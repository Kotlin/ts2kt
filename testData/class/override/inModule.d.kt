package inModule


// ------------------------------------------------------------------------------------------
package inModule.TypeScript.Syntax

interface IFactory {
    fun sourceUnit(moduleElements: ISyntaxList, endOfFileToken: ISyntaxToken): SourceUnitSyntax
}
open class NormalModeFactory : IFactory {
    override fun sourceUnit(moduleElements: ISyntaxList, endOfFileToken: ISyntaxToken): SourceUnitSyntax = definedExternally
}
