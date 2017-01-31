package simple

@module
object Foo {
    @module
    object Bar {
        @module
        object Baz {
            var variable: Number = definedExternally
            fun func(): Unit = definedExternally
            open class A
        }
    }
}
