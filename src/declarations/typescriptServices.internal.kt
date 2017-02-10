@file:JsQualifier("ts")
package typescriptServices.ts

// Declarations that declared inside namespace marked as internal and not exist inside typescriptServices.d.ts and typescript.d.ts, but available at runtime

external fun unescapeIdentifier(identifier: String): String
external fun normalizePath(path: String): String
external fun getDirectoryPath(path: String): String
