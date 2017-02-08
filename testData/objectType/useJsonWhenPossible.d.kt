package useJsonWhenPossible

external var foo: Json = definedExternally
external interface `T$0` {
    @nativeGetter
    fun get(s: Number): Any?
    @nativeSetter
    fun set(s: Number, value: Any)
}
external interface Foo {
    var foo: Json
    var boo: `T$0`
}

// ------------------------------------------------------------------------------------------
package useJsonWhenPossible.Module

var bar: Json = definedExternally
fun withObjectTypeParam(bar: Json): Unit = definedExternally
open class Foo {
    open var prop: Json = definedExternally
}
