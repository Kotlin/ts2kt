package withGenericParams

@module
object Q {
    external fun <T, B> Promise<T>.foo(b: B): T = noImpl
    external fun <T0, T, B> Promise<T0>.foo(a: Any, b: B): T = noImpl
    external var <T> Promise<T>.bar: Array<T> get() = noImpl; set(value){}
}
@module
object ref-array {
    interface ArrayType<T> {
        @nativeGetter
        fun get(prop: String): Number?
        @nativeSetter
        fun set(prop: String, value: Number)
        var someField: String
        var optionalField: T? get() = noImpl; set(value){}
        @nativeInvoke
        fun invoke(resourceId: String, hash: Any? = null, callback: Function? = null)
    }
}
