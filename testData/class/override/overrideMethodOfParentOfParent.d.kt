[file: nativePackageRoot]
package overrideMethodOfParentOfParent

/* ============= */
[file: nativePackage]
package overrideMethodOfParentOfParent.TypeScript

native
public trait ISyntaxElement {
    public fun kind(): SyntaxKind
}
native
public trait ISyntaxList : ISyntaxElement {
    public fun childAt(index: Number): ISyntaxNodeOrToken
    public fun toArray(): Array<ISyntaxNodeOrToken>
    public fun insertChildrenInto(array: Array<ISyntaxElement>, index: Number)
}

/* ============= */
[file: nativePackage]
package overrideMethodOfParentOfParent.TypeScript.Syntax

native
public open class EmptySyntaxList : ISyntaxList {
    override fun kind(): SyntaxKind = noImpl
}
