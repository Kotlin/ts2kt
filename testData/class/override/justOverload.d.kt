package justOverload

external open class Foo {
    open fun bar(a: Number): Unit = noImpl
}
external open class Boo : Foo() {
    open fun bar(a: String): Unit = noImpl
}
