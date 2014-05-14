package overloadedFunctions

native
public trait BrowserifyObject : NodeJS.EventEmitter  {
    public fun add(file: String): BrowserifyObject
    public fun require(file: String): BrowserifyObject
}
native
public trait Options {
    public var entries: Array<String>?
    public var noParse: Array<String>?
}
module
public fun browserify(): BrowserifyObject = noImpl
module
public fun browserify(files: Array<String>): BrowserifyObject = noImpl
module
public fun browserify(opts: Options): BrowserifyObject = noImpl
