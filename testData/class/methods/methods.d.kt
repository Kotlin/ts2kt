package methods

external open class Foo {
    open fun methodWithOutArgs(): Unit = noImpl
    open fun methodWithString(s: String): String = noImpl
    open fun methodWithManyArgs(n: Number, settings: Bar): Boolean = noImpl
}
