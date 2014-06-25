package bigscreen

native
public trait BigScreenStatic {
    public var element: Element
    public var enabled: Boolean
    public fun exit(): Unit
    public fun onchange(element: Element): Unit
    public fun onenter(element: Element): Unit
    public fun onerror(element: Element, reason: String): Unit
    public fun onexit(): Unit
    public fun request(element: Element, onEnter: ((element: Element) -> Unit)? = null, onExit: (() -> Unit)? = null, onError: ((element: Element, reason: String) -> Unit)? = null): Unit
    public fun toggle(element: Element, onEnter: ((element: Element) -> Unit)? = null, onExit: (() -> Unit)? = null, onError: ((element: Element, reason: String) -> Unit)? = null): Unit
    public fun videoEnabled(video: HTMLVideoElement): Boolean
}
native
module("bigscreen")
public var bigscreen: BigScreenStatic = noImpl
