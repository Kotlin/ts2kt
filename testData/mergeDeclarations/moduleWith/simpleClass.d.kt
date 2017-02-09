package simpleClass

external open class Foo {
    open fun bar(): Number = definedExternally
}

// ------------------------------------------------------------------------------------------
@file:JsQualifier("Foo")
package simpleClass.Foo

fun baz(a: Any): Unit = definedExternally
fun bar(): Number = definedExternally
