package var

module
public object Mixto {
    public trait IMixinStatic {
        public fun includeInto(constructor: Any): Unit
        public fun extend(`object`: Any): Unit
    }
}
module
public var mixto: Mixto.IMixinStatic = noImpl
