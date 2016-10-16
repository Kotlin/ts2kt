package variables

@native
interface Foo {
    var varWithoutTypeAnnotation: Any
    var varAsAny: Any
    var varAsNumber: Number
    var varAsBoolean: Boolean
    var varAsString: String
}
@module
object foo {
    interface Bar {
        var name: String
    }
}
