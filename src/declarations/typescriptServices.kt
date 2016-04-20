package typescript

@native("ts")
object TS {
    interface Path2 {
        val __pathBrand: Any
    }

    interface FileMap<T> {
        fun get(fileName: String /* Path */): T
        fun get(fileName: Path2 /* Path */): T
        fun set(fileName: String /* Path */, value: T)
        fun set(fileName: Path2 /* Path */, value: T)
        fun contains(fileName: String /* Path */): Boolean
        fun contains(fileName: Path2 /* Path */): Boolean
        fun remove(fileName: String /* Path */)
        fun remove(fileName: Path2 /* Path */)
        fun forEachValue(f: (key: String /* Path */, v: T) -> Unit)
        fun forEachValue(f: (key: Path2 /* Path */, v: T) -> Unit)
        fun clear()
    }

    interface TextRange {
        var pos: Number
        var end: Number
    }

    @native("ts.SyntaxKind")
    enum class SyntaxKind {
        Unknown /* = 0 */,
        EndOfFileToken /* = 1 */,
        SingleLineCommentTrivia /* = 2 */,
        MultiLineCommentTrivia /* = 3 */,
        NewLineTrivia /* = 4 */,
        WhitespaceTrivia /* = 5 */,
        ShebangTrivia /* = 6 */,
        ConflictMarkerTrivia /* = 7 */,
        NumericLiteral /* = 8 */,
        StringLiteral /* = 9 */,
        RegularExpressionLiteral /* = 10 */,
        NoSubstitutionTemplateLiteral /* = 11 */,
        TemplateHead /* = 12 */,
        TemplateMiddle /* = 13 */,
        TemplateTail /* = 14 */,
        OpenBraceToken /* = 15 */,
        CloseBraceToken /* = 16 */,
        OpenParenToken /* = 17 */,
        CloseParenToken /* = 18 */,
        OpenBracketToken /* = 19 */,
        CloseBracketToken /* = 20 */,
        DotToken /* = 21 */,
        DotDotDotToken /* = 22 */,
        SemicolonToken /* = 23 */,
        CommaToken /* = 24 */,
        LessThanToken /* = 25 */,
        LessThanSlashToken /* = 26 */,
        GreaterThanToken /* = 27 */,
        LessThanEqualsToken /* = 28 */,
        GreaterThanEqualsToken /* = 29 */,
        EqualsEqualsToken /* = 30 */,
        ExclamationEqualsToken /* = 31 */,
        EqualsEqualsEqualsToken /* = 32 */,
        ExclamationEqualsEqualsToken /* = 33 */,
        EqualsGreaterThanToken /* = 34 */,
        PlusToken /* = 35 */,
        MinusToken /* = 36 */,
        AsteriskToken /* = 37 */,
        AsteriskAsteriskToken /* = 38 */,
        SlashToken /* = 39 */,
        PercentToken /* = 40 */,
        PlusPlusToken /* = 41 */,
        MinusMinusToken /* = 42 */,
        LessThanLessThanToken /* = 43 */,
        GreaterThanGreaterThanToken /* = 44 */,
        GreaterThanGreaterThanGreaterThanToken /* = 45 */,
        AmpersandToken /* = 46 */,
        BarToken /* = 47 */,
        CaretToken /* = 48 */,
        ExclamationToken /* = 49 */,
        TildeToken /* = 50 */,
        AmpersandAmpersandToken /* = 51 */,
        BarBarToken /* = 52 */,
        QuestionToken /* = 53 */,
        ColonToken /* = 54 */,
        AtToken /* = 55 */,
        EqualsToken /* = 56 */,
        PlusEqualsToken /* = 57 */,
        MinusEqualsToken /* = 58 */,
        AsteriskEqualsToken /* = 59 */,
        AsteriskAsteriskEqualsToken /* = 60 */,
        SlashEqualsToken /* = 61 */,
        PercentEqualsToken /* = 62 */,
        LessThanLessThanEqualsToken /* = 63 */,
        GreaterThanGreaterThanEqualsToken /* = 64 */,
        GreaterThanGreaterThanGreaterThanEqualsToken /* = 65 */,
        AmpersandEqualsToken /* = 66 */,
        BarEqualsToken /* = 67 */,
        CaretEqualsToken /* = 68 */,
        Identifier /* = 69 */,
        BreakKeyword /* = 70 */,
        CaseKeyword /* = 71 */,
        CatchKeyword /* = 72 */,
        ClassKeyword /* = 73 */,
        ConstKeyword /* = 74 */,
        ContinueKeyword /* = 75 */,
        DebuggerKeyword /* = 76 */,
        DefaultKeyword /* = 77 */,
        DeleteKeyword /* = 78 */,
        DoKeyword /* = 79 */,
        ElseKeyword /* = 80 */,
        EnumKeyword /* = 81 */,
        ExportKeyword /* = 82 */,
        ExtendsKeyword /* = 83 */,
        FalseKeyword /* = 84 */,
        FinallyKeyword /* = 85 */,
        ForKeyword /* = 86 */,
        FunctionKeyword /* = 87 */,
        IfKeyword /* = 88 */,
        ImportKeyword /* = 89 */,
        InKeyword /* = 90 */,
        InstanceOfKeyword /* = 91 */,
        NewKeyword /* = 92 */,
        NullKeyword /* = 93 */,
        ReturnKeyword /* = 94 */,
        SuperKeyword /* = 95 */,
        SwitchKeyword /* = 96 */,
        ThisKeyword /* = 97 */,
        ThrowKeyword /* = 98 */,
        TrueKeyword /* = 99 */,
        TryKeyword /* = 100 */,
        TypeOfKeyword /* = 101 */,
        VarKeyword /* = 102 */,
        VoidKeyword /* = 103 */,
        WhileKeyword /* = 104 */,
        WithKeyword /* = 105 */,
        ImplementsKeyword /* = 106 */,
        InterfaceKeyword /* = 107 */,
        LetKeyword /* = 108 */,
        PackageKeyword /* = 109 */,
        PrivateKeyword /* = 110 */,
        ProtectedKeyword /* = 111 */,
        PublicKeyword /* = 112 */,
        StaticKeyword /* = 113 */,
        YieldKeyword /* = 114 */,
        AbstractKeyword /* = 115 */,
        AsKeyword /* = 116 */,
        AnyKeyword /* = 117 */,
        AsyncKeyword /* = 118 */,
        AwaitKeyword /* = 119 */,
        BooleanKeyword /* = 120 */,
        ConstructorKeyword /* = 121 */,
        DeclareKeyword /* = 122 */,
        GetKeyword /* = 123 */,
        IsKeyword /* = 124 */,
        ModuleKeyword /* = 125 */,
        NamespaceKeyword /* = 126 */,
        RequireKeyword /* = 127 */,
        NumberKeyword /* = 128 */,
        SetKeyword /* = 129 */,
        StringKeyword /* = 130 */,
        SymbolKeyword /* = 131 */,
        TypeKeyword /* = 132 */,
        FromKeyword /* = 133 */,
        GlobalKeyword /* = 134 */,
        OfKeyword /* = 135 */,
        QualifiedName /* = 136 */,
        ComputedPropertyName /* = 137 */,
        TypeParameter /* = 138 */,
        Parameter /* = 139 */,
        Decorator /* = 140 */,
        PropertySignature /* = 141 */,
        PropertyDeclaration /* = 142 */,
        MethodSignature /* = 143 */,
        MethodDeclaration /* = 144 */,
        Constructor /* = 145 */,
        GetAccessor /* = 146 */,
        SetAccessor /* = 147 */,
        CallSignature /* = 148 */,
        ConstructSignature /* = 149 */,
        IndexSignature /* = 150 */,
        TypePredicate /* = 151 */,
        TypeReference /* = 152 */,
        FunctionType /* = 153 */,
        ConstructorType /* = 154 */,
        TypeQuery /* = 155 */,
        TypeLiteral /* = 156 */,
        ArrayType /* = 157 */,
        TupleType /* = 158 */,
        UnionType /* = 159 */,
        IntersectionType /* = 160 */,
        ParenthesizedType /* = 161 */,
        ThisType /* = 162 */,
        StringLiteralType /* = 163 */,
        ObjectBindingPattern /* = 164 */,
        ArrayBindingPattern /* = 165 */,
        BindingElement /* = 166 */,
        ArrayLiteralExpression /* = 167 */,
        ObjectLiteralExpression /* = 168 */,
        PropertyAccessExpression /* = 169 */,
        ElementAccessExpression /* = 170 */,
        CallExpression /* = 171 */,
        NewExpression /* = 172 */,
        TaggedTemplateExpression /* = 173 */,
        TypeAssertionExpression /* = 174 */,
        ParenthesizedExpression /* = 175 */,
        FunctionExpression /* = 176 */,
        ArrowFunction /* = 177 */,
        DeleteExpression /* = 178 */,
        TypeOfExpression /* = 179 */,
        VoidExpression /* = 180 */,
        AwaitExpression /* = 181 */,
        PrefixUnaryExpression /* = 182 */,
        PostfixUnaryExpression /* = 183 */,
        BinaryExpression /* = 184 */,
        ConditionalExpression /* = 185 */,
        TemplateExpression /* = 186 */,
        YieldExpression /* = 187 */,
        SpreadElementExpression /* = 188 */,
        ClassExpression /* = 189 */,
        OmittedExpression /* = 190 */,
        ExpressionWithTypeArguments /* = 191 */,
        AsExpression /* = 192 */,
        TemplateSpan /* = 193 */,
        SemicolonClassElement /* = 194 */,
        Block /* = 195 */,
        VariableStatement /* = 196 */,
        EmptyStatement /* = 197 */,
        ExpressionStatement /* = 198 */,
        IfStatement /* = 199 */,
        DoStatement /* = 200 */,
        WhileStatement /* = 201 */,
        ForStatement /* = 202 */,
        ForInStatement /* = 203 */,
        ForOfStatement /* = 204 */,
        ContinueStatement /* = 205 */,
        BreakStatement /* = 206 */,
        ReturnStatement /* = 207 */,
        WithStatement /* = 208 */,
        SwitchStatement /* = 209 */,
        LabeledStatement /* = 210 */,
        ThrowStatement /* = 211 */,
        TryStatement /* = 212 */,
        DebuggerStatement /* = 213 */,
        VariableDeclaration /* = 214 */,
        VariableDeclarationList /* = 215 */,
        FunctionDeclaration /* = 216 */,
        ClassDeclaration /* = 217 */,
        InterfaceDeclaration /* = 218 */,
        TypeAliasDeclaration /* = 219 */,
        EnumDeclaration /* = 220 */,
        ModuleDeclaration /* = 221 */,
        ModuleBlock /* = 222 */,
        CaseBlock /* = 223 */,
        ImportEqualsDeclaration /* = 224 */,
        ImportDeclaration /* = 225 */,
        ImportClause /* = 226 */,
        NamespaceImport /* = 227 */,
        NamedImports /* = 228 */,
        ImportSpecifier /* = 229 */,
        ExportAssignment /* = 230 */,
        ExportDeclaration /* = 231 */,
        NamedExports /* = 232 */,
        ExportSpecifier /* = 233 */,
        MissingDeclaration /* = 234 */,
        ExternalModuleReference /* = 235 */,
        JsxElement /* = 236 */,
        JsxSelfClosingElement /* = 237 */,
        JsxOpeningElement /* = 238 */,
        JsxText /* = 239 */,
        JsxClosingElement /* = 240 */,
        JsxAttribute /* = 241 */,
        JsxSpreadAttribute /* = 242 */,
        JsxExpression /* = 243 */,
        CaseClause /* = 244 */,
        DefaultClause /* = 245 */,
        HeritageClause /* = 246 */,
        CatchClause /* = 247 */,
        PropertyAssignment /* = 248 */,
        ShorthandPropertyAssignment /* = 249 */,
        EnumMember /* = 250 */,
        SourceFile /* = 251 */,
        JSDocTypeExpression /* = 252 */,
        JSDocAllType /* = 253 */,
        JSDocUnknownType /* = 254 */,
        JSDocArrayType /* = 255 */,
        JSDocUnionType /* = 256 */,
        JSDocTupleType /* = 257 */,
        JSDocNullableType /* = 258 */,
        JSDocNonNullableType /* = 259 */,
        JSDocRecordType /* = 260 */,
        JSDocRecordMember /* = 261 */,
        JSDocTypeReference /* = 262 */,
        JSDocOptionalType /* = 263 */,
        JSDocFunctionType /* = 264 */,
        JSDocVariadicType /* = 265 */,
        JSDocConstructorType /* = 266 */,
        JSDocThisType /* = 267 */,
        JSDocComment /* = 268 */,
        JSDocTag /* = 269 */,
        JSDocParameterTag /* = 270 */,
        JSDocReturnTag /* = 271 */,
        JSDocTypeTag /* = 272 */,
        JSDocTemplateTag /* = 273 */,
        SyntaxList /* = 274 */,
        Count /* = 275 */,
        FirstAssignment /* = 56 */,
        LastAssignment /* = 68 */,
        FirstReservedWord /* = 70 */,
        LastReservedWord /* = 105 */,
        FirstKeyword /* = 70 */,
        LastKeyword /* = 135 */,
        FirstFutureReservedWord /* = 106 */,
        LastFutureReservedWord /* = 114 */,
        FirstTypeNode /* = 151 */,
        LastTypeNode /* = 163 */,
        FirstPunctuation /* = 15 */,
        LastPunctuation /* = 68 */,
        FirstToken /* = 0 */,
        LastToken /* = 135 */,
        FirstTriviaToken /* = 2 */,
        LastTriviaToken /* = 7 */,
        FirstLiteralToken /* = 8 */,
        LastLiteralToken /* = 11 */,
        FirstTemplateToken /* = 11 */,
        LastTemplateToken /* = 14 */,
        FirstBinaryOperator /* = 25 */,
        LastBinaryOperator /* = 68 */,
        FirstNode /* = 136 */
    }

