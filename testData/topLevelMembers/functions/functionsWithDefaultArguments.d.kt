package functionsWithDefaultArguments

external fun withOneAny(a: Any = 0): Any = noImpl
external fun withOneString(s: String = "foobar"): String = noImpl
external fun withOneStringAndOptional(s: String = "something", settings: JQueryAjaxSettings? = null): Boolean = noImpl
