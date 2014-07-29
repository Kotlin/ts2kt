package overrideMethodOfParentOfParent

module
public object TypeScript {
    module
    public object Syntax {
        public open class EmptySyntaxList : ISyntaxList {
            override fun kind(): SyntaxKind = noImpl
        }
    }
    public trait ISyntaxElement {
        public fun kind(): SyntaxKind
    }
    public trait ISyntaxList : ISyntaxElement {
        public fun childAt(index: Number): ISyntaxNodeOrToken
        public fun toArray(): Array<ISyntaxNodeOrToken>
        public fun insertChildrenInto(array: Array<ISyntaxElement>, index: Number)
    }
}
