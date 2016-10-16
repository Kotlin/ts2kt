package useOneTraitForSameObjectTypes

@native
interface `T$0` {
    fun bar(a: Any): Number
    var baz: Any
    var boo: String
    var show: (overrideChecks: Boolean) -> Unit
    @nativeGetter
    fun get(s: String): Any?
    @nativeSetter
    fun set(s: String, value: Any)
}
@native
var foo: `T$0` = noImpl
@native
var bar: `T$0` = noImpl
@native
interface `T$1` {
    fun bar(a: Any): Number
    var baz: Any
    var boo: String
    var show: (flag: Boolean) -> Unit
    @nativeGetter
    fun get(s: String): Number?
    @nativeSetter
    fun set(s: String, value: Number)
}
@native
var baz: `T$1` = noImpl
@native
interface Interface {
    var bar: `T$0`
    var baz: `T$1`
}
