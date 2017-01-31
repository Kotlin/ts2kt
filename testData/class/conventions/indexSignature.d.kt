package indexSignature

external open class Foo {
    @nativeGetter
    open fun get(n: Number): Bar? = definedExternally
    @nativeSetter
    open fun set(n: Number, value: Bar): Unit = definedExternally
    @nativeGetter
    open fun get(s: String): String? = definedExternally
    @nativeSetter
    open fun set(s: String, value: String): Unit = definedExternally
}
