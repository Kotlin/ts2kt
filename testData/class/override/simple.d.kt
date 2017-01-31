package simple

external open class Foo {
    open fun bar(): Unit = noImpl
    open fun bar(a: Number): Unit = noImpl
    open var baz: Any = noImpl
}
external open class Boo : Foo() {
    override fun bar(): Unit = noImpl
    override fun bar(a: Number): Unit = noImpl
    open fun bar(a: String): Unit = noImpl
    override var baz: Number = noImpl
}
