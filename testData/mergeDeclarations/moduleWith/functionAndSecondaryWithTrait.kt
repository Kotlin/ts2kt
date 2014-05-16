package functionAndSecondaryWithTrait

native
module("fibers")
public trait Fiber {
    public var reset: () -> Any
    public var run: (param: Any? = null) -> Any
    public var throwInto: (ex: Any) -> Any
    public class object {
        public var current: Fiber = noImpl
        public fun yield(value: Any? = null): Any = noImpl
    }
}
module("fibers")
public fun Fiber(fn: Function): Fiber = noImpl
