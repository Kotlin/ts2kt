[file: nativePackageRoot]
package function

native
public trait Fiber_ {
    public var reset: () -> Any
    public var run: (param: Any? = null) -> Any
    public var throwInto: (ex: Any) -> Any
}

/* ============= */
[file: nativeModulePart]
package function.fibers

nativeModule("fibers")
public fun Fiber(fn: Function): Fiber_ = noImpl

/* ============= */
[file: nativePackage, nativeModule("fibers")]
package function.fibers.Fiber

native
public var current: Fiber_ = noImpl
native
public fun yield(value: Any? = null): Any = noImpl
