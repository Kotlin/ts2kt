// OUT:
// WRONG
package angular-ui-router

module
public object ng.ui  {
    public trait IState {
        public var name: String?
        public var template: Any?
        public var templateUrl: Any?
        public var templateProvider: (() -> String)?
        public var controller: Any?
        public var controllerProvider: Any?
        public var resolve: Any?
        public var url: String?
        public var params: Array<Any>?
        public var views: Any?
        public var abstract: Boolean?
        public var onEnter: Any?
        public var onExit: Any?
        public var data: Any?
    }
    public trait IStateProvider : IServiceProvider {
        public fun state(name: String, config: IState): IStateProvider
        public fun state(config: IState): IStateProvider
        public fun decorator(name: String? = null, decorator: ((state: IState, parent: Function) -> Any)? = null): Any
    }
    public trait IUrlMatcher {
        public fun concat(pattern: String): IUrlMatcher
        public fun exec(path: String, searchParams: Any): Any
        public fun parameters(): Array<String>
        public fun format(values: Any): String
    }
    public trait IUrlMatcherFactory {
        public fun compile(pattern: String): IUrlMatcher
        public fun isMatcher(o: Any): Boolean
    }
    public trait IUrlRouterProvider : IServiceProvider {
        public fun `when`(whenPath: RegExp, handler: Function): IUrlRouterProvider
        public fun `when`(whenPath: RegExp, handler: Array<Any>): IUrlRouterProvider
        public fun `when`(whenPath: RegExp, toPath: String): IUrlRouterProvider
        public fun `when`(whenPath: IUrlMatcher, hanlder: Function): IUrlRouterProvider
        public fun `when`(whenPath: IUrlMatcher, handler: Array<Any>): IUrlRouterProvider
        public fun `when`(whenPath: IUrlMatcher, toPath: String): IUrlRouterProvider
        public fun `when`(whenPath: String, handler: Function): IUrlRouterProvider
        public fun `when`(whenPath: String, handler: Array<Any>): IUrlRouterProvider
        public fun `when`(whenPath: String, toPath: String): IUrlRouterProvider
        public fun otherwise(handler: Function): IUrlRouterProvider
        public fun otherwise(handler: Array<Any>): IUrlRouterProvider
        public fun otherwise(path: String): IUrlRouterProvider
        public fun rule(handler: Function): IUrlRouterProvider
        public fun rule(handler: Array<Any>): IUrlRouterProvider
    }
    public trait IStateOptions {
        public var location: Any?
        public var inherit: Boolean?
        public var relative: IState?
        public var notify: Boolean?
    }
    public trait IHrefOptions {
        public var lossy: Boolean?
        public var inherit: Boolean?
        public var relative: IState?
        public var absolute: Boolean?
    }
    public trait IStateService {
        public fun go(to: String, params: Any? = null, options: IStateOptions? = null): IPromise<Any>
        public fun transitionTo(state: String, params: Any? = null, updateLocation: Boolean? = null): Unit
        public fun transitionTo(state: String, params: Any? = null, options: IStateOptions? = null): Unit
        public fun includes(state: String, params: Any? = null): Boolean
        public fun `is`(state: String, params: Any? = null): Boolean
        public fun `is`(state: IState, params: Any? = null): Boolean
        public fun href(state: IState, params: Any? = null, options: IHrefOptions? = null): String
        public fun href(state: String, params: Any? = null, options: IHrefOptions? = null): String
        public fun get(state: String): IState
        public fun get(): Array<IState>
        public var current: IState
        public var params: IStateParamsService
        public fun reload(): Unit
    }
    public trait IStateParamsService {
        public fun get(key: String): Any
        public fun set(key: String, value: Any): Unit
    }
    public trait IUrlRouterService {
        public fun sync(): Unit
    }
    public trait IUiViewScrollProvider {
        public fun useAnchorScroll(): Unit
    }
}
