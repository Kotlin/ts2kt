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
import ts2kt.utils.join
import ts2kt.kotlin.ast.TypeParam
import ts2kt.kotlin.ast.CallSignature
import ts2kt.utils.assert

val ANY = "Any"
val NUMBER = "Number"
val STRING = "String"
val BOOLEAN = "Boolean"
val UNIT = "Unit"
val ARRAY = "Array"

val SHOULD_BE_ESCAPED =
        setOf("as", "break", "class", "continue", "do", "else", "false", "for", "fun", "if",
              "in", "is", "null", "object", "package", "return", "super", "this", "This", "throw",
              "trait", "true", "try", "typealias", "val", "var", "when", "while")

val NOT_OVERRIDE: (PositionedElement) -> Boolean = { false }

fun String.escapeIfNeed(): String {
    return if (this in SHOULD_BE_ESCAPED || this.contains("$")) {
        "`$this`"
    }
    else {
        this
    }
}

fun ISyntaxElement.getText(): String = when {
        this.isToken() ->
            (this as ISyntaxToken).text()
        else ->
            this.fullText().substring(this.leadingTriviaWidth(), width())
    }


fun ShouldBeEscaped.getText(): String = (this: ISyntaxElement).getText().escapeIfNeed()

fun NameAsStringLiteral.getText(): String {
    val quotedText = (this: ISyntaxElement).getText()
    val text = quotedText.substring(1, quotedText.size - 1)
    return text.escapeIfNeed()
}

///

fun ParameterSyntax.toKotlinParam(typeMapper: ObjectTypeToKotlinTypeMapper): FunParam {
    val originalNodeType = typeAnnotation?.`type`
    val isVararg: Boolean = dotDotDotToken != null

    val nodeType: ITypeSyntax?
    if (isVararg && originalNodeType != null) {
        val originalNodeKind = originalNodeType.kind()

        if (originalNodeKind == ArrayType) {
            nodeType = (originalNodeType as? ArrayTypeSyntax)?.`type`
        } else if (originalNodeKind == GenericType && (originalNodeType as? GenericTypeSyntax)?.name?.getText() == "Array") {
            val typeArguments = (originalNodeType as GenericTypeSyntax).typeArgumentList.typeArguments
            assert(typeArguments.nonSeparatorCount() == 1, "Array should have one generic paramater, but have ${typeArguments.nonSeparatorCount()}.")

            nodeType = typeArguments.nonSeparatorAt(0) as ITypeSyntax?
        } else {
            throw Exception("Rest parameter must be array types")
        }
    }
    else {
        nodeType = originalNodeType
    }

    val name = identifier.getText()
    val typeName = nodeType?.toKotlinTypeName(typeMapper) ?: ANY
    val defaultValue = equalsValueClause?.value?.fullText()
    val isNullable = questionToken != null
    val isLambda = nodeType?.kind() == FunctionType
    val isVar = publicOrPrivateKeyword != null

    return FunParam(name,
            TypeAnnotation(typeName, isNullable = isNullable, isLambda = isLambda, isVararg = isVararg),
            if (defaultValue == null && isNullable) "null" else defaultValue,
            isVar)
}

fun ParameterListSyntax.toKotlinParams(typeMapper: ObjectTypeToKotlinTypeMapper): List<FunParam>  =
        parameters.map { (param: ParameterSyntax) -> param.toKotlinParam(typeMapper) }

fun TypeParameterListSyntax.toKotlinTypeParams(typeMapper: ObjectTypeToKotlinTypeMapper): List<TypeParam>  =
        typeParameters.map { (typeParam: TypeParameterSyntax) ->
            val typeName = typeParam.identifier.toKotlinTypeName(typeMapper)
            val upperBound = typeParam.constraint?.`type`?.toKotlinTypeName(typeMapper)
            TypeParam(typeName, upperBound)
        }

fun CallSignatureSyntax.toKotlinCallSignature(typeMapper: ObjectTypeToKotlinTypeMapper): CallSignature {
    val typeParams = typeParameterList?.toKotlinTypeParams(typeMapper)
    val params = parameterList.toKotlinParams(typeMapper)
    val returnType = typeAnnotation?.toKotlinTypeName(typeMapper) ?: UNIT

    return CallSignature(params, typeParams, TypeAnnotation(returnType))
}


fun ArrayTypeSyntax.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    val typeArg = `type`.toKotlinTypeName(typeMapper)
    return "$ARRAY<$typeArg>"
}

private fun GenericTypeSyntax.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    var typeArgs = typeArgumentList.typeArguments.map { (typeArg: ITypeSyntax) -> typeArg.toKotlinTypeName(typeMapper) }
    return "${name.getText()}<${typeArgs.join(", ")}>"
}

//TODO: do we need LambdaType???
private fun FunctionTypeSyntax.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    val params = parameterList.toKotlinParams(typeMapper)
    return "${params.join(", ", start = "(", end = ")")} -> ${`type`.toKotlinTypeName(typeMapper)}"
}

// TODO implement
private fun ObjectTypeSyntax.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String =
        typeMapper.getKotlinTypeNameForObjectType(this)

private fun ITypeSyntax.toKotlinTypeNameIfStandardType(typeMapper: ObjectTypeToKotlinTypeMapper): String? {
    return when (this.kind()) {
        AnyKeyword -> ANY
        NumberKeyword -> NUMBER
        StringKeyword -> STRING
        BooleanKeyword -> BOOLEAN
        VoidKeyword -> UNIT
        ArrayType -> (this as ArrayTypeSyntax).toKotlinTypeName(typeMapper)
        GenericType -> (this as GenericTypeSyntax).toKotlinTypeName(typeMapper)
        FunctionType -> (this as FunctionTypeSyntax).toKotlinTypeName(typeMapper)
        ObjectType -> (this as ObjectTypeSyntax).toKotlinTypeName(typeMapper)
        else -> null
    }
}

fun ITypeSyntax.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String {
    return this.toKotlinTypeNameIfStandardType(typeMapper) ?: this.getText()
}

fun TypeAnnotationSyntax.toKotlinTypeName(typeMapper: ObjectTypeToKotlinTypeMapper): String = `type`.toKotlinTypeName(typeMapper)

///

fun ISyntaxList.containsBy<T>(a: T, f: (ISyntaxNodeOrToken) -> T): Boolean {
    for (i in 0..childCount() - 1) {
        val e = f(childAt(i))
        if (e == a) return true
    }

    return false
}

fun ISyntaxList.contains(syntaxKind: SyntaxKind): Boolean = this.containsBy(syntaxKind) { it.kind() }

fun ISyntaxList.map<T : ISyntaxNodeOrToken, R>(f: (T) -> R): List<R> {
    val l = ArrayList<R>()

    for (i in 0..childCount() - 1) {
        [suppress("UNCHECKED_CAST")]
        val e = childAt(i) as T
        l.add(f(e))
    }

    return l
}

fun ISeparatedSyntaxList.map<T : ISyntaxNodeOrToken, R>(f: (T) -> R): List<R> {
    val l = ArrayList<R>()

    for (i in 0..nonSeparatorCount() - 1) {
        [suppress("UNCHECKED_CAST")]
        val e = nonSeparatorAt(i) as T
        l.add(f(e))
    }

    return l
}

fun ISeparatedSyntaxList.iterator(): Iterator<VariableDeclaratorSyntax> {
    return object : Iterator<VariableDeclaratorSyntax> {
        var i = 0
        override fun next() = childAt(i++) as VariableDeclaratorSyntax
        override fun hasNext() = i < childCount()
    }
}
