package bootbox

@native
interface BootboxBaseOptions {
    var title: dynamic /* String | Element */? = noImpl
    var callback: ((result: dynamic /* Boolean | String */) -> Any)? = noImpl
    var onEscape: (() -> dynamic /* Any | Boolean */)? = noImpl
    var show: Boolean? = noImpl
    var backdrop: Boolean? = noImpl
    var closeButton: Boolean? = noImpl
    var animate: Boolean? = noImpl
    var className: String? = noImpl
    var size: String? = noImpl
    var buttons: BootboxButtonMap? = noImpl
}
@native
interface BootboxDialogOptions : BootboxBaseOptions {
    var message: dynamic /* String | Element */
}
@native
interface BootboxAlertOptions : BootboxDialogOptions {
    var callback: (() -> Any)? = noImpl
    override var buttons: BootboxAlertButtonMap? = noImpl
}
@native
interface BootboxConfirmOptions : BootboxDialogOptions {
    var callback: (result: Boolean) -> Any
    override var buttons: BootboxConfirmPromptButtonMap? = noImpl
}
@native
interface BootboxPromptOptions : BootboxBaseOptions {
    var title: String
    var value: String? = noImpl
    var callback: (result: String) -> Any
    override var buttons: BootboxConfirmPromptButtonMap? = noImpl
}
@native
interface BootboxDefaultOptions {
    var locale: String? = noImpl
    var show: Boolean? = noImpl
    var backdrop: Boolean? = noImpl
    var closeButton: Boolean? = noImpl
    var animate: Boolean? = noImpl
    var className: String? = noImpl
}
@native
interface BootboxButton {
    var label: String? = noImpl
    var className: String? = noImpl
    var callback: (() -> Any)? = noImpl
}
@native
interface BootboxButtonMap {
    @nativeGetter
    fun get(key: String): dynamic /* BootboxButton | Function */
    @nativeSetter
    fun set(key: String, value: dynamic /* BootboxButton | Function */)
}
@native
interface BootboxAlertButtonMap : BootboxButtonMap {
    var ok: dynamic /* BootboxButton | Function */
}
@native
interface BootboxConfirmPromptButtonMap : BootboxButtonMap {
    var confirm: dynamic /* BootboxButton | Function */
    var cancel: dynamic /* BootboxButton | Function */
}
@native
interface BootboxLocaleValues {
    var OK: String
    var CANCEL: String
    var CONFIRM: String
}
@native
interface BootboxStatic {
    fun alert(message: String, callback: (() -> Unit)? = null): JQuery
    fun alert(options: BootboxAlertOptions): JQuery
    fun confirm(message: String, callback: (result: Boolean) -> Unit): JQuery
    fun confirm(options: BootboxConfirmOptions): JQuery
    fun prompt(message: String, callback: (result: String) -> Unit): JQuery
    fun prompt(options: BootboxPromptOptions): JQuery
    fun dialog(message: String, callback: ((result: String) -> Unit)? = null): JQuery
    fun dialog(options: BootboxDialogOptions): JQuery
    fun setDefaults(options: BootboxDefaultOptions)
    fun hideAll()
    fun addLocale(name: String, values: BootboxLocaleValues)
    fun removeLocale(name: String)
    fun setLocale(name: String)
}
@native
@module("bootbox")
var bootbox: BootboxStatic = noImpl
