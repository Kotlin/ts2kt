package abstract

abstract external class AbstractFoo {
    open fun open(): Unit = definedExternally
    abstract fun close(): Unit
}
