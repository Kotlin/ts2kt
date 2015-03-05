package indexSignature

native
public open class Foo {
    nativeGetter
    public open fun get(n: Number): Bar = noImpl
    nativeSetter
    public open fun set(n: Number, value: Bar): Unit = noImpl
    nativeGetter
    public open fun get(s: String): String = noImpl
    nativeSetter
    public open fun set(s: String, value: String): Unit = noImpl
}
