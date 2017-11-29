@file:JsQualifier("lib1")
package namespaceImportMultiple.lib1

external interface I {
    var x: String
}

// ------------------------------------------------------------------------------------------
@file:JsQualifier("lib1.lib3")
package namespaceImportMultiple.lib1.lib3

external interface K

// ------------------------------------------------------------------------------------------
@file:JsQualifier("lib1.lib2")
package namespaceImportMultiple.lib1.lib2

external interface J {
    var y: namespaceImportMultiple.lib1.I
}

// ------------------------------------------------------------------------------------------
@file:JsQualifier("lib1.lib2.lib3")
package namespaceImportMultiple.lib1.lib2.lib3

external fun foo(x: namespaceImportMultiple.lib1.lib2.J, y: namespaceImportMultiple.lib1.I, z: namespaceImportMultiple.lib1.lib3.K, v: namespaceImportMultiple.lib1.lib3.K): Unit = definedExternally
