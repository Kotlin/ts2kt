package genericsWithConstraint

native
public class Foo<T : Bar> {
    public var varT: T = noImpl
    public fun withoutArgumentsReturnsT(): T = noImpl
    public fun withOneT(a: T): T = noImpl
    public fun returnsB<B : Baz>(a: Any): B = noImpl
    public fun withManyArguments<A : T, B : B>(a: A, b: B): T = noImpl
}
