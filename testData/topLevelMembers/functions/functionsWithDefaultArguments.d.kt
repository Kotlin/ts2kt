package functionsWithDefaultArguments

@native
fun withOneAny(a: Any = 0): Any = noImpl
@native
fun withOneString(s: String = "foobar"): String = noImpl
@native
fun withOneStringAndOptional(s: String = "something", settings: JQueryAjaxSettings? = null): Boolean = noImpl
