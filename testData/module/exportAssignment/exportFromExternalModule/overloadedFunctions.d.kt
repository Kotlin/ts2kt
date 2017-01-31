package overloadedFunctions

external interface BrowserifyObject : NodeJS.EventEmitter {
    fun add(file: String): BrowserifyObject
    fun require(file: String): BrowserifyObject
}
external interface Options {
    var entries: Array<String>? get() = definedExternally; set(value) = definedExternally
    var noParse: Array<String>? get() = definedExternally; set(value) = definedExternally
}
@module("browserify")
fun browserify(): BrowserifyObject = definedExternally
@module("browserify")
fun browserify(files: Array<String>): BrowserifyObject = definedExternally
@module("browserify")
fun browserify(opts: Options): BrowserifyObject = definedExternally
