package classWithStaticMembers

native
module
public class Foo {
    public fun bar(): Number = noImpl
    public class object {
        public var variable: String = noImpl
        public fun bar(): Unit = noImpl
        public fun baz(a: Any): Unit = noImpl
    }
}
