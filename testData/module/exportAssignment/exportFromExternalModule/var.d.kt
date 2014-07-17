package var

module
public object Mixto {
    public trait IMixinStatic {
        public fun includeInto(constructor: Any)
        public fun extend(`object`: Any)
    }
}
module
public var mixto: Mixto.IMixinStatic = noImpl