    @native("ts.NodeFlags")
    enum class NodeFlags {
        None /* = 0 */,
        Export /* = 2 */,
        Ambient /* = 4 */,
        Public /* = 8 */,
        Private /* = 16 */,
        Protected /* = 32 */,
        Static /* = 64 */,
        Abstract /* = 128 */,
        Async /* = 256 */,
        Default /* = 512 */,
        MultiLine /* = 1024 */,
        Synthetic /* = 2048 */,
        DeclarationFile /* = 4096 */,
        Let /* = 8192 */,
        Const /* = 16384 */,
        OctalLiteral /* = 32768 */,
        Namespace /* = 65536 */,
        ExportContext /* = 131072 */,
        ContainsThis /* = 262144 */,
        HasImplicitReturn /* = 524288 */,
        HasExplicitReturn /* = 1048576 */,
        GlobalAugmentation /* = 2097152 */,
        HasClassExtends /* = 4194304 */,
        HasDecorators /* = 8388608 */,
        HasParamDecorators /* = 16777216 */,
        HasAsyncFunctions /* = 33554432 */,
        HasJsxSpreadAttribute /* = 1073741824 */,
        Modifier /* = 1022 */,
        AccessibilityModifier /* = 56 */,
        BlockScoped /* = 24576 */,
        ReachabilityCheckFlags /* = 1572864 */,
        EmitHelperFlags /* = 62914560 */
    }

    @native("ts.JsxFlags")
    enum class JsxFlags {
        None /* = 0 */,
        IntrinsicNamedElement /* = 1 */,
        IntrinsicIndexedElement /* = 2 */,
        ValueElement /* = 4 */,
        UnknownElement /* = 16 */,
        IntrinsicElement /* = 3 */
    }

    @native("ts.Node")
    interface Node : TextRange {
        var kind: SyntaxKind
        var flags: NodeFlags
        var decorators: NodeArray<Decorator>? // = noImpl
        var modifiers: ModifiersArray? // = noImpl
        var parent: Node? // = noImpl

        fun getSourceFile(): SourceFile
        fun getChildCount(sourceFile: SourceFile?): Number
        fun getChildAt(index: Number, sourceFile: SourceFile?): Node
        fun getChildren(sourceFile: SourceFile?): Array<Node>
        fun getStart(sourceFile: SourceFile?): Number
        fun getFullStart(): Number
        fun getEnd(): Number
        fun getWidth(sourceFile: SourceFile?): Number
        fun getFullWidth(): Number
        fun getLeadingTriviaWidth(sourceFile: SourceFile?): Number
        fun getFullText(sourceFile: SourceFile?): String
        fun getText(sourceFile: SourceFile?): String
        fun getFirstToken(sourceFile: SourceFile?): Node
        fun getLastToken(sourceFile: SourceFile?): Node
    }

    interface NodeArray<T> : JsArray<T>, TextRange {
        var hasTrailingComma: Boolean? // = noImpl
    }

    interface ModifiersArray : NodeArray<Modifier> {
        var flags: Number
    }

    interface Modifier : Node

    interface Identifier : PrimaryExpression {
        /*override */var text: String
        var originalKeywordKind: SyntaxKind? // = noImpl
    }

    interface QualifiedName : Node {
        var left: EntityName
        var right: Identifier
    }

    interface EntityName : TS.Identifier, TS.QualifiedName
    interface PropertyName : Identifier, LiteralExpression, ComputedPropertyName
    interface DeclarationName : Identifier, LiteralExpression, ComputedPropertyName, BindingPattern

    interface Declaration : Node {
        var _declarationBrand: Any
        @native("name")
        val declarationName: DeclarationName? // = noImpl
    }

    interface DeclarationStatement : Declaration, Statement {
        @native("name")
        /*override*/ val identifierName: Identifier? // = noImpl
    }

    interface ComputedPropertyName : Node {
        var expression: Expression
    }

    interface Decorator : Node {
        var expression: LeftHandSideExpression
    }

    interface TypeParameterDeclaration : Declaration {
        @native("name")
        /*override*/ var identifierName: Identifier
        var constraint: TypeNode? // = noImpl
        var expression: Expression? // = noImpl
    }

    interface SignatureDeclaration : Declaration {
        @native("name")
        /*override*/ val propertyName: PropertyName? // = noImpl
        var typeParameters: NodeArray<TypeParameterDeclaration>? // = noImpl
        var parameters: NodeArray<ParameterDeclaration>
        var type: TypeNode? // = noImpl
    }

    interface CallSignatureDeclaration : SignatureDeclaration, TypeElement

    interface ConstructSignatureDeclaration : SignatureDeclaration, TypeElement

    interface VariableDeclaration : Declaration {
//        override var parent: VariableDeclarationList? // = noImpl
        @native("name")
        /*override*/ var dynamicName: dynamic /* Identifier | BindingPattern */
        var type: TypeNode? // = noImpl
        var initializer: Expression? // = noImpl
    }

    interface VariableDeclarationList : Node {
        var declarations: NodeArray<VariableDeclaration>
    }

    interface ParameterDeclaration : Declaration {
        var dotDotDotToken: Node? // = noImpl
        @native("name")
        /*override*/ var dynamicName: dynamic /* Identifier | BindingPattern */
        var questionToken: Node? // = noImpl
        var type: TypeNode? // = noImpl
        var initializer: Expression? // = noImpl
    }

    interface BindingElement : Declaration {
        var propertyName: PropertyName? // = noImpl
        var dotDotDotToken: Node? // = noImpl
        @native("name")
        /*override*/ var dynamicName: dynamic /* Identifier | BindingPattern */
        var initializer: Expression? // = noImpl
    }

    interface PropertySignature : TypeElement {
        override val propertyName: PropertyName
        override var questionToken: Node? // = noImpl
        var type: TypeNode? // = noImpl
        var initializer: Expression? // = noImpl
    }

    interface PropertyDeclaration : ClassElement {
        var questionToken: Node? // = noImpl
        override val propertyName: PropertyName
        var type: TypeNode? // = noImpl
        var initializer: Expression? // = noImpl
    }

    interface ObjectLiteralElement : Declaration {
        var _objectLiteralBrandBrand: Any
        @native("name")
        /*override*/ val propertyName: PropertyName? // = noImpl
    }

    interface PropertyAssignment : ObjectLiteralElement {
        var _propertyAssignmentBrand: Any
        override val propertyName: PropertyName
        var questionToken: Node? // = noImpl
        var initializer: Expression
    }

    interface ShorthandPropertyAssignment : ObjectLiteralElement {
        @native("name")
        /*override*/ val identifierName: Identifier //TODO extra space
        var questionToken: Node? // = noImpl
        var equalsToken: Node? // = noImpl
        var objectAssignmentInitializer: Expression? // = noImpl
    }

    interface VariableLikeDeclaration : Declaration {
        var propertyName: PropertyName? // = noImpl
        var dotDotDotToken: Node? // = noImpl
        override val declarationName: DeclarationName
        var questionToken: Node? // = noImpl
        var type: TypeNode? // = noImpl
        var initializer: Expression? // = noImpl
    }

    interface PropertyLikeDeclaration : Declaration {
        @native("name")
        /*override*/ var propertyName: PropertyName
    }

    interface BindingPattern : Node {
        var elements: NodeArray<BindingElement>
    }

    interface ObjectBindingPattern : BindingPattern

    interface ArrayBindingPattern : BindingPattern

    interface FunctionLikeDeclaration : SignatureDeclaration {
        var _functionLikeDeclarationBrand: Any
        var asteriskToken: Node? // = noImpl
        var questionToken: Node? // = noImpl
        var body: dynamic /* Block | Expression */? // = noImpl // TODO
    }

    interface FunctionDeclaration : FunctionLikeDeclaration, DeclarationStatement {
        override var identifierName: Identifier? // = noImpl
        override var body: FunctionBody? // = noImpl
    }

    interface MethodSignature : SignatureDeclaration, TypeElement {
        override val propertyName: PropertyName
    }

