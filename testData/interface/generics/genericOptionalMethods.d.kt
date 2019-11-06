package genericOptionalMethods

external interface Foo<T> {
    val methodWithOutArgs: (() -> Unit)? get() = definedExternally
    val methodWithString: ((s: Any /* A */) -> T)? get() = definedExternally
    val methodWithManyArgs: ((n: T /* A */, settings: Bar) -> Any /* B */)? get() = definedExternally
    val methodWithInOutArg: ((n: T /* A */) -> T /* A */)? get() = definedExternally
}
