package overloadedFunctions

external interface BrowserifyObject : NodeJS.EventEmitter {
    fun add(file: String): BrowserifyObject
    fun require(file: String): BrowserifyObject
}
external interface Options {
    var entries: Array<String>? get() = noImpl; set(value){}
    var noParse: Array<String>? get() = noImpl; set(value){}
}
@module("browserify")
fun browserify(): BrowserifyObject = noImpl
@module("browserify")
fun browserify(files: Array<String>): BrowserifyObject = noImpl
@module("browserify")
fun browserify(opts: Options): BrowserifyObject = noImpl
