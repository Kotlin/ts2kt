// OUT:
package ansicolors

module
public object ansicolors {
    public trait `T$0` {
        nativeGetter
        public fun get(index: String): (s: String) -> String
        nativeSetter
        public fun set(index: String, value: (s: String) -> String)
    }
    module("ansicolors") // TODO ???
    public var colors: `T$0` = noImpl
}
