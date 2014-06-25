// OUT:
// WRONG DECLARATIONS
package asciify

native
public trait AsciifyOptions {
    public var font: String?
    public var maxWidth: Number?
    public var color: String?
}
native
public trait AsciifyCallback {
    public fun invoke(err: Any, asciifiedText: String): Unit
}
module
public object asciify {
    module("asciify")
    public fun asciify(text: String, callback: AsciifyCallback): Unit = noImpl
    module("asciify")
    public fun asciify(text: String, options: String, callback: AsciifyCallback): Unit = noImpl
    module("asciify")
    public fun asciify(text: String, options: AsciifyOptions, callback: AsciifyCallback): Unit = noImpl

    // missed
    // function getFonts(callback: (err: Error, fonts: string[]) => void): void;
}
