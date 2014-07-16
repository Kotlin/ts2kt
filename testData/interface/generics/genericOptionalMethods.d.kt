package genericOptionalMethods

native
public trait Foo<T> {
    public val methodWithOutArgs: (() -> Unit)? = noImpl
    public val <A> methodWithString: ((s: A) -> T)? = noImpl
    public val <A : T, B> methodWithManyArgs: ((n: A, settings: Bar) -> B)? = noImpl
}
