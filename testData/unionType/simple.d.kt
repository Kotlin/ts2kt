package simple

@native
var foo: dynamic /* String | Number */ = noImpl
@native
fun bar(a: String): Unit = noImpl
@native
fun bar(a: Number): Unit = noImpl
@native
fun bar(a: Foo): Unit = noImpl
@native
fun baz(a: String, b: Number): Unit = noImpl
@native
fun baz(a: String, b: Foo): Unit = noImpl
@native
fun baz(a: Number, b: Number): Unit = noImpl
@native
fun baz(a: Number, b: Foo): Unit = noImpl
@native
fun baz(a: Foo, b: Number): Unit = noImpl
@native
fun baz(a: Foo, b: Foo): Unit = noImpl
@native
open class Foo {
    constructor(a: String)
    constructor(a: Number)
    open var foo: dynamic /* String | Number */ = noImpl
    open var optionalFoo: dynamic /* String | Number */ = noImpl
}
