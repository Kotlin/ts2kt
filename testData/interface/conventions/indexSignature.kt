package indexSignature

native
public trait Foo {
    public fun get(n: Number): Bar
    public fun set(n: Number, value: Bar): Unit
    public fun get(s: String): String
    public fun set(s: String, value: String): Unit
}
