package withGeneric

external open class JQueryXHR : JQueryPromise<Any>(), MyXMLHttpRequest {
    open fun overrideMimeType(mimeType: String): Any = noImpl
    open fun abort(statusText: String? = null): Unit = noImpl
}
