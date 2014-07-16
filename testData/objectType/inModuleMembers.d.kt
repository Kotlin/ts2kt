package inModuleMembers

native
public trait `T$0` {
    public fun bar(a: Any): Number
    public var baz: Any? = noImpl
    public var boo: Any? = noImpl
    public var show: (overrideChecks: Boolean) -> Unit
}
native
public trait `T$1` {
    public var value: Any? = noImpl
    public var done: Boolean
}
native
public trait `T$2` {
    public fun bar(a: Any): Number
    public fun baz(a: Any, b: Any, c: String): Boolean
}
module
public object Foo {
    public fun withObjectTypeParam(opt: `T$0`): Unit = noImpl
    public fun returnsObjectType(): `T$1` = noImpl
    public var foo: `T$2` = noImpl
}
