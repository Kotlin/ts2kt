package simpleClass

@module
external open class Foo {
    open fun bar(): Number = noImpl
    companion object {
        fun baz(a: Any): Unit = noImpl
        fun bar(): Number = noImpl
    }
}
