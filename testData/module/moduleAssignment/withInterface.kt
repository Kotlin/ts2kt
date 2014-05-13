package withInterface

module
public object LazyJS {
    public trait LazyStatic {
        public fun foo(a: Number): Unit
    }
    public var a: Any = noImpl
}
native
module("lazy.js")
public var Lazy: LazyJS.LazyStatic = noImpl
module
public object lazy.js {

}
