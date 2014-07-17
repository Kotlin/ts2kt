package refToOuterVarBeforeModule

native
public trait SinonStatic {
    public var createStubInstance: (constructor: Any) -> SinonStub
    public var format: (obj: Any) -> String
    public var log: (message: String) -> Unit
    public fun restore(`object`: Any)
}
native
module("sinon")
public var sinon: SinonStatic = noImpl
