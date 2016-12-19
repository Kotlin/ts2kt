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
import ts2kt.utils.replaceAll
import typescript.TS
import typescript.identifierName

interface ObjectTypeToKotlinTypeMapper {
    fun getKotlinTypeForObjectType(objectType: TS.TypeLiteralNode): Type
    fun resolveUsingAliases(referencedType: Type): TypeUnion
    fun withTypeParameters(typeParameters: TS.NodeArray<TS.TypeParameterDeclaration>?): ObjectTypeToKotlinTypeMapper
}

data class ObjectTypeToKotlinTypeMapperImpl(
        val defaultAnnotations: List<Annotation>,
        val declarations: MutableList<Member>,
        val typeAliases: List<TypeAlias>,
        val typeParameterDeclarations: List<TS.TypeParameterDeclaration> = listOf()
) : ObjectTypeToKotlinTypeMapper {

    companion object {
        private var n = 0

        fun reset() {
            n = 0
        }
    }

    val cache = HashMap<String, Type>()

    init {
        // TODO better declaration for known classes
        cache[""] = Type("Any")

        val jsonTypeKey = "@nativeGetter\nfun get(String): Any?, @nativeSetter\nfun set(String, Any)"
        cache[jsonTypeKey] = Type("Json")
    }

    override fun getKotlinTypeForObjectType(objectType: TS.TypeLiteralNode): Type {
        val translator = TsInterfaceToKt(annotations = defaultAnnotations, typeMapper = this, isOverride = NOT_OVERRIDE, isOverrideProperty = NOT_OVERRIDE)

        forEachChild(translator, objectType)

        val typeKey = translator.declarations.toStringKey()

        val cachedTraitType = cache[typeKey]
        if (cachedTraitType != null) return cachedTraitType

        val usedTypeParams = translator.declarations.flatMap {
            when (it) {
                is Variable ->
                    listOf(it.type.type.name)
                is Function ->
                    it.callSignature.params.map { it.type.type.name } + it.callSignature.returnType.type.name
                else ->
                    emptyList()
            }
        }.distinct()
        val typeParams = typeParameterDeclarations.filter { usedTypeParams.contains(it.identifierName.text) }
                .map { TypeParam(it.identifierName.text) }

        val traitName = "T$${n++}"
        val traitType = Type(traitName, typeParams.map { Type(it.name) })
        translator.name = traitName
        translator.typeParams = typeParams

        declarations.add(translator.result)

        cache[typeKey] = traitType
        return traitType
    }

    override fun resolveUsingAliases(referencedType: Type): TypeUnion {
        val matchingTypeAlias = typeAliases.find { it.name == referencedType.name }
        if (matchingTypeAlias != null) {
            val resolvedTypeUnion = replaceTypeParamsWithTypeArgs(referencedType, matchingTypeAlias, typeAliases)
            return resolvedTypeUnion.flatMap { if (referencedType.name != it.name) resolveUsingAliases(it) else TypeUnion(it) }
        } else if (referencedType.typeArgs.isNotEmpty()) {
            return TypeUnion(referencedType.copy(typeArgs = referencedType.typeArgs.map { resolveUsingAliases(it).singleType }))
        } else {
            return TypeUnion(referencedType)
        }
    }

    private fun replaceTypeParamsWithTypeArgs(fromType: Type, matchingTypeAlias: TypeAlias, replacements: List<TypeAlias>): TypeUnion {
        val toTypeWithUnresolvedArgs = matchingTypeAlias.actualTypeUnionUsingAliasParams
        val boundTypeAliases: List<TypeAlias> = getReplacementsForTypeParams(fromType, matchingTypeAlias)
        return toTypeWithUnresolvedArgs.map { resolveTypeArgs(it, replacements + boundTypeAliases) }
    }

    private fun TypeUnion.flatMap(function: (Type) -> TypeUnion): TypeUnion = TypeUnion(possibleTypes.flatMap { function(it).possibleTypes })

    private fun TypeUnion.map(function: (Type) -> Type): TypeUnion = TypeUnion(possibleTypes.map(function))

    private fun resolveTypeArgs(type: Type, replacements: List<TypeAlias>): Type {
        if (type.typeArgs.isNotEmpty()) {
            val aliasMapper = copy(typeAliases = replacements)
            return type.copy(typeArgs = type.typeArgs.map { aliasMapper.resolveUsingAliases(it).singleType })
        } else {
            return type
        }
    }

    private fun getReplacementsForTypeParams(fromType: Type, matchingTypeAlias: TypeAlias): List<TypeAlias> {
        return matchingTypeAlias.typeParams?.zip(fromType.typeArgs)?.map {
            TypeAlias(it.first.name, actualTypeUsingAliasParams = it.second)
        } ?: emptyList()
    }

    override fun withTypeParameters(typeParameters: TS.NodeArray<TS.TypeParameterDeclaration>?): ObjectTypeToKotlinTypeMapper {
        return copy(typeParameterDeclarations = typeParameterDeclarations.toList() + (typeParameters?.arr ?: arrayOf()))
    }

    fun <T> List<T>.toStringKey(): String =
            map { it.toString().replaceAll("(\\(|,\\s*)\\w+: ", "$1") }.sorted().joinToString(", ")
}
