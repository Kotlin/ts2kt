package appframework

native
public trait `T$0` {
    public var webkit: Boolean
    public var android: Boolean
    public var androidICS: Boolean
    public var ipad: Boolean
    public var iphone: Boolean
    public var ios7: Boolean
    public var webos: Boolean
    public var touchpad: Boolean
    public var ios: Boolean
    public var playbook: Boolean
    public var blackberry: Boolean
    public var blackberry10: Boolean
    public var chrome: Boolean
    public var opera: Boolean
    public var fennec: Boolean
    public var ie: Boolean
    public var ieTouch: Boolean
    public var supportsTouch: Boolean
}
native
public trait `T$1` {
    public var nativeTouchScroll: Boolean
    public var cssPrefix: String
    public var cssTransformStart: String
    public var cssTransformEnd: String
}
native
public trait appFrameworkStatic {
    public fun invoke(selector: String, context: Any? = null): appFrameworkCollection
    public fun invoke(collection: appFrameworkCollection): appFrameworkCollection
    public fun invoke(element: HTMLElement): appFrameworkCollection
    public fun invoke(htmlString: String): appFrameworkCollection
    public fun invoke(`object`: Any): appFrameworkCollection
    public fun `is$`(obj: Any): Boolean
    public fun map(collection: Array<Any>, fn: (item: Any, index: Number) -> Any): Array<Any>
    public fun each(collection: Array<Any>, fn: (index: Number, item: Any) -> Any): Unit
    public fun each(collection: Any, fn: (key: String, value: Any) -> Any): Unit
    public fun extend(target: Any, vararg sources: Any): Any
    public fun isArray(`object`: Any): Boolean
    public fun isFunction(`object`: Any): Boolean
    public fun isObject(`object`: Any): Boolean
    public var fn: Object
    public var ajaxSettings: appFrameworkAjaxSettings
    public fun jsonP(options: appFrameworkAjaxSettings): Any
    public fun ajax(options: appFrameworkAjaxSettings): XMLHttpRequest
    public fun get(url: String, fn: (data: Any, status: String? = null, xhr: XMLHttpRequest? = null) -> Unit): XMLHttpRequest
    public fun post(url: String, fn: (data: Any, status: String? = null, xhr: XMLHttpRequest? = null) -> Unit, dataType: String? = null): XMLHttpRequest
    public fun post(url: String, data: Any, fn: (data: Any, status: String? = null, xhr: XMLHttpRequest? = null) -> Unit, dataType: String? = null): XMLHttpRequest
    public fun getJSON(url: String, fn: (data: Any, status: String? = null, xhr: XMLHttpRequest? = null) -> Unit): XMLHttpRequest
    public fun getJSON(url: String, data: Any, fn: (data: Any, status: String, xhr: XMLHttpRequest) -> Unit): XMLHttpRequest
    public fun param(`object`: Any, prefix: String? = null): String
    public fun parseJSON(str: String): Any
    public fun parseXML(str: String): Any
    public fun uuid(): String
    public fun getCssMatrix(node: HTMLElement): appFrameworkCssMatrix
    public fun getCssMatrix(elem: appFrameworkCollection): appFrameworkCssMatrix
    public fun create(`type`: String, params: Any? = null): appFrameworkCollection
    public fun query(selector: String, context: Any? = null): appFrameworkCollection
    public fun Event(`type`: String, props: Any): Any
    public fun bind(`object`: Any, event: String, fn: Function): Unit
    public fun trigger(`object`: Any, event: String, args: Array<Any>? = null): Unit
    public fun unbind(`object`: Any, event: String, fn: Function): Unit
    public fun proxy(callback: Function, context: Any): Unit
    public fun cleanUpContent(node: HTMLElement, itself: Boolean? = null, kill: Boolean? = null): Unit
    public fun asap(callback: Function, context: Any? = null, args: Array<Any>? = null): Unit
    public fun parseJS(content: String): Unit
    public fun parseJS(content: HTMLElement): Unit
    public var os: `T$0`
    public var feat: `T$1`
}
native
public trait `T$2` {
    public var left: Number
    public var top: Number
    public var right: Number
    public var bottom: Number
    public var width: Number
    public var height: Number
}
native
public trait appFrameworkCollection {
    public fun reduce(callbackfn: (previousValue: appFrameworkCollection, currentValue: appFrameworkCollection, currentIndex: Number, array: Array<appFrameworkCollection>) -> appFrameworkCollection, initialValue: appFrameworkCollection? = null): appFrameworkCollection
    public fun push(vararg items: appFrameworkCollection): Number
    public fun indexOf(searchElement: appFrameworkCollection, fromIndex: Number? = null): Number
    public fun concat(vararg items: appFrameworkCollection): Array<appFrameworkCollection>
    public fun slice(start: Number, end: Number? = null): Array<appFrameworkCollection>
    public var length: Number
    public fun map(fn: (index: Number, item: Any) -> Any): appFrameworkCollection
    public fun each(fn: (index: Number, item: Any) -> Any): appFrameworkCollection
    public fun forEach(fn: (item: Any, index: Number) -> Any): Unit
    public fun ready(fn: Function): appFrameworkStatic
    public fun find(selector: String): appFrameworkCollection
    public fun html(): String
    public fun html(html: String): appFrameworkCollection
    public fun html(html: String, cleanup: Boolean): appFrameworkCollection
    public fun text(): String
    public fun text(text: String): appFrameworkCollection
    public fun css(property: String): Any
    public fun css(property: String, value: Any): appFrameworkCollection
    public fun css(properties: Any): appFrameworkCollection
    public fun vendorCss(transform: String): appFrameworkCollection
    public fun computedStyle(css: String): appFrameworkCollection
    public fun empty(): appFrameworkCollection
    public fun hide(): appFrameworkCollection
    public fun show(): appFrameworkCollection
    public fun toggle(show: Boolean? = null): appFrameworkCollection
    public fun `val`(): String
    public fun `val`(value: String): appFrameworkCollection
    public fun attr(attribute: String): Any
    public fun attr(attributeHash: Object): appFrameworkCollection
    public fun attr(attribute: String, value: String): appFrameworkCollection
    public fun attr(attribute: String, value: Any): appFrameworkCollection
    public fun removeAttr(attribute: String): appFrameworkCollection
    public fun prop(attribute: String): Any
    public fun prop(attributeHash: Object): appFrameworkCollection
    public fun prop(attribute: String, value: String): appFrameworkCollection
    public fun prop(attribute: String, value: Any): appFrameworkCollection
    public fun removeProp(attribute: String): appFrameworkCollection
    public fun remove(): appFrameworkCollection
    public fun remove(selector: String): appFrameworkCollection
    public fun remove(element: HTMLElement): appFrameworkCollection
    public fun remove(elements: Array<Any>): appFrameworkCollection
    public fun remove(elements: appFrameworkCollection): appFrameworkCollection
    public fun addClass(className: String): appFrameworkCollection
    public fun removeClass(className: String): appFrameworkCollection
    public fun toggleClass(name: String, state: Boolean? = null): appFrameworkCollection
    public fun replaceClass(oldClassName: String, newClassName: String): appFrameworkCollection
    public fun hasClass(className: String, element: HTMLElement): Boolean
    public fun append(content: Any): appFrameworkCollection
    public fun appendTo(target: Any): appFrameworkCollection
    public fun prependTo(target: Any): appFrameworkCollection
    public fun prepend(content: Any): appFrameworkCollection
    public fun insertBefore(target: Any): appFrameworkCollection
    public fun insertAfter(target: Any): Unit
    public fun get(): Array<HTMLElement>
    public fun get(index: Number): HTMLElement
    public fun offset(): `T$2`
    public fun height(): String
    public fun width(): String
    public fun parent(selector: Any? = null): appFrameworkCollection
    public fun parents(selector: Any? = null): appFrameworkCollection
    public fun children(selector: Any? = null): appFrameworkCollection
    public fun siblings(selector: Any? = null): appFrameworkCollection
    public fun closest(selector: Any? = null): appFrameworkCollection
    public fun filter(selector: Any? = null): appFrameworkCollection
    public fun not(selector: Any? = null): appFrameworkCollection
    public fun data(attribute: String): Any
    public fun data(attribute: String, value: String): appFrameworkCollection
    public fun data(attribute: String, value: Any): appFrameworkCollection
    public fun end(): appFrameworkCollection
    public fun clone(deep: Boolean? = null): appFrameworkCollection
    public fun size(): Number
    public fun serialize(): String
    public fun eq(index: Number): appFrameworkCollection
    public fun index(): Number
    public fun index(selector: Any): Number
    public fun `is`(selector: Any): Number
    public fun bind(eventHash: Object): appFrameworkCollection
    public fun bind(eventName: String, fn: (e: Event) -> Any): appFrameworkCollection
    public fun unbind(eventHash: Any): appFrameworkCollection
    public fun unbind(eventName: String? = null): appFrameworkCollection
    public fun unbind(eventName: String, fn: ((e: Event) -> Any)? = null): appFrameworkCollection
    public fun one(eventHash: Any): appFrameworkCollection
    public fun one(eventName: String, fn: (e: Event) -> Any): appFrameworkCollection
    public fun delegate(selector: Any, eventHash: Any): appFrameworkCollection
    public fun delegate(selector: Any, eventName: String, fn: (e: Event) -> Any): appFrameworkCollection
    public fun undelegate(selector: Any, eventHash: Any): appFrameworkCollection
    public fun undelegate(selector: Any, eventName: String, fn: (e: Event) -> Any): appFrameworkCollection
    public fun on(eventHash: Any, selector: Any? = null): appFrameworkCollection
    public fun on(eventName: String, fn: (e: Event) -> Any): appFrameworkCollection
    public fun on(eventName: String, selector: String, fn: (e: Event) -> Any): appFrameworkCollection
    public fun off(eventHash: Any, selector: Any? = null): appFrameworkCollection
    public fun off(eventName: String, fn: (e: Event) -> Any): appFrameworkCollection
    public fun off(eventName: String, selector: String, fn: (e: Event) -> Any): appFrameworkCollection
    public fun trigger(eventName: String, data: Any? = null): appFrameworkCollection
    public fun trigger(eventHash: Any, data: Any? = null): appFrameworkCollection
    public fun click(fn: ((e: Event) -> Any)? = null): appFrameworkCollection
    public fun keydown(fn: ((e: Event) -> Any)? = null): appFrameworkCollection
    public fun keyup(fn: ((e: Event) -> Any)? = null): appFrameworkCollection
    public fun keypress(fn: ((e: Event) -> Any)? = null): appFrameworkCollection
    public fun submit(fn: ((e: Event) -> Any)? = null): appFrameworkCollection
    public fun load(fn: ((e: Event) -> Any)? = null): appFrameworkCollection
    public fun resize(fn: ((e: Event) -> Any)? = null): appFrameworkCollection
    public fun change(fn: ((e: Event) -> Any)? = null): appFrameworkCollection
    public fun select(fn: ((e: Event) -> Any)? = null): appFrameworkCollection
    public fun error(fn: ((e: Event) -> Any)? = null): appFrameworkCollection
    public fun focus(fn: ((e: Event) -> Any)? = null): appFrameworkCollection
    public fun blur(fn: ((e: Event) -> Any)? = null): appFrameworkCollection
}
native
public trait appFrameworkAjaxSettings {
    public var `type`: String?
    public var beforeSend: ((xhr: XMLHttpRequest, settings: appFrameworkAjaxSettings) -> Boolean)?
    public var success: ((data: Any, status: String, xhr: XMLHttpRequest) -> Unit)?
    public var error: ((xhr: XMLHttpRequest, errorType: String, error: Error) -> Unit)?
    public var complete: ((xhr: XMLHttpRequest, status: String) -> Unit)?
    public var timeout: Number?
    public var url: String?
    public var contentType: String?
    public var headers: Any?
    public var dataType: String?
    public var data: Any?
    public var context: Any?
    public var crossDomain: Boolean?
}
native
public trait appFrameworkCssMatrix {
    public var a: Number
    public var b: Number
    public var c: Number
    public var d: Number
    public var e: Number
    public var f: Number
}
native
public var af: (fn: (`$`: appFrameworkStatic) -> Unit) -> Unit = noImpl
native
public var `$`: appFrameworkStatic = noImpl