    interface MethodDeclaration : FunctionLikeDeclaration, ClassElement, ObjectLiteralElement {
        override var propertyName: PropertyName
        override var body: FunctionBody? // = noImpl
    }

    interface ConstructorDeclaration : FunctionLikeDeclaration, ClassElement {
        override var body: FunctionBody? // = noImpl
    }

    interface SemicolonClassElement : ClassElement {
        var _semicolonClassElementBrand: Any
    }

    interface AccessorDeclaration : FunctionLikeDeclaration, ClassElement, ObjectLiteralElement {
        var _accessorDeclarationBrand: Any
        override var propertyName: PropertyName
        override var body: FunctionBody
    }

    interface GetAccessorDeclaration : AccessorDeclaration

    interface SetAccessorDeclaration : AccessorDeclaration

    interface IndexSignatureDeclaration : SignatureDeclaration, ClassElement, TypeElement {
        var _indexSignatureDeclarationBrand: Any
    }

    interface TypeNode : Node {
        var _typeNodeBrand: Any
    }

    interface ThisTypeNode : TypeNode {
        var _thisTypeNodeBrand: Any
    }

    interface FunctionOrConstructorTypeNode : TypeNode, SignatureDeclaration {
        var _functionOrConstructorTypeNodeBrand: Any
    }

    interface FunctionTypeNode : FunctionOrConstructorTypeNode

    interface ConstructorTypeNode : FunctionOrConstructorTypeNode

    interface TypeReferenceNode : TypeNode {
        var typeName: EntityName
        var typeArguments: NodeArray<TypeNode>? // = noImpl
    }

    interface TypePredicateNode : TypeNode {
        var parameterName: dynamic /* Identifier | ThisTypeNode */
        var type: TypeNode
    }

    interface TypeQueryNode : TypeNode {
        var exprName: EntityName
    }

    interface TypeLiteralNode : TypeNode, Declaration {
        var members: NodeArray<TypeElement>
    }

    interface ArrayTypeNode : TypeNode {
        var elementType: TypeNode
    }

    interface TupleTypeNode : TypeNode {
        var elementTypes: NodeArray<TypeNode>
    }

    interface UnionOrIntersectionTypeNode : TypeNode {
        var types: NodeArray<TypeNode>
    }

    interface UnionTypeNode : UnionOrIntersectionTypeNode

    interface IntersectionTypeNode : UnionOrIntersectionTypeNode

    interface ParenthesizedTypeNode : TypeNode {
        var type: TypeNode
    }

    interface StringLiteralTypeNode : LiteralLikeNode, TypeNode {
        var _stringLiteralTypeBrand: Any
    }

    interface StringLiteral : LiteralExpression {
        var _stringLiteralBrand: Any
    }

    interface Expression : Node {
        var _expressionBrand: Any
        var contextualType: Type? // = noImpl
    }

    interface OmittedExpression : Expression

    interface UnaryExpression : Expression {
        var _unaryExpressionBrand: Any
    }

    interface IncrementExpression : UnaryExpression {
        var _incrementExpressionBrand: Any
    }

    interface PrefixUnaryExpression : IncrementExpression {
        var operator: SyntaxKind
        var operand: UnaryExpression
    }

    interface PostfixUnaryExpression : IncrementExpression {
        var operand: LeftHandSideExpression
        var operator: SyntaxKind
    }

    interface PostfixExpression : UnaryExpression {
        var _postfixExpressionBrand: Any
    }

    interface LeftHandSideExpression : IncrementExpression {
        var _leftHandSideExpressionBrand: Any
    }

    interface MemberExpression : LeftHandSideExpression {
        var _memberExpressionBrand: Any
    }

    interface PrimaryExpression : MemberExpression {
        var _primaryExpressionBrand: Any
    }

    interface DeleteExpression : UnaryExpression {
        var expression: UnaryExpression
    }

    interface TypeOfExpression : UnaryExpression {
        var expression: UnaryExpression
    }

    interface VoidExpression : UnaryExpression {
        var expression: UnaryExpression
    }

    interface AwaitExpression : UnaryExpression {
        var expression: UnaryExpression
    }

    interface YieldExpression : Expression {
        var asteriskToken: Node? // = noImpl
        var expression: Expression? // = noImpl
    }

    interface BinaryExpression : Expression, Declaration {
        var left: Expression
        var operatorToken: Node
        var right: Expression
    }

    interface ConditionalExpression : Expression {
        var condition: Expression
        var questionToken: Node
        var whenTrue: Expression
        var colonToken: Node
        var whenFalse: Expression
    }

    interface FunctionBody : Block
    interface ConciseBody : FunctionBody, Expression

    interface FunctionExpression : PrimaryExpression, FunctionLikeDeclaration {
        @native("name")
        /*override*/ var identifierName: Identifier? // = noImpl
        override var body: FunctionBody
    }

    interface ArrowFunction : Expression, FunctionLikeDeclaration {
        var equalsGreaterThanToken: Node
        override var body: ConciseBody
    }

    interface LiteralLikeNode : Node {
        /*override */var text: String
        var isUnterminated: Boolean? // = noImpl
        var hasExtendedUnicodeEscape: Boolean? // = noImpl
    }

    interface LiteralExpression : LiteralLikeNode, PrimaryExpression {
        var _literalExpressionBrand: Any
    }

    interface TemplateLiteralFragment : LiteralLikeNode {
        var _templateLiteralFragmentBrand: Any
    }

    interface TemplateExpression : PrimaryExpression {
        var head: TemplateLiteralFragment
        var templateSpans: NodeArray<TemplateSpan>
    }

    interface TemplateSpan : Node {
        var expression: Expression
        var literal: TemplateLiteralFragment
    }

    interface ParenthesizedExpression : PrimaryExpression {
        var expression: Expression
    }

    interface ArrayLiteralExpression : PrimaryExpression {
        var elements: NodeArray<Expression>
    }

    interface SpreadElementExpression : Expression {
        var expression: Expression
    }

    interface ObjectLiteralExpression : PrimaryExpression, Declaration {
        var properties: NodeArray<ObjectLiteralElement>
    }

    interface PropertyAccessExpression : MemberExpression, Declaration {
        var expression: LeftHandSideExpression?
        var dotToken: Node
        @native("name")
        /*override*/ var identifierName: Identifier
    }

    interface ElementAccessExpression : MemberExpression {
        var expression: LeftHandSideExpression
        var argumentExpression: Expression? // = noImpl
    }

    interface CallExpression : LeftHandSideExpression, Declaration {
        var expression: LeftHandSideExpression
        var typeArguments: NodeArray<TypeNode>? // = noImpl
        var arguments: NodeArray<Expression>
    }

    interface ExpressionWithTypeArguments : TypeNode {
        var expression: LeftHandSideExpression
        var typeArguments: NodeArray<TypeNode>? // = noImpl
    }

    interface NewExpression : CallExpression, PrimaryExpression

    interface TaggedTemplateExpression : MemberExpression {
        var tag: LeftHandSideExpression
        var template: dynamic /* LiteralExpression | TemplateExpression */
    }

    interface CallLikeExpression : CallExpression, NewExpression, TaggedTemplateExpression, Decorator

    interface AsExpression : Expression {
        var expression: Expression
        var type: TypeNode
    }

    interface TypeAssertion : UnaryExpression {
        var type: TypeNode
        var expression: UnaryExpression
    }

    interface JsxElement : PrimaryExpression {
        var openingElement: JsxOpeningElement
        var children: NodeArray<JsxChild>
        var closingElement: JsxClosingElement
    }

    interface JsxOpeningElement : Expression {
        var _openingElementBrand: Any? // = noImpl
        var tagName: EntityName
        /*override */var attributes: NodeArray<dynamic /* JsxAttribute | JsxSpreadAttribute */>
    }

    interface JsxSelfClosingElement : PrimaryExpression, JsxOpeningElement {
        var _selfClosingElementBrand: Any? // = noImpl
    }

    interface JsxAttribute : Node {
        @native("name")
        var identifierName: Identifier
        var initializer: Expression? // = noImpl
    }

    interface JsxSpreadAttribute : Node {
        var expression: Expression
    }

    interface JsxClosingElement : Node {
        var tagName: EntityName
    }

    interface JsxExpression : Expression {
        var expression: Expression? // = noImpl
    }

    interface JsxText : Node {
        var _jsxTextExpressionBrand: Any
    }

    interface JsxChild : JsxText, JsxExpression, JsxElement, JsxSelfClosingElement

    interface Statement : Node {
        var _statementBrand: Any
    }

    interface EmptyStatement : Statement

    interface DebuggerStatement : Statement

    interface MissingDeclaration : DeclarationStatement, ClassElement, ObjectLiteralElement, TypeElement {
        override var identifierName: Identifier? // = noImpl
    }

    interface Block : Statement {
        var statements: NodeArray<Statement>
    }

    interface VariableStatement : Statement {
        var declarationList: VariableDeclarationList
    }

    interface ExpressionStatement : Statement {
        var expression: Expression
    }

    interface IfStatement : Statement {
        var expression: Expression
        var thenStatement: Statement
        var elseStatement: Statement? // = noImpl
    }

    interface IterationStatement : Statement {
        var statement: Statement
    }

    interface DoStatement : IterationStatement {
        var expression: Expression
    }

    interface WhileStatement : IterationStatement {
        var expression: Expression
    }

    interface ForStatement : IterationStatement {
        var initializer: dynamic /* VariableDeclarationList | Expression */? // = noImpl
        var condition: Expression? // = noImpl
        var incrementor: Expression? // = noImpl
    }

    interface ForInStatement : IterationStatement {
        var initializer: dynamic /* VariableDeclarationList | Expression */
        var expression: Expression
    }

    interface ForOfStatement : IterationStatement {
        var initializer: dynamic /* VariableDeclarationList | Expression */
        var expression: Expression
    }

    interface BreakStatement : Statement {
        var label: Identifier? // = noImpl
    }

    interface ContinueStatement : Statement {
        var label: Identifier? // = noImpl
    }

    interface ReturnStatement : Statement {
        var expression: Expression? // = noImpl
    }

    interface WithStatement : Statement {
        var expression: Expression
        var statement: Statement
    }

    interface SwitchStatement : Statement {
        var expression: Expression
        var caseBlock: CaseBlock
    }

    interface CaseBlock : Node {
        var clauses: NodeArray<CaseOrDefaultClause>
    }

    interface CaseClause : Node {
        var expression: Expression
        var statements: NodeArray<Statement>
    }

    interface DefaultClause : Node {
        var statements: NodeArray<Statement>
    }

    interface CaseOrDefaultClause : CaseClause, DefaultClause;

    interface LabeledStatement : Statement {
        var label: Identifier
        var statement: Statement
    }

    interface ThrowStatement : Statement {
        var expression: Expression
    }

    interface TryStatement : Statement {
        var tryBlock: Block
        var catchClause: CatchClause? // = noImpl
        var finallyBlock: Block? // = noImpl
    }

