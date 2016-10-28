package overrides

@native
interface Shape
@native
interface Box : Shape
@native
interface BaseEvent {
    var data: dynamic /* String | Number */
    fun getDelegateTarget(): Shape
    fun getElement(): Element
}
@native
open class BoxStringEvent : BaseEvent {
    override var data: String = noImpl
    override fun getDelegateTarget(): Box = noImpl
    override fun getElement(): HTMLElement = noImpl
}
@native
interface NumberEvent : BaseEvent {
    override var data: Number
}
