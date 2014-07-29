package genericsWithConstraint

native
public open class Foo<T : Bar> {
    public open var varT: T = noImpl
    public open fun withoutArgumentsReturnsT(): T = noImpl
    public open fun withOneT(a: T): T = noImpl
    public open fun returnsB<B : Baz>(a: Any): B = noImpl
    public open fun withManyArguments<A : T, B : B>(a: A, b: B): T = noImpl
}
