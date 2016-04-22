package genericsWithConstraint

@native
fun <T : Foo> extendsFooT(a: T): T = noImpl
@native
fun <T : Any> extendsAny(a: T): T = noImpl
@native
fun <A : Bar, B : A> withManyExtends(a: A, b: B): Boolean = noImpl
