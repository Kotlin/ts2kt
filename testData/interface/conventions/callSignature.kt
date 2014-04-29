package callSignature

native
public trait Foo {
    public fun invoke(): Unit
    public fun invoke(n: Number): Boolean
    public fun invoke(foo: Foo, s: String): Bar
}
