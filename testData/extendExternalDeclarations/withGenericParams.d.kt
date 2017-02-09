@file:JsQualifier("Q")
package withGenericParams.Q

external fun <T, B> Promise<T>.foo(b: B): T = definedExternally
external fun <T0, T, B> Promise<T0>.foo(a: Any, b: B): T = definedExternally
external var <T> Promise<T>.bar: Array<T> get() = definedExternally; set(value) = definedExternally

// ------------------------------------------------------------------------------------------
@file:JsQualifier("ref-array")
package withGenericParams.ref-array

interface ArrayType<T> {
    @nativeGetter
    fun get(prop: String): Number?
    @nativeSetter
    fun set(prop: String, value: Number)
    var someField: String
    var optionalField: T? get() = definedExternally; set(value) = definedExternally
    @nativeInvoke
    fun invoke(resourceId: String, hash: Any? = definedExternally /* null */, callback: Function? = definedExternally /* null */)
}
