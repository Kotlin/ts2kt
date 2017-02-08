package tscEscaping

external var __foo: Any = definedExternally
external fun __express(filename: String, options: Any, callback: Function): Any = definedExternally
external open class __A {
    open var __foo: Number = definedExternally
    open fun __express(filename: String, options: Any, callback: Function): Any = definedExternally
}
external interface __B {
    var __foo: Number
    fun __express(filename: String, options: Any, callback: Function): Any
}
enum class __E {
    __A,
    __B
}
external fun <__T> foo(__a: __T, _b: __M.__N.__C): Unit = definedExternally

// ------------------------------------------------------------------------------------------
package tscEscaping.atpl

var __foo: Any = definedExternally
fun __express(filename: String, options: Any, callback: Function): Any = definedExternally

// ------------------------------------------------------------------------------------------
package tscEscaping.__M

var __foo: Number = definedExternally
fun __express(filename: String, options: Any, callback: Function): Any = definedExternally

// ------------------------------------------------------------------------------------------
package tscEscaping.__M.__N

var __foo: Number = definedExternally
fun __express(filename: String, options: Any, callback: Function): Any = definedExternally
open class __C
