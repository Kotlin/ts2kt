package withGenericParameters

@native
interface Interface<T> {
    var foo: Interface<T> /* this */
    fun bar(): Interface<T> /* this */
}
@native
open class Class<T, U> {
    open var baz: Class<T, U> /* this */ = noImpl
    open fun boo(): Class<T, U> /* this */ = noImpl
}
