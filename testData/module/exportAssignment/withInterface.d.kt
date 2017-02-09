package withInterface

@JsModule("lazy.js")
external var Lazy: LazyJS.LazyStatic = definedExternally

// ------------------------------------------------------------------------------------------
@file:JsQualifier("LazyJS")
package withInterface.LazyJS

interface LazyStatic {
    fun foo(a: Number)
}
var a: Any = definedExternally
