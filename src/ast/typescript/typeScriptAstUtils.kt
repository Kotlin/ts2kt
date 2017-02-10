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
import ts2kt.utils.assert
import ts2kt.utils.cast
import ts2kt.utils.hasFlag
import ts2kt.utils.join
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
    return toKotlinParam(nodeType, nodeType?.toKotlinType(typeMapper) ?: KtType(ANY))
}

fun ParameterDeclaration.toKotlinParamOverloads(typeMapper: ObjectTypeToKotlinTypeMapper): List<KtFunParam> {
    val nodeType: TypeNode? = getNodeTypeConsideringVararg()
    return (nodeType?.toKotlinTypeUnion(typeMapper) ?: KtTypeUnion(KtType(ANY))).possibleTypes.map { type ->
        toKotlinParam(nodeType, type)
    }
}

private fun ParameterDeclaration.toKotlinParam(nodeType: TypeNode?, typeWithoutFlags: KtType): KtFunParam {
    val isNullable = questionToken != null || typeWithoutFlags.isNullable
    val isLambda = nodeType?.kind === SyntaxKind.FunctionType
    return toKotlinParam(typeWithoutFlags.copy(isNullable = isNullable, isLambda = isLambda))
}

private fun ParameterDeclaration.toKotlinParam(type: KtType): KtFunParam {
    val name = declarationName!!.unescapedText
    val defaultValue = initializer?.let {
        when (it.kind) {
        // TODO
            SyntaxKind.FirstLiteralToken -> (it.cast<LiteralExpression>()).text
            SyntaxKind.StringLiteral -> "\"" + (it.cast<LiteralExpression>()).text + "\""

            else -> unsupportedNode(it)
        }
    }
    val isVar = hasFlag(flags, NodeFlags.AccessibilityModifier)

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

        when {
            originalNodeKind === SyntaxKind.ArrayType -> {
                nodeType = (originalNodeType.cast<ArrayTypeNode>()).elementType
            }

            originalNodeKind === SyntaxKind.TypeReference &&
                ((originalNodeType.cast<TypeReferenceNode>()).typeName as EntityName).text == "Array" -> {
                val typeArguments = originalNodeType.cast<TypeReferenceNode>().typeArguments!!.arr
                assert(typeArguments.size == 1, "Array should have one generic paramater, but have ${typeArguments.size}.")
                nodeType = typeArguments[0]
            }
            else -> {
                throw IllegalStateException("Rest parameter must be array types, but ${originalNodeKind.str}")
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
        val paramOverloads = arr[arrIndex].toKotlinParamOverloads(typeMapper)
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
    val type = identifierName.cast<TypeNode>().toKotlinType(typeMapper)
    val upperBound = constraint?.toKotlinType(typeMapper)
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
    val returnType = type?.toKotlinType(typeMapper) ?: KtType(UNIT)

    return KtCallSignature(params, typeParams, KtTypeAnnotation(returnType))
}


fun ArrayTypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    val typeArg = elementType.toKotlinType(typeMapper)
    return KtType(ARRAY, listOf(typeArg))
}

//TODO: do we need LambdaType???
private fun FunctionOrConstructorTypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    val params = parameters.toKotlinParams(typeMapper)
    return KtType("${params.join(", ", start = "(", end = ")", stringify = KtFunParam::stringify)} -> ${(type?.toKotlinType(typeMapper) ?: KtType(ANY)).stringify() }")
}

//TODO: do we need LambdaType???
private fun FunctionOrConstructorTypeNode.toKotlinTypeUnion(typeMapper: ObjectTypeToKotlinTypeMapper): KtTypeUnion {
    return KtTypeUnion(parameters.toKotlinParamsOverloads(typeMapper).map { params ->
        KtType("${params.join(", ", start = "(", end = ")", stringify = KtFunParam::stringify)} -> ${(type?.toKotlinType(typeMapper) ?: KtType(ANY)).stringify() }")
    })
}

// TODO implement
private fun TypeLiteralNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType =
        typeMapper.getKotlinTypeForObjectType(this)

