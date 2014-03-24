package genericsWithConstraint

native
public trait Foo<T : Bar> {
    public var varT: T
    public fun withoutArgumentsReturnsT(): T
    public fun withOneT(a: T): T
    public fun returnsB<B : Baz>(a: Any): B
    public fun withManyArguments<A : T, B : B>(a: A, b: B): T
}
