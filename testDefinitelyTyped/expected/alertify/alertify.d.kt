package alertify

@native
@module
interface alertify {
    interface IAlertifyStatic {
        fun alert(message: String, fn: Function? = null, cssClass: String? = null): IAlertifyStatic
        fun confirm(message: String, fn: Function? = null, cssClass: String? = null): IAlertifyStatic
        fun extend(type: String): (message: String, wait: Number? = null) -> IAlertifyStatic
        fun init()
        fun log(message: String, type: String? = null, wait: Number? = null): IAlertifyStatic
        fun prompt(message: String, fn: Function? = null, placeholder: String? = null, cssClass: String? = null): IAlertifyStatic
        fun success(message: String): IAlertifyStatic
        fun error(message: String): IAlertifyStatic
        fun set(args: IProperties)
        var labels: ILabels
        fun debug()
    }
    interface IProperties {
        var delay: Number? get() = noImpl
        var labels: ILabels? get() = noImpl
        var buttonFocus: String? get() = noImpl
        var buttonReverse: Boolean? get() = noImpl
    }
    interface ILabels {
        var ok: String? get() = noImpl
        var cancel: String? get() = noImpl
    }
    companion object : alertify.IAlertifyStatic by noImpl: alertify.IAlertifyStatic {

    }
}
