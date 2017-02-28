package module

@JsModule("lodash")
external val _: _.LoDashStatic = definedExternally

// ------------------------------------------------------------------------------------------
@file:[JsQualifier("_"), JsModule("lodash")]
package module._

external interface LoDashStatic {
    @nativeInvoke
    fun invoke(value: Number): LoDashWrapper<Number>
    var VERSION: String
    var support: Support
}
external interface Support {
    var argsClass: Boolean
    var argsObject: Boolean
}
external interface LoDashArrayWrapper<T> {
    fun difference(vararg others: Array<T>): LoDashArrayWrapper<T>
    fun difference(vararg others: List<T>): LoDashArrayWrapper<T>
}
