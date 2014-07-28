package anyMembers

native
public class ExpectedOverrides {
    override fun equals(a: Any): Unit = noImpl
    override fun hashCode(): Number = noImpl
    override fun toString(): String = noImpl
}
native
public class ExpectedOverrides2 {
    override fun equals(a: Any): Unit = noImpl
}
native
public class ExpectedNoOverrides {
    public fun equals(): Unit = noImpl
    public fun equals(a: Number): Unit = noImpl
    public fun equals(a: String): Unit = noImpl
    public fun hashCode(a: String): Number = noImpl
    public fun toString(a: Number = 1): Unit = noImpl
}
