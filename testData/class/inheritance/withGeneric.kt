package withGeneric

native
public class JQueryXHR : XMLHttpRequest, JQueryPromise<Any> {
    public fun overrideMimeType(mimeType: String): Any = noImpl
    public fun abort(statusText: String? = null): Unit = noImpl
}
