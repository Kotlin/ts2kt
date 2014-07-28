package justOverload

native
public trait Foo {
    public fun bar(a: Number)
}
native
public trait Boo : Foo {
    public fun bar(a: String)
}
