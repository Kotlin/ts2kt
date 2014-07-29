package justOverload

native
public open class Foo {
    public open fun bar(a: Number): Unit = noImpl
}
native
public open class Boo : Foo() {
    public open fun bar(a: String): Unit = noImpl
}
