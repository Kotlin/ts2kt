package simple

native
public trait Foo {
    public fun bar()
    public fun bar(a: Number)
    public var baz: Any
}
native
public trait Boo : Foo {
    override fun bar()
    override fun bar(a: Number)
    public fun bar(a: String)
    override var baz: Number
}