    interface CatchClause : Node {
        var variableDeclaration: VariableDeclaration
        var block: Block
    }

    interface ClassLikeDeclaration : Declaration {
        @native("name")
        /*override*/ var identifierName: Identifier? // = noImpl
        var typeParameters: NodeArray<TypeParameterDeclaration>? // = noImpl
        var heritageClauses: NodeArray<HeritageClause>? // = noImpl
        var members: NodeArray<ClassElement>
    }

    interface ClassDeclaration : ClassLikeDeclaration, DeclarationStatement {
        override var identifierName: Identifier? // = noImpl
    }

    interface ClassExpression : ClassLikeDeclaration, PrimaryExpression

    interface ClassElement : Declaration {
        var _classElementBrand: Any
        @native("name")
        /*override*/ val propertyName: PropertyName? // = noImpl
    }

    interface TypeElement : Declaration {
        var _typeElementBrand: Any
        @native("name")
        /*override*/ val propertyName: PropertyName? // = noImpl
        var questionToken: Node? // = noImpl
    }

    interface InterfaceDeclaration : DeclarationStatement {
        override val identifierName: Identifier
        var typeParameters: NodeArray<TypeParameterDeclaration>? // = noImpl
        var heritageClauses: NodeArray<HeritageClause>? // = noImpl
        var members: NodeArray<TypeElement>
    }

    interface HeritageClause : Node {
        var token: SyntaxKind
        var types: NodeArray<ExpressionWithTypeArguments>? // = noImpl
    }

    interface TypeAliasDeclaration : DeclarationStatement {
        override var identifierName: Identifier
        var typeParameters: NodeArray<TypeParameterDeclaration>? // = noImpl
        var type: TypeNode
    }

    interface EnumMember : Declaration {
        override val declarationName: DeclarationName
        var initializer: Expression? // = noImpl
    }

    interface EnumDeclaration : DeclarationStatement {
        override var identifierName: Identifier
        var members: NodeArray<EnumMember>
    }

    interface ModuleDeclaration : DeclarationStatement {
        @native("name")
        /*override*/ var dynamicName: dynamic /* Identifier | LiteralExpression */
        var body: dynamic /* ModuleBlock | ModuleDeclaration */
    }

    interface ModuleBlock : Node, Statement {
        var statements: NodeArray<Statement>
    }

    interface ImportEqualsDeclaration : DeclarationStatement {
        override var identifierName: Identifier
        var moduleReference: dynamic /* EntityName | ExternalModuleReference */
    }

    interface ExternalModuleReference : Node {
        var expression: Expression? // = noImpl
    }

    interface ImportDeclaration : Statement {
        var importClause: ImportClause? // = noImpl
        var moduleSpecifier: Expression
    }

    interface ImportClause : Declaration {
        @native("name")
        /*override*/ var identifierName: Identifier? // = noImpl
        var namedBindings: dynamic /* NamespaceImport | NamedImports */? // = noImpl
    }

    interface NamespaceImport : Declaration {
        @native("name")
        /*override*/ var identifierName: Identifier
    }

    interface ExportDeclaration : DeclarationStatement {
        var exportClause: NamedExports? // = noImpl
        var moduleSpecifier: Expression? // = noImpl
    }

    interface NamedImports : Node {
        var elements: NodeArray<ImportSpecifier>
    }

    interface NamedExports : Node {
        var elements: NodeArray<ExportSpecifier>
    }

    interface ImportSpecifier : Declaration {
        var propertyName: Identifier? // = noImpl
        @native("name")
        /*override*/ var identifierName: Identifier
    }

    interface ExportSpecifier : Declaration {
        var propertyName: Identifier? // = noImpl
        @native("name")
        /*override*/ var identifierName: Identifier
    }

    interface ExportAssignment : DeclarationStatement {
        var isExportEquals: Boolean? // = noImpl
        var expression: Expression
    }

    interface FileReference : TextRange {
        var fileName: String
    }

    interface CommentRange : TextRange {
        var hasTrailingNewLine: Boolean? // = noImpl
        var kind: SyntaxKind
    }

    interface JSDocTypeExpression : Node {
        var type: JSDocType
    }

    interface JSDocType : TypeNode {
        var _jsDocTypeBrand: Any
    }

    interface JSDocAllType : JSDocType {
        var _JSDocAllTypeBrand: Any
    }

    interface JSDocUnknownType : JSDocType {
        var _JSDocUnknownTypeBrand: Any
    }

    interface JSDocArrayType : JSDocType {
        var elementType: JSDocType
    }

    interface JSDocUnionType : JSDocType {
        var types: NodeArray<JSDocType>
    }

    interface JSDocTupleType : JSDocType {
        var types: NodeArray<JSDocType>
    }

    interface JSDocNonNullableType : JSDocType {
        var type: JSDocType
    }

    interface JSDocNullableType : JSDocType {
        var type: JSDocType
    }

    interface JSDocRecordType : JSDocType, TypeLiteralNode {
//        override var members: NodeArray<JSDocRecordMember>
    }

    interface JSDocTypeReference : JSDocType {
        var name: EntityName
        var typeArguments: NodeArray<JSDocType>
    }

    interface JSDocOptionalType : JSDocType {
        var type: JSDocType
    }

    interface JSDocFunctionType : JSDocType, SignatureDeclaration {
        override var parameters: NodeArray<ParameterDeclaration>
//        override var type: JSDocType
    }

    interface JSDocVariadicType : JSDocType {
        var type: JSDocType
    }

    interface JSDocConstructorType : JSDocType {
        var type: JSDocType
    }

    interface JSDocThisType : JSDocType {
        var type: JSDocType
    }

    interface JSDocRecordMember : PropertySignature {
        override var propertyName: dynamic /* Identifier | LiteralExpression */
//        override var type: JSDocType? // = noImpl
    }

    interface JSDocComment : Node {
        var tags: NodeArray<JSDocTag>
    }

    interface JSDocTag : Node {
        var atToken: Node
        var tagName: Identifier
    }

    interface JSDocTemplateTag : JSDocTag {
        var typeParameters: NodeArray<TypeParameterDeclaration>
    }

    interface JSDocReturnTag : JSDocTag {
        var typeExpression: JSDocTypeExpression
    }

    interface JSDocTypeTag : JSDocTag {
        var typeExpression: JSDocTypeExpression
    }

    interface JSDocParameterTag : JSDocTag {
        var preParameterName: Identifier? // = noImpl
        var typeExpression: JSDocTypeExpression? // = noImpl
        var postParameterName: Identifier? // = noImpl
        var isBracketed: Boolean
    }

    interface AmdDependency {
        var path: String
        var name: String
    }

    interface SourceFile : Declaration {
        var statements: NodeArray<Statement>
        var endOfFileToken: Node
        var fileName: String
        var path: String /*Path: String | Path2*/
        /*override */var text: String
        var amdDependencies: Array<AmdDependency>
        var moduleName: String
        var referencedFiles: Array<FileReference>
        var languageVariant: LanguageVariant
        var hasNoDefaultLib: Boolean
        var languageVersion: ScriptTarget
        fun getLineAndCharacterOfPosition(pos: Number): LineAndCharacter
        fun getLineStarts(): Array<Number>
        fun getPositionOfLineAndCharacter(line: Number, character: Number): Number
        fun update(newText: String, textChangeRange: TextChangeRange): SourceFile
    }

    interface ScriptReferenceHost {
        fun getCompilerOptions(): CompilerOptions
        fun getSourceFile(fileName: String): SourceFile
        fun getCurrentDirectory(): String
    }

    interface ParseConfigHost {
        fun readDirectory(rootDir: String, extension: String, exclude: Array<String>): Array<String>
    }

    interface WriteFileCallback {
        @nativeInvoke
        fun invoke(fileName: String, data: String, writeByteOrderMark: Boolean, onError: ((message: String) -> Unit)? = null)
    }

    interface CancellationToken {
        fun isCancellationRequested(): Boolean
        fun throwIfCancellationRequested()
    }

    interface Program : ScriptReferenceHost {
        fun getRootFileNames(): Array<String>
        fun getSourceFiles(): Array<SourceFile>
        fun emit(targetSourceFile: SourceFile? = null, writeFile: WriteFileCallback? = null, cancellationToken: CancellationToken? = null): EmitResult
        fun getOptionsDiagnostics(cancellationToken: CancellationToken? = null): Array<Diagnostic>
        fun getGlobalDiagnostics(cancellationToken: CancellationToken? = null): Array<Diagnostic>
        fun getSyntacticDiagnostics(sourceFile: SourceFile? = null, cancellationToken: CancellationToken? = null): Array<Diagnostic>
        fun getSemanticDiagnostics(sourceFile: SourceFile? = null, cancellationToken: CancellationToken? = null): Array<Diagnostic>
        fun getDeclarationDiagnostics(sourceFile: SourceFile? = null, cancellationToken: CancellationToken? = null): Array<Diagnostic>
        fun getTypeChecker(): TypeChecker
    }

    interface SourceMapSpan {
        var emittedLine: Number
        var emittedColumn: Number
        var sourceLine: Number
        var sourceColumn: Number
        var nameIndex: Number? // = noImpl
        var sourceIndex: Number
    }

    interface SourceMapData {
        var sourceMapFilePath: String
        var jsSourceMappingURL: String
        var sourceMapFile: String
        var sourceMapSourceRoot: String
        var sourceMapSources: Array<String>
        var sourceMapSourcesContent: Array<String>? // = noImpl
        var inputSourceFileNames: Array<String>
        var sourceMapNames: Array<String>? // = noImpl
        var sourceMapMappings: String
        var sourceMapDecodedMappings: Array<SourceMapSpan>
    }

    @native("ts.ExitStatus")
    enum class ExitStatus {
        Success /* = 0 */,
        DiagnosticsPresent_OutputsSkipped /* = 1 */,
        DiagnosticsPresent_OutputsGenerated /* = 2 */
    }

    interface EmitResult {
        var emitSkipped: Boolean
        var diagnostics: Array<Diagnostic>
    }

