package module

native
module("lodash")
public trait _ {
    public trait LoDashStatic {
        nativeInvoke
        public fun invoke(value: Number): LoDashWrapper<Number>
        public var VERSION: String
        public var support: Support
    }
    public trait Support {
        public var argsClass: Boolean
        public var argsObject: Boolean
    }
    public trait LoDashArrayWrapper<T> {
        public fun difference(vararg others: Array<T>): LoDashArrayWrapper<T>
        public fun difference(vararg others: List<T>): LoDashArrayWrapper<T>
    }
    public class object : _.LoDashStatic by noImpl: _.LoDashStatic {

    }
}
