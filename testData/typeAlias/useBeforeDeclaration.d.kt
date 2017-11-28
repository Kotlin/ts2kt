package useBeforeDeclaration

external var listOfString: List<String> = definedExternally
external fun listOfNumberFunction(a: List<Number>): Unit = definedExternally

// ------------------------------------------------------------------------------------------
@file:JsQualifier("Foo")
package useBeforeDeclaration.Foo

external var listOfString: Values<String> = definedExternally
external fun listOfNumberFunction(a: Values<Number>): Unit = definedExternally
external var myVar: String = definedExternally
external fun myFunction(a: String): Unit = definedExternally
