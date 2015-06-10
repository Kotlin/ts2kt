package typescript

native("ts")
public object TS {
    public interface JsMap<T> {
        nativeGetter
        public fun get(index: String): T
        nativeSetter
        public fun set(index: String, value: T)
    }
    public interface TextRange {
        public var pos: Number
        public var end: Number
    }
    public enum class SyntaxKind {
        Unknown,
        EndOfFileToken,
        SingleLineCommentTrivia,
        MultiLineCommentTrivia,
        NewLineTrivia,
        WhitespaceTrivia,
        NumericLiteral,
        StringLiteral,
        RegularExpressionLiteral,
        NoSubstitutionTemplateLiteral,
        TemplateHead,
        TemplateMiddle,
        TemplateTail,
        OpenBraceToken,
        CloseBraceToken,
        OpenParenToken,
        CloseParenToken,
        OpenBracketToken,
        CloseBracketToken,
        DotToken,
        DotDotDotToken,
        SemicolonToken,
        CommaToken,
        LessThanToken,
        GreaterThanToken,
        LessThanEqualsToken,
        GreaterThanEqualsToken,
        EqualsEqualsToken,
        ExclamationEqualsToken,
        EqualsEqualsEqualsToken,
        ExclamationEqualsEqualsToken,
        EqualsGreaterThanToken,
        PlusToken,
        MinusToken,
        AsteriskToken,
        SlashToken,
        PercentToken,
        PlusPlusToken,
        MinusMinusToken,
        LessThanLessThanToken,
        GreaterThanGreaterThanToken,
        GreaterThanGreaterThanGreaterThanToken,
        AmpersandToken,
        BarToken,
        CaretToken,
        ExclamationToken,
        TildeToken,
        AmpersandAmpersandToken,
        BarBarToken,
        QuestionToken,
        ColonToken,
        EqualsToken,
        PlusEqualsToken,
        MinusEqualsToken,
        AsteriskEqualsToken,
        SlashEqualsToken,
        PercentEqualsToken,
        LessThanLessThanEqualsToken,
        GreaterThanGreaterThanEqualsToken,
        GreaterThanGreaterThanGreaterThanEqualsToken,
        AmpersandEqualsToken,
        BarEqualsToken,
        CaretEqualsToken,
        Identifier,
        BreakKeyword,
        CaseKeyword,
        CatchKeyword,
        ClassKeyword,
        ConstKeyword,
        ContinueKeyword,
        DebuggerKeyword,
        DefaultKeyword,
        DeleteKeyword,
        DoKeyword,
        ElseKeyword,
        EnumKeyword,
        ExportKeyword,
        ExtendsKeyword,
        FalseKeyword,
        FinallyKeyword,
        ForKeyword,
        FunctionKeyword,
        IfKeyword,
        ImportKeyword,
        InKeyword,
        InstanceOfKeyword,
        NewKeyword,
        NullKeyword,
        ReturnKeyword,
        SuperKeyword,
        SwitchKeyword,
        ThisKeyword,
        ThrowKeyword,
        TrueKeyword,
        TryKeyword,
        TypeOfKeyword,
        VarKeyword,
        VoidKeyword,
        WhileKeyword,
        WithKeyword,
        ImplementsKeyword,
        InterfaceKeyword,
        LetKeyword,
        PackageKeyword,
        PrivateKeyword,
        ProtectedKeyword,
        PublicKeyword,
        StaticKeyword,
        YieldKeyword,
        AnyKeyword,
        BooleanKeyword,
        ConstructorKeyword,
        DeclareKeyword,
        GetKeyword,
        ModuleKeyword,
        RequireKeyword,
        NumberKeyword,
        SetKeyword,
        StringKeyword,
        TypeKeyword,
        QualifiedName,
        ComputedPropertyName,
        TypeParameter,
        Parameter,
        Property,
        Method,
        Constructor,
        GetAccessor,
        SetAccessor,
        CallSignature,
        ConstructSignature,
        IndexSignature,
        TypeReference,
        FunctionType,
        ConstructorType,
        TypeQuery,
        TypeLiteral,
        ArrayType,
        TupleType,
        UnionType,
        ParenthesizedType,
        ArrayLiteralExpression,
        ObjectLiteralExpression,
        PropertyAccessExpression,
        ElementAccessExpression,
        CallExpression,
        NewExpression,
        TaggedTemplateExpression,
        TypeAssertionExpression,
        ParenthesizedExpression,
        FunctionExpression,
        ArrowFunction,
        DeleteExpression,
        TypeOfExpression,
        VoidExpression,
        PrefixUnaryExpression,
        PostfixUnaryExpression,
        BinaryExpression,
        ConditionalExpression,
        TemplateExpression,
        YieldExpression,
        OmittedExpression,
        TemplateSpan,
        Block,
        VariableStatement,
        EmptyStatement,
        ExpressionStatement,
        IfStatement,
        DoStatement,
        WhileStatement,
        ForStatement,
        ForInStatement,
        ContinueStatement,
        BreakStatement,
        ReturnStatement,
        WithStatement,
        SwitchStatement,
        LabeledStatement,
        ThrowStatement,
        TryStatement,
        TryBlock,
        FinallyBlock,
        DebuggerStatement,
        VariableDeclaration,
        FunctionDeclaration,
        ClassDeclaration,
        InterfaceDeclaration,
        TypeAliasDeclaration,
        EnumDeclaration,
        ModuleDeclaration,
        ModuleBlock,
        ImportDeclaration,
        ExportAssignment,
        ExternalModuleReference,
        CaseClause,
        DefaultClause,
        HeritageClause,
        CatchClause,
        PropertyAssignment,
        ShorthandPropertyAssignment,
        EnumMember,
        SourceFile,
        Program,
        SyntaxList,
        Count,
        FirstAssignment, // = EqualsToken
        LastAssignment, // = CaretEqualsToken
        FirstReservedWord, // = BreakKeyword
        LastReservedWord, // = WithKeyword
        FirstKeyword, // = BreakKeyword
        LastKeyword, // = TypeKeyword
        FirstFutureReservedWord, // = ImplementsKeyword
        LastFutureReservedWord, // = YieldKeyword
        FirstTypeNode, // = TypeReference
        LastTypeNode, // = ParenthesizedType
        FirstPunctuation, // = OpenBraceToken
        LastPunctuation, // = CaretEqualsToken
        FirstToken, // = Unknown
        LastToken, // = TypeKeyword
        FirstTriviaToken, // = SingleLineCommentTrivia
        LastTriviaToken, // = WhitespaceTrivia
        FirstLiteralToken, // = NumericLiteral
        LastLiteralToken, // = NoSubstitutionTemplateLiteral
        FirstTemplateToken, // = NoSubstitutionTemplateLiteral
        LastTemplateToken, // = TemplateTail
        FirstOperator, // = SemicolonToken
        LastOperator, // = CaretEqualsToken
        FirstBinaryOperator, // = LessThanToken
        LastBinaryOperator, // = CaretEqualsToken
        FirstNode // = QualifiedName
    }
    public enum class NodeFlags {
        Export, // = 0x00000001
        Ambient, // = 0x00000002
        Public, // = 0x00000010
        Private, // = 0x00000020
        Protected, // = 0x00000040
        Static, // = 0x00000080
        MultiLine, // = 0x00000100
        Synthetic, // = 0x00000200
        DeclarationFile, // = 0x00000400
        Let, // = 0x00000800
        Const, // = 0x00001000
        OctalLiteral, // = 0x00002000
        Modifier, // = Export | Ambient | Public | Private | Protected | Static
        AccessibilityModifier, // = Public | Private | Protected
        BlockScoped // = Let | Const
    }
    public enum class ParserContextFlags {
        StrictMode, // = 1 << 0
        DisallowIn, // = 1 << 1
        Yield, // = 1 << 2
        GeneratorParameter, // = 1 << 3
        ContainsError, // = 1 << 4
        HasPropagatedChildContainsErrorFlag // = 1 << 5
    }
    public interface Node : TextRange {
        public var kind: SyntaxKind
        public var flags: NodeFlags
        public var parserContextFlags: ParserContextFlags? // = noImpl
        public var id: Number? // = noImpl
        public var parent: Node? // = noImpl
        public var symbol: Symbol? // = noImpl
        public var locals: SymbolTable? // = noImpl
        public var nextContainer: Node? // = noImpl
        public var localSymbol: Symbol? // = noImpl
        public var modifiers: ModifiersArray? // = noImpl
    }

