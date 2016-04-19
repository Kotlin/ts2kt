package optionalVariables

@native
interface Foo {
    var varAsAny: Any? = noImpl
    var varAsNumber: Number? = noImpl
    var varAsBoolean: Boolean? = noImpl
    var varAsString: String? = noImpl
}
