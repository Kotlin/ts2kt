package browserify

native
public trait `T$0` {
    public var expose: String
}
native
public trait `T$1` {
    public var insertGlobals: Boolean?
    public var detectGlobals: Boolean?
    public var debug: Boolean?
    public var standalone: String?
    public var insertGlobalVars: Any?
}
native
public trait BrowserifyObject : NodeJS.EventEmitter  {
    public fun add(file: String): BrowserifyObject
    public fun require(file: String, opts: `T$0`? = null): BrowserifyObject
    public fun bundle(opts: `T$1`? = null, cb: ((err: Any, src: Any) -> Unit)? = null): NodeJS.ReadableStream
    public fun external(file: String): BrowserifyObject
    public fun ignore(file: String): BrowserifyObject
    public fun transform(tr: String): BrowserifyObject
    public fun transform(tr: Function): BrowserifyObject
}
native
public trait `T$2` {
    public var entries: Array<String>?
    public var noParse: Array<String>?
}
module("browserify")
public fun browserify(): BrowserifyObject = noImpl
module("browserify")
public fun browserify(files: Array<String>): BrowserifyObject = noImpl
module("browserify")
public fun browserify(opts: `T$2`): BrowserifyObject = noImpl
