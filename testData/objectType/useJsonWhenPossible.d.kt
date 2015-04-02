[file: nativePackageRoot]
package useJsonWhenPossible

native
public var foo: Json = noImpl
native
public trait `T$0` {
    nativeGetter
    public fun get(s: Number): Any
    nativeSetter
    public fun set(s: Number, value: Any)
}
native
public trait Foo {
    public var foo: Json
    public var boo: `T$0`
}

/* ============= */
[file: nativePackage]
package useJsonWhenPossible.Module

native
public var bar: Json = noImpl
native
public fun withObjectTypeParam(bar: Json): Unit = noImpl
native
public open class Foo {
    public open var prop: Json = noImpl
}
