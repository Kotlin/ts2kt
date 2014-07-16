package bufferstream

native
public trait `T$0` {
    public var warn: Boolean
}
module("bufferstream")
public class BufferStream(options: BufferStream.Opts? = null) : stream.Duplex  {
    public fun setSize(size: String): Unit = noImpl
    public fun setSize(size: Number): Unit = noImpl
    public fun enable(): Unit = noImpl
    public fun disable(): Unit = noImpl
    public fun disable(token: String, vararg tokens: String): Unit = noImpl
    public fun disable(tokens: Array<String>): Unit = noImpl
    public fun disable(token: Buffer, vararg tokens: Buffer): Unit = noImpl
    public fun disable(tokens: Array<Buffer>): Unit = noImpl
    public fun split(token: String, vararg tokens: String): Unit = noImpl
    public fun split(tokens: Array<String>): Unit = noImpl
    public fun split(token: Buffer, vararg tokens: Buffer): Unit = noImpl
    public fun split(tokens: Array<Buffer>): Unit = noImpl
    public fun getBuffer(): Buffer = noImpl
    public var buffer: Buffer = noImpl
    public fun toString(): String = noImpl
    public var length: Number = noImpl
    public class object {
        public trait Opts {
            public var encoding: String?
            public var blocking: Boolean?
            public var size: Any?
            public var disabled: Boolean?
            public var split: Any?
        }
        public var fn: `T$0` = noImpl
    }
}
module("bufferstream/postbuffer")
public class PostBuffer(req: http.ServerRequest) : BufferStream {
    public fun onEnd(callback: (data: Any) -> Unit): Unit = noImpl
    public fun pipe(stream: NodeJS.WritableStream, options: BufferStream.Opts? = null): NodeJS.ReadableStream = noImpl
}
