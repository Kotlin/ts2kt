package bigscreen

@native
interface BigScreenStatic {
    var element: Element
    var enabled: Boolean
    fun exit()
    fun onchange(element: Element)
    fun onenter(element: Element)
    fun onerror(element: Element, reason: String)
    fun onexit()
    fun request(element: Element, onEnter: ((element: Element) -> Unit)? = null, onExit: (() -> Unit)? = null, onError: ((element: Element, reason: String) -> Unit)? = null)
    fun toggle(element: Element, onEnter: ((element: Element) -> Unit)? = null, onExit: (() -> Unit)? = null, onError: ((element: Element, reason: String) -> Unit)? = null)
    fun videoEnabled(video: HTMLVideoElement): Boolean
}
@native
@module("bigscreen")
var bigscreen: BigScreenStatic = noImpl
