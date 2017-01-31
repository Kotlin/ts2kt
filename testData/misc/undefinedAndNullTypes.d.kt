package undefinedAndNullTypes

external fun foo(a: Nothing?): Nothing? = noImpl
external fun bar(a: Nothing?): Nothing? = noImpl
external interface I {
    fun foo(a: Nothing?): Nothing?
    fun bar(a: Nothing?): Nothing?
}
external open class C {
    open fun foo(a: Nothing?): Nothing? = noImpl
    open fun bar(a: Nothing?): Nothing? = noImpl
}
