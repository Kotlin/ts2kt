package indexSignature

native
public open class Foo {
    public open fun get(n: Number): Bar = noImpl
    public open fun set(n: Number, value: Bar): Unit = noImpl
    public open fun get(s: String): String = noImpl
    public open fun set(s: String, value: String): Unit = noImpl
}
