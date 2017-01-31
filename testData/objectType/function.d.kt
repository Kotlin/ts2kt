package function

external interface `T$0` {
    fun bar(a: Any): Number
    var baz: Any? get() = noImpl; set(value){}
    var boo: Any? get() = noImpl; set(value){}
    var show: (overrideChecks: Boolean) -> Unit
}
external fun withObjectTypeParam(opt: `T$0`): Unit = noImpl
external interface `T$1` {
    fun bar(a: Any): Number
    var baz: Any? get() = noImpl; set(value){}
    var show: (overrideChecks: Boolean) -> Unit
}
external fun returnsObjectType(): `T$1` = noImpl
