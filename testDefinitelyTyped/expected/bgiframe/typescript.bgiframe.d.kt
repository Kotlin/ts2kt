[file: nativePackageRoot]
package typescript.bgiframe

/* ============= */
[file: nativePackage]
package typescript.bgiframe.BgiFrame

native
public trait ISettings {
    public var top: String
    public var left: String
    public var width: String
    public var height: String
    public var opacity: Boolean
    public var src: String
    public var conditional: Boolean
}
native
public trait IBgiframe {
    public var s: ISettings
    public fun createIframe(): HTMLElement
    public fun fire(element: HTMLElement)
    public fun getIframe(element: HTMLElement): HTMLElement
    public fun prop(n: Any): String
}
