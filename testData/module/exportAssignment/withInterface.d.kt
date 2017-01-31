package withInterface

@module
object LazyJS {
    interface LazyStatic {
        fun foo(a: Number)
    }
    var a: Any = noImpl
}
@module("lazy.js")
external var Lazy: LazyJS.LazyStatic = noImpl
@module
object lazy.js {

}
