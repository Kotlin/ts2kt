package withMerging

/* ============= */
package withMerging.Foo

public var variableFoo: Number = noImpl
public fun funcFoo(): Unit = noImpl
public open class AFoo

/* ============= */
package withMerging.Foo.Bar

public var variableFooBar: Number = noImpl
public fun funcFooBar(): Unit = noImpl
public open class AFooBar

/* ============= */
package withMerging.Foo.Bar.Baz

public var variableFooBarBaz: Number = noImpl
public fun funcFooBarBaz(): Unit = noImpl
public open class AFooBarBaz
public var anotherVariableFooBarBaz: Number = noImpl
public fun anotherFuncFooBarBaz(): Unit = noImpl
public open class AnotherAFooBarBaz
