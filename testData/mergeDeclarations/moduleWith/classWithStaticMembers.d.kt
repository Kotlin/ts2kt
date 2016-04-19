package classWithStaticMembers

@native
@module
open class Foo {
    open fun bar(): Number = noImpl
    companion object {
        var variable: String = noImpl
        fun bar(): Unit = noImpl
        fun baz(a: Any): Unit = noImpl
    }
}
