package anyMembers

@native
open class ExpectedOverrides {
    override fun equals(a: Any): Unit = noImpl
    override fun hashCode(): Number = noImpl
    override fun toString(): String = noImpl
}
@native
open class ExpectedOverrides2 {
    override fun equals(a: Any): Unit = noImpl
}
@native
open class ExpectedNoOverrides {
    open fun equals(): Unit = noImpl
    open fun equals(a: Number): Unit = noImpl
    open fun equals(a: String): Unit = noImpl
    open fun hashCode(a: String): Number = noImpl
    open fun toString(a: Number = 1): Unit = noImpl
}
