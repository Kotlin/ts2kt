package inModule

/* ============= */
package inModule.TypeScript.Syntax

public trait IFactory {
    public fun sourceUnit(moduleElements: ISyntaxList, endOfFileToken: ISyntaxToken): SourceUnitSyntax
}
public open class NormalModeFactory : IFactory {
    override fun sourceUnit(moduleElements: ISyntaxList, endOfFileToken: ISyntaxToken): SourceUnitSyntax = noImpl
}
