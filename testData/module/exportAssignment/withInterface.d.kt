[file: nativePackageRoot]
package withInterface

nativeModule("lazy.js")
public var Lazy: LazyJS.LazyStatic = noImpl

/* ============= */
[file: nativePackage]
package withInterface.LazyJS

native
public trait LazyStatic {
    public fun foo(a: Number)
}
native
public var a: Any = noImpl
