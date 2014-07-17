package amplifyjs

native
public trait amplifyRequestSettings {
    public var resourceId: String
    public var data: Any? = noImpl
    public var success: ((vararg args: Any) -> Unit)? = noImpl
    public var error: ((vararg args: Any) -> Unit)? = noImpl
}
native
public trait amplifyDecoder {
    public fun invoke(data: Any? = null, status: String? = null, xhr: JQueryXHR? = null, success: ((vararg args: Any) -> Unit)? = null, error: ((vararg args: Any) -> Unit)? = null)
}
native
public trait amplifyDecoders {
    public fun get(decoderName: String): amplifyDecoder
    public fun set(decoderName: String, value: amplifyDecoder)
    public var jsSend: amplifyDecoder
}
native
public trait amplifyAjaxSettings : JQueryAjaxSettings {
    public var cache: Any? = noImpl
    public var decoder: Any? = noImpl
}
native
public trait amplifyRequest {
    public fun invoke(resourceId: String, hash: Any? = null, callback: Function? = null)
    public fun invoke(settings: amplifyRequestSettings)
    public fun define(resourceId: String, requestType: String, settings: amplifyAjaxSettings? = null)
    public fun define(resourceId: String, resource: (settings: amplifyRequestSettings) -> Unit)
    public var decoders: amplifyDecoders
    public var cache: Any
}
native
public trait amplifySubscribe {
    public fun invoke(topic: String, callback: Function)
    public fun invoke(topic: String, context: Any, callback: Function, priority: Number? = null)
    public fun invoke(topic: String, callback: Function, priority: Number? = null)
}
native
public trait amplifyStorageTypeStore {
    public fun invoke(key: String, value: Any, options: Any? = null)
    public fun invoke(key: String): Any
    public fun invoke(): Any
}
native
public trait amplifyStore : amplifyStorageTypeStore {
    public var localStorage: amplifyStorageTypeStore
    public var sessionStorage: amplifyStorageTypeStore
    public var globalStorage: amplifyStorageTypeStore
    public var userData: amplifyStorageTypeStore
    public var memory: amplifyStorageTypeStore
}
native
public trait amplifyStatic {
    public var subscribe: amplifySubscribe
    public fun unsubscribe(topic: String, callback: Function)
    public fun publish(topic: String, vararg args: Any): Boolean
    public var store: amplifyStore
    public var request: amplifyRequest
}
native
public var amplify: amplifyStatic = noImpl
