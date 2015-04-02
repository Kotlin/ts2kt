[file: nativePackageRoot]
package var

/* ============= */
[file: nativePackage]
package var.Mixto

native
public trait IMixinStatic {
    public fun includeInto(constructor: Any)
    public fun extend(`object`: Any)
}

/* ============= */
[file: nativeModulePart]
package var.mixto

nativeModule("mixto")
public var _tmp: Mixto.IMixinStatic = noImpl
