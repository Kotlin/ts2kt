// OUT:
package auth0

native
public trait Window {
// Should be extenstion?
    public var token: String
}
native
public trait Location {
// Should be extenstion?
    public var origin: String
}
native
public trait Auth0Static {
    public fun invoke(options: Auth0ClientOptions): Auth0Static
    public fun changePassword(options: Any, callback: Function? = null): Unit
    public fun decodeJwt(jwt: String): Any
    public fun login(options: Any, callback: (error: Auth0Error? = null, profile: Auth0UserProfile? = null, id_token: String? = null, access_token: String? = null, state: String? = null) -> Any): Unit
    public fun loginWithPopup(options: Auth0LoginOptions, callback: (error: Auth0Error? = null, profile: Auth0UserProfile? = null, id_token: String? = null, access_token: String? = null, state: String? = null) -> Any): Unit
    public fun loginWithResourceOwner(options: Auth0LoginOptions, callback: (error: Auth0Error? = null, profile: Auth0UserProfile? = null, id_token: String? = null, access_token: String? = null, state: Any? = null) -> Any): Unit
    public fun loginWithUsernamePassword(options: Auth0LoginOptions, callback: (error: Auth0Error? = null, profile: Auth0UserProfile? = null, id_token: String? = null, access_token: String? = null, state: String? = null) -> Any): Unit
    public fun logout(query: String): Unit
    public fun getConnections(callback: Function? = null): Unit
    public fun getDelegationToken(targetClientId: String, id_token: String, options: Any, callback: (error: Auth0Error? = null, delegationResult: Auth0DelegationToken? = null) -> Any): Unit
    public fun getProfile(id_token: String, callback: Function? = null): Auth0UserProfile
    public fun getSSOData(withActiveDirectories: Any, callback: Function? = null): Unit
    public fun parseHash(hash: String): Auth0DecodedHash
    public fun signup(options: Auth0SignupOptions, callback: Function): Unit
    public fun validateUser(options: Any, callback: (error: Auth0Error? = null, valid: Any? = null) -> Any): Unit
}
native
public trait Auth0ClientOptions {
    public var clientID: String
    public var callbackURL: String
    public var callbackOnLoactionHash: Boolean? = noImpl
    public var domain: String
    public var forceJSONP: Boolean? = noImpl
}
native
public trait Auth0UserProfile {
    public var email: String
    public var family_name: String
    public var gender: String
    public var given_name: String
    public var locale: String
    public var name: String
    public var nickname: String
    public var picture: String
    public var user_id: String
    public var identities: Array<Auth0Identity>
}
native
public trait MicrosoftUserProfile : Auth0UserProfile {
    public var emails: Array<String>
}
native
public trait Office365UserProfile : Auth0UserProfile {
    public var tenantid: String
    public var upn: String
}
native
public trait AdfsUserProfile : Auth0UserProfile {
    public var issuer: String
}
native
public trait Auth0Identity {
    public var access_token: String
    public var connection: String
    public var isSocial: Boolean
    public var provider: String
    public var user_id: String
}
native
public trait Auth0DecodedHash {
    public var access_token: String
    public var id_token: String
    public var profile: Auth0UserProfile
    public var state: Any
}
native
public trait Auth0PopupOptions {
    public var width: Number
    public var height: Number
}
native
public trait Auth0LoginOptions {
    public var auto_login: Boolean? = noImpl
    public var connection: String? = noImpl
    public var email: String? = noImpl
    public var username: String? = noImpl
    public var password: String? = noImpl
    public var popup: Boolean? = noImpl
    public var popupOptions: Auth0PopupOptions? = noImpl
}
native
public trait Auth0SignupOptions : Auth0LoginOptions {
    public var auto_login: Boolean
}
native
public trait Auth0Error {
    public var code: Any
    public var details: Any
    public var name: String
    public var message: String
    public var status: Any
}
native
public trait Auth0DelegationToken {
    public var expires_in: String
    public var id_token: String
    public var token_type: String
}
native
module("Auth0")
public var Auth0: Auth0Static = noImpl
