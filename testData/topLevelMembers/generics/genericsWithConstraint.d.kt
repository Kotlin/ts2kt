package genericsWithConstraint

external fun <T : Foo> extendsFooT(a: T): T = noImpl
external fun <T : Any> extendsAny(a: T): T = noImpl
external fun <A : Bar, B : A> withManyExtends(a: A, b: B): Boolean = noImpl
