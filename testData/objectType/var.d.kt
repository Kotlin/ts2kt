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
    nativeInvoke
    public fun invoke(foo: `T$0`): Any
    nativeGetter
    public fun get(s: String): Any
    nativeSetter
    public fun set(s: String, value: Any)
}
native
public var foo: `T$1` = noImpl
