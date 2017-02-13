package simpleInterface

external interface Foo {
    fun bar(): Number
}

// ------------------------------------------------------------------------------------------
@file:JsQualifier("Foo")
package simpleInterface.Foo

external fun baz(a: Any): Unit = definedExternally
external fun bar(): Number = definedExternally
