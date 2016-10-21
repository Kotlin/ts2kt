package aliases

@native
open class Foo
@native
var fooKey: dynamic /* String | Foo | Number */ = noImpl
@native
fun barKey(a: String): Unit = noImpl
@native
fun barKey(a: Foo): Unit = noImpl
@native
fun barKey(a: Number): Unit = noImpl
@native
fun barList(a: List<dynamic /* String | Foo | Number */>): Unit = noImpl
@native
fun barArray(a: Array<dynamic /* String | Foo | Number */>): Unit = noImpl
@native
interface Parent {
    @nativeInvoke
    fun invoke(vararg children: String): Foo
    @nativeInvoke
    fun invoke(vararg children: Foo): Foo
    @nativeInvoke
    fun invoke(vararg children: Number): Foo
}
