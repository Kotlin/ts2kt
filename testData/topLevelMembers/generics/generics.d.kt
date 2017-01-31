package generics

external fun <T> withoutArgumentsReturnsT(): T = noImpl
external fun <T> withOneT(a: T): Any = noImpl
external fun <T> returnsT(s: String): T = noImpl
external fun <A, B> withManyArguments(a: A, b: B): Boolean = noImpl
external var arrayOfAny: Array<Any> = noImpl
external var arrayOfArray: Array<Array<String>> = noImpl
external var arrayOfList: Array<List<String>> = noImpl
external var arrayOfListBySquare: Array<List<Boolean>> = noImpl
external var listOfArray: List<Array<Any>> = noImpl
external var listOfArrayBySquare: List<Array<Number>> = noImpl
