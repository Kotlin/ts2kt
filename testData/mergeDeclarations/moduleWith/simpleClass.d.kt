package simpleClass

external open class Foo {
    open fun bar(): Number = definedExternally
}

// ------------------------------------------------------------------------------------------
@file:JsQualifier("Foo")
package simpleClass.Foo

external fun baz(a: Any): Unit = definedExternally
external fun bar(): Number = definedExternally
