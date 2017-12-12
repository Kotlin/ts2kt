package asTypeAlias

external interface I {
    fun foo(): String
}
external interface J {
    fun foo(): String
}
external interface K {
    fun bar(): Number
}
external fun f(a: I, b: J, c: I): K = definedExternally
external var x: I = definedExternally
external var y: I = definedExternally
external var z: J = definedExternally
