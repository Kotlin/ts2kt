package function

external interface Fiber_ {
    var reset: () -> Any
    var run: (param: Any? = null) -> Any
    var throwInto: (ex: Any) -> Any
}
@module("fibers")
fun Fiber(fn: Function): Fiber_ = definedExternally
@module("fibers")
object Fiber {
    var current: Fiber = definedExternally
    fun yield(value: Any? = null): Any = definedExternally
}
