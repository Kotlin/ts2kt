// OUT:
// WRONG
package breeze

module
// WRONG
public object breeze.core  {
    public trait ErrorCallback {
        public fun invoke(error: Error): Unit
    }
    public trait IEnum {
        public fun contains(`object`: Any): Boolean
        public fun fromName(name: String): EnumSymbol
        public fun getNames(): Array<String>
        public fun getSymbols(): Array<EnumSymbol>
    }
    public fun objectForEach(obj: Object, kvfn: (key: String, value: Any) -> Unit): Unit = noImpl
    public fun extend(target: Object, source: Object): Object = noImpl
    public fun propEq(propertyName: String, value: Any): (obj: Object) -> Boolean = noImpl
    public fun pluck(propertyName: String): (obj: Object) -> Any = noImpl
    public fun arrayEquals(a1: Array<Any>, a2: Array<Any>, equalsFn: (e1: Any, e2: Any) -> Boolean): Boolean = noImpl
    public fun arrayFirst(a1: Array<Any>, predicate: (e: Any) -> Boolean): Any = noImpl
    public fun arrayIndexOf(a1: Array<Any>, predicate: (e: Any) -> Boolean): Number = noImpl
    public fun arrayRemoveItem(array: Array<Any>, item: Any, shouldRemoveMultiple: Boolean): Any = noImpl
    public fun arrayRemoveItem(array: Array<Any>, predicate: (e: Any) -> Boolean, shouldRemoveMultiple: Boolean): Any = noImpl
    public fun arrayZip(a1: Array<Any>, a2: Array<Any>, callback: (e1: Any, e2: Any) -> Any): Array<Any> = noImpl
    public fun requireLib(libnames: String, errMessage: String): Object = noImpl
    public fun using(obj: Object, property: String, tempValue: Any, fn: () -> Any): Any = noImpl
    public fun memoize(fn: Function): Any = noImpl
    public fun getUuid(): String = noImpl
    public fun durationToSeconds(duration: String): Number = noImpl
    public fun isDate(o: Any): Boolean = noImpl
    public fun isGuid(o: Any): Boolean = noImpl
    public fun isDuration(o: Any): Boolean = noImpl
    public fun isFunction(o: Any): Boolean = noImpl
    public fun isEmpty(o: Any): Boolean = noImpl
    public fun isNumeric(o: Any): Boolean = noImpl
    public fun stringStartsWith(str: String, prefix: String): Boolean = noImpl
    public fun stringEndsWith(str: String, suffix: String): Boolean = noImpl
    public fun formatString(format: String, vararg args: Any): String = noImpl
}
native
public trait `T$0` {
    public var interfaceName: String
    public var isDefault: Boolean
}
native
public trait `T$1` {
    public var resourceName: String
}
native
public trait `T$2` {
    public var entityType: EntityType?
    public var nodeId: Any?
    public var nodeRefId: Any?
    public var ignore: Boolean?
}
native
public trait `T$3` {
    public var name: String
    public var extractResults: ((data: Any) -> Any)?
    public var visitNode: (node: Any, queryContext: QueryContext, nodeContext: NodeContext) -> `T$2`
}
native
public trait `T$4` {
    public var mergeStrategy: StrategySymbol?
}
native
public trait `T$5` {
    public var query: EntityQuery
    public var XHR: XMLHttpRequest
    public var entityManager: EntityManager
}
native
public trait `T$6` {
    public var XHR: XMLHttpRequest
}
native
public trait `T$7` {
    public var name: String?
    public var isCaseSensitive: Boolean?
    public var usesSql92CompliantStringComparison: Boolean?
}
native
public trait `T$8` {
    public var allowConcurrentSaves: Boolean?
}
native
public trait `T$9` {
    public var maxLength: Number
}
native
public trait `T$10` {
    public var maxLength: Number
    public var minLength: Number
}
module
public object breeze {
    public trait Entity {
        public var entityAspect: EntityAspect
        public var entityType: EntityType
    }
    public trait ComplexObject {
        public var complexAspect: ComplexAspect
        public var complexType: ComplexType
    }
    public trait IProperty {
        public var name: String
        public var parentType: IStructuralType
        public var validators: Array<Validator>
        public var isDataProperty: Boolean
        public var isNavigationProperty: Boolean
    }
    public trait IStructuralType {
        public var complexProperties: Array<DataProperty>
        public var dataProperties: Array<DataProperty>
        public var name: String
        public var namespace: String
        public var shortName: String
        public var unmappedProperties: Array<DataProperty>
        public var validators: Array<Validator>
    }
    public trait DataPropertyOptions {
        public var complexTypeName: String?
        public var concurrencyMode: String?
        public var dataType: DataTypeSymbol?
        public var defaultValue: Any?
        public var fixedLength: Boolean?
        public var isNullable: Boolean?
        public var isPartOfKey: Boolean?
        public var isUnmapped: Boolean?
        public var maxLength: Number?
        public var name: String?
        public var nameOnServer: String?
        public var validators: Array<Validator>?
    }
    public trait DataServiceOptions {
        public var serviceName: String?
        public var adapterName: String?
        public var hasServerMetadata: Boolean?
        public var jsonResultsAdapter: JsonResultsAdapter?
        public var useJsonp: Boolean?
    }
    public trait QueryContext {
        public var url: String
        public var query: Any
        public var entityManager: EntityManager
        public var dataService: DataService
        public var queryOptions: QueryOptions
    }
    public trait NodeContext {
        public var nodeType: String
    }
    public trait EntityByKeyResult {
        public var entity: Entity
        public var entityKey: EntityKey
        public var fromCache: Boolean
    }
    public trait EntityManagerOptions {
        public var serviceName: String?
        public var dataService: DataService?
        public var metadataStore: MetadataStore?
        public var queryOptions: QueryOptions?
        public var saveOptions: SaveOptions?
        public var validationOptions: ValidationOptions?
        public var keyGeneratorCtor: Function?
    }
    public trait EntityManagerProperties {
        public var serviceName: String?
        public var dataService: DataService?
        public var queryOptions: QueryOptions?
        public var saveOptions: SaveOptions?
        public var validationOptions: ValidationOptions?
        public var keyGeneratorCtor: Function?
    }
    public trait ExecuteQuerySuccessCallback {
        public fun invoke(data: QueryResult): Unit
    }
    public trait ExecuteQueryErrorCallback {
        public fun invoke(error: `T$5`): Unit
    }
    public trait SaveChangesSuccessCallback {
        public fun invoke(saveResult: SaveResult): Unit
    }
    public trait SaveChangesErrorCallback {
        public fun invoke(error: `T$6`): Unit
    }
    public trait OrderByClause
    public trait EntityTypeOptions {
        public var shortName: String?
        public var namespace: String?
        public var autoGeneratedKeyType: AutoGeneratedKeyType?
        public var defaultResourceName: String?
        public var dataProperties: Array<DataProperty>?
        public var navigationProperties: Array<NavigationProperty>?
    }
    public trait EntityTypeProperties {
        public var autoGeneratedKeyType: AutoGeneratedKeyType?
        public var defaultResourceName: String?
    }
    public trait MetadataStoreOptions {
        public var namingConvention: NamingConvention?
        public var localQueryComparisonOptions: LocalQueryComparisonOptions?
    }
    public trait NamingConventionOptions {
        public var serverPropertyNameToClient: ((name: String) -> String)?
        public var clientPropertyNameToServer: ((name: String) -> String)?
    }
    public trait NavigationPropertyOptions {
        public var name: String?
        public var nameOnServer: String?
        public var entityTypeName: String
        public var isScalar: Boolean?
        public var associationName: String?
        public var foreignKeyNames: Array<String>?
        public var foreignKeyNamesOnServer: Array<String>?
        public var validators: Array<Validator>?
    }
    public trait PredicateMethod {
        public fun invoke(predicates: Array<Predicate>): Predicate
        public fun invoke(vararg predicates: Predicate): Predicate
        public fun invoke(property: String, operator: String, value: Any, valueIsLiteral: Boolean? = null): Predicate
        public fun invoke(property: String, operator: FilterQueryOpSymbol, value: Any, valueIsLiteral: Boolean? = null): Predicate
    }
    public trait QueryOptionsConfiguration {
        public var fetchStrategy: StrategySymbol?
        public var mergeStrategy: StrategySymbol?
    }
    public trait QueryResult {
        public var results: Array<Entity>
        public var query: EntityQuery
        public var XHR: XMLHttpRequest
        public var entityManager: EntityManager?
        public var inlineCount: Number?
    }
    public trait SaveOptionsConfiguration {
        public var allowConcurrentSaves: Boolean?
        public var resourceName: String?
        public var dataService: DataService?
        public var tag: String?
    }
    public trait SaveResult {
        public var entities: Array<Entity>
        public var keyMappings: Any
        public var XHR: XMLHttpRequest
    }
    public trait ValidationOptionsConfiguration {
        public var validateOnAttach: Boolean?
        public var validateOnSave: Boolean?
        public var validateOnQuery: Boolean?
        public var validateOnPropertyChange: Boolean?
    }
    public trait ValidatorFunction {
        public fun invoke(value: Any, context: ValidatorFunctionContext): Unit
    }
    public trait ValidatorFunctionContext {
        public var value: Any
        public var validatorName: String
        public var displayName: String
        public var messageTemplate: String
        public var message: String?
    }
}
module
public object breeze.config  {
    public fun getAdapter(interfaceName: String, adapterName: String): Object = noImpl
    public fun getAdapterInstance(interfaceName: String, adapterName: String? = null): Object = noImpl
    public fun initializeAdapterInstance(interfaceName: String, adapterName: String, isDefault: Boolean): Unit = noImpl
    public fun initializeAdapterInstances(config: Object): Unit = noImpl
    public fun registerAdapter(interfaceName: String, adapterCtor: Function): Unit = noImpl
    public fun registerFunction(fn: Function, fnName: String): Unit = noImpl
    public fun registerType(ctor: Function, typeName: String): Unit = noImpl
}
