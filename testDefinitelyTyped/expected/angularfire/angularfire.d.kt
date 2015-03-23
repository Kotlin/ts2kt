package angularfire

native
public trait AngularFireService {
    nativeInvoke
    public fun invoke(firebase: Firebase, config: Any? = null): AngularFire
}
native
public trait AngularFire {
    public fun `$asArray`(): AngularFireArray
    public fun `$asObject`(): AngularFireObject
    public fun `$ref`(): Firebase
    public fun `$push`(data: Any): ng.IPromise<Firebase>
    public fun `$set`(key: String, data: Any): ng.IPromise<Firebase>
    public fun `$set`(data: Any): ng.IPromise<Firebase>
    public fun `$remove`(key: String? = null): ng.IPromise<Firebase>
    public fun `$update`(key: String, data: Object): ng.IPromise<Firebase>
    public fun `$update`(data: Any): ng.IPromise<Firebase>
    public fun `$transaction`(updateFn: (currentData: Any) -> Any, applyLocally: Boolean? = null): ng.IPromise<FirebaseDataSnapshot>
    public fun `$transaction`(key: String, updateFn: (currentData: Any) -> Any, applyLocally: Boolean? = null): ng.IPromise<FirebaseDataSnapshot>
}
native
public trait AngularFireObject : AngularFireSimpleObject {
    override var `$id`: String
    override var `$priority`: Number
    override var `$value`: Any
    public fun `$save`(): ng.IPromise<Firebase>
    public fun `$loaded`(resolve: ((x: AngularFireObject) -> ng.IHttpPromise<Any>)? = null, reject: ((err: Any) -> Any)? = null): ng.IPromise<AngularFireObject>
    public fun `$loaded`(resolve: ((x: AngularFireObject) -> ng.IPromise<Any>)? = null, reject: ((err: Any) -> Any)? = null): ng.IPromise<AngularFireObject>
    public fun `$loaded`(resolve: ((x: AngularFireObject) -> Unit)? = null, reject: ((err: Any) -> Any)? = null): ng.IPromise<AngularFireObject>
    public fun `$inst`(): AngularFire
    public fun `$bindTo`(scope: ng.IScope, varName: String): ng.IPromise<Any>
    public fun `$watch`(callback: Function, context: Any? = null): Function
    public fun `$destroy`()
}
native
public trait AngularFireObjectService {
    public fun `$extendFactory`(ChildClass: Object, methods: Object? = null): Object
}
native
public trait AngularFireArray : Array<AngularFireSimpleObject> {
    public fun `$add`(newData: Any): ng.IPromise<Firebase>
    public fun `$save`(recordOrIndex: Any): ng.IPromise<Firebase>
    public fun `$remove`(recordOrIndex: Any): ng.IPromise<Firebase>
    public fun `$getRecord`(key: String): AngularFireSimpleObject
    public fun `$keyAt`(recordOrIndex: Any): String
    public fun `$indexFor`(key: String): Number
    public fun `$loaded`(resolve: ((x: AngularFireArray) -> ng.IHttpPromise<Any>)? = null, reject: ((err: Any) -> Any)? = null): ng.IPromise<AngularFireArray>
    public fun `$loaded`(resolve: ((x: AngularFireArray) -> ng.IPromise<Any>)? = null, reject: ((err: Any) -> Any)? = null): ng.IPromise<AngularFireArray>
    public fun `$loaded`(resolve: ((x: AngularFireArray) -> Unit)? = null, reject: ((err: Any) -> Any)? = null): ng.IPromise<AngularFireArray>
    public fun `$inst`(): AngularFire
    public fun `$watch`(cb: (event: String, key: String, prevChild: String) -> Unit, context: Any? = null): Function
    public fun `$destroy`()
}
native
public trait AngularFireArrayService {
    public fun `$extendFactory`(ChildClass: Object, methods: Object? = null): Object
}
native
public trait AngularFireSimpleObject {
    public var `$id`: String
    public var `$priority`: Number
    public var `$value`: Any
    nativeGetter
    public fun get(key: String): Any
    nativeSetter
    public fun set(key: String, value: Any)
}
native
public trait AngularFireAuthService {
    nativeInvoke
    public fun invoke(firebase: Firebase): AngularFireAuth
}
native
public trait AngularFireAuth {
    public fun `$getCurrentUser`(): ng.IPromise<Any>
    public fun `$login`(provider: String, options: Object? = null): ng.IPromise<Any>
    public fun `$logout`()
    public fun `$createUser`(email: String, password: String): ng.IPromise<Any>
    public fun `$changePassword`(email: String, oldPassword: String, newPassword: String): ng.IPromise<Any>
    public fun `$removeUser`(email: String, password: String): ng.IPromise<Any>
    public fun `$sendPasswordResetEmail`(email: String): ng.IPromise<Any>
}
