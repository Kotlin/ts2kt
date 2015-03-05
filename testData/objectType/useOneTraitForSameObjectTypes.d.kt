package useOneTraitForSameObjectTypes

native
public trait `T$0` {
    public fun bar(a: Any): Number
    public var baz: Any
    public var boo: String
    public var show: (overrideChecks: Boolean) -> Unit
    nativeGetter
    public fun get(s: String): Any
    nativeSetter
    public fun set(s: String, value: Any)
}
native
public var foo: `T$0` = noImpl
native
public var bar: `T$0` = noImpl
native
public trait `T$1` {
    public fun bar(a: Any): Number
    public var baz: Any
    public var boo: String
    public var show: (flag: Boolean) -> Unit
    nativeGetter
    public fun get(s: String): Number
    nativeSetter
    public fun set(s: String, value: Number)
}
native
public var baz: `T$1` = noImpl
native
public trait Interface {
    public var bar: `T$0`
    public var baz: `T$1`
}
