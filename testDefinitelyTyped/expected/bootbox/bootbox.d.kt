package bootbox

@native
interface BootboxAlertOptions {
    var message: String
    var callback: (() -> Any)? = noImpl
}
@native
interface BootboxConfirmOptions {
    var message: String
    var callback: ((result: Boolean) -> Any)? = noImpl
}
@native
interface BootboxPromptOptions {
    var message: String
    var callback: ((result: String) -> Any)? = noImpl
}
@native
interface BootboxButton {
    var label: String? = noImpl
    var className: String? = noImpl
    var callback: (() -> Any)? = noImpl
}
@native
interface BootboxDialogOptions {
    var message: dynamic /* String | Element */
    var title: dynamic /* String | Element */? = noImpl
    var callback: ((result: Boolean) -> Any)? = noImpl
    var show: Boolean? = noImpl
    var onEscape: (() -> Any)? = noImpl
    var backdrop: Boolean? = noImpl
    var closeButton: Boolean? = noImpl
    var animate: Boolean? = noImpl
    var className: String? = noImpl
    var buttons: Object? = noImpl
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
interface BootboxStatic {
    fun alert(message: String, callback: (() -> Unit)? = null)
    fun alert(options: BootboxAlertOptions)
    fun confirm(message: String, callback: ((result: Boolean) -> Unit)? = null)
    fun confirm(options: BootboxConfirmOptions)
    fun prompt(message: String, callback: ((result: String) -> Unit)? = null)
    fun prompt(options: BootboxPromptOptions)
    fun dialog(message: String, callback: ((result: String) -> Unit)? = null)
    fun dialog(options: BootboxDialogOptions)
    fun setDefaults(options: BootboxDefaultOptions)
    fun hideAll()
}
@native
var bootbox: BootboxStatic = noImpl
