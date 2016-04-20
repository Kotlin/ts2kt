package angularfire

@native
interface AngularFireService {
    @nativeInvoke
    fun invoke(firebase: Firebase, config: Any? = null): AngularFire
}
@native
interface AngularFire {
    fun `$asArray`(): AngularFireArray
    fun `$asObject`(): AngularFireObject
    fun `$ref`(): Firebase
    fun `$push`(data: Any): ng.IPromise<Firebase>
    fun `$set`(key: String, data: Any): ng.IPromise<Firebase>
    fun `$set`(data: Any): ng.IPromise<Firebase>
    fun `$remove`(key: String? = null): ng.IPromise<Firebase>
    fun `$update`(key: String, data: Object): ng.IPromise<Firebase>
    fun `$update`(data: Any): ng.IPromise<Firebase>
    fun `$transaction`(updateFn: (currentData: Any) -> Any, applyLocally: Boolean? = null): ng.IPromise<FirebaseDataSnapshot>
    fun `$transaction`(key: String, updateFn: (currentData: Any) -> Any, applyLocally: Boolean? = null): ng.IPromise<FirebaseDataSnapshot>
}
@native
interface AngularFireObject : AngularFireSimpleObject {
    override var `$id`: String
    override var `$priority`: Number
    override var `$value`: Any
    fun `$save`(): ng.IPromise<Firebase>
    fun `$loaded`(resolve: ((x: AngularFireObject) -> ng.IHttpPromise<Any>)? = null, reject: ((err: Any) -> Any)? = null): ng.IPromise<AngularFireObject>
    fun `$loaded`(resolve: ((x: AngularFireObject) -> ng.IPromise<Any>)? = null, reject: ((err: Any) -> Any)? = null): ng.IPromise<AngularFireObject>
    fun `$loaded`(resolve: ((x: AngularFireObject) -> Unit)? = null, reject: ((err: Any) -> Any)? = null): ng.IPromise<AngularFireObject>
    fun `$inst`(): AngularFire
    fun `$bindTo`(scope: ng.IScope, varName: String): ng.IPromise<Any>
    fun `$watch`(callback: Function, context: Any? = null): Function
    fun `$destroy`()
}
@native
interface AngularFireObjectService {
    fun `$extendFactory`(ChildClass: Object, methods: Object? = null): Object
}
@native
interface AngularFireArray : Array<AngularFireSimpleObject> {
    fun `$add`(newData: Any): ng.IPromise<Firebase>
    fun `$save`(recordOrIndex: Any): ng.IPromise<Firebase>
    fun `$remove`(recordOrIndex: Any): ng.IPromise<Firebase>
    fun `$getRecord`(key: String): AngularFireSimpleObject
    fun `$keyAt`(recordOrIndex: Any): String
    fun `$indexFor`(key: String): Number
    fun `$loaded`(resolve: ((x: AngularFireArray) -> ng.IHttpPromise<Any>)? = null, reject: ((err: Any) -> Any)? = null): ng.IPromise<AngularFireArray>
    fun `$loaded`(resolve: ((x: AngularFireArray) -> ng.IPromise<Any>)? = null, reject: ((err: Any) -> Any)? = null): ng.IPromise<AngularFireArray>
    fun `$loaded`(resolve: ((x: AngularFireArray) -> Unit)? = null, reject: ((err: Any) -> Any)? = null): ng.IPromise<AngularFireArray>
    fun `$inst`(): AngularFire
    fun `$watch`(cb: (event: String, key: String, prevChild: String) -> Unit, context: Any? = null): Function
    fun `$destroy`()
}
@native
interface AngularFireArrayService {
    fun `$extendFactory`(ChildClass: Object, methods: Object? = null): Object
}
@native
interface AngularFireSimpleObject {
    var `$id`: String
    var `$priority`: Number
    var `$value`: Any
    @nativeGetter
    fun get(key: String): Any
    @nativeSetter
    fun set(key: String, value: Any)
}
@native
interface AngularFireAuthService {
    @nativeInvoke
    fun invoke(firebase: Firebase): AngularFireAuth
}
@native
interface AngularFireAuth {
    fun `$getCurrentUser`(): ng.IPromise<Any>
    fun `$login`(provider: String, options: Object? = null): ng.IPromise<Any>
    fun `$logout`()
    fun `$createUser`(email: String, password: String): ng.IPromise<Any>
    fun `$changePassword`(email: String, oldPassword: String, newPassword: String): ng.IPromise<Any>
    fun `$removeUser`(email: String, password: String): ng.IPromise<Any>
    fun `$sendPasswordResetEmail`(email: String): ng.IPromise<Any>
}
