package optionalVariables

@native
interface Foo {
    var varAsAny: Any? get() = noImpl
    var varAsNumber: Number? get() = noImpl
    var varAsBoolean: Boolean? get() = noImpl
    var varAsString: String? get() = noImpl
}
@module
object foo {
    interface Bar {
        var name: String? get() = noImpl
    }
}
