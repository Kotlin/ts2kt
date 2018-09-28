package ts2kt

import ts2kt.kotlin.ast.*
import typescriptServices.ts.ImportEqualsDeclaration
import typescriptServices.ts.Node
import typescriptServices.ts.Symbol
import typescriptServices.ts.SyntaxKind

abstract class TypeScriptToKotlinBase(
        val declarations: MutableList<KtMember>,
        val declarationsBySymbol: MutableMap<Symbol, MutableList<KtMember>>
) : Visitor {
    abstract val hasMembersOpenModifier: Boolean
    abstract val isInterface: Boolean
    abstract val isAbstract: Boolean

    open val defaultAnnotations: List<KtAnnotation> = listOf()

    open fun addVariable(symbol: Symbol?, name: String, type: KtType, extendsType: KtType? = null, typeParams: List<KtTypeParam>? = null, isVar: Boolean = true, isAbstract: Boolean = false, needsNoImpl: Boolean = !isAbstract, additionalAnnotations: List<KtAnnotation> = listOf(), isOverride: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        addDeclaration(symbol, KtVariable(KtName(name), KtTypeAnnotation(type), extendsType?.let { KtHeritageType(it) }, annotations, typeParams, isVar = isVar, needsNoImpl = needsNoImpl, isInInterface = isInterface, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier && !isAbstract, isAbstract = isAbstract))
    }

    open fun addFunction(symbol: Symbol?, name: String, callSignature: KtCallSignature, extendsType: KtType? = null, needsNoImpl: Boolean = true, additionalAnnotations: List<KtAnnotation> = listOf(), isOverride: Boolean = false, isOperator: Boolean = false, isAbstract: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        addDeclaration(symbol, KtFunction(KtName(name), callSignature, extendsType?.let { KtHeritageType(it) }, annotations, needsNoImpl = needsNoImpl, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier && !isAbstract, isOperator = isOperator, isAbstract = isAbstract))
    }

    protected fun addDeclaration(symbol: Symbol?, declaration: KtMember) {
        declarations += declaration
        if (symbol != null) {
            val values = declarationsBySymbol.getOrPut(symbol) { mutableListOf() }
            values += declaration
        }
    }

    fun isAbstract(node: Node): Boolean {
        return node.modifiers?.arr?.any { it.kind == SyntaxKind.AbstractKeyword } == true
    }

    fun isReadonly(node: Node): Boolean {
        return node.modifiers?.arr?.any { it.kind == SyntaxKind.ReadonlyKeyword } == true
    }

    // TODO
    open fun visitList(node: typescriptServices.ts.Node) {
        forEachChild(this, node)
    }

    override fun visitImportEqualsDeclaration(node: ImportEqualsDeclaration) {
    }
}
