package refToOuterVarAfterModule

external interface JQueryStatic {
    fun ajax(settings: JQueryAjaxSettings): JQueryXHR
    fun ajax(url: String, settings: JQueryAjaxSettings? = definedExternally /* null */): JQueryXHR
}
@module("jquery")
external var `$`: JQueryStatic = definedExternally

// ------------------------------------------------------------------------------------------
package refToOuterVarAfterModule.jquery

