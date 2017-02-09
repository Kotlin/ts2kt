package withInterface

@module("lazy.js")
external var Lazy: LazyJS.LazyStatic = definedExternally

// ------------------------------------------------------------------------------------------
package withInterface.LazyJS

interface LazyStatic {
    fun foo(a: Number)
}
var a: Any = definedExternally
