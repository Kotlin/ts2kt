package emptyObjectTypeAsAny

@native
var foo: Any = noImpl
@native
interface Foo {
    var boo: Any
}
