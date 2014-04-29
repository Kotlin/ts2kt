package generics

native
public class Foo<T> {
    public var varT: T = noImpl
    public fun withoutArgumentsReturnsT(): T = noImpl
    public fun withOneT(a: T): T = noImpl
    public fun returnsB<B>(a: Any): B = noImpl
    public fun withManyArguments<A, B>(a: A, b: B): T = noImpl
}