    interface TypeChecker {
        fun getTypeOfSymbolAtLocation(symbol: Symbol, node: Node): Type
        fun getDeclaredTypeOfSymbol(symbol: Symbol): Type
        fun getPropertiesOfType(type: Type): Array<Symbol>
        fun getPropertyOfType(type: Type, propertyName: String): Symbol?
        fun getSignaturesOfType(type: Type, kind: SignatureKind): Array<Signature>
        fun getIndexTypeOfType(type: Type, kind: IndexKind): Type
        fun getBaseTypes(type: InterfaceType): Array<ObjectType>
        fun getReturnTypeOfSignature(signature: Signature): Type
        fun getSymbolsInScope(location: Node, meaning: SymbolFlags): Array<Symbol>
        fun getSymbolAtLocation(node: Node): Symbol
        fun getSymbolsOfParameterPropertyDeclaration(parameter: ParameterDeclaration, parameterName: String): Array<Symbol>
        fun getShorthandAssignmentValueSymbol(location: Node): Symbol
        fun getExportSpecifierLocalTargetSymbol(location: ExportSpecifier): Symbol
        fun getTypeAtLocation(node: Node): Type?
        fun typeToString(type: Type, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null): String
        fun symbolToString(symbol: Symbol, enclosingDeclaration: Node? = null, meaning: SymbolFlags? = null): String
        fun getSymbolDisplayBuilder(): SymbolDisplayBuilder
        fun getFullyQualifiedName(symbol: Symbol): String
        fun getAugmentedPropertiesOfType(type: Type): Array<Symbol>
        fun getRootSymbols(symbol: Symbol): Array<Symbol>
        fun getContextualType(node: Expression): Type
        fun getResolvedSignature(node: CallLikeExpression, candidatesOutArray: Array<Signature>? = null): Signature
        fun getSignatureFromDeclaration(declaration: SignatureDeclaration): Signature
        fun isImplementationOfOverload(node: FunctionLikeDeclaration): Boolean
        fun isUndefinedSymbol(symbol: Symbol): Boolean
        fun isArgumentsSymbol(symbol: Symbol): Boolean
        fun isUnknownSymbol(symbol: Symbol): Boolean
        fun getConstantValue(node: dynamic /* EnumMember | PropertyAccessExpression | ElementAccessExpression */): Number
        fun isValidPropertyAccess(node: dynamic /* PropertyAccessExpression | QualifiedName */, propertyName: String): Boolean
        fun getAliasedSymbol(symbol: Symbol): Symbol
        fun getExportsOfModule(moduleSymbol: Symbol): Array<Symbol>
        fun getJsxElementAttributesType(elementNode: dynamic /*JsxOpeningLikeElement*/): Type
        fun getJsxIntrinsicTagNames(): Array<Symbol>
        fun isOptionalParameter(node: ParameterDeclaration): Boolean
    }

