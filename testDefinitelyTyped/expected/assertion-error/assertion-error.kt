// OUT:
// WRONG package
package assertion-error

module("assertion-error")
public class AssertionError(message: String, props: Any? = null, ssf: Function? = null) : Error {
    public var name: String = noImpl
    public var message: String = noImpl
    public var showDiff: Boolean = noImpl
    public var stack: String = noImpl
}
