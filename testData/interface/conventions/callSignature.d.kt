package callSignature

@native
interface Foo {
    @nativeInvoke
    fun invoke()
    @nativeInvoke
    fun invoke(n: Number): Boolean
    @nativeInvoke
    fun invoke(foo: Foo, s: String): Bar
}
