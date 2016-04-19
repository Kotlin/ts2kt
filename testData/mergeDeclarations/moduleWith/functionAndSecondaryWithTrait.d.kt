package functionAndSecondaryWithTrait

@native
@module("fibers")
interface Fiber {
    var reset: () -> Any
    var run: (param: Any? = null) -> Any
    var throwInto: (ex: Any) -> Any
    companion object {
        var current: Fiber = noImpl
        fun yield(value: Any? = null): Any = noImpl
    }
}
@module("fibers")
fun Fiber(fn: Function): Fiber = noImpl
