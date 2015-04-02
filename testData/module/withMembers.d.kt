[file: nativePackageRoot]
package withMembers

/* ============= */
[file: nativePackage]
package withMembers.Foo

native
public trait A {
    public fun baz()
}
native
public open class B {
    public open fun boo(): Unit = noImpl
}
native
public var c: Number = noImpl
native
public fun d(a: Boolean, b: Any, c: SomeType): Unit = noImpl
