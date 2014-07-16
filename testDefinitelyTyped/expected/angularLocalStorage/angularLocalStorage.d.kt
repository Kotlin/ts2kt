// OUT:
package angularLocalStorage

native
public trait `T$0` {
    public var defaultValue: Any?
    public var storeName: String?
}
module
// WRONG module name
public object ng.localStorage  {
    public trait ILocalStorageService {
        public fun set(key: String, value: Any): Any
        public fun get(key: String): Any
        public fun remove(key: String): Boolean
        public fun clearAll(): Unit
        public fun bind(`$scope`: ng.IScope, key: String, opts: `T$0`? = null): Any
        public fun unbind(`$scope`: ng.IScope, key: String, storeName: String? = null): Unit
    }
}
