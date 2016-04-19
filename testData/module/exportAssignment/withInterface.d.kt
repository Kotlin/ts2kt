package withInterface

@module
object LazyJS {
    interface LazyStatic {
        fun foo(a: Number)
    }
    var a: Any = noImpl
}
@native
@module("lazy.js")
var Lazy: LazyJS.LazyStatic = noImpl
@module
object lazy.js {

}
