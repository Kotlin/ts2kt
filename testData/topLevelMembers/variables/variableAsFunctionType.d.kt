package variableAsFunctionType

@native
var withoutArguments: () -> Unit = noImpl
@native
var withOneArgument: (withOutType: Any) -> String = noImpl
@native
var withManyArguments: (num: Number, s: String, a: Any) -> Boolean = noImpl
@native
var withOptionalArguments: (num: Number? = null, s: String? = null) -> Boolean = noImpl
