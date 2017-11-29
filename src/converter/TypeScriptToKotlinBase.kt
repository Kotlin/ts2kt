package ts2kt

import ts2kt.kotlin.ast.*
import typescriptServices.ts.ImportEqualsDeclaration

abstract class TypeScriptToKotlinBase(val declarations: MutableList<KtMember>) : Visitor {
    abstract val hasMembersOpenModifier: Boolean
    abstract val isInterface: Boolean

    open val defaultAnnotations: List<KtAnnotation> = listOf()

    open fun addVariable(name: String, type: KtType, extendsType: String? = null, typeParams: List<KtTypeParam>? = null, isVar: Boolean = true, needsNoImpl: Boolean = true, additionalAnnotations: List<KtAnnotation> = listOf(), isOverride: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        declarations.add(KtVariable(name, KtTypeAnnotation(type), extendsType?.let { KtHeritageType(it) }, annotations, typeParams, isVar = isVar, needsNoImpl = needsNoImpl, isInInterface = isInterface, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier))
    }

    open fun addFunction(name: String, callSignature: KtCallSignature, extendsType: String? = null, needsNoImpl: Boolean = true, additionalAnnotations: List<KtAnnotation> = listOf(), isOverride: Boolean = false, isOperator: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        declarations.add(KtFunction(name, callSignature, extendsType?.let { KtHeritageType(it) }, annotations, needsNoImpl = needsNoImpl, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier, isOperator = isOperator))
    }

    // TODO
    open fun visitList(node: typescriptServices.ts.Node) {
        forEachChild(this, node)
    }

    override fun visitImportEqualsDeclaration(node: ImportEqualsDeclaration) {
    }
}
