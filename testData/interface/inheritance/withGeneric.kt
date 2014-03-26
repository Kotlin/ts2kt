package withGeneric

native
public trait JQueryXHR : XMLHttpRequest, JQueryPromise<Any> {
    public fun overrideMimeType(mimeType: String): Any
    public fun abort(statusText: String? = null): Unit
}
