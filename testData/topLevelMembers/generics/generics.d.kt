package generics

@native
fun withoutArgumentsReturnsT<T>(): T = noImpl
@native
fun withOneT<T>(a: T): Any = noImpl
@native
fun returnsT<T>(s: String): T = noImpl
@native
fun withManyArguments<A, B>(a: A, b: B): Boolean = noImpl
@native
var arrayOfAny: Array<Any> = noImpl
@native
var arrayOfArray: Array<Array<String>> = noImpl
@native
var arrayOfList: Array<List<String>> = noImpl
@native
var arrayOfListBySquare: Array<List<Boolean>> = noImpl
@native
var listOfArray: List<Array<Any>> = noImpl
@native
var listOfArrayBySquare: List<Array<Number>> = noImpl
