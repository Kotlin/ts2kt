package indexSignature

native
public trait Foo {
    nativeGetter
    public fun get(n: Number): Bar
    nativeSetter
    public fun set(n: Number, value: Bar)
    nativeGetter
    public fun get(s: String): String
    nativeSetter
    public fun set(s: String, value: String)
}
