package simpleInterface

native
public trait Foo {
    public fun bar(): Number
    public class object {
        public fun baz(a: Any): Unit = noImpl
        public fun bar(): Number = noImpl
    }
}
