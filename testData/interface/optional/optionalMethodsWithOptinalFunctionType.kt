package optionalMethodsWithOptinalFunctionType

native
public trait Foo {
    public val foo: ((f: ((Number, String) -> String)? = null) -> Boolean)?
}
