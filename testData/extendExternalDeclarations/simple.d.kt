package simple

external fun JQuery.foo(): Unit = noImpl
external var JQuery.bar: Any get() = noImpl; set(value){}
@nativeGetter
external fun JQueryStatic.get(prop: String): Number? = noImpl
@nativeSetter
external fun JQueryStatic.set(prop: String, value: Number): Unit = noImpl
external var JQueryStatic.someField: String get() = noImpl; set(value){}
external var JQueryStatic.optionalField: Any? get() = noImpl; set(value){}
@nativeInvoke
external fun JQueryStatic.invoke(resourceId: String, hash: Any? = null, callback: Function? = null): Unit = noImpl
