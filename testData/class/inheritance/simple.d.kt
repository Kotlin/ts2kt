package simple

native
public open class BaseJQueryEventObject : Event {
    public open var data: Any = noImpl
    public open var delegateTarget: Element = noImpl
    public open fun isDefaultPrevented(): Boolean = noImpl
    public open fun isImmediatePropogationStopped(): Boolean = noImpl
    public open fun isPropagationStopped(): Boolean = noImpl
}
