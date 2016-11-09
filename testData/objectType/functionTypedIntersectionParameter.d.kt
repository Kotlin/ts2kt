package functionTypedIntersectionParameter

@native
interface FooPart<T>
@native
interface `T$0`<T> {
    var foo: T
    var bar: Any
}
@native
interface `T$1`<T> {
    var foo: T
    var sup: Any
}
@native
open class FooTypedUnion {
    open fun <T> baz(p: `T$1`<T>): Unit = noImpl
    open fun <T> bar(p: `T$0`<T> /* `T$0`<T> & FooPart<T> */): Unit = noImpl
}
