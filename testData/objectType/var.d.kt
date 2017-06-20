package `var`

external interface `T$0` {
    var bar: Number
}
external interface `T$1` {
    fun bar(a: Any): Number
    var baz: Any
    var boo: String
    var show: (overrideChecks: Boolean) -> Unit
    @nativeInvoke
    operator fun invoke(foo: `T$0`): Any
    @nativeGetter
    operator fun get(s: String): Any?
    @nativeSetter
    operator fun set(s: String, value: Any)
}
external var foo: `T$1` = definedExternally
