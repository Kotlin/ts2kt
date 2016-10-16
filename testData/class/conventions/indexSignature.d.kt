package indexSignature

@native
open class Foo {
    @nativeGetter
    open fun get(n: Number): Bar? = noImpl
    @nativeSetter
    open fun set(n: Number, value: Bar): Unit = noImpl
    @nativeGetter
    open fun get(s: String): String? = noImpl
    @nativeSetter
    open fun set(s: String, value: String): Unit = noImpl
}
