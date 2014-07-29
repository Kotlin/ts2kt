package classWhenItContainsClass

module("ws")
public open class WebSocket(address: String) : events.EventEmitter() {
    public open fun connect(): Boolean = noImpl
    public class object {
        public open class Server {
            public open fun start(): Unit = noImpl
        }
    }
}
