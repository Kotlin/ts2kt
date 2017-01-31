package methods

external open class Foo {
    companion object {
        fun methodWithOutArgs(): Unit = noImpl
        fun methodWithString(s: String): String = noImpl
        fun methodWithManyArgs(n: Number, settings: Bar): Boolean = noImpl
    }
}
