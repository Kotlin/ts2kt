package methods

@native
interface Foo {
    @native("new")
    fun invoke(n: Number): Bar
    fun methodWithOutArgs()
    fun methodWithString(s: String): String
    fun methodWithManyArgs(n: Number, settings: Bar): Boolean
}
