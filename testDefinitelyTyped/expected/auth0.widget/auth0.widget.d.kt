package auth0.widget

native
public trait Auth0WidgetStatic {
    nativeNew
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
    public var assetsUrl: String? = noImpl
    public var cdn: String? = noImpl
    public var dict: Any? = noImpl
}
native
public trait Auth0Options {
    public var access_token: String? = noImpl
    public var connections: Array<String>? = noImpl
    public var container: String? = noImpl
    public var enableReturnUserExperience: Boolean? = noImpl
    public var extraParameters: Any? = noImpl
    public var icon: String? = noImpl
    public var protocol: String? = noImpl
    public var request_id: String? = noImpl
    public var scope: String? = noImpl
    public var showIcon: Boolean? = noImpl
    public var showForgot: Boolean? = noImpl
    public var showSignup: Boolean? = noImpl
    public var state: Any? = noImpl
    public var userPwdConnectionName: String? = noImpl
    public var username_style: String? = noImpl
}
native
module("Auth0Widget")
public var Auth0Widget: Auth0WidgetStatic = noImpl
