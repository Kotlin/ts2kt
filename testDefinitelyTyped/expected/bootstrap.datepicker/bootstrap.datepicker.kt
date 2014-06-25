// OUT:
// WRONG
package bootstrap.datepicker

native
public trait DatepickerOptions {
    public var format: String?
    public var weekStart: Number?
    public var startDate: Any?
    public var endDate: Any?
    public var autoclose: Boolean?
    public var startView: Number?
    public var todayBtn: Any?
    public var todayHighlight: Boolean?
    public var keyboardNavigation: Boolean?
    public var language: String?
}
native
public trait DatepickerEventObject : JQueryEventObject {
    public var date: Date
    public fun format(format: String? = null): String
}
native
public trait JQuery {
    // should be extensions
    public fun datepicker(): JQuery
    public fun datepicker(methodName: String): JQuery
    public fun datepicker(methodName: String, params: Any): JQuery
    public fun datepicker(options: DatepickerOptions): JQuery
    // WRONG
    public fun off(events: "changeDate", selector: String? = null, handler: ((eventObject: DatepickerEventObject) -> Any)? = null): JQuery
    public fun off(events: "changeDate", handler: (eventObject: DatepickerEventObject) -> Any): JQuery
    public fun on(events: "changeDate", selector: String, data: Any, handler: ((eventObject: DatepickerEventObject) -> Any)? = null): JQuery
    public fun on(events: "changeDate", selector: String, handler: (eventObject: DatepickerEventObject) -> Any): JQuery
    public fun on(events: 'changeDate', handler: (eventObject: DatepickerEventObject) -> Any): JQuery
}
