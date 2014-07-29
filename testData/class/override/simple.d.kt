package simple

native
public open class Foo {
    public open fun bar(): Unit = noImpl
    public open fun bar(a: Number): Unit = noImpl
    public open var baz: Any = noImpl
}
native
public open class Boo : Foo() {
    override fun bar(): Unit = noImpl
    override fun bar(a: Number): Unit = noImpl
    public open fun bar(a: String): Unit = noImpl
    override var baz: Number = noImpl
}
