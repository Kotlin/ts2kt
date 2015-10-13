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

package ts2kt.kotlin.ast

import ts2kt.UNIT
import ts2kt.escapeIfNeed
import ts2kt.utils.assert
import ts2kt.utils.join

val MODULE = "module"
val NATIVE = "native"
val FAKE = "fake"

val FAKE_ANNOTATION = Annotation(FAKE)
val DEFAULT_FAKE_ANNOTATION = listOf(FAKE_ANNOTATION)

val NO_IMPL = "noImpl"
private val EQ_NO_IMPL = " = $NO_IMPL"
private val PUBLIC = "public"
private val OPEN = "open"
private val OVERRIDE = "override"
private val VAR = "var"
private val VAL = "val"
private val FUN = "fun"
private val VARARG = "vararg"

private val INDENT = "    "
private val indents = listOf("") as MutableList<String>

private val takeIfNotAnnotatedAsFake = { node: Annotated ->
    var result = true
    for (a in node.annotations) {
        if (a == FAKE_ANNOTATION) {
            result = false
            break
        }
    }

    result
}


fun getIndent(n: Int): String {
    assert(n >= 0, "The indent index should be >= 0")
    if (n < indents.size) return indents[n]

    for (i in indents.size..n) {
        indents.add(indents[i - 1] + INDENT)
    }

    return indents[n]
}

abstract class Node(val needsFixIndent: Boolean = false) {
    private var cachedToString: String? = null

    abstract fun stringify(): String

    final override fun toString(): String {
        if (cachedToString == null) {
            cachedToString = fixIndentation(stringify())
        }
        return cachedToString!!
    }

    private fun fixIndentation(s: String): String {
        if (!needsFixIndent) return s

        var indentIdx = 0
        var indent = getIndent(indentIdx)

        return s.lineSequence().map {
            if (it.endsWith("}")) {
                indent = getIndent(--indentIdx)
            }

            val result = if (it.isEmpty() || indentIdx == 0) it else indent + it.trimStart()

            if (it.endsWith('{')) {
                indent = getIndent(++indentIdx)
            }

            result
        }.joinToString("\n")
    }
}

class MemberList(val elements: List<Member>) : Node() {
    override fun stringify(): String = throw UnsupportedOperationException()
}

class KotlinFile(val packageFqName: Package?, val members: List<Member>) : Node() {
    override fun stringify(): String =
            (packageFqName?.toString()?.plus("\n") ?: "") +
            members.join("\n",
                    startWithIfNotEmpty = if (packageFqName == null) "" else "\n",
                    endWithIfNotEmpty = "\n",
                    filter = takeIfNotAnnotatedAsFake)
}

class Package(val name: String) : Node() {
    override fun stringify(): String = "package $name"
}

interface Named {
    // TODO: make it immutable
    var name: String
}

interface Annotated {
    // TODO: make it immutable
    var annotations: List<Annotation>
}

interface Member : Named, Annotated

// TODO should be Named?
// TODO should we escape name here?
class Argument(val name: String? = null, val value: Any /* TODO ??? */) {
    override fun toString() = (if (name == null) "" else "$name = ") + value
}

class Annotation(override var name: String, val parameters: List<Argument> = listOf()) : Named, Node() {
    override fun stringify(): String = "$escapedName" + if (parameters.isEmpty()) "" else "(${parameters.join()})"
}

enum class ClassKind(val keyword: String, val bracesAlwaysRequired: Boolean = false) {
    CLASS("class"),
    TRAIT("trait"),
    ENUM("enum class"),
    OBJECT("object", bracesAlwaysRequired = true),
    CLASS_OBJECT("class object", bracesAlwaysRequired = true)
}

class Classifier(
        val kind: ClassKind,
        override var name: String,
        val paramsOfConstructors: List<List<FunParam>>,
        val typeParams: List<TypeParam>?,
        val parents: List<Type>,
        val members: List<Member>,
        override var annotations: List<Annotation>,
        val hasOpenModifier: Boolean
) : Member, Node(needsFixIndent = true) {
    override fun stringify(): String =
            annotations.stringify() +
            PUBLIC + " " +
            (if (hasOpenModifier) OPEN + " " else "") +
            kind.keyword +
            (if (name.isEmpty()) "" else " ") +
            escapedName +
            (typeParams?.join(", ", startWithIfNotEmpty = "<", endWithIfNotEmpty = ">") ?: "") +
            (if (paramsOfConstructors.isEmpty()) "" else paramsOfConstructors[0].join(", ", startWithIfNotEmpty = "(", endWithIfNotEmpty = ")")) +
            parents.join(", ", startWithIfNotEmpty = " : ") +
            (if (bracesRequired) " {\n" else "") +
            members.join("\n", filter = takeIfNotAnnotatedAsFake) +
            (if (bracesRequired) "\n}" else "")

    val bracesRequired = kind.bracesAlwaysRequired || !members.isEmpty()
}