    open class JsArray<T>

    public interface NodeArray<T> : JsArray<T>, TextRange {
        public var hasTrailingComma: Boolean? // = noImpl
    }

    public interface ModifiersArray : NodeArray<Node> {
        public var flags: Number
    }

    public interface Identifier : PrimaryExpression {
        public var text: String
    }

    public interface EntityName : Identifier, QualifiedName
    public interface DeclarationName : Identifier, LiteralExpression, ComputedPropertyName

    public interface QualifiedName : Node {
        public var left: EntityName
        public var right: Identifier
    }
    public interface Declaration : Node {
        public var _declarationBrand: Any
        native("name")
        public val declarationName: DeclarationName? // = noImpl
    }
    public interface ComputedPropertyName : Node {
        public var expression: Expression
    }
    public interface TypeParameterDeclaration : Declaration {
        public var name: Identifier
        public var constraint: TypeNode? // = noImpl
        public var expression: Expression? // = noImpl
    }
        public interface SignatureDeclaration : Declaration {
        public var typeParameters: NodeArray<TypeParameterDeclaration>? // = noImpl
        public var parameters: NodeArray<ParameterDeclaration>
        public var type: TypeNode? // = noImpl
    }
    public interface VariableDeclaration : Declaration {
        public var name: Identifier
        public var type: TypeNode? // = noImpl
        public var initializer: Expression? // = noImpl
    }

    interface TypeNode_or_StringLiteralExpression : TypeNode, StringLiteralExpression

    public interface ParameterDeclaration : Declaration {
        public var dotDotDotToken: Node? // = noImpl
        public var name: Identifier
        public var questionToken: Node? // = noImpl
        public var type: TypeNode_or_StringLiteralExpression? // = noImpl
        public var initializer: Expression? // = noImpl
    }
    public interface PropertyDeclaration : Declaration, ClassElement {
        public var _propertyDeclarationBrand: Any
        public var questionToken: Node? // = noImpl
        public var type: TypeNode? // = noImpl
        public var initializer: Expression? // = noImpl
    }
    public interface ObjectLiteralElement : Declaration {
        public var _objectLiteralBrandBrand: Any
    }
    public interface ShorthandPropertyAssignment : ObjectLiteralElement {
        public var name: Identifier
        public var questionToken: Node? // = noImpl
    }
    public interface PropertyAssignment : ObjectLiteralElement {
        public var _propertyAssignmentBrand: Any
        native("name")
        override val declarationName: DeclarationName
        public var questionToken: Node? // = noImpl
        public var initializer: Expression
    }

    interface Block_or_Expression : Block, Expression

