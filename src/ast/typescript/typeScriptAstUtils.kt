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
import ts2kt.kotlin.ast.CallSignature
import ts2kt.kotlin.ast.FunParam
import ts2kt.kotlin.ast.TypeAnnotation
import ts2kt.kotlin.ast.TypeParam
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
              "trait", "true", "try", "typealias", "val", "var", "when", "while")

val NOT_OVERRIDE: (TS.Node) -> Boolean = { false }

fun String.escapeIfNeed(): String {
    return if (this in SHOULD_BE_ESCAPED || this.contains("$")) {
        "`$this`"
    }
    else {
        this
    }
}

fun TS.ParameterDeclaration.toKotlinParam(typeMapper: ObjectTypeToKotlinTypeMapper): FunParam {
    val originalNodeType = type
    val isVararg = dotDotDotToken != null

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

    val name = declarationName!!.unescapedText
    val typeName = nodeType?.toKotlinTypeName(typeMapper) ?: ANY
    val defaultValue = initializer?.let {
        when (it.kind) {
            // TODO
            TS.SyntaxKind.FirstLiteralToken -> (it.cast<TS.LiteralExpression>()).text
            TS.SyntaxKind.StringLiteral -> "\"" + (it.cast<TS.LiteralExpression>()).text + "\""

            else -> unsupportedNode(it)
        }
    }
    val isNullable = questionToken != null
    val isLambda = nodeType?.kind === TS.SyntaxKind.FunctionType
    val isVar = hasFlag(flags, TS.NodeFlags.AccessibilityModifier)

    return FunParam(name,
            TypeAnnotation(typeName, isNullable = isNullable, isLambda = isLambda, isVararg = isVararg),
            if (defaultValue == null && isNullable) "null" else defaultValue,
            isVar)
}

fun TS.NodeArray<TS.ParameterDeclaration>.toKotlinParams(typeMapper: ObjectTypeToKotlinTypeMapper): List<FunParam>  =
        arr.map { param -> param.toKotlinParam(typeMapper) }

fun TS.NodeArray<TS.TypeParameterDeclaration>.toKotlinTypeParams(typeMapper: ObjectTypeToKotlinTypeMapper): List<TypeParam>  =
        arr.map { typeParam ->
            val typeName = (typeParam.identifierName.cast<TS.TypeNode>()).toKotlinTypeName(typeMapper)
            val upperBound = typeParam.constraint?.toKotlinTypeName(typeMapper)
            TypeParam(typeName, upperBound)
        }

fun TS.SignatureDeclaration.toKotlinCallSignature(typeMapper: ObjectTypeToKotlinTypeMapper): CallSignature {
    val typeParams = typeParameters?.toKotlinTypeParams(typeMapper)
    val params = parameters.toKotlinParams(typeMapper)
    val returnType = type?.toKotlinTypeName(typeMapper) ?: UNIT

    return CallSignature(params, typeParams, TypeAnnotation(returnType))
}


fun TS.ArrayTypeNode.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    val typeArg = elementType.toKotlinTypeName(typeMapper)
    return "$ARRAY<$typeArg>"
}

//TODO: do we need LambdaType???
private fun TS.FunctionOrConstructorTypeNode.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    val params = parameters.toKotlinParams(typeMapper)
    return "${params.join(", ", start = "(", end = ")")} -> ${type?.toKotlinTypeName(typeMapper) ?: ANY }"
}

// TODO implement
private fun TS.TypeLiteralNode.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String =
        typeMapper.getKotlinTypeNameForObjectType(this)

