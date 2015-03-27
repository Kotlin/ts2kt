package withNonExportDeclarations

/* ============= */
package withNonExportDeclarations.Foo

public trait A {
    public fun baz()
}
public open class B {
    public open fun boo(): Unit = noImpl
}
public var c: Number = noImpl
public fun d(a: Boolean, b: Any, c: SomeType): Unit = noImpl

/* ============= */
package withNonExportDeclarations.Foo.Bar

public trait A {
    public fun baz()
}
public open class B {
    public open fun boo(): Unit = noImpl
}
public var c: Number = noImpl
public fun d(a: Boolean, b: Any, c: SomeType): Unit = noImpl
