package jquery

native
public trait JQueryStatic {
    public fun ajax(settings: JQueryAjaxSettings): JQueryXHR
    public fun ajax(url: String, settings: JQueryAjaxSettings? = null): JQueryXHR
}
module
public object jquery {

}
native
module("jquery")
public var `$`: JQueryStatic = noImpl
