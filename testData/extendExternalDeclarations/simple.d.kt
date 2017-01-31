package simple

external fun JQuery.foo(): Unit = definedExternally
external var JQuery.bar: Any get() = definedExternally; set(value) = definedExternally
@nativeGetter
external fun JQueryStatic.get(prop: String): Number? = definedExternally
@nativeSetter
external fun JQueryStatic.set(prop: String, value: Number): Unit = definedExternally
external var JQueryStatic.someField: String get() = definedExternally; set(value) = definedExternally
external var JQueryStatic.optionalField: Any? get() = definedExternally; set(value) = definedExternally
@nativeInvoke
external fun JQueryStatic.invoke(resourceId: String, hash: Any? = null, callback: Function? = null): Unit = definedExternally
