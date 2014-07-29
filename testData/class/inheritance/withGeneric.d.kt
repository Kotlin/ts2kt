package withGeneric

native
public open class JQueryXHR : JQueryPromise<Any>(), XMLHttpRequest {
    public open fun overrideMimeType(mimeType: String): Any = noImpl
    public open fun abort(statusText: String? = null): Unit = noImpl
}
