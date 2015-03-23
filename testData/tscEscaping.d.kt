package tscEscaping

module
public object atpl {
    public var __foo: Any = noImpl
    public fun __express(filename: String, options: Any, callback: Function): Any = noImpl
}
native
public open class __A {
    public open var __foo: Number = noImpl
    public open fun __express(filename: String, options: Any, callback: Function): Any = noImpl
}
native
public trait __B {
    public var __foo: Number
    public fun __express(filename: String, options: Any, callback: Function): Any
}
public enum class __E {
    __A
    __B
}
module
public object __M {
    public var __foo: Number = noImpl
    public fun __express(filename: String, options: Any, callback: Function): Any = noImpl
    module
    public object __N {
        public var __foo: Number = noImpl
        public fun __express(filename: String, options: Any, callback: Function): Any = noImpl
        public open class __C
    }
}
native
public fun foo<__T>(__a: __T, _b: __M.__N.__C): Unit = noImpl
