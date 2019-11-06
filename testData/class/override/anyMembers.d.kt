package anyMembers

external open class ExpectedOverrides {
    override fun equals(a: Any?): Boolean = definedExternally
    override fun hashCode(): Int = definedExternally
    override fun toString(): String = definedExternally
}
external open class ExpectedOverrides2 {
    override fun equals(a: Any?): Boolean = definedExternally
    override fun toString(): String = definedExternally
}
external open class ExpectedNoOverrides {
    open fun equals(): Unit = definedExternally
    open fun equals(a: Number): Unit = definedExternally
    open fun equals(a: String): Unit = definedExternally
    open fun hashCode(a: String): Number = definedExternally
    open fun toString(a: Number = definedExternally /* 1 */): Unit = definedExternally
}
