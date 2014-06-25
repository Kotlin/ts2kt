package auth0.widget

native
public trait Auth0WidgetStatic {
    public fun invoke(params: Auth0Constructor): Auth0WidgetStatic
    public fun getClient(): Auth0Static
    public fun getProfile(token: String, callback: Function): Auth0UserProfile
    public fun parseHash(hash: String): Auth0DecodedHash
    public fun reset(options: Auth0Options, callback: Function? = null): Auth0WidgetStatic
    public fun signin(options: Auth0Options, widgetLoadedCallback: Function? = null, popupCallback: Function? = null): Auth0WidgetStatic
    public fun signup(options: Auth0Options, callback: (error: Auth0Error? = null, profile: Auth0UserProfile? = null, id_token: String? = null, access_token: String? = null, state: String? = null) -> Any): Auth0WidgetStatic
}
native
public trait Auth0Constructor : Auth0ClientOptions {
    public var assetsUrl: String?
    public var cdn: String?
    public var dict: Any?
}
native
public trait Auth0Options {
    public var access_token: String?
    public var connections: Array<String>?
    public var container: String?
    public var enableReturnUserExperience: Boolean?
    public var extraParameters: Any?
    public var icon: String?
    public var protocol: String?
    public var request_id: String?
    public var scope: String?
    public var showIcon: Boolean?
    public var showForgot: Boolean?
    public var showSignup: Boolean?
    public var state: Any?
    public var userPwdConnectionName: String?
    public var username_style: String?
}
native
module("Auth0Widget")
public var Auth0Widget: Auth0WidgetStatic = noImpl
