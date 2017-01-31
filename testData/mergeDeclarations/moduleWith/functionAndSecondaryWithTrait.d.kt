package functionAndSecondaryWithTrait

@module("fibers")
external interface Fiber {
    var reset: () -> Any
    var run: (param: Any? = definedExternally /* null */) -> Any
    var throwInto: (ex: Any) -> Any
    companion object {
        var current: Fiber = definedExternally
        fun yield(value: Any? = definedExternally /* null */): Any = definedExternally
    }
}
@module("fibers")
fun Fiber(fn: Function): Fiber = definedExternally
