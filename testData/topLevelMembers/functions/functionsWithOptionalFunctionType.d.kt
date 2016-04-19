package functionsWithOptionalFunctionType

@native
fun foo(f: ((a: Any) -> Boolean)? = null): Boolean = noImpl
