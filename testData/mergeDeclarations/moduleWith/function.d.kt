package function

native
public trait Fiber_ {
    public var reset: () -> Any
    public var run: (param: Any? = null) -> Any
    public var throwInto: (ex: Any) -> Any
}
module("fibers")
public fun Fiber(fn: Function): Fiber_ = noImpl
module("fibers")
public object Fiber {
    public var current: Fiber = noImpl
    public fun yield(value: Any? = null): Any = noImpl
}
