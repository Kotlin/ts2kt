package jquery

native
public trait JQueryAjaxSettings {
    public var accepts: Any? = noImpl
    public var async: Boolean? = noImpl
    public val beforeSend: ((jqXHR: JQueryXHR, settings: JQueryAjaxSettings) -> Any)? = noImpl
    public var cache: Boolean? = noImpl
    public val complete: ((jqXHR: JQueryXHR, textStatus: String) -> Any)? = noImpl
    public var contents: Json? = noImpl
    public var contentType: Any? = noImpl
    public var context: Any? = noImpl
    public var converters: Json? = noImpl
    public var crossDomain: Boolean? = noImpl
    public var data: Any? = noImpl
    public val dataFilter: ((data: Any, ty: Any) -> Any)? = noImpl
    public var dataType: String? = noImpl
    public val error: ((jqXHR: JQueryXHR, textStatus: String, errorThrown: String) -> Any)? = noImpl
    public var global: Boolean? = noImpl
    public var headers: Json? = noImpl
    public var ifModified: Boolean? = noImpl
    public var isLocal: Boolean? = noImpl
    public var jsonp: Any? = noImpl
    public var jsonpCallback: Any? = noImpl
    public var mimeType: String? = noImpl
    public var password: String? = noImpl
    public var processData: Boolean? = noImpl
    public var scriptCharset: String? = noImpl
    public var statusCode: Json? = noImpl
    public val success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = noImpl
    public var timeout: Number? = noImpl
    public var traditional: Boolean? = noImpl
    public var type: String? = noImpl
    public var url: String? = noImpl
    public var username: String? = noImpl
    public var xhr: Any? = noImpl
    public var xhrFields: Json? = noImpl
}
native
public trait JQueryXHR : XMLHttpRequest, JQueryPromise<Any> {
    override fun overrideMimeType(mimeType: String): Any
    override fun abort(statusText: String?)
    override fun then(doneCallback: (data: Any, textStatus: String, jqXHR: JQueryXHR) -> Unit, failCallback: ((jqXHR: JQueryXHR, textStatus: String, errorThrown: Any) -> Unit)?): JQueryPromise<Any>
    public var responseJSON: Any? = noImpl
}
native
public trait JQueryCallback {
    public fun add(callbacks: Function): JQueryCallback
    public fun add(callbacks: Array<Function>): JQueryCallback
    public fun disable(): JQueryCallback
    public fun disabled(): Boolean
    public fun empty(): JQueryCallback
    public fun fire(vararg arguments: Any): JQueryCallback
    public fun fired(): Boolean
    public fun fireWith(context: Any? = null, vararg args: Any): JQueryCallback
    public fun has(callback: Function): Boolean
    public fun lock(): JQueryCallback
    public fun locked(): Boolean
    public fun remove(callbacks: Function): JQueryCallback
    public fun remove(callbacks: Array<Function>): JQueryCallback
}
native
public trait JQueryGenericPromise<T> {
    public fun then<U>(doneFilter: (value: T) -> dynamic /* U | JQueryGenericPromise<U> */, failFilter: ((reason: Any) -> dynamic /* U | JQueryGenericPromise<U> */)? = null): JQueryGenericPromise<U>
}
native
public trait JQueryPromiseCallback<T> {
    nativeInvoke
    public fun invoke(value: T? = null, vararg args: Any)
}
native
public trait JQueryPromiseOperator<T, R> {
    nativeInvoke
    public fun invoke(callback: JQueryPromiseCallback<T>, vararg callbacks: JQueryPromiseCallback<T>): JQueryPromise<R>
    nativeInvoke
    public fun invoke(callback: Array<JQueryPromiseCallback<T>>, vararg callbacks: JQueryPromiseCallback<T>): JQueryPromise<R>
}
native
public trait JQueryPromise<T> {
    public var always: JQueryPromiseOperator<Any,T>
    public var done: JQueryPromiseOperator<T,T>
    public var fail: JQueryPromiseOperator<Any,T>
    public fun progress(progressCallback: JQueryPromiseCallback<T>): JQueryPromise<T>
    public fun progress(progressCallbacks: Array<JQueryPromiseCallback<T>>): JQueryPromise<T>
    public fun state(): String
    public fun pipe(doneFilter: ((x: Any) -> Any)? = null, failFilter: ((x: Any) -> Any)? = null, progressFilter: ((x: Any) -> Any)? = null): JQueryPromise<Any>
    public fun then<U>(doneFilter: (value: T) -> dynamic /* U | JQueryGenericPromise<U> */, failFilter: ((vararg reasons: Any) -> dynamic /* U | JQueryGenericPromise<U> */)? = null, progressFilter: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
    public fun then<U>(doneFilter: (vararg values: Any) -> dynamic /* U | JQueryGenericPromise<U> */, failFilter: ((vararg reasons: Any) -> dynamic /* U | JQueryGenericPromise<U> */)? = null, progressFilter: ((vararg progression: Any) -> Any)? = null): JQueryPromise<U>
}
native
public trait JQueryDeferred<T> : JQueryPromise<T> {
    public fun always(alwaysCallbacks1: JQueryPromiseCallback<T>? = null, vararg alwaysCallbacks2: JQueryPromiseCallback<T>): JQueryDeferred<T>
    public fun always(alwaysCallbacks1: Array<JQueryPromiseCallback<T>>? = null, vararg alwaysCallbacks2: JQueryPromiseCallback<T>): JQueryDeferred<T>
    public fun always(alwaysCallbacks1: JQueryPromiseCallback<T>? = null, vararg alwaysCallbacks2: Any): JQueryDeferred<T>
    public fun always(alwaysCallbacks1: Array<JQueryPromiseCallback<T>>? = null, vararg alwaysCallbacks2: Any): JQueryDeferred<T>
    public fun done(doneCallbacks1: JQueryPromiseCallback<T>? = null, vararg doneCallbacks2: JQueryPromiseCallback<T>): JQueryDeferred<T>
    public fun done(doneCallbacks1: Array<JQueryPromiseCallback<T>>? = null, vararg doneCallbacks2: JQueryPromiseCallback<T>): JQueryDeferred<T>
    public fun done(doneCallbacks1: JQueryPromiseCallback<T>? = null, vararg doneCallbacks2: Any): JQueryDeferred<T>
    public fun done(doneCallbacks1: Array<JQueryPromiseCallback<T>>? = null, vararg doneCallbacks2: Any): JQueryDeferred<T>
    public fun fail(failCallbacks1: JQueryPromiseCallback<T>? = null, vararg failCallbacks2: JQueryPromiseCallback<T>): JQueryDeferred<T>
    public fun fail(failCallbacks1: Array<JQueryPromiseCallback<T>>? = null, vararg failCallbacks2: JQueryPromiseCallback<T>): JQueryDeferred<T>
    public fun fail(failCallbacks1: JQueryPromiseCallback<T>? = null, vararg failCallbacks2: Any): JQueryDeferred<T>
    public fun fail(failCallbacks1: Array<JQueryPromiseCallback<T>>? = null, vararg failCallbacks2: Any): JQueryDeferred<T>
    public fun progress(progressCallback: JQueryPromiseCallback<T>): JQueryDeferred<T>
    public fun progress(progressCallbacks: Array<JQueryPromiseCallback<T>>): JQueryDeferred<T>
    public fun notify(vararg args: Any): JQueryDeferred<T>
    public fun notifyWith(context: Any, vararg args: Any): JQueryDeferred<T>
    public fun reject(vararg args: Any): JQueryDeferred<T>
    public fun rejectWith(context: Any, vararg args: Any): JQueryDeferred<T>
    public fun resolve(value: T? = null, vararg args: Any): JQueryDeferred<T>
    public fun resolveWith(context: Any, vararg args: Any): JQueryDeferred<T>
    public fun promise(target: Any? = null): JQueryPromise<T>
}
native
public trait BaseJQueryEventObject : Event {
    public var data: Any
    public var delegateTarget: Element
    public fun isDefaultPrevented(): Boolean
    public fun isImmediatePropagationStopped(): Boolean
    public fun isPropagationStopped(): Boolean
    public var namespace: String
    public var originalEvent: Event
    override fun preventDefault(): Any
    public var relatedTarget: Element
    public var result: Any
    override fun stopImmediatePropagation()
    override fun stopPropagation()
    override var target: Element
    public var pageX: Number
    public var pageY: Number
    public var which: Number
    public var metaKey: Boolean
}
native
public trait JQueryInputEventObject : BaseJQueryEventObject {
    public var altKey: Boolean
    public var ctrlKey: Boolean
    override var metaKey: Boolean
    public var shiftKey: Boolean
}
native
public trait JQueryMouseEventObject : JQueryInputEventObject {
    public var button: Number
    public var clientX: Number
    public var clientY: Number
    public var offsetX: Number
    public var offsetY: Number
    override var pageX: Number
    override var pageY: Number
    public var screenX: Number
    public var screenY: Number
}
native
public trait JQueryKeyEventObject : JQueryInputEventObject {
    public var char: Any
    public var charCode: Number
    public var key: Any
    public var keyCode: Number
}
native
public trait JQueryEventObject : BaseJQueryEventObject, JQueryInputEventObject, JQueryMouseEventObject, JQueryKeyEventObject
native
public trait JQuerySupport {
    public var ajax: Boolean? = noImpl
    public var boxModel: Boolean? = noImpl
    public var changeBubbles: Boolean? = noImpl
    public var checkClone: Boolean? = noImpl
    public var checkOn: Boolean? = noImpl
    public var cors: Boolean? = noImpl
    public var cssFloat: Boolean? = noImpl
    public var hrefNormalized: Boolean? = noImpl
    public var htmlSerialize: Boolean? = noImpl
    public var leadingWhitespace: Boolean? = noImpl
    public var noCloneChecked: Boolean? = noImpl
    public var noCloneEvent: Boolean? = noImpl
    public var opacity: Boolean? = noImpl
    public var optDisabled: Boolean? = noImpl
    public var optSelected: Boolean? = noImpl
    public val scriptEval: (() -> Boolean)? = noImpl
    public var style: Boolean? = noImpl
    public var submitBubbles: Boolean? = noImpl
    public var tbody: Boolean? = noImpl
}
native
public trait JQueryParam {
    nativeInvoke
    public fun invoke(obj: Any): String
    nativeInvoke
    public fun invoke(obj: Any, traditional: Boolean): String
}
native
public trait JQueryEventConstructor {
    nativeInvoke
    public fun invoke(name: String, eventProperties: Any? = null): JQueryEventObject
    nativeNew
    public fun invoke(name: String, eventProperties: Any? = null): JQueryEventObject
}
native
public trait JQueryCoordinates {
    public var left: Number
    public var top: Number
}
native
public trait JQuerySerializeArrayElement {
    public var name: String
    public var value: String
}
native
public trait JQueryAnimationOptions {
    public var duration: Any? = noImpl
    public var easing: String? = noImpl
    public var complete: Function? = noImpl
    public var step: ((now: Number, tween: Any) -> Any)? = noImpl
    public var progress: ((animation: JQueryPromise<Any>, progress: Number, remainingMs: Number) -> Any)? = noImpl
    public var start: ((animation: JQueryPromise<Any>) -> Any)? = noImpl
    public var done: ((animation: JQueryPromise<Any>, jumpedToEnd: Boolean) -> Any)? = noImpl
    public var fail: ((animation: JQueryPromise<Any>, jumpedToEnd: Boolean) -> Any)? = noImpl
    public var always: ((animation: JQueryPromise<Any>, jumpedToEnd: Boolean) -> Any)? = noImpl
    public var queue: Any? = noImpl
    public var specialEasing: Object? = noImpl
}
native
public trait `T$0` {
    public var slow: Number
    public var fast: Number
}
native
public trait `T$1` {
    public var tick: () -> Unit
    public var interval: Number
    public var stop: () -> Unit
    public var speeds: `T$0`
    public var off: Boolean
    public var step: Any
}
native
public trait JQueryStatic {
    public fun ajax(settings: JQueryAjaxSettings): JQueryXHR
    public fun ajax(url: String, settings: JQueryAjaxSettings? = null): JQueryXHR
    public fun ajaxPrefilter(dataTypes: String, handler: (opts: Any, originalOpts: JQueryAjaxSettings, jqXHR: JQueryXHR) -> Any)
    public fun ajaxPrefilter(handler: (opts: Any, originalOpts: JQueryAjaxSettings, jqXHR: JQueryXHR) -> Any)
    public var ajaxSettings: JQueryAjaxSettings
    public fun ajaxSetup(options: JQueryAjaxSettings)
    public fun get(url: String, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    public fun get(url: String, data: dynamic /* Object | String */? = null, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    public fun getJSON(url: String, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null): JQueryXHR
    public fun getJSON(url: String, data: dynamic /* Object | String */? = null, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null): JQueryXHR
    public fun getScript(url: String, success: ((script: String, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null): JQueryXHR
    public var param: JQueryParam
    public fun post(url: String, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    public fun post(url: String, data: dynamic /* Object | String */? = null, success: ((data: Any, textStatus: String, jqXHR: JQueryXHR) -> Any)? = null, dataType: String? = null): JQueryXHR
    public fun Callbacks(flags: String? = null): JQueryCallback
    public fun holdReady(hold: Boolean)
    nativeInvoke
    public fun invoke(selector: String, context: dynamic /* Element | JQuery */? = null): JQuery
    nativeInvoke
    public fun invoke(element: Element): JQuery
    nativeInvoke
    public fun invoke(elementArray: Array<Element>): JQuery
    nativeInvoke
    public fun invoke(`object`: Any): JQuery
    nativeInvoke
    public fun invoke(`object`: JQuery): JQuery
    nativeInvoke
    public fun invoke(): JQuery
    nativeInvoke
    public fun invoke(html: String, ownerDocument: Document? = null): JQuery
    nativeInvoke
    public fun invoke(html: String, attributes: Object): JQuery
    nativeInvoke
    public fun invoke(callback: Function): JQuery
    public fun noConflict(removeAll: Boolean? = null): Object
    public fun `when`<T>(vararg deferreds: JQueryGenericPromise<T>): JQueryPromise<T>
    public fun `when`<T>(vararg deferreds: T): JQueryPromise<T>
    public fun `when`<T>(vararg deferreds: Any): JQueryPromise<T>
    public var cssHooks: Json
    public var cssNumber: Any
    public fun data<T>(element: Element, key: String, value: T): T
    public fun data(element: Element, key: String): Any
    public fun data(element: Element): Any
    public fun dequeue(element: Element, queueName: String? = null)
    public fun hasData(element: Element): Boolean
    public fun queue(element: Element, queueName: String? = null): Array<Any>
    public fun queue(element: Element, queueName: String, newQueue: Array<Function>): JQuery
    public fun queue(element: Element, queueName: String, callback: Function): JQuery
    public fun removeData(element: Element, name: String? = null): JQuery
    public fun Deferred<T>(beforeStart: ((deferred: JQueryDeferred<T>) -> Any)? = null): JQueryDeferred<T>
    public var fx: `T$1`
    public fun proxy(fnction: (vararg args: Any) -> Any, context: Object, vararg additionalArguments: Any): Any
    public fun proxy(context: Object, name: String, vararg additionalArguments: Any): Any
    public var Event: JQueryEventConstructor
    public fun error(message: Any): JQuery
    public var expr: Any
    public var fn: Any
    public var isReady: Boolean
    public var support: JQuerySupport
    public fun contains(container: Element, contained: Element): Boolean
    public fun each<T>(collection: Array<T>, callback: (indexInArray: Number, valueOfElement: T) -> Any): Any
    public fun each(collection: Any, callback: (indexInArray: Any, valueOfElement: Any) -> Any): Any
    public fun extend(target: Any, object1: Any? = null, vararg objectN: Any): Any
    public fun extend(deep: Boolean, target: Any, object1: Any? = null, vararg objectN: Any): Any
    public fun globalEval(code: String): Any
    public fun grep<T>(array: Array<T>, func: (elementOfArray: T, indexInArray: Number) -> Boolean, invert: Boolean? = null): Array<T>
    public fun inArray<T>(value: T, array: Array<T>, fromIndex: Number? = null): Number
    public fun isArray(obj: Any): Boolean
    public fun isEmptyObject(obj: Any): Boolean
    public fun isFunction(obj: Any): Boolean
    public fun isNumeric(value: Any): Boolean
    public fun isPlainObject(obj: Any): Boolean
    public fun isWindow(obj: Any): Boolean
    public fun isXMLDoc(node: Node): Boolean
    public fun makeArray(obj: Any): Array<Any>
    public fun map<T, U>(array: Array<T>, callback: (elementOfArray: T, indexInArray: Number) -> U): Array<U>
    public fun map(arrayOrObject: Any, callback: (value: Any, indexOrKey: Any) -> Any): Any
    public fun merge<T>(first: Array<T>, second: Array<T>): Array<T>
    public fun noop(): Any
    public fun now(): Number
    public fun parseJSON(json: String): Any
    public fun parseXML(data: String): XMLDocument
    public fun trim(str: String): String
    public fun type(obj: Any): String
    public fun unique(array: Array<Element>): Array<Element>
    public fun parseHTML(data: String, context: HTMLElement? = null, keepScripts: Boolean? = null): Array<Any>
    public fun parseHTML(data: String, context: Document? = null, keepScripts: Boolean? = null): Array<Any>
}
native
public trait JQuery {
    public fun ajaxComplete(handler: (event: JQueryEventObject, XMLHttpRequest: XMLHttpRequest, ajaxOptions: Any) -> Any): JQuery
    public fun ajaxError(handler: (event: JQueryEventObject, jqXHR: JQueryXHR, ajaxSettings: JQueryAjaxSettings, thrownError: Any) -> Any): JQuery
    public fun ajaxSend(handler: (event: JQueryEventObject, jqXHR: JQueryXHR, ajaxOptions: JQueryAjaxSettings) -> Any): JQuery
    public fun ajaxStart(handler: () -> Any): JQuery
    public fun ajaxStop(handler: () -> Any): JQuery
    public fun ajaxSuccess(handler: (event: JQueryEventObject, XMLHttpRequest: XMLHttpRequest, ajaxOptions: JQueryAjaxSettings) -> Any): JQuery
    public fun load(url: String, data: dynamic /* String | Object */? = null, complete: ((responseText: String, textStatus: String, XMLHttpRequest: XMLHttpRequest) -> Any)? = null): JQuery
    public fun serialize(): String
    public fun serializeArray(): Array<JQuerySerializeArrayElement>
    public fun addClass(className: String): JQuery
    public fun addClass(func: (index: Number, className: String) -> String): JQuery
    public fun addBack(selector: String? = null): JQuery
    public fun attr(attributeName: String): String
    public fun attr(attributeName: String, value: dynamic /* String | Number */): JQuery
    public fun attr(attributeName: String, func: (index: Number, attr: String) -> dynamic /* String | Number */): JQuery
    public fun attr(attributes: Object): JQuery
    public fun hasClass(className: String): Boolean
    public fun html(): String
    public fun html(htmlString: String): JQuery
    public fun html(func: (index: Number, oldhtml: String) -> String): JQuery
    public fun prop(propertyName: String): Any
    public fun prop(propertyName: String, value: dynamic /* String | Number | Boolean */): JQuery
    public fun prop(properties: Object): JQuery
    public fun prop(propertyName: String, func: (index: Number, oldPropertyValue: Any) -> Any): JQuery
    public fun removeAttr(attributeName: String): JQuery
    public fun removeClass(className: String? = null): JQuery
    public fun removeClass(func: (index: Number, className: String) -> String): JQuery
    public fun removeProp(propertyName: String): JQuery
    public fun toggleClass(className: String, swtch: Boolean? = null): JQuery
    public fun toggleClass(swtch: Boolean? = null): JQuery
    public fun toggleClass(func: (index: Number, className: String, swtch: Boolean) -> String, swtch: Boolean? = null): JQuery
    public fun `val`(): Any
    public fun `val`(value: dynamic /* String | Array<String> */): JQuery
    public fun `val`(func: (index: Number, value: String) -> String): JQuery
    public fun css(propertyName: String): String
    public fun css(propertyName: String, value: dynamic /* String | Number */): JQuery
    public fun css(propertyName: String, value: (index: Number, value: String) -> dynamic /* String | Number */): JQuery
    public fun css(properties: Object): JQuery
    public fun height(): Number
    public fun height(value: dynamic /* Number | String */): JQuery
    public fun height(func: (index: Number, height: Number) -> dynamic /* Number | String */): JQuery
    public fun innerHeight(): Number
    public fun innerHeight(height: dynamic /* Number | String */): JQuery
    public fun innerWidth(): Number
    public fun innerWidth(width: dynamic /* Number | String */): JQuery
    public fun offset(): JQueryCoordinates
    public fun offset(coordinates: JQueryCoordinates): JQuery
    public fun offset(func: (index: Number, coords: JQueryCoordinates) -> JQueryCoordinates): JQuery
    public fun outerHeight(includeMargin: Boolean? = null): Number
    public fun outerHeight(height: dynamic /* Number | String */): JQuery
    public fun outerWidth(includeMargin: Boolean? = null): Number
    public fun outerWidth(width: dynamic /* Number | String */): JQuery
    public fun position(): JQueryCoordinates
    public fun scrollLeft(): Number
    public fun scrollLeft(value: Number): JQuery
    public fun scrollTop(): Number
    public fun scrollTop(value: Number): JQuery
    public fun width(): Number
    public fun width(value: dynamic /* Number | String */): JQuery
    public fun width(func: (index: Number, width: Number) -> dynamic /* Number | String */): JQuery
    public fun clearQueue(queueName: String? = null): JQuery
    public fun data(key: String, value: Any): JQuery
    public fun data(obj: Json): JQuery
    public fun data(key: String): Any
    public fun data(): Any
    public fun dequeue(queueName: String? = null): JQuery
    public fun removeData(name: String): JQuery
    public fun removeData(list: Array<String>): JQuery
    public fun promise(type: String? = null, target: Object? = null): JQueryPromise<Any>
    public fun animate(properties: Object, duration: dynamic /* String | Number */? = null, complete: Function? = null): JQuery
    public fun animate(properties: Object, duration: dynamic /* String | Number */? = null, easing: String? = null, complete: Function? = null): JQuery
    public fun animate(properties: Object, options: JQueryAnimationOptions): JQuery
    public fun delay(duration: Number, queueName: String? = null): JQuery
    public fun fadeIn(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    public fun fadeIn(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    public fun fadeIn(options: JQueryAnimationOptions): JQuery
    public fun fadeOut(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    public fun fadeOut(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    public fun fadeOut(options: JQueryAnimationOptions): JQuery
    public fun fadeTo(duration: dynamic /* String | Number */, opacity: Number, complete: Function? = null): JQuery
    public fun fadeTo(duration: dynamic /* String | Number */, opacity: Number, easing: String? = null, complete: Function? = null): JQuery
    public fun fadeToggle(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    public fun fadeToggle(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    public fun fadeToggle(options: JQueryAnimationOptions): JQuery
    public fun finish(queue: String? = null): JQuery
    public fun hide(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    public fun hide(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    public fun hide(options: JQueryAnimationOptions): JQuery
    public fun show(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    public fun show(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    public fun show(options: JQueryAnimationOptions): JQuery
    public fun slideDown(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    public fun slideDown(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    public fun slideDown(options: JQueryAnimationOptions): JQuery
    public fun slideToggle(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    public fun slideToggle(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    public fun slideToggle(options: JQueryAnimationOptions): JQuery
    public fun slideUp(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    public fun slideUp(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    public fun slideUp(options: JQueryAnimationOptions): JQuery
    public fun stop(clearQueue: Boolean? = null, jumpToEnd: Boolean? = null): JQuery
    public fun stop(queue: String? = null, clearQueue: Boolean? = null, jumpToEnd: Boolean? = null): JQuery
    public fun toggle(duration: dynamic /* Number | String */? = null, complete: Function? = null): JQuery
    public fun toggle(duration: dynamic /* Number | String */? = null, easing: String? = null, complete: Function? = null): JQuery
    public fun toggle(options: JQueryAnimationOptions): JQuery
    public fun toggle(showOrHide: Boolean): JQuery
    public fun bind(eventType: String, eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun bind(eventType: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun bind(eventType: String, eventData: Any, preventBubble: Boolean): JQuery
    public fun bind(eventType: String, preventBubble: Boolean): JQuery
    public fun bind(events: Any): JQuery
    public fun blur(): JQuery
    public fun blur(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun blur(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun change(): JQuery
    public fun change(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun change(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun click(): JQuery
    public fun click(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun click(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun dblclick(): JQuery
    public fun dblclick(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun dblclick(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun delegate(selector: Any, eventType: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun delegate(selector: Any, eventType: String, eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun focus(): JQuery
    public fun focus(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun focus(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun focusin(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun focusin(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun focusout(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun focusout(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun hover(handlerIn: (eventObject: JQueryEventObject) -> Any, handlerOut: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun hover(handlerInOut: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun keydown(): JQuery
    public fun keydown(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    public fun keydown(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    public fun keypress(): JQuery
    public fun keypress(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    public fun keypress(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    public fun keyup(): JQuery
    public fun keyup(handler: (eventObject: JQueryKeyEventObject) -> Any): JQuery
    public fun keyup(eventData: Any? = null, handler: ((eventObject: JQueryKeyEventObject) -> Any)? = null): JQuery
    public fun load(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun load(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun mousedown(): JQuery
    public fun mousedown(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mousedown(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseenter(): JQuery
    public fun mouseenter(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseenter(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseleave(): JQuery
    public fun mouseleave(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseleave(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mousemove(): JQuery
    public fun mousemove(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mousemove(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseout(): JQuery
    public fun mouseout(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseout(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseover(): JQuery
    public fun mouseover(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseover(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseup(): JQuery
    public fun mouseup(handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun mouseup(eventData: Object, handler: (eventObject: JQueryMouseEventObject) -> Any): JQuery
    public fun off(): JQuery
    public fun off(events: String, selector: String? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun off(events: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun off(events: Json, selector: String? = null): JQuery
    public fun on(events: String, handler: (eventObject: JQueryEventObject, vararg args: Any) -> Any): JQuery
    public fun on(events: String, data: Any, handler: (eventObject: JQueryEventObject, vararg args: Any) -> Any): JQuery
    public fun on(events: String, selector: String, handler: (eventObject: JQueryEventObject, vararg eventData: Any) -> Any): JQuery
    public fun on(events: String, selector: String, data: Any, handler: (eventObject: JQueryEventObject, vararg eventData: Any) -> Any): JQuery
    public fun on(events: Json, selector: String? = null, data: Any? = null): JQuery
    public fun on(events: Json, data: Any? = null): JQuery
    public fun one(events: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun one(events: String, data: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun one(events: String, selector: String, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun one(events: String, selector: String, data: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun one(events: Json, selector: String? = null, data: Any? = null): JQuery
    public fun one(events: Json, data: Any? = null): JQuery
    public fun ready(handler: Function): JQuery
    public fun resize(): JQuery
    public fun resize(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun resize(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun scroll(): JQuery
    public fun scroll(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun scroll(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun select(): JQuery
    public fun select(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun select(eventData: Object, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun submit(): JQuery
    public fun submit(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun submit(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun trigger(eventType: String, extraParameters: dynamic /* Array<Any> | Object */? = null): JQuery
    public fun trigger(event: JQueryEventObject, extraParameters: dynamic /* Array<Any> | Object */? = null): JQuery
    public fun triggerHandler(eventType: String, vararg extraParameters: Any): Object
    public fun unbind(eventType: String? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun unbind(eventType: String, fls: Boolean): JQuery
    public fun unbind(evt: Any): JQuery
    public fun undelegate(): JQuery
    public fun undelegate(selector: String, eventType: String, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public fun undelegate(selector: String, events: Object): JQuery
    public fun undelegate(namespace: String): JQuery
    public fun unload(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun unload(eventData: Any? = null, handler: ((eventObject: JQueryEventObject) -> Any)? = null): JQuery
    public var context: Element
    public var jquery: String
    public fun error(handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun error(eventData: Any, handler: (eventObject: JQueryEventObject) -> Any): JQuery
    public fun pushStack(elements: Array<Any>): JQuery
    public fun pushStack(elements: Array<Any>, name: String, arguments: Array<Any>): JQuery
    public fun after(content1: dynamic /* JQuery | Array<Any> | Element | Text | String */, vararg content2: Any): JQuery
    public fun after(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    public fun append(content1: dynamic /* JQuery | Array<Any> | Element | Text | String */, vararg content2: Any): JQuery
    public fun append(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    public fun appendTo(target: dynamic /* JQuery | Array<Any> | Element | String */): JQuery
    public fun before(content1: dynamic /* JQuery | Array<Any> | Element | Text | String */, vararg content2: Any): JQuery
    public fun before(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    public fun clone(withDataAndEvents: Boolean? = null, deepWithDataAndEvents: Boolean? = null): JQuery
    public fun detach(selector: String? = null): JQuery
    public fun empty(): JQuery
    public fun insertAfter(target: dynamic /* JQuery | Array<Any> | Element | Text | String */): JQuery
    public fun insertBefore(target: dynamic /* JQuery | Array<Any> | Element | Text | String */): JQuery
    public fun prepend(content1: dynamic /* JQuery | Array<Any> | Element | Text | String */, vararg content2: Any): JQuery
    public fun prepend(func: (index: Number, html: String) -> dynamic /* String | Element | JQuery */): JQuery
    public fun prependTo(target: dynamic /* JQuery | Array<Any> | Element | String */): JQuery
    public fun remove(selector: String? = null): JQuery
    public fun replaceAll(target: dynamic /* JQuery | Array<Any> | Element | String */): JQuery
    public fun replaceWith(newContent: dynamic /* JQuery | Array<Any> | Element | Text | String */): JQuery
    public fun replaceWith(func: () -> dynamic /* Element | JQuery */): JQuery
    public fun text(): String
    public fun text(text: dynamic /* String | Number | Boolean */): JQuery
    public fun text(func: (index: Number, text: String) -> String): JQuery
    public fun toArray(): Array<Any>
    public fun unwrap(): JQuery
    public fun wrap(wrappingElement: dynamic /* JQuery | Element | String */): JQuery
    public fun wrap(func: (index: Number) -> dynamic /* String | JQuery */): JQuery
    public fun wrapAll(wrappingElement: dynamic /* JQuery | Element | String */): JQuery
    public fun wrapAll(func: (index: Number) -> String): JQuery
    public fun wrapInner(wrappingElement: dynamic /* JQuery | Element | String */): JQuery
    public fun wrapInner(func: (index: Number) -> String): JQuery
    public fun each(func: (index: Number, elem: Element) -> Any): JQuery
    public fun get(index: Number): HTMLElement
    public fun get(): Array<Any>
    public fun index(): Number
    public fun index(selector: dynamic /* String | JQuery | Element */): Number
    public var length: Number
    public var selector: String
    nativeGetter
    public fun get(index: String): Any
    nativeSetter
    public fun set(index: String, value: Any)
    nativeGetter
    public fun get(index: Number): HTMLElement
    nativeSetter
    public fun set(index: Number, value: HTMLElement)
    public fun add(selector: String, context: Element? = null): JQuery
    public fun add(vararg elements: Element): JQuery
    public fun add(html: String): JQuery
    public fun add(obj: JQuery): JQuery
    public fun children(selector: String? = null): JQuery
    public fun closest(selector: String): JQuery
    public fun closest(selector: String, context: Element? = null): JQuery
    public fun closest(obj: JQuery): JQuery
    public fun closest(element: Element): JQuery
    public fun closest(selectors: Any, context: Element? = null): Array<Any>
    public fun contents(): JQuery
    public fun end(): JQuery
    public fun eq(index: Number): JQuery
    public fun filter(selector: String): JQuery
    public fun filter(func: (index: Number, element: Element) -> Any): JQuery
    public fun filter(element: Element): JQuery
    public fun filter(obj: JQuery): JQuery
    public fun find(selector: String): JQuery
    public fun find(element: Element): JQuery
    public fun find(obj: JQuery): JQuery
    public fun first(): JQuery
    public fun has(selector: String): JQuery
    public fun has(contained: Element): JQuery
    public fun `is`(selector: String): Boolean
    public fun `is`(func: (index: Number, element: Element) -> Boolean): Boolean
    public fun `is`(obj: JQuery): Boolean
    public fun `is`(elements: Any): Boolean
    public fun last(): JQuery
    public fun map(callback: (index: Number, domElement: Element) -> Any): JQuery
    public fun next(selector: String? = null): JQuery
    public fun nextAll(selector: String? = null): JQuery
    public fun nextUntil(selector: String? = null, filter: String? = null): JQuery
    public fun nextUntil(element: Element? = null, filter: String? = null): JQuery
    public fun nextUntil(obj: JQuery? = null, filter: String? = null): JQuery
    public fun not(selector: String): JQuery
    public fun not(func: (index: Number, element: Element) -> Boolean): JQuery
    public fun not(vararg elements: Element): JQuery
    public fun not(obj: JQuery): JQuery
    public fun offsetParent(): JQuery
    public fun parent(selector: String? = null): JQuery
    public fun parents(selector: String? = null): JQuery
    public fun parentsUntil(selector: String? = null, filter: String? = null): JQuery
    public fun parentsUntil(element: Element? = null, filter: String? = null): JQuery
    public fun parentsUntil(obj: JQuery? = null, filter: String? = null): JQuery
    public fun prev(selector: String? = null): JQuery
    public fun prevAll(selector: String? = null): JQuery
    public fun prevUntil(selector: String? = null, filter: String? = null): JQuery
    public fun prevUntil(element: Element? = null, filter: String? = null): JQuery
    public fun prevUntil(obj: JQuery? = null, filter: String? = null): JQuery
    public fun siblings(selector: String? = null): JQuery
    public fun slice(start: Number, end: Number? = null): JQuery
    public fun queue(queueName: String? = null): Array<Any>
    public fun queue(newQueue: Array<Function>): JQuery
    public fun queue(callback: Function): JQuery
    public fun queue(queueName: String, newQueue: Array<Function>): JQuery
    public fun queue(queueName: String, callback: Function): JQuery
}
native
public var jQuery: JQueryStatic = noImpl
nativeModule("jquery")
public var `$`: JQueryStatic = noImpl
