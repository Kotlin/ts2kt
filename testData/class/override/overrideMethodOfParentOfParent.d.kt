package overrideMethodOfParentOfParent.TypeScript.Syntax

open class EmptySyntaxList : ISyntaxList {
    override fun kind(): SyntaxKind = definedExternally
}

// ------------------------------------------------------------------------------------------
package overrideMethodOfParentOfParent.TypeScript

interface ISyntaxElement {
    fun kind(): SyntaxKind
}
interface ISyntaxList : ISyntaxElement {
    fun childAt(index: Number): ISyntaxNodeOrToken
    fun toArray(): Array<ISyntaxNodeOrToken>
    fun insertChildrenInto(array: Array<ISyntaxElement>, index: Number)
}
