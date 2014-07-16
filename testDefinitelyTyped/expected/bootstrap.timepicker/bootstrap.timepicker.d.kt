package bootstrap.timepicker

native
public trait TimeickerOptions {
    public var defaultTime: String? = noImpl
    public var disableFocus: Boolean? = noImpl
    public var isOpen: Boolean? = noImpl
    public var minuteStep: Number? = noImpl
    public var modalBackdrop: Boolean? = noImpl
    public var secondStep: Number? = noImpl
    public var showSeconds: Boolean? = noImpl
    public var showInputs: Boolean? = noImpl
    public var showMeridian: Boolean? = noImpl
    public var template: String? = noImpl
    public var appendWidgetTo: String? = noImpl
}
native
public fun JQuery.timepicker(): JQuery = noImpl
native
public fun JQuery.timepicker(methodName: String): JQuery = noImpl
native
public fun JQuery.timepicker(methodName: String, params: Any): JQuery = noImpl
native
public fun JQuery.timepicker(options: TimeickerOptions): JQuery = noImpl
