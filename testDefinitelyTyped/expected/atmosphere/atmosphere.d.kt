package atmosphere

module
public object Atmosphere {
    public trait Atmosphere {
        public var subscribe: ((requestOrUrl: Any, callback: Function? = null, request: Request? = null) -> Request)?
        public var unsubscribe: (() -> Unit)?
        public var AtmosphereRequest: AtmosphereRequest?
    }
    public trait AtmosphereRequest {
        public fun invoke(): Request
    }
    public trait Request {
        public var timeout: Number?
        public var method: String?
        public var headers: Any?
        public var contentType: String?
        public var callback: Function?
        public var url: String?
        public var data: String?
        public var suspend: Boolean?
        public var maxRequest: Number?
        public var reconnect: Boolean?
        public var maxStreamingLength: Number?
        public var lastIndex: Number?
        public var logLevel: String?
        public var requestCount: Number?
        public var fallbackMethod: String?
        public var fallbackTransport: String?
        public var transport: String?
        public var webSocketImpl: Any?
        public var webSocketBinaryType: Any?
        public var dispatchUrl: String?
        public var webSocketPathDelimiter: String?
        public var enableXDR: Boolean?
        public var rewriteURL: Boolean?
        public var attachHeadersAsQueryString: Boolean?
        public var executeCallbackBeforeReconnect: Boolean?
        public var readyState: Number?
        public var lastTimestamp: Number?
        public var withCredentials: Boolean?
        public var trackMessageLength: Boolean?
        public var messageDelimiter: String?
        public var connectTimeout: Number?
        public var reconnectInterval: Number?
        public var dropHeaders: Boolean?
        public var uuid: Number?
        public var async: Boolean?
        public var shared: Boolean?
        public var readResponsesHeaders: Boolean?
        public var maxReconnectOnClose: Number?
        public var enableProtocol: Boolean?
        public var pollingInterval: Number?
        public var onError: ((response: Response? = null) -> Unit)?
        public var onClose: ((response: Response? = null) -> Unit)?
        public var onOpen: ((response: Response? = null) -> Unit)?
        public var onMessage: ((response: Response) -> Unit)?
        public var onReopen: ((request: Request? = null, response: Response? = null) -> Unit)?
        public var onReconnect: ((request: Request? = null, response: Response? = null) -> Unit)?
        public var onMessagePublished: ((response: Response? = null) -> Unit)?
        public var onTransportFailure: ((reason: String? = null, response: Response? = null) -> Unit)?
        public var onLocalMessage: ((request: Request? = null) -> Unit)?
        public var onFailureToReconnect: ((request: Request? = null, response: Response? = null) -> Unit)?
        public var onClientTimeout: ((request: Request? = null) -> Unit)?
        public var subscribe: ((options: Request) -> Unit)?
        public var execute: (() -> Unit)?
        public var close: (() -> Unit)?
        public var disconnect: (() -> Unit)?
        public var getUrl: (() -> String)?
        public var push: ((message: String, dispatchUrl: String? = null) -> Unit)?
        public var getUUID: (() -> Unit)?
        public var pushLocal: ((message: String) -> Unit)?
    }
    public trait Response {
        public var status: Number?
        public var reasonPhrase: String?
        public var responseBody: String?
        public var messages: Array<String>?
        public var headers: Array<String>?
        public var state: String?
        public var transport: String?
        public var error: String?
        public var request: Request?
        public var partialMessage: String?
        public var errorHandled: Boolean?
        public var closedByClientTimeout: Boolean?
    }
}
native
public var atmosphere: Atmosphere.Atmosphere = noImpl
