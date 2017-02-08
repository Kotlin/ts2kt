package simpleInterface

external interface Foo {
    fun bar(): Number
}

// ------------------------------------------------------------------------------------------
package simpleInterface.Foo

fun baz(a: Any): Unit = definedExternally
fun bar(): Number = definedExternally
