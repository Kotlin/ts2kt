[file: nativePackageRoot]
package module

/* ============= */
[file: nativePackage]
package module.Ext

native
public trait IAbstractComponent : Ext.IBase, Ext.util.IPositionable, Ext.util.IObservable, Ext.util.IAnimate, Ext.util.IElementContainer, Ext.util.IRenderable, Ext.state.IStateful {
    public var autoEl: Any
    public var autoLoad: Any? = noImpl
    public var autoRender: Any
}
native
public var num: Number = noImpl
native
public fun foo(): Unit = noImpl
native
public trait IAbstractPlugin : Ext.IBase {
    public var pluginId: String? = noImpl
    public var isPlugin: Boolean? = noImpl
}
native
public var str: String = noImpl
native
public fun bar(): Unit = noImpl
