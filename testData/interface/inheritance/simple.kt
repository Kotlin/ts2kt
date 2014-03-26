package simple

native
public trait BaseJQueryEventObject : Event {
    public var data: Any
    public var delegateTarget: Element
    public fun isDefaultPrevented(): Boolean
    public fun isImmediatePropogationStopped(): Boolean
    public fun isPropagationStopped(): Boolean
}
