package optionalVariablesAsFunctionType

@native
interface Foo {
    var bar: ((b: Boolean, baz: Any) -> Boolean)? get() = noImpl; set(value){}
}
