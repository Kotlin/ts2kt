package generics

native
public open class Foo<T> {
    public open var varT: T = noImpl
    public open fun withoutArgumentsReturnsT(): T = noImpl
    public open fun withOneT(a: T): T = noImpl
    public open fun returnsB<B>(a: Any): B = noImpl
    public open fun withManyArguments<A, B>(a: A, b: B): T = noImpl
}
