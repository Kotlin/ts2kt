package withInterface

@module
object LazyJS {
    interface LazyStatic {
        fun foo(a: Number)
    }
    var a: Any = definedExternally
}
@module("lazy.js")
external var Lazy: LazyJS.LazyStatic = definedExternally
@module
object lazy.js {
}
