package typescriptServices

@module
object ts {
    interface MapLike<T> {
        @nativeGetter
        fun get(index: String): T?
        @nativeSetter
        fun set(index: String, value: T)
    }
    interface Map<T> : MapLike<T> {
        var __mapBrand: Any
    }
    interface `T$0` {
        var __pathBrand: Any
    }
    interface FileMap<T> {
        fun get(fileName: String /* String & `T$0` */): T
        fun set(fileName: String /* String & `T$0` */, value: T)
        fun contains(fileName: String /* String & `T$0` */): Boolean
        fun remove(fileName: String /* String & `T$0` */)
        fun forEachValue(f: `(key: String /* String & `T$0` */, v: T) -> Unit`)
        fun getKeys(): Array<String /* String & `T$0` */>
        fun clear()
    }
    interface TextRange {
        var pos: Number
        var end: Number
    }
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
        NeverKeyword /* = 127 */,
        ReadonlyKeyword /* = 128 */,
        RequireKeyword /* = 129 */,
        NumberKeyword /* = 130 */,
        SetKeyword /* = 131 */,
        StringKeyword /* = 132 */,
        SymbolKeyword /* = 133 */,
        TypeKeyword /* = 134 */,
        UndefinedKeyword /* = 135 */,
        FromKeyword /* = 136 */,
        GlobalKeyword /* = 137 */,
        OfKeyword /* = 138 */,
        QualifiedName /* = 139 */,
        ComputedPropertyName /* = 140 */,
        TypeParameter /* = 141 */,
        Parameter /* = 142 */,
        Decorator /* = 143 */,
        PropertySignature /* = 144 */,
        PropertyDeclaration /* = 145 */,
        MethodSignature /* = 146 */,
        MethodDeclaration /* = 147 */,
        Constructor /* = 148 */,
        GetAccessor /* = 149 */,
        SetAccessor /* = 150 */,
        CallSignature /* = 151 */,
        ConstructSignature /* = 152 */,
        IndexSignature /* = 153 */,
        TypePredicate /* = 154 */,
        TypeReference /* = 155 */,
        FunctionType /* = 156 */,
        ConstructorType /* = 157 */,
        TypeQuery /* = 158 */,
        TypeLiteral /* = 159 */,
        ArrayType /* = 160 */,
        TupleType /* = 161 */,
        UnionType /* = 162 */,
        IntersectionType /* = 163 */,
        ParenthesizedType /* = 164 */,
        ThisType /* = 165 */,
        LiteralType /* = 166 */,
        ObjectBindingPattern /* = 167 */,
        ArrayBindingPattern /* = 168 */,
        BindingElement /* = 169 */,
        ArrayLiteralExpression /* = 170 */,
        ObjectLiteralExpression /* = 171 */,
        PropertyAccessExpression /* = 172 */,
        ElementAccessExpression /* = 173 */,
        CallExpression /* = 174 */,
        NewExpression /* = 175 */,
        TaggedTemplateExpression /* = 176 */,
        TypeAssertionExpression /* = 177 */,
        ParenthesizedExpression /* = 178 */,
        FunctionExpression /* = 179 */,
        ArrowFunction /* = 180 */,
        DeleteExpression /* = 181 */,
        TypeOfExpression /* = 182 */,
        VoidExpression /* = 183 */,
        AwaitExpression /* = 184 */,
        PrefixUnaryExpression /* = 185 */,
        PostfixUnaryExpression /* = 186 */,
        BinaryExpression /* = 187 */,
        ConditionalExpression /* = 188 */,
        TemplateExpression /* = 189 */,
        YieldExpression /* = 190 */,
        SpreadElementExpression /* = 191 */,
        ClassExpression /* = 192 */,
        OmittedExpression /* = 193 */,
        ExpressionWithTypeArguments /* = 194 */,
        AsExpression /* = 195 */,
        NonNullExpression /* = 196 */,
        TemplateSpan /* = 197 */,
        SemicolonClassElement /* = 198 */,
        Block /* = 199 */,
        VariableStatement /* = 200 */,
        EmptyStatement /* = 201 */,
        ExpressionStatement /* = 202 */,
        IfStatement /* = 203 */,
        DoStatement /* = 204 */,
        WhileStatement /* = 205 */,
        ForStatement /* = 206 */,
        ForInStatement /* = 207 */,
        ForOfStatement /* = 208 */,
        ContinueStatement /* = 209 */,
        BreakStatement /* = 210 */,
        ReturnStatement /* = 211 */,
        WithStatement /* = 212 */,
        SwitchStatement /* = 213 */,
        LabeledStatement /* = 214 */,
        ThrowStatement /* = 215 */,
        TryStatement /* = 216 */,
        DebuggerStatement /* = 217 */,
        VariableDeclaration /* = 218 */,
        VariableDeclarationList /* = 219 */,
        FunctionDeclaration /* = 220 */,
        ClassDeclaration /* = 221 */,
        InterfaceDeclaration /* = 222 */,
        TypeAliasDeclaration /* = 223 */,
        EnumDeclaration /* = 224 */,
        ModuleDeclaration /* = 225 */,
        ModuleBlock /* = 226 */,
        CaseBlock /* = 227 */,
        NamespaceExportDeclaration /* = 228 */,
        ImportEqualsDeclaration /* = 229 */,
        ImportDeclaration /* = 230 */,
        ImportClause /* = 231 */,
        NamespaceImport /* = 232 */,
        NamedImports /* = 233 */,
        ImportSpecifier /* = 234 */,
        ExportAssignment /* = 235 */,
        ExportDeclaration /* = 236 */,
        NamedExports /* = 237 */,
        ExportSpecifier /* = 238 */,
        MissingDeclaration /* = 239 */,
        ExternalModuleReference /* = 240 */,
        JsxElement /* = 241 */,
        JsxSelfClosingElement /* = 242 */,
        JsxOpeningElement /* = 243 */,
        JsxText /* = 244 */,
        JsxClosingElement /* = 245 */,
        JsxAttribute /* = 246 */,
        JsxSpreadAttribute /* = 247 */,
        JsxExpression /* = 248 */,
        CaseClause /* = 249 */,
        DefaultClause /* = 250 */,
        HeritageClause /* = 251 */,
        CatchClause /* = 252 */,
        PropertyAssignment /* = 253 */,
        ShorthandPropertyAssignment /* = 254 */,
        EnumMember /* = 255 */,
        SourceFile /* = 256 */,
        JSDocTypeExpression /* = 257 */,
        JSDocAllType /* = 258 */,
        JSDocUnknownType /* = 259 */,
        JSDocArrayType /* = 260 */,
        JSDocUnionType /* = 261 */,
        JSDocTupleType /* = 262 */,
        JSDocNullableType /* = 263 */,
        JSDocNonNullableType /* = 264 */,
        JSDocRecordType /* = 265 */,
        JSDocRecordMember /* = 266 */,
        JSDocTypeReference /* = 267 */,
        JSDocOptionalType /* = 268 */,
        JSDocFunctionType /* = 269 */,
        JSDocVariadicType /* = 270 */,
        JSDocConstructorType /* = 271 */,
        JSDocThisType /* = 272 */,
        JSDocComment /* = 273 */,
        JSDocTag /* = 274 */,
        JSDocParameterTag /* = 275 */,
        JSDocReturnTag /* = 276 */,
        JSDocTypeTag /* = 277 */,
        JSDocTemplateTag /* = 278 */,
        JSDocTypedefTag /* = 279 */,
        JSDocPropertyTag /* = 280 */,
        JSDocTypeLiteral /* = 281 */,
        JSDocLiteralType /* = 282 */,
        JSDocNullKeyword /* = 283 */,
        JSDocUndefinedKeyword /* = 284 */,
        JSDocNeverKeyword /* = 285 */,
        SyntaxList /* = 286 */,
        Count /* = 287 */,
        FirstAssignment /* = 56 */,
        LastAssignment /* = 68 */,
        FirstReservedWord /* = 70 */,
        LastReservedWord /* = 105 */,
        FirstKeyword /* = 70 */,
        LastKeyword /* = 138 */,
        FirstFutureReservedWord /* = 106 */,
        LastFutureReservedWord /* = 114 */,
        FirstTypeNode /* = 154 */,
        LastTypeNode /* = 166 */,
        FirstPunctuation /* = 15 */,
        LastPunctuation /* = 68 */,
        FirstToken /* = 0 */,
        LastToken /* = 138 */,
        FirstTriviaToken /* = 2 */,
        LastTriviaToken /* = 7 */,
        FirstLiteralToken /* = 8 */,
        LastLiteralToken /* = 11 */,
        FirstTemplateToken /* = 11 */,
        LastTemplateToken /* = 14 */,
        FirstBinaryOperator /* = 25 */,
        LastBinaryOperator /* = 68 */,
        FirstNode /* = 139 */,
        FirstJSDocNode /* = 257 */,
        LastJSDocNode /* = 282 */,
        FirstJSDocTagNode /* = 273 */,
        LastJSDocTagNode /* = 285 */
    }
    enum class NodeFlags {
        None /* = 0 */,
        Export /* = 1 */,
        Ambient /* = 2 */,
        Public /* = 4 */,
        Private /* = 8 */,
        Protected /* = 16 */,
        Static /* = 32 */,
        Readonly /* = 64 */,
        Abstract /* = 128 */,
        Async /* = 256 */,
        Default /* = 512 */,
        Let /* = 1024 */,
        Const /* = 2048 */,
        Namespace /* = 4096 */,
        ExportContext /* = 8192 */,
        ContainsThis /* = 16384 */,
        HasImplicitReturn /* = 32768 */,
        HasExplicitReturn /* = 65536 */,
        GlobalAugmentation /* = 131072 */,
        HasClassExtends /* = 262144 */,
        HasDecorators /* = 524288 */,
        HasParamDecorators /* = 1048576 */,
        HasAsyncFunctions /* = 2097152 */,
        DisallowInContext /* = 4194304 */,
        YieldContext /* = 8388608 */,
        DecoratorContext /* = 16777216 */,
        AwaitContext /* = 33554432 */,
        ThisNodeHasError /* = 67108864 */,
        JavaScriptFile /* = 134217728 */,
        ThisNodeOrAnySubNodesHasError /* = 268435456 */,
        HasAggregatedChildData /* = 536870912 */,
        HasJsxSpreadAttribute /* = 1073741824 */,
        Modifier /* = 1023 */,
        AccessibilityModifier /* = 28 */,
        ParameterPropertyModifier /* = 92 */,
        BlockScoped /* = 3072 */,
        ReachabilityCheckFlags /* = 98304 */,
        EmitHelperFlags /* = 3932160 */,
        ReachabilityAndEmitFlags /* = 4030464 */,
        ContextFlags /* = 197132288 */,
        TypeExcludesFlags /* = 41943040 */
    }
    enum class JsxFlags {
        None /* = 0 */,
        IntrinsicNamedElement /* = 1 */,
        IntrinsicIndexedElement /* = 2 */,
        IntrinsicElement /* = 3 */
    }
    interface Node : TextRange {
        var kind: SyntaxKind
        var flags: NodeFlags
        var decorators: NodeArray<Decorator>? get() = noImpl; set(value){}
        var modifiers: ModifiersArray? get() = noImpl; set(value){}
        var parent: Node? get() = noImpl; set(value){}
        fun getSourceFile(): SourceFile
        fun getChildCount(sourceFile: SourceFile? = null): Number
        fun getChildAt(index: Number, sourceFile: SourceFile? = null): Node
        fun getChildren(sourceFile: SourceFile? = null): Array<Node>
        fun getStart(sourceFile: SourceFile? = null, includeJsDocComment: Boolean? = null): Number
        fun getFullStart(): Number
        fun getEnd(): Number
        fun getWidth(sourceFile: SourceFile? = null): Number
        fun getFullWidth(): Number
        fun getLeadingTriviaWidth(sourceFile: SourceFile? = null): Number
        fun getFullText(sourceFile: SourceFile? = null): String
        fun getText(sourceFile: SourceFile? = null): String
        fun getFirstToken(sourceFile: SourceFile? = null): Node
        fun getLastToken(sourceFile: SourceFile? = null): Node
    }
    interface NodeArray<T> : Array<T>, TextRange {
        var hasTrailingComma: Boolean? get() = noImpl; set(value){}
    }
    interface ModifiersArray : NodeArray<Modifier> {
        var flags: NodeFlags
    }
    interface Token : Node {
        var __tokenTag: Any
    }
    interface Modifier : Token
    interface Identifier : PrimaryExpression {
        var text: String
        var originalKeywordKind: SyntaxKind? get() = noImpl; set(value){}
    }
    interface QualifiedName : Node {
        var left: EntityName
        var right: Identifier
    }
    interface Declaration : Node {
        var _declarationBrand: Any
        var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName | BindingPattern */ get() = noImpl; set(value){}
    }
    interface DeclarationStatement : Declaration, Statement {
        override var name: Identifier? get() = noImpl; set(value){}
    }
    interface ComputedPropertyName : Node {
        var expression: Expression
    }
    interface Decorator : Node {
        var expression: LeftHandSideExpression
    }
    interface TypeParameterDeclaration : Declaration {
        override var name: Identifier
        var constraint: TypeNode? get() = noImpl; set(value){}
        var expression: Expression? get() = noImpl; set(value){}
    }
    interface SignatureDeclaration : Declaration {
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = noImpl; set(value){}
        var typeParameters: NodeArray<TypeParameterDeclaration>? get() = noImpl; set(value){}
        var parameters: NodeArray<ParameterDeclaration>
        var type: TypeNode? get() = noImpl; set(value){}
    }
    interface CallSignatureDeclaration : SignatureDeclaration, TypeElement
    interface ConstructSignatureDeclaration : SignatureDeclaration, TypeElement
    interface VariableDeclaration : Declaration {
        override var parent: VariableDeclarationList? get() = noImpl; set(value){}
        override var name: dynamic /* Identifier | BindingPattern */
        var type: TypeNode? get() = noImpl; set(value){}
        var initializer: Expression? get() = noImpl; set(value){}
    }
    interface VariableDeclarationList : Node {
        var declarations: NodeArray<VariableDeclaration>
    }
    interface ParameterDeclaration : Declaration {
        var dotDotDotToken: Node? get() = noImpl; set(value){}
        override var name: dynamic /* Identifier | BindingPattern */
        var questionToken: Node? get() = noImpl; set(value){}
        var type: TypeNode? get() = noImpl; set(value){}
        var initializer: Expression? get() = noImpl; set(value){}
    }
    interface BindingElement : Declaration {
        var propertyName: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = noImpl; set(value){}
        var dotDotDotToken: Node? get() = noImpl; set(value){}
        override var name: dynamic /* Identifier | BindingPattern */
        var initializer: Expression? get() = noImpl; set(value){}
    }
    interface PropertySignature : TypeElement {
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
        override var questionToken: Node? get() = noImpl; set(value){}
        var type: TypeNode? get() = noImpl; set(value){}
        var initializer: Expression? get() = noImpl; set(value){}
    }
    interface PropertyDeclaration : ClassElement {
        var questionToken: Node? get() = noImpl; set(value){}
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
        var type: TypeNode? get() = noImpl; set(value){}
        var initializer: Expression? get() = noImpl; set(value){}
    }
    interface ObjectLiteralElement : Declaration {
        var _objectLiteralBrandBrand: Any
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = noImpl; set(value){}
    }
    interface PropertyAssignment : ObjectLiteralElement {
        var _propertyAssignmentBrand: Any
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
        var questionToken: Node? get() = noImpl; set(value){}
        var initializer: Expression
    }
    interface ShorthandPropertyAssignment : ObjectLiteralElement {
        override var name: Identifier
        var questionToken: Node? get() = noImpl; set(value){}
        var equalsToken: Node? get() = noImpl; set(value){}
        var objectAssignmentInitializer: Expression? get() = noImpl; set(value){}
    }
    interface VariableLikeDeclaration : Declaration {
        var propertyName: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = noImpl; set(value){}
        var dotDotDotToken: Node? get() = noImpl; set(value){}
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName | BindingPattern */
        var questionToken: Node? get() = noImpl; set(value){}
        var type: TypeNode? get() = noImpl; set(value){}
        var initializer: Expression? get() = noImpl; set(value){}
    }
    interface PropertyLikeDeclaration : Declaration {
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
    }
    interface BindingPattern : Node {
        var elements: NodeArray<BindingElement>
    }
    interface ObjectBindingPattern : BindingPattern
    interface ArrayBindingPattern : BindingPattern
    interface FunctionLikeDeclaration : SignatureDeclaration {
        var _functionLikeDeclarationBrand: Any
        var asteriskToken: Node? get() = noImpl; set(value){}
        var questionToken: Node? get() = noImpl; set(value){}
        var body: dynamic /* Block | Expression */ get() = noImpl; set(value){}
    }
    interface FunctionDeclaration : FunctionLikeDeclaration, DeclarationStatement {
        override var name: Identifier? get() = noImpl; set(value){}
        override var body: FunctionBody? get() = noImpl; set(value){}
    }
    interface MethodSignature : SignatureDeclaration, TypeElement {
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
    }
    interface MethodDeclaration : FunctionLikeDeclaration, ClassElement, ObjectLiteralElement {
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
        override var body: FunctionBody? get() = noImpl; set(value){}
    }
    interface ConstructorDeclaration : FunctionLikeDeclaration, ClassElement {
        override var body: FunctionBody? get() = noImpl; set(value){}
    }
    interface SemicolonClassElement : ClassElement {
        var _semicolonClassElementBrand: Any
    }
    interface AccessorDeclaration : FunctionLikeDeclaration, ClassElement, ObjectLiteralElement {
        var _accessorDeclarationBrand: Any
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
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
        var typeName: dynamic /* Identifier | QualifiedName */
        var typeArguments: NodeArray<TypeNode>? get() = noImpl; set(value){}
    }
    interface TypePredicateNode : TypeNode {
        var parameterName: dynamic /* Identifier | ThisTypeNode */
        var type: TypeNode
    }
    interface TypeQueryNode : TypeNode {
        var exprName: dynamic /* Identifier | QualifiedName */
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
    interface LiteralTypeNode : TypeNode {
        var _stringLiteralTypeBrand: Any
        var literal: Expression
    }
    interface StringLiteral : LiteralExpression {
        var _stringLiteralBrand: Any
    }
    interface Expression : Node {
        var _expressionBrand: Any
        var contextualType: Type? get() = noImpl; set(value){}
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
        var asteriskToken: Node? get() = noImpl; set(value){}
        var expression: Expression? get() = noImpl; set(value){}
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
    interface FunctionExpression : PrimaryExpression, FunctionLikeDeclaration {
        override var name: Identifier? get() = noImpl; set(value){}
        override var body: Block
    }
    interface ArrowFunction : Expression, FunctionLikeDeclaration {
        var equalsGreaterThanToken: Node
        override var body: dynamic /* Block | Expression */
    }
    interface LiteralLikeNode : Node {
        var text: String
        var isUnterminated: Boolean? get() = noImpl; set(value){}
        var hasExtendedUnicodeEscape: Boolean? get() = noImpl; set(value){}
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
        var expression: LeftHandSideExpression
        override var name: Identifier
    }
    interface PropertyAccessEntityNameExpression : PropertyAccessExpression {
        var _propertyAccessExpressionLikeQualifiedNameBrand: Any? get() = noImpl; set(value){}
        override var expression: dynamic /* Identifier | PropertyAccessEntityNameExpression */
    }
    interface ElementAccessExpression : MemberExpression {
        var expression: LeftHandSideExpression
        var argumentExpression: Expression? get() = noImpl; set(value){}
    }
    interface CallExpression : LeftHandSideExpression, Declaration {
        var expression: LeftHandSideExpression
        var typeArguments: NodeArray<TypeNode>? get() = noImpl; set(value){}
        var arguments: NodeArray<Expression>
    }
    interface ExpressionWithTypeArguments : TypeNode {
        var expression: LeftHandSideExpression
        var typeArguments: NodeArray<TypeNode>? get() = noImpl; set(value){}
    }
    interface NewExpression : CallExpression, PrimaryExpression
    interface TaggedTemplateExpression : MemberExpression {
        var tag: LeftHandSideExpression
        var template: dynamic /* LiteralExpression | TemplateExpression */
    }
    interface AsExpression : Expression {
        var expression: Expression
        var type: TypeNode
    }
    interface TypeAssertion : UnaryExpression {
        var type: TypeNode
        var expression: UnaryExpression
    }
    interface NonNullExpression : LeftHandSideExpression {
        var expression: Expression
    }
    interface JsxElement : PrimaryExpression {
        var openingElement: JsxOpeningElement
        var children: NodeArray<JsxChild>
        var closingElement: JsxClosingElement
    }
    interface JsxOpeningElement : Expression {
        var _openingElementBrand: Any? get() = noImpl; set(value){}
        var tagName: dynamic /* PrimaryExpression | PropertyAccessExpression */
        var attributes: NodeArray<dynamic /* JsxAttribute | JsxSpreadAttribute */>
    }
    interface JsxSelfClosingElement : PrimaryExpression, JsxOpeningElement {
        var _selfClosingElementBrand: Any? get() = noImpl; set(value){}
    }
    interface JsxAttribute : Node {
        var name: Identifier
        var initializer: Expression? get() = noImpl; set(value){}
    }
    interface JsxSpreadAttribute : Node {
        var expression: Expression
    }
    interface JsxClosingElement : Node {
        var tagName: dynamic /* PrimaryExpression | PropertyAccessExpression */
    }
    interface JsxExpression : Expression {
        var expression: Expression? get() = noImpl; set(value){}
    }
    interface JsxText : Node {
        var _jsxTextExpressionBrand: Any
    }
    interface Statement : Node {
        var _statementBrand: Any
    }
    interface EmptyStatement : Statement
    interface DebuggerStatement : Statement
    interface MissingDeclaration : DeclarationStatement, ClassElement, ObjectLiteralElement, TypeElement {
        override var name: Identifier? get() = noImpl; set(value){}
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
        var elseStatement: Statement? get() = noImpl; set(value){}
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
        var initializer: dynamic /* VariableDeclarationList | Expression */ get() = noImpl; set(value){}
        var condition: Expression? get() = noImpl; set(value){}
        var incrementor: Expression? get() = noImpl; set(value){}
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
        var label: Identifier? get() = noImpl; set(value){}
    }
    interface ContinueStatement : Statement {
        var label: Identifier? get() = noImpl; set(value){}
    }
    interface ReturnStatement : Statement {
        var expression: Expression? get() = noImpl; set(value){}
    }
    interface WithStatement : Statement {
        var expression: Expression
        var statement: Statement
    }
    interface SwitchStatement : Statement {
        var expression: Expression
        var caseBlock: CaseBlock
        var possiblyExhaustive: Boolean? get() = noImpl; set(value){}
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
    interface LabeledStatement : Statement {
        var label: Identifier
        var statement: Statement
    }
    interface ThrowStatement : Statement {
        var expression: Expression
    }
    interface TryStatement : Statement {
        var tryBlock: Block
        var catchClause: CatchClause? get() = noImpl; set(value){}
        var finallyBlock: Block? get() = noImpl; set(value){}
    }
    interface CatchClause : Node {
        var variableDeclaration: VariableDeclaration
        var block: Block
    }
    interface ClassLikeDeclaration : Declaration {
        override var name: Identifier? get() = noImpl; set(value){}
        var typeParameters: NodeArray<TypeParameterDeclaration>? get() = noImpl; set(value){}
        var heritageClauses: NodeArray<HeritageClause>? get() = noImpl; set(value){}
        var members: NodeArray<ClassElement>
    }
    interface ClassDeclaration : ClassLikeDeclaration, DeclarationStatement {
        override var name: Identifier? get() = noImpl; set(value){}
    }
    interface ClassExpression : ClassLikeDeclaration, PrimaryExpression
    interface ClassElement : Declaration {
        var _classElementBrand: Any
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = noImpl; set(value){}
    }
    interface TypeElement : Declaration {
        var _typeElementBrand: Any
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = noImpl; set(value){}
        var questionToken: Node? get() = noImpl; set(value){}
    }
    interface InterfaceDeclaration : DeclarationStatement {
        override var name: Identifier
        var typeParameters: NodeArray<TypeParameterDeclaration>? get() = noImpl; set(value){}
        var heritageClauses: NodeArray<HeritageClause>? get() = noImpl; set(value){}
        var members: NodeArray<TypeElement>
    }
    interface HeritageClause : Node {
        var token: SyntaxKind
        var types: NodeArray<ExpressionWithTypeArguments>? get() = noImpl; set(value){}
    }
    interface TypeAliasDeclaration : DeclarationStatement {
        override var name: Identifier
        var typeParameters: NodeArray<TypeParameterDeclaration>? get() = noImpl; set(value){}
        var type: TypeNode
    }
    interface EnumMember : Declaration {
        override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName | BindingPattern */
        var initializer: Expression? get() = noImpl; set(value){}
    }
    interface EnumDeclaration : DeclarationStatement {
        override var name: Identifier
        var members: NodeArray<EnumMember>
    }
    interface ModuleDeclaration : DeclarationStatement {
        override var name: dynamic /* Identifier | LiteralExpression */
        var body: dynamic /* ModuleBlock | ModuleDeclaration */ get() = noImpl; set(value){}
    }
    interface ModuleBlock : Node, Statement {
        var statements: NodeArray<Statement>
    }
    interface ImportEqualsDeclaration : DeclarationStatement {
        override var name: Identifier
        var moduleReference: dynamic /* Identifier | QualifiedName | ExternalModuleReference */
    }
    interface ExternalModuleReference : Node {
        var expression: Expression? get() = noImpl; set(value){}
    }
    interface ImportDeclaration : Statement {
        var importClause: ImportClause? get() = noImpl; set(value){}
        var moduleSpecifier: Expression
    }
    interface ImportClause : Declaration {
        override var name: Identifier? get() = noImpl; set(value){}
        var namedBindings: dynamic /* NamespaceImport | NamedImports */ get() = noImpl; set(value){}
    }
    interface NamespaceImport : Declaration {
        override var name: Identifier
    }
    interface NamespaceExportDeclaration : DeclarationStatement {
        override var name: Identifier
        var moduleReference: LiteralLikeNode
    }
    interface ExportDeclaration : DeclarationStatement {
        var exportClause: NamedExports? get() = noImpl; set(value){}
        var moduleSpecifier: Expression? get() = noImpl; set(value){}
    }
    interface NamedImports : Node {
        var elements: NodeArray<ImportSpecifier>
    }
    interface NamedExports : Node {
        var elements: NodeArray<ExportSpecifier>
    }
    interface ImportSpecifier : Declaration {
        var propertyName: Identifier? get() = noImpl; set(value){}
        override var name: Identifier
    }
    interface ExportSpecifier : Declaration {
        var propertyName: Identifier? get() = noImpl; set(value){}
        override var name: Identifier
    }
    interface ExportAssignment : DeclarationStatement {
        var isExportEquals: Boolean? get() = noImpl; set(value){}
        var expression: Expression
    }
    interface FileReference : TextRange {
        var fileName: String
    }
    interface CommentRange : TextRange {
        var hasTrailingNewLine: Boolean? get() = noImpl; set(value){}
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
        override var members: NodeArray<JSDocRecordMember>
    }
    interface JSDocTypeReference : JSDocType {
        var name: dynamic /* Identifier | QualifiedName */
        var typeArguments: NodeArray<JSDocType>
    }
    interface JSDocOptionalType : JSDocType {
        var type: JSDocType
    }
    interface JSDocFunctionType : JSDocType, SignatureDeclaration {
        override var parameters: NodeArray<ParameterDeclaration>
        override var type: JSDocType
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
    interface JSDocLiteralType : JSDocType {
        var literal: LiteralTypeNode
    }
    interface JSDocRecordMember : PropertySignature {
        override var name: dynamic /* Identifier | LiteralExpression */
        override var type: JSDocType? get() = noImpl; set(value){}
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
    interface JSDocTypedefTag : JSDocTag, Declaration {
        override var name: Identifier? get() = noImpl; set(value){}
        var typeExpression: JSDocTypeExpression? get() = noImpl; set(value){}
        var jsDocTypeLiteral: JSDocTypeLiteral? get() = noImpl; set(value){}
    }
    interface JSDocPropertyTag : JSDocTag, TypeElement {
        override var name: Identifier
        var typeExpression: JSDocTypeExpression
    }
    interface JSDocTypeLiteral : JSDocType {
        var jsDocPropertyTags: NodeArray<JSDocPropertyTag>? get() = noImpl; set(value){}
        var jsDocTypeTag: JSDocTypeTag? get() = noImpl; set(value){}
    }
    interface JSDocParameterTag : JSDocTag {
        var preParameterName: Identifier? get() = noImpl; set(value){}
        var typeExpression: JSDocTypeExpression? get() = noImpl; set(value){}
        var postParameterName: Identifier? get() = noImpl; set(value){}
        var isBracketed: Boolean
    }
    enum class FlowFlags {
        Unreachable /* = 1 */,
        Start /* = 2 */,
        BranchLabel /* = 4 */,
        LoopLabel /* = 8 */,
        Assignment /* = 16 */,
        TrueCondition /* = 32 */,
        FalseCondition /* = 64 */,
        SwitchClause /* = 128 */,
        Referenced /* = 256 */,
        Shared /* = 512 */,
        Label /* = 12 */,
        Condition /* = 96 */
    }
    interface FlowNode {
        var flags: FlowFlags
        var id: Number? get() = noImpl; set(value){}
    }
    interface FlowStart : FlowNode {
        var container: dynamic /* FunctionExpression | ArrowFunction */ get() = noImpl; set(value){}
    }
    interface FlowLabel : FlowNode {
        var antecedents: Array<FlowNode>
    }
    interface FlowAssignment : FlowNode {
        var node: dynamic /* Expression | VariableDeclaration | BindingElement */
        var antecedent: FlowNode
    }
    interface FlowCondition : FlowNode {
        var expression: Expression
        var antecedent: FlowNode
    }
    interface FlowSwitchClause : FlowNode {
        var switchStatement: SwitchStatement
        var clauseStart: Number
        var clauseEnd: Number
        var antecedent: FlowNode
    }
    interface IncompleteType {
        var flags: TypeFlags
        var type: Type
    }
    interface AmdDependency {
        var path: String
        var name: String
    }
    interface SourceFile : Declaration {
        var statements: NodeArray<Statement>
        var endOfFileToken: Node
        var fileName: String
        var path: String /* String & `T$0` */
        var text: String
        var amdDependencies: Array<AmdDependency>
        var moduleName: String
        var referencedFiles: Array<FileReference>
        var typeReferenceDirectives: Array<FileReference>
        var languageVariant: LanguageVariant
        var isDeclarationFile: Boolean
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
        fun getSourceFileByPath(path: String /* String & `T$0` */): SourceFile
        fun getCurrentDirectory(): String
    }
    interface ParseConfigHost {
        var useCaseSensitiveFileNames: Boolean
        fun readDirectory(rootDir: String, extensions: Array<String>, excludes: Array<String>, includes: Array<String>): Array<String>
        fun fileExists(path: String): Boolean
    }
    interface WriteFileCallback {
        @nativeInvoke
        fun invoke(fileName: String, data: String, writeByteOrderMark: Boolean, onError: ((message: String) -> Unit)? = null, sourceFiles: Array<SourceFile>? = null)
    }
    open class OperationCanceledException
    interface CancellationToken {
        fun isCancellationRequested(): Boolean
        fun throwIfCancellationRequested()
    }
    interface Program : ScriptReferenceHost {
        fun getRootFileNames(): Array<String>
        fun getSourceFiles(): Array<SourceFile>
        fun emit(targetSourceFile: SourceFile? = null, writeFile: WriteFileCallback? = null, cancellationToken: CancellationToken? = null, emitOnlyDtsFiles: Boolean? = null): EmitResult
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
        var nameIndex: Number? get() = noImpl; set(value){}
        var sourceIndex: Number
    }
    interface SourceMapData {
        var sourceMapFilePath: String
        var jsSourceMappingURL: String
        var sourceMapFile: String
        var sourceMapSourceRoot: String
        var sourceMapSources: Array<String>
        var sourceMapSourcesContent: Array<String>? get() = noImpl; set(value){}
        var inputSourceFileNames: Array<String>
        var sourceMapNames: Array<String>? get() = noImpl; set(value){}
        var sourceMapMappings: String
        var sourceMapDecodedMappings: Array<SourceMapSpan>
    }
    enum class ExitStatus {
        Success /* = 0 */,
        DiagnosticsPresent_OutputsSkipped /* = 1 */,
        DiagnosticsPresent_OutputsGenerated /* = 2 */
    }
    interface EmitResult {
        var emitSkipped: Boolean
        var diagnostics: Array<Diagnostic>
        var emittedFiles: Array<String>
    }
    interface TypeChecker {
        fun getTypeOfSymbolAtLocation(symbol: Symbol, node: Node): Type
        fun getDeclaredTypeOfSymbol(symbol: Symbol): Type
        fun getPropertiesOfType(type: Type): Array<Symbol>
        fun getPropertyOfType(type: Type, propertyName: String): Symbol
        fun getSignaturesOfType(type: Type, kind: SignatureKind): Array<Signature>
        fun getIndexTypeOfType(type: Type, kind: IndexKind): Type
        fun getBaseTypes(type: InterfaceType): Array<ObjectType>
        fun getReturnTypeOfSignature(signature: Signature): Type
        fun getNonNullableType(type: Type): Type
        fun getSymbolsInScope(location: Node, meaning: SymbolFlags): Array<Symbol>
        fun getSymbolAtLocation(node: Node): Symbol
        fun getSymbolsOfParameterPropertyDeclaration(parameter: ParameterDeclaration, parameterName: String): Array<Symbol>
        fun getShorthandAssignmentValueSymbol(location: Node): Symbol
        fun getExportSpecifierLocalTargetSymbol(location: ExportSpecifier): Symbol
        fun getPropertySymbolOfDestructuringAssignment(location: Identifier): Symbol
        fun getTypeAtLocation(node: Node): Type
        fun typeToString(type: Type, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null): String
        fun symbolToString(symbol: Symbol, enclosingDeclaration: Node? = null, meaning: SymbolFlags? = null): String
        fun getSymbolDisplayBuilder(): SymbolDisplayBuilder
        fun getFullyQualifiedName(symbol: Symbol): String
        fun getAugmentedPropertiesOfType(type: Type): Array<Symbol>
        fun getRootSymbols(symbol: Symbol): Array<Symbol>
        fun getContextualType(node: Expression): Type
        fun getResolvedSignature(node: CallExpression, candidatesOutArray: Array<Signature>? = null): Signature
        fun getResolvedSignature(node: NewExpression, candidatesOutArray: Array<Signature>? = null): Signature
        fun getResolvedSignature(node: TaggedTemplateExpression, candidatesOutArray: Array<Signature>? = null): Signature
        fun getResolvedSignature(node: Decorator, candidatesOutArray: Array<Signature>? = null): Signature
        fun getSignatureFromDeclaration(declaration: SignatureDeclaration): Signature
        fun isImplementationOfOverload(node: FunctionLikeDeclaration): Boolean
        fun isUndefinedSymbol(symbol: Symbol): Boolean
        fun isArgumentsSymbol(symbol: Symbol): Boolean
        fun isUnknownSymbol(symbol: Symbol): Boolean
        fun getConstantValue(node: EnumMember): Number
        fun getConstantValue(node: PropertyAccessExpression): Number
        fun getConstantValue(node: ElementAccessExpression): Number
        fun isValidPropertyAccess(node: PropertyAccessExpression, propertyName: String): Boolean
        fun isValidPropertyAccess(node: QualifiedName, propertyName: String): Boolean
        fun getAliasedSymbol(symbol: Symbol): Symbol
        fun getExportsOfModule(moduleSymbol: Symbol): Array<Symbol>
        fun getJsxElementAttributesType(elementNode: JsxSelfClosingElement): Type
        fun getJsxElementAttributesType(elementNode: JsxOpeningElement): Type
        fun getJsxIntrinsicTagNames(): Array<Symbol>
        fun isOptionalParameter(node: ParameterDeclaration): Boolean
        fun getAmbientModules(): Array<Symbol>
    }
    interface SymbolDisplayBuilder {
        fun buildTypeDisplay(type: Type, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        fun buildSymbolDisplay(symbol: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = null, meaning: SymbolFlags? = null, flags: SymbolFormatFlags? = null)
        fun buildSignatureDisplay(signatures: Signature, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null, kind: SignatureKind? = null)
        fun buildParameterDisplay(parameter: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        fun buildTypeParameterDisplay(tp: TypeParameter, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        fun buildTypePredicateDisplay(predicate: TypePredicate, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        fun buildTypeParameterDisplayFromSymbol(symbol: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
        fun buildDisplayForParametersAndDelimiters(thisParameter: Symbol, parameters: Array<Symbol>, writer: SymbolWriter, enclosingDeclaration: Node? = null, flags: TypeFormatFlags? = null)
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
    enum class TypeFormatFlags {
        None /* = 0 */,
        WriteArrayAsGenericType /* = 1 */,
        UseTypeOfFunction /* = 2 */,
        NoTruncation /* = 4 */,
        WriteArrowStyleSignature /* = 8 */,
        WriteOwnNameForAnyLike /* = 16 */,
        WriteTypeArgumentsOfSignature /* = 32 */,
        InElementType /* = 64 */,
        UseFullyQualifiedType /* = 128 */,
        InFirstTypeArgument /* = 256 */,
        InTypeAlias /* = 512 */
    }
    enum class SymbolFormatFlags {
        None /* = 0 */,
        WriteTypeParametersOrArguments /* = 1 */,
        UseOnlyExternalAliasing /* = 2 */
    }
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
        Type /* = 793064 */,
        Namespace /* = 1920 */,
        Module /* = 1536 */,
        Accessor /* = 98304 */,
        FunctionScopedVariableExcludes /* = 107454 */,
        BlockScopedVariableExcludes /* = 107455 */,
        ParameterExcludes /* = 107455 */,
        PropertyExcludes /* = 0 */,
        EnumMemberExcludes /* = 900095 */,
        FunctionExcludes /* = 106927 */,
        ClassExcludes /* = 899519 */,
        InterfaceExcludes /* = 792968 */,
        RegularEnumExcludes /* = 899327 */,
        ConstEnumExcludes /* = 899967 */,
        ValueModuleExcludes /* = 106639 */,
        NamespaceModuleExcludes /* = 0 */,
        MethodExcludes /* = 99263 */,
        GetAccessorExcludes /* = 41919 */,
        SetAccessorExcludes /* = 74687 */,
        TypeParameterExcludes /* = 530920 */,
        TypeAliasExcludes /* = 793064 */,
        AliasExcludes /* = 8388608 */,
        ModuleMember /* = 8914931 */,
        ExportHasLocal /* = 944 */,
        HasExports /* = 1952 */,
        HasMembers /* = 6240 */,
        BlockScoped /* = 418 */,
        PropertyOrAccessor /* = 98308 */,
        Export /* = 7340032 */,
        ClassMember /* = 106500 */
    }
    interface Symbol {
        var flags: SymbolFlags
        var name: String
        var declarations: Array<Declaration>? get() = noImpl; set(value){}
        var valueDeclaration: Declaration? get() = noImpl; set(value){}
        var members: SymbolTable? get() = noImpl; set(value){}
        var exports: SymbolTable? get() = noImpl; set(value){}
        var globalExports: SymbolTable? get() = noImpl; set(value){}
        fun getFlags(): SymbolFlags
        fun getName(): String
        fun getDeclarations(): Array<Declaration>
        fun getDocumentationComment(): Array<SymbolDisplayPart>
    }
    enum class TypeFlags {
        Any /* = 1 */,
        String /* = 2 */,
        Number /* = 4 */,
        Boolean /* = 8 */,
        Enum /* = 16 */,
        StringLiteral /* = 32 */,
        NumberLiteral /* = 64 */,
        BooleanLiteral /* = 128 */,
        EnumLiteral /* = 256 */,
        ESSymbol /* = 512 */,
        Void /* = 1024 */,
        Undefined /* = 2048 */,
        Null /* = 4096 */,
        Never /* = 8192 */,
        TypeParameter /* = 16384 */,
        Class /* = 32768 */,
        Interface /* = 65536 */,
        Reference /* = 131072 */,
        Tuple /* = 262144 */,
        Union /* = 524288 */,
        Intersection /* = 1048576 */,
        Anonymous /* = 2097152 */,
        Instantiated /* = 4194304 */,
        ThisType /* = 268435456 */,
        ObjectLiteralPatternWithComputedProperties /* = 536870912 */,
        Literal /* = 480 */,
        PossiblyFalsy /* = 7406 */,
        StringLike /* = 34 */,
        NumberLike /* = 340 */,
        BooleanLike /* = 136 */,
        EnumLike /* = 272 */,
        ObjectType /* = 2588672 */,
        UnionOrIntersection /* = 1572864 */,
        StructuredType /* = 4161536 */,
        StructuredOrTypeParameter /* = 4177920 */,
        Narrowable /* = 4178943 */,
        NotUnionOrUnit /* = 2589191 */
    }
    interface Type {
        var flags: TypeFlags
        var symbol: Symbol? get() = noImpl; set(value){}
        var pattern: dynamic /* BindingPattern | ObjectLiteralExpression | ArrayLiteralExpression */ get() = noImpl; set(value){}
        var aliasSymbol: Symbol? get() = noImpl; set(value){}
        var aliasTypeArguments: Array<Type>? get() = noImpl; set(value){}
        fun getFlags(): TypeFlags
        fun getSymbol(): Symbol
        fun getProperties(): Array<Symbol>
        fun getProperty(propertyName: String): Symbol
        fun getApparentProperties(): Array<Symbol>
        fun getCallSignatures(): Array<Signature>
        fun getConstructSignatures(): Array<Signature>
        fun getStringIndexType(): Type
        fun getNumberIndexType(): Type
        fun getBaseTypes(): Array<ObjectType>
        fun getNonNullableType(): Type
    }
    interface LiteralType : Type {
        var text: String
    }
    interface EnumType : Type {
        var memberTypes: Map<EnumLiteralType>
    }
    interface EnumLiteralType : LiteralType {
        var baseType: EnumType /* EnumType & UnionType */
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
        var declaredStringIndexInfo: IndexInfo
        var declaredNumberIndexInfo: IndexInfo
    }
    interface TypeReference : ObjectType {
        var target: GenericType
        var typeArguments: Array<Type>
    }
    interface GenericType : InterfaceType, TypeReference
    interface UnionOrIntersectionType : Type {
        var types: Array<Type>
    }
    interface UnionType : UnionOrIntersectionType
    interface IntersectionType : UnionOrIntersectionType
    interface TypeParameter : Type {
        var constraint: Type
    }
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
    enum class IndexKind {
        String /* = 0 */,
        Number /* = 1 */
    }
    interface IndexInfo {
        var type: Type
        var isReadonly: Boolean
        var declaration: SignatureDeclaration? get() = noImpl; set(value){}
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
        var next: DiagnosticMessageChain? get() = noImpl; set(value){}
    }
    interface Diagnostic {
        var file: SourceFile
        var start: Number
        var length: Number
        var messageText: dynamic /* String | DiagnosticMessageChain */
        var category: DiagnosticCategory
        var code: Number
    }
    enum class DiagnosticCategory {
        Warning /* = 0 */,
        Error /* = 1 */,
        Message /* = 2 */
    }
    enum class ModuleResolutionKind {
        Classic /* = 1 */,
        NodeJs /* = 2 */
    }
    interface CompilerOptions {
        var allowJs: Boolean? get() = noImpl; set(value){}
        var allowSyntheticDefaultImports: Boolean? get() = noImpl; set(value){}
        var allowUnreachableCode: Boolean? get() = noImpl; set(value){}
        var allowUnusedLabels: Boolean? get() = noImpl; set(value){}
        var baseUrl: String? get() = noImpl; set(value){}
        var charset: String? get() = noImpl; set(value){}
        var declaration: Boolean? get() = noImpl; set(value){}
        var declarationDir: String? get() = noImpl; set(value){}
        var disableSizeLimit: Boolean? get() = noImpl; set(value){}
        var emitBOM: Boolean? get() = noImpl; set(value){}
        var emitDecoratorMetadata: Boolean? get() = noImpl; set(value){}
        var experimentalDecorators: Boolean? get() = noImpl; set(value){}
        var forceConsistentCasingInFileNames: Boolean? get() = noImpl; set(value){}
        var inlineSourceMap: Boolean? get() = noImpl; set(value){}
        var inlineSources: Boolean? get() = noImpl; set(value){}
        var isolatedModules: Boolean? get() = noImpl; set(value){}
        var jsx: JsxEmit? get() = noImpl; set(value){}
        var lib: Array<String>? get() = noImpl; set(value){}
        var locale: String? get() = noImpl; set(value){}
        var mapRoot: String? get() = noImpl; set(value){}
        var maxNodeModuleJsDepth: Number? get() = noImpl; set(value){}
        var module: ModuleKind? get() = noImpl; set(value){}
        var moduleResolution: ModuleResolutionKind? get() = noImpl; set(value){}
        var newLine: NewLineKind? get() = noImpl; set(value){}
        var noEmit: Boolean? get() = noImpl; set(value){}
        var noEmitHelpers: Boolean? get() = noImpl; set(value){}
        var noEmitOnError: Boolean? get() = noImpl; set(value){}
        var noErrorTruncation: Boolean? get() = noImpl; set(value){}
        var noFallthroughCasesInSwitch: Boolean? get() = noImpl; set(value){}
        var noImplicitAny: Boolean? get() = noImpl; set(value){}
        var noImplicitReturns: Boolean? get() = noImpl; set(value){}
        var noImplicitThis: Boolean? get() = noImpl; set(value){}
        var noUnusedLocals: Boolean? get() = noImpl; set(value){}
        var noUnusedParameters: Boolean? get() = noImpl; set(value){}
        var noImplicitUseStrict: Boolean? get() = noImpl; set(value){}
        var noLib: Boolean? get() = noImpl; set(value){}
        var noResolve: Boolean? get() = noImpl; set(value){}
        var out: String? get() = noImpl; set(value){}
        var outDir: String? get() = noImpl; set(value){}
        var outFile: String? get() = noImpl; set(value){}
        var paths: MapLike<Array<String>>? get() = noImpl; set(value){}
        var preserveConstEnums: Boolean? get() = noImpl; set(value){}
        var project: String? get() = noImpl; set(value){}
        var reactNamespace: String? get() = noImpl; set(value){}
        var removeComments: Boolean? get() = noImpl; set(value){}
        var rootDir: String? get() = noImpl; set(value){}
        var rootDirs: Array<String>? get() = noImpl; set(value){}
        var skipLibCheck: Boolean? get() = noImpl; set(value){}
        var skipDefaultLibCheck: Boolean? get() = noImpl; set(value){}
        var sourceMap: Boolean? get() = noImpl; set(value){}
        var sourceRoot: String? get() = noImpl; set(value){}
        var strictNullChecks: Boolean? get() = noImpl; set(value){}
        var suppressExcessPropertyErrors: Boolean? get() = noImpl; set(value){}
        var suppressImplicitAnyIndexErrors: Boolean? get() = noImpl; set(value){}
        var target: ScriptTarget? get() = noImpl; set(value){}
        var traceResolution: Boolean? get() = noImpl; set(value){}
        var types: Array<String>? get() = noImpl; set(value){}
        var typeRoots: Array<String>? get() = noImpl; set(value){}
        @nativeGetter
        fun get(option: String): dynamic /* String | Number | Boolean | Array<dynamic /* String | Number */> | Array<String> | MapLike<Array<String>> */
        @nativeSetter
        fun set(option: String, value: String)
        @nativeSetter
        fun set(option: String, value: Number)
        @nativeSetter
        fun set(option: String, value: Boolean)
        @nativeSetter
        fun set(option: String, value: Array<dynamic /* String | Number */>)
        @nativeSetter
        fun set(option: String, value: Array<String>)
        @nativeSetter
        fun set(option: String, value: MapLike<Array<String>>)
    }
    interface TypingOptions {
        var enableAutoDiscovery: Boolean? get() = noImpl; set(value){}
        var include: Array<String>? get() = noImpl; set(value){}
        var exclude: Array<String>? get() = noImpl; set(value){}
        @nativeGetter
        fun get(option: String): dynamic /* Array<String> | Boolean */
        @nativeSetter
        fun set(option: String, value: Array<String>)
        @nativeSetter
        fun set(option: String, value: Boolean)
    }
    interface DiscoverTypingsInfo {
        var fileNames: Array<String>
        var projectRootPath: String
        var safeListPath: String
        var packageNameToTypingLocation: Map<String>
        var typingOptions: TypingOptions
        var compilerOptions: CompilerOptions
    }
    enum class ModuleKind {
        None /* = 0 */,
        CommonJS /* = 1 */,
        AMD /* = 2 */,
        UMD /* = 3 */,
        System /* = 4 */,
        ES6 /* = 5 */,
        ES2015 /* = 5 */
    }
    enum class JsxEmit {
        None /* = 0 */,
        Preserve /* = 1 */,
        React /* = 2 */
    }
    enum class NewLineKind {
        CarriageReturnLineFeed /* = 0 */,
        LineFeed /* = 1 */
    }
    interface LineAndCharacter {
        var line: Number
        var character: Number
    }
    enum class ScriptKind {
        Unknown /* = 0 */,
        JS /* = 1 */,
        JSX /* = 2 */,
        TS /* = 3 */,
        TSX /* = 4 */
    }
    enum class ScriptTarget {
        ES3 /* = 0 */,
        ES5 /* = 1 */,
        ES6 /* = 2 */,
        ES2015 /* = 2 */,
        Latest /* = 2 */
    }
    enum class LanguageVariant {
        Standard /* = 0 */,
        JSX /* = 1 */
    }
    interface ParsedCommandLine {
        var options: CompilerOptions
        var typingOptions: TypingOptions? get() = noImpl; set(value){}
        var fileNames: Array<String>
        var raw: Any? get() = noImpl; set(value){}
        var errors: Array<Diagnostic>
        var wildcardDirectories: MapLike<WatchDirectoryFlags>? get() = noImpl; set(value){}
        var compileOnSave: Boolean? get() = noImpl; set(value){}
    }
    enum class WatchDirectoryFlags {
        None /* = 0 */,
        Recursive /* = 1 */
    }
    interface ExpandResult {
        var fileNames: Array<String>
        var wildcardDirectories: MapLike<WatchDirectoryFlags>
    }
    interface ModuleResolutionHost {
        fun fileExists(fileName: String): Boolean
        fun readFile(fileName: String): String
        val trace: ((s: String) -> Unit)? get() = noImpl
        val directoryExists: ((directoryName: String) -> Boolean)? get() = noImpl
        val realpath: ((path: String) -> String)? get() = noImpl
        val getCurrentDirectory: (() -> String)? get() = noImpl
        val getDirectories: ((path: String) -> Array<String>)? get() = noImpl
    }
    interface ResolvedModule {
        var resolvedFileName: String
        var isExternalLibraryImport: Boolean? get() = noImpl; set(value){}
    }
    interface ResolvedModuleWithFailedLookupLocations {
        var resolvedModule: ResolvedModule
        var failedLookupLocations: Array<String>
    }
    interface ResolvedTypeReferenceDirective {
        var primary: Boolean
        var resolvedFileName: String? get() = noImpl; set(value){}
    }
    interface ResolvedTypeReferenceDirectiveWithFailedLookupLocations {
        var resolvedTypeReferenceDirective: ResolvedTypeReferenceDirective
        var failedLookupLocations: Array<String>
    }
    interface CompilerHost : ModuleResolutionHost {
        fun getSourceFile(fileName: String, languageVersion: ScriptTarget, onError: ((message: String) -> Unit)? = null): SourceFile
        val getSourceFileByPath: (`(fileName: String, path: String /* String & `T$0` */, languageVersion: ScriptTarget, onError: ((message: String) -> Unit)? = null) -> SourceFile`)? get() = noImpl
        val getCancellationToken: (() -> CancellationToken)? get() = noImpl
        fun getDefaultLibFileName(options: CompilerOptions): String
        val getDefaultLibLocation: (() -> String)? get() = noImpl
        var writeFile: WriteFileCallback
        override fun getCurrentDirectory(): String
        override fun getDirectories(path: String): Array<String>
        fun getCanonicalFileName(fileName: String): String
        fun useCaseSensitiveFileNames(): Boolean
        fun getNewLine(): String
        val resolveModuleNames: ((moduleNames: Array<String>, containingFile: String) -> Array<ResolvedModule>)? get() = noImpl
        val resolveTypeReferenceDirectives: ((typeReferenceDirectiveNames: Array<String>, containingFile: String) -> Array<ResolvedTypeReferenceDirective>)? get() = noImpl
    }
    interface TextSpan {
        var start: Number
        var length: Number
    }
    interface TextChangeRange {
        var span: TextSpan
        var newLength: Number
    }
    interface SyntaxList : Node {
        var _children: Array<Node>
    }
    var version: String = noImpl
    interface WatchedFile {
        var fileName: String
        var callback: (fileName: String, removed: Boolean? = null) -> Unit
        var mtime: Date? get() = noImpl; set(value){}
    }
    interface System {
        var args: Array<String>
        var newLine: String
        var useCaseSensitiveFileNames: Boolean
        fun write(s: String)
        fun readFile(path: String, encoding: String? = null): String
        val getFileSize: ((path: String) -> Number)? get() = noImpl
        fun writeFile(path: String, data: String, writeByteOrderMark: Boolean? = null)
        val watchFile: ((path: String, callback: (fileName: String, removed: Boolean? = null) -> Unit, pollingInterval: Number? = null) -> FileWatcher)? get() = noImpl
        val watchDirectory: ((path: String, callback: (fileName: String) -> Unit, recursive: Boolean? = null) -> FileWatcher)? get() = noImpl
        fun resolvePath(path: String): String
        fun fileExists(path: String): Boolean
        fun directoryExists(path: String): Boolean
        fun createDirectory(path: String)
        fun getExecutingFilePath(): String
        fun getCurrentDirectory(): String
        fun getDirectories(path: String): Array<String>
        fun readDirectory(path: String, extensions: Array<String>? = null, exclude: Array<String>? = null, include: Array<String>? = null): Array<String>
        val getModifiedTime: ((path: String) -> Date)? get() = noImpl
        val createHash: ((data: String) -> String)? get() = noImpl
        val getMemoryUsage: (() -> Number)? get() = noImpl
        fun exit(exitCode: Number? = null)
        val realpath: ((path: String) -> String)? get() = noImpl
    }
    interface FileWatcher {
        fun close()
    }
    interface DirectoryWatcher : FileWatcher {
        var directoryName: String
        var referenceCount: Number
    }
    var sys: System = noImpl
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
        fun getText(): String
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
    fun isWhiteSpaceSingleLine(ch: Number): Boolean = noImpl
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
    fun isExternalModule(file: SourceFile): Boolean = noImpl
    fun updateSourceFile(sourceFile: SourceFile, newText: String, textChangeRange: TextChangeRange, aggressiveChecks: Boolean? = null): SourceFile = noImpl
    fun classicNameResolver(moduleName: String, containingFile: String, compilerOptions: CompilerOptions, host: ModuleResolutionHost): ResolvedModuleWithFailedLookupLocations = noImpl
    fun nodeModuleNameResolver(moduleName: String, containingFile: String, compilerOptions: CompilerOptions, host: ModuleResolutionHost): ResolvedModuleWithFailedLookupLocations = noImpl
    fun resolveModuleName(moduleName: String, containingFile: String, compilerOptions: CompilerOptions, host: ModuleResolutionHost): ResolvedModuleWithFailedLookupLocations = noImpl
    fun findConfigFile(searchPath: String, fileExists: (fileName: String) -> Boolean, configName: String? = null): String = noImpl
    fun resolveTripleslashReference(moduleName: String, containingFile: String): String = noImpl
    fun resolveTypeReferenceDirective(typeReferenceDirectiveName: String, containingFile: String, options: CompilerOptions, host: ModuleResolutionHost): ResolvedTypeReferenceDirectiveWithFailedLookupLocations = noImpl
    fun createCompilerHost(options: CompilerOptions, setParentNodes: Boolean? = null): CompilerHost = noImpl
    fun getPreEmitDiagnostics(program: Program, sourceFile: SourceFile? = null, cancellationToken: CancellationToken? = null): Array<Diagnostic> = noImpl
    interface FormatDiagnosticsHost {
        fun getCurrentDirectory(): String
        fun getCanonicalFileName(fileName: String): String
        fun getNewLine(): String
    }
    fun formatDiagnostics(diagnostics: Array<Diagnostic>, host: FormatDiagnosticsHost): String = noImpl
    fun flattenDiagnosticMessageText(messageText: String, newLine: String): String = noImpl
    fun flattenDiagnosticMessageText(messageText: DiagnosticMessageChain, newLine: String): String = noImpl
    fun getAutomaticTypeDirectiveNames(options: CompilerOptions, host: ModuleResolutionHost): Array<String> = noImpl
    fun createProgram(rootNames: Array<String>, options: CompilerOptions, host: CompilerHost? = null, oldProgram: Program? = null): Program = noImpl
    interface `T$1` {
        var config: Any? get() = noImpl; set(value){}
        var error: Diagnostic? get() = noImpl; set(value){}
    }
    fun readConfigFile(fileName: String, readFile: (path: String) -> String): `T$1` = noImpl
    interface `T$2` {
        var config: Any? get() = noImpl; set(value){}
        var error: Diagnostic? get() = noImpl; set(value){}
    }
    fun parseConfigFileTextToJson(fileName: String, jsonText: String, stripComments: Boolean? = null): `T$2` = noImpl
    fun parseJsonConfigFileContent(json: Any, host: ParseConfigHost, basePath: String, existingOptions: CompilerOptions? = null, configFileName: String? = null): ParsedCommandLine = noImpl
    fun convertCompileOnSaveOptionFromJson(jsonOption: Any, basePath: String, errors: Array<Diagnostic>): Boolean = noImpl
    interface `T$3` {
        var options: CompilerOptions
        var errors: Array<Diagnostic>
    }
    fun convertCompilerOptionsFromJson(jsonOptions: Any, basePath: String, configFileName: String? = null): `T$3` = noImpl
    interface `T$4` {
        var options: TypingOptions
        var errors: Array<Diagnostic>
    }
    fun convertTypingOptionsFromJson(jsonOptions: Any, basePath: String, configFileName: String? = null): `T$4` = noImpl
    var servicesVersion: String = noImpl
    interface IScriptSnapshot {
        fun getText(start: Number, end: Number): String
        fun getLength(): Number
        fun getChangeRange(oldSnapshot: IScriptSnapshot): TextChangeRange
        val dispose: (() -> Unit)? get() = noImpl
    }
    @module
    object ScriptSnapshot {
        fun fromString(text: String): IScriptSnapshot = noImpl
    }
    interface PreProcessedFileInfo {
        var referencedFiles: Array<FileReference>
        var typeReferenceDirectives: Array<FileReference>
        var importedFiles: Array<FileReference>
        var ambientExternalModules: Array<String>
        var isLibFile: Boolean
    }
    interface `T$5` {
        var message: String
        var start: Number
        var length: Number
        var category: String
        var code: Number
    }
    fun realizeDiagnostics(diagnostics: Array<Diagnostic>, newLine: String): Array<`T$5`> = noImpl
    interface `T$6` {
        var message: String
        var start: Number
        var length: Number
        var category: String
        var code: Number
    }
    fun realizeDiagnostic(diagnostic: Diagnostic, newLine: String): `T$6` = noImpl
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
        fun getScriptSnapshot(fileName: String): IScriptSnapshot
        val getLocalizedDiagnosticMessages: (() -> Any)? get() = noImpl
        val getCancellationToken: (() -> HostCancellationToken)? get() = noImpl
        fun getCurrentDirectory(): String
        fun getDefaultLibFileName(options: CompilerOptions): String
        val log: ((s: String) -> Unit)? get() = noImpl
        val trace: ((s: String) -> Unit)? get() = noImpl
        val error: ((s: String) -> Unit)? get() = noImpl
        val useCaseSensitiveFileNames: (() -> Boolean)? get() = noImpl
        val readDirectory: ((path: String, extensions: Array<String>? = null, exclude: Array<String>? = null, include: Array<String>? = null) -> Array<String>)? get() = noImpl
        val readFile: ((path: String, encoding: String? = null) -> String)? get() = noImpl
        val fileExists: ((path: String) -> Boolean)? get() = noImpl
        val getTypeRootsVersion: (() -> Number)? get() = noImpl
        val resolveModuleNames: ((moduleNames: Array<String>, containingFile: String) -> Array<ResolvedModule>)? get() = noImpl
        val resolveTypeReferenceDirectives: ((typeDirectiveNames: Array<String>, containingFile: String) -> Array<ResolvedTypeReferenceDirective>)? get() = noImpl
        val directoryExists: ((directoryName: String) -> Boolean)? get() = noImpl
        val getDirectories: ((directoryName: String) -> Array<String>)? get() = noImpl
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
        fun getNavigateToItems(searchValue: String, maxResultCount: Number? = null, excludeDts: Boolean? = null): Array<NavigateToItem>
        fun getNavigationBarItems(fileName: String): Array<NavigationBarItem>
        fun getNavigationTree(fileName: String): NavigationTree
        fun getOutliningSpans(fileName: String): Array<OutliningSpan>
        fun getTodoComments(fileName: String, descriptors: Array<TodoCommentDescriptor>): Array<TodoComment>
        fun getBraceMatchingAtPosition(fileName: String, position: Number): Array<TextSpan>
        fun getIndentationAtPosition(fileName: String, position: Number, options: EditorOptions): Number
        fun getIndentationAtPosition(fileName: String, position: Number, options: EditorSettings): Number
        fun getFormattingEditsForRange(fileName: String, start: Number, end: Number, options: FormatCodeOptions): Array<TextChange>
        fun getFormattingEditsForRange(fileName: String, start: Number, end: Number, options: FormatCodeSettings): Array<TextChange>
        fun getFormattingEditsForDocument(fileName: String, options: FormatCodeOptions): Array<TextChange>
        fun getFormattingEditsForDocument(fileName: String, options: FormatCodeSettings): Array<TextChange>
        fun getFormattingEditsAfterKeystroke(fileName: String, position: Number, key: String, options: FormatCodeOptions): Array<TextChange>
        fun getFormattingEditsAfterKeystroke(fileName: String, position: Number, key: String, options: FormatCodeSettings): Array<TextChange>
        fun getDocCommentTemplateAtPosition(fileName: String, position: Number): TextInsertion
        fun isValidBraceCompletionAtPosition(fileName: String, position: Number, openingBrace: Number): Boolean
        fun getEmitOutput(fileName: String, emitOnlyDtsFiles: Boolean? = null): EmitOutput
        fun getProgram(): Program
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
    interface NavigationTree {
        var text: String
        var kind: String
        var kindModifiers: String
        var spans: Array<TextSpan>
        var childItems: Array<NavigationTree>? get() = noImpl; set(value){}
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
    open class TextChange {
        open var span: TextSpan = noImpl
        open var newText: String = noImpl
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
        var isDefinition: Boolean
    }
    interface DocumentHighlights {
        var fileName: String
        var highlightSpans: Array<HighlightSpan>
    }
    @module
    object HighlightSpanKind {
        var none: String = noImpl
        var definition: String = noImpl
        var reference: String = noImpl
        var writtenReference: String = noImpl
    }
    interface HighlightSpan {
        var fileName: String? get() = noImpl; set(value){}
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
        var BaseIndentSize: Number? get() = noImpl; set(value){}
        var IndentSize: Number
        var TabSize: Number
        var NewLineCharacter: String
        var ConvertTabsToSpaces: Boolean
        var IndentStyle: IndentStyle
    }
    interface EditorSettings {
        var baseIndentSize: Number? get() = noImpl; set(value){}
        var indentSize: Number? get() = noImpl; set(value){}
        var tabSize: Number? get() = noImpl; set(value){}
        var newLineCharacter: String? get() = noImpl; set(value){}
        var convertTabsToSpaces: Boolean? get() = noImpl; set(value){}
        var indentStyle: IndentStyle? get() = noImpl; set(value){}
    }
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
        var InsertSpaceAfterOpeningAndBeforeClosingJsxExpressionBraces: Boolean? get() = noImpl; set(value){}
        var PlaceOpenBraceOnNewLineForFunctions: Boolean
        var PlaceOpenBraceOnNewLineForControlBlocks: Boolean
    }
    interface FormatCodeSettings : EditorSettings {
        var insertSpaceAfterCommaDelimiter: Boolean? get() = noImpl; set(value){}
        var insertSpaceAfterSemicolonInForStatements: Boolean? get() = noImpl; set(value){}
        var insertSpaceBeforeAndAfterBinaryOperators: Boolean? get() = noImpl; set(value){}
        var insertSpaceAfterKeywordsInControlFlowStatements: Boolean? get() = noImpl; set(value){}
        var insertSpaceAfterFunctionKeywordForAnonymousFunctions: Boolean? get() = noImpl; set(value){}
        var insertSpaceAfterOpeningAndBeforeClosingNonemptyParenthesis: Boolean? get() = noImpl; set(value){}
        var insertSpaceAfterOpeningAndBeforeClosingNonemptyBrackets: Boolean? get() = noImpl; set(value){}
        var insertSpaceAfterOpeningAndBeforeClosingTemplateStringBraces: Boolean? get() = noImpl; set(value){}
        var insertSpaceAfterOpeningAndBeforeClosingJsxExpressionBraces: Boolean? get() = noImpl; set(value){}
        var placeOpenBraceOnNewLineForFunctions: Boolean? get() = noImpl; set(value){}
        var placeOpenBraceOnNewLineForControlBlocks: Boolean? get() = noImpl; set(value){}
    }
    fun toEditorSettings(options: EditorOptions): EditorSettings = noImpl
    fun toEditorSettings(options: EditorSettings): EditorSettings = noImpl
    interface DefinitionInfo {
        var fileName: String
        var textSpan: TextSpan
        var kind: String
        var name: String
        var containerKind: String
        var containerName: String
    }
    interface ReferencedSymbolDefinitionInfo : DefinitionInfo {
        var displayParts: Array<SymbolDisplayPart>
    }
    interface ReferencedSymbol {
        var definition: ReferencedSymbolDefinitionInfo
        var references: Array<ReferenceEntry>
    }
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
        var replacementSpan: TextSpan? get() = noImpl; set(value){}
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
    enum class EndOfLineState {
        None /* = 0 */,
        InMultiLineCommentTrivia /* = 1 */,
        InSingleQuoteStringLiteral /* = 2 */,
        InDoubleQuoteStringLiteral /* = 3 */,
        InTemplateHeadOrNoSubstitutionTemplate /* = 4 */,
        InTemplateMiddleOrTail /* = 5 */,
        InTemplateSubstitutionPosition /* = 6 */
    }
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
        fun acquireDocumentWithKey(fileName: String, path: Path, compilationSettings: CompilerOptions, key: DocumentRegistryBucketKey, scriptSnapshot: IScriptSnapshot, version: String, scriptKind: ScriptKind? = null): SourceFile
        fun updateDocument(fileName: String, compilationSettings: CompilerOptions, scriptSnapshot: IScriptSnapshot, version: String, scriptKind: ScriptKind? = null): SourceFile
        fun updateDocumentWithKey(fileName: String, path: Path, compilationSettings: CompilerOptions, key: DocumentRegistryBucketKey, scriptSnapshot: IScriptSnapshot, version: String, scriptKind: ScriptKind? = null): SourceFile
        fun getKeyForCompilationSettings(settings: CompilerOptions): DocumentRegistryBucketKey
        fun releaseDocument(fileName: String, compilationSettings: CompilerOptions)
        fun releaseDocumentWithKey(path: Path, key: DocumentRegistryBucketKey)
        fun reportStats(): String
    }
    interface `T$7` {
        var __bucketKey: Any
    }
    @module
    object ScriptElementKind {
        var unknown: String = noImpl
        var warning: String = noImpl
        var keyword: String = noImpl
        var scriptElement: String = noImpl
        var moduleElement: String = noImpl
        var classElement: String = noImpl
        var localClassElement: String = noImpl
        var interfaceElement: String = noImpl
        var typeElement: String = noImpl
        var enumElement: String = noImpl
        var enumMemberElement: String = noImpl
        var variableElement: String = noImpl
        var localVariableElement: String = noImpl
        var functionElement: String = noImpl
        var localFunctionElement: String = noImpl
        var memberFunctionElement: String = noImpl
        var memberGetAccessorElement: String = noImpl
        var memberSetAccessorElement: String = noImpl
        var memberVariableElement: String = noImpl
        var constructorImplementationElement: String = noImpl
        var callSignatureElement: String = noImpl
        var indexSignatureElement: String = noImpl
        var constructSignatureElement: String = noImpl
        var parameterElement: String = noImpl
        var typeParameterElement: String = noImpl
        var primitiveType: String = noImpl
        var label: String = noImpl
        var alias: String = noImpl
        var constElement: String = noImpl
        var letElement: String = noImpl
        var directory: String = noImpl
        var externalModuleName: String = noImpl
    }
    @module
    object ScriptElementKindModifier {
        var none: String = noImpl
        var publicMemberModifier: String = noImpl
        var privateMemberModifier: String = noImpl
        var protectedMemberModifier: String = noImpl
        var exportedModifier: String = noImpl
        var ambientModifier: String = noImpl
        var staticModifier: String = noImpl
        var abstractModifier: String = noImpl
    }
    open class ClassificationTypeNames {
        companion object {
            var comment: String = noImpl
            var identifier: String = noImpl
            var keyword: String = noImpl
            var numericLiteral: String = noImpl
            var operator: String = noImpl
            var stringLiteral: String = noImpl
            var whiteSpace: String = noImpl
            var text: String = noImpl
            var punctuation: String = noImpl
            var className: String = noImpl
            var enumName: String = noImpl
            var interfaceName: String = noImpl
            var moduleName: String = noImpl
            var typeParameterName: String = noImpl
            var typeAliasName: String = noImpl
            var parameterName: String = noImpl
            var docCommentTagName: String = noImpl
            var jsxOpenTagName: String = noImpl
            var jsxCloseTagName: String = noImpl
            var jsxSelfClosingTagName: String = noImpl
            var jsxAttribute: String = noImpl
            var jsxText: String = noImpl
            var jsxAttributeStringLiteralValue: String = noImpl
        }
    }
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
        var compilerOptions: CompilerOptions? get() = noImpl; set(value){}
        var fileName: String? get() = noImpl; set(value){}
        var reportDiagnostics: Boolean? get() = noImpl; set(value){}
        var moduleName: String? get() = noImpl; set(value){}
        var renamedDependencies: MapLike<String>? get() = noImpl; set(value){}
    }
    interface TranspileOutput {
        var outputText: String
        var diagnostics: Array<Diagnostic>? get() = noImpl; set(value){}
        var sourceMapText: String? get() = noImpl; set(value){}
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
