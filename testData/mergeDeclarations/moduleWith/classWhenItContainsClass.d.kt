package classWhenItContainsClass

@JsModule("ws")
external open class WebSocket(address: String) : events.EventEmitter {
    open fun connect(): Boolean = definedExternally
}
