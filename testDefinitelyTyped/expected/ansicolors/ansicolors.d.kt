package ansicolors

module
public object ansicolors {
    public trait `T$0` {
        public fun get(index: String): (s: String) -> String
        public fun set(index: String, value: (s: String) -> String)
    }
    module("ansicolors") // ???
    public var colors: `T$0` = noImpl
}
