package simple

external var foo: dynamic /* String | Number */ = noImpl
external fun bar(a: String): Unit = noImpl
external fun bar(a: Number): Unit = noImpl
external fun bar(a: Foo): Unit = noImpl
external fun baz(a: String, b: Number): Unit = noImpl
external fun baz(a: String, b: Foo): Unit = noImpl
external fun baz(a: Number, b: Number): Unit = noImpl
external fun baz(a: Number, b: Foo): Unit = noImpl
external fun baz(a: Foo, b: Number): Unit = noImpl
external fun baz(a: Foo, b: Foo): Unit = noImpl
external interface `T$0` {
    @nativeGetter
    fun get(key: String): dynamic /* String | Number */
    @nativeSetter
    fun set(key: String, value: String)
    @nativeSetter
    fun set(key: String, value: Number)
}
external open class Foo {
    constructor(a: String)
    constructor(a: Number)
    open fun someMethod(): dynamic /* String | Number */ = noImpl
    open var foo: dynamic /* String | Number */ = noImpl
    open var optionalFoo: dynamic /* String | Number */ = noImpl
    open var refs: `T$0` = noImpl
}
