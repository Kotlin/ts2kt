package withMerging.Foo.Bar.Baz

var variableFooBarBaz: Number = definedExternally
fun funcFooBarBaz(): Unit = definedExternally
open class AFooBarBaz
var anotherVariableFooBarBaz: Number = definedExternally
fun anotherFuncFooBarBaz(): Unit = definedExternally
open class AnotherAFooBarBaz

// ------------------------------------------------------------------------------------------
package withMerging.Foo.Bar

var variableFooBar: Number = definedExternally
fun funcFooBar(): Unit = definedExternally
open class AFooBar

// ------------------------------------------------------------------------------------------
package withMerging.Foo

var variableFoo: Number = definedExternally
fun funcFoo(): Unit = definedExternally
open class AFoo
