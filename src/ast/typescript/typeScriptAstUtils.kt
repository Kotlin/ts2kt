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

import typescript.*
import java.util.ArrayList
import ts2kt.kotlin.ast.FunParam
import ts2kt.kotlin.ast.TypeAnnotation
import ts2kt.kotlin.ast.TypeParam
import ts2kt.kotlin.ast.CallSignature
import ts2kt.utils.*

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

    val nodeType: TS.TypeNode_or_StringLiteralExpression?
    if (isVararg && originalNodeType != null) {
        val originalNodeKind = originalNodeType.kind

        when {
            originalNodeKind === TS.SyntaxKind.ArrayType -> {
                nodeType = (originalNodeType as TS.ArrayTypeNode).elementType as TS.TypeNode_or_StringLiteralExpression
            }

            originalNodeKind === TS.SyntaxKind.TypeReference &&
            (originalNodeType as TS.TypeReferenceNode).typeName.text == "Array" -> {
                val typeArguments = (originalNodeType as TS.TypeReferenceNode).typeArguments!!.arr
                assert(typeArguments.size() == 1, "Array should have one generic paramater, but have ${typeArguments.size()}.")
                nodeType = typeArguments[0] as TS.TypeNode_or_StringLiteralExpression
            }
            else -> {
                throw Exception("Rest parameter must be array types, but ${originalNodeKind.str}")
            }
        }
    }
    else {
        nodeType = originalNodeType
    }

    val name = name.text
    val typeName = nodeType?.toKotlinTypeName(typeMapper) ?: ANY
    val defaultValue = initializer?.let {
        when (it.kind) {
            // TODO
            TS.SyntaxKind.FirstLiteralToken -> (it as TS.LiteralExpression).text
            TS.SyntaxKind.StringLiteral -> "\"" + (it as TS.LiteralExpression).text + "\""

            else -> unsupportedNode(it)
        }
    }
    val isNullable = questionToken != null
    val isLambda = nodeType?.kind === TS.SyntaxKind.FunctionType
    val isVar = TS.hasFlag(flags, TS.NodeFlags.AccessibilityModifier)

    return FunParam(name,
            TypeAnnotation(typeName, isNullable = isNullable, isLambda = isLambda, isVararg = isVararg),
            if (defaultValue == null && isNullable) "null" else defaultValue,
            isVar)
}

fun TS.NodeArray<TS.ParameterDeclaration>.toKotlinParams(typeMapper: ObjectTypeToKotlinTypeMapper): List<FunParam>  =
        arr.map { param -> param.toKotlinParam(typeMapper) }

fun TS.NodeArray<TS.TypeParameterDeclaration>.toKotlinTypeParams(typeMapper: ObjectTypeToKotlinTypeMapper): List<TypeParam>  =
        arr.map { typeParam ->
            val typeName = (typeParam.name as TS.TypeNode).toKotlinTypeName(typeMapper)
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
        TS.SyntaxKind.ArrayType -> (this as TS.ArrayTypeNode).toKotlinTypeName(typeMapper)
        TS.SyntaxKind.ConstructorType,
        TS.SyntaxKind.FunctionType -> (this as TS.FunctionOrConstructorTypeNode).toKotlinTypeName(typeMapper)

        TS.SyntaxKind.TypeReference -> (this as TS.TypeReferenceNode).toKotlinTypeName(typeMapper)

        TS.SyntaxKind.Identifier -> (this as TS.Identifier).text
        TS.SyntaxKind.TypeLiteral -> (this as TS.TypeLiteralNode).toKotlinTypeName(typeMapper)

        TS.SyntaxKind.UnionType -> (this as TS.UnionTypeNode).toKotlinTypeName(typeMapper)

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
            this.text
        else ->
            this.left.toKotlinTypeName(typeMapper) + "." + this.right.text
    }
}

fun TS.TypeReferenceNode.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    // TODO improve
    val name = typeName.toKotlinTypeName(typeMapper)
    val typeArgs = typeArguments
    if (typeArgs == null) return name

    val strTypeArgs = typeArgs.arr.map { it.toKotlinTypeName(typeMapper) }.join(",")
    return "$name<$strTypeArgs>"
}

fun TS.UnionTypeNode.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    val commentWithExpectedType = types.arr.map { it.toKotlinTypeName(typeMapper) }.join(" | ", prefix = " /* ", postfix = " */")
    // TODO should it be `Any`?
    return DYNAMIC + commentWithExpectedType
}


fun forEachChild(visitor: Visitor, node: dynamic) {
    ts.forEachChild(node) { node ->
        visitNodeOrToken(visitor, node)
    }
}

fun visitNodeOrToken(visitor: Visitor, node: dynamic): Unit {
    if (node == null) return

    when (node.kind) {
        TS.SyntaxKind.ModuleDeclaration -> visitor.visitModuleDeclaration(node);

        TS.SyntaxKind.FunctionDeclaration    -> visitor.visitFunctionDeclaration(node);
        TS.SyntaxKind.VariableStatement -> visitor.visitVariableStatement(node);

        TS.SyntaxKind.EnumDeclaration -> visitor.visitEnumDeclaration(node);

        TS.SyntaxKind.ClassDeclaration -> visitor.visitClassDeclaration(node);
        TS.SyntaxKind.InterfaceDeclaration -> visitor.visitInterfaceDeclaration(node);

        TS.SyntaxKind.HeritageClause -> visitor.visitHeritageClause(node);

        TS.SyntaxKind.Constructor -> visitor.visitConstructorDeclaration(node);

        TS.SyntaxKind.Method -> visitor.visitMethodDeclaration(node);
        TS.SyntaxKind.Property -> visitor.visitPropertyDeclaration(node);
        TS.SyntaxKind.IndexSignature -> visitor.visitIndexSignature(node);
        TS.SyntaxKind.CallSignature -> visitor.visitSignatureDeclaration(node);

        TS.SyntaxKind.ExportAssignment -> visitor.visitExportAssignment(node);

        TS.SyntaxKind.EndOfFileToken -> { /* ignore */ }
        else -> {
            val message = "Unsupported node.kind: ${node.kind}, name: ${ts.SyntaxKind[node.kind]}"
            if (reportedKinds.add(node.kind)) console.error(message)
            throw Exception(message)
        }
    }
}

val <T> TS.NodeArray<T>.arr: Array<T>
    get() = this: dynamic

val TS.SyntaxKind.str: String
    get() = ts.SyntaxKind[this]

fun unsupportedNode(node: TS.Node): Nothing = throw Exception("${node.kind.str} kind unsupported yet here!")
