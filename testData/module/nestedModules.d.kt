package nestedModules

module
public object Foo {
    module
    public object Bar {
        public trait A {
            public fun baz()
        }
        public class B {
            public fun boo(): Unit = noImpl
        }
        public var c: Number = noImpl
        public fun d(a: Boolean, b: Any, c: SomeType): Unit = noImpl
    }
}
