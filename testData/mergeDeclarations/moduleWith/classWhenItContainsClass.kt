package classWhenItContainsClass

module("ws")
public class WebSocket(address: String) : events.EventEmitter() {
    public fun connect(): Boolean = noImpl
    public class object {
        public class Server {
            public fun start(): Unit = noImpl
        }
    }
}
