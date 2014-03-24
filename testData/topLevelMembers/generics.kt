package generics

native
public fun withoutArgumentsReturnsT<T>(): T = noImpl
native
public fun withOneT<T>(a: T): Any = noImpl
native
public fun returnsT<T>(s: String): T = noImpl
native
public fun withManyArguments<A, B>(a: A, b: B): Boolean = noImpl
