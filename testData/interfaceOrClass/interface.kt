package interface

trait JQueryAjaxSettings {
    var optionalVarAsAny: Any?
    var optionalVarAsBool: Boolean
    val optionalFunction: ((jqXHR: String, settings: JQueryAjaxSettings) -> Any)?
    var varAsAny: Any
    var varAsBool: Boolean
    fun method0()
    fun method1(jqXHR: String): String
    fun method2(jqXHR: String, settings: JQueryAjaxSettings): Boolean
}