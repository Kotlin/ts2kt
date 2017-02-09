package `var`

@JsModule("mixto")
var mixto: Mixto.IMixinStatic = definedExternally

// ------------------------------------------------------------------------------------------
@file:JsQualifier("Mixto")
package `var`.Mixto

interface IMixinStatic {
    fun includeInto(constructor: Any)
    fun extend(`object`: Any)
}
