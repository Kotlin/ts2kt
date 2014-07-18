package withMerging

module
public object Foo {
    module
    public object Bar {
        module
        public object Baz {
            public var variableFooBarBaz: Number = noImpl
            public fun funcFooBarBaz(): Unit = noImpl
            public class AFooBarBaz
            public var anotherVariableFooBarBaz: Number = noImpl
            public fun anotherFuncFooBarBaz(): Unit = noImpl
            public class AnotherAFooBarBaz
        }
        public var variableFooBar: Number = noImpl
        public fun funcFooBar(): Unit = noImpl
        public class AFooBar
    }
    public var variableFoo: Number = noImpl
    public fun funcFoo(): Unit = noImpl
    public class AFoo
}
