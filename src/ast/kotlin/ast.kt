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

import ts2kt.DYNAMIC
import ts2kt.UNIT

val MODULE = "module"
private val FAKE = "fake"

val FAKE_ANNOTATION = KtAnnotation(FAKE)
val DEFAULT_FAKE_ANNOTATION = listOf(FAKE_ANNOTATION)

internal val isNotAnnotatedAsFake = { node: KtAnnotated ->
    var result = true
    for (a in node.annotations) {
        if (a == FAKE_ANNOTATION) {
            result = false
            break
        }
    }

    result
}


interface KtNode {
    fun accept(visitor: KtVisitor)
}

abstract class AbstractKtNode : KtNode {
    override fun accept(visitor: KtVisitor) {
        visitor.visitNode(this)
    }
}

interface KtWithMembers {
    var members: List<KtMember>
}

class KtPackagePart(
        val fqName: List<String>,
        override var members: List<KtMember>,
        override var annotations: List<KtAnnotation>
) : AbstractKtNode(), KtAnnotated, KtWithMembers {
    override fun accept(visitor: KtVisitor) {
        visitor.visitPackagePart(this)
    }
}

interface KtNamed {
    // TODO: make it immutable
    var name: String
}

interface KtAnnotated {
    // TODO: make it immutable
    var annotations: List<KtAnnotation>
}

interface KtMember : KtNode, KtNamed, KtAnnotated

// TODO should be Named?
// TODO should we escape name here?
data class KtArgument(val value: Any/* TODO Any ??? */, val name: String? = null) : AbstractKtNode() {
    override fun accept(visitor: KtVisitor) {
        visitor.visitArgument(this)
    }
}

data class KtAnnotation(override var name: String, val parameters: List<KtArgument> = listOf()) : KtNamed, AbstractKtNode() {
    override fun accept(visitor: KtVisitor) {
        visitor.visitAnnotation(this)
    }
}

enum class KtClassKind(val keyword: String, val bracesAlwaysRequired: Boolean = false) {
    CLASS("class"),
    INTERFACE("interface"),
    ENUM("enum class"),
    OBJECT("object", bracesAlwaysRequired = true),
    COMPANION_OBJECT("companion object", bracesAlwaysRequired = true)
}

data class KtClassifier(
        val kind: KtClassKind,
        override var name: String,
        val paramsOfConstructors: List<List<KtFunParam>>,
        val typeParams: List<KtTypeParam>?,
        val parents: List<KtHeritageType>,
        override var members: List<KtMember>,
        override var annotations: List<KtAnnotation>,
        val hasOpenModifier: Boolean
) : KtMember, AbstractKtNode(), KtWithMembers {
    override fun accept(visitor: KtVisitor) {
        visitor.visitClassifier(this)
    }
}

data class KtFunParam(
        override var name: String,
        val type: KtTypeAnnotation,
        val defaultValue: Any? = null,
        val isVar: Boolean = false
) : KtNamed, AbstractKtNode() {
    override fun accept(visitor: KtVisitor) {
        visitor.visitFunParam(this)
    }
}

data class KtCallSignature(
        val params: List<KtFunParam>,
        val typeParams: List<KtTypeParam>?,
        val returnType: KtTypeAnnotation
) : AbstractKtNode() {
    override fun accept(visitor: KtVisitor) {
        visitor.visitCallSignature(this)
    }
}

data class KtFunction(
        override var name: String,
        val callSignature: KtCallSignature,
        val extendsType: KtHeritageType? = null,
        override var annotations: List<KtAnnotation> = emptyList(),
        val needsNoImpl: Boolean = true,
        val isOverride: Boolean = false,
        val hasOpenModifier: Boolean = false,
        val isOperator: Boolean = false
) : KtMember, AbstractKtNode() {
    override fun accept(visitor: KtVisitor) {
        visitor.visitFunction(this)
    }
}

data class KtVariable(
        override var name: String,
        var type: KtTypeAnnotation,
        val extendsType: KtHeritageType? = null,
        override var annotations: List<KtAnnotation>,
        val typeParams: List<KtTypeParam>?,
        var isVar: Boolean,
        val needsNoImpl: Boolean = true,
        val isInInterface: Boolean,
        val isOverride: Boolean = false,
        val hasOpenModifier: Boolean
) : KtMember, AbstractKtNode() {
    override fun accept(visitor: KtVisitor) {
        visitor.visitVariable(this)
    }
}

data class KtEnumEntry(override var name: String, val value: String? = null) : KtMember, AbstractKtNode() {
    override var annotations = listOf<KtAnnotation>()

    override fun accept(visitor: KtVisitor) {
        visitor.visitEnumEntry(this)
    }
}

data class KtHeritageType(override var name: String) : KtNamed, AbstractKtNode() {
    override fun accept(visitor: KtVisitor) {
        visitor.visitHeritageType(this)
    }
}

fun KtTypeUnion(vararg possibleTypes: KtType): KtTypeUnion = KtTypeUnion(possibleTypes.toList())

data class KtTypeUnion(val possibleTypes: List<KtType>) : AbstractKtNode() {
    override fun accept(visitor: KtVisitor) {
        visitor.visitTypeUnion(this)
    }

    val singleType: KtType = if (possibleTypes.size == 1) possibleTypes.single() else {
        // TODO should it be `Any`?
        KtType(DYNAMIC, comment = stringify(), isNullable = possibleTypes.first().isNullable)
    }
}

/**
 * A reference to a type such as String or Map<String,List<T>> such as for a variable, function param or return type.
 * @param name the name of the type such as String or Map
 * @param typeArgs the type params such as [String, List<T>], defaulting to empty
 * @param comment a comment about the type, currently used to document intersection types, defaulting to null.
 */
data class KtType(
        override var name: String,
        val typeArgs: List<KtType> = emptyList(),
        val comment: String? = null,
        val isNullable: Boolean = false,
        val callSignature: KtCallSignature? = null
) : KtNamed, AbstractKtNode() {

    override fun accept(visitor: KtVisitor) {
        visitor.visitType(this)
    }

    val isLambda: Boolean get() = callSignature != null

    // TODO make extension function
    fun isUnit() = escapedName == UNIT && !isNullable && !isLambda
}

data class KtTypeParam(override var name: String, val upperBound: KtType? = null) : KtNamed, AbstractKtNode() {
    override fun accept(visitor: KtVisitor) {
        visitor.visitTypeParam(this)
    }

}

data class KtTypeAnnotation(var type: KtType, val isVararg: Boolean = false) : AbstractKtNode() {
    override fun accept(visitor: KtVisitor) {
        visitor.visitTypeAnnotation(this)
    }
}
