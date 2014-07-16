package function

native
public trait `T$0` {
    public fun bar(a: Any): Number
    public var baz: Any?
    public var boo: Any?
    public var show: (overrideChecks: Boolean) -> Unit
}
native
public fun withObjectTypeParam(opt: `T$0`): Unit = noImpl
native
public trait `T$1` {
    public fun bar(a: Any): Number
    public var baz: Any?
    public var show: (overrideChecks: Boolean) -> Unit
}
native
public fun returnsObjectType(): `T$1` = noImpl
