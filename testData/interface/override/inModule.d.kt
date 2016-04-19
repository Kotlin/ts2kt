package inModule

@module
object TypeScript {
    interface ISyntaxElement {
        fun childAt(index: Number): ISyntaxElement
    }
    interface ISeparatedSyntaxList : ISyntaxElement {
        override fun childAt(index: Number): ISeparatedSyntaxList
    }
}
