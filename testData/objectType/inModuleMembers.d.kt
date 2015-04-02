[file: nativePackageRoot]
package inModuleMembers

/* ============= */
[file: nativePackage]
package inModuleMembers.Foo

native
public trait `T$0` {
    public fun bar(a: Any): Number
    public var baz: Any? = noImpl
    public var boo: Any? = noImpl
    public var show: (overrideChecks: Boolean) -> Unit
}
native
public fun withObjectTypeParam(opt: `T$0`): Unit = noImpl
native
public trait `T$1` {
    public var value: Any? = noImpl
    public var done: Boolean
}
native
public fun returnsObjectType(): `T$1` = noImpl
native
public trait `T$2` {
    public fun bar(a: Any): Number
    public fun baz(a: Any, b: Any, c: String): Boolean
}
native
public var foo: `T$2` = noImpl
