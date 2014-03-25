package genericOptionalMethods

native
public trait Foo<T> {
    public val methodWithOutArgs: (() -> Unit)?
    public val <A> methodWithString: ((s: A) -> T)?
    public val <A : T, B> methodWithManyArgs: ((n: A, settings: Bar) -> B)?
}
