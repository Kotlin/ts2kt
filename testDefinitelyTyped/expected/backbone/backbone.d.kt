// OUT:
// WRONG DECLARATIONS -- missed many non exported elements
package backbone

native
public trait `T$0` {
    public fun invoke(): TModel
}
module("backbone")
public object Backbone {
    public trait AddOptions : Silenceable {
        public var at: Number?
    }
    public trait HistoryOptions : Silenceable {
        public var pushState: Boolean?
        public var root: String?
    }
    public trait NavigateOptions {
        public var trigger: Boolean?
    }
    public trait RouterOptions {
        public var routes: Any
    }
    public trait Silenceable {
        public var silent: Boolean?
    }
    public trait Validable {
        public var validate: Boolean?
    }
    public trait Waitable {
        public var wait: Boolean?
    }
    public trait Parseable {
        public var parse: Any?
    }
    public trait PersistenceOptions {
        public var url: String?
        public var beforeSend: ((jqxhr: JQueryXHR) -> Unit)?
        public var success: ((modelOrCollection: Any? = null, response: Any? = null, options: Any? = null) -> Unit)?
        public var error: ((modelOrCollection: Any? = null, jqxhr: JQueryXHR? = null, options: Any? = null) -> Unit)?
    }
    public trait ModelSetOptions : Silenceable, Validable
    public trait ModelFetchOptions : PersistenceOptions, ModelSetOptions, Parseable
    public trait ModelSaveOptions : Silenceable, Waitable, Validable, Parseable, PersistenceOptions {
        public var patch: Boolean?
    }
    public trait ModelDestroyOptions : Waitable, PersistenceOptions
    public trait CollectionFetchOptions : PersistenceOptions, Parseable {
        public var reset: Boolean?
    }
    public trait ViewOptions<TModel : Model> {
        public var model: TModel?
        public var collection: Backbone.Collection<TModel>?
        public var el: Any?
        public var id: String?
        public var className: String?
        public var tagName: String?
        public var attributes: Array<Any>?
    }
}
module
public object backbone {

}
