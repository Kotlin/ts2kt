package function

external interface Fiber_ {
    var reset: () -> Any
    var run: (param: Any? /*= null*/) -> Any
    var throwInto: (ex: Any) -> Any
}
@JsModule("fibers")
external fun Fiber(fn: Function): Fiber_ = definedExternally
