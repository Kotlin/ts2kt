package optionalMethodsWithOptionalFunctionType

@native
interface Foo {
    val foo: ((f: ((n: Number, s: String) -> String)? = null) -> Boolean)? get() = noImpl
}
