/*
 * Copyright 2013-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ts2kt

import ts2kt.kotlin.ast.*
import typescript.identifierName
import typescriptServices.ts.NodeArray
import typescriptServices.ts.TypeLiteralNode
import typescriptServices.ts.TypeParameterDeclaration

interface ObjectTypeToKotlinTypeMapper {
    fun getKotlinTypeForObjectType(objectType: TypeLiteralNode): KtType
    fun resolveUsingAliases(referencedType: KtType): KtTypeUnion
    fun withTypeParameters(typeParameters: NodeArray<TypeParameterDeclaration>?): ObjectTypeToKotlinTypeMapper
}

data class ObjectTypeToKotlinTypeMapperImpl(
        val defaultAnnotations: List<KtAnnotation>,
        val declarations: MutableList<KtMember>,
        val typeAliases: List<KtTypeAlias>,
        val typeParameterDeclarations: List<TypeParameterDeclaration> = listOf()
) : ObjectTypeToKotlinTypeMapper {

    companion object {
        private var n = 0

        fun reset() {
            n = 0
        }
    }

    val cache = HashMap<String, KtType>()

    init {
        // TODO better declaration for known classes
        cache[""] = KtType("Any")

        val jsonTypeKey = """
                @nativeGetter
                operator fun get(String): Any?
                @nativeSetter
                operator fun set(String, Any)

                """.trimIndent()

        cache[jsonTypeKey] = KtType("Json")
    }

    override fun getKotlinTypeForObjectType(objectType: TypeLiteralNode): KtType {
        val translator = TsInterfaceToKt(annotations = defaultAnnotations, typeMapper = this, isOverride = NOT_OVERRIDE, isOverrideProperty = NOT_OVERRIDE)

        forEachChild(translator, objectType)

        val typeKey = translator.declarations.toStringKey()

        val cachedTraitType = cache[typeKey]
        if (cachedTraitType != null) return cachedTraitType

        val usedTypeParams = translator.declarations.flatMap {
            when (it) {
                is KtVariable ->
                    listOf(it.type.type.name)
                is KtFunction ->
                    it.callSignature.params.map { it.type.type.name } + it.callSignature.returnType.type.name
                else ->
                    emptyList()
            }
        }.distinct()
        val typeParams = typeParameterDeclarations.filter { usedTypeParams.contains(it.identifierName.text) }
                .map { KtTypeParam(it.identifierName.text) }

        val traitName = "T$${n++}"
        val traitType = KtType(traitName, typeParams.map { KtType(it.name) })
        translator.name = traitName
        translator.typeParams = typeParams

        declarations.add(translator.createClassifier())

        cache[typeKey] = traitType
        return traitType
    }

    override fun resolveUsingAliases(referencedType: KtType): KtTypeUnion {
        val matchingTypeAlias = typeAliases.find { it.name == referencedType.name }
        if (matchingTypeAlias != null) {
            val resolvedTypeUnion = replaceTypeParamsWithTypeArgs(referencedType, matchingTypeAlias, typeAliases)
            return resolvedTypeUnion.flatMap { if (referencedType.name != it.name) resolveUsingAliases(it) else KtTypeUnion(it) }
        } else if (referencedType.typeArgs.isNotEmpty()) {
            return KtTypeUnion(referencedType.copy(typeArgs = referencedType.typeArgs.map { resolveUsingAliases(it).singleType }))
        } else {
            return KtTypeUnion(referencedType)
        }
    }

    private fun replaceTypeParamsWithTypeArgs(fromType: KtType, matchingTypeAlias: KtTypeAlias, replacements: List<KtTypeAlias>): KtTypeUnion {
        val toTypeWithUnresolvedArgs = matchingTypeAlias.actualTypeUnionUsingAliasParams
        val boundTypeAliases: List<KtTypeAlias> = getReplacementsForTypeParams(fromType, matchingTypeAlias)
        return toTypeWithUnresolvedArgs.map { resolveTypeArgs(it, replacements + boundTypeAliases) }
    }

    private fun KtTypeUnion.flatMap(function: (KtType) -> KtTypeUnion): KtTypeUnion = KtTypeUnion(possibleTypes.flatMap { function(it).possibleTypes })

    private fun KtTypeUnion.map(function: (KtType) -> KtType): KtTypeUnion = KtTypeUnion(possibleTypes.map(function))

    private fun resolveTypeArgs(type: KtType, replacements: List<KtTypeAlias>): KtType {
        if (type.typeArgs.isNotEmpty()) {
            val aliasMapper = copy(typeAliases = replacements)
            return type.copy(typeArgs = type.typeArgs.map { aliasMapper.resolveUsingAliases(it).singleType })
        } else {
            return type
        }
    }

    private fun getReplacementsForTypeParams(fromType: KtType, matchingTypeAlias: KtTypeAlias): List<KtTypeAlias> {
        return matchingTypeAlias.typeParams?.zip(fromType.typeArgs)?.map {
            KtTypeAlias(it.first.name, actualTypeUsingAliasParams = it.second)
        } ?: emptyList()
    }

    override fun withTypeParameters(typeParameters: NodeArray<TypeParameterDeclaration>?): ObjectTypeToKotlinTypeMapper {
        return copy(typeParameterDeclarations = typeParameterDeclarations.toList() + (typeParameters?.arr ?: arrayOf()))
    }

    fun List<KtNode>.toStringKey(): String =
            map { it.stringify().replace("(\\(|,\\s*)\\w+: ".toRegex(), "$1") }.sorted().joinToString("")
}
