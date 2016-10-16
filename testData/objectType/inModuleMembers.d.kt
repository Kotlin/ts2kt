package inModuleMembers

@module
object Foo {
    interface `T$0` {
        fun bar(a: Any): Number
        var baz: Any? get() = noImpl
        var boo: Any? get() = noImpl
        var show: (overrideChecks: Boolean) -> Unit
    }
    fun withObjectTypeParam(opt: `T$0`): Unit = noImpl
    interface `T$1` {
        var value: Any? get() = noImpl
        var done: Boolean
    }
    fun returnsObjectType(): `T$1` = noImpl
    interface `T$2` {
        fun bar(a: Any): Number
        fun baz(a: Any, b: Any, c: String): Boolean
    }
    var foo: `T$2` = noImpl
}
