package typescript

external interface JsArray<T>

external interface ClassOrInterfaceDeclaration : TS.DeclarationStatement {
    var typeParameters: TS.NodeArray<TS.TypeParameterDeclaration>? // = noImpl
}

typealias Path = String

typealias DocumentRegistryBucketKey = String

external interface SymbolTable {
    @nativeGetter
    fun get(index: String): TS.Symbol?

    @nativeSetter
    fun set(index: String, value: TS.Symbol)
}

external interface CaseOrDefaultClause : TS.CaseClause, TS.DefaultClause

external interface FunctionBody : TS.Block

external interface JsxChild : TS.JsxText, TS.JsxExpression, TS.JsxElement, TS.JsxSelfClosingElement

external interface EntityName : TS.Identifier, TS.QualifiedName

external interface PropertyName : TS.Identifier, TS.LiteralExpression, TS.ComputedPropertyName

external interface DeclarationName : TS.Identifier, TS.LiteralExpression, TS.ComputedPropertyName, TS.BindingPattern


inline val TS.Declaration.declarationName: DeclarationName?
    get() = asDynamic().name

inline val TS.DeclarationStatement.identifierName: TS.Identifier?
    get() = asDynamic().name

inline val TS.TypeParameterDeclaration.identifierName: TS.Identifier
    get() = asDynamic().name

inline val TS.SignatureDeclaration.propertyName: PropertyName?
    get() = asDynamic().name

inline val TS.PropertySignature.propertyName: PropertyName
    get() = asDynamic().name

inline val TS.PropertyDeclaration.propertyName: PropertyName
    get() = asDynamic().name

inline val TS.ObjectLiteralElement.propertyName: PropertyName? // = noImpl
    get() = asDynamic().name

inline val TS.PropertyAssignment.propertyName: PropertyName
    get() = asDynamic().name

inline val TS.ShorthandPropertyAssignment.identifierName: TS.Identifier
    get() = asDynamic().name

inline val TS.VariableLikeDeclaration.declarationName: DeclarationName
    get() = asDynamic().name

inline val TS.PropertyLikeDeclaration.propertyName: PropertyName
    get() = asDynamic().name

inline val TS.FunctionDeclaration.identifierName: TS.Identifier? // = noImpl
    get() = asDynamic().name

inline val TS.MethodSignature.propertyName: PropertyName
    get() = asDynamic().name

inline var TS.MethodDeclaration.propertyName: PropertyName
    get() = asDynamic().name
    set(v) { asDynamic().name = v }

inline val TS.AccessorDeclaration.propertyName: PropertyName
    get() = asDynamic().name

inline val TS.FunctionExpression.identifierName: TS.Identifier? // = noImpl
    get() = asDynamic().name

inline val TS.PropertyAccessExpression.identifierName: TS.Identifier
    get() = asDynamic().name

inline val TS.MissingDeclaration.identifierName: TS.Identifier? // = noImpl
    get() = asDynamic().name

inline var TS.ClassLikeDeclaration.identifierName: TS.Identifier? // = noImpl
    get() = asDynamic().name
    set(v) { asDynamic().name = v }

inline var TS.ClassDeclaration.identifierName: TS.Identifier? // = noImpl
    get() = asDynamic().name
    set(v) { asDynamic().name = v }

inline val TS.ClassElement.propertyName: PropertyName? // = noImpl
    get() = asDynamic().name

inline val TS.TypeElement.propertyName: PropertyName? // = noImpl
    get() = asDynamic().name

inline val TS.InterfaceDeclaration.identifierName: TS.Identifier
    get() = asDynamic().name

inline var TS.TypeAliasDeclaration.identifierName: TS.Identifier
    get() = asDynamic().name
    set(v) { asDynamic().name = v }

inline val TS.EnumMember.declarationName: DeclarationName
    get() = asDynamic().name

inline val TS.EnumDeclaration.identifierName: TS.Identifier
    get() = asDynamic().name

inline val TS.ImportEqualsDeclaration.identifierName: TS.Identifier
    get() = asDynamic().name

inline val TS.NamespaceExportDeclaration.identifierName: TS.Identifier
    get() = asDynamic().name

inline var TS.ImportClause.identifierName: TS.Identifier?
    get() = asDynamic().name
    set(v) { asDynamic().name = v }

inline val TS.NamespaceImport.identifierName: TS.Identifier
    get() = asDynamic().name

inline val TS.ImportSpecifier.identifierName: TS.Identifier
    get() = asDynamic().name

inline val TS.ExportSpecifier.identifierName: TS.Identifier
    get() = asDynamic().name

