package optionalMethods

@native
interface Foo {
    val methodWithOutArgs: (() -> Unit)? = noImpl
    val methodWithString: ((s: String) -> String)? = noImpl
    val methodWithManyArgs: ((n: Number, settings: Bar) -> Boolean)? = noImpl
}
