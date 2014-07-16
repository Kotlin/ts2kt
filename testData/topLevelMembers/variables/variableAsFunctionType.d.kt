package variableAsFunctionType

native
public var withoutArguments: () -> Unit = noImpl
native
public var withOneArgument: (withOutType: Any) -> String = noImpl
native
public var withManyArguments: (num: Number, s: String, a: Any) -> Boolean = noImpl
native
public var withOptionalArguments: (num: Number? = null, s: String? = null) -> Boolean = noImpl
