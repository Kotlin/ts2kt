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

import js.JsError
import ts2kt.kotlin.ast.*
import ts2kt.utils.assert
import ts2kt.utils.cast
import ts2kt.utils.hasFlag
import ts2kt.utils.join
import typescript.ClassOrInterfaceDeclaration
import typescript.TS
import typescript.unescapeIdentifier

val ANY = "Any"
val NUMBER = "Number"
val STRING = "String"
val BOOLEAN = "Boolean"
val UNIT = "Unit"
val DYNAMIC = "dynamic"
val ARRAY = "Array"

val SHOULD_BE_ESCAPED =
        setOf("as", "break", "class", "continue", "do", "else", "false", "for", "fun", "if",
              "in", "is", "null", "object", "package", "return", "super", "this", "This", "throw",
              "trait", "true", "try", "typealias", "typeof", "val", "var", "when", "while")

val NOT_OVERRIDE: (TS.Node) -> Boolean = { false }

fun String.escapeIfNeed(): String {
    return if (this in SHOULD_BE_ESCAPED || this.contains("$")) {
        "`$this`"
    }
    else {
        this
    }
}

val TS.ParameterDeclaration.isVararg: Boolean get() = dotDotDotToken != null

fun TS.ParameterDeclaration.toKotlinParam(typeMapper: ObjectTypeToKotlinTypeMapper): FunParam {
    val nodeType: TS.TypeNode? = getNodeTypeConsideringVararg()
    val typeName = nodeType?.toKotlinType(typeMapper) ?: Type(ANY)
    return toKotlinParam(nodeType, typeName)
}

fun TS.ParameterDeclaration.toKotlinParamOverloads(typeMapper: ObjectTypeToKotlinTypeMapper): List<FunParam> {
    val nodeType: TS.TypeNode? = getNodeTypeConsideringVararg()
    return (nodeType?.toKotlinTypeOverloads(typeMapper) ?: listOf(Type(ANY))).map { type ->
        toKotlinParam(nodeType, type)
    }
}

private fun TS.ParameterDeclaration.toKotlinParam(nodeType: TS.TypeNode?, type: Type): FunParam {
    val isLambda = nodeType?.kind === TS.SyntaxKind.FunctionType
    val name = declarationName!!.unescapedText
    val defaultValue = initializer?.let {
        when (it.kind) {
        // TODO
            TS.SyntaxKind.FirstLiteralToken -> (it.cast<TS.LiteralExpression>()).text
            TS.SyntaxKind.StringLiteral -> "\"" + (it.cast<TS.LiteralExpression>()).text + "\""

            else -> unsupportedNode(it)
        }
    }
    val isNullable = questionToken != null
    val isVar = hasFlag(flags, TS.NodeFlags.AccessibilityModifier)

    return FunParam(name,
            TypeAnnotation(type.copy(isNullable = isNullable, isLambda = isLambda), isVararg = isVararg),
            if (defaultValue == null && isNullable) "null" else defaultValue,
            isVar)
}

private fun TS.ParameterDeclaration.getNodeTypeConsideringVararg(): TS.TypeNode? {
    val originalNodeType = type

    val nodeType: TS.TypeNode?
    if (isVararg && originalNodeType != null) {
        val originalNodeKind = originalNodeType.kind

        when {
            originalNodeKind === TS.SyntaxKind.ArrayType -> {
                nodeType = (originalNodeType.cast<TS.ArrayTypeNode>()).elementType
            }

            originalNodeKind === TS.SyntaxKind.TypeReference &&
            (originalNodeType.cast<TS.TypeReferenceNode>()).typeName.text == "Array" -> {
                val typeArguments = originalNodeType.cast<TS.TypeReferenceNode>().typeArguments!!.arr
                assert(typeArguments.size == 1, "Array should have one generic paramater, but have ${typeArguments.size}.")
                nodeType = typeArguments[0]
            }
            else -> {
                throw JsError("Rest parameter must be array types, but ${originalNodeKind.str}")
            }
        }
    }
    else {
        nodeType = originalNodeType
    }
    return nodeType
}

fun TS.NodeArray<TS.ParameterDeclaration>.toKotlinParamsOverloads(typeMapper: ObjectTypeToKotlinTypeMapper): List<List<FunParam>> =
        toKotlinParamsOverloads(typeMapper, arr.size - 1)

