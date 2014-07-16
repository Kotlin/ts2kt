// OUT:
// WRONG
package bootstrap-notify

native
public trait NotifyOptions {
    public var `type`: String?
    public var closable: Boolean?
    public var transition: String?
    public var fadeOut: NotifyFadeOutSettings?
    public var message: MessageOptions?
    public var onClose: (() -> Unit)?
    public var onClosed: (() -> Unit)?
}
native
public trait NotifyFadeOutSettings {
    public var enabled: Boolean?
    public var delay: Number?
}
native
public trait MessageOptions {
    public var html: String?
    public var text: String?
}
native
public trait Notification {
    public fun show(): Unit
    public fun hide(): Unit
}
native
public trait JQuery {
    public fun notify(options: NotifyOptions): Notification
}
