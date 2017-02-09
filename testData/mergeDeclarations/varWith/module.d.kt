package module

@JsModule("lodash")
external var _: _.LoDashStatic = definedExternally

// ------------------------------------------------------------------------------------------
@file:JsModule("lodash")
package module._

interface LoDashStatic {
    @nativeInvoke
    fun invoke(value: Number): LoDashWrapper<Number>
    var VERSION: String
    var support: Support
}
interface Support {
    var argsClass: Boolean
    var argsObject: Boolean
}
interface LoDashArrayWrapper<T> {
    fun difference(vararg others: Array<T>): LoDashArrayWrapper<T>
    fun difference(vararg others: List<T>): LoDashArrayWrapper<T>
}
