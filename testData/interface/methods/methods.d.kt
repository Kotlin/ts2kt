package methods

external interface Foo {
    @native("new")
    fun invoke(n: Number): Bar
    fun methodWithOutArgs()
    fun methodWithString(s: String): String
    fun methodWithManyArgs(n: Number, settings: Bar): Boolean
}

// ------------------------------------------------------------------------------------------
@file:JsQualifier("foo")
package methods.foo

interface Bar {
    fun methodWithString(s: String): String
}
