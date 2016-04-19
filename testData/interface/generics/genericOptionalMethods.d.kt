package genericOptionalMethods

@native
interface Foo<T> {
    val methodWithOutArgs: (() -> Unit)? = noImpl
    val <A> methodWithString: ((s: A) -> T)? = noImpl
    val <A : T, B> methodWithManyArgs: ((n: A, settings: Bar) -> B)? = noImpl
}
