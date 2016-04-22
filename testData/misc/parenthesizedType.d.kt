package parenthesizedType

@native
interface Interface
@native
fun foo(p: Interface, p2: Number): String = noImpl
@native
var a: Any = noImpl
@native
var b: Interface = noImpl
