package functions

@native
fun withoutArguments(): Unit = noImpl
@native
fun withOneAny(a: Any): Any = noImpl
@native
fun withOneString(s: String): String = noImpl
@native
fun withOneNumber(num: Number): Number = noImpl
@native
fun withOneBoolean(bool: Boolean): Boolean = noImpl
@native
fun withManyArguments(s: String, settings: JQueryAjaxSettings): Boolean = noImpl
