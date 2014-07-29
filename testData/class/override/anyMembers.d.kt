package anyMembers

native
public open class ExpectedOverrides {
    override fun equals(a: Any): Unit = noImpl
    override fun hashCode(): Number = noImpl
    override fun toString(): String = noImpl
}
native
public open class ExpectedOverrides2 {
    override fun equals(a: Any): Unit = noImpl
}
native
public open class ExpectedNoOverrides {
    public open fun equals(): Unit = noImpl
    public open fun equals(a: Number): Unit = noImpl
    public open fun equals(a: String): Unit = noImpl
    public open fun hashCode(a: String): Number = noImpl
    public open fun toString(a: Number = 1): Unit = noImpl
}
