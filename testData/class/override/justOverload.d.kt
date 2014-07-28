package justOverload

native
public class Foo {
    public fun bar(a: Number): Unit = noImpl
}
native
public class Boo : Foo() {
    public fun bar(a: String): Unit = noImpl
}
