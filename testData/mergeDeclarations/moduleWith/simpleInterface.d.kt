package simpleInterface

external interface Foo {
    fun bar(): Number
}

// ------------------------------------------------------------------------------------------
@file:JsQualifier("Foo")
package simpleInterface.Foo

fun baz(a: Any): Unit = definedExternally
fun bar(): Number = definedExternally
