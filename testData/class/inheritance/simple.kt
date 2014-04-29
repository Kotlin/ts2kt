package simple

native
public class BaseJQueryEventObject : Event {
    public var data: Any = noImpl
    public var delegateTarget: Element = noImpl
    public fun isDefaultPrevented(): Boolean = noImpl
    public fun isImmediatePropogationStopped(): Boolean = noImpl
    public fun isPropagationStopped(): Boolean = noImpl
}
