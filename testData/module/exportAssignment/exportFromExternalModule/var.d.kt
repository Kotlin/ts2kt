package `var`

@JsModule("mixto")
var mixto: Mixto.IMixinStatic = definedExternally

// ------------------------------------------------------------------------------------------
package `var`.Mixto

interface IMixinStatic {
    fun includeInto(constructor: Any)
    fun extend(`object`: Any)
}
