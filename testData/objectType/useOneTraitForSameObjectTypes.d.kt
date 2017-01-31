package useOneTraitForSameObjectTypes

external interface `T$0` {
    fun bar(a: Any): Number
    var baz: Any
    var boo: String
    var show: (overrideChecks: Boolean) -> Unit
    @nativeGetter
    fun get(s: String): Any?
    @nativeSetter
    fun set(s: String, value: Any)
}
external var foo: `T$0` = noImpl
external var bar: `T$0` = noImpl
external interface `T$1` {
    fun bar(a: Any): Number
    var baz: Any
    var boo: String
    var show: (flag: Boolean) -> Unit
    @nativeGetter
    fun get(s: String): Number?
    @nativeSetter
    fun set(s: String, value: Number)
}
external var baz: `T$1` = noImpl
external interface Interface {
    var bar: `T$0`
    var baz: `T$1`
}
