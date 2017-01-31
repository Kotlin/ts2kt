package functionsWithVararg

external fun withVarargWithoutTypeAnnotation(vararg a: Any): Unit = noImpl
external fun withVarargAny(vararg a: Any): Any = noImpl
external fun withVarargNumber(vararg s: Number): String = noImpl
external fun withManyArguments(n: Number, vararg s: String): Boolean = noImpl
external fun withVarargWithGenericArrayOfNumber(vararg numbers: Number): String = noImpl
external fun withVarargWithGenericArrayOfFoo(vararg foos: Foo): String = noImpl