class FunParam(
        override var name: String,
        val type: TypeAnnotation,
        val defaultValue: Any? = null,
        val isVar: Boolean = false
) : Named, Node() {
    override fun stringify(): String = stringify(printDefaultValue = true)

    fun stringify(printDefaultValue: Boolean): String =
            (if (isVar) "$PUBLIC $OPEN $VAR " else "") +
            (if (type.isVararg) VARARG + " " else "") + escapedName + type +
            if (defaultValue == null || !printDefaultValue) "" else " = $defaultValue"
}

class CallSignature(
        val params: List<FunParam>,
        val typeParams: List<TypeParam>?,
        val returnType: TypeAnnotation
) : Node() {
    override fun stringify(): String = stringify(withTypeParams = true, printUnitReturnType = true, printDefaultValues = true)

    fun stringify(withTypeParams: Boolean, printUnitReturnType: Boolean, printDefaultValues: Boolean): String =
            (if (withTypeParams) stringifyTypeParams() else  "") +
            params.join(start = "(", end = ")", stringify = { it.stringify(printDefaultValues) }) +
            returnType.stringify(printUnitType = printUnitReturnType)

    fun stringifyTypeParams(withSpaceAfter: Boolean = false) =
            typeParams?.join(startWithIfNotEmpty = "<", endWithIfNotEmpty = ">" + if (withSpaceAfter) " " else "") ?:  ""
}

class Function(
        override var name: String,
        val callSignature: CallSignature,
        val extendsType: Type? = null,
        override var annotations: List<Annotation>,
        val needsNoImpl: Boolean = true,
        val isOverride: Boolean = false,
        val hasOpenModifier: Boolean
) : Member, Node() {
    override fun stringify(): String =
            annotations.stringify() +
            (if (isOverride) OVERRIDE else PUBLIC + (if (hasOpenModifier) " " + OPEN else "")) +
            " $FUN " +
            // TODO refactor this
            (if (extendsType == null) "" else callSignature.stringifyTypeParams(withSpaceAfter = true) + extendsType.toString() + "." ) +
            escapedName +
            callSignature.stringify(withTypeParams = extendsType == null, printUnitReturnType = needsNoImpl, printDefaultValues = !isOverride) +
            if (needsNoImpl) EQ_NO_IMPL else ""
}

class Variable(
        name: String,
        var type: TypeAnnotation,
        val extendsType: Type? = null,
        override var annotations: List<Annotation>,
        val typeParams: List<TypeParam>?,
        val isVar: Boolean,
        val needsNoImpl: Boolean = true,
        val isOverride: Boolean = false,
        val hasOpenModifier: Boolean
) : Member, Node() {

    // TODO is it HACK???
    var _name = name
    override var name: String
        get() = (if (extendsType == null) "" else extendsType.stringify() + ".") + _name
        set(value) { _name = value }

    override fun stringify(): String =
            annotations.stringify() +
            (if (isOverride) OVERRIDE else PUBLIC + (if (hasOpenModifier) " " + OPEN else "")) + " " +
            (if (isVar) VAR else VAL) + " " +
            (typeParams?.join(", ", startWithIfNotEmpty = "<", endWithIfNotEmpty = "> ") ?: "") +
            (if (extendsType == null) "" else extendsType.toString() + "." ) +
            _name.escapeIfNeed() +
            type.stringify(printUnitType = !needsNoImpl) +
            if (needsNoImpl) EQ_NO_IMPL else ""
}

class EnumEntry(override var name: String, val value: String? = null) : Member, Node() {
    override var annotations = listOf<Annotation>()
    override fun stringify(): String = escapedName + if (value == null) "" else " // = $value"
}

class Type(override var name: String, val needParens: Boolean = false) : Named, Node() {
    override fun stringify(): String = "$escapedName" + if (needParens) "()" else ""
}

class TypeParam(override var name: String, val upperBound: String? = null) : Named, Node() {
    override fun stringify(): String = "$escapedName" + if(upperBound == null) "" else " : $upperBound"
}

class TypeAnnotation(
        override var name: String,
        // TODO move to isNullable and isLambda to `Type` class
        val isNullable: Boolean = false,
        val isLambda: Boolean = false,
        val isVararg: Boolean = false
) : Named, Node() {
    override fun stringify(): String = stringify(printUnitType = true)

    fun stringify(printUnitType: Boolean): String {
        if (!printUnitType && isUnit()) return ""

        return  ": " +
                (if (isLambda && isNullable) "(" else "") +
                escapedName +
                (if (isLambda && isNullable) ")" else "") +
                (if (isNullable) "?" else "")
    }

    fun isUnit() = escapedName == UNIT && !isNullable && !isLambda && !isVararg
}
