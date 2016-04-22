package generics

@native
fun <T> withoutArgumentsReturnsT(): T = noImpl
@native
fun <T> withOneT(a: T): Any = noImpl
@native
fun <T> returnsT(s: String): T = noImpl
@native
fun <A, B> withManyArguments(a: A, b: B): Boolean = noImpl
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
