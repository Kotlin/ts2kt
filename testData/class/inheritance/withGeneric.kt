package withGeneric

native
public class JQueryXHR : XMLHttpRequest, JQueryPromise<Any> {
    public fun overrideMimeType(mimeType: String): Any
    public fun abort(statusText: String? = null): Unit
}
