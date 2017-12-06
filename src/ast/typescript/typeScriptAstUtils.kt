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

import converter.mapType
import converter.mapTypeToUnion
import ts2kt.kotlin.ast.*
import ts2kt.utils.*
import typescript.ClassOrInterfaceDeclaration
import typescript.EntityName
import typescript.declarationName
import typescript.identifierName
import typescriptServices.ts.*

val ANY = "Any"
val NOTHING = "Nothing"
val NUMBER = "Number"
val STRING = "String"
val BOOLEAN = "Boolean"
val UNIT = "Unit"
val DYNAMIC = "dynamic"
val ARRAY = "Array"

val NOTHING_TYPE = KtType(NOTHING, isNullable = true)

val SHOULD_BE_ESCAPED =
        setOf("as", "break", "class", "continue", "do", "else", "false", "for", "fun", "if",
              "in", "interface", "is", "null", "object", "package", "return", "super", "this", "This", "throw",
              "true", "try", "typealias", "typeof", "val", "var", "when", "while")

val NOT_OVERRIDE: (Node) -> Boolean = { false }

private const val OVERLOAD_GEN_THRESHOLD_FOR_TYPE_COUNT_ON_ONE_PARAMETER = 10
private const val OVERLOAD_GEN_THRESHOLD_FOR_TOTAL_COUNT = 10

fun String.escapeIfNeed(): String {
    return if (this in SHOULD_BE_ESCAPED || this.contains("$")) {
        "`$this`"
    }
    else {
        this
    }
}

val ParameterDeclaration.isVararg: Boolean get() = dotDotDotToken != null

fun ParameterDeclaration.toKotlinParam(typeMapper: ObjectTypeToKotlinTypeMapper): KtFunParam {
    val nodeType: TypeNode? = getNodeTypeConsideringVararg()
    return toKotlinParam(nodeType, nodeType?.let { typeMapper.mapType(it) } ?: KtType(ANY))
}

fun ParameterDeclaration.toKotlinParamOverloads(typeMapper: ObjectTypeToKotlinTypeMapper): List<KtFunParam> {
    val nodeType: TypeNode? = getNodeTypeConsideringVararg()
    val unionType = nodeType?.let { typeMapper.mapTypeToUnion(it) } ?: KtTypeUnion(KtType(ANY))

    if (unionType.possibleTypes.size > OVERLOAD_GEN_THRESHOLD_FOR_TYPE_COUNT_ON_ONE_PARAMETER) {
        return listOf(toKotlinParam(KtType(DYNAMIC, comment = unionType.stringify())))
    }

    return unionType.possibleTypes.map { type ->
        toKotlinParam(nodeType, type)
    }
}

private fun ParameterDeclaration.toKotlinParam(nodeType: TypeNode?, typeWithoutFlags: KtType): KtFunParam =
        toKotlinParam(typeWithoutFlags.copy(isNullable = questionToken != null || typeWithoutFlags.isNullable))

private fun ParameterDeclaration.toKotlinParam(type: KtType): KtFunParam {
    val name = declarationName!!.unescapedText
    val defaultValue = initializer?.let {
        when (it.kind as Any) {
        // TODO
            SyntaxKind.FirstLiteralToken -> (it.cast<LiteralExpression>()).text
            SyntaxKind.StringLiteral -> "\"" + (it.cast<LiteralExpression>()).text + "\""

            else -> reportUnsupportedNode(it)
        }
    }
    val isVar = NodeFlags.AccessibilityModifier in flags

    val isOptional = questionToken != null
    return KtFunParam(name,
            KtTypeAnnotation(type, isVararg = isVararg),
            if (defaultValue == null && isOptional) "null" else defaultValue,
            isVar)
}

