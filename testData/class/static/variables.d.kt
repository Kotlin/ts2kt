package variables

@native
open class Foo {
    companion object {
        var varAsAny: Any = noImpl
        var varAsNumber: Number = noImpl
        var varAsBoolean: Boolean = noImpl
        var varAsString: String = noImpl
    }
}
