package auth0.widget

@native
interface Auth0WidgetStatic {
    @native("new")
    fun invoke(params: Auth0Constructor): Auth0WidgetStatic
    fun getClient(): Auth0Static
    fun getProfile(token: String, callback: Function): Auth0UserProfile
    fun parseHash(hash: String): Auth0DecodedHash
    fun reset(options: Auth0Options, callback: Function? = null): Auth0WidgetStatic
    fun signin(options: Auth0Options, widgetLoadedCallback: Function? = null, popupCallback: Function? = null): Auth0WidgetStatic
    fun signup(options: Auth0Options, callback: (error: Auth0Error? = null, profile: Auth0UserProfile? = null, id_token: String? = null, access_token: String? = null, state: String? = null) -> Any): Auth0WidgetStatic
}
@native
interface Auth0Constructor : Auth0ClientOptions {
    var assetsUrl: String? get() = noImpl
    var cdn: String? get() = noImpl
    var dict: Any? get() = noImpl
}
@native
interface Auth0Options {
    var access_token: String? get() = noImpl
    var connections: Array<String>? get() = noImpl
    var container: String? get() = noImpl
    var enableReturnUserExperience: Boolean? get() = noImpl
    var extraParameters: Any? get() = noImpl
    var icon: String? get() = noImpl
    var protocol: String? get() = noImpl
    var request_id: String? get() = noImpl
    var scope: String? get() = noImpl
    var showIcon: Boolean? get() = noImpl
    var showForgot: Boolean? get() = noImpl
    var showSignup: Boolean? get() = noImpl
    var state: Any? get() = noImpl
    var userPwdConnectionName: String? get() = noImpl
    var username_style: String? get() = noImpl
}
@native
@module("Auth0Widget")
var Auth0Widget: Auth0WidgetStatic = noImpl
