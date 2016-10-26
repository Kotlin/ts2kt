package simple

@native
fun JQuery.foo(): Unit = noImpl
@native
var JQuery.bar: Any get() = noImpl; set(value){}
@native
@nativeGetter
fun JQueryStatic.get(prop: String): Number? = noImpl
@native
@nativeSetter
fun JQueryStatic.set(prop: String, value: Number): Unit = noImpl
@native
var JQueryStatic.someField: String get() = noImpl; set(value){}
@native
var JQueryStatic.optionalField: Any? get() = noImpl; set(value){}
@native
@nativeInvoke
fun JQueryStatic.invoke(resourceId: String, hash: Any? = null, callback: Function? = null): Unit = noImpl