fun TypeNode.toKotlinTypeUnion(typeMapper: ObjectTypeToKotlinTypeMapper): KtTypeUnion {
    return when (this.kind) {
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
    return when (this.kind) {
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

        else -> unsupportedNode(this)
    }
}

fun EntityName.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    return when (kind) {
        SyntaxKind.Identifier ->
            this.unescapedText
        else ->
            this.left.toKotlinTypeName(typeMapper) + "." + this.right.unescapedText
    }
}

fun TypeReferenceNode.toKotlinTypeUnion(typeMapper: ObjectTypeToKotlinTypeMapper): KtTypeUnion {
    return typeMapper.resolveUsingAliases(toKotlinTypeIgnoringTypeAliases(typeMapper))
}

private fun TypeReferenceNode.toKotlinTypeIgnoringTypeAliases(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    // TODO improve
    val name = (typeName as EntityName).toKotlinTypeName(typeMapper)

    return KtType(name, typeArguments?.arr?.map { it.toKotlinType(typeMapper) } ?: emptyList())
}

fun ExpressionWithTypeArguments.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    val name = expression.stringifyQualifiedName()

    return KtType(name, typeArguments?.arr?.map { it.toKotlinType(typeMapper) } ?: emptyList())
}

private fun PropertyAccessExpression.stringify(): String {
    val identifier = identifierName.unescapedText

    val qualifier = expression?.stringifyQualifiedName() ?: return identifier

    return qualifier + "." + identifier
}

private fun Node.stringifyQualifiedName() = when (kind) {
    SyntaxKind.Identifier ->
        (this.cast<Identifier>()).unescapedText

    SyntaxKind.PropertyAccessExpression ->
        (this.cast<PropertyAccessExpression>()).stringify()

    else -> unsupportedNode(this)
}

fun UnionTypeNode.toKotlinTypeUnion(typeMapper: ObjectTypeToKotlinTypeMapper): KtTypeUnion {
    val possibleTypes = types.arr.flatMap { it.toKotlinTypeUnion(typeMapper).possibleTypes }.distinct()

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
    val kotlinTypeUnions = types.arr.map { it.toKotlinTypeUnion(typeMapper) }
    val commentWithExpectedType = kotlinTypeUnions.join(" & ", stringify = KtTypeUnion::stringify)
    // just take the first one for now since Kotlin doesn't support intersection types.
    return kotlinTypeUnions[0].mapLast { it.copy(comment = commentWithExpectedType) }
}

private fun KtTypeUnion.mapLast(function: (KtType) -> KtType): KtTypeUnion = KtTypeUnion(possibleTypes.dropLast(1) + function(possibleTypes.last()))

fun ThisTypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): KtType {
    var parent = parent

    while(parent != null) {
        @Suppress("NON_EXHAUSTIVE_WHEN")
        when (parent.kind) {
            SyntaxKind.ClassDeclaration,
            SyntaxKind.InterfaceDeclaration ->
                return parent.cast<ClassOrInterfaceDeclaration>().toKotlinType(typeMapper).copy(comment = "this")
            // TODO support
            SyntaxKind.TypeLiteral ->
                return KtType(ANY, comment = "this")
        }
        parent = parent.parent
    }

    throw IllegalStateException("Illegal State")
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
    })
}

fun visitNode(visitor: Visitor, node: Node?): Unit {
    if (node == null) return

    when (node.kind) {
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
        SyntaxKind.ImportEqualsDeclaration ->  { /* TODO implement */ }

        SyntaxKind.EndOfFileToken -> { /* ignore */ }
        else -> {
            val message = "Unsupported node.kind: ${node.kind}, name: ${node.kind.str} (${node.location()})"
            if (reportedKinds.add(node.kind.id)) console.error(message)
            unsupportedNode(node)
        }
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

private fun Node.location(): String {
    val start = getSourceFile().getLineAndCharacterOfPosition(pos)
    val end = getSourceFile().getLineAndCharacterOfPosition(end)
    return "${getSourceFile().fileName}:${start.format()} to ${end.format()}"
}

fun unsupportedNode(node: Node): Nothing {
    val message = "${node.kind.str} kind (${node.location()}) unsupported yet here! See node in attachment."
    val exception = Exception(message)
    exception.asDynamic().attachment = node
    throw exception
}
