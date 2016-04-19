package functionsWithVararg

@native
fun withVarargWithoutTypeAnnotation(vararg a: Any): Unit = noImpl
@native
fun withVarargAny(vararg a: Any): Any = noImpl
@native
fun withVarargNumber(vararg s: Number): String = noImpl
@native
fun withManyArguments(n: Number, vararg s: String): Boolean = noImpl
@native
fun withVarargWithGenericArrayOfNumber(vararg numbers: Number): String = noImpl
@native
fun withVarargWithGenericArrayOfFoo(vararg foos: Foo): String = noImpl