private fun ParameterDeclaration.getNodeTypeConsideringVararg(): TypeNode? {
    val originalNodeType = type

    val nodeType: TypeNode?
    if (isVararg && originalNodeType != null) {
        val originalNodeKind = originalNodeType.kind

        @Suppress("UNCHECKED_CAST_TO_NATIVE_INTERFACE")
        when {
            originalNodeKind === SyntaxKind.ArrayType -> {
                nodeType = (originalNodeType.cast<ArrayTypeNode>()).elementType
            }

            originalNodeKind === SyntaxKind.TypeReference &&
                ((originalNodeType as TypeReferenceNode).typeName as EntityName).text == "Array" -> {
                val typeArguments = originalNodeType.cast<TypeReferenceNode>().typeArguments!!.arr
                assert(typeArguments.size == 1, "Array should have one generic paramater, but have ${typeArguments.size}.")
                nodeType = typeArguments[0]
            }
            else -> {
                report("Rest parameter must be array types, but ${originalNodeKind.str}")
                return null
            }
        }
    }
    else {
        nodeType = originalNodeType
    }
    return nodeType
}

fun NodeArray<ParameterDeclaration>.toKotlinParamsOverloads(typeMapper: ObjectTypeToKotlinTypeMapper): List<List<KtFunParam>> =
        toKotlinParamsOverloads(typeMapper, arr.size - 1)

private fun NodeArray<ParameterDeclaration>.toKotlinParamsOverloads(typeMapper: ObjectTypeToKotlinTypeMapper, arrIndex: Int): List<List<KtFunParam>> {
    if (arrIndex < 0) {
        return listOf(emptyList())
    }
    else {
        val overloadsOfPriorParams = toKotlinParamsOverloads(typeMapper, arrIndex - 1)
        val parameterDeclaration = arr[arrIndex]
        var paramOverloads = parameterDeclaration.toKotlinParamOverloads(typeMapper)

        if (overloadsOfPriorParams.size * paramOverloads.size > OVERLOAD_GEN_THRESHOLD_FOR_TOTAL_COUNT) {
            val comment = KtTypeUnion(paramOverloads.map { it.type.type }).stringify()
            paramOverloads = listOf(parameterDeclaration.toKotlinParam(KtType(DYNAMIC, comment = comment)))
        }

        return overloadsOfPriorParams.flatMap { priorParams ->
            paramOverloads.map { priorParams.plus(it) }
        }
    }
}

fun NodeArray<ParameterDeclaration>.toKotlinParams(typeMapper: ObjectTypeToKotlinTypeMapper): List<KtFunParam>  =
        arr.map { param -> param.toKotlinParam(typeMapper) }

fun NodeArray<TypeParameterDeclaration>.toKotlinTypeParams(typeMapper: ObjectTypeToKotlinTypeMapper): List<KtTypeParam> =
        arr.map { it.toKotlinTypeParam(typeMapper) }

fun TypeParameterDeclaration.toKotlinTypeParam(typeMapper: ObjectTypeToKotlinTypeMapper): KtTypeParam {
    val type = typeMapper.mapType(this)
    val upperBound = constraint?.let { typeMapper.mapType(it) }
    return KtTypeParam(type.name, upperBound)
}

fun SignatureDeclaration.toKotlinCallSignatureOverloads(typeMapper: ObjectTypeToKotlinTypeMapper): List<KtCallSignature> {
    val newTypeMapper = typeMapper.withTypeParameters(typeParameters)
    val paramsOverloads = parameters.toKotlinParamsOverloads(newTypeMapper)
    return paramsOverloads.map { toKotlinCallSignature(newTypeMapper, it) }
}

fun SignatureDeclaration.toKotlinCallSignature(typeMapper: ObjectTypeToKotlinTypeMapper): KtCallSignature {
    val newTypeMapper = typeMapper.withTypeParameters(typeParameters)
    val params = parameters.toKotlinParams(newTypeMapper)
    return toKotlinCallSignature(newTypeMapper, params)
}

fun SignatureDeclaration.toKotlinCallSignature(typeMapper: ObjectTypeToKotlinTypeMapper, params: List<KtFunParam>): KtCallSignature {
    val typeParams = typeParameters?.toKotlinTypeParams(typeMapper)
    val returnType = type?.let { typeMapper.mapType(it) } ?: KtType(UNIT)

    return KtCallSignature(params, typeParams, KtTypeAnnotation(returnType))
}

