package functionAndSecondaryWithTrait

external interface Fiber {
    var reset: () -> Any
    var run: (param: Any? /*= null*/) -> Any
    var throwInto: (ex: Any) -> Any
}
@JsModule("fibers")
external fun Fiber(fn: Function<*>): Fiber = definedExternally
