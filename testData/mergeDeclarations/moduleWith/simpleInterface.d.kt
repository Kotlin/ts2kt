package simpleInterface

@module
external interface Foo {
    fun bar(): Number
    companion object {
        fun baz(a: Any): Unit = noImpl
        fun bar(): Number = noImpl
    }
}
