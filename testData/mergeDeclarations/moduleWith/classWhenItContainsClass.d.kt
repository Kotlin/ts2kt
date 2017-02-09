package classWhenItContainsClass

@JsModule("ws")
open class WebSocket(address: String) : events.EventEmitter {
    open fun connect(): Boolean = definedExternally
}
