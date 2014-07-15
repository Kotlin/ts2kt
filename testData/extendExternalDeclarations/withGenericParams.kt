package withGenericParams

module
public object Q {
    native
    public fun <T, B> Promise<T>.foo(b: B): T = noImpl
    native
    public fun <T0, T, B> Promise<T0>.foo(a: Any, b: B): T = noImpl
    native
    public var <T> Promise<T>.bar: Array<T> = noImpl
}
module
public object ref-array {
    native
    public fun <T> ArrayType<T>.get(prop: String): Number = noImpl
    native
    public fun <T> ArrayType<T>.set(prop: String, value: Number): Unit = noImpl
    native
    public var <T> ArrayType<T>.someField: String = noImpl
    native
    public var <T> ArrayType<T>.optionalField: T? = noImpl
    native
    public fun <T> ArrayType<T>.invoke(resourceId: String, hash: Any? = null, callback: Function? = null): Unit = noImpl
}
