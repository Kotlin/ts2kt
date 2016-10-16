package optionalMethods

@native
interface Foo {
    val methodWithOutArgs: (() -> Unit)? get() = noImpl
    val methodWithString: ((s: String) -> String)? get() = noImpl
    val methodWithManyArgs: ((n: Number, settings: Bar) -> Boolean)? get() = noImpl
}
