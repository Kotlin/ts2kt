package atmosphere

@module
object Atmosphere {
    interface Atmosphere {
        var subscribe: ((requestOrUrl: Any, callback: Function? = null, request: Request? = null) -> Request)? = noImpl
        var unsubscribe: (() -> Unit)? = noImpl
        var AtmosphereRequest: AtmosphereRequest? = noImpl
    }
    interface AtmosphereRequest {
        @nativeNew
        fun invoke(): Request
    }
    interface Request {
        var timeout: Number? = noImpl
        var method: String? = noImpl
        var headers: Any? = noImpl
        var contentType: String? = noImpl
        var callback: Function? = noImpl
        var url: String? = noImpl
        var data: String? = noImpl
        var suspend: Boolean? = noImpl
        var maxRequest: Number? = noImpl
        var reconnect: Boolean? = noImpl
        var maxStreamingLength: Number? = noImpl
        var lastIndex: Number? = noImpl
        var logLevel: String? = noImpl
        var requestCount: Number? = noImpl
        var fallbackMethod: String? = noImpl
        var fallbackTransport: String? = noImpl
        var transport: String? = noImpl
        var webSocketImpl: Any? = noImpl
        var webSocketBinaryType: Any? = noImpl
        var dispatchUrl: String? = noImpl
        var webSocketPathDelimiter: String? = noImpl
        var enableXDR: Boolean? = noImpl
        var rewriteURL: Boolean? = noImpl
        var attachHeadersAsQueryString: Boolean? = noImpl
        var executeCallbackBeforeReconnect: Boolean? = noImpl
        var readyState: Number? = noImpl
        var lastTimestamp: Number? = noImpl
        var withCredentials: Boolean? = noImpl
        var trackMessageLength: Boolean? = noImpl
        var messageDelimiter: String? = noImpl
        var connectTimeout: Number? = noImpl
        var reconnectInterval: Number? = noImpl
        var dropHeaders: Boolean? = noImpl
        var uuid: Number? = noImpl
        var async: Boolean? = noImpl
        var shared: Boolean? = noImpl
        var readResponsesHeaders: Boolean? = noImpl
        var maxReconnectOnClose: Number? = noImpl
        var enableProtocol: Boolean? = noImpl
        var pollingInterval: Number? = noImpl
        var onError: ((response: Response? = null) -> Unit)? = noImpl
        var onClose: ((response: Response? = null) -> Unit)? = noImpl
        var onOpen: ((response: Response? = null) -> Unit)? = noImpl
        var onMessage: ((response: Response) -> Unit)? = noImpl
        var onReopen: ((request: Request? = null, response: Response? = null) -> Unit)? = noImpl
        var onReconnect: ((request: Request? = null, response: Response? = null) -> Unit)? = noImpl
        var onMessagePublished: ((response: Response? = null) -> Unit)? = noImpl
        var onTransportFailure: ((reason: String? = null, response: Response? = null) -> Unit)? = noImpl
        var onLocalMessage: ((request: Request? = null) -> Unit)? = noImpl
        var onFailureToReconnect: ((request: Request? = null, response: Response? = null) -> Unit)? = noImpl
        var onClientTimeout: ((request: Request? = null) -> Unit)? = noImpl
        var subscribe: ((options: Request) -> Unit)? = noImpl
        var execute: (() -> Unit)? = noImpl
        var close: (() -> Unit)? = noImpl
        var disconnect: (() -> Unit)? = noImpl
        var getUrl: (() -> String)? = noImpl
        var push: ((message: String, dispatchUrl: String? = null) -> Unit)? = noImpl
        var getUUID: (() -> Unit)? = noImpl
        var pushLocal: ((message: String) -> Unit)? = noImpl
    }
    interface Response {
        var status: Number? = noImpl
        var reasonPhrase: String? = noImpl
        var responseBody: String? = noImpl
        var messages: Array<String>? = noImpl
        var headers: Array<String>? = noImpl
        var state: String? = noImpl
        var transport: String? = noImpl
        var error: String? = noImpl
        var request: Request? = noImpl
        var partialMessage: String? = noImpl
        var errorHandled: Boolean? = noImpl
        var closedByClientTimeout: Boolean? = noImpl
    }
}
@native
var atmosphere: Atmosphere.Atmosphere = noImpl
