package module

module
public object Ext {
    public trait IAbstractComponent : Ext.IBase, Ext.util.IPositionable, Ext.util.IObservable, Ext.util.IAnimate, Ext.util.IElementContainer, Ext.util.IRenderable, Ext.state.IStateful  {
        public var autoEl: Any
        public var autoLoad: Any?
        public var autoRender: Any
    }
    public var num: Number = noImpl
    public fun foo(): Unit = noImpl
    public trait IAbstractPlugin : Ext.IBase  {
        public var pluginId: String?
        public var isPlugin: Boolean?
    }
    public var str: String = noImpl
    public fun bar(): Unit = noImpl
}
