package withMerging

@module
object Foo {
    @module
    object Bar {
        @module
        object Baz {
            var variableFooBarBaz: Number = definedExternally
            fun funcFooBarBaz(): Unit = definedExternally
            open class AFooBarBaz
            var anotherVariableFooBarBaz: Number = definedExternally
            fun anotherFuncFooBarBaz(): Unit = definedExternally
            open class AnotherAFooBarBaz
        }
        var variableFooBar: Number = definedExternally
        fun funcFooBar(): Unit = definedExternally
        open class AFooBar
    }
    var variableFoo: Number = definedExternally
    fun funcFoo(): Unit = definedExternally
    open class AFoo
}
