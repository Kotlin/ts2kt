package functionsWithOptionalParameter

@native
fun withOneAny(a: Any? = null): Any = noImpl
@native
fun withOneString(s: String? = null): String = noImpl
@native
fun withManyArguments(s: String? = null, settings: JQueryAjaxSettings? = null): Boolean = noImpl
