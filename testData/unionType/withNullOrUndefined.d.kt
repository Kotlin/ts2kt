package withNullOrUndefined

external var foo: String? = noImpl
external var bar: String? = noImpl
external fun bar(a: String?): Foo? = noImpl
external fun baz(a: Foo?, b: Number? = null): Any? = noImpl
external interface `T$0` {
    @nativeGetter
    fun get(key: String?): String?
    @nativeSetter
    fun set(key: String?, value: String?)
}
external open class Foo(a: String?) {
    open fun someMethod(): dynamic /* String | Number | Nothing? */ = noImpl
    open var foo: Foo? = noImpl
    open var optionalFoo: String? = noImpl
    open var optionalFoo2: String? = noImpl
    open var optionalFoo3: String? = noImpl
    open var refs: `T$0` = noImpl
}
external interface IBar {
    fun someMethod(): dynamic /* String | Number | Nothing? */
    var foo: Foo?
    var optionalFoo: String? get() = noImpl; set(value){}
    var optionalFoo2: String? get() = noImpl; set(value){}
    var optionalFoo3: String? get() = noImpl; set(value){}
}