    public interface FunctionLikeDeclaration : SignatureDeclaration {
        public var _functionLikeDeclarationBrand: Any
        public var asteriskToken: Node? // = noImpl
        public var questionToken: Node? // = noImpl
        native("body")
        public val myBody: Block_or_Expression? // = noImpl
    }
    public interface FunctionDeclaration : FunctionLikeDeclaration, Statement {
        public var name: Identifier
        public var body: Block? // = noImpl
    }
    public interface MethodDeclaration : FunctionLikeDeclaration, ClassElement, ObjectLiteralElement {
        //TODO extra space
        public  var body: Block? // = noImpl
    }
    public interface ConstructorDeclaration : FunctionLikeDeclaration, ClassElement {
        public  var body: Block? // = noImpl
    }
    public interface AccessorDeclaration : FunctionLikeDeclaration, ClassElement, ObjectLiteralElement {
        public var _accessorDeclarationBrand: Any
        public var body: Block
    }
    public interface IndexSignatureDeclaration : SignatureDeclaration, ClassElement {
        public var _indexSignatureDeclarationBrand: Any
    }
    public interface TypeNode : Node {
        public var _typeNodeBrand: Any
    }
    public interface FunctionOrConstructorTypeNode : TypeNode, SignatureDeclaration {
        public var _functionOrConstructorTypeNodeBrand: Any
    }
    public interface TypeReferenceNode : TypeNode {
        public var typeName: EntityName
        public var typeArguments: NodeArray<TypeNode>? // = noImpl
    }
    public interface TypeQueryNode : TypeNode {
        public var exprName: EntityName
    }
    public interface TypeLiteralNode : TypeNode, Declaration {
        public var members: NodeArray<Node>
    }
    public interface ArrayTypeNode : TypeNode {
        public var elementType: TypeNode
    }
    public interface TupleTypeNode : TypeNode {
        public var elementTypes: NodeArray<TypeNode>
    }
    public interface UnionTypeNode : TypeNode {
        public var types: NodeArray<TypeNode>
    }
    public interface ParenthesizedTypeNode : TypeNode {
        public var type: TypeNode
    }
    public interface Expression : Node {
        public var _expressionBrand: Any
        public var contextualType: Type? // = noImpl
    }
    public interface UnaryExpression : Expression {
        public var _unaryExpressionBrand: Any
    }
    public interface PrefixUnaryExpression : UnaryExpression {
        public var operator: SyntaxKind
        public var operand: UnaryExpression
    }
    public interface PostfixUnaryExpression : PostfixExpression {
        public var operand: LeftHandSideExpression
        public var operator: SyntaxKind
    }
    public interface PostfixExpression : UnaryExpression {
        public var _postfixExpressionBrand: Any
    }
    public interface LeftHandSideExpression : PostfixExpression {
        public var _leftHandSideExpressionBrand: Any
    }
    public interface MemberExpression : LeftHandSideExpression {
        public var _memberExpressionBrand: Any
    }
    public interface PrimaryExpression : MemberExpression {
        public var _primaryExpressionBrand: Any
    }
    public interface DeleteExpression : UnaryExpression {
        public var expression: UnaryExpression
    }
    public interface TypeOfExpression : UnaryExpression {
        public var expression: UnaryExpression
    }
    public interface VoidExpression : UnaryExpression {
        public var expression: UnaryExpression
    }
    public interface YieldExpression : Expression {
        public var asteriskToken: Node? // = noImpl
        public var expression: Expression
    }
    public interface BinaryExpression : Expression {
        public var left: Expression
        public var operator: SyntaxKind
        public var right: Expression
    }
    public interface ConditionalExpression : Expression {
        public var condition: Expression
        public var whenTrue: Expression
        public var whenFalse: Expression
    }
    public interface FunctionExpression : PrimaryExpression, FunctionLikeDeclaration {
        public var name: Identifier? // = noImpl
        native("body")
        override var myBody: Block_or_Expression
    }
    public interface LiteralExpression : PrimaryExpression {
        public var text: String
        public var isUnterminated: Boolean? // = noImpl
    }
    public interface StringLiteralExpression : LiteralExpression {
        public var _stringLiteralExpressionBrand: Any
    }
    public interface TemplateExpression : PrimaryExpression {
        public var head: LiteralExpression
        public var templateSpans: NodeArray<TemplateSpan>
    }
    public interface TemplateSpan : Node {
        public var expression: Expression
        public var literal: LiteralExpression
    }
    public interface ParenthesizedExpression : PrimaryExpression {
        public var expression: Expression
    }
    public interface ArrayLiteralExpression : PrimaryExpression {
        public var elements: NodeArray<Expression>
    }
    public interface ObjectLiteralExpression : PrimaryExpression, Declaration {
        public var properties: NodeArray<ObjectLiteralElement>
    }
    public interface PropertyAccessExpression : MemberExpression {
        public var expression: LeftHandSideExpression
        public var name: Identifier
    }
    public interface ElementAccessExpression : MemberExpression {
        public var expression: LeftHandSideExpression
        public var argumentExpression: Expression? // = noImpl
    }
    public interface CallExpression : LeftHandSideExpression {
        public var expression: LeftHandSideExpression
        public var typeArguments: NodeArray<TypeNode>? // = noImpl
        public var arguments: NodeArray<Expression>
    }
    public interface NewExpression : CallExpression, PrimaryExpression

    interface LiteralExpression_or_TemplateExpression : LiteralExpression, TemplateExpression

    public interface TaggedTemplateExpression : MemberExpression {
        public var tag: LeftHandSideExpression
        public var template: LiteralExpression_or_TemplateExpression
    }
    public interface TypeAssertion : UnaryExpression {
        public var type: TypeNode
        public var expression: UnaryExpression
    }
    public interface Statement : Node, ModuleElement {
        public var _statementBrand: Any
    }
    public interface Block : Statement {
        public var statements: NodeArray<Statement>
    }
    public interface VariableStatement : Statement {
        public var declarations: NodeArray<VariableDeclaration>
    }
    public interface ExpressionStatement : Statement {
        public var expression: Expression
    }
    public interface IfStatement : Statement {
        public var expression: Expression
        public var thenStatement: Statement
        public var elseStatement: Statement? // = noImpl
    }
    public interface IterationStatement : Statement {
        public var statement: Statement
    }
    public interface DoStatement : IterationStatement {
        public var expression: Expression
    }
    public interface WhileStatement : IterationStatement {
        public var expression: Expression
    }
    public interface ForStatement : IterationStatement {
        public var declarations: NodeArray<VariableDeclaration>? // = noImpl
        public var initializer: Expression? // = noImpl
        public var condition: Expression? // = noImpl
        public var iterator: Expression? // = noImpl
    }
    public interface ForInStatement : IterationStatement {
        public var declarations: NodeArray<VariableDeclaration>? // = noImpl
        public var variable: Expression? // = noImpl
        public var expression: Expression
    }
    public interface BreakOrContinueStatement : Statement {
        public var label: Identifier? // = noImpl
    }
    public interface ReturnStatement : Statement {
        public var expression: Expression? // = noImpl
    }
    public interface WithStatement : Statement {
        public var expression: Expression
        public var statement: Statement
    }
    public interface SwitchStatement : Statement {
        public var expression: Expression
        public var clauses: NodeArray<CaseOrDefaultClause>
    }
    public interface CaseClause : Node {
        public var expression: Expression? // = noImpl
        public var statements: NodeArray<Statement>
    }
    public interface DefaultClause : Node {
        public var statements: NodeArray<Statement>
    }

