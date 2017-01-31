package classWhenItContainsClass

@module("ws")
open class WebSocket(address: String) : events.EventEmitter() {
    open fun connect(): Boolean = definedExternally
    companion object {
        open class Server {
            open fun start(): Unit = definedExternally
        }
    }
}
