package `var`

@JsModule("mixto")
external var mixto: Mixto.IMixinStatic = definedExternally

// ------------------------------------------------------------------------------------------
@file:JsQualifier("Mixto")
package `var`.Mixto

external interface IMixinStatic {
    fun includeInto(constructor: Any)
    fun extend(`object`: Any)
}
