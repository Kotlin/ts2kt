package abstract

abstract external class AbstractFoo {
    abstract val x: Number
    open fun open(): Unit = definedExternally
    abstract fun close(): Unit
}
