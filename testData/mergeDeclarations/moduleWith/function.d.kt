package function

external interface Fiber_ {
    var reset: () -> Any
    var run: (param: Any? = null) -> Any
    var throwInto: (ex: Any) -> Any
}
@module("fibers")
fun Fiber(fn: Function): Fiber_ = noImpl
@module("fibers")
object Fiber {
    var current: Fiber = noImpl
    fun yield(value: Any? = null): Any = noImpl
}
