package overrideMethodOfParentOfParent

/* ============= */
package overrideMethodOfParentOfParent.TypeScript

public trait ISyntaxElement {
    public fun kind(): SyntaxKind
}
public trait ISyntaxList : ISyntaxElement {
    public fun childAt(index: Number): ISyntaxNodeOrToken
    public fun toArray(): Array<ISyntaxNodeOrToken>
    public fun insertChildrenInto(array: Array<ISyntaxElement>, index: Number)
}

/* ============= */
package overrideMethodOfParentOfParent.TypeScript.Syntax

public open class EmptySyntaxList : ISyntaxList {
    override fun kind(): SyntaxKind = noImpl
}
