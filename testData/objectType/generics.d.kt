package generics

external interface `T$0`<B> {
    fun bar(a: Any): B
}
external interface FooBazWithTypes<T> {
    fun <B> returnsB(b: B): `T$0`<B>
}
external interface `T$1`<T> {
    fun bar(a: Any): T
    var baz: Any? get() = noImpl; set(value){}
    var boo: T? get() = noImpl; set(value){}
    var show: (overrideChecks: Boolean) -> Unit
}
external fun <T> withGenericObjectTypeParam(opt: `T$1`<T>): Unit = noImpl
external interface `T$2`<T> {
    var a: T
}
external interface `T$3`<T, S> {
    fun bar(a: Any): T
    fun foo(t: `T$2`<T>)
    fun foo(t: String)
    var baz: Any? get() = noImpl; set(value){}
    var boo: S? get() = noImpl; set(value){}
    var show: (overrideChecks: Boolean) -> Unit
}
external fun <T, S> withDoublyGenericObjectTypeParam(opt: `T$3`<T, S>): Unit = noImpl
external interface `T$4`<S> {
    fun bar(a: Any): S
}
external fun <S> returnsGenericObjectType(): `T$4`<S> = noImpl
