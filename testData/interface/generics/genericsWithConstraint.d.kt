package genericsWithConstraint

@native
interface Foo<T : Bar> {
    var varT: T
    fun withoutArgumentsReturnsT(): T
    fun withOneT(a: T): T
    fun returnsB<B : Baz>(a: Any): B
    fun withManyArguments<A : T, B : B>(a: A, b: B): T
}
