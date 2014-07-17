package exportedByDefault

module
public object Boo {
    public fun foo(): String = noImpl
    public var bar: Number = noImpl
    public trait IBaz {
        public fun doSomething()
    }
    public class Klass {
        public fun method(s: Any): String = noImpl
    }
}
