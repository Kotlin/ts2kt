package functionTypedIntersectionParameter

@native
interface FooPart<T>
@native
interface `T$0`<T> {
    var foo: T
    var sup: Any
}
@native
interface `T$1`<T> {
    var foo: T
    var bar: Any
}
@native
open class FooTypedUnion {
    open fun <T> baz(p: `T$0`<T>): Unit = noImpl
    open fun <T> bar(p: `T$1`<T> /* `T$1`<T> & FooPart<T> */): Unit = noImpl
}
