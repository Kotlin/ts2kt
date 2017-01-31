package withDefaultArgs

external open class Foo {
    open fun bar(a: Number = 1): Unit = noImpl
    open fun baz(a: Any? = null): Unit = noImpl
}
external open class Boo : Foo() {
    override fun bar(a: Number): Unit = noImpl
    override fun baz(a: Any?): Unit = noImpl
}
