package module

@module
object Ext {
    interface IAbstractComponent : Ext.IBase, Ext.util.IPositionable, Ext.util.IObservable, Ext.util.IAnimate, Ext.util.IElementContainer, Ext.util.IRenderable, Ext.state.IStateful {
        var autoEl: Any
        var autoLoad: Any? = noImpl
        var autoRender: Any
    }
    var num: Number = noImpl
    fun foo(): Unit = noImpl
    interface IAbstractPlugin : Ext.IBase {
        var pluginId: String? = noImpl
        var isPlugin: Boolean? = noImpl
    }
    var str: String = noImpl
    fun bar(): Unit = noImpl
}
