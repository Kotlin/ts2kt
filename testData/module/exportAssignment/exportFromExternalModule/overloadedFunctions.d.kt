package overloadedFunctions

@native
interface BrowserifyObject : NodeJS.EventEmitter {
    fun add(file: String): BrowserifyObject
    fun require(file: String): BrowserifyObject
}
@native
interface Options {
    var entries: Array<String>? = noImpl
    var noParse: Array<String>? = noImpl
}
@module("browserify")
fun browserify(): BrowserifyObject = noImpl
@module("browserify")
fun browserify(files: Array<String>): BrowserifyObject = noImpl
@module("browserify")
fun browserify(opts: Options): BrowserifyObject = noImpl
