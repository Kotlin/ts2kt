package indexSignature

@native
interface Foo {
    @nativeGetter
    fun get(n: Number): Bar?
    @nativeSetter
    fun set(n: Number, value: Bar)
    @nativeGetter
    fun get(s: String): String?
    @nativeSetter
    fun set(s: String, value: String)
}
