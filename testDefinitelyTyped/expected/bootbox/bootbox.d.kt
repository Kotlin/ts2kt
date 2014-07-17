package bootbox

native
public trait BootboxLocale {
    public var OK: String
    public var CANCEL: String
    public var CONFIRM: String
}
native
public trait BootboxIcons {
    public var OK: Any
    public var CANCEL: Any
    public var CONFIRM: Any
}
native
public trait BootboxHandler {
    public var label: String
    public var `class`: String
    public var callback: (result: Any? = null) -> Unit
}
native
public trait BootboxOption {
    public var header: String
    public var headerCloseButton: Boolean
}
native
public trait BootboxStatic {
    public fun alert(message: String, callback: () -> Unit)
    public fun alert(message: String, customButtonText: String? = null, callback: (() -> Unit)? = null)
    public fun confirm(message: String, callback: (result: Boolean) -> Unit)
    public fun confirm(message: String, cancelButtonText: String? = null, confirmButtonText: String? = null, callback: ((result: Boolean) -> Unit)? = null)
    public fun prompt(message: String, callback: (result: String) -> Unit, defaultValue: String? = null)
    public fun prompt(message: String, cancelButtonText: String? = null, confirmButtonText: String? = null, callback: ((result: String) -> Unit)? = null, defaultValue: String? = null)
    public fun dialog(message: String, handlers: Array<BootboxHandler>, options: Any? = null)
    public fun dialog(message: String, handler: BootboxHandler)
    public fun dialog(message: String)
    public fun hideAll()
    public fun animate(shouldAnimate: Boolean)
    public fun backdrop(backdropValue: String)
    public fun classes(customCssClasses: String)
    public fun setIcons(icons: BootboxIcons)
    public fun setLocale(localeName: String)
    public fun addLocale(localeName: String, translations: BootboxLocale)
}
native
public var bootbox: BootboxStatic = noImpl
