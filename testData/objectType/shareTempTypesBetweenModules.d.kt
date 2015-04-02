[file: nativePackageRoot]
package shareTempTypesBetweenModules

native
public trait `T$6` {
    public fun bar(a: Any): Number
    public var baz: Any? = noImpl
    public var boo: Any? = noImpl
    public var show: (overrideChecks: Boolean) -> Unit
}
native
public fun withObjectTypeParam(opt: `T$6`): Unit = noImpl
native
public trait `T$7` {
    public var value: Any? = noImpl
    public var done: Boolean
}
native
public fun returnsObjectType(): `T$7` = noImpl
native
public trait `T$8` {
    public fun bar(a: Any): Number
    public fun baz(a: Any, b: Any, c: String): Boolean
}
native
public var foo: `T$8` = noImpl

/* ============= */
[file: nativePackage]
package shareTempTypesBetweenModules.Foo

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

/* ============= */
[file: nativePackage]
package shareTempTypesBetweenModules.Bar

native
public trait `T$3` {
    public fun bar(a: Any): Number
    public var baz: Any? = noImpl
    public var boo: Any? = noImpl
    public var show: (overrideChecks: Boolean) -> Unit
}
native
public fun someFunction(opt: `T$3`): Unit = noImpl
native
public trait `T$4` {
    public var value: Any? = noImpl
    public var done: Boolean
}
native
public fun anotherReturnsObjectType(): `T$4` = noImpl
native
public trait `T$5` {
    public fun bar(a: Any): Number
    public fun baz(a: Any, b: Any, c: String): Boolean
}
native
public var foo: `T$5` = noImpl
