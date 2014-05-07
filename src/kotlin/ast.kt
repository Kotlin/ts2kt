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


private val EQ_NO_IMPL = " = noImpl"
private val PUBLIC = "public"
private val VAR = "var"
private val VAL = "val"
private val FUN = "fun"
private val VARARG = "vararg"

private val INDENT = "    "
private val indents = listOf("") as MutableList<String>

fun getIndent(n: Int): String {
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
                lines[i] = indent + lines[i].trim()
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
                    endWithIfNotEmpty = "\n")
}

class Package(val name: String) : Node() {
    override fun stringify(): String = "package $name"
}

trait Named : Node {
    val name: String
}

trait Annotated : Node {
    val annotations: List<Annotation>
}

trait Member : Named, Annotated

class Argument(val name: String, val value: Any /* TODO ??? */) {
    override fun toString() = "$name = $value"
}

class Annotation(override val name: String, val parameters: List<Argument> = listOf()) : Named, Node() {
    override fun stringify(): String = "$name" + if (parameters.isEmpty()) "" else "(${parameters.join()})"
}

enum class ClassKind(val name: String, val bracesAlwaysRequired: Boolean = false) {
    CLASS : ClassKind("class")
    TRAIT : ClassKind("trait")
    OBJECT : ClassKind("object", bracesAlwaysRequired = true)
    CLASS_OBJECT: ClassKind("class object", bracesAlwaysRequired = true)
}

class Classifier(
        val kind: ClassKind,
        override val name: String,
        val paramsOfConstructors: List<List<FunParam>>,
        val typeParams: List<TypeParam>?,
        val parents: List<Type>,
        val members: List<Node>,
        override val annotations: List<Annotation>
) : Member, Node(needsFixIndent = true) {
    override fun stringify(): String =
            annotations.stringify() +
            PUBLIC + " " +
            kind.name +
            (if (name.isEmpty()) "" else " ") +
            name +
            (typeParams?.join(", ", startWithIfNotEmpty = "<", endWithIfNotEmpty = ">") ?: "") +
            (if (paramsOfConstructors.isEmpty()) "" else paramsOfConstructors[0].join(", ", startWithIfNotEmpty = "(", endWithIfNotEmpty = ")")) +
            parents.join(", ", startWithIfNotEmpty = " : ") +
            (if (bracesRequired) " {\n" else "") +
            members.join("\n") +
            (if (bracesRequired) "\n}" else "")

    val bracesRequired = kind.bracesAlwaysRequired || !members.isEmpty()
}

class FunParam(override val name: String, val `type`: TypeAnnotation, val defaultValue: Any? = null, val isVar: Boolean = false) : Named, Node() {
    override fun stringify(): String =
            (if (isVar) "$PUBLIC $VAR " else "") +
            (if (`type`.isVararg) VARARG + " " else "") + name + `type` + if (defaultValue == null) "" else " = $defaultValue"
}

class CallSignature(
        val params: List<FunParam>,
        val typeParams: List<TypeParam>?,
        val returnType: TypeAnnotation
) : Node() {
    override fun stringify(): String =
            (typeParams?.join(startWithIfNotEmpty = "<", endWithIfNotEmpty = ">") ?: "") +
            params.join(start = "(", end = ")") +
            returnType
}

class Function(
        override val name: String,
        val callSignature: CallSignature,
        override val annotations: List<Annotation>,
        val needsNoImpl: Boolean = true
) : Member, Node() {
    override fun stringify(): String =
            annotations.stringify() +
            "$PUBLIC $FUN " +
            name +
            callSignature +
            if (needsNoImpl) EQ_NO_IMPL else ""
}

class Variable(
        override val name: String,
        var `type`: TypeAnnotation,
        override val annotations: List<Annotation>,
        val typeParams: List<TypeParam>?,
        val isVar: Boolean,
        val needsNoImpl: Boolean = true
) : Member {
    override fun stringify(): String =
            annotations.stringify() +
            "$PUBLIC " +
            (if (isVar) VAR else VAL) + " " +
            (typeParams?.join(", ", startWithIfNotEmpty = "<", endWithIfNotEmpty = "> ") ?: "") +
            name +
            `type`.stringify() +
            if (needsNoImpl) EQ_NO_IMPL else ""
}

class Type(override val name: String) : Named {
    override fun stringify(): String = "$name"
}

class TypeParam(override val name: String, val upperBound: String? = null) : Named {
    override fun stringify(): String = "$name" + if(upperBound == null) "" else " : $upperBound"
}

class TypeAnnotation(override val name: String,
                     val isNullable: Boolean = false,
                     val isLambda: Boolean = false,
                     val isVararg: Boolean = false
) : Named {
    override fun stringify(): String =
            ": " +
            (if (isLambda && isNullable) "(" else "") +
            name +
            (if (isLambda && isNullable) ")" else "") +
            (if (isNullable) "?" else "")
}

fun <T> List<T>.stringify() = join("\n", endWithIfNotEmpty = "\n")
