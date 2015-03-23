package browserify

native
public trait `T$0` {
    public var expose: String
}
native
public trait `T$1` {
    public var insertGlobals: Boolean? = noImpl
    public var detectGlobals: Boolean? = noImpl
    public var debug: Boolean? = noImpl
    public var standalone: String? = noImpl
    public var insertGlobalVars: Any? = noImpl
}
native
public trait BrowserifyObject : NodeJS.EventEmitter {
    public fun add(file: String): BrowserifyObject
    public fun require(file: String, opts: `T$0`? = null): BrowserifyObject
    public fun bundle(opts: `T$1`? = null, cb: ((err: Any, src: Any) -> Unit)? = null): NodeJS.ReadableStream
    public fun external(file: String): BrowserifyObject
    public fun ignore(file: String): BrowserifyObject
    public fun transform(tr: String): BrowserifyObject
    public fun transform(tr: Function): BrowserifyObject
    public fun plugin(plugin: String, opts: Any? = null): BrowserifyObject
    public fun plugin(plugin: Function, opts: Any? = null): BrowserifyObject
}
native
public trait `T$2` {
    public var entries: Array<String>? = noImpl
    public var noParse: Array<String>? = noImpl
}
native
public trait Browserify {
    nativeInvoke
    public fun invoke(): BrowserifyObject
    nativeInvoke
    public fun invoke(files: Array<String>): BrowserifyObject
    nativeInvoke
    public fun invoke(opts: `T$2`): BrowserifyObject
}
module
public var browserify: Browserify = noImpl
