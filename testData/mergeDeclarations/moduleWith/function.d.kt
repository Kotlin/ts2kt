package function

external interface Fiber_ {
    var reset: () -> Any
    var run: (param: Any? = definedExternally /* null */) -> Any
    var throwInto: (ex: Any) -> Any
}
@module("fibers")
fun Fiber(fn: Function): Fiber_ = definedExternally
