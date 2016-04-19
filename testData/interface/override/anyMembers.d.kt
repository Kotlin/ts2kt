package anyMembers

@native
interface ExpectedOverrides {
    override fun equals(a: Any)
    override fun hashCode(): Number
    override fun toString(): String
}
@native
interface ExpectedOverrides2 {
    override fun equals(a: Any)
}
@native
interface ExpectedNoOverrides {
    fun equals()
    fun equals(a: Number)
    fun equals(a: String)
    fun hashCode(a: String): Number
    fun toString(a: Number = 1)
}
