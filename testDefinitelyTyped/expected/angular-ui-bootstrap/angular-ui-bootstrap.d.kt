// OUT:
// WRONG
package angular-ui-bootstrap

module
public object ng.ui.bootstrap  {
    public trait IAccordionConfig {
        public var closeOthers: Boolean?
    }
    public trait IButtonConfig {
        public var activeClass: String?
        public var toggleEvent: String?
    }
    public trait IDatepickerConfig {
        public var dayFormat: String?
        public var monthFormat: String?
        public var yearFormat: String?
        public var dayHeaderFormat: String?
        public var dayTitleFormat: String?
        public var monthTitleFormat: String?
        public var showWeeks: Boolean?
        public var startingDay: Number?
        public var yearRange: Number?
        public var minDate: Any?
        public var maxDate: Any?
    }
    public trait IDatepickerPopupConfig {
        public var dateFormat: String?
        public var currentText: String?
        public var toggleWeeksText: String?
        public var clearText: String?
        public var closeText: String?
        public var closeOnDateSelection: Boolean?
        public var appendToBody: Boolean?
        public var showButtonBar: Boolean?
    }
    public trait IModalService {
        public fun open(options: IModalSettings): IModalServiceInstance
    }
    public trait IModalServiceInstance {
        public fun close(result: Any? = null): Unit
        public fun dismiss(reason: Any? = null): Unit
        public var result: ng.IPromise<Any>
        public var opened: ng.IPromise<Any>
    }
    public trait IModalSettings {
        public var templateUrl: String?
        public var template: String?
        public var scope: Any?
        public var controller: Any?
        public var resolve: Any?
        public var backdrop: Any?
        public var keyboard: Boolean?
        public var windowClass: String?
    }
    public trait IModalStackService {
        public fun open(modalInstance: IModalServiceInstance, modal: Any): Unit
        public fun close(modalInstance: IModalServiceInstance, result: Any? = null): Unit
        public fun dismiss(modalInstance: IModalServiceInstance, reason: Any? = null): Unit
        public fun dismissAll(reason: Any? = null): Unit
        public fun getTop(): IModalStackedMapKeyValuePair
    }
    public trait IModalStackedMapKeyValuePair {
        public var key: IModalServiceInstance
        public var value: Any
    }
    public trait IPaginationConfig {
        public var page: Number?
        public var totalItems: Number?
        public var itemsPerPage: Number?
        public var maxSize: Number?
        public var numPages: Number?
        public var rotate: Boolean?
        public val onSelectPage: ((page: Number) -> Unit)?
        public var directionLinks: Boolean?
        public var previousText: String?
        public var nextText: String?
        public var boundaryLinks: Boolean?
        public var firstText: String?
        public var lastText: String?
    }
    public trait IPagerConfig {
        public var align: Boolean?
        public var page: Number?
        public var totalItems: Number?
        public var itemsPerPage: Number?
        public var numPages: Number?
        public val onSelectPage: ((page: Number) -> Unit)?
        public var previousText: String?
        public var nextText: String?
    }
    public trait IPositionCoordinates {
        public var width: Number?
        public var height: Number?
        public var top: Number?
        public var left: Number?
    }
    public trait IPositionService {
        public fun position(element: JQuery): IPositionCoordinates
        public fun offset(element: JQuery): IPositionCoordinates
    }
    public trait IProgressConfig {
        public var animate: Boolean?
        public var max: Number?
    }
    public trait IRatingConfig {
        public var max: Number?
        public var stateOn: String?
        public var stateOff: String?
    }
    public trait ITimepickerConfig {
        public var hourStep: Number?
        public var minuteStep: Number?
        public var showMeridian: Boolean?
        public var meridians: Array<String>?
        public var readonlyInput: Boolean?
        public var mousewheel: Boolean?
    }
    public trait ITooltipOptions {
        public var placement: String?
        public var animation: Boolean?
        public var popupDelay: Number?
        public var appendtoBody: Boolean?
    }
    public trait ITooltipProvider {
        public fun options(value: ITooltipOptions): Unit
        public fun setTriggers(triggers: Object): Unit
    }
    public trait ITransitionService {
        public var animationEndEventName: String
        public var transitionEndEventName: String
        public fun invoke(element: ng.IAugmentedJQuery, trigger: Any, options: ITransitionServiceOptions? = null): ng.IPromise<ng.IAugmentedJQuery>
    }
    public trait ITransitionServiceOptions {
        public var animation: Boolean?
    }
}
