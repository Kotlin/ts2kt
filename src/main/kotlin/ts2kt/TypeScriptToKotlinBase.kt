package ts2kt

import converter.replaceTypeParameters
import ts2kt.kotlin.ast.*
import typescriptServices.ts.ImportEqualsDeclaration
import typescriptServices.ts.Symbol

abstract class TypeScriptToKotlinBase(
        val declarations: MutableList<KtMember>,
        val declarationsBySymbol: MutableMap<Symbol, MutableList<KtMember>>
) : Visitor {
    abstract val hasMembersOpenModifier: Boolean
    abstract val isInterface: Boolean

    open val defaultAnnotations: List<KtAnnotation> = listOf()

    open fun addVariable(symbol: Symbol?, name: String, type: KtType, extendsType: KtType? = null, typeParams: List<KtTypeParam>? = null, isVar: Boolean = true, needsNoImpl: Boolean = true, additionalAnnotations: List<KtAnnotation> = listOf(), isOverride: Boolean = false) {
        val (typeParamsToKeep, typeParamsToReplace) = (typeParams ?: emptyList()).partition {
            typeParam -> extendsType?.typeArgs?.any { it.qualifiedName.name == typeParam.name } ?: false
        }
        val substitution = typeParamsToReplace.map { it.name.value to (it.upperBound ?: KtType(ANY)).copy(comment = it.name.value) }.toMap()

        val annotations = defaultAnnotations + additionalAnnotations
        addDeclaration(symbol, KtVariable(KtName(name), KtTypeAnnotation(type.replaceTypeParameters(substitution)), extendsType?.let { KtHeritageType(it) }, annotations, typeParamsToKeep, isVar = isVar, needsNoImpl = needsNoImpl, isInInterface = isInterface, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier))
    }

    open fun addFunction(symbol: Symbol?, name: String, callSignature: KtCallSignature, extendsType: KtType? = null, needsNoImpl: Boolean = true, additionalAnnotations: List<KtAnnotation> = listOf(), isOverride: Boolean = false, isOperator: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        addDeclaration(symbol, KtFunction(KtName(name), callSignature, extendsType?.let { KtHeritageType(it) }, annotations, needsNoImpl = needsNoImpl, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier, isOperator = isOperator))
    }

    protected fun addDeclaration(symbol: Symbol?, declaration: KtMember) {
        declarations += declaration
        if (symbol != null) {
            val values = declarationsBySymbol.getOrPut(symbol) { mutableListOf() }
            values += declaration
        }
    }

    // TODO
    open fun visitList(node: typescriptServices.ts.Node) {
        forEachChild(this, node)
    }

    override fun visitImportEqualsDeclaration(node: ImportEqualsDeclaration) {
    }
}
