package genericsWithConstraint

@native
fun extendsFooT<T : Foo>(a: T): T = noImpl
@native
fun extendsAny<T : Any>(a: T): T = noImpl
@native
fun withManyExtends<A : Bar, B : A>(a: A, b: B): Boolean = noImpl
