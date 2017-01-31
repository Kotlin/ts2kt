package inClassMembers

external interface `T$0` {
    fun bar(a: Any): Number
    var baz: Any? get() = noImpl; set(value){}
    var boo: Any? get() = noImpl; set(value){}
    var show: (overrideChecks: Boolean) -> Unit
}
external interface `T$1` {
    var value: Any? get() = noImpl; set(value){}
    var done: Boolean
}
external interface `T$2` {
    fun bar(a: Any): Number
    fun baz(a: Any, b: Any, c: String): Boolean
}
external open class Foo {
    open fun withObjectTypeParam(opt: `T$0`): Unit = noImpl
    open fun returnsObjectType(): `T$1` = noImpl
    open var foo: `T$2` = noImpl
}
