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

import ts2kt.utils.listOf
import ts2kt.utils.join
import ts2kt.utils.assert
import ts2kt.utils.trimLeading

val MODULE = "module"
val NATIVE = "native"
val FAKE = "fake"

val FAKE_ANNOTATION = Annotation(FAKE)
val DEFAULT_FAKE_ANNOTATION = listOf(FAKE_ANNOTATION)

private val EQ_NO_IMPL = " = noImpl"
private val PUBLIC = "public"
private val VAR = "var"
private val VAL = "val"
private val FUN = "fun"
private val VARARG = "vararg"

private val INDENT = "    "
private val indents = listOf("") as MutableList<String>

private val takeIfNotAnnotatedAsFake = { (node: Annotated) ->
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
    if (n < indents.size()) return indents[n]

    for (i in indents.size()..n) {
        indents.add(indents[i - 1] + INDENT)
    }

    return indents[n]
}

abstract class Node(val needsFixIndent: Boolean = false) {
    private var cachedToString: String? = null

    abstract fun stringify(): String

    final override fun toString(): String {
        if (cachedToString == null) {
            cachedToString = fixIndention(stringify())
        }
        return cachedToString!!
    }

    private fun fixIndention(s: String): String {
        if (!needsFixIndent) return s

        val lines = s.split("\n")

        var indentIdx = 0
        var indent = getIndent(indentIdx)
        for (i in lines.indices) {
            if (lines[i].endsWith("}")) {

                indent = getIndent(--indentIdx)
            }

            if (!lines[i].isEmpty() && indentIdx != 0) {
                lines[i] = indent + lines[i].trimLeading()
            }

            if (lines[i].endsWith('{')) {
                indent = getIndent(++indentIdx)
            }
        }

        return lines.join("\n")
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

trait Named : Node {
    // TODO: make it immutable
    var name: String
}

trait Annotated : Node {
    // TODO: make it immutable
    var annotations: List<Annotation>
}

trait Member : Named, Annotated

class Argument(val name: String? = null, val value: Any /* TODO ??? */) {
    override fun toString() = (if (name == null) "" else "$name = ") + value
}

class Annotation(override var name: String, val parameters: List<Argument> = listOf()) : Named, Node() {
    override fun stringify(): String = "$name" + if (parameters.isEmpty()) "" else "(${parameters.join()})"
}

enum class ClassKind(val keyword: String, val bracesAlwaysRequired: Boolean = false) {
    CLASS : ClassKind("class")
    TRAIT : ClassKind("trait")
    OBJECT : ClassKind("object", bracesAlwaysRequired = true)
    CLASS_OBJECT: ClassKind("class object", bracesAlwaysRequired = true)
}

class Classifier(
        val kind: ClassKind,
        override var name: String,
        val paramsOfConstructors: List<List<FunParam>>,
        val typeParams: List<TypeParam>?,
        val parents: List<Type>,
        val members: List<Member>,
        override var annotations: List<Annotation>
) : Member, Node(needsFixIndent = true) {
    override fun stringify(): String =
            annotations.stringify() +
            PUBLIC + " " +
            kind.keyword +
            (if (name.isEmpty()) "" else " ") +
            name +
            (typeParams?.join(", ", startWithIfNotEmpty = "<", endWithIfNotEmpty = ">") ?: "") +
            (if (paramsOfConstructors.isEmpty()) "" else paramsOfConstructors[0].join(", ", startWithIfNotEmpty = "(", endWithIfNotEmpty = ")")) +
            parents.join(", ", startWithIfNotEmpty = " : ") +
            (if (bracesRequired) " {\n" else "") +
            members.join("\n", filter = takeIfNotAnnotatedAsFake) +
            (if (bracesRequired) "\n}" else "")

    val bracesRequired = kind.bracesAlwaysRequired || !members.isEmpty()
}

class FunParam(override var name: String, val `type`: TypeAnnotation, val defaultValue: Any? = null, val isVar: Boolean = false) : Named, Node() {
    override fun stringify(): String =
            (if (isVar) "$PUBLIC $VAR " else "") +
            (if (`type`.isVararg) VARARG + " " else "") + name + `type` + if (defaultValue == null) "" else " = $defaultValue"
}

class CallSignature(
        val params: List<FunParam>,
        val typeParams: List<TypeParam>?,
        val returnType: TypeAnnotation
) : Node() {
    override fun stringify(): String = stringify(withTypeParams = true)

    fun stringify(withTypeParams: Boolean): String =
            (if (withTypeParams) stringifyTypeParams() else  "") +
            params.join(start = "(", end = ")") +
            returnType

    fun stringifyTypeParams(withSpaceAfter: Boolean = false) =
            typeParams?.join(startWithIfNotEmpty = "<", endWithIfNotEmpty = ">" + if (withSpaceAfter) " " else "") ?:  ""
}

class Function(
        override var name: String,
        val callSignature: CallSignature,
        val extendsType: Type? = null,
        override var annotations: List<Annotation>,
        val needsNoImpl: Boolean = true
) : Member, Node() {
    override fun stringify(): String =
            annotations.stringify() +
            "$PUBLIC $FUN " +
            // TODO refactor this
            (if (extendsType == null) "" else callSignature.stringifyTypeParams(withSpaceAfter = true) + extendsType.toString() + "." ) +
            name +
            callSignature.stringify(withTypeParams = extendsType == null) +
            if (needsNoImpl) EQ_NO_IMPL else ""
}

class Variable(
        override var name: String,
        var `type`: TypeAnnotation,
        val extendsType: Type? = null,
        override var annotations: List<Annotation>,
        val typeParams: List<TypeParam>?,
        val isVar: Boolean,
        val needsNoImpl: Boolean = true
) : Member {
    override fun stringify(): String =
            annotations.stringify() +
            "$PUBLIC " +
            (if (isVar) VAR else VAL) + " " +
            (typeParams?.join(", ", startWithIfNotEmpty = "<", endWithIfNotEmpty = "> ") ?: "") +
            (if (extendsType == null) "" else extendsType.toString() + "." ) +
            name +
            `type`.stringify() +
            if (needsNoImpl) EQ_NO_IMPL else ""
}

class Type(override var name: String) : Named {
    override fun stringify(): String = "$name"
}

class TypeParam(override var name: String, val upperBound: String? = null) : Named {
    override fun stringify(): String = "$name" + if(upperBound == null) "" else " : $upperBound"
}

class TypeAnnotation(override var name: String,
                     // TODO move to isNullable and isLambda to `Type` class
                     val isNullable: Boolean = false,
                     val isLambda: Boolean = false,
                     val isVararg: Boolean = false
) : Named {
    // TODO: drop this temporary fix of indentation
    override fun stringify(): String {
        val result = stringify_()
        // Add space to the end when results ends with '}' to avoid to detect a wrong indentation
        return result + if (result.endsWith("}")) " " else ""
    }

    fun stringify_(): String =
            ": " +
            (if (isLambda && isNullable) "(" else "") +
            name +
            (if (isLambda && isNullable) ")" else "") +
            (if (isNullable) "?" else "")
}
