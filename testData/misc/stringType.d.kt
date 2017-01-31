package stringType

external fun foo(s: Any /* "number" */): Number = noImpl
external fun foo(s: Any /* "string" */): String = noImpl
external interface I {
    fun bar(s: Any /* "number" */): Number
    fun bar(s: Any /* "string" */): String
}
external open class C {
    open fun baz(s: Any /* "number" */): Number = noImpl
    open fun baz(s: Any /* "string" */): String = noImpl
}
