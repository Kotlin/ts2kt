@file:JsQualifier("lib1")
package namespaceImport.lib1

external interface I {
    var x: String
}

// ------------------------------------------------------------------------------------------
@file:JsQualifier("lib2")
package namespaceImport.lib2

external fun foo(): namespaceImport.lib1.I = definedExternally
