package aliases

external open class Foo
external var fooKey: dynamic /* String | Foo | Number */ = noImpl
external fun barKey(a: String): Unit = noImpl
external fun barKey(a: Foo): Unit = noImpl
external fun barKey(a: Number): Unit = noImpl
external fun barList(a: List<dynamic /* String | Foo | Number */>): Unit = noImpl
external fun barArray(a: Array<dynamic /* String | Foo | Number */>): Unit = noImpl
external interface Parent {
    @nativeInvoke
    fun invoke(vararg children: String): Foo
    @nativeInvoke
    fun invoke(vararg children: Foo): Foo
    @nativeInvoke
    fun invoke(vararg children: Number): Foo
}
