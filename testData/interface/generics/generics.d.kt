package generics

@native
interface Foo<T> {
    var varT: T
    fun withoutArgumentsReturnsT(): T
    fun withOneT(a: T): T
    fun <B> returnsB(a: Any): B
    fun <A, B> withManyArguments(a: A, b: B): T
}
