[file: nativePackageRoot]
package classWhenItContainsClass

/* ============= */
[file: nativeModulePart]
package classWhenItContainsClass.ws

nativeModule("ws")
public open class WebSocket(address: String) : events.EventEmitter() {
    public open fun connect(): Boolean = noImpl
    public class object {
        public open class Server {
            public open fun start(): Unit = noImpl
        }
    }
}
