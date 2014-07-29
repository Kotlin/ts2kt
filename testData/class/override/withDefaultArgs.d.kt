package withDefaultArgs

native
public class Foo {
    public fun bar(a: Number = 1): Unit = noImpl
    public fun baz(a: Any? = null): Unit = noImpl
}
native
public class Boo : Foo() {
    override fun bar(a: Number): Unit = noImpl
    override fun baz(a: Any?): Unit = noImpl
}
