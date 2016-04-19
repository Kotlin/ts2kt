package withGenericParams

@module
object Q {
    @native
    fun <T, B> Promise<T>.foo(b: B): T = noImpl
    @native
    fun <T0, T, B> Promise<T0>.foo(a: Any, b: B): T = noImpl
    @native
    var <T> Promise<T>.bar: Array<T> = noImpl
}
@module
object ref-array {
    @native
    @nativeGetter
    fun <T> ArrayType<T>.get(prop: String): Number = noImpl
    @native
    @nativeSetter
    fun <T> ArrayType<T>.set(prop: String, value: Number): Unit = noImpl
    @native
    var <T> ArrayType<T>.someField: String = noImpl
    @native
    var <T> ArrayType<T>.optionalField: T? = noImpl
    @native
    @nativeInvoke
    fun <T> ArrayType<T>.invoke(resourceId: String, hash: Any? = null, callback: Function? = null): Unit = noImpl
}
