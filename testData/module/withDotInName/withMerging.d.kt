package withMerging

module
public object Foo {
    module
    public object Bar {
        module
        public object Baz {
            public var variableFooBarBaz: Number = noImpl
            public fun funcFooBarBaz(): Unit = noImpl
            public open class AFooBarBaz
            public var anotherVariableFooBarBaz: Number = noImpl
            public fun anotherFuncFooBarBaz(): Unit = noImpl
            public open class AnotherAFooBarBaz
        }
        public var variableFooBar: Number = noImpl
        public fun funcFooBar(): Unit = noImpl
        public open class AFooBar
    }
    public var variableFoo: Number = noImpl
    public fun funcFoo(): Unit = noImpl
    public open class AFoo
}
