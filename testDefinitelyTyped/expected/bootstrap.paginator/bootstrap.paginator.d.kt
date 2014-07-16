// OUT:
// WRONG
package bootstrap.paginator

native
public trait PaginatorOptions {
    public var alignment: String?
    public var size: String?
    public var itemContainerClass: ((`type`: Any, page: Any, current: Any) -> String)?
    public var currentPage: Number?
    public var numberOfPages: Number?
    public var totalPages: Number?
    public var pageUrl: ((`type`: Any, page: Any, current: Any) -> String)?
    public var shouldShowPage: Boolean?
    public var itemTexts: ((`type`: String, page: Number, current: Number) -> String)?
    public var tooltipTitles: ((`type`: Any, page: Any, current: Any) -> String)?
    public var useBootstrapTooltip: Boolean?
    public var bootstrapTooltipOptions: Any?
    public var bootstrapMajorVersion: Number?
    public var onPageClicked: ((event: Any, originalEvent: Any, `type`: Any, page: Any) -> Unit)?
    public var onPageChanged: ((event: Any, originalEvent: Any, `type`: Any, page: Any) -> Unit)?
}
native
public trait JQuery {
    // Should be extensions
    public fun bootstrapPaginator(): JQuery
    public fun bootstrapPaginator(options: PaginatorOptions): JQuery
}
