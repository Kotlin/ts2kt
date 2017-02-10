package typescript

import typescriptServices.ts.*

external interface JsArray<T>

external interface ClassOrInterfaceDeclaration : DeclarationStatement {
    var typeParameters: NodeArray<TypeParameterDeclaration>? // = noImpl
}

typealias Path = String

typealias DocumentRegistryBucketKey = String

external interface SymbolTable {
    @nativeGetter
    fun get(index: String): Symbol?

    @nativeSetter
    fun set(index: String, value: Symbol)
}

external interface CaseOrDefaultClause : CaseClause, DefaultClause

external interface FunctionBody : Block

external interface JsxChild : JsxText, JsxExpression, JsxElement, JsxSelfClosingElement

external interface EntityName : Identifier, QualifiedName

external interface PropertyName : Identifier, LiteralExpression, ComputedPropertyName

external interface DeclarationName : Identifier, LiteralExpression, ComputedPropertyName, BindingPattern


inline val Declaration.declarationName: DeclarationName?
    get() = asDynamic().name

inline val DeclarationStatement.identifierName: Identifier?
    get() = asDynamic().name

inline val TypeParameterDeclaration.identifierName: Identifier
    get() = asDynamic().name

inline val SignatureDeclaration.propertyName: PropertyName?
    get() = asDynamic().name

inline val PropertySignature.propertyName: PropertyName
    get() = asDynamic().name

inline val PropertyDeclaration.propertyName: PropertyName
    get() = asDynamic().name

inline val ObjectLiteralElement.propertyName: PropertyName? // = noImpl
    get() = asDynamic().name

inline val PropertyAssignment.propertyName: PropertyName
    get() = asDynamic().name

inline val ShorthandPropertyAssignment.identifierName: Identifier
    get() = asDynamic().name

inline val VariableLikeDeclaration.declarationName: DeclarationName
    get() = asDynamic().name

inline val PropertyLikeDeclaration.propertyName: PropertyName
    get() = asDynamic().name

inline val FunctionDeclaration.identifierName: Identifier? // = noImpl
    get() = asDynamic().name

inline val MethodSignature.propertyName: PropertyName
    get() = asDynamic().name

inline var MethodDeclaration.propertyName: PropertyName
    get() = asDynamic().name
    set(v) { asDynamic().name = v }

inline val AccessorDeclaration.propertyName: PropertyName
    get() = asDynamic().name

inline val FunctionExpression.identifierName: Identifier? // = noImpl
    get() = asDynamic().name

inline val PropertyAccessExpression.identifierName: Identifier
    get() = asDynamic().name

inline val MissingDeclaration.identifierName: Identifier? // = noImpl
    get() = asDynamic().name

inline var ClassLikeDeclaration.identifierName: Identifier? // = noImpl
    get() = asDynamic().name
    set(v) { asDynamic().name = v }

inline var ClassDeclaration.identifierName: Identifier? // = noImpl
    get() = asDynamic().name
    set(v) { asDynamic().name = v }

inline val ClassElement.propertyName: PropertyName? // = noImpl
    get() = asDynamic().name

inline val TypeElement.propertyName: PropertyName? // = noImpl
    get() = asDynamic().name

inline val InterfaceDeclaration.identifierName: Identifier
    get() = asDynamic().name

inline var TypeAliasDeclaration.identifierName: Identifier
    get() = asDynamic().name
    set(v) { asDynamic().name = v }

inline val EnumMember.declarationName: DeclarationName
    get() = asDynamic().name

inline val EnumDeclaration.identifierName: Identifier
    get() = asDynamic().name

inline val ImportEqualsDeclaration.identifierName: Identifier
    get() = asDynamic().name

inline val NamespaceExportDeclaration.identifierName: Identifier
    get() = asDynamic().name

inline var ImportClause.identifierName: Identifier?
    get() = asDynamic().name
    set(v) { asDynamic().name = v }

inline val NamespaceImport.identifierName: Identifier
    get() = asDynamic().name

inline val ImportSpecifier.identifierName: Identifier
    get() = asDynamic().name

inline val ExportSpecifier.identifierName: Identifier
    get() = asDynamic().name

