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
        var delay: Number? = noImpl
        var labels: ILabels? = noImpl
        var buttonFocus: String? = noImpl
        var buttonReverse: Boolean? = noImpl
    }
    interface ILabels {
        var ok: String? = noImpl
        var cancel: String? = noImpl
    }
    companion object : alertify.IAlertifyStatic by noImpl: alertify.IAlertifyStatic {

    }
}
