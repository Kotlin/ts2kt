[file: nativePackageRoot]
package exportedByDefault

/* ============= */
[file: nativeModule]
package exportedByDefault.Boo

native
public fun foo(): String = noImpl
native
public var bar: Number = noImpl
native
public trait IBaz {
    public fun doSomething()
}
native
public open class Klass {
    public open fun method(s: Any): String = noImpl
}
