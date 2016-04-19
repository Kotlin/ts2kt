package nestedModules

@module
object Foo {
    @module
    object Bar {
        interface A {
            fun baz()
        }
        open class B {
            open fun boo(): Unit = noImpl
        }
        var c: Number = noImpl
        fun d(a: Boolean, b: Any, c: SomeType): Unit = noImpl
    }
}
