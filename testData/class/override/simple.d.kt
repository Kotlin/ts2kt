package simple

native
public class Foo {
    public fun bar(): Unit = noImpl
    public fun bar(a: Number): Unit = noImpl
    public var baz: Any = noImpl
}
native
public class Boo : Foo() {
    override fun bar(): Unit = noImpl
    override fun bar(a: Number): Unit = noImpl
    public fun bar(a: String): Unit = noImpl
    override var baz: Number = noImpl
}
