// OUT:
// WRONG
package bootstrap

native
public trait ModalOptions {
    public var backdrop: Boolean?
    public var keyboard: Boolean?
    public var show: Boolean?
    public var remote: String?
}
native
public trait ModalOptionsBackdropString {
    public var backdrop: String?
    public var keyboard: Boolean?
    public var show: Boolean?
    public var remote: String?
}
native
public trait ScrollSpyOptions {
    public var offset: Number?
}
native
public trait TooltipOptions {
    public var animation: Boolean?
    public var html: Boolean?
    public var placement: Any?
    public var selector: String?
    public var title: Any?
    public var trigger: String?
    public var delay: Any?
    public var container: Any?
}
native
public trait PopoverOptions {
    public var animation: Boolean?
    public var html: Boolean?
    public var placement: Any?
    public var selector: String?
    public var trigger: String?
    public var title: Any?
    public var content: Any?
    public var delay: Any?
    public var container: Any?
}
native
public trait CollapseOptions {
    public var parent: Any?
    public var toggle: Boolean?
}
native
public trait CarouselOptions {
    public var interval: Number?
    public var pause: String?
}
native
public trait TypeaheadOptions {
    public var source: Any?
    public var items: Number?
    public var minLength: Number?
    public var matcher: ((item: Any) -> Boolean)?
    public var sorter: ((items: Array<Any>) -> Array<Any>)?
    public var updater: ((item: Any) -> Any)?
    public var highlighter: ((item: Any) -> String)?
}
native
public trait AffixOptions {
    public var offset: Any?
}
native
public trait JQuery {
    // Should be extensions
    public fun modal(options: ModalOptions? = null): JQuery
    public fun modal(options: ModalOptionsBackdropString? = null): JQuery
    public fun modal(command: String): JQuery
    public fun dropdown(): JQuery
    public fun dropdown(command: String): JQuery
    public fun scrollspy(command: String): JQuery
    public fun scrollspy(options: ScrollSpyOptions? = null): JQuery
    public fun tab(): JQuery
    public fun tab(command: String): JQuery
    public fun tooltip(options: TooltipOptions? = null): JQuery
    public fun tooltip(command: String): JQuery
    public fun popover(options: PopoverOptions? = null): JQuery
    public fun popover(command: String): JQuery
    public fun alert(): JQuery
    public fun alert(command: String): JQuery
    public fun button(): JQuery
    public fun button(command: String): JQuery
    public fun collapse(options: CollapseOptions? = null): JQuery
    public fun collapse(command: String): JQuery
    public fun carousel(options: CarouselOptions? = null): JQuery
    public fun carousel(command: String): JQuery
    public fun typeahead(options: TypeaheadOptions? = null): JQuery
    public fun affix(options: AffixOptions? = null): JQuery
}
module
public object bootstrap {

}
