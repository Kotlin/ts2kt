// OUT:
// WRONG
package AzureMobileServicesClient

module
// WRONG module
public object Microsoft.WindowsAzure  {
    public trait MobileServiceClient {
        public fun invoke(applicationUrl: String, applicationKey: String): MobileServiceClient
        public var applicationUrl: String
        public var applicationKey: String
        public var currentUser: User
        public fun login(provider: String, token: String, callback: (error: Any, user: User) -> Unit): Unit
        public fun login(provider: String, token: String): asyncPromise
        public fun login(provider: String, callback: (error: Any, user: User) -> Unit): Unit
        public fun login(provider: String): asyncPromise
        public fun logout(): Unit
        public fun getTable(tableName: String): MobileServiceTable
        public fun withFilter(serviceFilter: (request: Any, next: (request: Any, callback: (error: Any, response: Any) -> Unit) -> Unit, callback: (error: Any, response: Any) -> Unit) -> Unit): MobileServiceClient
    }
    public trait User {
        public fun getIdentities(): Any
        public var accessTokens: Any
        public var level: String
        public var userId: String
    }
    public trait asyncPromise {
        public fun then(onSuccess: (result: Any) -> Any, onError: ((error: Any) -> Any)? = null): asyncPromise
        public fun done(onSuccess: ((result: Any) -> Unit)? = null, onError: ((error: Any) -> Unit)? = null): Unit
    }
    public trait MobileServiceTable : IQuery {
        public fun invoke(tableName: String, client: MobileServiceClient): MobileServiceTable
        public fun getTableName(): String
        public fun getMobileServiceClient(): MobileServiceClient
        public fun insert(instance: Any, paramsQS: Object, callback: (error: Any, retInserted: Any) -> Any): Unit
        public fun insert(instance: Any, paramsQS: Object): asyncPromise
        public fun insert(instance: Any): asyncPromise
        public fun update(instance: Any, paramsQS: Object, callback: (error: Any, retUpdated: Any) -> Any): Unit
        public fun update(instance: Any, paramsQS: Object): asyncPromise
        public fun update(instance: Any): asyncPromise
        public fun lookup(id: Number, paramsQS: Object, callback: (error: Any, retValue: Any) -> Any): Unit
        public fun lookup(id: Number, paramsQS: Object): asyncPromise
        public fun lookup(id: Number): asyncPromise
        public fun del(instance: Any, paramsQS: Object, callback: (error: Any? = null) -> Unit): Unit
        public fun del(instance: Any, paramsQS: Object): asyncPromise
        public fun del(instance: Any): asyncPromise
        public fun read(query: IQuery, paramsQS: Object, callback: (error: Any, retValues: Any) -> Any): Unit
        public fun read(query: IQuery, paramsQS: Object): asyncPromise
        public fun read(query: IQuery): asyncPromise
        public fun read(): asyncPromise
    }
    public trait IQuery {
        public fun read(paramsQS: Object? = null): asyncPromise
        public fun orderBy(vararg propName: String): IQuery
        public fun orderByDescending(vararg propName: String): IQuery
        public fun select(vararg propNameSelected: String): IQuery
        public fun select(funcProjectionFromThis: () -> Any): IQuery
        public fun where(mapObjFilterCriteria: Any): IQuery
        public fun where(funcPredicateOnThis: (vararg qParams: Any) -> Boolean, vararg qValues: Any): IQuery
        public fun skip(n: Number): IQuery
        public fun take(n: Number): IQuery
        public fun includeTotalCount(): IQuery
    }
    public trait WindowsAzureStatic {
        public var MobileServiceClient: MobileServiceClient
    }
}
module("WindowsAzure")
native
public var WindowsAzure: Microsoft.WindowsAzure.WindowsAzureStatic = noImpl
