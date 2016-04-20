package jquery

@native
interface JQueryAjaxSettings {
    var accepts: Any? = noImpl
    var async: Boolean? = noImpl
    val beforeSend: ((jqXHR: JQueryXHR, settings: JQueryAjaxSettings) -> Any)? = noImpl
    var cache: Boolean? = noImpl
    val complete: ((jqXHR: JQueryXHR, textStatus: String) -> Any)? = noImpl
    var contents: Json? = noImpl
    var contentType: Any? = noImpl
    var context: Any? = noImpl
    var converters: Json? = noImpl
    var crossDomain: Boolean? = noImpl
    var data: Any? = noImpl
    val dataFilter: ((data: Any, ty: Any) -> Any)? = noImpl
    var dataType: String? = noImpl
    val error: ((jqXHR: JQueryXHR, textStatus: String, errorThrown: String) -> Any)? = noImpl
    var global: Boolean? = noImpl
    var headers: Json? = noImpl
    var ifModified: Boolean? = noImpl
    var isLocal: Boolean? = noImpl
    var jsonp: Any? = noImpl
    var jsonpCallback: Any? = noImpl
    var mimeType: String? = noImpl
    var password: String? = noImpl
    var processData: Boolean? = noImpl
    var scriptCharset: String? = noImpl
    var statusCode: Json? = noImpl
    val success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = noImpl
    var timeout: Number? = noImpl
    var traditional: Boolean? = noImpl
    var type: String? = noImpl
    var url: String? = noImpl
    var username: String? = noImpl
    var xhr: Any? = noImpl
    var xhrFields: Json? = noImpl
}
@native
interface JQueryXHR : XMLHttpRequest, JQueryPromise<Any> {
    // TODO: investigate
    fun overrideMimeType(mimeType: String): Any
    fun abort(statusText: String? = null)
    fun then(doneCallback: (data: Any, textStatus: String, jqXHR: JQueryXHR) -> Unit, failCallback: ((jqXHR: JQueryXHR, textStatus: String, errorThrown: Any) -> Unit)? = null): JQueryPromise<Any>
    var responseJSON: Any? = noImpl
}
@native
interface JQueryCallback {
    fun add(callbacks: Function): JQueryCallback
    fun add(callbacks: Array<Function>): JQueryCallback
    fun disable(): JQueryCallback
    fun disabled(): Boolean
    fun empty(): JQueryCallback
    fun fire(vararg arguments: Any): JQueryCallback
    fun fired(): Boolean
    fun fireWith(context: Any? = null, vararg args: Any): JQueryCallback
    fun has(callback: Function): Boolean
    fun lock(): JQueryCallback
    fun locked(): Boolean
    fun remove(callbacks: Function): JQueryCallback
    fun remove(callbacks: Array<Function>): JQueryCallback
}
@native
interface JQueryGenericPromise<T> {
    fun then<U>(doneFilter: (value: T) -> dynamic /* U | JQueryGenericPromise<U> */, failFilter: ((reason: Any) -> dynamic /* U | JQueryGenericPromise<U> */)? = null): JQueryGenericPromise<U>
}
@native
interface JQueryPromiseCallback<T> {
    @nativeInvoke
    fun invoke(value: T? = null, vararg args: Any)
}
@native
interface JQueryPromiseOperator<T, R> {
    @nativeInvoke
    fun invoke(callback: JQueryPromiseCallback<T>, vararg callbacks: JQueryPromiseCallback<T>): JQueryPromise<R>
    @nativeInvoke
    fun invoke(callback: Array<JQueryPromiseCallback<T>>, vararg callbacks: JQueryPromiseCallback<T>): JQueryPromise<R>
}
@native
interface JQueryPromise<T> {
    var always: JQueryPromiseOperator<Any,T>
    var done: JQueryPromiseOperator<T,T>
    var fail: JQueryPromiseOperator<Any,T>
    fun progress(progressCallback: JQueryPromiseCallback<T>): JQueryPromise<T>
    fun progress(progressCallbacks: Array<JQueryPromiseCallback<T>>): JQueryPromise<T>
    fun state(): String
    fun pipe(doneFilter: ((x: Any) -> Any)? = null, failFilter: ((x: Any) -> Any)? = null, progressFilter: ((x: Any) -> Any)? = null): JQueryPromise<Any>
    fun then<U>(doneFilter: (value: T) -> dynamic /* U | JQueryGenericPromise<U> */, failFilter: ((vararg reasons: Any) -> dynamic /* U | JQueryGenericPromise<U> */)? = null, progressFilter: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
    fun then<U>(doneFilter: (vararg values: Any) -> dynamic /* U | JQueryGenericPromise<U> */, failFilter: ((vararg reasons: Any) -> dynamic /* U | JQueryGenericPromise<U> */)? = null, progressFilter: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
}
@native
interface JQueryDeferred<T> : JQueryPromise<T> {
    fun always(alwaysCallbacks1: JQueryPromiseCallback<T>? = null, vararg alwaysCallbacks2: JQueryPromiseCallback<T>): JQueryDeferred<T>
    fun always(alwaysCallbacks1: Array<JQueryPromiseCallback<T>>? = null, vararg alwaysCallbacks2: JQueryPromiseCallback<T>): JQueryDeferred<T>
    fun always(alwaysCallbacks1: JQueryPromiseCallback<T>? = null, vararg alwaysCallbacks2: Any): JQueryDeferred<T>
    fun always(alwaysCallbacks1: Array<JQueryPromiseCallback<T>>? = null, vararg alwaysCallbacks2: Any): JQueryDeferred<T>
    fun done(doneCallbacks1: JQueryPromiseCallback<T>? = null, vararg doneCallbacks2: JQueryPromiseCallback<T>): JQueryDeferred<T>
    fun done(doneCallbacks1: Array<JQueryPromiseCallback<T>>? = null, vararg doneCallbacks2: JQueryPromiseCallback<T>): JQueryDeferred<T>
    fun done(doneCallbacks1: JQueryPromiseCallback<T>? = null, vararg doneCallbacks2: Any): JQueryDeferred<T>
    fun done(doneCallbacks1: Array<JQueryPromiseCallback<T>>? = null, vararg doneCallbacks2: Any): JQueryDeferred<T>
    fun fail(failCallbacks1: JQueryPromiseCallback<T>? = null, vararg failCallbacks2: JQueryPromiseCallback<T>): JQueryDeferred<T>
    fun fail(failCallbacks1: Array<JQueryPromiseCallback<T>>? = null, vararg failCallbacks2: JQueryPromiseCallback<T>): JQueryDeferred<T>
    fun fail(failCallbacks1: JQueryPromiseCallback<T>? = null, vararg failCallbacks2: Any): JQueryDeferred<T>
    fun fail(failCallbacks1: Array<JQueryPromiseCallback<T>>? = null, vararg failCallbacks2: Any): JQueryDeferred<T>
    fun progress(progressCallback: JQueryPromiseCallback<T>): JQueryDeferred<T>
    fun progress(progressCallbacks: Array<JQueryPromiseCallback<T>>): JQueryDeferred<T>
    fun notify(vararg args: Any): JQueryDeferred<T>
    fun notifyWith(context: Any, vararg args: Any): JQueryDeferred<T>
    fun reject(vararg args: Any): JQueryDeferred<T>
    fun rejectWith(context: Any, vararg args: Any): JQueryDeferred<T>
    fun resolve(value: T? = null, vararg args: Any): JQueryDeferred<T>
    fun resolveWith(context: Any, vararg args: Any): JQueryDeferred<T>
    fun promise(target: Any? = null): JQueryPromise<T>
}
@native
interface BaseJQueryEventObject : Event {
    var data: Any
    var delegateTarget: Element
    fun isDefaultPrevented(): Boolean
    fun isImmediatePropagationStopped(): Boolean
    fun isPropagationStopped(): Boolean
    var namespace: String
    var originalEvent: Event
    fun preventDefault(): Any
    var relatedTarget: Element
    var result: Any
    override fun stopImmediatePropagation()
    override fun stopPropagation()
    override var target: Element
    var pageX: Number
    var pageY: Number
    var which: Number
    var metaKey: Boolean
}
@native
interface JQueryInputEventObject : BaseJQueryEventObject {
    var altKey: Boolean
    var ctrlKey: Boolean
    override var metaKey: Boolean
    var shiftKey: Boolean
}
@native
interface JQueryMouseEventObject : JQueryInputEventObject {
    var button: Number
    var clientX: Number
    var clientY: Number
    var offsetX: Number
    var offsetY: Number
    override var pageX: Number
    override var pageY: Number
    var screenX: Number
    var screenY: Number
}
@native
interface JQueryKeyEventObject : JQueryInputEventObject {
    var char: Any
    var charCode: Number
    var key: Any
    var keyCode: Number
}
@native
interface JQueryEventObject : BaseJQueryEventObject, JQueryInputEventObject, JQueryMouseEventObject, JQueryKeyEventObject
@native
interface JQuerySupport {
    var ajax: Boolean? = noImpl
    var boxModel: Boolean? = noImpl
    var changeBubbles: Boolean? = noImpl
    var checkClone: Boolean? = noImpl
    var checkOn: Boolean? = noImpl
    var cors: Boolean? = noImpl
    var cssFloat: Boolean? = noImpl
    var hrefNormalized: Boolean? = noImpl
    var htmlSerialize: Boolean? = noImpl
    var leadingWhitespace: Boolean? = noImpl
    var noCloneChecked: Boolean? = noImpl
    var noCloneEvent: Boolean? = noImpl
    var opacity: Boolean? = noImpl
    var optDisabled: Boolean? = noImpl
    var optSelected: Boolean? = noImpl
    val scriptEval: (() -> Boolean)? = noImpl
    var style: Boolean? = noImpl
    var submitBubbles: Boolean? = noImpl
    var tbody: Boolean? = noImpl
}
@native
interface JQueryParam {
    @nativeInvoke
    fun invoke(obj: Any): String
    @nativeInvoke
    fun invoke(obj: Any, traditional: Boolean): String
}
@native
interface JQueryEventConstructor {
    @nativeInvoke
    fun invoke(name: String, eventProperties: Any? = null): JQueryEventObject
    @nativeNew
    fun invoke(name: String, eventProperties: Any? = null): JQueryEventObject
}
@native
interface JQueryCoordinates {
    var left: Number
    var top: Number
}
@native
interface JQuerySerializeArrayElement {
    var name: String
    var value: String
}
@native
interface JQueryAnimationOptions {
    var duration: Any? = noImpl
    var easing: String? = noImpl
    var complete: Function? = noImpl
    var step: ((now: Number, tween: Any) -> Any)? = noImpl
    var progress: ((animation: JQueryPromise<Any>, progress: Number, remainingMs: Number) -> Any)? = noImpl
    var start: ((animation: JQueryPromise<Any>) -> Any)? = noImpl
    var done: ((animation: JQueryPromise<Any>, jumpedToEnd: Boolean) -> Any)? = noImpl
    var fail: ((animation: JQueryPromise<Any>, jumpedToEnd: Boolean) -> Any)? = noImpl
    var always: ((animation: JQueryPromise<Any>, jumpedToEnd: Boolean) -> Any)? = noImpl
    var queue: Any? = noImpl
    var specialEasing: Object? = noImpl
}
@native
interface `T$0` {
    var slow: Number
    var fast: Number
}
@native
interface `T$1` {
    var tick: () -> Unit
    var interval: Number
    var stop: () -> Unit
    var speeds: `T$0`
    var off: Boolean
    var step: Any
}
@native
interface JQueryStatic {
    fun ajax(settings: JQueryAjaxSettings): JQueryXHR
    fun ajax(url: String, settings: JQueryAjaxSettings? = null): JQueryXHR
    fun ajaxPrefilter(dataTypes: String, handler: (opts: Any, originalOpts: JQueryAjaxSettings, jqXHR: JQueryXHR) -> Any)
    fun ajaxPrefilter(handler: (opts: Any, originalOpts: JQueryAjaxSettings, jqXHR: JQueryXHR) -> Any)
    var ajaxSettings: JQueryAjaxSettings
    fun ajaxSetup(options: JQueryAjaxSettings)
    fun get(url: String, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    fun get(url: String, data: dynamic /* Object | String */? = null, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    fun getJSON(url: String, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null): JQueryXHR
    fun getJSON(url: String, data: dynamic /* Object | String */? = null, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null): JQueryXHR
    fun getScript(url: String, success: ((script: String, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null): JQueryXHR
    var param: JQueryParam
    fun post(url: String, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    fun post(url: String, data: dynamic /* Object | String */? = null, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    fun Callbacks(flags: String? = null): JQueryCallback
    fun holdReady(hold: Boolean)
    @nativeInvoke
    fun invoke(selector: String, context: dynamic /* Element | JQuery */? = null): JQuery
    @nativeInvoke
    fun invoke(element: Element): JQuery
    @nativeInvoke
    fun invoke(elementArray: Array<Element>): JQuery
    @nativeInvoke
    fun invoke(`object`: Any): JQuery
    @nativeInvoke
    fun invoke(`object`: JQuery): JQuery
    @nativeInvoke
    fun invoke(): JQuery
    @nativeInvoke
    fun invoke(html: String, ownerDocument: Document? = null): JQuery
    @nativeInvoke
    fun invoke(html: String, attributes: Object): JQuery
    @nativeInvoke
    fun invoke(callback: Function): JQuery
    fun noConflict(removeAll: Boolean? = null): Object
    fun `when`<T>(vararg deferreds: JQueryGenericPromise<T>): JQueryPromise<T>
    fun `when`<T>(vararg deferreds: T): JQueryPromise<T>
    fun `when`<T>(vararg deferreds: Any): JQueryPromise<T>
    var cssHooks: Json
    var cssNumber: Any
    fun data<T>(element: Element, key: String, value: T): T
    fun data(element: Element, key: String): Any
    fun data(element: Element): Any
    fun dequeue(element: Element, queueName: String? = null)
    fun hasData(element: Element): Boolean
    fun queue(element: Element, queueName: String? = null): Array<Any>
    fun queue(element: Element, queueName: String, newQueue: Array<Function>): JQuery
    fun queue(element: Element, queueName: String, callback: Function): JQuery
    fun removeData(element: Element, name: String? = null): JQuery
    fun Deferred<T>(beforeStart: ((deferred: JQueryDeferred<T>) -> Any)? = null): JQueryDeferred<T>
    var fx: `T$1`
    fun proxy(fnction: (vararg args: Any) -> Any, context: Object, vararg additionalArguments: Any): Any
    fun proxy(context: Object, name: String, vararg additionalArguments: Any): Any
    var Event: JQueryEventConstructor
    fun error(message: Any): JQuery
    var expr: Any
    var fn: Any
    var isReady: Boolean
    var support: JQuerySupport
    fun contains(container: Element, contained: Element): Boolean
    fun each<T>(collection: Array<T>, callback: (indexInArray: Number, valueOfElement: T) -> Any): Any
    fun each(collection: Any, callback: (indexInArray: Any, valueOfElement: Any) -> Any): Any
    fun extend(target: Any, object1: Any? = null, vararg objectN: Any): Any
    fun extend(deep: Boolean, target: Any, object1: Any? = null, vararg objectN: Any): Any
    fun globalEval(code: String): Any
    fun grep<T>(array: Array<T>, func: (elementOfArray: T, indexInArray: Number) -> Boolean, invert: Boolean? = null): Array<T>
    fun inArray<T>(value: T, array: Array<T>, fromIndex: Number? = null): Number
    fun isArray(obj: Any): Boolean
    fun isEmptyObject(obj: Any): Boolean
    fun isFunction(obj: Any): Boolean
    fun isNumeric(value: Any): Boolean
    fun isPlainObject(obj: Any): Boolean
    fun isWindow(obj: Any): Boolean
    fun isXMLDoc(node: Node): Boolean
    fun makeArray(obj: Any): Array<Any>
    fun map<T, U>(array: Array<T>, callback: (elementOfArray: T, indexInArray: Number) -> U): Array<U>
    fun map(arrayOrObject: Any, callback: (value: Any, indexOrKey: Any) -> Any): Any
    fun merge<T>(first: Array<T>, second: Array<T>): Array<T>
    fun noop(): Any
    fun now(): Number
    fun parseJSON(json: String): Any
    fun parseXML(data: String): XMLDocument
    fun trim(str: String): String
    fun type(obj: Any): String
    fun unique(array: Array<Element>): Array<Element>
    fun parseHTML(data: String, context: HTMLElement? = null, keepScripts: Boolean? = null): Array<Any>
    fun parseHTML(data: String, context: Document? = null, keepScripts: Boolean? = null): Array<Any>
}
@native
interface JQuery {
    fun ajaxComplete(handler: (event: JQueryEventObject, XMLHttpRequest: XMLHttpRequest, ajaxOptions: Any) -> Any): JQuery
    fun ajaxError(handler: (event: JQueryEventObject, jqXHR: JQueryXHR, ajaxSettings: JQueryAjaxSettings, thrownError: Any) -> Any): JQuery
    fun ajaxSend(handler: (event: JQueryEventObject, jqXHR: JQueryXHR, ajaxOptions: JQueryAjaxSettings) -> Any): JQuery
    fun ajaxStart(handler: () -> Any): JQuery
    fun ajaxStop(handler: () -> Any): JQuery
    fun ajaxSuccess(handler: (event: JQueryEventObject, XMLHttpRequest: XMLHttpRequest, ajaxOptions: JQueryAjaxSettings) -> Any): JQuery
    fun load(url: String, data: dynamic /* String | Object */? = null, complete: ((responseText: String, textStatus: String, XMLHttpRequest: XMLHttpRequest) -> Any)? = null): JQuery
    fun serialize(): String
    fun serializeArray(): Array<JQuerySerializeArrayElement>
    fun addClass(className: String): JQuery
    fun addClass(func: (index: Number, className: String) -> String): JQuery
    fun addBack(selector: String? = null): JQuery
    fun attr(attributeName: String): String
    fun attr(attributeName: String, value: dynamic /* String | Number */): JQuery
    fun attr(attributeName: String, func: (index: Number, attr: String) -> dynamic /* String | Number */): JQuery
    fun attr(attributes: Object): JQuery
    fun hasClass(className: String): Boolean
    fun html(): String
    fun html(htmlString: String): JQuery
    fun html(func: (index: Number, oldhtml: String) -> String): JQuery
    fun prop(propertyName: String): Any
    fun prop(propertyName: String, value: dynamic /* String | Number | Boolean */): JQuery
    fun prop(properties: Object): JQuery
    fun prop(propertyName: String, func: (index: Number, oldPropertyValue: Any) -> Any): JQuery
    fun removeAttr(attributeName: String): JQuery
    fun removeClass(className: String? = null): JQuery
    fun removeClass(func: (index: Number, className: String) -> String): JQuery
    fun removeProp(propertyName: String): JQuery
    fun toggleClass(className: String, swtch: Boolean? = null): JQuery
    fun toggleClass(swtch: Boolean? = null): JQuery
    fun toggleClass(func: (index: Number, className: String, swtch: Boolean) -> String, swtch: Boolean? = null): JQuery
    fun `val`(): Any
    fun `val`(value: dynamic /* String | Array<String> */): JQuery
    fun `val`(func: (index: Number, value: String) -> String): JQuery
    fun css(propertyName: String): String
    fun css(propertyName: String, value: dynamic /* String | Number */): JQuery
    fun css(propertyName: String, value: (index: Number, value: String) -> dynamic /* String | Number */): JQuery
    fun css(properties: Object): JQuery
    fun height(): Number
    fun height(value: dynamic /* Number | String */): JQuery
    fun height(func: (index: Number, height: Number) -> dynamic /* Number | String */): JQuery
    fun innerHeight(): Number
    fun innerHeight(height: dynamic /* Number | String */): JQuery
    fun innerWidth(): Number
    fun innerWidth(width: dynamic /* Number | String */): JQuery
    fun offset(): JQueryCoordinates
    fun offset(coordinates: JQueryCoordinates): JQuery
    fun offset(func: (index: Number, coords: JQueryCoordinates) -> JQueryCoordinates): JQuery
    fun outerHeight(includeMargin: Boolean? = null): Number
    fun outerHeight(height: dynamic /* Number | String */): JQuery
    fun outerWidth(includeMargin: Boolean? = null): Number
    fun outerWidth(width: dynamic /* Number | String */): JQuery
    fun position(): JQueryCoordinates
    fun scrollLeft(): Number
    fun scrollLeft(value: Number): JQuery
    fun scrollTop(): Number
    fun scrollTop(value: Number): JQuery
    fun width(): Number
    fun width(value: dynamic /* Number | String */): JQuery
    fun width(func: (index: Number, width: Number) -> dynamic /* Number | String */): JQuery
    fun clearQueue(queueName: String? = null): JQuery
    fun data(key: String, value: Any): JQuery
    fun data(obj: Json): JQuery
    fun data(key: String): Any
    fun data(): Any
    fun dequeue(queueName: String? = null): JQuery
    fun removeData(name: String): JQuery
    fun removeData(list: Array<String>): JQuery
    fun promise(type: String? = null, target: Object? = null): JQueryPromise<Any>
    fun animate(properties: Object, duration: dynamic /* String | Number */? = null, complete: Function? = null): JQuery
    fun animate(properties: Object, duration: dynamic /* String | Number */? = null, easing: String? = null, complete: Function? = null): JQuery
    fun animate(properties: Object, options: JQueryAnimationOptions): JQuery
    fun delay(duration: Number, queueName: String? = null): JQuery
    fun fadeIn(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    fun fadeIn(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    fun fadeIn(options: JQueryAnimationOptions): JQuery
    fun fadeOut(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    fun fadeOut(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    fun fadeOut(options: JQueryAnimationOptions): JQuery
    fun fadeTo(duration: dynamic /* String | Number */, opacity: Number, complete: Function? = null): JQuery
    fun fadeTo(duration: dynamic /* String | Number */, opacity: Number, easing: String? = null, complete: Function? = null): JQuery
    fun fadeToggle(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    fun fadeToggle(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    fun fadeToggle(options: JQueryAnimationOptions): JQuery
    fun finish(queue: String? = null): JQuery
    fun hide(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    fun hide(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    fun hide(options: JQueryAnimationOptions): JQuery
    fun show(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    fun show(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    fun show(options: JQueryAnimationOptions): JQuery
    fun slideDown(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    fun slideDown(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    fun slideDown(options: JQueryAnimationOptions): JQuery
    fun slideToggle(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    fun slideToggle(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    fun slideToggle(options: JQueryAnimationOptions): JQuery
    fun slideUp(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    fun slideUp(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    fun slideUp(options: JQueryAnimationOptions): JQuery
    fun stop(clearQueue: Boolean? = null, jumpToEnd: Boolean? = null): JQuery
    fun stop(queue: String? = null, clearQueue: Boolean? = null, jumpToEnd: Boolean? = null): JQuery
    fun toggle(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    fun toggle(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    fun toggle(options: JQueryAnimationOptions): JQuery
    fun toggle(showOrHide: Boolean): JQuery
    fun bind(eventType: String, eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun bind(eventType: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun bind(eventType: String, eventData: Any, preventBubble: Boolean): JQuery
    fun bind(eventType: String, preventBubble: Boolean): JQuery
    fun bind(events: Any): JQuery
    fun blur(): JQuery
    fun blur(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun blur(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun change(): JQuery
    fun change(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun change(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun click(): JQuery
    fun click(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun click(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun dblclick(): JQuery
    fun dblclick(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun dblclick(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun delegate(selector: Any, eventType: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun delegate(selector: Any, eventType: String, eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focus(): JQuery
    fun focus(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focus(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun focusin(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusin(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusout(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun focusout(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun hover(handlerIn: (eventObject: JQueryEventObject) -> Any, handlerOut: (eventObject: JQueryEventObject) -> Any): JQuery
    fun hover(handlerInOut: (eventObject: JQueryEventObject) -> Any): JQuery
    fun keydown(): JQuery
    fun keydown(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    fun keydown(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    fun keypress(): JQuery
    fun keypress(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    fun keypress(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    fun keyup(): JQuery
    fun keyup(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    fun keyup(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    fun load(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun load(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun mousedown(): JQuery
    fun mousedown(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mousedown(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseenter(): JQuery
    fun mouseenter(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseenter(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseleave(): JQuery
    fun mouseleave(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseleave(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mousemove(): JQuery
    fun mousemove(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mousemove(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseout(): JQuery
    fun mouseout(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseout(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseover(): JQuery
    fun mouseover(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseover(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseup(): JQuery
    fun mouseup(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun mouseup(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    fun off(): JQuery
    fun off(events: String, selector: String? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun off(events: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun off(events: Json, selector: String? = null): JQuery
    fun on(events: String, handler: (eventObject: JQueryEventObject, vararg args: Any) -> Any): JQuery
    fun on(events: String, data: Any, handler: (eventObject: JQueryEventObject, vararg args: Any) -> Any): JQuery
    fun on(events: String, selector: String, handler: (eventObject: JQueryEventObject, vararg eventData: Any) -> Any): JQuery
    fun on(events: String, selector: String, data: Any, handler: (eventObject: JQueryEventObject, vararg eventData: Any) -> Any): JQuery
    fun on(events: Json, selector: String? = null, data: Any? = null): JQuery
    fun on(events: Json, data: Any? = null): JQuery
    fun one(events: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun one(events: String, data: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun one(events: String, selector: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun one(events: String, selector: String, data: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun one(events: Json, selector: String? = null, data: Any? = null): JQuery
    fun one(events: Json, data: Any? = null): JQuery
    fun ready(handler: Function): JQuery
    fun resize(): JQuery
    fun resize(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun resize(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun scroll(): JQuery
    fun scroll(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun scroll(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun select(): JQuery
    fun select(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun select(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun submit(): JQuery
    fun submit(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun submit(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun trigger(eventType: String, extraParameters: dynamic /* Array<Any> | Object */? = null): JQuery
    fun trigger(event: JQueryEventObject, extraParameters: dynamic /* Array<Any> | Object */? = null): JQuery
    fun triggerHandler(eventType: String, vararg extraParameters: Any): Object
    fun unbind(eventType: String? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun unbind(eventType: String, fls: Boolean): JQuery
    fun unbind(evt: Any): JQuery
    fun undelegate(): JQuery
    fun undelegate(selector: String, eventType: String, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    fun undelegate(selector: String, events: Object): JQuery
    fun undelegate(namespace: String): JQuery
    fun unload(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun unload(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    var context: Element
    var jquery: String
    fun error(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun error(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    fun pushStack(elements: Array<Any>): JQuery
    fun pushStack(elements: Array<Any>, name: String, arguments: Array<Any>): JQuery
    fun after(content1: dynamic /* JQuery | Array<Any> | Element | Text | String */, vararg content2: Any): JQuery
    fun after(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    fun append(content1: dynamic /* JQuery | Array<Any> | Element | Text | String */, vararg content2: Any): JQuery
    fun append(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    fun appendTo(target: dynamic /* JQuery | Array<Any> | Element | String */): JQuery
    fun before(content1: dynamic /* JQuery | Array<Any> | Element | Text | String */, vararg content2: Any): JQuery
    fun before(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    fun clone(withDataAndEvents: Boolean? = null, deepWithDataAndEvents: Boolean? = null): JQuery
    fun detach(selector: String? = null): JQuery
    fun empty(): JQuery
    fun insertAfter(target: dynamic /* JQuery | Array<Any> | Element | Text | String */): JQuery
    fun insertBefore(target: dynamic /* JQuery | Array<Any> | Element | Text | String */): JQuery
    fun prepend(content1: dynamic /* JQuery | Array<Any> | Element | Text | String */, vararg content2: Any): JQuery
    fun prepend(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    fun prependTo(target: dynamic /* JQuery | Array<Any> | Element | String */): JQuery
    fun remove(selector: String? = null): JQuery
    fun replaceAll(target: dynamic /* JQuery | Array<Any> | Element | String */): JQuery
    fun replaceWith(newContent: dynamic /* JQuery | Array<Any> | Element | Text | String */): JQuery
    fun replaceWith(func: () -> dynamic /* Element | JQuery */): JQuery
    fun text(): String
    fun text(text: dynamic /* String | Number | Boolean */): JQuery
    fun text(func: (index: Number, text: String) -> String): JQuery
    fun toArray(): Array<Any>
    fun unwrap(): JQuery
    fun wrap(wrappingElement: dynamic /* JQuery | Element | String */): JQuery
    fun wrap(func: (index: Number) -> dynamic /* String | JQuery */): JQuery
    fun wrapAll(wrappingElement: dynamic /* JQuery | Element | String */): JQuery
    fun wrapAll(func: (index: Number) -> String): JQuery
    fun wrapInner(wrappingElement: dynamic /* JQuery | Element | String */): JQuery
    fun wrapInner(func: (index: Number) -> String): JQuery
    fun each(func: (index: Number, elem: Element) -> Any): JQuery
    fun get(index: Number): HTMLElement
    fun get(): Array<Any>
    fun index(): Number
    fun index(selector: dynamic /* String | JQuery | Element */): Number
    var length: Number
    var selector: String
    @nativeGetter
    fun get(index: String): Any
    @nativeSetter
    fun set(index: String, value: Any)
    @nativeGetter
    fun get(index: Number): HTMLElement
    @nativeSetter
    fun set(index: Number, value: HTMLElement)
    fun add(selector: String, context: Element? = null): JQuery
    fun add(vararg elements: Element): JQuery
    fun add(html: String): JQuery
    fun add(obj: JQuery): JQuery
    fun children(selector: String? = null): JQuery
    fun closest(selector: String): JQuery
    fun closest(selector: String, context: Element? = null): JQuery
    fun closest(obj: JQuery): JQuery
    fun closest(element: Element): JQuery
    fun closest(selectors: Any, context: Element? = null): Array<Any>
    fun contents(): JQuery
    fun end(): JQuery
    fun eq(index: Number): JQuery
    fun filter(selector: String): JQuery
    fun filter(func: (index: Number, element: Element) -> Any): JQuery
    fun filter(element: Element): JQuery
    fun filter(obj: JQuery): JQuery
    fun find(selector: String): JQuery
    fun find(element: Element): JQuery
    fun find(obj: JQuery): JQuery
    fun first(): JQuery
    fun has(selector: String): JQuery
    fun has(contained: Element): JQuery
    fun `is`(selector: String): Boolean
    fun `is`(func: (index: Number, element: Element) -> Boolean): Boolean
    fun `is`(obj: JQuery): Boolean
    fun `is`(elements: Any): Boolean
    fun last(): JQuery
    fun map(callback: (index: Number, domElement: Element) -> Any): JQuery
    fun next(selector: String? = null): JQuery
    fun nextAll(selector: String? = null): JQuery
    fun nextUntil(selector: String? = null, filter: String? = null): JQuery
    fun nextUntil(element: Element? = null, filter: String? = null): JQuery
    fun nextUntil(obj: JQuery? = null, filter: String? = null): JQuery
    fun not(selector: String): JQuery
    fun not(func: (index: Number, element: Element) -> Boolean): JQuery
    fun not(vararg elements: Element): JQuery
    fun not(obj: JQuery): JQuery
    fun offsetParent(): JQuery
    fun parent(selector: String? = null): JQuery
    fun parents(selector: String? = null): JQuery
    fun parentsUntil(selector: String? = null, filter: String? = null): JQuery
    fun parentsUntil(element: Element? = null, filter: String? = null): JQuery
    fun parentsUntil(obj: JQuery? = null, filter: String? = null): JQuery
    fun prev(selector: String? = null): JQuery
    fun prevAll(selector: String? = null): JQuery
    fun prevUntil(selector: String? = null, filter: String? = null): JQuery
    fun prevUntil(element: Element? = null, filter: String? = null): JQuery
    fun prevUntil(obj: JQuery? = null, filter: String? = null): JQuery
    fun siblings(selector: String? = null): JQuery
    fun slice(start: Number, end: Number? = null): JQuery
    fun queue(queueName: String? = null): Array<Any>
    fun queue(newQueue: Array<Function>): JQuery
    fun queue(callback: Function): JQuery
    fun queue(queueName: String, newQueue: Array<Function>): JQuery
    fun queue(queueName: String, callback: Function): JQuery
}
@module
object jquery {

}
@native
var jQuery: JQueryStatic = noImpl
@native
@module("jquery")
var `$`: JQueryStatic = noImpl
