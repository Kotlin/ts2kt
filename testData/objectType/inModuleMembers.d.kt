@file:JsQualifier("Foo")
package inModuleMembers.Foo

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
