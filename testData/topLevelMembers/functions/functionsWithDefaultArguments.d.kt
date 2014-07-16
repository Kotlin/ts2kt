package functionsWithDefaultArguments

native
public fun withOneAny(a: Any = 0): Any = noImpl
native
public fun withOneString(s: String = "foobar"): String = noImpl
native
public fun withOneStringAndOptional(s: String = "something", settings: JQueryAjaxSettings? = null): Boolean = noImpl
