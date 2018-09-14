package typescriptServices.ts

external interface JsArray<T> {
    @nativeGetter
    fun get(index: Int): T?

    @nativeSetter
    fun set(index: Int, value: T)
}

external interface ReadonlyArray<T> {
    @nativeGetter
    fun get(index: Int): T?
}

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

typealias Transformer<T/* : Node*/> = (node: T) -> T
typealias TransformerFactory<T/* : Node*/> = (context: TransformationContext) -> Transformer<T>

external interface BaseType : Type

external interface CommentKind

external interface CaseOrDefaultClause : Node

interface UnionOrIntersectionTypeNode : TypeNode {
    val types: NodeArray<TypeNode>
}

external interface FunctionBody : Block

external interface EntityName : Node // Identifier | QualifiedName;

external interface PropertyName : Node {
    val text: String
}

external interface DeclarationName : Node

external interface DeclarationWithTypeParameters : Node

external interface BindingPattern : Node, BindingName

external interface BindingName : Node

external interface ArrayBindingElement : Node

external interface ObjectLiteralElementLike : Node

external interface AccessorDeclaration : ObjectLiteralElementLike

external interface TemplateLiteral

external interface DestructuringAssignment

external interface PrefixUnaryOperator // = SyntaxKind.PlusPlusToken | SyntaxKind.MinusMinusToken | SyntaxKind.PlusToken | SyntaxKind.MinusToken | SyntaxKind.TildeToken | SyntaxKind.ExclamationToken;
external interface PostfixUnaryOperator // = SyntaxKind.PlusPlusToken | SyntaxKind.MinusMinusToken;

typealias BinaryOperator = SyntaxKind //= AssignmentOperatorOrHigher | SyntaxKind.CommaToken;
typealias BinaryOperatorToken = Token<BinaryOperator>

external interface ForInitializer //= VariableDeclarationList | Expression;

external interface ModuleName // = Identifier | StringLiteral;
external interface ModuleBody // = NamespaceBody | JSDocNamespaceBody;

external interface ModuleReference //= EntityName | ExternalModuleReference;

external interface ConciseBody //= FunctionBody | Expression;

external interface NamedImportBindings //= NamespaceImport | NamedImports;


typealias VisitResult<T> = Any //<T extends Node> = T | T[];
typealias Visitor = (node: Node) -> VisitResult<Node>

typealias DotDotDotToken = Token<SyntaxKind.DotDotDotToken>
typealias QuestionToken = Token<SyntaxKind.QuestionToken>
typealias ColonToken = Token<SyntaxKind.ColonToken>
typealias EqualsToken = Token<SyntaxKind.EqualsToken>
typealias AsteriskToken = Token<SyntaxKind.AsteriskToken>
typealias EqualsGreaterThanToken = Token<SyntaxKind.EqualsGreaterThanToken>
typealias EndOfFileToken = Token<SyntaxKind.EndOfFileToken>
typealias AtToken = Token<SyntaxKind.AtToken>
typealias ReadonlyToken = Token<SyntaxKind.ReadonlyKeyword>
typealias AwaitKeywordToken = Token<SyntaxKind.AwaitKeyword>

external interface Modifier : Token<SyntaxKind> //: Token<SyntaxKind.AbstractKeyword>, Token<SyntaxKind.AsyncKeyword>, Token<SyntaxKind.ConstKeyword>, Token<SyntaxKind.DeclareKeyword>, Token<SyntaxKind.DefaultKeyword>, Token<SyntaxKind.ExportKeyword>, Token<SyntaxKind.PublicKeyword>, Token<SyntaxKind.PrivateKeyword>, Token<SyntaxKind.ProtectedKeyword>, Token<SyntaxKind.ReadonlyKeyword>, Token<SyntaxKind.StaticKeyword>

typealias ModifiersArray = NodeArray<Modifier>

external interface FunctionOrConstructorTypeNode //= FunctionTypeNode | ConstructorTypeNode;

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
    set(v) {
        asDynamic().name = v
    }

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
    set(v) {
        asDynamic().name = v
    }

inline var ClassDeclaration.identifierName: Identifier? // = noImpl
    get() = asDynamic().name
    set(v) {
        asDynamic().name = v
    }

inline val ClassElement.propertyName: PropertyName? // = noImpl
    get() = asDynamic().name

inline val TypeElement.propertyName: PropertyName? // = noImpl
    get() = asDynamic().name

inline val InterfaceDeclaration.identifierName: Identifier
    get() = asDynamic().name

inline var TypeAliasDeclaration.identifierName: Identifier
    get() = asDynamic().name
    set(v) {
        asDynamic().name = v
    }

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
    set(v) {
        asDynamic().name = v
    }

inline val NamespaceImport.identifierName: Identifier
    get() = asDynamic().name

inline val ImportSpecifier.identifierName: Identifier
    get() = asDynamic().name

inline val ExportSpecifier.identifierName: Identifier
    get() = asDynamic().name

