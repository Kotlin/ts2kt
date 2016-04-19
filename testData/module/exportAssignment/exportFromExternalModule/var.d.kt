package var

@module
object Mixto {
    interface IMixinStatic {
        fun includeInto(constructor: Any)
        fun extend(`object`: Any)
    }
}
@module
var mixto: Mixto.IMixinStatic = noImpl
