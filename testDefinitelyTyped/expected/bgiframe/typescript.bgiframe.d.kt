package typescript.bgiframe

@module
object BgiFrame {
    interface ISettings {
        var top: String
        var left: String
        var width: String
        var height: String
        var opacity: Boolean
        var src: String
        var conditional: Boolean
    }
    interface IBgiframe {
        var s: ISettings
        fun createIframe(): HTMLElement
        fun fire(element: HTMLElement)
        fun getIframe(element: HTMLElement): HTMLElement
        fun prop(n: Any): String
    }
}
