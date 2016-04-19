package refToOuterVarAfterModule

@native
interface JQueryStatic {
    fun ajax(settings: JQueryAjaxSettings): JQueryXHR
    fun ajax(url: String, settings: JQueryAjaxSettings? = null): JQueryXHR
}
@module
object jquery {

}
@native
@module("jquery")
var `$`: JQueryStatic = noImpl
