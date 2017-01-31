package simple

external open class BaseJQueryEventObject : Event {
    open var data: Any = noImpl
    open var delegateTarget: Element = noImpl
    open fun isDefaultPrevented(): Boolean = noImpl
    open fun isImmediatePropogationStopped(): Boolean = noImpl
    open fun isPropagationStopped(): Boolean = noImpl
}
