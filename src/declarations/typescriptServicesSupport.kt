package typescript

@native
interface JsArray<T>

@native
interface JsMap<T> {
    @nativeGetter
    fun get(index: String): T
    @nativeSetter
    fun set(index: String, value: T)
}
