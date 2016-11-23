package typescript

@native
interface JsArray<T>

@native
interface ClassOrInterfaceDeclaration : TS.DeclarationStatement {
    var typeParameters: TS.NodeArray<TS.TypeParameterDeclaration>? // = noImpl
}

typealias Path = String

typealias DocumentRegistryBucketKey = String

@native
interface SymbolTable {
    @nativeGetter
    fun get(index: String): TS.Symbol?

    @nativeSetter
    fun set(index: String, value: TS.Symbol)
}

@native
interface CaseOrDefaultClause : TS.CaseClause, TS.DefaultClause

@native
interface FunctionBody : TS.Block

@native
interface JsxChild : TS.JsxText, TS.JsxExpression, TS.JsxElement, TS.JsxSelfClosingElement

@native
interface EntityName : TS.Identifier, TS.QualifiedName

@native
interface PropertyName : TS.Identifier, TS.LiteralExpression, TS.ComputedPropertyName

@native
interface DeclarationName : TS.Identifier, TS.LiteralExpression, TS.ComputedPropertyName, TS.BindingPattern


@native("name")
val TS.Declaration.declarationName: DeclarationName?

@native("name")
val TS.DeclarationStatement.identifierName: TS.Identifier?

@native("name")
val TS.TypeParameterDeclaration.identifierName: TS.Identifier

@native("name")
val TS.SignatureDeclaration.propertyName: PropertyName?

@native("name")
val TS.PropertySignature.propertyName: PropertyName

@native("name")
val TS.PropertyDeclaration.propertyName: PropertyName

@native("name")
val TS.ObjectLiteralElement.propertyName: PropertyName? // = noImpl

@native("name")
val TS.PropertyAssignment.propertyName: PropertyName

@native("name")
val TS.ShorthandPropertyAssignment.identifierName: TS.Identifier

@native("name")
val TS.VariableLikeDeclaration.declarationName: DeclarationName

@native("name")
val TS.PropertyLikeDeclaration.propertyName: PropertyName

@native("name")
val TS.FunctionDeclaration.identifierName: TS.Identifier? // = noImpl

@native("name")
val TS.MethodSignature.propertyName: PropertyName

@native("name")
var TS.MethodDeclaration.propertyName: PropertyName

@native("name")
val TS.AccessorDeclaration.propertyName: PropertyName

@native("name")
val TS.FunctionExpression.identifierName: TS.Identifier? // = noImpl

@native("name")
val TS.PropertyAccessExpression.identifierName: TS.Identifier

@native
val TS.MissingDeclaration.identifierName: TS.Identifier? // = noImpl

@native("name")
var TS.ClassLikeDeclaration.identifierName: TS.Identifier? // = noImpl

@native("name")
var TS.ClassDeclaration.identifierName: TS.Identifier? // = noImpl

@native("name")
val TS.ClassElement.propertyName: PropertyName? // = noImpl

@native("name")
val TS.TypeElement.propertyName: PropertyName? // = noImpl

@native("name")
val TS.InterfaceDeclaration.identifierName: TS.Identifier

@native("name")
var TS.TypeAliasDeclaration.identifierName: TS.Identifier

@native("name")
val TS.EnumMember.declarationName: DeclarationName

@native("name")
val TS.EnumDeclaration.identifierName: TS.Identifier

@native("name")
val TS.ImportEqualsDeclaration.identifierName: TS.Identifier

@native("name")
val TS.NamespaceExportDeclaration.identifierName: TS.Identifier

@native("name")
var TS.ImportClause.identifierName: TS.Identifier? // = noImpl

@native("name")
val TS.NamespaceImport.identifierName: TS.Identifier

@native("name")
val TS.ImportSpecifier.identifierName: TS.Identifier

@native("name")
val TS.ExportSpecifier.identifierName: TS.Identifier

