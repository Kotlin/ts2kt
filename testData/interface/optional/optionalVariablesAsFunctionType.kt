package optionalVariablesAsFunctionType

native
public trait Foo {
    public var bar: ((Boolean, Baz) -> Boolean)?
}
