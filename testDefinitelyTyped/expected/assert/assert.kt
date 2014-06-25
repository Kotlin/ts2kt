// OUT:
package assert

native
module("power-assert")
public fun assert(value: Any, message: String? = null): Unit = noImpl
native
public trait `T$0` {
    public var message: String?
    public var actual: Any?
    public var expected: Any?
    public var operator: String?
    public var stackStartFunction: Function?
}
native
public trait `T$1` {
    public fun invoke(block: Function, message: String? = null): Unit
    public fun invoke(block: Function, error: Function, message: String? = null): Unit
    public fun invoke(block: Function, error: RegExp, message: String? = null): Unit
    public fun invoke(block: Function, error: (err: Any) -> Boolean, message: String? = null): Unit
}
module("power-assert")
public object assert {
    public class AssertionError(options: `T$0`? = null) : Error {
        public var name: String = noImpl
        public var message: String = noImpl
        public var actual: Any = noImpl
        public var expected: Any = noImpl
        public var operator: String = noImpl
        public var generatedMessage: Boolean = noImpl
    }
    public fun fail(actual: Any? = null, expected: Any? = null, message: String? = null, operator: String? = null): Unit = noImpl
    public fun ok(value: Any, message: String? = null): Unit = noImpl
    public fun equal(actual: Any, expected: Any, message: String? = null): Unit = noImpl
    public fun notEqual(actual: Any, expected: Any, message: String? = null): Unit = noImpl
    public fun deepEqual(actual: Any, expected: Any, message: String? = null): Unit = noImpl
    public fun notDeepEqual(acutal: Any, expected: Any, message: String? = null): Unit = noImpl
    public fun strictEqual(actual: Any, expected: Any, message: String? = null): Unit = noImpl
    public fun notStrictEqual(actual: Any, expected: Any, message: String? = null): Unit = noImpl
    public var throws: `T$1` = noImpl
    public var doesNotThrow: `T$1` = noImpl
    public fun ifError(value: Any): Unit = noImpl
}
module
public object power-assert {

}
