// OUT: TODO fix crash
package bufferstream

module("bufferstream")
public open class BufferStream(options: BufferStream.Opts? = null) : stream.Duplex() {
    public open fun setSize(size: String): Unit = noImpl
    public open fun setSize(size: Number): Unit = noImpl
    public open fun enable(): Unit = noImpl
    public open fun disable(): Unit = noImpl
    public open fun disable(token: String, vararg tokens: String): Unit = noImpl
    public open fun disable(tokens: Array<String>): Unit = noImpl
    public open fun disable(token: Buffer, vararg tokens: Buffer): Unit = noImpl
    public open fun disable(tokens: Array<Buffer>): Unit = noImpl
    public open fun split(token: String, vararg tokens: String): Unit = noImpl
    public open fun split(tokens: Array<String>): Unit = noImpl
    public open fun split(token: Buffer, vararg tokens: Buffer): Unit = noImpl
    public open fun split(tokens: Array<Buffer>): Unit = noImpl
    public open fun getBuffer(): Buffer = noImpl
    public open var buffer: Buffer = noImpl
    override fun toString(): String = noImpl
    public open var length: Number = noImpl
    public class object {
        public trait Opts {
            public var encoding: String? = noImpl
            public var blocking: Boolean? = noImpl
            public var size: Any? = noImpl
            public var disabled: Boolean? = noImpl
            public var split: Any? = noImpl
        }
        public trait `T$0` {
            public var warn: Boolean
        }
        public var fn: `T$0` = noImpl
    }
}
module("bufferstream/postbuffer")
public open class PostBuffer(req: http.ServerRequest) : BufferStream() {
    public open fun onEnd(callback: (data: Any) -> Unit): Unit = noImpl
    override fun pipe(stream: NodeJS.WritableStream, options: BufferStream.Opts?): NodeJS.ReadableStream = noImpl
}
