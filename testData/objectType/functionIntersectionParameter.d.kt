package functionIntersectionParameter

@native
interface FooIntersectionPart
@native
interface `T$0` {
    var foo: String
    var bar: Any
}
@native
open class FooIntersection {
    open fun bar(p: `T$0` /* `T$0` & FooIntersectionPart */): Unit = noImpl
}
