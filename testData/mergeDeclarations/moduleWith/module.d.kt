package module.Ext

interface IAbstractComponent : Ext.IBase, Ext.util.IPositionable, Ext.util.IObservable, Ext.util.IAnimate, Ext.util.IElementContainer, Ext.util.IRenderable, Ext.state.IStateful {
    var autoEl: Any
    var autoLoad: Any? get() = definedExternally; set(value) = definedExternally
    var autoRender: Any
}
var num: Number = definedExternally
fun foo(): Unit = definedExternally
interface IAbstractPlugin : Ext.IBase {
    var pluginId: String? get() = definedExternally; set(value) = definedExternally
    var isPlugin: Boolean? get() = definedExternally; set(value) = definedExternally
}
var str: String = definedExternally
fun bar(): Unit = definedExternally
