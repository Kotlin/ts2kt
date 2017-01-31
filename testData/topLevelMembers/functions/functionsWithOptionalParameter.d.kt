package functionsWithOptionalParameter

external fun withOneAny(a: Any? = null): Any = noImpl
external fun withOneString(s: String? = null): String = noImpl
external fun withManyArguments(s: String? = null, settings: JQueryAjaxSettings? = null): Boolean = noImpl
