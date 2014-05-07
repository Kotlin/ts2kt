package withMembers

module
public object Foo {
    public trait A {
        public fun baz(): Unit
    }
    public class B {
        public fun boo(): Unit = noImpl
    }
    public var c: Number = noImpl
    public fun d(a: Boolean, b: Any, c: SomeType): Unit = noImpl
}
