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

val FAKE_ANNOTATION = Annotation(FAKE)
val DEFAULT_FAKE_ANNOTATION = listOf(FAKE_ANNOTATION)

internal val takeIfNotAnnotatedAsFake = { node: Annotated ->
    var result = true
    for (a in node.annotations) {
        if (a == FAKE_ANNOTATION) {
            result = false
            break
        }
    }

    result
}


interface Node {
    fun accept(visitor: Visitor)
}

abstract class AbstractNode : Node {
    override fun accept(visitor: Visitor) {
        visitor.visitNode(this)
    }

    final override fun toString(): String {
        return Stringify().also { this.accept(it) }.result
    }
}

class PackagePart(val fqName: String?, val members: List<Member>) : AbstractNode() {
    override fun accept(visitor: Visitor) {
        visitor.visitPackage(this)
    }
}

interface Named {
    // TODO: make it immutable
    var name: String
}

interface Annotated {
    // TODO: make it immutable
    var annotations: List<Annotation>
}

interface Member : Node, Named, Annotated

// TODO should be Named?
// TODO should we escape name here?
class Argument(val name: String? = null, val value: Any /* TODO ??? */) : AbstractNode() {
    override fun accept(visitor: Visitor) {
        visitor.visitArgument(this)
    }
}

class Annotation(override var name: String, val parameters: List<Argument> = listOf()) : Named, AbstractNode() {
    override fun accept(visitor: Visitor) {
        visitor.visitAnnotation(this)
    }
}

enum class ClassKind(val keyword: String, val bracesAlwaysRequired: Boolean = false) {
    CLASS("class"),
    INTERFACE("interface"),
    ENUM("enum class"),
    OBJECT("object", bracesAlwaysRequired = true),
    COMPANION_OBJECT("companion object", bracesAlwaysRequired = true)
}

class Classifier(
        val kind: ClassKind,
        override var name: String,
        val paramsOfConstructors: List<List<FunParam>>,
        val typeParams: List<TypeParam>?,
        val parents: List<HeritageType>,
        val members: List<Member>,
        override var annotations: List<Annotation>,
        val hasOpenModifier: Boolean
) : Member, AbstractNode() {
    override fun accept(visitor: Visitor) {
        visitor.visitClassifier(this)
    }
}

class FunParam(
        override var name: String,
        val type: TypeAnnotation,
        val defaultValue: Any? = null,
        val isVar: Boolean = false
) : Named, AbstractNode() {
    override fun accept(visitor: Visitor) {
        visitor.visitFunParam(this)
    }
}

class CallSignature(
        val params: List<FunParam>,
        val typeParams: List<TypeParam>?,
        val returnType: TypeAnnotation
) : AbstractNode() {
    override fun accept(visitor: Visitor) {
        visitor.visitCallSignature(this)
    }
}

class Function(
        override var name: String,
        val callSignature: CallSignature,
        val extendsType: HeritageType? = null,
        override var annotations: List<Annotation>,
        val needsNoImpl: Boolean = true,
        val isOverride: Boolean = false,
        val hasOpenModifier: Boolean
) : Member, AbstractNode() {
    override fun accept(visitor: Visitor) {
        visitor.visitFunction(this)
    }
}

class Variable(
        name: String,
        var type: TypeAnnotation,
        val extendsType: HeritageType? = null,
        override var annotations: List<Annotation>,
        val typeParams: List<TypeParam>?,
        val isVar: Boolean,
        val needsNoImpl: Boolean = true,
        val isInInterface: Boolean,
        val isOverride: Boolean = false,
        val hasOpenModifier: Boolean
) : Member, AbstractNode() {

    // TODO is it HACK???
    var _name = name
    override var name: String
        get() = (if (extendsType == null) "" else extendsType.toString() + ".") + _name
        set(value) { _name = value }

    override fun accept(visitor: Visitor) {
        visitor.visitVariable(this)
    }
}

class EnumEntry(override var name: String, val value: String? = null) : Member, AbstractNode() {
    override var annotations = listOf<Annotation>()

    override fun accept(visitor: Visitor) {
        visitor.visitEnumEntry(this)
    }
}

class HeritageType(override var name: String) : Named, AbstractNode() {
    override fun accept(visitor: Visitor) {
        visitor.visitHeritageType(this)
    }
}

fun TypeUnion(vararg possibleTypes: Type): TypeUnion = TypeUnion(possibleTypes.toList())

data class TypeUnion(val possibleTypes: List<Type>) : AbstractNode() {
    override fun accept(visitor: Visitor) {
        visitor.visitTypeUnion(this)
    }

    val singleType: Type = if (possibleTypes.size == 1) possibleTypes.single() else {
        // TODO should it be `Any`?
        Type(DYNAMIC, comment = toString(), isNullable = possibleTypes.first().isNullable)
    }
}

/**
 * A reference to a type such as String or Map<String,List<T>> such as for a variable, function param or return type.
 * @param name the name of the type such as String or Map
 * @param typeArgs the type params such as [String, List<T>], defaulting to empty
 * @param comment a comment about the type, currently used to document intersection types, defaulting to null.
 */
data class Type(
        override var name: String,
        val typeArgs: List<Type> = emptyList(),
        val comment: String? = null,
        val isNullable: Boolean = false,
        val isLambda: Boolean = false
) : Named, AbstractNode() {

    override fun accept(visitor: Visitor) {
        visitor.visitType(this)
    }

    // TODO make extension function
    fun isUnit() = escapedName == UNIT && !isNullable && !isLambda
}

class TypeParam(override var name: String, val upperBound: Type? = null) : Named, AbstractNode() {
    override fun accept(visitor: Visitor) {
        visitor.visitTypeParam(this)
    }
}

/** A Kotlin representation as in: typealias name<typeParams> = actualTypeUnionUsingAliasParams */
data class TypeAlias(val name: String, val typeParams: List<TypeParam>? = null, val actualTypeUnionUsingAliasParams: TypeUnion)

fun TypeAlias(name: String, typeParams: List<TypeParam>? = null, actualTypeUsingAliasParams: Type): TypeAlias {
    return TypeAlias(name, typeParams, TypeUnion(actualTypeUsingAliasParams))
}

class TypeAnnotation(var type: Type, val isVararg: Boolean = false) : AbstractNode() {
    override fun accept(visitor: Visitor) {
        visitor.visitTypeAnnotation(this)
    }
}
