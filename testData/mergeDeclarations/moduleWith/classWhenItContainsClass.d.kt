package classWhenItContainsClass.ws

@JsModule("ws")
external open class WebSocket(address: String) : events.EventEmitter {
    open fun connect(): Boolean = definedExternally
}

// ------------------------------------------------------------------------------------------
@file:JsModule("ws")
package classWhenItContainsClass.ws.WebSocket

external open class Server {
    open fun start(): Unit = definedExternally
}
