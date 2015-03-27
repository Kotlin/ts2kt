package withInterface

native
module("lazy.js")
public var Lazy: LazyJS.LazyStatic = noImpl

/* ============= */
package withInterface.LazyJS

public trait LazyStatic {
    public fun foo(a: Number)
}
public var a: Any = noImpl
