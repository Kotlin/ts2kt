package useJsonWhenPossible

@native
var foo: Json = noImpl
@module
object Module {
    var bar: Json = noImpl
    fun withObjectTypeParam(bar: Json): Unit = noImpl
    open class Foo {
        open var prop: Json = noImpl
    }
}
@native
interface `T$0` {
    @nativeGetter
    fun get(s: Number): Any?
    @nativeSetter
    fun set(s: Number, value: Any)
}
@native
interface Foo {
    var foo: Json
    var boo: `T$0`
}
