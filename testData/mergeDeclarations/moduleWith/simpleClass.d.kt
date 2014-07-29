package simpleClass

native
module
public open class Foo {
    public open fun bar(): Number = noImpl
    public class object {
        public fun baz(a: Any): Unit = noImpl
        public fun bar(): Number = noImpl
    }
}
