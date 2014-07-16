package simple

native
public fun JQuery.foo(): Unit = noImpl
native
public var JQuery.bar: Any = noImpl
native
public fun JQueryStatic.get(prop: String): Number = noImpl
native
public fun JQueryStatic.set(prop: String, value: Number): Unit = noImpl
native
public var JQueryStatic.someField: String = noImpl
native
public var JQueryStatic.optionalField: Any? = noImpl
native
public fun JQueryStatic.invoke(resourceId: String, hash: Any? = null, callback: Function? = null): Unit = noImpl
