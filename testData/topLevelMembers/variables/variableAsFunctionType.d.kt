package variableAsFunctionType

external var withoutArguments: () -> Unit = noImpl
external var withOneArgument: (withOutType: Any) -> String = noImpl
external var withManyArguments: (num: Number, s: String, a: Any) -> Boolean = noImpl
external var withOptionalArguments: (num: Number? = null, s: String? = null) -> Boolean = noImpl
