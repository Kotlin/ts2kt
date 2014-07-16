package optionalMethods

native
public trait Foo {
    public val methodWithOutArgs: (() -> Unit)?
    public val methodWithString: ((s: String) -> String)?
    public val methodWithManyArgs: ((n: Number, settings: Bar) -> Boolean)?
}
