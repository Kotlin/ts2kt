package bootstrap.timepicker

native
public trait TimeickerOptions {
    public var defaultTime: String?
    public var disableFocus: Boolean?
    public var isOpen: Boolean?
    public var minuteStep: Number?
    public var modalBackdrop: Boolean?
    public var secondStep: Number?
    public var showSeconds: Boolean?
    public var showInputs: Boolean?
    public var showMeridian: Boolean?
    public var template: String?
    public var appendWidgetTo: String?
}
native
public trait JQuery {
    // Should be extension
    public fun timepicker(): JQuery
    public fun timepicker(methodName: String): JQuery
    public fun timepicker(methodName: String, params: Any): JQuery
    public fun timepicker(options: TimeickerOptions): JQuery
}
