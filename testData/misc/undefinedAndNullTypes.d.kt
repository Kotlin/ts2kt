package undefinedAndNullTypes

@native
fun foo(a: Nothing?): Nothing? = noImpl
@native
fun bar(a: Nothing?): Nothing? = noImpl
@native
interface I {
    fun foo(a: Nothing?): Nothing?
    fun bar(a: Nothing?): Nothing?
}
@native
open class C {
    open fun foo(a: Nothing?): Nothing? = noImpl
    open fun bar(a: Nothing?): Nothing? = noImpl
}
