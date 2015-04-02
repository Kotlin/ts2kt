[file: nativePackageRoot]
package functionAndSecondaryWithTrait

native
public trait Fiber {
    public var reset: () -> Any
    public var run: (param: Any? = null) -> Any
    public var throwInto: (ex: Any) -> Any
}

/* ============= */
[file: nativeModulePart]
package functionAndSecondaryWithTrait.fibers

nativeModule("fibers")
public fun Fiber(fn: Function): Fiber = noImpl

/* ============= */
[file: nativePackage, nativeModule("fibers")]
package functionAndSecondaryWithTrait.fibers.Fiber

native
public var current: Fiber = noImpl
native
public fun yield(value: Any? = null): Any = noImpl
