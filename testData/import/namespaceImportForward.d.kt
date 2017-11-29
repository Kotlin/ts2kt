@file:JsQualifier("lib1")
package namespaceImportForward.lib1

external interface I {
    var x: String
}

// ------------------------------------------------------------------------------------------
@file:JsQualifier("lib2")
package namespaceImportForward.lib2

external fun foo(): namespaceImportForward.lib1.I = definedExternally
