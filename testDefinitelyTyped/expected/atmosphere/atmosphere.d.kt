package atmosphere

module
public object Atmosphere {
    public trait Atmosphere {
        public var subscribe: ((requestOrUrl: Any, callback: Function? = null, request: Request? = null) -> Request)? = noImpl
        public var unsubscribe: (() -> Unit)? = noImpl
        public var AtmosphereRequest: AtmosphereRequest? = noImpl
    }
    public trait AtmosphereRequest {
        public fun invoke(): Request
    }
    public trait Request {
        public var timeout: Number? = noImpl
        public var method: String? = noImpl
        public var headers: Any? = noImpl
        public var contentType: String? = noImpl
        public var callback: Function? = noImpl
        public var url: String? = noImpl
        public var data: String? = noImpl
        public var suspend: Boolean? = noImpl
        public var maxRequest: Number? = noImpl
        public var reconnect: Boolean? = noImpl
        public var maxStreamingLength: Number? = noImpl
        public var lastIndex: Number? = noImpl
        public var logLevel: String? = noImpl
        public var requestCount: Number? = noImpl
        public var fallbackMethod: String? = noImpl
        public var fallbackTransport: String? = noImpl
        public var transport: String? = noImpl
        public var webSocketImpl: Any? = noImpl
        public var webSocketBinaryType: Any? = noImpl
        public var dispatchUrl: String? = noImpl
        public var webSocketPathDelimiter: String? = noImpl
        public var enableXDR: Boolean? = noImpl
        public var rewriteURL: Boolean? = noImpl
        public var attachHeadersAsQueryString: Boolean? = noImpl
        public var executeCallbackBeforeReconnect: Boolean? = noImpl
        public var readyState: Number? = noImpl
        public var lastTimestamp: Number? = noImpl
        public var withCredentials: Boolean? = noImpl
        public var trackMessageLength: Boolean? = noImpl
        public var messageDelimiter: String? = noImpl
        public var connectTimeout: Number? = noImpl
        public var reconnectInterval: Number? = noImpl
        public var dropHeaders: Boolean? = noImpl
        public var uuid: Number? = noImpl
        public var async: Boolean? = noImpl
        public var shared: Boolean? = noImpl
        public var readResponsesHeaders: Boolean? = noImpl
        public var maxReconnectOnClose: Number? = noImpl
        public var enableProtocol: Boolean? = noImpl
        public var pollingInterval: Number? = noImpl
        public var onError: ((response: Response? = null) -> Unit)? = noImpl
        public var onClose: ((response: Response? = null) -> Unit)? = noImpl
        public var onOpen: ((response: Response? = null) -> Unit)? = noImpl
        public var onMessage: ((response: Response) -> Unit)? = noImpl
        public var onReopen: ((request: Request? = null, response: Response? = null) -> Unit)? = noImpl
        public var onReconnect: ((request: Request? = null, response: Response? = null) -> Unit)? = noImpl
        public var onMessagePublished: ((response: Response? = null) -> Unit)? = noImpl
        public var onTransportFailure: ((reason: String? = null, response: Response? = null) -> Unit)? = noImpl
        public var onLocalMessage: ((request: Request? = null) -> Unit)? = noImpl
        public var onFailureToReconnect: ((request: Request? = null, response: Response? = null) -> Unit)? = noImpl
        public var onClientTimeout: ((request: Request? = null) -> Unit)? = noImpl
        public var subscribe: ((options: Request) -> Unit)? = noImpl
        public var execute: (() -> Unit)? = noImpl
        public var close: (() -> Unit)? = noImpl
        public var disconnect: (() -> Unit)? = noImpl
        public var getUrl: (() -> String)? = noImpl
        public var push: ((message: String, dispatchUrl: String? = null) -> Unit)? = noImpl
        public var getUUID: (() -> Unit)? = noImpl
        public var pushLocal: ((message: String) -> Unit)? = noImpl
    }
    public trait Response {
        public var status: Number? = noImpl
        public var reasonPhrase: String? = noImpl
        public var responseBody: String? = noImpl
        public var messages: Array<String>? = noImpl
        public var headers: Array<String>? = noImpl
        public var state: String? = noImpl
        public var transport: String? = noImpl
        public var error: String? = noImpl
        public var request: Request? = noImpl
        public var partialMessage: String? = noImpl
        public var errorHandled: Boolean? = noImpl
        public var closedByClientTimeout: Boolean? = noImpl
    }
}
native
public var atmosphere: Atmosphere.Atmosphere = noImpl
