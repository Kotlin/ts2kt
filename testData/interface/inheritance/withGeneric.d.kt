package withGeneric

native
public trait JQueryXHR : MyXMLHttpRequest, JQueryPromise<Any> {
    public fun overrideMimeType(mimeType: String): Any
    public fun abort(statusText: String? = null)
}
