package amplifyjs

@native
interface amplifyRequestSettings {
    var resourceId: String
    var data: Any? get() = noImpl
    var success: ((vararg args: Any) -> Unit)? get() = noImpl
    var error: ((vararg args: Any) -> Unit)? get() = noImpl
}
@native
interface amplifyDecoder {
    @nativeInvoke
    fun invoke(data: Any? = null, status: String? = null, xhr: JQueryXHR? = null, success: ((vararg args: Any) -> Unit)? = null, error: ((vararg args: Any) -> Unit)? = null)
}
@native
interface amplifyDecoders {
    @nativeGetter
    fun get(decoderName: String): amplifyDecoder
    @nativeSetter
    fun set(decoderName: String, value: amplifyDecoder)
    var jsSend: amplifyDecoder
}
@native
interface amplifyAjaxSettings : JQueryAjaxSettings {
    var cache: Any? get() = noImpl
    var dataMap: dynamic /* Any | (data: Any) -> Any */ get() = noImpl
    var decoder: Any? get() = noImpl
}
@native
interface amplifyRequest {
    @nativeInvoke
    fun invoke(resourceId: String, hash: Any? = null, callback: Function? = null)
    @nativeInvoke
    fun invoke(settings: amplifyRequestSettings): Any
    fun define(resourceId: String, requestType: String, settings: amplifyAjaxSettings? = null)
    fun define(resourceId: String, resource: (settings: amplifyRequestSettings) -> Unit)
    var decoders: amplifyDecoders
    var cache: Any
}
@native
interface amplifySubscribe {
    @nativeInvoke
    fun invoke(topic: String, callback: Function)
    @nativeInvoke
    fun invoke(topic: String, context: Any, callback: Function, priority: Number? = null)
    @nativeInvoke
    fun invoke(topic: String, callback: Function, priority: Number? = null)
}
@native
interface amplifyStorageTypeStore {
    @nativeInvoke
    fun invoke(key: String, value: Any, options: Any? = null)
    @nativeInvoke
    fun invoke(key: String): Any
    @nativeInvoke
    fun invoke(): Any
}
@native
interface amplifyStore : amplifyStorageTypeStore {
    var localStorage: amplifyStorageTypeStore
    var sessionStorage: amplifyStorageTypeStore
    var globalStorage: amplifyStorageTypeStore
    var userData: amplifyStorageTypeStore
    var memory: amplifyStorageTypeStore
}
@native
interface amplifyStatic {
    var subscribe: amplifySubscribe
    fun unsubscribe(topic: String, callback: Function)
    fun publish(topic: String, vararg args: Any): Boolean
    var store: amplifyStore
    var request: amplifyRequest
}
@native
@module("amplify")
var amplify: amplifyStatic = noImpl
