package refToOuterVarAfterModule

external interface JQueryStatic {
    fun ajax(settings: JQueryAjaxSettings): JQueryXHR
    fun ajax(url: String, settings: JQueryAjaxSettings? = null): JQueryXHR
}
@module
object jquery {

}
@module("jquery")
external var `$`: JQueryStatic = definedExternally
