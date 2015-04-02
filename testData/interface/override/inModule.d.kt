[file: nativePackageRoot]
package inModule

/* ============= */
[file: nativePackage]
package inModule.TypeScript

native
public trait ISyntaxElement {
    public fun childAt(index: Number): ISyntaxElement
}
native
public trait ISeparatedSyntaxList : ISyntaxElement {
    override fun childAt(index: Number): ISyntaxNodeOrToken
}
