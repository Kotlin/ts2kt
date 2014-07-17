package alertify

native
module
public trait alertify {
    public trait IAlertifyStatic {
        public fun alert(message: String, fn: Function? = null, cssClass: String? = null): IAlertifyStatic
        public fun confirm(message: String, fn: Function? = null, cssClass: String? = null): IAlertifyStatic
        public fun extend(`type`: String): (message: String, wait: Number? = null) -> IAlertifyStatic
        public fun init()
        public fun log(message: String, `type`: String? = null, wait: Number? = null): IAlertifyStatic
        public fun prompt(message: String, fn: Function? = null, placeholder: String? = null, cssClass: String? = null): IAlertifyStatic
        public fun success(message: String): IAlertifyStatic
        public fun error(message: String): IAlertifyStatic
        public fun set(args: IProperties)
        public var labels: ILabels
        public fun debug()
    }
    public trait IProperties {
        public var delay: Number? = noImpl
        public var labels: ILabels? = noImpl
        public var buttonFocus: String? = noImpl
        public var buttonReverse: Boolean? = noImpl
    }
    public trait ILabels {
        public var ok: String? = noImpl
        public var cancel: String? = noImpl
    }
    public class object : alertify.IAlertifyStatic by noImpl: alertify.IAlertifyStatic {

    }
}
