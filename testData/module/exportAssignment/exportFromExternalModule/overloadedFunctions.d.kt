[file: nativePackageRoot]
package overloadedFunctions

native
public trait BrowserifyObject : NodeJS.EventEmitter {
    public fun add(file: String): BrowserifyObject
    public fun require(file: String): BrowserifyObject
}
native
public trait Options {
    public var entries: Array<String>? = noImpl
    public var noParse: Array<String>? = noImpl
}

/* ============= */
[file: nativeModulePart]
package overloadedFunctions.browserify

nativeModule
public fun browserify(): BrowserifyObject = noImpl
nativeModule
public fun browserify(files: Array<String>): BrowserifyObject = noImpl
nativeModule
public fun browserify(opts: Options): BrowserifyObject = noImpl
