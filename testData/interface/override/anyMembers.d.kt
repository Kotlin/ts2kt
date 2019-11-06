package anyMembers

external interface ExpectedOverrides {
    override fun equals(a: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String
}
external interface ExpectedOverrides2 {
    override fun equals(a: Any?): Boolean
}
external interface ExpectedNoOverrides {
    fun equals()
    fun equals(a: Number)
    fun equals(a: String)
    fun hashCode(a: String): Number
    fun toString(a: Number = definedExternally /* 1 */)
}
