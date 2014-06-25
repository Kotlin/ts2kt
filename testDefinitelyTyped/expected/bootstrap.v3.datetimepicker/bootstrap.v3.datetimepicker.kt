// OUT:
// WRONG
package bootstrap.v3.datetimepicker

module
public object BootstrapV3DatetimePicker {
    public trait DatetimepickerChangeEventObject : JQueryEventObject {
        public var date: Any
        public var oldDate: Any
    }
    public trait DatetimepickerEventObject : JQueryEventObject {
        public var date: Any
    }
    public trait DatetimepickerIcons {
        public var time: String?
        public var date: String?
        public var up: String?
        public var down: String?
    }
    public trait DatetimepickerOptions {
        public var pickDate: Boolean?
        public var pickTime: Boolean?
        public var useMinutes: Boolean?
        public var useSeconds: Boolean?
        public var useCurrent: Boolean?
        public var minuteStepping: Number?
        public var minDate: Any?
        public var maxDate: Any?
        public var showToday: Boolean?
        public var collapse: Boolean?
        public var language: String?
        public var defaultDate: String?
        public var disabledDates: Array<Any>?
        public var enabledDates: Array<Any>?
        public var icons: DatetimepickerIcons?
        public var useStrict: Boolean?
        public var direction: String?
        public var sideBySide: Boolean?
        public var daysOfWeekDisabled: Array<Any>?
    }
    public trait Datetimepicker {
        public fun setDate(date: Any): Unit
        public fun setMinDate(date: Any): Unit
        public fun setMaxDate(date: Any): Unit
        public fun show(): Unit
        public fun disable(): Unit
        public fun enable(): Unit
        public fun getDate(): Unit
    }
}
native
public trait JQuery {
    // Should be extensions
    public fun datetimepicker(): JQuery
    public fun datetimepicker(options: BootstrapV3DatetimePicker.DatetimepickerOptions): JQuery
    // WRONG
    public fun off(events: "dp.change", selector: String? = null, handler: ((eventobject: BootstrapV3DatetimePicker.DatetimepickerChangeEventObject) -> Any)? = null): JQuery
    public fun off(events: "dp.change", handler: (eventobject: BootstrapV3DatetimePicker.DatetimepickerChangeEventObject) -> Any): JQuery
    public fun on(events: "dp.change", selector: String, data: Any, handler: ((eventobject: BootstrapV3DatetimePicker.DatetimepickerChangeEventObject) -> Any)? = null): JQuery
    public fun on(events: "dp.change", selector: String, handler: (eventobject: BootstrapV3DatetimePicker.DatetimepickerChangeEventObject) -> Any): JQuery
    public fun on(events: 'dp.change', handler: (eventObject: BootstrapV3DatetimePicker.DatetimepickerChangeEventObject) -> Any): JQuery
    public fun off(events: "dp.show", selector: String? = null, handler: ((eventobject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any)? = null): JQuery
    public fun off(events: "dp.show", handler: (eventobject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any): JQuery
    public fun on(events: "dp.show", selector: String, data: Any, handler: ((eventobject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any)? = null): JQuery
    public fun on(events: "dp.show", selector: String, handler: (eventobject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any): JQuery
    public fun on(events: 'dp.show', handler: (eventObject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any): JQuery
    public fun off(events: "dp.hide", selector: String? = null, handler: ((eventobject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any)? = null): JQuery
    public fun off(events: "dp.hide", handler: (eventobject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any): JQuery
    public fun on(events: "dp.hide", selector: String, data: Any, handler: ((eventobject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any)? = null): JQuery
    public fun on(events: "dp.hide", selector: String, handler: (eventobject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any): JQuery
    public fun on(events: 'dp.hide', handler: (eventObject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any): JQuery
    public fun off(events: "dp.error", selector: String? = null, handler: ((eventobject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any)? = null): JQuery
    public fun off(events: "dp.error", handler: (eventobject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any): JQuery
    public fun on(events: "dp.error", selector: String, data: Any, handler: ((eventobject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any)? = null): JQuery
    public fun on(events: "dp.error", selector: String, handler: (eventobject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any): JQuery
    public fun on(events: 'dp.error', handler: (eventObject: BootstrapV3DatetimePicker.DatetimepickerEventObject) -> Any): JQuery
    public fun data(key: 'DateTimePicker'): BootstrapV3DatetimePicker.Datetimepicker
}
