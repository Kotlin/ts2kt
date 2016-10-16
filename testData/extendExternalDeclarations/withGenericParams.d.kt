package withGenericParams

@module
object Q {
    @native
    fun <T, B> Promise<T>.foo(b: B): T = noImpl
    @native
    fun <T0, T, B> Promise<T0>.foo(a: Any, b: B): T = noImpl
    @native
    var <T> Promise<T>.bar: Array<T> get() = noImpl
}
@module
object ref-array {
    interface ArrayType<T> {
        @nativeGetter
        fun get(prop: String): Number?
        @nativeSetter
        fun set(prop: String, value: Number)
        var someField: String
        var optionalField: T? get() = noImpl
        @nativeInvoke
        fun invoke(resourceId: String, hash: Any? = null, callback: Function? = null)
    }
}
