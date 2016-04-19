package optionalMethodsWithOptinalFunctionType

@native
interface Foo {
    val foo: ((f: ((n: Number, s: String) -> String)? = null) -> Boolean)? = noImpl
}
