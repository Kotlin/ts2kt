package functionsWithDefaultArguments

external fun withOneAny(a: Any = 0): Any = definedExternally
external fun withOneString(s: String = "foobar"): String = definedExternally
external fun withOneStringAndOptional(s: String = "something", settings: JQueryAjaxSettings? = null): Boolean = definedExternally
