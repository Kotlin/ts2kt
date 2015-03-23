package bootbox

native
public trait BootboxAlertOptions {
    public var message: String
    public var callback: (() -> Any)? = noImpl
}
native
public trait BootboxConfirmOptions {
    public var message: String
    public var callback: ((result: Boolean) -> Any)? = noImpl
}
native
public trait BootboxPromptOptions {
    public var message: String
    public var callback: ((result: String) -> Any)? = noImpl
}
native
public trait BootboxButton {
    public var label: String? = noImpl
    public var className: String? = noImpl
    public var callback: (() -> Any)? = noImpl
}
native
public trait BootboxDialogOptions {
    public var message: dynamic /* String | Element */
    public var title: dynamic /* String | Element */? = noImpl
    public var callback: ((result: Boolean) -> Any)? = noImpl
    public var show: Boolean? = noImpl
    public var onEscape: (() -> Any)? = noImpl
    public var backdrop: Boolean? = noImpl
    public var closeButton: Boolean? = noImpl
    public var animate: Boolean? = noImpl
    public var className: String? = noImpl
    public var buttons: Object? = noImpl
}
native
public trait BootboxDefaultOptions {
    public var locale: String? = noImpl
    public var show: Boolean? = noImpl
    public var backdrop: Boolean? = noImpl
    public var closeButton: Boolean? = noImpl
    public var animate: Boolean? = noImpl
    public var className: String? = noImpl
}
native
public trait BootboxStatic {
    public fun alert(message: String, callback: (() -> Unit)? = null)
    public fun alert(options: BootboxAlertOptions)
    public fun confirm(message: String, callback: ((result: Boolean) -> Unit)? = null)
    public fun confirm(options: BootboxConfirmOptions)
    public fun prompt(message: String, callback: ((result: String) -> Unit)? = null)
    public fun prompt(options: BootboxPromptOptions)
    public fun dialog(message: String, callback: ((result: String) -> Unit)? = null)
    public fun dialog(options: BootboxDialogOptions)
    public fun setDefaults(options: BootboxDefaultOptions)
    public fun hideAll()
}
native
public var bootbox: BootboxStatic = noImpl
