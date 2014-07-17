package bigscreen

native
public trait BigScreenStatic {
    public var element: Element
    public var enabled: Boolean
    public fun exit()
    public fun onchange(element: Element)
    public fun onenter(element: Element)
    public fun onerror(element: Element, reason: String)
    public fun onexit()
    public fun request(element: Element, onEnter: ((element: Element) -> Unit)? = null, onExit: (() -> Unit)? = null, onError: ((element: Element, reason: String) -> Unit)? = null)
    public fun toggle(element: Element, onEnter: ((element: Element) -> Unit)? = null, onExit: (() -> Unit)? = null, onError: ((element: Element, reason: String) -> Unit)? = null)
    public fun videoEnabled(video: HTMLVideoElement): Boolean
}
native
module("bigscreen")
public var bigscreen: BigScreenStatic = noImpl
