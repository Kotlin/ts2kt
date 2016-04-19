package genericsWithConstraint

@native
open class Foo<T : Bar> {
    open var varT: T = noImpl
    open fun withoutArgumentsReturnsT(): T = noImpl
    open fun withOneT(a: T): T = noImpl
    open fun returnsB<B : Baz>(a: Any): B = noImpl
    open fun withManyArguments<A : T, B : B>(a: A, b: B): T = noImpl
}
