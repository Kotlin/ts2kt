package overrideMethodOfParentOfParent

@module
object TypeScript {
    @module
    object Syntax {
        open class EmptySyntaxList : ISyntaxList {
            override fun kind(): SyntaxKind = definedExternally
        }
    }
    interface ISyntaxElement {
        fun kind(): SyntaxKind
    }
    interface ISyntaxList : ISyntaxElement {
        fun childAt(index: Number): ISyntaxNodeOrToken
        fun toArray(): Array<ISyntaxNodeOrToken>
        fun insertChildrenInto(array: Array<ISyntaxElement>, index: Number)
    }
}
