package variables

external open class Foo {
    open var varWithoutTypeAnnotation: Any = noImpl
    open var varAsAny: Any = noImpl
    open var varAsNumber: Number = noImpl
    open var varAsBoolean: Boolean = noImpl
    open var varAsString: String = noImpl
}
