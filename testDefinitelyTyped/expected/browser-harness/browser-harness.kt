// OUT:
// WRONG
package browser-harness

native
public trait `T$0` {
    public var func: Function
    public var args: Array<Any>?
}
native
public trait `T$1` {
    public var condition: Function
    public var exec: Function?
    public var timeoutMS: Number?
}
native
public trait `T$2` {
    public var `type`: String
    public var location: String?
    public var args: Any?
}
native
public trait `T$3` {
    public var timeoutMS: Number
    public var retryMS: Number
}
module
// WRONG
public object browser-harness {
    public trait HarnessEvents : _events.EventEmitter  {
        public fun once(event: String, listener: (driver: Driver) -> Unit): _events.EventEmitter
        // WRONG
        public fun once(event: 'ready', listener: (driver: Driver) -> Unit): _events.EventEmitter
        public fun on(event: String, listener: (driver: Driver) -> Unit): _events.EventEmitter
        // WRONG
        public fun on(event: 'ready', listener: (driver: Driver) -> Unit): _events.EventEmitter
    }
    public trait DriverEvents : _events.EventEmitter  {
        public fun once(event: String, listener: (text: String) -> Unit): _events.EventEmitter
        // WRONG
        public fun once(event: 'console.log', listener: (text: String) -> Unit): _events.EventEmitter
        public fun once(event: 'console.warn', listener: (text: String) -> Unit): _events.EventEmitter
        public fun once(event: 'console.error', listener: (text: String) -> Unit): _events.EventEmitter
        public fun once(event: 'window.onerror', listener: (text: String) -> Unit): _events.EventEmitter
        public fun on(event: String, listener: (text: String) -> Unit): _events.EventEmitter
        public fun on(event: 'console.log', listener: (text: String) -> Unit): _events.EventEmitter
        public fun on(event: 'console.warn', listener: (text: String) -> Unit): _events.EventEmitter
        public fun on(event: 'console.error', listener: (text: String) -> Unit): _events.EventEmitter
        public fun on(event: 'window.onerror', listener: (text: String) -> Unit): _events.EventEmitter
    }
    public trait Driver {
        public fun exec(args: `T$0`, callback: Function? = null): Any
        public fun exec(func: Function, callback: Function? = null): Any
        public fun setUrl(url: String, callback: Function? = null): Unit
        public fun waitFor(args: `T$1`, callback: Function? = null): Unit
        public fun waitFor(condition: Function, callback: Function? = null): Unit
        public fun findElement(selector: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun findElements(selector: String, callback: ((err: Error, elements: ElementProxy) -> Unit)? = null): ElementProxy
        public fun findVisible(selector: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun findVisibles(selector: String, callback: ((err: Error, elements: ElementProxy) -> Unit)? = null): ElementProxy
        public fun find(selector: String, callback: ((err: Error, elements: ElementProxy) -> Unit)? = null): ElementProxy
        public var events: DriverEvents
    }
    public trait ElementProxy {
        public fun click(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun focus(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun blur(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun `val`(value: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun attr(name: String, value: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun removeAttr(name: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun prop(name: String, value: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun removeProp(name: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun html(value: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun text(value: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun hasClass(className: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun addClass(className: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun removeClass(className: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun toggleClass(className: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun trigger(event: String, extraParameters: Any? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun triggerHandler(event: String, extraParameters: Any? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun css(name: String, value: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun height(value: Any? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun innerHeight(value: Any? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun outerHeight(value: Any? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun width(value: Any? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun innerWidth(value: Any? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun outerWidth(value: Any? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun offset(value: Any? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun position(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun scrollLeft(value: Number? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun scrollTop(value: Number? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun hide(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun show(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun toggle(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun children(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun closest(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun contents(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun find(selector: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun findElements(selector: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun findElement(selector: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun findVisible(selector: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun findVisibles(selector: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun isActionable(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun first(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun has(arg: Any, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun `is`(arg: Any, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun last(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun next(selector: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun nextAll(selector: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun nextUntil(selector: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun offsetParent(callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun parent(selector: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun parents(selector: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun parentsUntil(selector: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun prev(selector: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun prevAll(selector: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun prevUntil(selector: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun siblings(selector: String? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun data(name: String, value: Any? = null, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun removeData(name: String, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
        public fun filter(selector: Any, callback: ((err: Error, element: ElementProxy) -> Unit)? = null): ElementProxy
    }
    public class Browser(args: `T$2`) {
        public fun open(harnessUrl: String, serverUrl: String? = null): Unit = noImpl
        public fun close(): Unit = noImpl
    }
    public fun listen(port: Number, callback: Function? = null): Unit = noImpl
    public var events: HarnessEvents = noImpl
    public var config: `T$3` = noImpl
}
