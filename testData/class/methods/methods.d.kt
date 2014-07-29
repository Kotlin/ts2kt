package methods

native
public open class Foo {
    public open fun methodWithOutArgs(): Unit = noImpl
    public open fun methodWithString(s: String): String = noImpl
    public open fun methodWithManyArgs(n: Number, settings: Bar): Boolean = noImpl
}
