package browserify

@native
interface `T$0` {
    var expose: String
}
@native
interface `T$1` {
    var insertGlobals: Boolean? = noImpl
    var detectGlobals: Boolean? = noImpl
    var debug: Boolean? = noImpl
    var standalone: String? = noImpl
    var insertGlobalVars: Any? = noImpl
}
@native
interface BrowserifyObject : NodeJS.EventEmitter {
    fun add(file: String): BrowserifyObject
    fun require(file: String, opts: `T$0`? = null): BrowserifyObject
    fun bundle(opts: `T$1`? = null, cb: ((err: Any, src: Any) -> Unit)? = null): NodeJS.ReadableStream
    fun external(file: String): BrowserifyObject
    fun ignore(file: String): BrowserifyObject
    fun transform(tr: String): BrowserifyObject
    fun transform(tr: Function): BrowserifyObject
    fun plugin(plugin: String, opts: Any? = null): BrowserifyObject
    fun plugin(plugin: Function, opts: Any? = null): BrowserifyObject
}
@native
interface `T$2` {
    var entries: Array<String>? = noImpl
    var noParse: Array<String>? = noImpl
}
@native
interface Browserify {
    @nativeInvoke
    fun invoke(): BrowserifyObject
    @nativeInvoke
    fun invoke(files: Array<String>): BrowserifyObject
    @nativeInvoke
    fun invoke(opts: `T$2`): BrowserifyObject
}
@module
var browserify: Browserify = noImpl
