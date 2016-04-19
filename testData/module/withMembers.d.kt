package withMembers

@module
object Foo {
    interface A {
        fun baz()
    }
    open class B {
        open fun boo(): Unit = noImpl
    }
    var c: Number = noImpl
    fun d(a: Boolean, b: Any, c: SomeType): Unit = noImpl
}
