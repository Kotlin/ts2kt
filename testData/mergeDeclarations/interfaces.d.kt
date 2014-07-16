package interfaces

module
public object _ {
    public trait LoDashStatic {
        public fun chain(value: Number): LoDashWrapper<Number>
        public fun chain(value: String): LoDashWrapper<String>
        public fun chain(value: Boolean): LoDashWrapper<Boolean>
        public fun chain<T>(value: Array<T>): LoDashArrayWrapper<T>
        public fun chain(value: Any): LoDashWrapper<Any>
        public fun compact<T>(array: Array<T>): Array<T>
        public fun compact<T>(array: List<T>): Array<T>
    }
}
