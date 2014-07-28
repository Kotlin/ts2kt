package inModule

module
public object TypeScript {
    public trait ISyntaxElement {
        public fun childAt(index: Number): ISyntaxElement
    }
    public trait ISeparatedSyntaxList : ISyntaxElement {
        override fun childAt(index: Number): ISyntaxNodeOrToken
    }
}
