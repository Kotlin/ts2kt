package backbone-relational

module
public object Backbone {
    public class RelationalModel : Model() {
        public var relations: Any = noImpl
        public var subModelTypes: Any = noImpl
        public var subModelTypeAttribute: Any = noImpl
        public fun initializeRelations(options: Any): Unit = noImpl
        public fun updateRelations(options: Any): Unit = noImpl
        public fun queue(func: Any): Unit = noImpl
        public fun processQueue(): Unit = noImpl
        public fun getRelation(name: String): Relation = noImpl
        public fun getRelations(): Array<Relation> = noImpl
        public fun fetchRelated(key: String, options: Any? = null, update: Boolean? = null): Any = noImpl
        override fun toJSON(): Any = noImpl
        public fun setup(): Unit = noImpl
        public fun build(attributes: Any, options: Any? = null): Unit = noImpl
        public fun findOrCreate(attributes: String, options: Any? = null): Unit = noImpl
        public fun findOrCreate(attributes: Number, options: Any? = null): Unit = noImpl
        public fun findOrCreate(attributes: Any, options: Any? = null): Unit = noImpl
    }
    public class Relation : Model() {
        public var options: Any = noImpl
        public var instance: Any = noImpl
        public var key: Any = noImpl
        public var keyContents: Any = noImpl
        public var relatedModel: Any = noImpl
        public var relatedCollection: Any = noImpl
        public var reverseRelation: Any = noImpl
        public var related: Any = noImpl
        public fun checkPreconditions(): Boolean = noImpl
        public fun setRelated(related: Model): Unit = noImpl
        public fun setRelated(related: Collection<Model>): Unit = noImpl
        public fun getReverseRelations(model: RelationalModel): Relation = noImpl
        override fun destroy(): Unit = noImpl
    }
    public class HasOne : Relation() {
        public var collectionType: Any = noImpl
        public fun findRelated(options: Any): Model = noImpl
        public fun setKeyContents(keyContents: String): Unit = noImpl
        public fun setKeyContents(keyContents: Array<String>): Unit = noImpl
        public fun setKeyContents(keyContents: Number): Unit = noImpl
        public fun setKeyContents(keyContents: Array<Number>): Unit = noImpl
        public fun setKeyContents(keyContents: Collection<Model>): Unit = noImpl
        public fun onChange(model: Model, attr: Any, options: Any): Unit = noImpl
        public fun handleAddition(model: Model, coll: Collection<Model>, options: Any): Unit = noImpl
        public fun handleRemoval(model: Model, coll: Collection<Model>, options: Any): Unit = noImpl
        public fun handleReset(coll: Collection<Model>, options: Any): Unit = noImpl
        public fun tryAddRelated(model: Model, coll: Any, options: Any): Unit = noImpl
        public fun addRelated(model: Model, options: Any): Unit = noImpl
        public fun removeRelated(model: Model, coll: Any, options: Any): Unit = noImpl
    }
    public class HasMany : Relation() {
        public var collectionType: Any = noImpl
        public fun findRelated(options: Any): Model = noImpl
        public fun setKeyContents(keyContents: String): Unit = noImpl
        public fun setKeyContents(keyContents: Number): Unit = noImpl
        public fun setKeyContents(keyContents: Model): Unit = noImpl
        public fun onChange(model: Model, attr: Any, options: Any): Unit = noImpl
        public fun tryAddRelated(model: Model, coll: Any, options: Any): Unit = noImpl
        public fun addRelated(model: Model, options: Any): Unit = noImpl
        public fun removeRelated(model: Model, coll: Any, options: Any): Unit = noImpl
    }
    public class Store : Events() {
        public fun initializeRelation(model: Any, relation: Any, options: Any): Unit = noImpl
        public fun addModelScope(scope: Any): Unit = noImpl
        public fun removeModelScope(scope: Any): Unit = noImpl
        public fun addSubModels(subModelTypes: RelationalModel, superModelType: RelationalModel): Unit = noImpl
        public fun setupSuperModel(modelType: RelationalModel): Unit = noImpl
        public fun addReverseRelation(relation: Any): Unit = noImpl
        public fun addOrphanRelation(relation: Any): Unit = noImpl
        public fun processOrphanRelations(): Unit = noImpl
        public fun retroFitRelation(relation: RelationalModel, create: Boolean): Collection<Model> = noImpl
        public fun getCollection(`type`: RelationalModel, create: Boolean): Collection<Model> = noImpl
        public fun getObjectByName(name: String): Any = noImpl
        public fun resolveIdForItem(`type`: Any, item: Any): Any = noImpl
        public fun find(`type`: Any, item: String): RelationalModel = noImpl
        public fun find(`type`: Any, item: Number): RelationalModel = noImpl
        public fun find(`type`: Any, item: RelationalModel): RelationalModel = noImpl
        public fun find(`type`: Any, item: Any): RelationalModel = noImpl
        public fun register(model: RelationalModel): Unit = noImpl
        public fun checkId(model: RelationalModel, id: Any): Unit = noImpl
        public fun update(model: RelationalModel): Unit = noImpl
        public fun unregister(model: RelationalModel, collection: Collection<Model>, options: Any): Unit = noImpl
        public fun reset(): Unit = noImpl
    }
}