private fun TS.NodeArray<TS.ParameterDeclaration>.toKotlinParamsOverloads(typeMapper: ObjectTypeToKotlinTypeMapper, arrIndex: Int): List<List<FunParam>> {
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

fun TS.NodeArray<TS.ParameterDeclaration>.toKotlinParams(typeMapper: ObjectTypeToKotlinTypeMapper): List<FunParam>  =
        arr.map { param -> param.toKotlinParam(typeMapper) }

fun TS.NodeArray<TS.TypeParameterDeclaration>.toKotlinTypeParams(typeMapper: ObjectTypeToKotlinTypeMapper): List<TypeParam>  =
        arr.map { typeParam ->
            val type = (typeParam.identifierName.cast<TS.TypeNode>()).toKotlinType(typeMapper)
            val upperBound = typeParam.constraint?.toKotlinType(typeMapper)
            TypeParam(type.name, upperBound)
        }

fun TS.SignatureDeclaration.toKotlinCallSignatureOverloads(typeMapper: ObjectTypeToKotlinTypeMapper): List<CallSignature> {
    val newTypeMapper = typeMapper.withTypeParameters(typeParameters)
    val paramsOverloads = parameters.toKotlinParamsOverloads(newTypeMapper)
    return paramsOverloads.map { toKotlinCallSignature(newTypeMapper, it) }
}

fun TS.SignatureDeclaration.toKotlinCallSignature(typeMapper: ObjectTypeToKotlinTypeMapper): CallSignature {
    val newTypeMapper = typeMapper.withTypeParameters(typeParameters)
    val params = parameters.toKotlinParams(newTypeMapper)
    return toKotlinCallSignature(newTypeMapper, params)
}

fun TS.SignatureDeclaration.toKotlinCallSignature(typeMapper: ObjectTypeToKotlinTypeMapper, params: List<FunParam>): CallSignature {
    val typeParams = typeParameters?.toKotlinTypeParams(typeMapper)
    val returnType = type?.toKotlinType(typeMapper) ?: Type(UNIT)

    return CallSignature(params, typeParams, TypeAnnotation(returnType))
}


fun TS.ArrayTypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): Type {
    val typeArg = elementType.toKotlinType(typeMapper)
    return Type(ARRAY, listOf(typeArg))
}

//TODO: do we need LambdaType???
private fun TS.FunctionOrConstructorTypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): Type {
    val params = parameters.toKotlinParams(typeMapper)
    return Type("${params.join(", ", start = "(", end = ")")} -> ${(type?.toKotlinType(typeMapper) ?: Type(ANY)).stringify() }")
}

//TODO: do we need LambdaType???
private fun TS.FunctionOrConstructorTypeNode.toKotlinTypeOverloads(typeMapper: ObjectTypeToKotlinTypeMapper): List<Type> {
    return parameters.toKotlinParamsOverloads(typeMapper).map { params ->
        Type("${params.join(", ", start = "(", end = ")")} -> ${(type?.toKotlinType(typeMapper) ?: Type(ANY)).stringify() }")
    }
}

// TODO implement
private fun TS.TypeLiteralNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): Type =
        typeMapper.getKotlinTypeForObjectType(this)

private fun TS.TypeNode.toKotlinTypeOverloadsIfStandardType(typeMapper: ObjectTypeToKotlinTypeMapper): List<Type> {
    return when (this.kind) {
        TS.SyntaxKind.ConstructorType,
        TS.SyntaxKind.FunctionType -> (this.cast<TS.FunctionOrConstructorTypeNode>()).toKotlinTypeOverloads(typeMapper)

        TS.SyntaxKind.TypeReference -> (this.cast<TS.TypeReferenceNode>()).toKotlinTypeNameOverloads(typeMapper)
        TS.SyntaxKind.UnionType -> (this.cast<TS.UnionTypeNode>()).toKotlinTypeOverloads(typeMapper)
        else -> listOf(toKotlinTypeIfStandardType(typeMapper))
    }
}

private fun TS.TypeNode.toKotlinTypeIfStandardType(typeMapper: ObjectTypeToKotlinTypeMapper): Type {
    return when (this.kind) {
        TS.SyntaxKind.AnyKeyword -> Type(ANY)
        TS.SyntaxKind.NumberKeyword -> Type(NUMBER)
        TS.SyntaxKind.StringKeyword -> Type(STRING)
        TS.SyntaxKind.BooleanKeyword -> Type(BOOLEAN)
        TS.SyntaxKind.VoidKeyword -> Type(UNIT)
        TS.SyntaxKind.ArrayType -> (this.cast<TS.ArrayTypeNode>()).toKotlinType(typeMapper)
        TS.SyntaxKind.ConstructorType,
        TS.SyntaxKind.FunctionType -> (this.cast<TS.FunctionOrConstructorTypeNode>()).toKotlinType(typeMapper)

        TS.SyntaxKind.TypeReference -> (this.cast<TS.TypeReferenceNode>()).toKotlinType(typeMapper)
        TS.SyntaxKind.ExpressionWithTypeArguments -> (this.cast<TS.ExpressionWithTypeArguments>()).toKotlinType(typeMapper)

        TS.SyntaxKind.Identifier -> Type((this.cast<TS.Identifier>()).unescapedText)
        TS.SyntaxKind.TypeLiteral -> (this.cast<TS.TypeLiteralNode>()).toKotlinType(typeMapper)

        TS.SyntaxKind.UnionType -> (this.cast<TS.UnionTypeNode>()).toKotlinType(typeMapper)

        TS.SyntaxKind.IntersectionType -> (this.cast<TS.IntersectionTypeNode>()).toKotlinType(typeMapper)

        TS.SyntaxKind.ParenthesizedType -> (this.cast<TS.ParenthesizedTypeNode>()).type.toKotlinType(typeMapper)

        // TODO how to support?
        TS.SyntaxKind.StringLiteralType -> Type(ANY, comment = "\"" + (this.cast<TS.StringLiteralType>()).text + "\"")

        TS.SyntaxKind.ThisType -> (this.cast<TS.ThisTypeNode>()).toKotlinType(typeMapper)

        TS.SyntaxKind.TypePredicate -> (this.cast<TS.TypePredicateNode>()).toKotlinType(typeMapper)

        else -> unsupportedNode(this)
    }
}

