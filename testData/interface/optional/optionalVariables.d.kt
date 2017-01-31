package optionalVariables

external interface Foo {
    var varAsAny: Any? get() = definedExternally; set(value) = definedExternally
    var varAsNumber: Number? get() = definedExternally; set(value) = definedExternally
    var varAsBoolean: Boolean? get() = definedExternally; set(value) = definedExternally
    var varAsString: String? get() = definedExternally; set(value) = definedExternally
}
@module
object foo {
    interface Bar {
        var name: String? get() = definedExternally; set(value) = definedExternally
    }
}