    public interface CaseOrDefaultClause : CaseClause, DefaultClause

    public interface LabeledStatement : Statement {
        public var label: Identifier
        public var statement: Statement
    }
    public interface ThrowStatement : Statement {
        public var expression: Expression
    }
    public interface TryStatement : Statement {
        public var tryBlock: Block
        public var catchClause: CatchClause? // = noImpl
        public var finallyBlock: Block? // = noImpl
    }
    public interface CatchClause : Declaration {
        public var name: Identifier
        public var type: TypeNode? // = noImpl
        public var block: Block
    }
    public interface ModuleElement : Node {
        public var _moduleElementBrand: Any
    }
    public interface ClassDeclaration : Declaration, ModuleElement {
        public var name: Identifier
        public var typeParameters: NodeArray<TypeParameterDeclaration>? // = noImpl
        public var heritageClauses: NodeArray<HeritageClause>? // = noImpl
        public var members: NodeArray<ClassElement>
    }
    public interface ClassElement : Declaration {
        public var _classElementBrand: Any
    }
    public interface InterfaceDeclaration : Declaration, ModuleElement {
        public var name: Identifier
        public var typeParameters: NodeArray<TypeParameterDeclaration>? // = noImpl
        public var heritageClauses: NodeArray<HeritageClause>? // = noImpl
        public var members: NodeArray<Declaration>
    }
    public interface HeritageClause : Node {
        public var token: SyntaxKind
        public var types: NodeArray<TypeReferenceNode>? // = noImpl
    }
    public interface TypeAliasDeclaration : Declaration, ModuleElement {
        public var name: Identifier
        public var type: TypeNode
    }
    public interface EnumMember : Declaration {
        native("name")
        override var declarationName: DeclarationName
        public var initializer: Expression? // = noImpl
    }
    public interface EnumDeclaration : Declaration, ModuleElement {
        public var name: Identifier
        public var members: NodeArray<EnumMember>
    }

    interface Identifier_or_LiteralExpression : Identifier, LiteralExpression

    interface ModuleBlock_or_ModuleDeclaration : ModuleBlock, ModuleDeclaration

    public interface ModuleDeclaration : Declaration, ModuleElement {
        public var name: Identifier_or_LiteralExpression
        public var body: ModuleBlock_or_ModuleDeclaration
    }
    public interface ModuleBlock : Node, ModuleElement {
        public var statements: NodeArray<ModuleElement>
    }

    interface EntityName_or_ExternalModuleReference : EntityName, ExternalModuleReference

    public interface ImportDeclaration : Declaration, ModuleElement {
        public var name: Identifier
        public var moduleReference: EntityName_or_ExternalModuleReference
    }
    public interface ExternalModuleReference : Node {
        public var expression: Expression? // = noImpl
    }
    public interface ExportAssignment : Statement, ModuleElement {
        public var exportName: Identifier
    }
    public interface FileReference : TextRange {
        public var filename: String
    }
    public interface CommentRange : TextRange {
        public var hasTrailingNewLine: Boolean? // = noImpl
    }
    public interface SourceFile : Declaration {
        public var statements: NodeArray<ModuleElement>
        public var endOfFileToken: Node
        public var filename: String
        public var text: String
        public fun getLineAndCharacterFromPosition(position: Number): LineAndCharacter
        public fun getPositionFromLineAndCharacter(line: Number, character: Number): Number
        public fun getLineStarts(): Array<Number>
        public var amdDependencies: Array<String>
        public var amdModuleName: String
        public var referencedFiles: Array<FileReference>
        public var referenceDiagnostics: Array<Diagnostic>
        public var parseDiagnostics: Array<Diagnostic>
        public var grammarDiagnostics: Array<Diagnostic>
        public fun getSyntacticDiagnostics(): Array<Diagnostic>
        public var semanticDiagnostics: Array<Diagnostic>
        public var hasNoDefaultLib: Boolean
        public var externalModuleIndicator: Node
        public var nodeCount: Number
        public var identifierCount: Number
        public var symbolCount: Number
        public var isOpen: Boolean
        public var version: String
        public var languageVersion: ScriptTarget
        public var identifiers: JsMap<String>
    }
    public interface Program {
        public fun getSourceFile(filename: String): SourceFile
        public fun getSourceFiles(): Array<SourceFile>
        public fun getCompilerOptions(): CompilerOptions
        public fun getCompilerHost(): CompilerHost
        public fun getDiagnostics(sourceFile: SourceFile? = null): Array<Diagnostic>
        public fun getGlobalDiagnostics(): Array<Diagnostic>
        public fun getTypeChecker(fullTypeCheckMode: Boolean): TypeChecker
        public fun getCommonSourceDirectory(): String
    }
    public interface SourceMapSpan {
        public var emittedLine: Number
        public var emittedColumn: Number
        public var sourceLine: Number
        public var sourceColumn: Number
        public var nameIndex: Number? // = noImpl
        public var sourceIndex: Number
    }
    public interface SourceMapData {
        public var sourceMapFilePath: String
        public var jsSourceMappingURL: String
        public var sourceMapFile: String
        public var sourceMapSourceRoot: String
        public var sourceMapSources: Array<String>
        public var inputSourceFileNames: Array<String>
        public var sourceMapNames: Array<String>? // = noImpl
        public var sourceMapMappings: String
        public var sourceMapDecodedMappings: Array<SourceMapSpan>
    }
    public enum class EmitReturnStatus {
        Succeeded, // = 0
        AllOutputGenerationSkipped, // = 1
        JSGeneratedWithSemanticErrors, // = 2
        DeclarationGenerationSkipped, // = 3
        EmitErrorsEncountered, // = 4
        CompilerOptionsErrors // = 5
    }
    public interface EmitResult {
        public var emitResultStatus: EmitReturnStatus
        public var diagnostics: Array<Diagnostic>
        public var sourceMaps: Array<SourceMapData>
    }

