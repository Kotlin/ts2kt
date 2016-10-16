package atmosphere

@module
object Atmosphere {
    interface Atmosphere {
        var subscribe: ((requestOrUrl: Any, callback: Function? = null, request: Request? = null) -> Request)? get() = noImpl
        var unsubscribe: (() -> Unit)? get() = noImpl
        var AtmosphereRequest: AtmosphereRequest? get() = noImpl
    }
    interface AtmosphereRequest {
        @native("new")
        fun invoke(): Request
    }
    interface Request {
        var timeout: Number? get() = noImpl
        var method: String? get() = noImpl
        var headers: Any? get() = noImpl
        var contentType: String? get() = noImpl
        var callback: Function? get() = noImpl
        var url: String? get() = noImpl
        var data: String? get() = noImpl
        var suspend: Boolean? get() = noImpl
        var maxRequest: Number? get() = noImpl
        var reconnect: Boolean? get() = noImpl
        var maxStreamingLength: Number? get() = noImpl
        var lastIndex: Number? get() = noImpl
        var logLevel: String? get() = noImpl
        var requestCount: Number? get() = noImpl
        var fallbackMethod: String? get() = noImpl
        var fallbackTransport: String? get() = noImpl
        var transport: String? get() = noImpl
        var webSocketImpl: Any? get() = noImpl
        var webSocketBinaryType: Any? get() = noImpl
        var dispatchUrl: String? get() = noImpl
        var webSocketPathDelimiter: String? get() = noImpl
        var enableXDR: Boolean? get() = noImpl
        var rewriteURL: Boolean? get() = noImpl
        var attachHeadersAsQueryString: Boolean? get() = noImpl
        var executeCallbackBeforeReconnect: Boolean? get() = noImpl
        var readyState: Number? get() = noImpl
        var lastTimestamp: Number? get() = noImpl
        var withCredentials: Boolean? get() = noImpl
        var trackMessageLength: Boolean? get() = noImpl
        var messageDelimiter: String? get() = noImpl
        var connectTimeout: Number? get() = noImpl
        var reconnectInterval: Number? get() = noImpl
        var dropHeaders: Boolean? get() = noImpl
        var uuid: String? get() = noImpl
        var async: Boolean? get() = noImpl
        var shared: Boolean? get() = noImpl
        var readResponsesHeaders: Boolean? get() = noImpl
        var maxReconnectOnClose: Number? get() = noImpl
        var enableProtocol: Boolean? get() = noImpl
        var pollingInterval: Number? get() = noImpl
        var onError: ((response: Response? = null) -> Unit)? get() = noImpl
        var onClose: ((response: Response? = null) -> Unit)? get() = noImpl
        var onOpen: ((response: Response? = null) -> Unit)? get() = noImpl
        var onMessage: ((response: Response) -> Unit)? get() = noImpl
        var onReopen: ((request: Request? = null, response: Response? = null) -> Unit)? get() = noImpl
        var onReconnect: ((request: Request? = null, response: Response? = null) -> Unit)? get() = noImpl
        var onMessagePublished: ((response: Response? = null) -> Unit)? get() = noImpl
        var onTransportFailure: ((reason: String? = null, response: Response? = null) -> Unit)? get() = noImpl
        var onLocalMessage: ((request: Request? = null) -> Unit)? get() = noImpl
        var onFailureToReconnect: ((request: Request? = null, response: Response? = null) -> Unit)? get() = noImpl
        var onClientTimeout: ((request: Request? = null) -> Unit)? get() = noImpl
        var subscribe: ((options: Request) -> Unit)? get() = noImpl
        var execute: (() -> Unit)? get() = noImpl
        var close: (() -> Unit)? get() = noImpl
        var disconnect: (() -> Unit)? get() = noImpl
        var getUrl: (() -> String)? get() = noImpl
        var push: ((message: String, dispatchUrl: String? = null) -> Unit)? get() = noImpl
        var getUUID: (() -> Unit)? get() = noImpl
        var pushLocal: ((message: String) -> Unit)? get() = noImpl
    }
    interface Response {
        var status: Number? get() = noImpl
        var reasonPhrase: String? get() = noImpl
        var responseBody: String? get() = noImpl
        var messages: Array<String>? get() = noImpl
        var headers: Array<String>? get() = noImpl
        var state: String? get() = noImpl
        var transport: String? get() = noImpl
        var error: String? get() = noImpl
        var request: Request? get() = noImpl
        var partialMessage: String? get() = noImpl
        var errorHandled: Boolean? get() = noImpl
        var closedByClientTimeout: Boolean? get() = noImpl
    }
}
@native
var atmosphere: Atmosphere.Atmosphere = noImpl
