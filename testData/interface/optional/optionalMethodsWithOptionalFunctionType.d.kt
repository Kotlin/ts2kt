package optionalMethodsWithOptionalFunctionType

external interface Foo {
    val foo: ((f: ((n: Number, s: String) -> String)? = definedExternally /* null */) -> Boolean)? get() = definedExternally
}
