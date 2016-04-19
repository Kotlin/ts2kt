package generics

@native
open class Foo<T> {
    open var varT: T = noImpl
    open fun withoutArgumentsReturnsT(): T = noImpl
    open fun withOneT(a: T): T = noImpl
    open fun returnsB<B>(a: Any): B = noImpl
    open fun withManyArguments<A, B>(a: A, b: B): T = noImpl
}
