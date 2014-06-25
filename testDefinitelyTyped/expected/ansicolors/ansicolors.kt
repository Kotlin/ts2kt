package ansicolors

native
public trait `T$0` {
    public fun get(index: String): (s: String) -> String
    public fun set(index: String, value: (s: String) -> String): Unit
}
module
public var ansicolors: `T$0` = noImpl