fun ArrayTypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    val typeArg = typeMapper.mapType(elementType)
    return KtType(ARRAY, listOf(typeArg))
}

//TODO: do we need LambdaType???
fun FunctionOrConstructorTypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    val params = parameters.toKotlinParams(typeMapper)
    val returnType = type?.let { typeMapper.mapType(it) } ?: KtType(ANY)
    return createFunctionType(params, returnType)
}

//TODO: do we need LambdaType???
private fun FunctionOrConstructorTypeNode.toKotlinTypeUnion(typeMapper: ObjectTypeToKotlinTypeMapper): KtTypeUnion {
    return KtTypeUnion(parameters.toKotlinParamsOverloads(typeMapper).map {
        createFunctionType(it, type?.let { typeMapper.mapType(it) } ?: KtType(ANY))
    })
}

// TODO implement
private fun TypeLiteralNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType =
        typeMapper.getKotlinTypeForObjectType(this)

fun TypeNode.toKotlinTypeUnion(typeMapper: ObjectTypeToKotlinTypeMapper): KtTypeUnion {
    return when (this.kind as Any) {
        SyntaxKind.ConstructorType,
        SyntaxKind.FunctionType -> (this.cast<FunctionOrConstructorTypeNode>()).toKotlinTypeUnion(typeMapper)

        SyntaxKind.TypeReference -> (this.cast<TypeReferenceNode>()).toKotlinTypeUnion(typeMapper)
        SyntaxKind.UnionType -> (this.cast<UnionTypeNode>()).toKotlinTypeUnion(typeMapper)
        SyntaxKind.IntersectionType -> (this.cast<IntersectionTypeNode>()).toKotlinTypeUnion(typeMapper)
        else -> KtTypeUnion(toKotlinType(typeMapper))
    }
}

// TODO
fun TypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    return when (this.kind as Any) {
        SyntaxKind.AnyKeyword -> KtType(ANY)
        SyntaxKind.NumberKeyword -> KtType(NUMBER)
        SyntaxKind.StringKeyword -> KtType(STRING)
        SyntaxKind.BooleanKeyword -> KtType(BOOLEAN)
        SyntaxKind.VoidKeyword -> KtType(UNIT)
        SyntaxKind.NullKeyword,
        SyntaxKind.UndefinedKeyword -> NOTHING_TYPE

        SyntaxKind.ArrayType -> (this.cast<ArrayTypeNode>()).toKotlinType(typeMapper)
        SyntaxKind.ConstructorType,
        SyntaxKind.FunctionType -> (this.cast<FunctionOrConstructorTypeNode>()).toKotlinType(typeMapper)

        SyntaxKind.TypeReference -> (this.cast<TypeReferenceNode>()).toKotlinTypeUnion(typeMapper).singleType
        SyntaxKind.ExpressionWithTypeArguments -> (this.cast<ExpressionWithTypeArguments>()).toKotlinType(typeMapper)

        SyntaxKind.Identifier -> KtType((this.cast<Identifier>()).unescapedText)
        SyntaxKind.TypeLiteral -> (this.cast<TypeLiteralNode>()).toKotlinType(typeMapper)

        SyntaxKind.UnionType -> (this.cast<UnionTypeNode>()).toKotlinTypeUnion(typeMapper).singleType

        SyntaxKind.IntersectionType -> (this.cast<IntersectionTypeNode>()).toKotlinTypeUnion(typeMapper).singleType

        SyntaxKind.ParenthesizedType -> (this.cast<ParenthesizedTypeNode>()).type.toKotlinType(typeMapper)

        // TODO how to support?
        // TODO fix after regenerate declarations
        SyntaxKind.LiteralType -> KtType(ANY, comment = "\"" + this.asDynamic().literal.text + "\"")

        SyntaxKind.ThisType -> (this.cast<ThisTypeNode>()).toKotlinType(typeMapper)

        SyntaxKind.TypePredicate -> (this.cast<TypePredicateNode>()).toKotlinType(typeMapper)

        else -> KtType(DYNAMIC, comment = reportUnsupportedNodeAndGetMessage(this))
    }
}

