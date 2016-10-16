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
    var assetsUrl: String? = noImpl
    var cdn: String? = noImpl
    var dict: Any? = noImpl
}
@native
interface Auth0Options {
    var access_token: String? = noImpl
    var connections: Array<String>? = noImpl
    var container: String? = noImpl
    var enableReturnUserExperience: Boolean? = noImpl
    var extraParameters: Any? = noImpl
    var icon: String? = noImpl
    var protocol: String? = noImpl
    var request_id: String? = noImpl
    var scope: String? = noImpl
    var showIcon: Boolean? = noImpl
    var showForgot: Boolean? = noImpl
    var showSignup: Boolean? = noImpl
    var state: Any? = noImpl
    var userPwdConnectionName: String? = noImpl
    var username_style: String? = noImpl
}
@native
@module("Auth0Widget")
var Auth0Widget: Auth0WidgetStatic = noImpl
