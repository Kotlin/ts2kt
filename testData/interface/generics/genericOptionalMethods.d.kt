package genericOptionalMethods

@native
interface Foo<T> {
    val methodWithOutArgs: (() -> Unit)? get() = noImpl
    val <A> methodWithString: ((s: A) -> T)? get() = noImpl
    val <A : T, B> methodWithManyArgs: ((n: A, settings: Bar) -> B)? get() = noImpl
}
