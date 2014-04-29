package indexSignature

native
public class Foo {
    public fun get(n: Number): Bar = noImpl
    public fun set(n: Number, value: Bar): Unit = noImpl
    public fun get(s: String): String = noImpl
    public fun set(s: String, value: String): Unit = noImpl
}