    interface SymbolDisplayBuilder {
        fun buildTypeDisplay(type: Type, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        fun buildSymbolDisplay(symbol: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = null, meaning: SymbolFlags? = null, flags: SymbolFormatFlags? = null)
        fun buildSignatureDisplay(signatures: Signature, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null, kind: SignatureKind? = null)
        fun buildParameterDisplay(parameter: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        fun buildTypeParameterDisplay(tp: TypeParameter, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        fun buildTypePredicateDisplay(predicate: dynamic /*TypePredicate*/, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        fun buildTypeParameterDisplayFromSymbol(symbol: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        fun buildDisplayForParametersAndDelimiters(parameters: Array<Symbol>, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        fun buildDisplayForTypeParametersAndDelimiters(typeParameters: Array<TypeParameter>, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        fun buildReturnTypeDisplay(signature: Signature, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
    }

    interface SymbolWriter {
        fun writeKeyword(text: String)
        fun writeOperator(text: String)
        fun writePunctuation(text: String)
        fun writeSpace(text: String)
        fun writeStringLiteral(text: String)
        fun writeParameter(text: String)
        fun writeSymbol(text: String, symbol: Symbol)
        fun writeLine()
        fun increaseIndent()
        fun decreaseIndent()
        fun clear()
        fun trackSymbol(symbol: Symbol, enclosingDeclaration: Node? = null, meaning: SymbolFlags? = null)
        fun reportInaccessibleThisError()
    }

    @native("ts.TypeFormatFlags")
    enum class TypeFormatFlags {
        None /* = 0 */,
        WriteArrayAsGenericType /* = 1 */,
        UseTypeOfFunction /* = 2 */,
        NoTruncation /* = 4 */,
        WriteArrowStyleSignature /* = 8 */,
        WriteOwnNameForAnyLike /* = 16 */,
        WriteTypeArgumentsOfSignature /* = 32 */,
        InElementType /* = 64 */,
        UseFullyQualifiedType /* = 128 */
    }

    @native("ts.SymbolFormatFlags")
    enum class SymbolFormatFlags {
        None /* = 0 */,
        WriteTypeParametersOrArguments /* = 1 */,
        UseOnlyExternalAliasing /* = 2 */
    }

    @native("ts.TypePredicateKind")
    enum class TypePredicateKind {
        `This` /* = 0 */,
        Identifier /* = 1 */
    }

    interface TypePredicateBase {
        var kind: TypePredicateKind
        var type: Type
    }

    interface ThisTypePredicate : TypePredicateBase {
        var _thisTypePredicateBrand: Any
    }

    interface IdentifierTypePredicate : TypePredicateBase {
        var parameterName: String
        var parameterIndex: Number
    }

    @native("ts.SymbolFlags")
    enum class SymbolFlags {
        None /* = 0 */,
        FunctionScopedVariable /* = 1 */,
        BlockScopedVariable /* = 2 */,
        Property /* = 4 */,
        EnumMember /* = 8 */,
        Function /* = 16 */,
        Class /* = 32 */,
        Interface /* = 64 */,
        ConstEnum /* = 128 */,
        RegularEnum /* = 256 */,
        ValueModule /* = 512 */,
        NamespaceModule /* = 1024 */,
        TypeLiteral /* = 2048 */,
        ObjectLiteral /* = 4096 */,
        Method /* = 8192 */,
        Constructor /* = 16384 */,
        GetAccessor /* = 32768 */,
        SetAccessor /* = 65536 */,
        Signature /* = 131072 */,
        TypeParameter /* = 262144 */,
        TypeAlias /* = 524288 */,
        ExportValue /* = 1048576 */,
        ExportType /* = 2097152 */,
        ExportNamespace /* = 4194304 */,
        Alias /* = 8388608 */,
        Instantiated /* = 16777216 */,
        Merged /* = 33554432 */,
        Transient /* = 67108864 */,
        Prototype /* = 134217728 */,
        SyntheticProperty /* = 268435456 */,
        Optional /* = 536870912 */,
        ExportStar /* = 1073741824 */,
        Enum /* = 384 */,
        Variable /* = 3 */,
        Value /* = 107455 */,
        Type /* = 793056 */,
        Namespace /* = 1536 */,
        Module /* = 1536 */,
        Accessor /* = 98304 */,
        FunctionScopedVariableExcludes /* = 107454 */,
        BlockScopedVariableExcludes /* = 107455 */,
        ParameterExcludes /* = 107455 */,
        PropertyExcludes /* = 107455 */,
        EnumMemberExcludes /* = 107455 */,
        FunctionExcludes /* = 106927 */,
        ClassExcludes /* = 899519 */,
        InterfaceExcludes /* = 792960 */,
        RegularEnumExcludes /* = 899327 */,
        ConstEnumExcludes /* = 899967 */,
        ValueModuleExcludes /* = 106639 */,
        NamespaceModuleExcludes /* = 0 */,
        MethodExcludes /* = 99263 */,
        GetAccessorExcludes /* = 41919 */,
        SetAccessorExcludes /* = 74687 */,
        TypeParameterExcludes /* = 530912 */,
        TypeAliasExcludes /* = 793056 */,
        AliasExcludes /* = 8388608 */,
        ModuleMember /* = 8914931 */,
        ExportHasLocal /* = 944 */,
        HasExports /* = 1952 */,
        HasMembers /* = 6240 */,
        BlockScoped /* = 418 */,
        PropertyOrAccessor /* = 98308 */,
        Export /* = 7340032 */
    }

    interface Symbol {
        var flags: SymbolFlags
        var name: String
        var declarations: Array<Declaration>? // = noImpl
        var valueDeclaration: Declaration? // = noImpl
        var members: SymbolTable? // = noImpl
        var exports: SymbolTable? // = noImpl
        fun getFlags(): SymbolFlags
        fun getName(): String
        fun getDeclarations(): Array<Declaration>
        fun getDocumentationComment(): Array<SymbolDisplayPart>
    }

    interface SymbolTable {
        @nativeGetter
        fun get(index: String): Symbol?

        @nativeSetter
        fun set(index: String, value: Symbol)
    }

    @native("ts.TypeFlags")
    enum class TypeFlags {
        Any /* = 1 */,
        String /* = 2 */,
        Number /* = 4 */,
        Boolean /* = 8 */,
        Void /* = 16 */,
        Undefined /* = 32 */,
        Null /* = 64 */,
        Enum /* = 128 */,
        StringLiteral /* = 256 */,
        TypeParameter /* = 512 */,
        Class /* = 1024 */,
        Interface /* = 2048 */,
        Reference /* = 4096 */,
        Tuple /* = 8192 */,
        Union /* = 16384 */,
        Intersection /* = 32768 */,
        Anonymous /* = 65536 */,
        Instantiated /* = 131072 */,
        ObjectLiteral /* = 524288 */,
        ESSymbol /* = 16777216 */,
        ThisType /* = 33554432 */,
        ObjectLiteralPatternWithComputedProperties /* = 67108864 */,
        StringLike /* = 258 */,
        NumberLike /* = 132 */,
        ObjectType /* = 80896 */,
        UnionOrIntersection /* = 49152 */,
        StructuredType /* = 130048 */
    }

    interface DestructuringPattern/* : BindingPattern, ObjectLiteralExpression, ArrayLiteralExpression*/

    interface Type {
        var flags: TypeFlags
        var symbol: Symbol? // = noImpl
        var pattern: DestructuringPattern? // = noImpl
        fun getFlags(): TypeFlags
        fun getSymbol(): Symbol
        fun getProperties(): Array<Symbol>
        fun getProperty(propertyName: String): Symbol
        fun getApparentProperties(): Array<Symbol>
        fun getCallSignatures(): Array<Signature>
        fun getConstructSignatures(): Array<Signature>
        fun getStringIndexType(): Type
        fun getNumberIndexType(): Type
        fun getBaseTypes(): Array<ObjectType>?
    }

    interface StringLiteralType : Type {
        var text: String
    }

    interface ObjectType : Type

    interface InterfaceType : ObjectType {
        var typeParameters: Array<TypeParameter>
        var outerTypeParameters: Array<TypeParameter>
        var localTypeParameters: Array<TypeParameter>
        var thisType: TypeParameter
    }

    interface InterfaceTypeWithDeclaredMembers : InterfaceType {
        var declaredProperties: Array<Symbol>
        var declaredCallSignatures: Array<Signature>
        var declaredConstructSignatures: Array<Signature>
        var declaredStringIndexType: Type
        var declaredNumberIndexType: Type
    }

    interface TypeReference : ObjectType {
        var target: GenericType
        var typeArguments: Array<Type>
    }

    interface GenericType : InterfaceType, TypeReference

    interface TupleType : ObjectType {
        var elementTypes: Array<Type>
    }

    interface UnionOrIntersectionType : Type {
        var types: Array<Type>
    }

    interface UnionType : UnionOrIntersectionType

    interface IntersectionType : UnionOrIntersectionType

    interface TypeParameter : Type {
        var constraint: Type
    }

    @native("ts.SignatureKind")
    enum class SignatureKind {
        Call /* = 0 */,
        Construct /* = 1 */
    }

    interface Signature {
        var declaration: SignatureDeclaration
        var typeParameters: Array<TypeParameter>
        var parameters: Array<Symbol>
        fun getDeclaration(): SignatureDeclaration
        fun getTypeParameters(): Array<Type>
        fun getParameters(): Array<Symbol>
        fun getReturnType(): Type
        fun getDocumentationComment(): Array<SymbolDisplayPart>
    }

    @native("ts.IndexKind")
    enum class IndexKind {
        String /* = 0 */,
        Number /* = 1 */
    }

    interface DiagnosticMessage {
        var key: String
        var category: DiagnosticCategory
        var code: Number
        var message: String
    }

    interface DiagnosticMessageChain {
        var messageText: String
        var category: DiagnosticCategory
        var code: Number
        var next: DiagnosticMessageChain? // = noImpl
    }

    interface Diagnostic {
        var file: SourceFile
        var start: Number
        var length: Number
        var messageText: dynamic /* String | DiagnosticMessageChain */
        var category: DiagnosticCategory
        var code: Number
    }

    @native("ts.DiagnosticCategory")
    enum class DiagnosticCategory {
        Warning /* = 0 */,
        Error /* = 1 */,
        Message /* = 2 */
    }

    @native("ts.ModuleResolutionKind")
    enum class ModuleResolutionKind {
        Classic /* = 1 */,
        NodeJs /* = 2 */
    }

    interface CompilerOptions {
        var allowNonTsExtensions: Boolean? // = noImpl
        var charset: String? // = noImpl
        var declaration: Boolean? // = noImpl
        var diagnostics: Boolean? // = noImpl
        var emitBOM: Boolean? // = noImpl
        var help: Boolean? // = noImpl
        var init: Boolean? // = noImpl
        var inlineSourceMap: Boolean? // = noImpl
        var inlineSources: Boolean? // = noImpl
        var jsx: JsxEmit? // = noImpl
        var reactNamespace: String? // = noImpl
        var listFiles: Boolean? // = noImpl
        var locale: String? // = noImpl
        var mapRoot: String? // = noImpl
        var module: ModuleKind? // = noImpl
        var newLine: NewLineKind? // = noImpl
        var noEmit: Boolean? // = noImpl
        var noEmitHelpers: Boolean? // = noImpl
        var noEmitOnError: Boolean? // = noImpl
        var noErrorTruncation: Boolean? // = noImpl
        var noImplicitAny: Boolean? // = noImpl
        var noLib: Boolean? // = noImpl
        var noResolve: Boolean? // = noImpl
        var out: String? // = noImpl
        var outFile: String? // = noImpl
        var outDir: String? // = noImpl
        var preserveConstEnums: Boolean? // = noImpl
        var project: String? // = noImpl
        var removeComments: Boolean? // = noImpl
        var rootDir: String? // = noImpl
        var sourceMap: Boolean? // = noImpl
        var sourceRoot: String? // = noImpl
        var suppressExcessPropertyErrors: Boolean? // = noImpl
        var suppressImplicitAnyIndexErrors: Boolean? // = noImpl
        var target: ScriptTarget? // = noImpl
        var version: Boolean? // = noImpl
        var watch: Boolean? // = noImpl
        var isolatedModules: Boolean? // = noImpl
        var experimentalDecorators: Boolean? // = noImpl
        var emitDecoratorMetadata: Boolean? // = noImpl
        var moduleResolution: ModuleResolutionKind? // = noImpl
        var allowUnusedLabels: Boolean? // = noImpl
        var allowUnreachableCode: Boolean? // = noImpl
        var noImplicitReturns: Boolean? // = noImpl
        var noFallthroughCasesInSwitch: Boolean? // = noImpl
        var forceConsistentCasingInFileNames: Boolean? // = noImpl
        var allowSyntheticDefaultImports: Boolean? // = noImpl
        var allowJs: Boolean? // = noImpl
        var noImplicitUseStrict: Boolean? // = noImpl
        var disableSizeLimit: Boolean? // = noImpl
        @nativeGetter
        fun get(option: String): dynamic /* String | Number | Boolean */

        @nativeSetter
        fun set(option: String, value: dynamic /* String | Number | Boolean */)
    }

    interface TypingOptions {
        var enableAutoDiscovery: Boolean? // = noImpl
        var include: Array<String>? // = noImpl
        var exclude: Array<String>? // = noImpl
        @nativeGetter
        fun get(option: String): dynamic /* Array<String> | Boolean */

        @nativeSetter
        fun set(option: String, value: dynamic /* Array<String> | Boolean */)
    }

    interface DiscoverTypingsInfo {
        var fileNames: Array<String>
        var projectRootPath: String
        var safeListPath: String
        var packageNameToTypingLocation: JsMap<String>
        var typingOptions: TypingOptions
        var compilerOptions: CompilerOptions
    }

    @native("ts.ModuleKind")
    enum class ModuleKind {
        None /* = 0 */,
        CommonJS /* = 1 */,
        AMD /* = 2 */,
        UMD /* = 3 */,
        System /* = 4 */,
        ES6 /* = 5 */,
        ES2015 /* = 5 */
    }

    @native("ts.JsxEmit")
    enum class JsxEmit {
        None /* = 0 */,
        Preserve /* = 1 */,
        React /* = 2 */
    }

    @native("ts.NewLineKind")
    enum class NewLineKind {
        CarriageReturnLineFeed /* = 0 */,
        LineFeed /* = 1 */
    }

    interface LineAndCharacter {
        var line: Number
        var character: Number
    }

    @native("ts.ScriptKind")
    enum class ScriptKind {
        Unknown /* = 0 */,
        JS /* = 1 */,
        JSX /* = 2 */,
        TS /* = 3 */,
        TSX /* = 4 */
    }

    @native("ts.ScriptTarget")
    enum class ScriptTarget {
        ES3 /* = 0 */,
        ES5 /* = 1 */,
        ES6 /* = 2 */,
        ES2015 /* = 2 */,
        Latest /* = 2 */
    }

    @native("ts.LanguageVariant")
    enum class LanguageVariant {
        Standard /* = 0 */,
        JSX /* = 1 */
    }

    interface ParsedCommandLine {
        var options: CompilerOptions
        var typingOptions: TypingOptions? // = noImpl
        var fileNames: Array<String>
        var errors: Array<Diagnostic>
    }

    interface ModuleResolutionHost {
        fun fileExists(fileName: String): Boolean
        fun readFile(fileName: String): String
        val directoryExists: ((directoryName: String) -> Boolean)? // = noImpl
    }

    interface ResolvedModule {
        var resolvedFileName: String
        var isExternalLibraryImport: Boolean? // = noImpl
    }

    interface ResolvedModuleWithFailedLookupLocations {
        var resolvedModule: ResolvedModule
        var failedLookupLocations: Array<String>
    }

    interface CompilerHost : ModuleResolutionHost {
        fun getSourceFile(fileName: String, languageVersion: ScriptTarget, onError: ((message: String) -> Unit)? = null): SourceFile
        val getCancellationToken: (() -> CancellationToken)? // = noImpl
        fun getDefaultLibFileName(options: CompilerOptions): String
        var writeFile: WriteFileCallback
        fun getCurrentDirectory(): String
        fun getCanonicalFileName(fileName: String): String
        fun useCaseSensitiveFileNames(): Boolean
        fun getNewLine(): String
        val resolveModuleNames: ((moduleNames: Array<String>, containingFile: String) -> Array<ResolvedModule>)? // = noImpl
    }

    interface TextSpan {
        var start: Number
        var length: Number
    }

    interface TextChangeRange {
        var span: TextSpan
        var newLength: Number
    }

    interface System {
        var args: Array<String>
        var newLine: String
        var useCaseSensitiveFileNames: Boolean
        fun write(s: String)
        fun readFile(path: String, encoding: String? = null): String
        fun writeFile(path: String, data: String, writeByteOrderMark: Boolean? = null)
        val watchFile: ((path: String /*Path*/, callback: dynamic /*FileWatcherCallback*/) -> FileWatcher)? // = noImpl
        val watchDirectory: ((path: String, callback: dynamic /*DirectoryWatcherCallback*/, recursive: Boolean?/* = null*/) -> FileWatcher)? // = noImpl
        fun resolvePath(path: String): String
        fun fileExists(path: String): Boolean
        fun directoryExists(path: String): Boolean
        fun createDirectory(path: String)
        fun getExecutingFilePath(): String
        fun getCurrentDirectory(): String
        fun readDirectory(path: String, extension: String? = null, exclude: Array<String>? = null): Array<String>
        val getMemoryUsage: (() -> Number)? // = noImpl
        fun exit(exitCode: Number? = null)
    }

    interface FileWatcher {
        fun close()
    }

    interface DirectoryWatcher : FileWatcher {
        var directoryPath: String /*Path*/
        var referenceCount: Number
    }

    interface ErrorCallback {
        @nativeInvoke
        fun invoke(message: DiagnosticMessage, length: Number)
    }

    interface Scanner {
        fun getStartPos(): Number
        fun getToken(): SyntaxKind
        fun getTextPos(): Number
        fun getTokenPos(): Number
        fun getTokenText(): String
        fun getTokenValue(): String
        fun hasExtendedUnicodeEscape(): Boolean
        fun hasPrecedingLineBreak(): Boolean
        fun isIdentifier(): Boolean
        fun isReservedWord(): Boolean
        fun isUnterminated(): Boolean
        fun reScanGreaterToken(): SyntaxKind
        fun reScanSlashToken(): SyntaxKind
        fun reScanTemplateToken(): SyntaxKind
        fun scanJsxIdentifier(): SyntaxKind
        fun reScanJsxToken(): SyntaxKind
        fun scanJsxToken(): SyntaxKind
        fun scanJSDocToken(): SyntaxKind
        fun scan(): SyntaxKind
        fun setText(text: String, start: Number? = null, length: Number? = null)
        fun setOnError(onError: ErrorCallback)
        fun setScriptTarget(scriptTarget: ScriptTarget)
        fun setLanguageVariant(variant: LanguageVariant)
        fun setTextPos(textPos: Number)
        fun <T> lookAhead(callback: () -> T): T
        fun <T> scanRange(start: Number, length: Number, callback: () -> T): T
        fun <T> tryScan(callback: () -> T): T
    }

    fun tokenToString(t: SyntaxKind): String = noImpl
    fun getPositionOfLineAndCharacter(sourceFile: SourceFile, line: Number, character: Number): Number = noImpl
    fun getLineAndCharacterOfPosition(sourceFile: SourceFile, position: Number): LineAndCharacter = noImpl
    fun isWhiteSpace(ch: Number): Boolean = noImpl
    fun isLineBreak(ch: Number): Boolean = noImpl
    fun couldStartTrivia(text: String, pos: Number): Boolean = noImpl
    fun getLeadingCommentRanges(text: String, pos: Number): Array<CommentRange> = noImpl
    fun getTrailingCommentRanges(text: String, pos: Number): Array<CommentRange> = noImpl
    fun getShebang(text: String): String = noImpl
    fun isIdentifierStart(ch: Number, languageVersion: ScriptTarget): Boolean = noImpl
    fun isIdentifierPart(ch: Number, languageVersion: ScriptTarget): Boolean = noImpl
    fun createScanner(languageVersion: ScriptTarget, skipTrivia: Boolean, languageVariant: LanguageVariant? = null, text: String? = null, onError: ErrorCallback? = null, start: Number? = null, length: Number? = null): Scanner = noImpl
    fun getDefaultLibFileName(options: CompilerOptions): String = noImpl
    fun textSpanEnd(span: TextSpan): Number = noImpl
    fun textSpanIsEmpty(span: TextSpan): Boolean = noImpl
    fun textSpanContainsPosition(span: TextSpan, position: Number): Boolean = noImpl
    fun textSpanContainsTextSpan(span: TextSpan, other: TextSpan): Boolean = noImpl
    fun textSpanOverlapsWith(span: TextSpan, other: TextSpan): Boolean = noImpl
    fun textSpanOverlap(span1: TextSpan, span2: TextSpan): TextSpan = noImpl
    fun textSpanIntersectsWithTextSpan(span: TextSpan, other: TextSpan): Boolean = noImpl
    fun textSpanIntersectsWith(span: TextSpan, start: Number, length: Number): Boolean = noImpl
    fun decodedTextSpanIntersectsWith(start1: Number, length1: Number, start2: Number, length2: Number): Boolean = noImpl
    fun textSpanIntersectsWithPosition(span: TextSpan, position: Number): Boolean = noImpl
    fun textSpanIntersection(span1: TextSpan, span2: TextSpan): TextSpan = noImpl
    fun createTextSpan(start: Number, length: Number): TextSpan = noImpl
    fun createTextSpanFromBounds(start: Number, end: Number): TextSpan = noImpl
    fun textChangeRangeNewSpan(range: TextChangeRange): TextSpan = noImpl
    fun textChangeRangeIsUnchanged(range: TextChangeRange): Boolean = noImpl
    fun createTextChangeRange(span: TextSpan, newLength: Number): TextChangeRange = noImpl
    var unchangedTextChangeRange: TextChangeRange = noImpl
    fun collapseTextChangeRangesAcrossMultipleVersions(changes: Array<TextChangeRange>): TextChangeRange = noImpl
    fun getTypeParameterOwner(d: Declaration): Declaration = noImpl
    fun isParameterPropertyDeclaration(node: ParameterDeclaration): Boolean = noImpl
    fun createNode(kind: SyntaxKind, pos: Number? = null, end: Number? = null): Node = noImpl
    fun <T> forEachChild(node: Node, cbNode: (node: Node) -> T, cbNodeArray: ((nodes: Array<Node>) -> T)? = null): T = noImpl
    fun createSourceFile(fileName: String, sourceText: String, languageVersion: ScriptTarget, setParentNodes: Boolean? = null, scriptKind: ScriptKind? = null): SourceFile = noImpl
    fun updateSourceFile(sourceFile: SourceFile, newText: String, textChangeRange: TextChangeRange, aggressiveChecks: Boolean? = null): SourceFile = noImpl
    var version: String = noImpl
    fun findConfigFile(searchPath: String, fileExists: (fileName: String) -> Boolean): String = noImpl
    fun resolveTripleslashReference(moduleName: String, containingFile: String): String = noImpl
    fun resolveModuleName(moduleName: String, containingFile: String, compilerOptions: CompilerOptions, host: ModuleResolutionHost): ResolvedModuleWithFailedLookupLocations = noImpl
    fun nodeModuleNameResolver(moduleName: String, containingFile: String, compilerOptions: CompilerOptions, host: ModuleResolutionHost): ResolvedModuleWithFailedLookupLocations = noImpl
    fun classicNameResolver(moduleName: String, containingFile: String, compilerOptions: CompilerOptions, host: ModuleResolutionHost): ResolvedModuleWithFailedLookupLocations = noImpl
    fun createCompilerHost(options: CompilerOptions, setParentNodes: Boolean? = null): CompilerHost = noImpl
    fun getPreEmitDiagnostics(program: Program, sourceFile: SourceFile? = null, cancellationToken: CancellationToken? = null): Array<Diagnostic> = noImpl
    fun flattenDiagnosticMessageText(messageText: dynamic /* String | DiagnosticMessageChain */, newLine: String): String = noImpl
    fun createProgram(rootNames: Array<String>, options: CompilerOptions, host: CompilerHost? = null, oldProgram: Program? = null): Program = noImpl
    fun parseCommandLine(commandLine: Array<String>, readFile: ((path: String) -> String)? = null): ParsedCommandLine = noImpl
    interface `T$0` {
        var config: Any? get() = noImpl; set(v) {}
        var error: Diagnostic? get() = noImpl; set(v) {}
    }
    fun readConfigFile(fileName: String, readFile: (path: String) -> String): `T$0` = noImpl
    fun parseConfigFileTextToJson(fileName: String, jsonText: String): `T$0` = noImpl
    fun parseJsonConfigFileContent(json: Any, host: ParseConfigHost, basePath: String, existingOptions: CompilerOptions? = null, configFileName: String? = null): ParsedCommandLine = noImpl
    interface `T$1` {
        var options: CompilerOptions
        var errors: Array<Diagnostic>
    }
    fun convertCompilerOptionsFromJson(jsonOptions: Any, basePath: String, configFileName: String? = null): `T$1` = noImpl
    var servicesVersion: String = noImpl
    interface IScriptSnapshot {
        fun getText(start: Number = noImpl, end: Number = noImpl): String
        fun getLength(): Number
        fun getChangeRange(oldSnapshot: IScriptSnapshot): TextChangeRange
        val dispose: (() -> Unit)? // = noImpl
    }
    object ScriptSnapshot {
        fun fromString(text: String): IScriptSnapshot = noImpl
    }
    interface PreProcessedFileInfo {
        var referencedFiles: Array<FileReference>
        var importedFiles: Array<FileReference>
        var ambientExternalModules: Array<String>
        var isLibFile: Boolean
    }

    interface HostCancellationToken {
        fun isCancellationRequested(): Boolean
    }

    interface LanguageServiceHost {
        fun getCompilationSettings(): CompilerOptions
        val getNewLine: (() -> String)? get() = noImpl
        val getProjectVersion: (() -> String)? get() = noImpl
        fun getScriptFileNames(): Array<String>
        val getScriptKind: ((fileName: String) -> ScriptKind)? get() = noImpl
        fun getScriptVersion(fileName: String): String
        fun getScriptSnapshot(fileName: String): IScriptSnapshot?
        val getLocalizedDiagnosticMessages: (() -> Any)? get() = noImpl
        val getCancellationToken: (() -> HostCancellationToken)? get() = noImpl
        fun getCurrentDirectory(): String
        fun getDefaultLibFileName(options: CompilerOptions): String
        val log: ((s: String) -> Unit)? get() = noImpl
        val trace: ((s: String) -> Unit)? get() = noImpl
        val error: ((s: String) -> Unit)? get() = noImpl
        val useCaseSensitiveFileNames: (() -> Boolean)? get() = noImpl
        val resolveModuleNames: ((moduleNames: Array<String>, containingFile: String) -> Array<ResolvedModule>)? get() = noImpl
        val directoryExists: ((directoryName: String) -> Boolean)? get() = noImpl
    }

    interface LanguageService {
        fun cleanupSemanticCache()
        fun getSyntacticDiagnostics(fileName: String): Array<Diagnostic>
        fun getSemanticDiagnostics(fileName: String): Array<Diagnostic>
        fun getCompilerOptionsDiagnostics(): Array<Diagnostic>
        fun getSyntacticClassifications(fileName: String, span: TextSpan): Array<ClassifiedSpan>
        fun getSemanticClassifications(fileName: String, span: TextSpan): Array<ClassifiedSpan>
        fun getEncodedSyntacticClassifications(fileName: String, span: TextSpan): Classifications
        fun getEncodedSemanticClassifications(fileName: String, span: TextSpan): Classifications
        fun getCompletionsAtPosition(fileName: String, position: Number): CompletionInfo
        fun getCompletionEntryDetails(fileName: String, position: Number, entryName: String): CompletionEntryDetails
        fun getQuickInfoAtPosition(fileName: String, position: Number): QuickInfo
        fun getNameOrDottedNameSpan(fileName: String, startPos: Number, endPos: Number): TextSpan
        fun getBreakpointStatementAtPosition(fileName: String, position: Number): TextSpan
        fun getSignatureHelpItems(fileName: String, position: Number): SignatureHelpItems
        fun getRenameInfo(fileName: String, position: Number): RenameInfo
        fun findRenameLocations(fileName: String, position: Number, findInStrings: Boolean, findInComments: Boolean): Array<RenameLocation>
        fun getDefinitionAtPosition(fileName: String, position: Number): Array<DefinitionInfo>
        fun getTypeDefinitionAtPosition(fileName: String, position: Number): Array<DefinitionInfo>
        fun getReferencesAtPosition(fileName: String, position: Number): Array<ReferenceEntry>
        fun findReferences(fileName: String, position: Number): Array<ReferencedSymbol>
        fun getDocumentHighlights(fileName: String, position: Number, filesToSearch: Array<String>): Array<DocumentHighlights>
        fun getOccurrencesAtPosition(fileName: String, position: Number): Array<ReferenceEntry>
        fun getNavigateToItems(searchValue: String, maxResultCount: Number? = null): Array<NavigateToItem>
        fun getNavigationBarItems(fileName: String): Array<NavigationBarItem>
        fun getOutliningSpans(fileName: String): Array<OutliningSpan>
        fun getTodoComments(fileName: String, descriptors: Array<TodoCommentDescriptor>): Array<TodoComment>
        fun getBraceMatchingAtPosition(fileName: String, position: Number): Array<TextSpan>
        fun getIndentationAtPosition(fileName: String, position: Number, options: EditorOptions): Number
        fun getFormattingEditsForRange(fileName: String, start: Number, end: Number, options: FormatCodeOptions): Array<TextChange>
        fun getFormattingEditsForDocument(fileName: String, options: FormatCodeOptions): Array<TextChange>
        fun getFormattingEditsAfterKeystroke(fileName: String, position: Number, key: String, options: FormatCodeOptions): Array<TextChange>
        fun getDocCommentTemplateAtPosition(fileName: String, position: Number): TextInsertion
        fun getEmitOutput(fileName: String): EmitOutput
        fun getProgram(): Program
        fun getSourceFile(fileName: String): SourceFile
        fun dispose()
    }

    interface Classifications {
        var spans: Array<Number>
        var endOfLineState: EndOfLineState
    }

    interface ClassifiedSpan {
        var textSpan: TextSpan
        var classificationType: String
    }

    interface NavigationBarItem {
        var text: String
        var kind: String
        var kindModifiers: String
        var spans: Array<TextSpan>
        var childItems: Array<NavigationBarItem>
        var indent: Number
        var bolded: Boolean
        var grayed: Boolean
    }

    interface TodoCommentDescriptor {
        var text: String
        var priority: Number
    }

    interface TodoComment {
        var descriptor: TodoCommentDescriptor
        var message: String
        var position: Number
    }

    class TextChange {
        val span: TextSpan
        val newText: String
    }

    interface TextInsertion {
        var newText: String
        var caretOffset: Number
    }

    interface RenameLocation {
        var textSpan: TextSpan
        var fileName: String
    }

    interface ReferenceEntry {
        var textSpan: TextSpan
        var fileName: String
        var isWriteAccess: Boolean
    }

    interface DocumentHighlights {
        var fileName: String
        var highlightSpans: Array<HighlightSpan>
    }

    interface HighlightSpan {
        var fileName: String? // = noImpl
        var textSpan: TextSpan
        var kind: String
    }

    interface NavigateToItem {
        var name: String
        var kind: String
        var kindModifiers: String
        var matchKind: String
        var isCaseSensitive: Boolean
        var fileName: String
        var textSpan: TextSpan
        var containerName: String
        var containerKind: String
    }

    interface EditorOptions {
        var IndentSize: Number
        var TabSize: Number
        var NewLineCharacter: String
        var ConvertTabsToSpaces: Boolean
        var IndentStyle: IndentStyle
    }

    @native("ts.IndentStyle")
    enum class IndentStyle {
        None /* = 0 */,
        Block /* = 1 */,
        Smart /* = 2 */
    }

    interface FormatCodeOptions : EditorOptions {
        var InsertSpaceAfterCommaDelimiter: Boolean
        var InsertSpaceAfterSemicolonInForStatements: Boolean
        var InsertSpaceBeforeAndAfterBinaryOperators: Boolean
        var InsertSpaceAfterKeywordsInControlFlowStatements: Boolean
        var InsertSpaceAfterFunctionKeywordForAnonymousFunctions: Boolean
        var InsertSpaceAfterOpeningAndBeforeClosingNonemptyParenthesis: Boolean
        var InsertSpaceAfterOpeningAndBeforeClosingNonemptyBrackets: Boolean
        var InsertSpaceAfterOpeningAndBeforeClosingTemplateStringBraces: Boolean
        var PlaceOpenBraceOnNewLineForFunctions: Boolean
        var PlaceOpenBraceOnNewLineForControlBlocks: Boolean
        @nativeGetter
        fun get(s: String): dynamic /* Boolean | Number | String */

        @nativeSetter
        fun set(s: String, value: dynamic /* Boolean | Number | String */)
    }

    interface DefinitionInfo {
        var fileName: String
        var textSpan: TextSpan
        var kind: String
        var name: String
        var containerKind: String
        var containerName: String
    }

    interface ReferencedSymbol {
        var definition: DefinitionInfo
        var references: Array<ReferenceEntry>
    }

    @native("ts.SymbolDisplayPartKind")
    enum class SymbolDisplayPartKind {
        aliasName /* = 0 */,
        className /* = 1 */,
        enumName /* = 2 */,
        fieldName /* = 3 */,
        interfaceName /* = 4 */,
        keyword /* = 5 */,
        lineBreak /* = 6 */,
        numericLiteral /* = 7 */,
        stringLiteral /* = 8 */,
        localName /* = 9 */,
        methodName /* = 10 */,
        moduleName /* = 11 */,
        operator /* = 12 */,
        parameterName /* = 13 */,
        propertyName /* = 14 */,
        punctuation /* = 15 */,
        space /* = 16 */,
        text /* = 17 */,
        typeParameterName /* = 18 */,
        enumMemberName /* = 19 */,
        functionName /* = 20 */,
        regularExpressionLiteral /* = 21 */
    }

    interface SymbolDisplayPart {
        var text: String
        var kind: String
    }

    interface QuickInfo {
        var kind: String
        var kindModifiers: String
        var textSpan: TextSpan
        var displayParts: Array<SymbolDisplayPart>
        var documentation: Array<SymbolDisplayPart>
    }

    interface RenameInfo {
        var canRename: Boolean
        var localizedErrorMessage: String
        var displayName: String
        var fullDisplayName: String
        var kind: String
        var kindModifiers: String
        var triggerSpan: TextSpan
    }

    interface SignatureHelpParameter {
        var name: String
        var documentation: Array<SymbolDisplayPart>
        var displayParts: Array<SymbolDisplayPart>
        var isOptional: Boolean
    }

    interface SignatureHelpItem {
        var isVariadic: Boolean
        var prefixDisplayParts: Array<SymbolDisplayPart>
        var suffixDisplayParts: Array<SymbolDisplayPart>
        var separatorDisplayParts: Array<SymbolDisplayPart>
        var parameters: Array<SignatureHelpParameter>
        var documentation: Array<SymbolDisplayPart>
    }

    interface SignatureHelpItems {
        var items: Array<SignatureHelpItem>
        var applicableSpan: TextSpan
        var selectedItemIndex: Number
        var argumentIndex: Number
        var argumentCount: Number
    }

    interface CompletionInfo {
        var isMemberCompletion: Boolean
        var isNewIdentifierLocation: Boolean
        var entries: Array<CompletionEntry>
    }

    interface CompletionEntry {
        var name: String
        var kind: String
        var kindModifiers: String
        var sortText: String
    }

    interface CompletionEntryDetails {
        var name: String
        var kind: String
        var kindModifiers: String
        var displayParts: Array<SymbolDisplayPart>
        var documentation: Array<SymbolDisplayPart>
    }

    interface OutliningSpan {
        var textSpan: TextSpan
        var hintSpan: TextSpan
        var bannerText: String
        var autoCollapse: Boolean
    }

    interface EmitOutput {
        var outputFiles: Array<OutputFile>
        var emitSkipped: Boolean
    }

    @native("ts.OutputFileType")
    enum class OutputFileType {
        JavaScript /* = 0 */,
        SourceMap /* = 1 */,
        Declaration /* = 2 */
    }

    interface OutputFile {
        var name: String
        var writeByteOrderMark: Boolean
        var text: String
    }

    @native("ts.EndOfLineState")
    enum class EndOfLineState {
        None /* = 0 */,
        InMultiLineCommentTrivia /* = 1 */,
        InSingleQuoteStringLiteral /* = 2 */,
        InDoubleQuoteStringLiteral /* = 3 */,
        InTemplateHeadOrNoSubstitutionTemplate /* = 4 */,
        InTemplateMiddleOrTail /* = 5 */,
        InTemplateSubstitutionPosition /* = 6 */
    }

    @native("ts.TokenClass")
    enum class TokenClass {
        Punctuation /* = 0 */,
        Keyword /* = 1 */,
        Operator /* = 2 */,
        Comment /* = 3 */,
        Whitespace /* = 4 */,
        Identifier /* = 5 */,
        NumberLiteral /* = 6 */,
        StringLiteral /* = 7 */,
        RegExpLiteral /* = 8 */
    }

    interface ClassificationResult {
        var finalLexState: EndOfLineState
        var entries: Array<ClassificationInfo>
    }

    interface ClassificationInfo {
        var length: Number
        var classification: TokenClass
    }

    interface Classifier {
        fun getClassificationsForLine(text: String, lexState: EndOfLineState, syntacticClassifierAbsent: Boolean): ClassificationResult
        fun getEncodedLexicalClassifications(text: String, endOfLineState: EndOfLineState, syntacticClassifierAbsent: Boolean): Classifications
    }

    interface DocumentRegistry {
        fun acquireDocument(fileName: String, compilationSettings: CompilerOptions, scriptSnapshot: IScriptSnapshot, version: String, scriptKind: ScriptKind? = null): SourceFile
        fun updateDocument(fileName: String, compilationSettings: CompilerOptions, scriptSnapshot: IScriptSnapshot, version: String, scriptKind: ScriptKind? = null): SourceFile
        fun releaseDocument(fileName: String, compilationSettings: CompilerOptions)
        fun reportStats(): String
    }

    @native("ts.ClassificationType")
    enum class ClassificationType {
        comment /* = 1 */,
        identifier /* = 2 */,
        keyword /* = 3 */,
        numericLiteral /* = 4 */,
        operator /* = 5 */,
        stringLiteral /* = 6 */,
        regularExpressionLiteral /* = 7 */,
        whiteSpace /* = 8 */,
        text /* = 9 */,
        punctuation /* = 10 */,
        className /* = 11 */,
        enumName /* = 12 */,
        interfaceName /* = 13 */,
        moduleName /* = 14 */,
        typeParameterName /* = 15 */,
        typeAliasName /* = 16 */,
        parameterName /* = 17 */,
        docCommentTagName /* = 18 */,
        jsxOpenTagName /* = 19 */,
        jsxCloseTagName /* = 20 */,
        jsxSelfClosingTagName /* = 21 */,
        jsxAttribute /* = 22 */,
        jsxText /* = 23 */,
        jsxAttributeStringLiteralValue /* = 24 */
    }

    interface DisplayPartsSymbolWriter : SymbolWriter {
        fun displayParts(): Array<SymbolDisplayPart>
    }

    fun displayPartsToString(displayParts: Array<SymbolDisplayPart>): String = noImpl
    fun getDefaultCompilerOptions(): CompilerOptions = noImpl

    interface TranspileOptions {
        var compilerOptions: CompilerOptions? // = noImpl
        var fileName: String? // = noImpl
        var reportDiagnostics: Boolean? // = noImpl
        var moduleName: String? // = noImpl
        var renamedDependencies: JsMap<String>? // = noImpl
    }

    interface TranspileOutput {
        var outputText: String
        var diagnostics: Array<Diagnostic>? // = noImpl
        var sourceMapText: String? // = noImpl
    }
    
    fun transpileModule(input: String, transpileOptions: TranspileOptions): TranspileOutput = noImpl
    fun transpile(input: String, compilerOptions: CompilerOptions? = null, fileName: String? = null, diagnostics: Array<Diagnostic>? = null, moduleName: String? = null): String = noImpl
    fun createLanguageServiceSourceFile(fileName: String, scriptSnapshot: IScriptSnapshot, scriptTarget: ScriptTarget, version: String, setNodeParents: Boolean, scriptKind: ScriptKind? = null): SourceFile = noImpl
    var disableIncrementalParsing: Boolean = noImpl
    fun updateLanguageServiceSourceFile(sourceFile: SourceFile, scriptSnapshot: IScriptSnapshot, version: String, textChangeRange: TextChangeRange, aggressiveChecks: Boolean? = null): SourceFile = noImpl
    fun createDocumentRegistry(useCaseSensitiveFileNames: Boolean? = null, currentDirectory: String? = null): DocumentRegistry = noImpl
    fun preProcessFile(sourceText: String, readImportFiles: Boolean? = null, detectJavaScriptImports: Boolean? = null): PreProcessedFileInfo = noImpl
    fun createLanguageService(host: LanguageServiceHost, documentRegistry: DocumentRegistry? = null): LanguageService = noImpl
    fun createClassifier(): Classifier = noImpl
    fun getDefaultLibFilePath(options: CompilerOptions): String = noImpl
}
