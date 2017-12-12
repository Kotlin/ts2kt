@file:JsQualifier("a")
package asTypeAliasInNamespaces.a

external interface I {
    fun foo(): String
}
external fun foo(): a.I = definedExternally
external fun bar(): b.I = definedExternally

// ------------------------------------------------------------------------------------------
@file:JsQualifier("b")
package asTypeAliasInNamespaces.b

external interface I {
    fun foo(): String
}
external fun foo(): b.I = definedExternally
external fun bar(): a.I = definedExternally
