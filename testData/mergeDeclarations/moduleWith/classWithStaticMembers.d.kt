package classWithStaticMembers

external open class Foo {
    open fun bar(): Number = definedExternally
    companion object {
        var variable: String = definedExternally
        fun bar(): Unit = definedExternally
    }
}

// ------------------------------------------------------------------------------------------
@file:JsQualifier("Foo")
package classWithStaticMembers.Foo

external fun baz(a: Any): Unit = definedExternally
