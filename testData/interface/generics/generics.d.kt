package generics

@native
interface Foo<T> {
    var varT: T
    fun withoutArgumentsReturnsT(): T
    fun withOneT(a: T): T
    fun returnsB<B>(a: Any): B
    fun withManyArguments<A, B>(a: A, b: B): T
}
