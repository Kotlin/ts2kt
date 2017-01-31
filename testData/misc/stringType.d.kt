package stringType

external fun foo(s: Any /* "number" */): Number = definedExternally
external fun foo(s: Any /* "string" */): String = definedExternally
external interface I {
    fun bar(s: Any /* "number" */): Number
    fun bar(s: Any /* "string" */): String
}
external open class C {
    open fun baz(s: Any /* "number" */): Number = definedExternally
    open fun baz(s: Any /* "string" */): String = definedExternally
}
