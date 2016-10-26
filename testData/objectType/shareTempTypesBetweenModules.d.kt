package shareTempTypesBetweenModules

@module
object Foo {
    interface `T$0` {
        fun bar(a: Any): Number
        var baz: Any? get() = noImpl; set(value){}
        var boo: Any? get() = noImpl; set(value){}
        var show: (overrideChecks: Boolean) -> Unit
    }
    fun withObjectTypeParam(opt: `T$0`): Unit = noImpl
    interface `T$1` {
        var value: Any? get() = noImpl; set(value){}
        var done: Boolean
    }
    fun returnsObjectType(): `T$1` = noImpl
    interface `T$2` {
        fun bar(a: Any): Number
        fun baz(a: Any, b: Any, c: String): Boolean
    }
    var foo: `T$2` = noImpl
}
@module
object Bar {
    interface `T$3` {
        fun bar(a: Any): Number
        var baz: Any? get() = noImpl; set(value){}
        var boo: Any? get() = noImpl; set(value){}
        var show: (overrideChecks: Boolean) -> Unit
    }
    fun someFunction(opt: `T$3`): Unit = noImpl
    interface `T$4` {
        var value: Any? get() = noImpl; set(value){}
        var done: Boolean
    }
    fun anotherReturnsObjectType(): `T$4` = noImpl
    interface `T$5` {
        fun bar(a: Any): Number
        fun baz(a: Any, b: Any, c: String): Boolean
    }
    var foo: `T$5` = noImpl
}
@native
interface `T$6` {
    fun bar(a: Any): Number
    var baz: Any? get() = noImpl; set(value){}
    var boo: Any? get() = noImpl; set(value){}
    var show: (overrideChecks: Boolean) -> Unit
}
@native
fun withObjectTypeParam(opt: `T$6`): Unit = noImpl
@native
interface `T$7` {
    var value: Any? get() = noImpl; set(value){}
    var done: Boolean
}
@native
fun returnsObjectType(): `T$7` = noImpl
@native
interface `T$8` {
    fun bar(a: Any): Number
    fun baz(a: Any, b: Any, c: String): Boolean
}
@native
var foo: `T$8` = noImpl