    interface CallLikeExpression : CallExpression, NewExpression, TaggedTemplateExpression

    interface PropertyAccessExpression_or_QualifiedName : PropertyAccessExpression, QualifiedName

    public interface TypeChecker {
        public fun getProgram(): Program
        public fun getDiagnostics(sourceFile: SourceFile? = null): Array<Diagnostic>
        public fun getDeclarationDiagnostics(sourceFile: SourceFile): Array<Diagnostic>
        public fun getGlobalDiagnostics(): Array<Diagnostic>
        public fun getNodeCount(): Number
        public fun getIdentifierCount(): Number
        public fun getSymbolCount(): Number
        public fun getTypeCount(): Number
        public fun emitFiles(targetSourceFile: SourceFile? = null): EmitResult
        public fun getTypeOfSymbolAtLocation(symbol: Symbol, node: Node): Type
        public fun getDeclaredTypeOfSymbol(symbol: Symbol): Type
        public fun getPropertiesOfType(type: Type): Array<Symbol>
        public fun getPropertyOfType(type: Type, propertyName: String): Symbol?
        public fun getSignaturesOfType(type: Type, kind: SignatureKind): Array<Signature>
        public fun getIndexTypeOfType(type: Type, kind: IndexKind): Type
        public fun getReturnTypeOfSignature(signature: Signature): Type
        public fun getSymbolsInScope(location: Node, meaning: SymbolFlags): Array<Symbol>
        public fun getSymbolAtLocation(node: Node): Symbol
        public fun getShorthandAssignmentValueSymbol(location: Node): Symbol
        public fun getTypeAtLocation(node: Node): Type
        public fun typeToString(type: Type, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null): String
        public fun symbolToString(symbol: Symbol, enclosingDeclaration: Node? = null, meaning: SymbolFlags? = null): String
        public fun getSymbolDisplayBuilder(): SymbolDisplayBuilder
        public fun getFullyQualifiedName(symbol: Symbol): String
        public fun getAugmentedPropertiesOfType(type: Type): Array<Symbol>
        public fun getRootSymbols(symbol: Symbol): Array<Symbol>
        public fun getContextualType(node: Expression): Type
        public fun getResolvedSignature(node: CallLikeExpression, candidatesOutArray: Array<Signature>? = null): Signature
        public fun getSignatureFromDeclaration(declaration: SignatureDeclaration): Signature
        public fun isImplementationOfOverload(node: FunctionLikeDeclaration): Boolean
        public fun isUndefinedSymbol(symbol: Symbol): Boolean
        public fun isArgumentsSymbol(symbol: Symbol): Boolean
        public fun isEmitBlocked(sourceFile: SourceFile? = null): Boolean
        public fun getEnumMemberValue(node: EnumMember): Number
        public fun isValidPropertyAccess(node: PropertyAccessExpression_or_QualifiedName, propertyName: String): Boolean
        public fun getAliasedSymbol(symbol: Symbol): Symbol
    }
    public interface SymbolDisplayBuilder {
        public fun buildTypeDisplay(type: Type, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        public fun buildSymbolDisplay(symbol: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = null, meaning: SymbolFlags? = null, flags: SymbolFormatFlags? = null)
        public fun buildSignatureDisplay(signatures: Signature, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        public fun buildParameterDisplay(parameter: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        public fun buildTypeParameterDisplay(tp: TypeParameter, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        public fun buildTypeParameterDisplayFromSymbol(symbol: Symbol, writer: SymbolWriter, enclosingDeclaraiton: Node? = null, flags: TypeFormatFlags? = null)
        public fun buildDisplayForParametersAndDelimiters(parameters: Array<Symbol>, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        public fun buildDisplayForTypeParametersAndDelimiters(typeParameters: Array<TypeParameter>, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        public fun buildReturnTypeDisplay(signature: Signature, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
    }
    public interface SymbolWriter {
        public fun writeKeyword(text: String)
        public fun writeOperator(text: String)
        public fun writePunctuation(text: String)
        public fun writeSpace(text: String)
        public fun writeStringLiteral(text: String)
        public fun writeParameter(text: String)
        public fun writeSymbol(text: String, symbol: Symbol)
        public fun writeLine()
        public fun increaseIndent()
        public fun decreaseIndent()
        public fun clear()
        public fun trackSymbol(symbol: Symbol, enclosingDeclaration: Node? = null, meaning: SymbolFlags? = null)
    }
    public enum class TypeFormatFlags {
        None, // = 0x00000000
        WriteArrayAsGenericType, // = 0x00000001
        UseTypeOfFunction, // = 0x00000002
        NoTruncation, // = 0x00000004
        WriteArrowStyleSignature, // = 0x00000008
        WriteOwnNameForAnyLike, // = 0x00000010
        WriteTypeArgumentsOfSignature, // = 0x00000020
        InElementType // = 0x00000040
    }
    public enum class SymbolFormatFlags {
        None, // = 0x00000000
        WriteTypeParametersOrArguments, // = 0x00000001
        UseOnlyExternalAliasing // = 0x00000002
    }
    public enum class SymbolAccessibility {
        Accessible,
        NotAccessible,
        CannotBeNamed
    }
    public interface SymbolVisibilityResult {
        public var accessibility: SymbolAccessibility
        public var aliasesToMakeVisible: Array<ImportDeclaration>? // = noImpl
        public var errorSymbolName: String? // = noImpl
        public var errorNode: Node? // = noImpl
    }
    public interface SymbolAccessiblityResult : SymbolVisibilityResult {
        public var errorModuleName: String? // = noImpl
    }
    public interface EmitResolver {
//        public fun getProgram(): Program
//        public fun getLocalNameOfContainer(container: ModuleDeclaration, EnumDeclaration: Any): String
//        public fun getExpressionNamePrefix(node: Identifier): String
//        public fun getExportAssignmentName(node: SourceFile): String
//        public fun isReferencedImportDeclaration(node: ImportDeclaration): Boolean
//        public fun isTopLevelValueImportWithEntityName(node: ImportDeclaration): Boolean
//        public fun getNodeCheckFlags(node: Node): NodeCheckFlags
//        public fun getEnumMemberValue(node: EnumMember): Number
//        public fun hasSemanticErrors(sourceFile: SourceFile? = null): Boolean
//        public fun isDeclarationVisible(node: Declaration): Boolean
//        public fun isImplementationOfOverload(node: FunctionLikeDeclaration): Boolean
//        public fun writeTypeOfDeclaration(declaration: AccessorDeclaration, VariableOrParameterDeclaration: Any, enclosingDeclaration: Node, flags: TypeFormatFlags, writer: SymbolWriter)
//        public fun writeReturnTypeOfSignatureDeclaration(signatureDeclaration: SignatureDeclaration, enclosingDeclaration: Node, flags: TypeFormatFlags, writer: SymbolWriter)
//        public fun isSymbolAccessible(symbol: Symbol, enclosingDeclaration: Node, meaning: SymbolFlags): SymbolAccessiblityResult
//        public fun isEntityNameVisible(entityName: EntityName, enclosingDeclaration: Node): SymbolVisibilityResult
//        public fun getConstantValue(node: PropertyAccessExpression, ElementAccessExpression: Any): Number
//        public fun isEmitBlocked(sourceFile: SourceFile? = null): Boolean
    }
    public enum class SymbolFlags {
        FunctionScopedVariable, // = 0x00000001
        BlockScopedVariable, // = 0x00000002
        Property, // = 0x00000004
        EnumMember, // = 0x00000008
        Function, // = 0x00000010
        Class, // = 0x00000020
        Interface, // = 0x00000040
        ConstEnum, // = 0x00000080
        RegularEnum, // = 0x00000100
        ValueModule, // = 0x00000200
        NamespaceModule, // = 0x00000400
        TypeLiteral, // = 0x00000800
        ObjectLiteral, // = 0x00001000
        Method, // = 0x00002000
        Constructor, // = 0x00004000
        GetAccessor, // = 0x00008000
        SetAccessor, // = 0x00010000
        CallSignature, // = 0x00020000
        ConstructSignature, // = 0x00040000
        IndexSignature, // = 0x00080000
        TypeParameter, // = 0x00100000
        TypeAlias, // = 0x00200000
        ExportValue, // = 0x00400000
        ExportType, // = 0x00800000
        ExportNamespace, // = 0x01000000
        Import, // = 0x02000000
        Instantiated, // = 0x04000000
        Merged, // = 0x08000000
        Transient, // = 0x10000000
        Prototype, // = 0x20000000
        UnionProperty, // = 0x40000000
        Enum, // = RegularEnum | ConstEnum
        Variable, // = FunctionScopedVariable | BlockScopedVariable
        Value, // = Variable | Property | EnumMember | Function | Class | Enum | ValueModule | Method | GetAccessor | SetAccessor
        Type, // = Class | Interface | Enum | TypeLiteral | ObjectLiteral | TypeParameter | TypeAlias
        Namespace, // = ValueModule | NamespaceModule
        Module, // = ValueModule | NamespaceModule
        Accessor, // = GetAccessor | SetAccessor
        Signature, // = CallSignature | ConstructSignature | IndexSignature
        FunctionScopedVariableExcludes, // = Value & ~FunctionScopedVariable
        BlockScopedVariableExcludes, // = Value
        ParameterExcludes, // = Value
        PropertyExcludes, // = Value
        EnumMemberExcludes, // = Value
        FunctionExcludes, // = Value & ~(Function | ValueModule)
        ClassExcludes, // = (Value | Type) & ~ValueModule
        InterfaceExcludes, // = Type & ~Interface
        RegularEnumExcludes, // = (Value | Type) & ~(RegularEnum | ValueModule)
        ConstEnumExcludes, // = (Value | Type) & ~ConstEnum
        ValueModuleExcludes, // = Value & ~(Function | Class | RegularEnum | ValueModule)
        NamespaceModuleExcludes, // = 0
        MethodExcludes, // = Value & ~Method
        GetAccessorExcludes, // = Value & ~SetAccessor
        SetAccessorExcludes, // = Value & ~GetAccessor
        TypeParameterExcludes, // = Type & ~TypeParameter
        TypeAliasExcludes, // = Type
        ImportExcludes, // = Import
        ModuleMember, // = Variable | Function | Class | Interface | Enum | Module | TypeAlias | Import
        ExportHasLocal, // = Function | Class | Enum | ValueModule
        HasLocals, // = Function | Module | Method | Constructor | Accessor | Signature
        HasExports, // = Class | Enum | Module
        HasMembers, // = Class | Interface | TypeLiteral | ObjectLiteral
        IsContainer, // = HasLocals | HasExports | HasMembers
        PropertyOrAccessor, // = Property | Accessor
        Export // = ExportNamespace | ExportType | ExportValue
    }
    public interface Symbol {
        public var flags: SymbolFlags
        public var name: String
        public var id: Number? // = noImpl
        public var mergeId: Number? // = noImpl
        public var declarations: Array<Declaration>? // = noImpl
        public var parent: Symbol? // = noImpl
        public var members: SymbolTable? // = noImpl
        public var exports: SymbolTable? // = noImpl
        public var exportSymbol: Symbol? // = noImpl
        public var valueDeclaration: Declaration? // = noImpl
        public var constEnumOnlyModule: Boolean? // = noImpl
    }
    public interface SymbolLinks {
        public var target: Symbol? // = noImpl
        public var type: Type? // = noImpl
        public var declaredType: Type? // = noImpl
        public var mapper: TypeMapper? // = noImpl
        public var referenced: Boolean? // = noImpl
        public var exportAssignSymbol: Symbol? // = noImpl
        public var unionType: UnionType? // = noImpl
    }
    public interface TransientSymbol : Symbol, SymbolLinks
    public interface SymbolTable {
        public fun get(index: String): Symbol
        public fun set(index: String, value: Symbol)
    }
    public enum class NodeCheckFlags {
        TypeChecked, // = 0x00000001
        LexicalThis, // = 0x00000002
        CaptureThis, // = 0x00000004
        EmitExtends, // = 0x00000008
        SuperInstance, // = 0x00000010
        SuperStatic, // = 0x00000020
        ContextChecked, // = 0x00000040
        EnumValuesComputed // = 0x00000080
    }
    public interface NodeLinks {
        public var resolvedType: Type? // = noImpl
        public var resolvedSignature: Signature? // = noImpl
        public var resolvedSymbol: Symbol? // = noImpl
        public var flags: NodeCheckFlags? // = noImpl
        public var enumMemberValue: Number? // = noImpl
        public var isIllegalTypeReferenceInConstraint: Boolean? // = noImpl
        public var isVisible: Boolean? // = noImpl
        public var localModuleName: String? // = noImpl
        public var assignmentChecks: JsMap<Boolean>? // = noImpl
    }
    public enum class TypeFlags {
        Any, // = 0x00000001
        String, // = 0x00000002
        Number, // = 0x00000004
        Boolean, // = 0x00000008
        Void, // = 0x00000010
        Undefined, // = 0x00000020
        Null, // = 0x00000040
        Enum, // = 0x00000080
        StringLiteral, // = 0x00000100
        TypeParameter, // = 0x00000200
        Class, // = 0x00000400
        Interface, // = 0x00000800
        Reference, // = 0x00001000
        Tuple, // = 0x00002000
        Union, // = 0x00004000
        Anonymous, // = 0x00008000
        FromSignature, // = 0x00010000
        Intrinsic, // = Any | String | Number | Boolean | Void | Undefined | Null
        StringLike, // = String | StringLiteral
        NumberLike, // = Number | Enum
        ObjectType // = Class | Interface | Reference | Tuple | Anonymous
    }
    public interface Type {
        public var flags: TypeFlags
        public var id: Number
        public var symbol: Symbol? // = noImpl
    }
    public interface IntrinsicType : Type {
        public var intrinsicName: String
    }
    public interface StringLiteralType : Type {
        public var text: String
    }
    public interface ObjectType : Type
    public interface InterfaceType : ObjectType {
        public var typeParameters: Array<TypeParameter>
        public var baseTypes: Array<ObjectType>
        public var declaredProperties: Array<Symbol>
        public var declaredCallSignatures: Array<Signature>
        public var declaredConstructSignatures: Array<Signature>
        public var declaredStringIndexType: Type
        public var declaredNumberIndexType: Type
    }
    public interface TypeReference : ObjectType {
        public var target: GenericType
        public var typeArguments: Array<Type>
    }
    public interface GenericType : InterfaceType, TypeReference {
        public var instantiations: JsMap<TypeReference>
        public var openReferenceTargets: Array<GenericType>
        public var openReferenceChecks: JsMap<Boolean>
    }
    public interface TupleType : ObjectType {
        public var elementTypes: Array<Type>
        public var baseArrayType: TypeReference
    }
    public interface UnionType : Type {
        public var types: Array<Type>
        public var resolvedProperties: SymbolTable
    }
    public interface ResolvedType : ObjectType, UnionType {
        public var members: SymbolTable
        public var properties: Array<Symbol>
        public var callSignatures: Array<Signature>
        public var constructSignatures: Array<Signature>
        public var stringIndexType: Type
        public var numberIndexType: Type
    }
    public interface TypeParameter : Type {
        public var constraint: Type
        public var target: TypeParameter? // = noImpl
        public var mapper: TypeMapper? // = noImpl
    }
    public enum class SignatureKind {
        Call,
        Construct
    }
    public interface Signature {
        public var declaration: SignatureDeclaration
        public var typeParameters: Array<TypeParameter>
        public var parameters: Array<Symbol>
        public var resolvedReturnType: Type
        public var minArgumentCount: Number
        public var hasRestParameter: Boolean
        public var hasStringLiterals: Boolean
        public var target: Signature? // = noImpl
        public var mapper: TypeMapper? // = noImpl
        public var unionSignatures: Array<Signature>? // = noImpl
        public var erasedSignatureCache: Signature? // = noImpl
        public var isolatedSignatureType: ObjectType? // = noImpl
    }
    public enum class IndexKind {
        String,
        Number
    }
    public interface TypeMapper {
        public fun invoke(t: Type): Type
    }
    public interface TypeInferences {
        public var primary: Array<Type>
        public var secondary: Array<Type>
    }
    public interface InferenceContext {
        public var typeParameters: Array<TypeParameter>
        public var inferUnionTypes: Boolean
        public var inferences: Array<TypeInferences>
        public var inferredTypes: Array<Type>
        public var failedTypeParameterIndex: Number? // = noImpl
    }
    public interface DiagnosticMessage {
        public var key: String
        public var category: DiagnosticCategory
        public var code: Number
        public var isEarly: Boolean? // = noImpl
    }
    public interface DiagnosticMessageChain {
        public var messageText: String
        public var category: DiagnosticCategory
        public var code: Number
        public var next: DiagnosticMessageChain? // = noImpl
    }
    public interface Diagnostic {
        public var file: SourceFile
        public var start: Number
        public var length: Number
        public var messageText: String
        public var category: DiagnosticCategory
        public var code: Number
        public var isEarly: Boolean? // = noImpl
    }
    public enum class DiagnosticCategory {
        Warning,
        Error,
        Message
    }
    public interface CompilerOptions {
        public var allowNonTsExtensions: Boolean? // = noImpl
        public var charset: String? // = noImpl
        public var codepage: Number? // = noImpl
        public var declaration: Boolean? // = noImpl
        public var diagnostics: Boolean? // = noImpl
        public var emitBOM: Boolean? // = noImpl
        public var help: Boolean? // = noImpl
        public var locale: String? // = noImpl
        public var mapRoot: String? // = noImpl
        public var module: ModuleKind? // = noImpl
        public var noEmitOnError: Boolean? // = noImpl
        public var noErrorTruncation: Boolean? // = noImpl
        public var noImplicitAny: Boolean? // = noImpl
        public var noLib: Boolean? // = noImpl
        public var noLibCheck: Boolean? // = noImpl
        public var noResolve: Boolean? // = noImpl
        public var out: String? // = noImpl
        public var outDir: String? // = noImpl
        public var preserveConstEnums: Boolean? // = noImpl
        public var removeComments: Boolean? // = noImpl
        public var sourceMap: Boolean? // = noImpl
        public var sourceRoot: String? // = noImpl
        public var suppressImplicitAnyIndexErrors: Boolean? // = noImpl
        public var target: ScriptTarget? // = noImpl
        public var version: Boolean? // = noImpl
        public var watch: Boolean? // = noImpl
//        public fun get(option: String): String
//        public fun set(option: String, value: String)
//        public fun get(option: String): Number
//        public fun set(option: String, value: Number)
//        public fun get(option: String): Boolean
//        public fun set(option: String, value: Boolean)
    }
    public enum class ModuleKind {
        None, // = 0
        CommonJS, // = 1
        AMD // = 2
    }
    public interface LineAndCharacter {
        public var line: Number
        public var character: Number
    }
    public enum class ScriptTarget {
        ES3, // = 0
        ES5, // = 1
        ES6, // = 2
        Latest // = ES6
    }
    public interface ParsedCommandLine {
        public var options: CompilerOptions
        public var filenames: Array<String>
        public var errors: Array<Diagnostic>
    }
//    public trait CommandLineOption {
//        public var name: String
//        public var type: String
//        public fun Map<number>()
//        public var shortName: String? // = noImpl
//        public var description: DiagnosticMessage? // = noImpl
//        public var paramType: DiagnosticMessage? // = noImpl
//        public var error: DiagnosticMessage? // = noImpl
//    }
    public enum class CharacterCodes {
        nullCharacter, // = 0
        maxAsciiCharacter, // = 0x7F
        lineFeed, // = 0x0A
        carriageReturn, // = 0x0D
        lineSeparator, // = 0x2028
        paragraphSeparator, // = 0x2029
        nextLine, // = 0x0085
        space, // = 0x0020
        nonBreakingSpace, // = 0x00A0
        enQuad, // = 0x2000
        emQuad, // = 0x2001
        enSpace, // = 0x2002
        emSpace, // = 0x2003
        threePerEmSpace, // = 0x2004
        fourPerEmSpace, // = 0x2005
        sixPerEmSpace, // = 0x2006
        figureSpace, // = 0x2007
        punctuationSpace, // = 0x2008
        thinSpace, // = 0x2009
        hairSpace, // = 0x200A
        zeroWidthSpace, // = 0x200B
        narrowNoBreakSpace, // = 0x202F
        ideographicSpace, // = 0x3000
        mathematicalSpace, // = 0x205F
        ogham, // = 0x1680
        _, // = 0x5F
        `$`, // = 0x24
        _0, // = 0x30
        _1, // = 0x31
        _2, // = 0x32
        _3, // = 0x33
        _4, // = 0x34
        _5, // = 0x35
        _6, // = 0x36
        _7, // = 0x37
        _8, // = 0x38
        _9, // = 0x39
        a, // = 0x61
        b, // = 0x62
        c, // = 0x63
        d, // = 0x64
        e, // = 0x65
        f, // = 0x66
        g, // = 0x67
        h, // = 0x68
        i, // = 0x69
        j, // = 0x6A
        k, // = 0x6B
        l, // = 0x6C
        m, // = 0x6D
        n, // = 0x6E
        o, // = 0x6F
        p, // = 0x70
        q, // = 0x71
        r, // = 0x72
        s, // = 0x73
        t, // = 0x74
        u, // = 0x75
        v, // = 0x76
        w, // = 0x77
        x, // = 0x78
        y, // = 0x79
        z, // = 0x7A
        A, // = 0x41
        B, // = 0x42
        C, // = 0x43
        D, // = 0x44
        E, // = 0x45
        F, // = 0x46
        G, // = 0x47
        H, // = 0x48
        I, // = 0x49
        J, // = 0x4A
        K, // = 0x4B
        L, // = 0x4C
        M, // = 0x4D
        N, // = 0x4E
        O, // = 0x4F
        P, // = 0x50
        Q, // = 0x51
        R, // = 0x52
        S, // = 0x53
        T, // = 0x54
        U, // = 0x55
        V, // = 0x56
        W, // = 0x57
        X, // = 0x58
        Y, // = 0x59
        Z, // = 0x5a
        ampersand, // = 0x26
        asterisk, // = 0x2A
        at, // = 0x40
        backslash, // = 0x5C
        backtick, // = 0x60
        bar, // = 0x7C
        caret, // = 0x5E
        closeBrace, // = 0x7D
        closeBracket, // = 0x5D
        closeParen, // = 0x29
        colon, // = 0x3A
        comma, // = 0x2C
        dot, // = 0x2E
        doubleQuote, // = 0x22
        equals, // = 0x3D
        exclamation, // = 0x21
        greaterThan, // = 0x3E
        lessThan, // = 0x3C
        minus, // = 0x2D
        openBrace, // = 0x7B
        openBracket, // = 0x5B
        openParen, // = 0x28
        percent, // = 0x25
        plus, // = 0x2B
        question, // = 0x3F
        semicolon, // = 0x3B
        singleQuote, // = 0x27
        slash, // = 0x2F
        tilde, // = 0x7E
        backspace, // = 0x08
        formFeed, // = 0x0C
        byteOrderMark, // = 0xFEFF
        tab, // = 0x09
        verticalTab // = 0x0B
    }
    public interface CancellationToken {
        public fun isCancellationRequested(): Boolean
    }
    public interface CompilerHost {
        public fun getSourceFile(filename: String, languageVersion: ScriptTarget, onError: ((message: String) -> Unit)? = null): SourceFile
        public fun getDefaultLibFilename(options: CompilerOptions): String
        public val getCancellationToken: (() -> CancellationToken)? // = noImpl
        public fun writeFile(filename: String, data: String, writeByteOrderMark: Boolean, onError: ((message: String) -> Unit)? = null)
        public fun getCurrentDirectory(): String
        public fun getCanonicalFileName(fileName: String): String
        public fun useCaseSensitiveFileNames(): Boolean
        public fun getNewLine(): String
    }
}
