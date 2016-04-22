package genericsWithConstraint

@native
open class Foo<T : Bar> {
    open var varT: T = noImpl
    open fun withoutArgumentsReturnsT(): T = noImpl
    open fun withOneT(a: T): T = noImpl
    open fun <B : Baz> returnsB(a: Any): B = noImpl
    open fun <A : T, B : B> withManyArguments(a: A, b: B): T = noImpl
}
