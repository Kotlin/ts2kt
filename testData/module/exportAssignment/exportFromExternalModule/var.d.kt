package var

module
public var mixto: Mixto.IMixinStatic = noImpl

/* ============= */
package var.Mixto

public trait IMixinStatic {
    public fun includeInto(constructor: Any)
    public fun extend(`object`: Any)
}
