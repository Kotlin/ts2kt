package optionalMethods

native
public trait Foo {
    public val methodWithOutArgs: (() -> Unit)? = noImpl
    public val methodWithString: ((s: String) -> String)? = noImpl
    public val methodWithManyArgs: ((n: Number, settings: Bar) -> Boolean)? = noImpl
}
