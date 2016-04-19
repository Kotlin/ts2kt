package simple

@module
object Foo {
    @module
    object Bar {
        @module
        object Baz {
            var variable: Number = noImpl
            fun func(): Unit = noImpl
            open class A
        }
    }
}
