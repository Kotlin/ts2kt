package typescript

@native
interface JsArray<T>

@native
interface JsMap<T> {
    @nativeGetter
    fun get(index: String): T
    @nativeSetter
    fun set(index: String, value: T)
}

@native
interface ClassOrInterfaceDeclaration : TS.DeclarationStatement {
    override val identifierName: TS.Identifier?
    var typeParameters: TS.NodeArray<TS.TypeParameterDeclaration>? // = noImpl
}
