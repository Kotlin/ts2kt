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

external interface `T$0` {
    fun bar(a: Any): Number
    var baz: Any? get() = definedExternally; set(value) = definedExternally
    var boo: Any? get() = definedExternally; set(value) = definedExternally
    var show: (overrideChecks: Boolean) -> Unit
}
external fun withObjectTypeParam(opt: `T$0`): Unit = definedExternally
external interface `T$1` {
    var value: Any? get() = definedExternally; set(value) = definedExternally
    var done: Boolean
}
external fun returnsObjectType(): `T$1` = definedExternally
external interface `T$2` {
    fun bar(a: Any): Number
    fun baz(a: Any, b: Any, c: String): Boolean
}
external var foo: `T$2` = definedExternally

// ------------------------------------------------------------------------------------------
@file:JsQualifier("Bar")
package shareTempTypesBetweenModules.Bar

external interface `T$3` {
    fun bar(a: Any): Number
    var baz: Any? get() = definedExternally; set(value) = definedExternally
    var boo: Any? get() = definedExternally; set(value) = definedExternally
    var show: (overrideChecks: Boolean) -> Unit
}
external fun someFunction(opt: `T$3`): Unit = definedExternally
external interface `T$4` {
    var value: Any? get() = definedExternally; set(value) = definedExternally
    var done: Boolean
}
external fun anotherReturnsObjectType(): `T$4` = definedExternally
external interface `T$5` {
    fun bar(a: Any): Number
    fun baz(a: Any, b: Any, c: String): Boolean
}
external var foo: `T$5` = definedExternally
