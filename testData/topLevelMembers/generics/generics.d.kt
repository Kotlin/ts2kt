package generics

native
public fun withoutArgumentsReturnsT<T>(): T = noImpl
native
public fun withOneT<T>(a: T): Any = noImpl
native
public fun returnsT<T>(s: String): T = noImpl
native
public fun withManyArguments<A, B>(a: A, b: B): Boolean = noImpl
native
public var arrayOfAny: Array<Any> = noImpl
native
public var arrayOfArray: Array<Array<String>> = noImpl
native
public var arrayOfList: Array<List<String>> = noImpl
native
public var arrayOfListBySquare: Array<List<Boolean>> = noImpl
native
public var listOfArray: List<Array<Any>> = noImpl
native
public var listOfArrayBySquare: List<Array<Number>> = noImpl
