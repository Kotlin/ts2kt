package bootstrap.timepicker

@native
interface TimeickerOptions {
    var defaultTime: String? = noImpl
    var disableFocus: Boolean? = noImpl
    var isOpen: Boolean? = noImpl
    var minuteStep: Number? = noImpl
    var modalBackdrop: Boolean? = noImpl
    var secondStep: Number? = noImpl
    var showSeconds: Boolean? = noImpl
    var showInputs: Boolean? = noImpl
    var showMeridian: Boolean? = noImpl
    var template: String? = noImpl
    var appendWidgetTo: String? = noImpl
}
@native
fun JQuery.timepicker(): JQuery = noImpl
@native
fun JQuery.timepicker(methodName: String): JQuery = noImpl
@native
fun JQuery.timepicker(methodName: String, params: Any): JQuery = noImpl
@native
fun JQuery.timepicker(options: TimeickerOptions): JQuery = noImpl
