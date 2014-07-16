package overloadedFunctions

native
public trait BrowserifyObject : NodeJS.EventEmitter {
    public fun add(file: String): BrowserifyObject
    public fun require(file: String): BrowserifyObject
}
native
public trait Options {
    public var entries: Array<String>?
    public var noParse: Array<String>?
}
module("browserify")
public fun browserify(): BrowserifyObject = noImpl
module("browserify")
public fun browserify(files: Array<String>): BrowserifyObject = noImpl
module("browserify")
public fun browserify(opts: Options): BrowserifyObject = noImpl
