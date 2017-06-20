package simple

external fun JQuery.foo(): Unit = definedExternally
external var JQuery.bar: Any get() = definedExternally; set(value) = definedExternally
@nativeGetter
external operator fun JQueryStatic.get(prop: String): Number? = definedExternally
@nativeSetter
external operator fun JQueryStatic.set(prop: String, value: Number): Unit = definedExternally
external var JQueryStatic.someField: String get() = definedExternally; set(value) = definedExternally
external var JQueryStatic.optionalField: Any? get() = definedExternally; set(value) = definedExternally
@nativeInvoke
external operator fun JQueryStatic.invoke(resourceId: String, hash: Any? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): Unit = definedExternally