fun EntityName.toKotlinTypeName(): String {
    return when (kind as Any) {
        SyntaxKind.Identifier ->
            this.unescapedText
        else ->
            this.left.toKotlinTypeName() + "." + this.right.unescapedText
    }
}

fun TypeReferenceNode.toKotlinTypeUnion(typeMapper: ObjectTypeToKotlinTypeMapper): KtTypeUnion {
    return KtTypeUnion(toKotlinTypeIgnoringTypeAliases(typeMapper))
}

private fun TypeReferenceNode.toKotlinTypeIgnoringTypeAliases(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    // TODO improve
    val name = (typeName as EntityName).toKotlinTypeName()

    return when (name) {
        // TODO: HACKS
        "Function" -> KtType(name, listOf(KtType("*")))
        "Object" -> KtType(ANY)

        else -> KtType(name, typeArguments?.arr?.map { typeMapper.mapType(it) } ?: emptyList())
    }
}

fun ExpressionWithTypeArguments.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    val name = expression.stringifyQualifiedName()

    return KtType(name ?: "???", typeArguments?.arr?.map { typeMapper.mapType(it) } ?: emptyList())
}

private fun PropertyAccessExpression.stringify(): String {
    val identifier = identifierName.unescapedText

    val qualifier = expression?.stringifyQualifiedName() ?: return identifier

    return qualifier + "." + identifier
}

private fun Node.stringifyQualifiedName() = when (kind as Any) {
    SyntaxKind.Identifier ->
        (this.cast<Identifier>()).unescapedText

    SyntaxKind.PropertyAccessExpression ->
        (this.cast<PropertyAccessExpression>()).stringify()

    else -> reportUnsupportedNode(this)
}

fun UnionTypeNode.toKotlinTypeUnion(typeMapper: ObjectTypeToKotlinTypeMapper): KtTypeUnion {
    val possibleTypes = types.arr.flatMap { typeMapper.mapTypeToUnion(it).possibleTypes }.distinct()

    // TODO unify KtTypeUnion and KtType and implement it better
    if (possibleTypes.size == 2) {
        val a = possibleTypes[0]
        val b = possibleTypes[1]

        val t = if (a == NOTHING_TYPE) b else if (b == NOTHING_TYPE) a else null

        t?.let {
            return KtTypeUnion(listOf(it.copy(isNullable = true)))
        }
    }

    return KtTypeUnion(possibleTypes)
}

fun IntersectionTypeNode.toKotlinTypeUnion(typeMapper: ObjectTypeToKotlinTypeMapper): KtTypeUnion {
    val kotlinTypeUnions = types.arr.map { typeMapper.mapTypeToUnion(it) }
    val commentWithExpectedType = kotlinTypeUnions.join(" & ", stringify = KtTypeUnion::stringify)
    // just take the first one for now since Kotlin doesn't support intersection types.
    return kotlinTypeUnions[0].mapLast { it.copy(comment = commentWithExpectedType) }
}

private fun KtTypeUnion.mapLast(function: (KtType) -> KtType): KtTypeUnion = KtTypeUnion(possibleTypes.dropLast(1) + function(possibleTypes.last()))

fun ThisTypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    var parent = parent

    while(parent != null) {
        @Suppress("NON_EXHAUSTIVE_WHEN")
        when (parent.kind as Any) {
            SyntaxKind.ClassDeclaration,
            SyntaxKind.InterfaceDeclaration ->
                return parent.cast<ClassOrInterfaceDeclaration>().toKotlinType(typeMapper).copy(comment = "this")
            // TODO support
            SyntaxKind.TypeLiteral ->
                return KtType(ANY, comment = "this")
        }
        parent = parent.parent
    }

    return KtType(DYNAMIC, comment = report("ThisTypeNode.toKotlinType in illegal state"))
}

