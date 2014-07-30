package shareTempTypesBetweenModules

module
public object Foo {
    public trait `T$0` {
        public fun bar(a: Any): Number
        public var baz: Any? = noImpl
        public var boo: Any? = noImpl
        public var show: (overrideChecks: Boolean) -> Unit
    }
    public fun withObjectTypeParam(opt: `T$0`): Unit = noImpl
    public trait `T$1` {
        public var value: Any? = noImpl
        public var done: Boolean
    }
    public fun returnsObjectType(): `T$1` = noImpl
    public trait `T$2` {
        public fun bar(a: Any): Number
        public fun baz(a: Any, b: Any, c: String): Boolean
    }
    public var foo: `T$2` = noImpl
}
module
public object Bar {
    public trait `T$3` {
        public fun bar(a: Any): Number
        public var baz: Any? = noImpl
        public var boo: Any? = noImpl
        public var show: (overrideChecks: Boolean) -> Unit
    }
    public fun someFunction(opt: `T$3`): Unit = noImpl
    public trait `T$4` {
        public var value: Any? = noImpl
        public var done: Boolean
    }
    public fun anotherReturnsObjectType(): `T$4` = noImpl
    public trait `T$5` {
        public fun bar(a: Any): Number
        public fun baz(a: Any, b: Any, c: String): Boolean
    }
    public var foo: `T$5` = noImpl
}
native
public trait `T$6` {
    public fun bar(a: Any): Number
    public var baz: Any? = noImpl
    public var boo: Any? = noImpl
    public var show: (overrideChecks: Boolean) -> Unit
}
native
public fun withObjectTypeParam(opt: `T$6`): Unit = noImpl
native
public trait `T$7` {
    public var value: Any? = noImpl
    public var done: Boolean
}
native
public fun returnsObjectType(): `T$7` = noImpl
native
public trait `T$8` {
    public fun bar(a: Any): Number
    public fun baz(a: Any, b: Any, c: String): Boolean
}
native
public var foo: `T$8` = noImpl
