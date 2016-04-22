package backbone-relational

@module
object Backbone {
    open class RelationalModel : Model() {
        open var relations: Any = noImpl
        open var subModelTypes: Any = noImpl
        open var subModelTypeAttribute: Any = noImpl
        open fun initializeRelations(options: Any): Unit = noImpl
        open fun updateRelations(options: Any): Unit = noImpl
        open fun queue(func: Any): Unit = noImpl
        open fun processQueue(): Unit = noImpl
        open fun getRelation(name: String): Relation = noImpl
        open fun getRelations(): Array<Relation> = noImpl
        open fun fetchRelated(key: String, options: Any? = null, update: Boolean? = null): Any = noImpl
        // TODO: investigate
        open fun toJSON(): Any = noImpl
        companion object {
            fun setup(): Unit = noImpl
            fun build(attributes: Any, options: Any? = null): Unit = noImpl
            fun findOrCreate(attributes: String, options: Any? = null): Unit = noImpl
            fun findOrCreate(attributes: Number, options: Any? = null): Unit = noImpl
            fun findOrCreate(attributes: Any, options: Any? = null): Unit = noImpl
        }
    }
    open class Relation : Model() {
        open var options: Any = noImpl
        open var instance: Any = noImpl
        open var key: Any = noImpl
        open var keyContents: Any = noImpl
        open var relatedModel: Any = noImpl
        open var relatedCollection: Any = noImpl
        open var reverseRelation: Any = noImpl
        open var related: Any = noImpl
        open fun checkPreconditions(): Boolean = noImpl
        open fun setRelated(related: Model): Unit = noImpl
        open fun setRelated(related: Collection<Model>): Unit = noImpl
        open fun getReverseRelations(model: RelationalModel): Relation = noImpl
        // TODO: investigate
        open fun destroy(): Unit = noImpl
    }
    open class HasOne : Relation() {
        open var collectionType: Any = noImpl
        open fun findRelated(options: Any): Model = noImpl
        open fun setKeyContents(keyContents: String): Unit = noImpl
        open fun setKeyContents(keyContents: Array<String>): Unit = noImpl
        open fun setKeyContents(keyContents: Number): Unit = noImpl
        open fun setKeyContents(keyContents: Array<Number>): Unit = noImpl
        open fun setKeyContents(keyContents: Collection<Model>): Unit = noImpl
        open fun onChange(model: Model, attr: Any, options: Any): Unit = noImpl
        open fun handleAddition(model: Model, coll: Collection<Model>, options: Any): Unit = noImpl
        open fun handleRemoval(model: Model, coll: Collection<Model>, options: Any): Unit = noImpl
        open fun handleReset(coll: Collection<Model>, options: Any): Unit = noImpl
        open fun tryAddRelated(model: Model, coll: Any, options: Any): Unit = noImpl
        open fun addRelated(model: Model, options: Any): Unit = noImpl
        open fun removeRelated(model: Model, coll: Any, options: Any): Unit = noImpl
    }
    open class HasMany : Relation() {
        open var collectionType: Any = noImpl
        open fun findRelated(options: Any): Model = noImpl
        open fun setKeyContents(keyContents: String): Unit = noImpl
        open fun setKeyContents(keyContents: Number): Unit = noImpl
        open fun setKeyContents(keyContents: Model): Unit = noImpl
        open fun onChange(model: Model, attr: Any, options: Any): Unit = noImpl
        open fun tryAddRelated(model: Model, coll: Any, options: Any): Unit = noImpl
        open fun addRelated(model: Model, options: Any): Unit = noImpl
        open fun removeRelated(model: Model, coll: Any, options: Any): Unit = noImpl
    }
    open class Store : Events() {
        open fun initializeRelation(model: Any, relation: Any, options: Any): Unit = noImpl
        open fun addModelScope(scope: Any): Unit = noImpl
        open fun removeModelScope(scope: Any): Unit = noImpl
        open fun addSubModels(subModelTypes: RelationalModel, superModelType: RelationalModel): Unit = noImpl
        open fun setupSuperModel(modelType: RelationalModel): Unit = noImpl
        open fun addReverseRelation(relation: Any): Unit = noImpl
        open fun addOrphanRelation(relation: Any): Unit = noImpl
        open fun processOrphanRelations(): Unit = noImpl
        open fun retroFitRelation(relation: RelationalModel, create: Boolean): Collection<Model> = noImpl
        open fun getCollection(type: RelationalModel, create: Boolean): Collection<Model> = noImpl
        open fun getObjectByName(name: String): Any = noImpl
        open fun resolveIdForItem(type: Any, item: Any): Any = noImpl
        open fun register(model: RelationalModel): Unit = noImpl
        open fun checkId(model: RelationalModel, id: Any): Unit = noImpl
        open fun update(model: RelationalModel): Unit = noImpl
        open fun unregister(model: RelationalModel, collection: Collection<Model>, options: Any): Unit = noImpl
        open fun reset(): Unit = noImpl
        companion object {
            fun find(type: Any, item: String): RelationalModel = noImpl
            fun find(type: Any, item: Number): RelationalModel = noImpl
            fun find(type: Any, item: RelationalModel): RelationalModel = noImpl
            fun find(type: Any, item: Any): RelationalModel = noImpl
        }
    }
}
