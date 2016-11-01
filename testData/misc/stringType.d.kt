package stringType

@native
fun foo(s: Any /* "number" */): Number = noImpl
@native
fun foo(s: Any /* "string" */): String = noImpl
@native
interface I {
    fun bar(s: Any /* "number" */): Number
    fun bar(s: Any /* "string" */): String
}
@native
open class C {
    open fun baz(s: Any /* "number" */): Number = noImpl
    open fun baz(s: Any /* "string" */): String = noImpl
}
