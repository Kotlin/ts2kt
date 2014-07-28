package anyMembers

native
public trait ExpectedOverrides {
    override fun equals(a: Any)
    override fun hashCode(): Number
    override fun toString(): String
}
native
public trait ExpectedOverrides2 {
    override fun equals(a: Any)
}
native
public trait ExpectedNoOverrides {
    public fun equals()
    public fun equals(a: Number)
    public fun equals(a: String)
    public fun hashCode(a: String): Number
    public fun toString(a: Number = 1)
}
