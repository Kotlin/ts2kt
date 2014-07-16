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
    public var class: String
    public var callback: (result: Any? = null) -> Unit
}
native
public trait BootboxOption {
    public var header: String
    public var headerCloseButton: Boolean
}
native
public trait BootboxStatic {
    public fun alert(message: String, callback: () -> Unit): Unit
    public fun alert(message: String, customButtonText: String? = null, callback: (() -> Unit)? = null): Unit
    public fun confirm(message: String, callback: (result: Boolean) -> Unit): Unit
    public fun confirm(message: String, cancelButtonText: String? = null, confirmButtonText: String? = null, callback: ((result: Boolean) -> Unit)? = null): Unit
    public fun prompt(message: String, callback: (result: String) -> Unit, defaultValue: String? = null): Unit
    public fun prompt(message: String, cancelButtonText: String? = null, confirmButtonText: String? = null, callback: ((result: String) -> Unit)? = null, defaultValue: String? = null): Unit
    public fun dialog(message: String, handlers: Array<BootboxHandler>, options: Any? = null): Unit
    public fun dialog(message: String, handler: BootboxHandler): Unit
    public fun dialog(message: String): Unit
    public fun hideAll(): Unit
    public fun animate(shouldAnimate: Boolean): Unit
    public fun backdrop(backdropValue: String): Unit
    public fun classes(customCssClasses: String): Unit
    public fun setIcons(icons: BootboxIcons): Unit
    public fun setLocale(localeName: String): Unit
    public fun addLocale(localeName: String, translations: BootboxLocale): Unit
}
native
public var bootbox: BootboxStatic = noImpl
