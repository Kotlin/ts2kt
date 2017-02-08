package simpleClass

external open class Foo {
    open fun bar(): Number = definedExternally
}

// ------------------------------------------------------------------------------------------
package simpleClass.Foo

fun baz(a: Any): Unit = definedExternally
fun bar(): Number = definedExternally
