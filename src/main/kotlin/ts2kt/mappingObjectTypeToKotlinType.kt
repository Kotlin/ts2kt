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
import typescriptServices.ts.identifierName
import typescriptServices.ts.*

interface ObjectTypeToKotlinTypeMapper {
    fun getKotlinTypeForObjectType(objectType: TypeLiteralNode): KtType
    fun withTypeParameters(typeParameters: NodeArray<TypeParameterDeclaration>?): ObjectTypeToKotlinTypeMapper
    val currentPackage: String
    val enclosingDeclaration: Node?
    val typeChecker: TypeChecker
    // TODO: support recursive type aliases, see recursiveType.d.ts
    val typesInMappingProcess: MutableSet<Type>
}

data class ObjectTypeToKotlinTypeMapperImpl(
        override val typeChecker: TypeChecker,
        val defaultAnnotations: List<KtAnnotation>,
        val declarations: MutableList<KtMember>,
        override val currentPackage: String,
        override val enclosingDeclaration: Node? = null,
        val typeParameterDeclarations: List<TypeParameterDeclaration> = listOf(),
        val cache: MutableMap<String, KtType> = hashMapOf()
) : ObjectTypeToKotlinTypeMapper {
    override val typesInMappingProcess: MutableSet<Type> = mutableSetOf()

    companion object {
        private var n = 0

        fun reset() {
            n = 0
        }

        val jsonTypeKey = """
                @nativeGetter
                operator fun get(String): Any?
                @nativeSetter
                operator fun set(String, Any)

                """.trimIndent()
    }

    init {
        // TODO better declaration for known classes
        cache[""] = KtType(KtQualifiedName("Any"))
        cache[jsonTypeKey] = KtType(KtQualifiedName("Json"))
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
                    listOf(it.type.type.qualifiedName)
                is KtFunction ->
                    it.callSignature.params.map { it.type.type.qualifiedName } + it.callSignature.returnType.type.qualifiedName
                else ->
                    emptyList()
            }
        }.distinct()
        val typeParamNames = typeParameterDeclarations.filter { usedTypeParams.contains(KtQualifiedName(it.identifierName.text)) }
                .map { it.identifierName.text }

        val traitName = "T$${n++}"
        val traitType = KtType(KtQualifiedName(traitName), typeParamNames.map { SingleKtType(KtType(KtQualifiedName(it))) })
        translator.name = traitName
        translator.typeParams = typeParamNames.map { KtTypeParam(KtName(it)) }

        declarations.add(translator.createClassifier())

        cache[typeKey] = traitType
        return traitType
    }

    override fun withTypeParameters(typeParameters: NodeArray<TypeParameterDeclaration>?): ObjectTypeToKotlinTypeMapper {
        return copy(typeParameterDeclarations = typeParameterDeclarations.toList() + (typeParameters?.arr ?: arrayOf()))
    }
}
