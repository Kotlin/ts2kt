package backbone-relational

module
public object Backbone {
    public open class RelationalModel : Model() {
        public open var relations: Any = noImpl
        public open var subModelTypes: Any = noImpl
        public open var subModelTypeAttribute: Any = noImpl
        public open fun initializeRelations(options: Any): Unit = noImpl
        public open fun updateRelations(options: Any): Unit = noImpl
        public open fun queue(func: Any): Unit = noImpl
        public open fun processQueue(): Unit = noImpl
        public open fun getRelation(name: String): Relation = noImpl
        public open fun getRelations(): Array<Relation> = noImpl
        public open fun fetchRelated(key: String, options: Any? = null, update: Boolean? = null): Any = noImpl
        override fun toJSON(): Any = noImpl
        public open fun setup(): Unit = noImpl
        public open fun build(attributes: Any, options: Any? = null): Unit = noImpl
        public open fun findOrCreate(attributes: String, options: Any? = null): Unit = noImpl
        public open fun findOrCreate(attributes: Number, options: Any? = null): Unit = noImpl
        public open fun findOrCreate(attributes: Any, options: Any? = null): Unit = noImpl
    }
    public open class Relation : Model() {
        public open var options: Any = noImpl
        public open var instance: Any = noImpl
        public open var key: Any = noImpl
        public open var keyContents: Any = noImpl
        public open var relatedModel: Any = noImpl
        public open var relatedCollection: Any = noImpl
        public open var reverseRelation: Any = noImpl
        public open var related: Any = noImpl
        public open fun checkPreconditions(): Boolean = noImpl
        public open fun setRelated(related: Model): Unit = noImpl
        public open fun setRelated(related: Collection<Model>): Unit = noImpl
        public open fun getReverseRelations(model: RelationalModel): Relation = noImpl
        override fun destroy(): Unit = noImpl
    }
    public open class HasOne : Relation() {
        public open var collectionType: Any = noImpl
        public open fun findRelated(options: Any): Model = noImpl
        public open fun setKeyContents(keyContents: String): Unit = noImpl
        public open fun setKeyContents(keyContents: Array<String>): Unit = noImpl
        public open fun setKeyContents(keyContents: Number): Unit = noImpl
        public open fun setKeyContents(keyContents: Array<Number>): Unit = noImpl
        public open fun setKeyContents(keyContents: Collection<Model>): Unit = noImpl
        public open fun onChange(model: Model, attr: Any, options: Any): Unit = noImpl
        public open fun handleAddition(model: Model, coll: Collection<Model>, options: Any): Unit = noImpl
        public open fun handleRemoval(model: Model, coll: Collection<Model>, options: Any): Unit = noImpl
        public open fun handleReset(coll: Collection<Model>, options: Any): Unit = noImpl
        public open fun tryAddRelated(model: Model, coll: Any, options: Any): Unit = noImpl
        public open fun addRelated(model: Model, options: Any): Unit = noImpl
        public open fun removeRelated(model: Model, coll: Any, options: Any): Unit = noImpl
    }
    public open class HasMany : Relation() {
        public open var collectionType: Any = noImpl
        public open fun findRelated(options: Any): Model = noImpl
        public open fun setKeyContents(keyContents: String): Unit = noImpl
        public open fun setKeyContents(keyContents: Number): Unit = noImpl
        public open fun setKeyContents(keyContents: Model): Unit = noImpl
        public open fun onChange(model: Model, attr: Any, options: Any): Unit = noImpl
        public open fun tryAddRelated(model: Model, coll: Any, options: Any): Unit = noImpl
        public open fun addRelated(model: Model, options: Any): Unit = noImpl
        public open fun removeRelated(model: Model, coll: Any, options: Any): Unit = noImpl
    }
    public open class Store : Events() {
        public open fun initializeRelation(model: Any, relation: Any, options: Any): Unit = noImpl
        public open fun addModelScope(scope: Any): Unit = noImpl
        public open fun removeModelScope(scope: Any): Unit = noImpl
        public open fun addSubModels(subModelTypes: RelationalModel, superModelType: RelationalModel): Unit = noImpl
        public open fun setupSuperModel(modelType: RelationalModel): Unit = noImpl
        public open fun addReverseRelation(relation: Any): Unit = noImpl
        public open fun addOrphanRelation(relation: Any): Unit = noImpl
        public open fun processOrphanRelations(): Unit = noImpl
        public open fun retroFitRelation(relation: RelationalModel, create: Boolean): Collection<Model> = noImpl
        public open fun getCollection(type: RelationalModel, create: Boolean): Collection<Model> = noImpl
        public open fun getObjectByName(name: String): Any = noImpl
        public open fun resolveIdForItem(type: Any, item: Any): Any = noImpl
        public open fun find(type: Any, item: String): RelationalModel = noImpl
        public open fun find(type: Any, item: Number): RelationalModel = noImpl
        public open fun find(type: Any, item: RelationalModel): RelationalModel = noImpl
        public open fun find(type: Any, item: Any): RelationalModel = noImpl
        public open fun register(model: RelationalModel): Unit = noImpl
        public open fun checkId(model: RelationalModel, id: Any): Unit = noImpl
        public open fun update(model: RelationalModel): Unit = noImpl
        public open fun unregister(model: RelationalModel, collection: Collection<Model>, options: Any): Unit = noImpl
        public open fun reset(): Unit = noImpl
    }
}
