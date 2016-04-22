package browserify

@module
object Browserify {
    interface FileOptions {
        var entry: Boolean? = noImpl
        var expose: String? = noImpl
        var basedir: String? = noImpl
        var file: String? = noImpl
        var external: Boolean? = noImpl
        var transform: Boolean? = noImpl
        var id: String? = noImpl
    }
    interface `T$0` {
        @nativeGetter
        fun get(builtinName: String): String
        @nativeSetter
        fun set(builtinName: String, value: String)
    }
    interface `T$1` {
        @nativeGetter
        fun get(globalName: String): (file: String, basedir: String) -> Any
        @nativeSetter
        fun set(globalName: String, value: (file: String, basedir: String) -> Any)
    }
    interface Options {
        @nativeGetter
        fun get(propName: String): Any
        @nativeSetter
        fun set(propName: String, value: Any)
        var entries: dynamic /* InputFile | Array<InputFile> */? = noImpl
        var noParse: Array<String>? = noImpl
        var extensions: Array<String>? = noImpl
        var basedir: String? = noImpl
        var paths: Array<String>? = noImpl
        var commondir: Boolean? = noImpl
        var fullPaths: Boolean? = noImpl
        var builtins: `dynamic /* Array<String> | T$0 | Boolean */`? = noImpl
        var bundleExternal: Boolean? = noImpl
        var insertGlobals: Boolean? = noImpl
        var detectGlobals: Boolean? = noImpl
        var debug: Boolean? = noImpl
        var standalone: String? = noImpl
        var insertGlobalVars: `T$1`? = noImpl
        var externalRequireName: String? = noImpl
    }
    interface BrowserifyConstructor {
        @nativeInvoke
        fun invoke(files: Array<InputFile>, opts: Options? = null): BrowserifyObject
        @nativeInvoke
        fun invoke(file: InputFile, opts: Options? = null): BrowserifyObject
        @nativeInvoke
        fun invoke(opts: Options): BrowserifyObject
        @nativeInvoke
        fun invoke(): BrowserifyObject
        @nativeNew
        fun invoke(files: Array<InputFile>, opts: Options? = null): BrowserifyObject
        @nativeNew
        fun invoke(file: InputFile, opts: Options? = null): BrowserifyObject
        @nativeNew
        fun invoke(opts: Options): BrowserifyObject
        @nativeNew
        fun invoke(): BrowserifyObject
    }
    interface `T$2` {
        var basedir: String? = noImpl
    }
    interface BrowserifyObject : NodeJS.EventEmitter {
        fun add(file: Array<InputFile>, opts: FileOptions? = null): BrowserifyObject
        fun add(file: InputFile, opts: FileOptions? = null): BrowserifyObject
        fun require(file: InputFile, opts: FileOptions? = null): BrowserifyObject
        fun bundle(cb: ((err: Any, src: Buffer) -> Any)? = null): NodeJS.ReadableStream
        fun external(file: Array<String>, opts: `T$2`? = null): BrowserifyObject
        fun external(file: String, opts: `T$2`? = null): BrowserifyObject
        fun external(file: BrowserifyObject): BrowserifyObject
        fun ignore(file: String, opts: `T$2`? = null): BrowserifyObject
        fun exclude(file: String, opts: `T$2`? = null): BrowserifyObject
        fun <T : T$2> transform(tr: String, opts: T? = null): BrowserifyObject
        fun <T : T$2> transform(tr: (file: String, opts: T) -> NodeJS.ReadWriteStream, opts: T? = null): BrowserifyObject
        fun <T : T$2> plugin(plugin: String, opts: T? = null): BrowserifyObject
        fun <T : T$2> plugin(plugin: (b: BrowserifyObject, opts: T) -> Any, opts: T? = null): BrowserifyObject
        fun reset(opts: Options? = null)
        fun on(event: Any /* "file"*/, listener: (file: String, id: String, parent: Any) -> Any): BrowserifyObject /* this */
        fun on(event: Any /* "package"*/, listener: (pkg: Any) -> Any): BrowserifyObject /* this */
        fun on(event: Any /* "bundle"*/, listener: (bundle: NodeJS.ReadableStream) -> Any): BrowserifyObject /* this */
        fun on(event: Any /* "reset"*/, listener: () -> Any): BrowserifyObject /* this */
        fun on(event: Any /* "transform"*/, listener: (tr: NodeJS.ReadWriteStream, file: String) -> Any): BrowserifyObject /* this */
        fun on(event: String, listener: Function): BrowserifyObject /* this */
        var pipeline: Any
    }
}
@module
var browserify: Browserify.BrowserifyConstructor = noImpl
