package refToOuterVarBeforeModule

@native
interface SinonStatic {
    var createStubInstance: (constructor: Any) -> SinonStub
    var format: (obj: Any) -> String
    var log: (message: String) -> Unit
    fun restore(`object`: Any)
}
@native
@module("sinon")
var sinon: SinonStatic = noImpl
