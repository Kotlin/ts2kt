package ts2kt

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
        val annotations = defaultAnnotations + additionalAnnotations
        addDeclaration(symbol, KtVariable(KtName(name), KtTypeAnnotation(type), extendsType?.let { KtHeritageType(it) }, annotations, typeParams, isVar = isVar, needsNoImpl = needsNoImpl, isInInterface = isInterface, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier))
    }

    open fun addFunction(symbol: Symbol?, name: String, callSignature: KtCallSignature, extendsType: KtType? = null, needsNoImpl: Boolean = true, additionalAnnotations: List<KtAnnotation> = listOf(), isOverride: Boolean = false, isOperator: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        var actualIsOverride = isOverride
        val overrideCallSignature = if ("hashCode" == name && callSignature.params.isEmpty()) {
            actualIsOverride = true
            //force hashCode to return an Int so it will compile
            callSignature.copy(returnType = callSignature.returnType.copy(type = KtType(INT)))
        } else if ("toString" == name && callSignature.params.isEmpty()) {
            actualIsOverride = true
            //force toString to return a String so it will compile
            callSignature.copy(returnType = callSignature.returnType.copy(type = KtType(STRING)))
        } else if ("equals" == name && callSignature.params.size == 1 && callSignature.params[0].type.type.qualifiedName == ANY) {
            actualIsOverride = true
            callSignature.copy(
                    //force equals to take Any? (instead of Any) so that it overrides
                    params = callSignature.params.map { it.copy(type = it.type.copy(type = KtType(ANY, isNullable = true))) },
                    //force equals to return a Boolean so it will compile
                    returnType = callSignature.returnType.copy(type = KtType(BOOLEAN)))
        } else {
            callSignature
        }
        val heritageType = extendsType?.let { KtHeritageType(it) }
        addDeclaration(symbol, KtFunction(KtName(name), overrideCallSignature, heritageType, annotations, needsNoImpl, actualIsOverride, hasMembersOpenModifier, isOperator))
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
