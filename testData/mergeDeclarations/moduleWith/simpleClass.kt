package simpleClass

native
module
public class Foo {
    public fun bar(): Number = noImpl
    public class object {
        public fun baz(a: Any): Unit = noImpl
        public fun bar(): Number = noImpl
    }
}
