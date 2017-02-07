package ts2kt

import ts2kt.kotlin.ast.*
import typescript.TS

abstract class TypeScriptToKotlinBase : Visitor {
    abstract val hasMembersOpenModifier: Boolean
    abstract val isInterface: Boolean

    open val defaultAnnotations: List<Annotation> = listOf()

    val declarations = arrayListOf<Member>()

    open fun addVariable(name: String, type: Type, extendsType: String? = null, typeParams: List<TypeParam>? = null, isVar: Boolean = true, needsNoImpl: Boolean = true, additionalAnnotations: List<Annotation> = listOf(), isOverride: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        declarations.add(Variable(name, TypeAnnotation(type), extendsType?.let { HeritageType(it) }, annotations, typeParams, isVar = isVar, needsNoImpl = needsNoImpl, isInInterface = isInterface, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier))
    }

    open fun addFunction(name: String, callSignature: CallSignature, extendsType: String? = null, needsNoImpl: Boolean = true, additionalAnnotations: List<Annotation> = listOf(), isOverride: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        declarations.add(Function(name, callSignature, extendsType?.let { HeritageType(it) }, annotations, needsNoImpl = needsNoImpl, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier))
    }

    // TODO
    open fun visitList(node: TS.Node) {
        forEachChild(this, node)
    }
}
