package genericsWithConstraint

native
public fun extendsFooT<T : Foo>(a: T): T = noImpl
native
public fun extendsAny<T : Any>(a: T): T = noImpl
native
public fun withManyExtends<A : Bar, B : A>(a: A, b: B): Boolean = noImpl
