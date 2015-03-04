package withGeneric

native
public open class JQueryXHR : JQueryPromise<Any>(), MyXMLHttpRequest {
    public open fun overrideMimeType(mimeType: String): Any = noImpl
    public open fun abort(statusText: String? = null): Unit = noImpl
}