fun TypePredicateNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    return KtType(BOOLEAN)
}

fun ClassOrInterfaceDeclaration.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    val name = identifierName!!.unescapedText

    return KtType(name, typeParameters?.arr?.map { KtType(it.identifierName.unescapedText) } ?: emptyList())
}

fun forEachChild(visitor: Visitor, node: Node) {
    forEachChild(node, { node ->
        visitNode(visitor, node)
        undefined
    })
}

fun visitNode(visitor: Visitor, node: Node?): Unit {
    if (node == null) return

    when (node.kind as Any) {
        SyntaxKind.ModuleDeclaration -> visitor.visitModuleDeclaration(node.asDynamic())

        SyntaxKind.FunctionDeclaration    -> visitor.visitFunctionDeclaration(node.cast<FunctionDeclaration>())
        SyntaxKind.VariableStatement -> visitor.visitVariableStatement(node.cast<VariableStatement>())

        SyntaxKind.EnumDeclaration -> visitor.visitEnumDeclaration(node.cast<EnumDeclaration>())

        SyntaxKind.ClassDeclaration -> visitor.visitClassDeclaration(node.cast<ClassDeclaration>())
        SyntaxKind.InterfaceDeclaration -> visitor.visitInterfaceDeclaration(node.cast<InterfaceDeclaration>())
        SyntaxKind.TypeAliasDeclaration -> visitor.visitTypeAliasDeclaration(node.cast<TypeAliasDeclaration>())

        SyntaxKind.HeritageClause -> visitor.visitHeritageClause(node.cast<HeritageClause>())

        SyntaxKind.Constructor -> visitor.visitConstructorDeclaration(node.cast<ConstructorDeclaration>())
        SyntaxKind.ConstructSignature -> visitor.visitConstructSignatureDeclaration(node.cast<ConstructorDeclaration>())

        // TODO what is difference between MethodSignature and MethodDeclaration
        SyntaxKind.MethodDeclaration,
        SyntaxKind.MethodSignature -> visitor.visitMethodDeclaration(node.cast<MethodDeclaration>())

        // TODO what is difference between PropertySignature and PropertyDeclaration
        SyntaxKind.PropertyDeclaration,
        SyntaxKind.PropertySignature -> visitor.visitPropertyDeclaration(node.cast<PropertyDeclaration>())

        SyntaxKind.IndexSignature -> visitor.visitIndexSignature(node.cast<IndexSignatureDeclaration>())
        SyntaxKind.CallSignature -> visitor.visitSignatureDeclaration(node.cast<SignatureDeclaration>())

        SyntaxKind.ExportAssignment -> visitor.visitExportAssignment(node.cast<ExportAssignment>())
        SyntaxKind.ImportEqualsDeclaration -> visitor.visitImportEqualsDeclaration(node.cast())

        SyntaxKind.EndOfFileToken -> { /* ignore */ }
        else -> reportUnsupportedNode(node)
    }
}

inline val <T> NodeArray<T>.arr: Array<T>
    get() = this.unsafeCast<Array<T>>()

inline val SyntaxKind.str: String
    get() = SyntaxKind::class.js.asDynamic()[this].unsafeCast<String>()

inline val SyntaxKind.id: Int
    get() = this.unsafeCast<Int>()

// TODO review where we use raw text
inline val Identifier.unescapedText: String
    get() = unescapeIdentifier(text)

private fun LineAndCharacter.format(): String = "${line.toInt() + 1}:${character.toInt() + 1}"

fun Node.location(): String {
    val start = getSourceFile().getLineAndCharacterOfPosition(pos)
    val end = getSourceFile().getLineAndCharacterOfPosition(end)
    return "${getSourceFile().fileName}:${start.format()} to ${end.format()}"
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun <E : Enum<E>> E.contains(flag: E): Boolean = unsafeCast<Int>() and flag.unsafeCast<Int>() != 0
