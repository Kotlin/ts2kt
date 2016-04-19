package justOverload

@native
interface Foo {
    fun bar(a: Number)
}
@native
interface Boo : Foo {
    fun bar(a: String)
}
