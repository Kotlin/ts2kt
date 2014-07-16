package withGeneric

native
public class JQueryXHR : JQueryPromise<Any>(), XMLHttpRequest {
    public fun overrideMimeType(mimeType: String): Any = noImpl
    public fun abort(statusText: String? = null): Unit = noImpl
}
