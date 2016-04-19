package classWhenItContainsClass

@module("ws")
open class WebSocket(address: String) : events.EventEmitter() {
    open fun connect(): Boolean = noImpl
    companion object {
        open class Server {
            open fun start(): Unit = noImpl
        }
    }
}
