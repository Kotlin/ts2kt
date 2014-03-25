package functionsWithVararg

native
public fun withVarargAny(vararg a: Any): Any = noImpl
native
public fun withVarargNumber(vararg s: Number): String = noImpl
native
public fun withManyArguments(n: Number, vararg s: String): Boolean = noImpl
