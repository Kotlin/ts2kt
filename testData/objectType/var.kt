package var

native
public trait `T$0` {
    public var bar: Number
}
native
public trait `T$1` {
    public fun bar(a: Any): Number
    public var baz: Any
    public var boo: String
    public var show: (overrideChecks: Boolean) -> Unit
    public fun invoke(foo: `T$0`): Any
    public fun get(s: String): Any
    public fun set(s: String, value: Any): Unit
}
native
public var foo: `T$1` = noImpl
