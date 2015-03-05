package callSignature

native
public trait Foo {
    nativeInvoke
    public fun invoke()
    nativeInvoke
    public fun invoke(n: Number): Boolean
    nativeInvoke
    public fun invoke(foo: Foo, s: String): Bar
}
