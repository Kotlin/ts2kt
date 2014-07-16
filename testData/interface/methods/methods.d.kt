package methods

native
public trait Foo {
    public fun methodWithOutArgs(): Unit
    public fun methodWithString(s: String): String
    public fun methodWithManyArgs(n: Number, settings: Bar): Boolean
}
