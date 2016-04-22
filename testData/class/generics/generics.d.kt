package generics

@native
open class Foo<T> {
    open var varT: T = noImpl
    open fun withoutArgumentsReturnsT(): T = noImpl
    open fun withOneT(a: T): T = noImpl
    open fun <B> returnsB(a: Any): B = noImpl
    open fun <A, B> withManyArguments(a: A, b: B): T = noImpl
}
