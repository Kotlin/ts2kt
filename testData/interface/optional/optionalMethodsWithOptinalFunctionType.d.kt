package optionalMethodsWithOptinalFunctionType

native
public trait Foo {
    public val foo: ((f: ((n: Number, s: String) -> String)? = null) -> Boolean)? = noImpl
}
