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
import ts2kt.utils.setOf
import ts2kt.kotlin.ast.FunParam
import ts2kt.kotlin.ast.TypeAnnotation
import ts2kt.utils.join
import ts2kt.kotlin.ast.TypeParam
import ts2kt.kotlin.ast.CallSignature

val SHOULD_BE_ESCAPED =
        setOf("val", "var", "is", "as", "trait", "package", "object", "when", "type", "fun", "in", "This")

fun String.escapedIfNeed(): String {
    return if (this in SHOULD_BE_ESCAPED || this.contains("$")) {
        "`$this`"
    }
    else {
        this
    }
}

fun ISyntaxElement.getText(): String = if (this.isToken()) (this as ISyntaxToken).text() else this.fullText()

fun ShouldBeEscaped.getText(): String = (this: ISyntaxElement).getText().escapedIfNeed()

///

fun ParameterSyntax.toKotlinParam(): FunParam {
    val originalNodeType = typeAnnotation?.`type`
    val isVararg: Boolean
    val nodeType =
            if (dotDotDotToken != null) {
                if (originalNodeType?.kind() != ArrayType) throw Exception("Rest prarameter must be array types")
                isVararg = true
                (originalNodeType as? ArrayTypeSyntax)?.`type`
            }
            else {
                isVararg = false
                originalNodeType
            }

    val name = identifier.getText()
    val typeName = nodeType?.toKotlinTypeName() ?: "Any"
    val defaultValue = equalsValueClause?.value?.fullText()
    val isNullable = questionToken != null
    val isLambda = nodeType?.kind() == FunctionType

    return FunParam(name,
            TypeAnnotation(typeName, isNullable = isNullable, isLambda = isLambda, isVararg = isVararg),
            if (defaultValue == null && isNullable) "null" else defaultValue)
}

fun ParameterListSyntax.toKotlinParams(): List<FunParam>  =
        parameters.map { (param: ParameterSyntax) -> param.toKotlinParam() }

fun TypeParameterListSyntax.toKotlinTypeParams(): List<TypeParam>  =
        typeParameters.map { (typeParam: TypeParameterSyntax) ->
            val typeName = typeParam.identifier.toKotlinTypeName()
            val upperBound = typeParam.constraint?.`type`?.toKotlinTypeName()
            TypeParam(typeName, upperBound)
        }

fun CallSignatureSyntax.toKotlinCallSignature(): CallSignature {
    val typeParams = typeParameterList?.toKotlinTypeParams()
    val params = parameterList.toKotlinParams()
    val returnType = typeAnnotation?.toKotlinTypeName() ?: "Unit"

    return CallSignature(params, typeParams, TypeAnnotation(returnType))
}


//TODO: do we need LambdaType???
fun FunctionTypeSyntax.toKotlinTypeName(): String {
    val params = parameterList.toKotlinParams()
    return "${params.join(", ", start = "(", end = ")")} -> ${`type`.toKotlinTypeName()}"
}

fun GenericTypeSyntax.toKotlinTypeName(): String {
    var typeArgs = typeArgumentList.typeArguments.map { (typeArg: ITypeSyntax) -> typeArg.toKotlinTypeName() }
    return "${name.getText()}<${typeArgs.join(", ")}>"
}

fun ITypeSyntax.toKotlinTypeNameIfStandardType(): String? {
    return when (this.kind()) {
        AnyKeyword -> "Any"
        NumberKeyword -> "Number"
        StringKeyword -> "String"
        BooleanKeyword -> "Boolean"
        VoidKeyword -> "Unit"
        ArrayType -> "Array<${(this as ArrayTypeSyntax).`type`.toKotlinTypeName()}>"
        GenericType -> (this as GenericTypeSyntax).toKotlinTypeName()
        FunctionType -> (this as FunctionTypeSyntax).toKotlinTypeName()
        else -> null
    }
}

fun ITypeSyntax.toKotlinTypeName(): String {
    return this.toKotlinTypeNameIfStandardType() ?: this.getText()
}

fun String?.toKotlinTypeName(): String {
    if (this == null) return "Unit"

    return when (this) {
        "any" -> "Any"
        "number" -> "Number"
        "string" -> "String"
        "boolean" -> "Boolean"
        "void" -> "Unit"
        else -> this
    }
}

fun TypeAnnotationSyntax.toKotlinTypeName(): String = `type`.toKotlinTypeName()

///

fun ISyntaxList.containsBy<T>(a: T, f: (ISyntaxNodeOrToken) -> T): Boolean {
    for (i in 0..childCount() - 1) {
        val e = f(childAt(i))
        if (e == a) return true
    }

    return false
}

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

