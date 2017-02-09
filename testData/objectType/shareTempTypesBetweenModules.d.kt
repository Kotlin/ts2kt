package shareTempTypesBetweenModules

external interface `T$6` {
    fun bar(a: Any): Number
    var baz: Any? get() = definedExternally; set(value) = definedExternally
    var boo: Any? get() = definedExternally; set(value) = definedExternally
    var show: (overrideChecks: Boolean) -> Unit
}
external fun withObjectTypeParam(opt: `T$6`): Unit = definedExternally
external interface `T$7` {
    var value: Any? get() = definedExternally; set(value) = definedExternally
    var done: Boolean
}
external fun returnsObjectType(): `T$7` = definedExternally
external interface `T$8` {
    fun bar(a: Any): Number
    fun baz(a: Any, b: Any, c: String): Boolean
}
external var foo: `T$8` = definedExternally

// ------------------------------------------------------------------------------------------
@file:JsQualifier("Foo")
package shareTempTypesBetweenModules.Foo

interface `T$0` {
    fun bar(a: Any): Number
    var baz: Any? get() = definedExternally; set(value) = definedExternally
    var boo: Any? get() = definedExternally; set(value) = definedExternally
    var show: (overrideChecks: Boolean) -> Unit
}
fun withObjectTypeParam(opt: `T$0`): Unit = definedExternally
interface `T$1` {
    var value: Any? get() = definedExternally; set(value) = definedExternally
    var done: Boolean
}
fun returnsObjectType(): `T$1` = definedExternally
interface `T$2` {
    fun bar(a: Any): Number
    fun baz(a: Any, b: Any, c: String): Boolean
}
var foo: `T$2` = definedExternally

// ------------------------------------------------------------------------------------------
@file:JsQualifier("Bar")
package shareTempTypesBetweenModules.Bar

interface `T$3` {
    fun bar(a: Any): Number
    var baz: Any? get() = definedExternally; set(value) = definedExternally
    var boo: Any? get() = definedExternally; set(value) = definedExternally
    var show: (overrideChecks: Boolean) -> Unit
}
fun someFunction(opt: `T$3`): Unit = definedExternally
interface `T$4` {
    var value: Any? get() = definedExternally; set(value) = definedExternally
    var done: Boolean
}
fun anotherReturnsObjectType(): `T$4` = definedExternally
interface `T$5` {
    fun bar(a: Any): Number
    fun baz(a: Any, b: Any, c: String): Boolean
}
var foo: `T$5` = definedExternally
