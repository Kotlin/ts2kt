package withMerging

@module
object Foo {
    @module
    object Bar {
        @module
        object Baz {
            var variableFooBarBaz: Number = noImpl
            fun funcFooBarBaz(): Unit = noImpl
            open class AFooBarBaz
            var anotherVariableFooBarBaz: Number = noImpl
            fun anotherFuncFooBarBaz(): Unit = noImpl
            open class AnotherAFooBarBaz
        }
        var variableFooBar: Number = noImpl
        fun funcFooBar(): Unit = noImpl
        open class AFooBar
    }
    var variableFoo: Number = noImpl
    fun funcFoo(): Unit = noImpl
    open class AFoo
}
