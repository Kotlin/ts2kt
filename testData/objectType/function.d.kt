package function

@native
interface `T$0` {
    fun bar(a: Any): Number
    var baz: Any? get() = noImpl; set(value){}
    var boo: Any? get() = noImpl; set(value){}
    var show: (overrideChecks: Boolean) -> Unit
}
@native
fun withObjectTypeParam(opt: `T$0`): Unit = noImpl
@native
interface `T$1` {
    fun bar(a: Any): Number
    var baz: Any? get() = noImpl; set(value){}
    var show: (overrideChecks: Boolean) -> Unit
}
@native
fun returnsObjectType(): `T$1` = noImpl