// TODO
fun TS.TypeNode.toKotlinTypeOverloads(typeMapper: ObjectTypeToKotlinTypeMapper): List<Type> {
    return this.toKotlinTypeOverloadsIfStandardType(typeMapper)
}

// TODO
fun TS.TypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): Type {
    return this.toKotlinTypeIfStandardType(typeMapper)
}

fun TS.EntityName.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    return when (kind) {
        TS.SyntaxKind.Identifier ->
            this.unescapedText
        else ->
            this.left.toKotlinTypeName(typeMapper) + "." + this.right.unescapedText
    }
}

fun TS.TypeReferenceNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): Type {
    val typeNameUsingAlias = typeMapper.getKotlinTypeForTypeAlias(typeName.text)?.toKotlinType(typeMapper)
    if (typeNameUsingAlias != null) return typeNameUsingAlias
    return toKotlinTypeIgnoringTypeAliases(typeMapper)
}

fun TS.TypeReferenceNode.toKotlinTypeNameOverloads(typeMapper: ObjectTypeToKotlinTypeMapper): List<Type> {
    val typeUsingAlias = typeMapper.getKotlinTypeForTypeAlias(typeName.text)?.toKotlinTypeOverloads(typeMapper)
    if (typeUsingAlias != null) return typeUsingAlias
    return listOf(toKotlinTypeIgnoringTypeAliases(typeMapper))
}

private fun TS.TypeReferenceNode.toKotlinTypeIgnoringTypeAliases(typeMapper: ObjectTypeToKotlinTypeMapper): Type {
    // TODO improve
    val name = typeName.toKotlinTypeName(typeMapper)

    return Type(name, typeArguments?.arr?.map { it.toKotlinType(typeMapper) } ?: emptyList())
}

fun TS.ExpressionWithTypeArguments.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): Type {
    val name = expression.stringifyQualifiedName()

    return Type(name, typeArguments?.arr?.map { it.toKotlinType(typeMapper) } ?: emptyList())
}

private fun TS.PropertyAccessExpression.stringify(): String {
    val identifier = identifierName.unescapedText

    val qualifier = expression?.stringifyQualifiedName() ?: return identifier

    return qualifier + "." + identifier
}

private fun TS.Node.stringifyQualifiedName() = when (kind) {
    TS.SyntaxKind.Identifier ->
        (this.cast<TS.Identifier>()).unescapedText

    TS.SyntaxKind.PropertyAccessExpression ->
        (this.cast<TS.PropertyAccessExpression>()).stringify()

    else -> unsupportedNode(this)
}

fun TS.UnionTypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): Type {
    val commentWithExpectedType = toKotlinTypeOverloads(typeMapper).joinToString(" | ")
    // TODO should it be `Any`?
    return Type(DYNAMIC, comment = commentWithExpectedType)
}

fun TS.UnionTypeNode.toKotlinTypeOverloads(typeMapper: ObjectTypeToKotlinTypeMapper): List<Type> {
    return types.arr.flatMap { it.toKotlinTypeOverloads(typeMapper) }.distinct()
}

fun TS.IntersectionTypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): Type {
    val kotlinTypes = types.arr.map { it.toKotlinType(typeMapper) }
    val commentWithExpectedType = kotlinTypes.joinToString(" & ")
    // just take the first one for now since Kotlin doesn't support intersection types.
    return kotlinTypes[0].copy(comment = commentWithExpectedType)
}

