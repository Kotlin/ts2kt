package justOverload

@native
open class Foo {
    open fun bar(a: Number): Unit = noImpl
}
@native
open class Boo : Foo() {
    open fun bar(a: String): Unit = noImpl
}
