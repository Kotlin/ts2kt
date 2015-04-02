[file: nativePackageRoot]
package withMerging

/* ============= */
[file: nativePackage]
package withMerging.Foo

native
public var variableFoo: Number = noImpl
native
public fun funcFoo(): Unit = noImpl
native
public open class AFoo

/* ============= */
[file: nativePackage]
package withMerging.Foo.Bar

native
public var variableFooBar: Number = noImpl
native
public fun funcFooBar(): Unit = noImpl
native
public open class AFooBar

/* ============= */
[file: nativePackage]
package withMerging.Foo.Bar.Baz

native
public var variableFooBarBaz: Number = noImpl
native
public fun funcFooBarBaz(): Unit = noImpl
native
public open class AFooBarBaz
native
public var anotherVariableFooBarBaz: Number = noImpl
native
public fun anotherFuncFooBarBaz(): Unit = noImpl
native
public open class AnotherAFooBarBaz
