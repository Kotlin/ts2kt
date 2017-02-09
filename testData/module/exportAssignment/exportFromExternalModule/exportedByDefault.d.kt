package exportedByDefault.Boo

fun foo(): String = definedExternally
var bar: Number = definedExternally
interface IBaz {
    fun doSomething()
}
open class Klass {
    open fun method(s: Any): String = definedExternally
}
