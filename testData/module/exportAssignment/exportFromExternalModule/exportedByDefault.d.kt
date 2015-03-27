package exportedByDefault

/* ============= */
package exportedByDefault.Boo

public fun foo(): String = noImpl
public var bar: Number = noImpl
public trait IBaz {
    public fun doSomething()
}
public open class Klass {
    public open fun method(s: Any): String = noImpl
}
