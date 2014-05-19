package functionsWithVararg

native
public fun withVarargAny(vararg a: Any): Any = noImpl
native
public fun withVarargNumber(vararg s: Number): String = noImpl
native
public fun withManyArguments(n: Number, vararg s: String): Boolean = noImpl
native
public fun withVarargWithGenericArrayOfNumber(vararg numbers: Number): String = noImpl
native
public fun withVarargWithGenericArrayOfFoo(vararg foos: Foo): String = noImpl