fun TS.ThisTypeNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): Type {
    var parent = parent

    while(parent != null) {
        @Suppress("NON_EXHAUSTIVE_WHEN")
        when (parent.kind) {
            TS.SyntaxKind.ClassDeclaration,
            TS.SyntaxKind.InterfaceDeclaration ->
                return parent.cast<ClassOrInterfaceDeclaration>().toKotlinType(typeMapper).copy(comment = "this")
            // TODO support
            TS.SyntaxKind.TypeLiteral ->
                return Type(ANY, comment = "this")
        }
        parent = parent.parent
    }

    throw JsError("Illegal State")
}

fun TS.TypePredicateNode.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): Type {
    return Type(BOOLEAN)
}

fun ClassOrInterfaceDeclaration.toKotlinType(typeMapper: ObjectTypeToKotlinTypeMapper): Type {
    val name = identifierName!!.unescapedText

    return Type(name, typeParameters?.arr?.map { Type(it.identifierName.unescapedText) } ?: emptyList())
}

fun forEachChild(visitor: Visitor, node: TS.Node) {
    TS.forEachChild(node, { node ->
        visitNode(visitor, node)
    })
}

fun visitNode(visitor: Visitor, node: TS.Node?): Unit {
    if (node == null) return

    when (node.kind) {
        TS.SyntaxKind.ModuleDeclaration -> visitor.visitModuleDeclaration(node.asDynamic())

        TS.SyntaxKind.FunctionDeclaration    -> visitor.visitFunctionDeclaration(node.cast<TS.FunctionDeclaration>())
        TS.SyntaxKind.VariableStatement -> visitor.visitVariableStatement(node.cast<TS.VariableStatement>())

        TS.SyntaxKind.EnumDeclaration -> visitor.visitEnumDeclaration(node.cast<TS.EnumDeclaration>())

        TS.SyntaxKind.ClassDeclaration -> visitor.visitClassDeclaration(node.cast<TS.ClassDeclaration>())
        TS.SyntaxKind.InterfaceDeclaration -> visitor.visitInterfaceDeclaration(node.cast<TS.InterfaceDeclaration>())
        TS.SyntaxKind.TypeAliasDeclaration -> visitor.visitTypeAliasDeclaration(node.cast<TS.TypeAliasDeclaration>())

        TS.SyntaxKind.HeritageClause -> visitor.visitHeritageClause(node.cast<TS.HeritageClause>())

        TS.SyntaxKind.Constructor -> visitor.visitConstructorDeclaration(node.cast<TS.ConstructorDeclaration>())
        TS.SyntaxKind.ConstructSignature -> visitor.visitConstructSignatureDeclaration(node.cast<TS.ConstructorDeclaration>())

        // TODO what is difference between MethodSignature and MethodDeclaration
        TS.SyntaxKind.MethodDeclaration,
        TS.SyntaxKind.MethodSignature -> visitor.visitMethodDeclaration(node.cast<TS.MethodDeclaration>())

        // TODO what is difference between PropertySignature and PropertyDeclaration
        TS.SyntaxKind.PropertyDeclaration,
        TS.SyntaxKind.PropertySignature -> visitor.visitPropertyDeclaration(node.cast<TS.PropertyDeclaration>())

        TS.SyntaxKind.IndexSignature -> visitor.visitIndexSignature(node.cast<TS.IndexSignatureDeclaration>())
        TS.SyntaxKind.CallSignature -> visitor.visitSignatureDeclaration(node.cast<TS.SignatureDeclaration>())

        TS.SyntaxKind.ExportAssignment -> visitor.visitExportAssignment(node.cast<TS.ExportAssignment>())
        TS.SyntaxKind.ImportEqualsDeclaration ->  { /* TODO implement */ }

        TS.SyntaxKind.EndOfFileToken -> { /* ignore */ }
        else -> {
            val message = "Unsupported node.kind: ${node.kind}, name: ${node.kind.str} (${node.location()})"
            if (reportedKinds.add(node.kind.id)) console.error(message)
            unsupportedNode(node)
        }
    }
}

val <T> TS.NodeArray<T>.arr: Array<T>
    get() = this.asDynamic()

val TS.SyntaxKind.str: String
    get() = js("ts").SyntaxKind[this]

val TS.SyntaxKind.id: Int
    get() = this.asDynamic()

// TODO review where we use raw text
val TS.Identifier.unescapedText: String
    get() = TS.unescapeIdentifier(text)

private fun TS.LineAndCharacter.format(): String = "${line.toInt() + 1}:${character.toInt() + 1}"

private fun TS.Node.location(): String {
    val start = getSourceFile().getLineAndCharacterOfPosition(pos)
    val end = getSourceFile().getLineAndCharacterOfPosition(end)
    return "${getSourceFile().fileName}:${start.format()} to ${end.format()}"
}

fun unsupportedNode(node: TS.Node): Nothing {
    val message = "${node.kind.str} kind (${node.location()}) unsupported yet here! See node in attachment."
    val exception = JsError(message)
    exception.asDynamic().attachment = node
    throw exception
}
