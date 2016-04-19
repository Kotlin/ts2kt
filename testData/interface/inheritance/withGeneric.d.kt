package withGeneric

@native
interface JQueryXHR : MyXMLHttpRequest, JQueryPromise<Any> {
    fun overrideMimeType(mimeType: String): Any
    fun abort(statusText: String? = null)
}
