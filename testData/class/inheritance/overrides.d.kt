package overrides

external interface Shape
external interface Box : Shape
external interface BaseEvent {
    var data: dynamic /* String | Number */
    fun getDelegateTarget(): Shape
    fun getElement(): Element
}
external open class BoxStringEvent : BaseEvent {
    override var data: String = noImpl
    override fun getDelegateTarget(): Box = noImpl
    override fun getElement(): HTMLElement = noImpl
}
external interface NumberEvent : BaseEvent {
    override var data: Number
}