private fun TS.TypeNode.toKotlinTypeNameIfStandardType(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    return when (this.kind) {
        TS.SyntaxKind.AnyKeyword -> ANY
        TS.SyntaxKind.NumberKeyword -> NUMBER
        TS.SyntaxKind.StringKeyword -> STRING
        TS.SyntaxKind.BooleanKeyword -> BOOLEAN
        TS.SyntaxKind.VoidKeyword -> UNIT
        TS.SyntaxKind.ArrayType -> (this.cast<TS.ArrayTypeNode>()).toKotlinTypeName(typeMapper)
        TS.SyntaxKind.ConstructorType,
        TS.SyntaxKind.FunctionType -> (this.cast<TS.FunctionOrConstructorTypeNode>()).toKotlinTypeName(typeMapper)

        TS.SyntaxKind.TypeReference -> (this.cast<TS.TypeReferenceNode>()).toKotlinTypeName(typeMapper)
        TS.SyntaxKind.ExpressionWithTypeArguments -> (this.cast<TS.ExpressionWithTypeArguments>()).toKotlinTypeName(typeMapper)

        TS.SyntaxKind.Identifier -> (this.cast<TS.Identifier>()).unescapedText
        TS.SyntaxKind.TypeLiteral -> (this.cast<TS.TypeLiteralNode>()).toKotlinTypeName(typeMapper)

        TS.SyntaxKind.UnionType -> (this.cast<TS.UnionTypeNode>()).toKotlinTypeName(typeMapper)

        TS.SyntaxKind.ParenthesizedType -> (this.cast<TS.ParenthesizedTypeNode>()).type.toKotlinTypeName(typeMapper)

        // TODO how to support?
        TS.SyntaxKind.StringLiteralType -> ANY + " /* \"" + (this.cast<TS.StringLiteralType>()).text + "\"*/"

        TS.SyntaxKind.ThisType -> (this.cast<TS.ThisTypeNode>()).toKotlinTypeName(typeMapper)

        else -> unsupportedNode(this)
    }
}

// TODO
fun TS.TypeNode.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    return this.toKotlinTypeNameIfStandardType(typeMapper)
}

fun TS.EntityName.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    return when (kind) {
        TS.SyntaxKind.Identifier ->
            this.unescapedText
        else ->
            this.left.toKotlinTypeName(typeMapper) + "." + this.right.unescapedText
    }
}

fun TS.TypeReferenceNode.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    // TODO improve
    val name = typeName.toKotlinTypeName(typeMapper)
    val typeArgs = typeArguments ?: return name

    val strTypeArgs = typeArgs.arr.map { it.toKotlinTypeName(typeMapper) }.joinToString(",")
    return "$name<$strTypeArgs>"
}

fun TS.ExpressionWithTypeArguments.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    val name = expression.stringifyQualifiedName()

    val typeArgs = typeArguments ?: return name

    val strTypeArgs = typeArgs.arr.map { it.toKotlinTypeName(typeMapper) }.joinToString(",")
    return "$name<$strTypeArgs>"
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

fun TS.UnionTypeNode.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    val commentWithExpectedType = types.arr.map { it.toKotlinTypeName(typeMapper) }.joinToString(" | ", prefix = " /* ", postfix = " */")
    // TODO should it be `Any`?
    return DYNAMIC + commentWithExpectedType
}

fun TS.ThisTypeNode.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    var parent = parent

    while(parent != null) {
        @Suppress("NON_EXHAUSTIVE_WHEN")
        when (parent.kind) {
            TS.SyntaxKind.ClassDeclaration,
            TS.SyntaxKind.InterfaceDeclaration ->
                return parent.cast<ClassOrInterfaceDeclaration>().toKotlinTypeName(typeMapper) + " /* this */"
            // TODO support
            TS.SyntaxKind.TypeLiteral ->
                return ANY + " /* this */"
        }
        parent = parent.parent
    }

    throw JsError("Illegal State")
}

fun ClassOrInterfaceDeclaration.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    val name = identifierName!!.unescapedText

    val typeParams = typeParameters ?: return name

    val strTypeParams = typeParams.arr.map { it.identifierName.unescapedText }.joinToString(", ")
    return "$name<$strTypeParams>"

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
        TS.SyntaxKind.TypeAliasDeclaration -> { /* TODO implement */ }

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

        TS.SyntaxKind.EndOfFileToken -> { /* ignore */ }
        else -> {
            val message = "Unsupported node.kind: ${node.kind}, name: ${node.kind.str}"
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

fun unsupportedNode(node: TS.Node): Nothing {
    val message = "${node.kind.str} kind unsupported yet here! See node in attachment."
    val exception = JsError(message)
    exception.asDynamic().attachment = node
    throw exception
}
