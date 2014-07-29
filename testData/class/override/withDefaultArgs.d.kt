package withDefaultArgs

native
public open class Foo {
    public open fun bar(a: Number = 1): Unit = noImpl
    public open fun baz(a: Any? = null): Unit = noImpl
}
native
public open class Boo : Foo() {
    override fun bar(a: Number): Unit = noImpl
    override fun baz(a: Any?): Unit = noImpl
}
