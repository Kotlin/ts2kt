package optionalVariablesAsFunctionType

native
public trait Foo {
    public var bar: ((b: Boolean, baz: Any) -> Boolean)?
}
