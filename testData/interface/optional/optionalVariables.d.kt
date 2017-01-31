package optionalVariables

external interface Foo {
    var varAsAny: Any? get() = noImpl; set(value){}
    var varAsNumber: Number? get() = noImpl; set(value){}
    var varAsBoolean: Boolean? get() = noImpl; set(value){}
    var varAsString: String? get() = noImpl; set(value){}
}
@module
object foo {
    interface Bar {
        var name: String? get() = noImpl; set(value){}
    }
}
