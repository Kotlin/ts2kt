[file: nativePackageRoot]
package module

/* ============= */
[file: nativeModule]
package module.Boo

/* ============= */
[file: nativePackage, nativeModule("Boo")]
package module.Boo.MM

native
public fun method(s: Any): String = noImpl
native
public var variable: Any = noImpl
