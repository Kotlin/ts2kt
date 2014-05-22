package inModuleMembers

module
public object Foo {
    public trait `T$0` {
        public fun bar(a: Any): Number
        public var baz: Any?
        public var boo: Any?
        public var show: (overrideChecks: Boolean) -> Unit
    }
    public fun withObjectTypeParam(opt: `T$0`): Unit = noImpl
    public trait `T$1` {
        public var value: Any?
        public var done: Boolean
    }
    public fun returnsObjectType(): `T$1` = noImpl
    public trait `T$2` {
        public fun bar(a: Any): Number
        public fun baz(a: Any, b: Any, c: String): Boolean
    }
    public var foo: `T$2` = noImpl
}
