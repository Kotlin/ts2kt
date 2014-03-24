package generics

native
public trait Foo<T> {
    public var varT: T
    public fun withoutArgumentsReturnsT(): T
    public fun withOneT(a: T): T
    public fun returnsB<B>(a: Any): B
    public fun withManyArguments<A, B>(a: A, b: B): T
}
