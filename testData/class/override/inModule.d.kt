[file: nativePackageRoot]
package inModule

/* ============= */
[file: nativePackage]
package inModule.TypeScript.Syntax

native
public trait IFactory {
    public fun sourceUnit(moduleElements: ISyntaxList, endOfFileToken: ISyntaxToken): SourceUnitSyntax
}
native
public open class NormalModeFactory : IFactory {
    override fun sourceUnit(moduleElements: ISyntaxList, endOfFileToken: ISyntaxToken): SourceUnitSyntax = noImpl
}
