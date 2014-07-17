package angularfire

native
public trait AngularFireService {
    public fun invoke(firebase: Firebase): AngularFire
}
native
public trait AngularFire {
    public fun `$add`(value: Any)
    public fun `$remove`(key: String? = null)
    public fun `$save`(key: String? = null)
    public fun `$child`(key: String): AngularFire
    public fun `$set`(value: Any)
    public fun `$getIndex`(): Array<String>
    public fun `$on`(eventType: String, callback: (dataSnapshot: IFirebaseDataSnapshot, prevChildName: String? = null) -> Unit, cancelCallback: (() -> Unit)? = null, context: Object? = null): (dataSnapshot: IFirebaseDataSnapshot, prevChildName: String? = null) -> Unit
    public fun `$off`(eventType: String? = null, callback: ((dataSnapshot: IFirebaseDataSnapshot, prevChildName: String? = null) -> Unit)? = null, cancelCallback: (() -> Unit)? = null, context: Object? = null): (dataSnapshot: IFirebaseDataSnapshot, prevChildName: String? = null) -> Unit
    public fun `$bind`(`$scope`: ng.IScope, modelName: String): ng.IPromise<Any>
}
native
public trait AngularFireObject {
    public var `$priority`: Number
}
native
public trait AngularFireAuthService {
    public fun invoke(firebase: Firebase): AngularFireAuth
}
native
public trait AngularFireAuth {
    public fun `$getCurrentUser`(): ng.IPromise<Any>
    public fun `$login`(provider: String, options: Object? = null): ng.IPromise<Any>
    public fun `$logout`()
    public fun `$createUser`(email: String, password: String, noLogin: Boolean? = null): ng.IPromise<Any>
    public fun `$changePassword`(email: String, oldPassword: String, newPassword: String): ng.IPromise<Any>
    public fun `$removeUser`(email: String, password: String): ng.IPromise<Any>
    public fun `$sendPasswordResetEmail`(email: String): ng.IPromise<Any>
}
