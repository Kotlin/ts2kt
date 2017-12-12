@file:JsModule("typescript")
package typescriptServices.ts

import typescript.*
import kotlin.js.*

external interface MapLike<T> {
    @nativeGetter
    fun get(index: String): T?
    @nativeSetter
    fun set(index: String, value: T)
}
external interface Map<T> : MapLike<T> {
    var __mapBrand: Any
}
external interface `T$0` {
    var __pathBrand: Any
}
external interface FileMap<T> {
    fun get(fileName: String /* String & `T$0` */): T
    fun set(fileName: String /* String & `T$0` */, value: T)
    fun contains(fileName: String /* String & `T$0` */): Boolean
    fun remove(fileName: String /* String & `T$0` */)
    fun forEachValue(f: (key: String /* String & `T$0` */, v: T) -> Unit)
    fun getKeys(): Array<String /* String & `T$0` */>
    fun clear()
}
external interface TextRange {
    var pos: Number
    var end: Number
}
external enum class SyntaxKind {
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
external enum class NodeFlags {
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
external enum class JsxFlags {
    None /* = 0 */,
    IntrinsicNamedElement /* = 1 */,
    IntrinsicIndexedElement /* = 2 */,
    IntrinsicElement /* = 3 */
}
external interface Node : TextRange {
    var kind: SyntaxKind
    var flags: NodeFlags
    var decorators: NodeArray<Decorator>? get() = definedExternally; set(value) = definedExternally
    var modifiers: ModifiersArray? get() = definedExternally; set(value) = definedExternally
    var parent: Node? get() = definedExternally; set(value) = definedExternally
    fun getSourceFile(): SourceFile
    fun getChildCount(sourceFile: SourceFile? = definedExternally /* null */): Number
    fun getChildAt(index: Number, sourceFile: SourceFile? = definedExternally /* null */): Node
    fun getChildren(sourceFile: SourceFile? = definedExternally /* null */): Array<Node>
    fun getStart(sourceFile: SourceFile? = definedExternally /* null */, includeJsDocComment: Boolean? = definedExternally /* null */): Number
    fun getFullStart(): Number
    fun getEnd(): Number
    fun getWidth(sourceFile: SourceFile? = definedExternally /* null */): Number
    fun getFullWidth(): Number
    fun getLeadingTriviaWidth(sourceFile: SourceFile? = definedExternally /* null */): Number
    fun getFullText(sourceFile: SourceFile? = definedExternally /* null */): String
    fun getText(sourceFile: SourceFile? = definedExternally /* null */): String
    fun getFirstToken(sourceFile: SourceFile? = definedExternally /* null */): Node
    fun getLastToken(sourceFile: SourceFile? = definedExternally /* null */): Node
}
external interface NodeArray<T> : JsArray<T>, TextRange {
    var hasTrailingComma: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface ModifiersArray : NodeArray<Modifier> {
    var flags: NodeFlags
}
external interface Token : Node {
    var __tokenTag: Any
}
external interface Modifier : Token
external interface Identifier : PrimaryExpression {
    var text: String
    var originalKeywordKind: SyntaxKind? get() = definedExternally; set(value) = definedExternally
}
external interface QualifiedName : Node {
    var left: EntityName
    var right: Identifier
}
external interface Declaration : Node {
    var _declarationBrand: Any
    var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName | BindingPattern */ get() = definedExternally; set(value) = definedExternally
}
external interface DeclarationStatement : Declaration, Statement {
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
}
external interface ComputedPropertyName : Node {
    var expression: Expression
}
external interface Decorator : Node {
    var expression: LeftHandSideExpression
}
external interface TypeParameterDeclaration : Declaration {
    override var name: Identifier
    var constraint: TypeNode? get() = definedExternally; set(value) = definedExternally
    var expression: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface SignatureDeclaration : Declaration {
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
    var typeParameters: NodeArray<TypeParameterDeclaration>? get() = definedExternally; set(value) = definedExternally
    var parameters: NodeArray<ParameterDeclaration>
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
}
external interface CallSignatureDeclaration : SignatureDeclaration, TypeElement {
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
}
external interface ConstructSignatureDeclaration : SignatureDeclaration, TypeElement {
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
}
external interface VariableDeclaration : Declaration {
//    override var parent: VariableDeclarationList? get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | BindingPattern */
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface VariableDeclarationList : Node {
    var declarations: NodeArray<VariableDeclaration>
}
external interface ParameterDeclaration : Declaration {
    var dotDotDotToken: Node? get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | BindingPattern */
    var questionToken: Node? get() = definedExternally; set(value) = definedExternally
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface BindingElement : Declaration {
    var propertyName: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
    var dotDotDotToken: Node? get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | BindingPattern */
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface PropertySignature : TypeElement {
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
    override var questionToken: Node? get() = definedExternally; set(value) = definedExternally
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface PropertyDeclaration : ClassElement {
    var questionToken: Node? get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface ObjectLiteralElement : Declaration {
    var _objectLiteralBrandBrand: Any
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
}
external interface PropertyAssignment : ObjectLiteralElement {
    var _propertyAssignmentBrand: Any
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
    var questionToken: Node? get() = definedExternally; set(value) = definedExternally
    var initializer: Expression
}
external interface ShorthandPropertyAssignment : ObjectLiteralElement {
    override var name: Identifier
    var questionToken: Node? get() = definedExternally; set(value) = definedExternally
    var equalsToken: Node? get() = definedExternally; set(value) = definedExternally
    var objectAssignmentInitializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface VariableLikeDeclaration : Declaration {
    var propertyName: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
    var dotDotDotToken: Node? get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName | BindingPattern */
    var questionToken: Node? get() = definedExternally; set(value) = definedExternally
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface PropertyLikeDeclaration : Declaration {
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
}
external interface BindingPattern : Node {
    var elements: NodeArray<BindingElement>
}
external interface ObjectBindingPattern : BindingPattern
external interface ArrayBindingPattern : BindingPattern
external interface FunctionLikeDeclaration : SignatureDeclaration {
    var _functionLikeDeclarationBrand: Any
    var asteriskToken: Node? get() = definedExternally; set(value) = definedExternally
    var questionToken: Node? get() = definedExternally; set(value) = definedExternally
    var body: dynamic /* Block | Expression */ get() = definedExternally; set(value) = definedExternally
}
external interface FunctionDeclaration : FunctionLikeDeclaration, DeclarationStatement {
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
    override var body: FunctionBody? get() = definedExternally; set(value) = definedExternally
}
external interface MethodSignature : SignatureDeclaration, TypeElement {
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
}
external interface MethodDeclaration : FunctionLikeDeclaration, ClassElement, ObjectLiteralElement {
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
    override var body: FunctionBody? get() = definedExternally; set(value) = definedExternally
}
external interface ConstructorDeclaration : FunctionLikeDeclaration, ClassElement {
    override var name: dynamic get() = definedExternally; set(value) = definedExternally
    override var body: FunctionBody? get() = definedExternally; set(value) = definedExternally
}
external interface SemicolonClassElement : ClassElement {
    var _semicolonClassElementBrand: Any
}
external interface AccessorDeclaration : FunctionLikeDeclaration, ClassElement, ObjectLiteralElement {
    var _accessorDeclarationBrand: Any
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */
    override var body: FunctionBody
}
external interface GetAccessorDeclaration : AccessorDeclaration
external interface SetAccessorDeclaration : AccessorDeclaration
external interface IndexSignatureDeclaration : SignatureDeclaration, ClassElement, TypeElement {
    override var name: dynamic get() = definedExternally; set(value) = definedExternally
    var _indexSignatureDeclarationBrand: Any
}
external interface TypeNode : Node {
    var _typeNodeBrand: Any
}
external interface ThisTypeNode : TypeNode {
    var _thisTypeNodeBrand: Any
}
external interface FunctionOrConstructorTypeNode : TypeNode, SignatureDeclaration {
    var _functionOrConstructorTypeNodeBrand: Any
}
external interface FunctionTypeNode : FunctionOrConstructorTypeNode
external interface ConstructorTypeNode : FunctionOrConstructorTypeNode
external interface TypeReferenceNode : TypeNode {
    var typeName: dynamic /* Identifier | QualifiedName */
    var typeArguments: NodeArray<TypeNode>? get() = definedExternally; set(value) = definedExternally
}
external interface TypePredicateNode : TypeNode {
    var parameterName: dynamic /* Identifier | ThisTypeNode */
    var type: TypeNode
}
external interface TypeQueryNode : TypeNode {
    var exprName: dynamic /* Identifier | QualifiedName */
}
external interface TypeLiteralNode : TypeNode, Declaration {
    var members: NodeArray<TypeElement>
}
external interface ArrayTypeNode : TypeNode {
    var elementType: TypeNode
}
external interface TupleTypeNode : TypeNode {
    var elementTypes: NodeArray<TypeNode>
}
external interface UnionOrIntersectionTypeNode : TypeNode {
    var types: NodeArray<TypeNode>
}
external interface UnionTypeNode : UnionOrIntersectionTypeNode
external interface IntersectionTypeNode : UnionOrIntersectionTypeNode
external interface ParenthesizedTypeNode : TypeNode {
    var type: TypeNode
}
external interface LiteralTypeNode : TypeNode {
    var _stringLiteralTypeBrand: Any
    var literal: Expression
}
external interface StringLiteral : LiteralExpression {
    var _stringLiteralBrand: Any
}
external interface Expression : Node {
    var _expressionBrand: Any
    var contextualType: Type? get() = definedExternally; set(value) = definedExternally
}
external interface OmittedExpression : Expression
external interface UnaryExpression : Expression {
    var _unaryExpressionBrand: Any
}
external interface IncrementExpression : UnaryExpression {
    var _incrementExpressionBrand: Any
}
external interface PrefixUnaryExpression : IncrementExpression {
    var operator: SyntaxKind
    var operand: UnaryExpression
}
external interface PostfixUnaryExpression : IncrementExpression {
    var operand: LeftHandSideExpression
    var operator: SyntaxKind
}
external interface PostfixExpression : UnaryExpression {
    var _postfixExpressionBrand: Any
}
external interface LeftHandSideExpression : IncrementExpression {
    var _leftHandSideExpressionBrand: Any
}
external interface MemberExpression : LeftHandSideExpression {
    var _memberExpressionBrand: Any
}
external interface PrimaryExpression : MemberExpression {
    var _primaryExpressionBrand: Any
}
external interface DeleteExpression : UnaryExpression {
    var expression: UnaryExpression
}
external interface TypeOfExpression : UnaryExpression {
    var expression: UnaryExpression
}
external interface VoidExpression : UnaryExpression {
    var expression: UnaryExpression
}
external interface AwaitExpression : UnaryExpression {
    var expression: UnaryExpression
}
external interface YieldExpression : Expression {
    var asteriskToken: Node? get() = definedExternally; set(value) = definedExternally
    var expression: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface BinaryExpression : Expression, Declaration {
    var left: Expression
    var operatorToken: Node
    var right: Expression
}
external interface ConditionalExpression : Expression {
    var condition: Expression
    var questionToken: Node
    var whenTrue: Expression
    var colonToken: Node
    var whenFalse: Expression
}
external interface FunctionExpression : PrimaryExpression, FunctionLikeDeclaration {
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
    override var body: Block
}
external interface ArrowFunction : Expression, FunctionLikeDeclaration {
    var equalsGreaterThanToken: Node
    override var body: dynamic /* Block | Expression */
}
external interface LiteralLikeNode : Node {
    var text: String
    var isUnterminated: Boolean? get() = definedExternally; set(value) = definedExternally
    var hasExtendedUnicodeEscape: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface LiteralExpression : LiteralLikeNode, PrimaryExpression {
    var _literalExpressionBrand: Any
}
external interface TemplateLiteralFragment : LiteralLikeNode {
    var _templateLiteralFragmentBrand: Any
}
external interface TemplateExpression : PrimaryExpression {
    var head: TemplateLiteralFragment
    var templateSpans: NodeArray<TemplateSpan>
}
external interface TemplateSpan : Node {
    var expression: Expression
    var literal: TemplateLiteralFragment
}
external interface ParenthesizedExpression : PrimaryExpression {
    var expression: Expression
}
external interface ArrayLiteralExpression : PrimaryExpression {
    var elements: NodeArray<Expression>
}
external interface SpreadElementExpression : Expression {
    var expression: Expression
}
external interface ObjectLiteralExpression : PrimaryExpression, Declaration {
    var properties: NodeArray<ObjectLiteralElement>
}
external interface PropertyAccessExpression : MemberExpression, Declaration {
    var expression: LeftHandSideExpression
    override var name: Identifier
}
external interface PropertyAccessEntityNameExpression : PropertyAccessExpression {
    var _propertyAccessExpressionLikeQualifiedNameBrand: Any? get() = definedExternally; set(value) = definedExternally
    override var expression: dynamic /* Identifier | PropertyAccessEntityNameExpression */
}
external interface ElementAccessExpression : MemberExpression {
    var expression: LeftHandSideExpression
    var argumentExpression: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface CallExpression : LeftHandSideExpression, Declaration {
    var expression: LeftHandSideExpression
    var typeArguments: NodeArray<TypeNode>? get() = definedExternally; set(value) = definedExternally
    var arguments: NodeArray<Expression>
}
external interface ExpressionWithTypeArguments : TypeNode {
    var expression: LeftHandSideExpression
    var typeArguments: NodeArray<TypeNode>? get() = definedExternally; set(value) = definedExternally
}
external interface NewExpression : CallExpression, PrimaryExpression
external interface TaggedTemplateExpression : MemberExpression {
    var tag: LeftHandSideExpression
    var template: dynamic /* LiteralExpression | TemplateExpression */
}
external interface AsExpression : Expression {
    var expression: Expression
    var type: TypeNode
}
external interface TypeAssertion : UnaryExpression {
    var type: TypeNode
    var expression: UnaryExpression
}
external interface NonNullExpression : LeftHandSideExpression {
    var expression: Expression
}
external interface JsxElement : PrimaryExpression {
    var openingElement: JsxOpeningElement
    var children: NodeArray<JsxChild>
    var closingElement: JsxClosingElement
}
external interface JsxOpeningElement : Expression {
    var _openingElementBrand: Any? get() = definedExternally; set(value) = definedExternally
    var tagName: dynamic /* PrimaryExpression | PropertyAccessExpression */
    var attributes: NodeArray<dynamic /* JsxAttribute | JsxSpreadAttribute */>
}
external interface JsxSelfClosingElement : PrimaryExpression, JsxOpeningElement {
    var _selfClosingElementBrand: Any? get() = definedExternally; set(value) = definedExternally
}
external interface JsxAttribute : Node {
    var name: Identifier
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface JsxSpreadAttribute : Node {
    var expression: Expression
}
external interface JsxClosingElement : Node {
    var tagName: dynamic /* PrimaryExpression | PropertyAccessExpression */
}
external interface JsxExpression : Expression {
    var expression: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface JsxText : Node {
    var _jsxTextExpressionBrand: Any
}
external interface Statement : Node {
    var _statementBrand: Any
}
external interface EmptyStatement : Statement
external interface DebuggerStatement : Statement
external interface MissingDeclaration : DeclarationStatement, ClassElement, ObjectLiteralElement, TypeElement {
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
}
external interface Block : Statement {
    var statements: NodeArray<Statement>
}
external interface VariableStatement : Statement {
    var declarationList: VariableDeclarationList
}
external interface ExpressionStatement : Statement {
    var expression: Expression
}
external interface IfStatement : Statement {
    var expression: Expression
    var thenStatement: Statement
    var elseStatement: Statement? get() = definedExternally; set(value) = definedExternally
}
external interface IterationStatement : Statement {
    var statement: Statement
}
external interface DoStatement : IterationStatement {
    var expression: Expression
}
external interface WhileStatement : IterationStatement {
    var expression: Expression
}
external interface ForStatement : IterationStatement {
    var initializer: dynamic /* VariableDeclarationList | Expression */ get() = definedExternally; set(value) = definedExternally
    var condition: Expression? get() = definedExternally; set(value) = definedExternally
    var incrementor: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface ForInStatement : IterationStatement {
    var initializer: dynamic /* VariableDeclarationList | Expression */
    var expression: Expression
}
external interface ForOfStatement : IterationStatement {
    var initializer: dynamic /* VariableDeclarationList | Expression */
    var expression: Expression
}
external interface BreakStatement : Statement {
    var label: Identifier? get() = definedExternally; set(value) = definedExternally
}
external interface ContinueStatement : Statement {
    var label: Identifier? get() = definedExternally; set(value) = definedExternally
}
external interface ReturnStatement : Statement {
    var expression: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface WithStatement : Statement {
    var expression: Expression
    var statement: Statement
}
external interface SwitchStatement : Statement {
    var expression: Expression
    var caseBlock: CaseBlock
    var possiblyExhaustive: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface CaseBlock : Node {
    var clauses: NodeArray<CaseOrDefaultClause>
}
external interface CaseClause : Node {
    var expression: Expression
    var statements: NodeArray<Statement>
}
external interface DefaultClause : Node {
    var statements: NodeArray<Statement>
}
external interface LabeledStatement : Statement {
    var label: Identifier
    var statement: Statement
}
external interface ThrowStatement : Statement {
    var expression: Expression
}
external interface TryStatement : Statement {
    var tryBlock: Block
    var catchClause: CatchClause? get() = definedExternally; set(value) = definedExternally
    var finallyBlock: Block? get() = definedExternally; set(value) = definedExternally
}
external interface CatchClause : Node {
    var variableDeclaration: VariableDeclaration
    var block: Block
}
external interface ClassLikeDeclaration : Declaration {
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
    var typeParameters: NodeArray<TypeParameterDeclaration>? get() = definedExternally; set(value) = definedExternally
    var heritageClauses: NodeArray<HeritageClause>? get() = definedExternally; set(value) = definedExternally
    var members: NodeArray<ClassElement>
}
external interface ClassDeclaration : ClassLikeDeclaration, DeclarationStatement {
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
}
external interface ClassExpression : ClassLikeDeclaration, PrimaryExpression
external interface ClassElement : Declaration {
    var _classElementBrand: Any
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
}
external interface TypeElement : Declaration {
    var _typeElementBrand: Any
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
    var questionToken: Node? get() = definedExternally; set(value) = definedExternally
}
external interface InterfaceDeclaration : DeclarationStatement {
    override var name: Identifier?
    var typeParameters: NodeArray<TypeParameterDeclaration>? get() = definedExternally; set(value) = definedExternally
    var heritageClauses: NodeArray<HeritageClause>? get() = definedExternally; set(value) = definedExternally
    var members: NodeArray<TypeElement>
}
external interface HeritageClause : Node {
    var token: SyntaxKind
    var types: NodeArray<ExpressionWithTypeArguments>? get() = definedExternally; set(value) = definedExternally
}
external interface TypeAliasDeclaration : DeclarationStatement {
    override var name: Identifier?
    var typeParameters: NodeArray<TypeParameterDeclaration>? get() = definedExternally; set(value) = definedExternally
    var type: TypeNode
}
external interface EnumMember : Declaration {
    override var name: dynamic /* Identifier | LiteralExpression | ComputedPropertyName | BindingPattern */
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface EnumDeclaration : DeclarationStatement {
    override var name: Identifier?
    var members: NodeArray<EnumMember>
}
external interface ModuleDeclaration : DeclarationStatement {
    override var name: dynamic /* Identifier | LiteralExpression */
    var body: dynamic /* ModuleBlock | ModuleDeclaration */ get() = definedExternally; set(value) = definedExternally
}
external interface ModuleBlock : Node, Statement {
    var statements: NodeArray<Statement>
}
external interface ImportEqualsDeclaration : DeclarationStatement {
    override var name: Identifier?
    var moduleReference: dynamic /* Identifier | QualifiedName | ExternalModuleReference */
}
external interface ExternalModuleReference : Node {
    var expression: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface ImportDeclaration : Statement {
    var importClause: ImportClause? get() = definedExternally; set(value) = definedExternally
    var moduleSpecifier: Expression
}
external interface ImportClause : Declaration {
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
    var namedBindings: dynamic /* NamespaceImport | NamedImports */ get() = definedExternally; set(value) = definedExternally
}
external interface NamespaceImport : Declaration {
    override var name: Identifier
}
external interface NamespaceExportDeclaration : DeclarationStatement {
    override var name: Identifier?
    var moduleReference: LiteralLikeNode
}
external interface ExportDeclaration : DeclarationStatement {
    var exportClause: NamedExports? get() = definedExternally; set(value) = definedExternally
    var moduleSpecifier: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface NamedImports : Node {
    var elements: NodeArray<ImportSpecifier>
}
external interface NamedExports : Node {
    var elements: NodeArray<ExportSpecifier>
}
external interface ImportSpecifier : Declaration {
    var propertyName: Identifier? get() = definedExternally; set(value) = definedExternally
    override var name: Identifier
}
external interface ExportSpecifier : Declaration {
    var propertyName: Identifier? get() = definedExternally; set(value) = definedExternally
    override var name: Identifier
}
external interface ExportAssignment : DeclarationStatement {
    var isExportEquals: Boolean? get() = definedExternally; set(value) = definedExternally
    var expression: Expression
}
external interface FileReference : TextRange {
    var fileName: String
}
external interface CommentRange : TextRange {
    var hasTrailingNewLine: Boolean? get() = definedExternally; set(value) = definedExternally
    var kind: SyntaxKind
}
external interface JSDocTypeExpression : Node {
    var type: JSDocType
}
external interface JSDocType : TypeNode {
    var _jsDocTypeBrand: Any
}
external interface JSDocAllType : JSDocType {
    var _JSDocAllTypeBrand: Any
}
external interface JSDocUnknownType : JSDocType {
    var _JSDocUnknownTypeBrand: Any
}
external interface JSDocArrayType : JSDocType {
    var elementType: JSDocType
}
external interface JSDocUnionType : JSDocType {
    var types: NodeArray<JSDocType>
}
external interface JSDocTupleType : JSDocType {
    var types: NodeArray<JSDocType>
}
external interface JSDocNonNullableType : JSDocType {
    var type: JSDocType
}
external interface JSDocNullableType : JSDocType {
    var type: JSDocType
}
external interface JSDocRecordType : JSDocType, TypeLiteralNode {
//    override var members: NodeArray<JSDocRecordMember>
}
external interface JSDocTypeReference : JSDocType {
    var name: dynamic /* Identifier | QualifiedName */
    var typeArguments: NodeArray<JSDocType>
}
external interface JSDocOptionalType : JSDocType {
    var type: JSDocType
}
external interface JSDocFunctionType : JSDocType, SignatureDeclaration {
    override var parameters: NodeArray<ParameterDeclaration>
//    override var type: JSDocType
}
external interface JSDocVariadicType : JSDocType {
    var type: JSDocType
}
external interface JSDocConstructorType : JSDocType {
    var type: JSDocType
}
external interface JSDocThisType : JSDocType {
    var type: JSDocType
}
external interface JSDocLiteralType : JSDocType {
    var literal: LiteralTypeNode
}
external interface JSDocRecordMember : PropertySignature {
    override var name: dynamic /* Identifier | LiteralExpression */
//    override var type: JSDocType? get() = definedExternally; set(value) = definedExternally
}
external interface JSDocComment : Node {
    var tags: NodeArray<JSDocTag>
}
external interface JSDocTag : Node {
    var atToken: Node
    var tagName: Identifier
}
external interface JSDocTemplateTag : JSDocTag {
    var typeParameters: NodeArray<TypeParameterDeclaration>
}
external interface JSDocReturnTag : JSDocTag {
    var typeExpression: JSDocTypeExpression
}
external interface JSDocTypeTag : JSDocTag {
    var typeExpression: JSDocTypeExpression
}
external interface JSDocTypedefTag : JSDocTag, Declaration {
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
    var typeExpression: JSDocTypeExpression? get() = definedExternally; set(value) = definedExternally
    var jsDocTypeLiteral: JSDocTypeLiteral? get() = definedExternally; set(value) = definedExternally
}
external interface JSDocPropertyTag : JSDocTag, TypeElement {
    override var name: Identifier
    var typeExpression: JSDocTypeExpression
}
external interface JSDocTypeLiteral : JSDocType {
    var jsDocPropertyTags: NodeArray<JSDocPropertyTag>? get() = definedExternally; set(value) = definedExternally
    var jsDocTypeTag: JSDocTypeTag? get() = definedExternally; set(value) = definedExternally
}
external interface JSDocParameterTag : JSDocTag {
    var preParameterName: Identifier? get() = definedExternally; set(value) = definedExternally
    var typeExpression: JSDocTypeExpression? get() = definedExternally; set(value) = definedExternally
    var postParameterName: Identifier? get() = definedExternally; set(value) = definedExternally
    var isBracketed: Boolean
}
external enum class FlowFlags {
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
external interface FlowNode {
    var flags: FlowFlags
    var id: Number? get() = definedExternally; set(value) = definedExternally
}
external interface FlowStart : FlowNode {
    var container: dynamic /* FunctionExpression | ArrowFunction */ get() = definedExternally; set(value) = definedExternally
}
external interface FlowLabel : FlowNode {
    var antecedents: Array<FlowNode>
}
external interface FlowAssignment : FlowNode {
    var node: dynamic /* Expression | VariableDeclaration | BindingElement */
    var antecedent: FlowNode
}
external interface FlowCondition : FlowNode {
    var expression: Expression
    var antecedent: FlowNode
}
external interface FlowSwitchClause : FlowNode {
    var switchStatement: SwitchStatement
    var clauseStart: Number
    var clauseEnd: Number
    var antecedent: FlowNode
}
external interface IncompleteType {
    var flags: TypeFlags
    var type: Type
}
external interface AmdDependency {
    var path: String
    var name: String
}
external interface SourceFile : Declaration {
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
external interface ScriptReferenceHost {
    fun getCompilerOptions(): CompilerOptions
    fun getSourceFile(fileName: String): SourceFile
    fun getSourceFileByPath(path: String /* String & `T$0` */): SourceFile
    fun getCurrentDirectory(): String
}
external interface ParseConfigHost {
    var useCaseSensitiveFileNames: Boolean
    fun readDirectory(rootDir: String, extensions: Array<String>, excludes: Array<String>, includes: Array<String>): Array<String>
    fun fileExists(path: String): Boolean
}
external interface WriteFileCallback {
    @nativeInvoke
    fun invoke(fileName: String, data: String, writeByteOrderMark: Boolean, onError: ((message: String) -> Unit)? = definedExternally /* null */, sourceFiles: Array<SourceFile>? = definedExternally /* null */)
}
external open class OperationCanceledException
external interface CancellationToken {
    fun isCancellationRequested(): Boolean
    fun throwIfCancellationRequested()
}
external interface Program : ScriptReferenceHost {
    fun getRootFileNames(): Array<String>
    fun getSourceFiles(): Array<SourceFile>
    fun emit(targetSourceFile: SourceFile? = definedExternally /* null */, writeFile: WriteFileCallback? = definedExternally /* null */, cancellationToken: CancellationToken? = definedExternally /* null */, emitOnlyDtsFiles: Boolean? = definedExternally /* null */): EmitResult
    fun getOptionsDiagnostics(cancellationToken: CancellationToken? = definedExternally /* null */): Array<Diagnostic>
    fun getGlobalDiagnostics(cancellationToken: CancellationToken? = definedExternally /* null */): Array<Diagnostic>
    fun getSyntacticDiagnostics(sourceFile: SourceFile? = definedExternally /* null */, cancellationToken: CancellationToken? = definedExternally /* null */): Array<Diagnostic>
    fun getSemanticDiagnostics(sourceFile: SourceFile? = definedExternally /* null */, cancellationToken: CancellationToken? = definedExternally /* null */): Array<Diagnostic>
    fun getDeclarationDiagnostics(sourceFile: SourceFile? = definedExternally /* null */, cancellationToken: CancellationToken? = definedExternally /* null */): Array<Diagnostic>
    fun getTypeChecker(): TypeChecker
}
external interface SourceMapSpan {
    var emittedLine: Number
    var emittedColumn: Number
    var sourceLine: Number
    var sourceColumn: Number
    var nameIndex: Number? get() = definedExternally; set(value) = definedExternally
    var sourceIndex: Number
}
external interface SourceMapData {
    var sourceMapFilePath: String
    var jsSourceMappingURL: String
    var sourceMapFile: String
    var sourceMapSourceRoot: String
    var sourceMapSources: Array<String>
    var sourceMapSourcesContent: Array<String>? get() = definedExternally; set(value) = definedExternally
    var inputSourceFileNames: Array<String>
    var sourceMapNames: Array<String>? get() = definedExternally; set(value) = definedExternally
    var sourceMapMappings: String
    var sourceMapDecodedMappings: Array<SourceMapSpan>
}
external enum class ExitStatus {
    Success /* = 0 */,
    DiagnosticsPresent_OutputsSkipped /* = 1 */,
    DiagnosticsPresent_OutputsGenerated /* = 2 */
}
external interface EmitResult {
    var emitSkipped: Boolean
    var diagnostics: Array<Diagnostic>
    var emittedFiles: Array<String>
}
external interface TypeChecker {
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
    fun getSymbolAtLocation(node: Node): Symbol?
    fun getSymbolsOfParameterPropertyDeclaration(parameter: ParameterDeclaration, parameterName: String): Array<Symbol>
    fun getShorthandAssignmentValueSymbol(location: Node): Symbol
    fun getExportSpecifierLocalTargetSymbol(location: ExportSpecifier): Symbol
    fun getPropertySymbolOfDestructuringAssignment(location: Identifier): Symbol
    fun getTypeAtLocation(node: Node): Type
    fun typeToString(type: Type, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */): String
    fun symbolToString(symbol: Symbol, enclosingDeclaration: Node? = definedExternally /* null */, meaning: SymbolFlags? = definedExternally /* null */): String
    fun getSymbolDisplayBuilder(): SymbolDisplayBuilder
    fun getFullyQualifiedName(symbol: Symbol): String
    fun getAugmentedPropertiesOfType(type: Type): Array<Symbol>
    fun getRootSymbols(symbol: Symbol): Array<Symbol>
    fun getContextualType(node: Expression): Type
    fun getResolvedSignature(node: CallExpression, candidatesOutArray: Array<Signature>? = definedExternally /* null */): Signature
    fun getResolvedSignature(node: NewExpression, candidatesOutArray: Array<Signature>? = definedExternally /* null */): Signature
    fun getResolvedSignature(node: TaggedTemplateExpression, candidatesOutArray: Array<Signature>? = definedExternally /* null */): Signature
    fun getResolvedSignature(node: Decorator, candidatesOutArray: Array<Signature>? = definedExternally /* null */): Signature
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
external interface SymbolDisplayBuilder {
    fun buildTypeDisplay(type: Type, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */)
    fun buildSymbolDisplay(symbol: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, meaning: SymbolFlags? = definedExternally /* null */, flags: SymbolFormatFlags? = definedExternally /* null */)
    fun buildSignatureDisplay(signatures: Signature, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */, kind: SignatureKind? = definedExternally /* null */)
    fun buildParameterDisplay(parameter: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */)
    fun buildTypeParameterDisplay(tp: TypeParameter, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */)
    fun buildTypePredicateDisplay(predicate: dynamic /*TypePredicate*/, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */)
    fun buildTypeParameterDisplayFromSymbol(symbol: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */)
    fun buildDisplayForParametersAndDelimiters(thisParameter: Symbol, parameters: Array<Symbol>, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */)
    fun buildDisplayForTypeParametersAndDelimiters(typeParameters: Array<TypeParameter>, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */)
    fun buildReturnTypeDisplay(signature: Signature, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */)
}
external interface SymbolWriter {
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
    fun trackSymbol(symbol: Symbol, enclosingDeclaration: Node? = definedExternally /* null */, meaning: SymbolFlags? = definedExternally /* null */)
    fun reportInaccessibleThisError()
}
external enum class TypeFormatFlags {
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
external enum class SymbolFormatFlags {
    None /* = 0 */,
    WriteTypeParametersOrArguments /* = 1 */,
    UseOnlyExternalAliasing /* = 2 */
}
external enum class TypePredicateKind {
    `This` /* = 0 */,
    Identifier /* = 1 */
}
external interface TypePredicateBase {
    var kind: TypePredicateKind
    var type: Type
}
external interface ThisTypePredicate : TypePredicateBase {
    var _thisTypePredicateBrand: Any
}
external interface IdentifierTypePredicate : TypePredicateBase {
    var parameterName: String
    var parameterIndex: Number
}
external enum class SymbolFlags {
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
external interface Symbol {
    var flags: SymbolFlags
    var name: String
    var declarations: Array<Declaration>? get() = definedExternally; set(value) = definedExternally
    var valueDeclaration: Declaration? get() = definedExternally; set(value) = definedExternally
    var members: SymbolTable? get() = definedExternally; set(value) = definedExternally
    var exports: SymbolTable? get() = definedExternally; set(value) = definedExternally
    var globalExports: SymbolTable? get() = definedExternally; set(value) = definedExternally
    fun getFlags(): SymbolFlags
    fun getName(): String
    fun getDeclarations(): Array<Declaration>
    fun getDocumentationComment(): Array<SymbolDisplayPart>
}
external enum class TypeFlags {
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
external interface Type {
    var flags: TypeFlags
    var symbol: Symbol? get() = definedExternally; set(value) = definedExternally
    var pattern: dynamic /* BindingPattern | ObjectLiteralExpression | ArrayLiteralExpression */ get() = definedExternally; set(value) = definedExternally
    var aliasSymbol: Symbol? get() = definedExternally; set(value) = definedExternally
    var aliasTypeArguments: Array<Type>? get() = definedExternally; set(value) = definedExternally
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
external interface LiteralType : Type {
    var text: String
}
external interface EnumType : Type {
    var memberTypes: Map<EnumLiteralType>
}
external interface EnumLiteralType : LiteralType {
    var baseType: EnumType /* EnumType & UnionType */
}
external interface ObjectType : Type
external interface InterfaceType : ObjectType {
    var typeParameters: Array<TypeParameter>
    var outerTypeParameters: Array<TypeParameter>
    var localTypeParameters: Array<TypeParameter>
    var thisType: TypeParameter
}
external interface InterfaceTypeWithDeclaredMembers : InterfaceType {
    var declaredProperties: Array<Symbol>
    var declaredCallSignatures: Array<Signature>
    var declaredConstructSignatures: Array<Signature>
    var declaredStringIndexInfo: IndexInfo
    var declaredNumberIndexInfo: IndexInfo
}
external interface TypeReference : ObjectType {
    var target: GenericType
    var typeArguments: Array<Type>
}
external interface GenericType : InterfaceType, TypeReference
external interface UnionOrIntersectionType : Type {
    var types: Array<Type>
}
external interface UnionType : UnionOrIntersectionType
external interface IntersectionType : UnionOrIntersectionType
external interface TypeParameter : Type {
    var constraint: Type
}
external enum class SignatureKind {
    Call /* = 0 */,
    Construct /* = 1 */
}
external interface Signature {
    var declaration: SignatureDeclaration
    var typeParameters: Array<TypeParameter>
    var parameters: Array<Symbol>
    fun getDeclaration(): SignatureDeclaration
    fun getTypeParameters(): Array<Type>
    fun getParameters(): Array<Symbol>
    fun getReturnType(): Type
    fun getDocumentationComment(): Array<SymbolDisplayPart>
}
external enum class IndexKind {
    String /* = 0 */,
    Number /* = 1 */
}
external interface IndexInfo {
    var type: Type
    var isReadonly: Boolean
    var declaration: SignatureDeclaration? get() = definedExternally; set(value) = definedExternally
}
external interface DiagnosticMessage {
    var key: String
    var category: DiagnosticCategory
    var code: Number
    var message: String
}
external interface DiagnosticMessageChain {
    var messageText: String
    var category: DiagnosticCategory
    var code: Number
    var next: DiagnosticMessageChain? get() = definedExternally; set(value) = definedExternally
}
external interface Diagnostic {
    var file: SourceFile
    var start: Number
    var length: Number
    var messageText: dynamic /* String | DiagnosticMessageChain */
    var category: DiagnosticCategory
    var code: Number
}
external enum class DiagnosticCategory {
    Warning /* = 0 */,
    Error /* = 1 */,
    Message /* = 2 */
}
external enum class ModuleResolutionKind {
    Classic /* = 1 */,
    NodeJs /* = 2 */
}
external interface CompilerOptions {
    var allowJs: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowSyntheticDefaultImports: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowUnreachableCode: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowUnusedLabels: Boolean? get() = definedExternally; set(value) = definedExternally
    var baseUrl: String? get() = definedExternally; set(value) = definedExternally
    var charset: String? get() = definedExternally; set(value) = definedExternally
    var declaration: Boolean? get() = definedExternally; set(value) = definedExternally
    var declarationDir: String? get() = definedExternally; set(value) = definedExternally
    var disableSizeLimit: Boolean? get() = definedExternally; set(value) = definedExternally
    var emitBOM: Boolean? get() = definedExternally; set(value) = definedExternally
    var emitDecoratorMetadata: Boolean? get() = definedExternally; set(value) = definedExternally
    var experimentalDecorators: Boolean? get() = definedExternally; set(value) = definedExternally
    var forceConsistentCasingInFileNames: Boolean? get() = definedExternally; set(value) = definedExternally
    var inlineSourceMap: Boolean? get() = definedExternally; set(value) = definedExternally
    var inlineSources: Boolean? get() = definedExternally; set(value) = definedExternally
    var isolatedModules: Boolean? get() = definedExternally; set(value) = definedExternally
    var jsx: JsxEmit? get() = definedExternally; set(value) = definedExternally
    var lib: Array<String>? get() = definedExternally; set(value) = definedExternally
    var locale: String? get() = definedExternally; set(value) = definedExternally
    var mapRoot: String? get() = definedExternally; set(value) = definedExternally
    var maxNodeModuleJsDepth: Number? get() = definedExternally; set(value) = definedExternally
    var module: ModuleKind? get() = definedExternally; set(value) = definedExternally
    var moduleResolution: ModuleResolutionKind? get() = definedExternally; set(value) = definedExternally
    var newLine: NewLineKind? get() = definedExternally; set(value) = definedExternally
    var noEmit: Boolean? get() = definedExternally; set(value) = definedExternally
    var noEmitHelpers: Boolean? get() = definedExternally; set(value) = definedExternally
    var noEmitOnError: Boolean? get() = definedExternally; set(value) = definedExternally
    var noErrorTruncation: Boolean? get() = definedExternally; set(value) = definedExternally
    var noFallthroughCasesInSwitch: Boolean? get() = definedExternally; set(value) = definedExternally
    var noImplicitAny: Boolean? get() = definedExternally; set(value) = definedExternally
    var noImplicitReturns: Boolean? get() = definedExternally; set(value) = definedExternally
    var noImplicitThis: Boolean? get() = definedExternally; set(value) = definedExternally
    var noUnusedLocals: Boolean? get() = definedExternally; set(value) = definedExternally
    var noUnusedParameters: Boolean? get() = definedExternally; set(value) = definedExternally
    var noImplicitUseStrict: Boolean? get() = definedExternally; set(value) = definedExternally
    var noLib: Boolean? get() = definedExternally; set(value) = definedExternally
    var noResolve: Boolean? get() = definedExternally; set(value) = definedExternally
    var out: String? get() = definedExternally; set(value) = definedExternally
    var outDir: String? get() = definedExternally; set(value) = definedExternally
    var outFile: String? get() = definedExternally; set(value) = definedExternally
    var paths: MapLike<Array<String>>? get() = definedExternally; set(value) = definedExternally
    var preserveConstEnums: Boolean? get() = definedExternally; set(value) = definedExternally
    var project: String? get() = definedExternally; set(value) = definedExternally
    var reactNamespace: String? get() = definedExternally; set(value) = definedExternally
    var removeComments: Boolean? get() = definedExternally; set(value) = definedExternally
    var rootDir: String? get() = definedExternally; set(value) = definedExternally
    var rootDirs: Array<String>? get() = definedExternally; set(value) = definedExternally
    var skipLibCheck: Boolean? get() = definedExternally; set(value) = definedExternally
    var skipDefaultLibCheck: Boolean? get() = definedExternally; set(value) = definedExternally
    var sourceMap: Boolean? get() = definedExternally; set(value) = definedExternally
    var sourceRoot: String? get() = definedExternally; set(value) = definedExternally
    var strictNullChecks: Boolean? get() = definedExternally; set(value) = definedExternally
    var suppressExcessPropertyErrors: Boolean? get() = definedExternally; set(value) = definedExternally
    var suppressImplicitAnyIndexErrors: Boolean? get() = definedExternally; set(value) = definedExternally
    var target: ScriptTarget? get() = definedExternally; set(value) = definedExternally
    var traceResolution: Boolean? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
    var typeRoots: Array<String>? get() = definedExternally; set(value) = definedExternally
    @nativeGetter
    fun get(option: String): dynamic /* String | Number | Boolean | Array<dynamic /* String | Number */> | Array<String> | MapLike<Array<String>> | Nothing? */
    @nativeSetter
    fun set(option: String, value: String)
    @nativeSetter
    fun set(option: String, value: Number)
    @nativeSetter
    fun set(option: String, value: Boolean)
        // TODO bug?
    @nativeSetter
    fun set(option: String, value: Array<dynamic /* String | Number */>)
//    @nativeSetter
//    fun set(option: String, value: Array<String>)
    @nativeSetter
    fun set(option: String, value: MapLike<Array<String>>)
// TODO
    @nativeSetter
    fun set(option: String, value: Nothing?)
}
external interface TypingOptions {
    var enableAutoDiscovery: Boolean? get() = definedExternally; set(value) = definedExternally
    var include: Array<String>? get() = definedExternally; set(value) = definedExternally
    var exclude: Array<String>? get() = definedExternally; set(value) = definedExternally
    @nativeGetter
    fun get(option: String): dynamic /* Array<String> | Boolean | Nothing? */
    @nativeSetter
    fun set(option: String, value: Array<String>)
    @nativeSetter
    fun set(option: String, value: Boolean)
// TODO
    @nativeSetter
    fun set(option: String, value: Nothing?)
}
external interface DiscoverTypingsInfo {
    var fileNames: Array<String>
    var projectRootPath: String
    var safeListPath: String
    var packageNameToTypingLocation: Map<String>
    var typingOptions: TypingOptions
    var compilerOptions: CompilerOptions
}
external enum class ModuleKind {
    None /* = 0 */,
    CommonJS /* = 1 */,
    AMD /* = 2 */,
    UMD /* = 3 */,
    System /* = 4 */,
    ES6 /* = 5 */,
    ES2015 /* = 5 */
}
external enum class JsxEmit {
    None /* = 0 */,
    Preserve /* = 1 */,
    React /* = 2 */
}
external enum class NewLineKind {
    CarriageReturnLineFeed /* = 0 */,
    LineFeed /* = 1 */
}
external interface LineAndCharacter {
    var line: Number
    var character: Number
}
external enum class ScriptKind {
    Unknown /* = 0 */,
    JS /* = 1 */,
    JSX /* = 2 */,
    TS /* = 3 */,
    TSX /* = 4 */
}
external enum class ScriptTarget {
    ES3 /* = 0 */,
    ES5 /* = 1 */,
    ES6 /* = 2 */,
    ES2015 /* = 2 */,
    Latest /* = 2 */
}
external enum class LanguageVariant {
    Standard /* = 0 */,
    JSX /* = 1 */
}
external interface ParsedCommandLine {
    var options: CompilerOptions
    var typingOptions: TypingOptions? get() = definedExternally; set(value) = definedExternally
    var fileNames: Array<String>
    var raw: Any? get() = definedExternally; set(value) = definedExternally
    var errors: Array<Diagnostic>
    var wildcardDirectories: MapLike<WatchDirectoryFlags>? get() = definedExternally; set(value) = definedExternally
    var compileOnSave: Boolean? get() = definedExternally; set(value) = definedExternally
}
external enum class WatchDirectoryFlags {
    None /* = 0 */,
    Recursive /* = 1 */
}
external interface ExpandResult {
    var fileNames: Array<String>
    var wildcardDirectories: MapLike<WatchDirectoryFlags>
}
external interface ModuleResolutionHost {
    fun fileExists(fileName: String): Boolean
    fun readFile(fileName: String): String
    val trace: ((s: String) -> Unit)? get() = definedExternally
    val directoryExists: ((directoryName: String) -> Boolean)? get() = definedExternally
    val realpath: ((path: String) -> String)? get() = definedExternally
    val getCurrentDirectory: (() -> String)? get() = definedExternally
    val getDirectories: ((path: String) -> Array<String>)? get() = definedExternally
}
external interface ResolvedModule {
    var resolvedFileName: String
    var isExternalLibraryImport: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface ResolvedModuleWithFailedLookupLocations {
    var resolvedModule: ResolvedModule
    var failedLookupLocations: Array<String>
}
external interface ResolvedTypeReferenceDirective {
    var primary: Boolean
    var resolvedFileName: String? get() = definedExternally; set(value) = definedExternally
}
external interface ResolvedTypeReferenceDirectiveWithFailedLookupLocations {
    var resolvedTypeReferenceDirective: ResolvedTypeReferenceDirective
    var failedLookupLocations: Array<String>
}
external interface CompilerHost : ModuleResolutionHost {
    fun getSourceFile(fileName: String, languageVersion: ScriptTarget, onError: ((message: String) -> Unit)? = definedExternally /* null */): SourceFile
    val getSourceFileByPath: ((fileName: String, path: String /* String & `T$0` */, languageVersion: ScriptTarget, onError: ((message: String) -> Unit)? /*= null*/) -> SourceFile)? get() = definedExternally
    val getCancellationToken: (() -> CancellationToken)? get() = definedExternally
    fun getDefaultLibFileName(options: CompilerOptions): String
    val getDefaultLibLocation: (() -> String)? get() = definedExternally
    var writeFile: WriteFileCallback
    // TODO bug
    fun getCurrentDirectory(): String
    fun getDirectories(path: String): Array<String>
    fun getCanonicalFileName(fileName: String): String
    fun useCaseSensitiveFileNames(): Boolean
    fun getNewLine(): String
    val resolveModuleNames: ((moduleNames: Array<String>, containingFile: String) -> Array<ResolvedModule>)? get() = definedExternally
    val resolveTypeReferenceDirectives: ((typeReferenceDirectiveNames: Array<String>, containingFile: String) -> Array<ResolvedTypeReferenceDirective>)? get() = definedExternally
}
external interface TextSpan {
    var start: Number
    var length: Number
}
external interface TextChangeRange {
    var span: TextSpan
    var newLength: Number
}
external interface SyntaxList : Node {
    var _children: Array<Node>
}
external var version: String = definedExternally
external interface WatchedFile {
    var fileName: String
    var callback: (fileName: String, removed: Boolean? /*= null*/) -> Unit
    var mtime: Date? get() = definedExternally; set(value) = definedExternally
}
external interface System {
    var args: Array<String>
    var newLine: String
    var useCaseSensitiveFileNames: Boolean
    fun write(s: String)
    fun readFile(path: String, encoding: String? = definedExternally /* null */): String
    val getFileSize: ((path: String) -> Number)? get() = definedExternally
    fun writeFile(path: String, data: String, writeByteOrderMark: Boolean? = definedExternally /* null */)
    val watchFile: ((path: String, callback: (fileName: String, removed: Boolean? /*= null*/) -> Unit, pollingInterval: Number? /*= null*/) -> FileWatcher)? get() = definedExternally
    val watchDirectory: ((path: String, callback: (fileName: String) -> Unit, recursive: Boolean? /*= null*/) -> FileWatcher)? get() = definedExternally
    fun resolvePath(path: String): String
    fun fileExists(path: String): Boolean
    fun directoryExists(path: String): Boolean
    fun createDirectory(path: String)
    fun getExecutingFilePath(): String
    fun getCurrentDirectory(): String
    fun getDirectories(path: String): Array<String>
    fun readDirectory(path: String, extensions: Array<String>? = definedExternally /* null */, exclude: Array<String>? = definedExternally /* null */, include: Array<String>? = definedExternally /* null */): Array<String>
    val getModifiedTime: ((path: String) -> Date)? get() = definedExternally
    val createHash: ((data: String) -> String)? get() = definedExternally
    val getMemoryUsage: (() -> Number)? get() = definedExternally
    fun exit(exitCode: Number? = definedExternally /* null */)
    val realpath: ((path: String) -> String)? get() = definedExternally
}
external interface FileWatcher {
    fun close()
}
external interface DirectoryWatcher : FileWatcher {
    var directoryName: String
    var referenceCount: Number
}
external var sys: System = definedExternally
external interface ErrorCallback {
    @nativeInvoke
    fun invoke(message: DiagnosticMessage, length: Number)
}
external interface Scanner {
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
    fun setText(text: String, start: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */)
    fun setOnError(onError: ErrorCallback)
    fun setScriptTarget(scriptTarget: ScriptTarget)
    fun setLanguageVariant(variant: LanguageVariant)
    fun setTextPos(textPos: Number)
    fun <T> lookAhead(callback: () -> T): T
    fun <T> scanRange(start: Number, length: Number, callback: () -> T): T
    fun <T> tryScan(callback: () -> T): T
}
external fun tokenToString(t: SyntaxKind): String = definedExternally
external fun getPositionOfLineAndCharacter(sourceFile: SourceFile, line: Number, character: Number): Number = definedExternally
external fun getLineAndCharacterOfPosition(sourceFile: SourceFile, position: Number): LineAndCharacter = definedExternally
external fun isWhiteSpace(ch: Number): Boolean = definedExternally
external fun isWhiteSpaceSingleLine(ch: Number): Boolean = definedExternally
external fun isLineBreak(ch: Number): Boolean = definedExternally
external fun couldStartTrivia(text: String, pos: Number): Boolean = definedExternally
external fun getLeadingCommentRanges(text: String, pos: Number): Array<CommentRange> = definedExternally
external fun getTrailingCommentRanges(text: String, pos: Number): Array<CommentRange> = definedExternally
external fun getShebang(text: String): String = definedExternally
external fun isIdentifierStart(ch: Number, languageVersion: ScriptTarget): Boolean = definedExternally
external fun isIdentifierPart(ch: Number, languageVersion: ScriptTarget): Boolean = definedExternally
external fun createScanner(languageVersion: ScriptTarget, skipTrivia: Boolean, languageVariant: LanguageVariant? = definedExternally /* null */, text: String? = definedExternally /* null */, onError: ErrorCallback? = definedExternally /* null */, start: Number? = definedExternally /* null */, length: Number? = definedExternally /* null */): Scanner = definedExternally
external fun getDefaultLibFileName(options: CompilerOptions): String = definedExternally
external fun textSpanEnd(span: TextSpan): Number = definedExternally
external fun textSpanIsEmpty(span: TextSpan): Boolean = definedExternally
external fun textSpanContainsPosition(span: TextSpan, position: Number): Boolean = definedExternally
external fun textSpanContainsTextSpan(span: TextSpan, other: TextSpan): Boolean = definedExternally
external fun textSpanOverlapsWith(span: TextSpan, other: TextSpan): Boolean = definedExternally
external fun textSpanOverlap(span1: TextSpan, span2: TextSpan): TextSpan = definedExternally
external fun textSpanIntersectsWithTextSpan(span: TextSpan, other: TextSpan): Boolean = definedExternally
external fun textSpanIntersectsWith(span: TextSpan, start: Number, length: Number): Boolean = definedExternally
external fun decodedTextSpanIntersectsWith(start1: Number, length1: Number, start2: Number, length2: Number): Boolean = definedExternally
external fun textSpanIntersectsWithPosition(span: TextSpan, position: Number): Boolean = definedExternally
external fun textSpanIntersection(span1: TextSpan, span2: TextSpan): TextSpan = definedExternally
external fun createTextSpan(start: Number, length: Number): TextSpan = definedExternally
external fun createTextSpanFromBounds(start: Number, end: Number): TextSpan = definedExternally
external fun textChangeRangeNewSpan(range: TextChangeRange): TextSpan = definedExternally
external fun textChangeRangeIsUnchanged(range: TextChangeRange): Boolean = definedExternally
external fun createTextChangeRange(span: TextSpan, newLength: Number): TextChangeRange = definedExternally
external var unchangedTextChangeRange: TextChangeRange = definedExternally
external fun collapseTextChangeRangesAcrossMultipleVersions(changes: Array<TextChangeRange>): TextChangeRange = definedExternally
external fun getTypeParameterOwner(d: Declaration): Declaration = definedExternally
external fun isParameterPropertyDeclaration(node: ParameterDeclaration): Boolean = definedExternally
external fun createNode(kind: SyntaxKind, pos: Number? = definedExternally /* null */, end: Number? = definedExternally /* null */): Node = definedExternally
external fun <T> forEachChild(node: Node, cbNode: (node: Node) -> T, cbNodeArray: ((nodes: Array<Node>) -> T)? = definedExternally /* null */): T = definedExternally
external fun createSourceFile(fileName: String, sourceText: String, languageVersion: ScriptTarget, setParentNodes: Boolean? = definedExternally /* null */, scriptKind: ScriptKind? = definedExternally /* null */): SourceFile = definedExternally
external fun isExternalModule(file: SourceFile): Boolean = definedExternally
external fun updateSourceFile(sourceFile: SourceFile, newText: String, textChangeRange: TextChangeRange, aggressiveChecks: Boolean? = definedExternally /* null */): SourceFile = definedExternally
external fun classicNameResolver(moduleName: String, containingFile: String, compilerOptions: CompilerOptions, host: ModuleResolutionHost): ResolvedModuleWithFailedLookupLocations = definedExternally
external fun nodeModuleNameResolver(moduleName: String, containingFile: String, compilerOptions: CompilerOptions, host: ModuleResolutionHost): ResolvedModuleWithFailedLookupLocations = definedExternally
external fun resolveModuleName(moduleName: String, containingFile: String, compilerOptions: CompilerOptions, host: ModuleResolutionHost): ResolvedModuleWithFailedLookupLocations = definedExternally
external fun findConfigFile(searchPath: String, fileExists: (fileName: String) -> Boolean, configName: String? = definedExternally /* null */): String = definedExternally
external fun resolveTripleslashReference(moduleName: String, containingFile: String): String = definedExternally
external fun resolveTypeReferenceDirective(typeReferenceDirectiveName: String, containingFile: String, options: CompilerOptions, host: ModuleResolutionHost): ResolvedTypeReferenceDirectiveWithFailedLookupLocations = definedExternally
external fun createCompilerHost(options: CompilerOptions, setParentNodes: Boolean? = definedExternally /* null */): CompilerHost = definedExternally
external fun getPreEmitDiagnostics(program: Program, sourceFile: SourceFile? = definedExternally /* null */, cancellationToken: CancellationToken? = definedExternally /* null */): Array<Diagnostic> = definedExternally
external interface FormatDiagnosticsHost {
    fun getCurrentDirectory(): String
    fun getCanonicalFileName(fileName: String): String
    fun getNewLine(): String
}
external fun formatDiagnostics(diagnostics: Array<Diagnostic>, host: FormatDiagnosticsHost): String = definedExternally
external fun flattenDiagnosticMessageText(messageText: String, newLine: String): String = definedExternally
external fun flattenDiagnosticMessageText(messageText: DiagnosticMessageChain, newLine: String): String = definedExternally
external fun getAutomaticTypeDirectiveNames(options: CompilerOptions, host: ModuleResolutionHost): Array<String> = definedExternally
external fun createProgram(rootNames: Array<String>, options: CompilerOptions, host: CompilerHost? = definedExternally /* null */, oldProgram: Program? = definedExternally /* null */): Program = definedExternally
external interface `T$1` {
    var config: Any? get() = definedExternally; set(value) = definedExternally
    var error: Diagnostic? get() = definedExternally; set(value) = definedExternally
}
external fun readConfigFile(fileName: String, readFile: (path: String) -> String): `T$1` = definedExternally
external interface `T$2` {
    var config: Any? get() = definedExternally; set(value) = definedExternally
    var error: Diagnostic? get() = definedExternally; set(value) = definedExternally
}
external fun parseConfigFileTextToJson(fileName: String, jsonText: String, stripComments: Boolean? = definedExternally /* null */): `T$2` = definedExternally
external fun parseJsonConfigFileContent(json: Any, host: ParseConfigHost, basePath: String, existingOptions: CompilerOptions? = definedExternally /* null */, configFileName: String? = definedExternally /* null */): ParsedCommandLine = definedExternally
external fun convertCompileOnSaveOptionFromJson(jsonOption: Any, basePath: String, errors: Array<Diagnostic>): Boolean = definedExternally
external interface `T$3` {
    var options: CompilerOptions
    var errors: Array<Diagnostic>
}
external fun convertCompilerOptionsFromJson(jsonOptions: Any, basePath: String, configFileName: String? = definedExternally /* null */): `T$3` = definedExternally
external interface `T$4` {
    var options: TypingOptions
    var errors: Array<Diagnostic>
}
external fun convertTypingOptionsFromJson(jsonOptions: Any, basePath: String, configFileName: String? = definedExternally /* null */): `T$4` = definedExternally
external var servicesVersion: String = definedExternally
external interface IScriptSnapshot {
    // TODO bug?
    fun getText(start: Number = definedExternally, end: Number = definedExternally): String
    fun getLength(): Number
    fun getChangeRange(oldSnapshot: IScriptSnapshot): TextChangeRange?
    val dispose: (() -> Unit)? get() = definedExternally
}
external interface PreProcessedFileInfo {
    var referencedFiles: Array<FileReference>
    var typeReferenceDirectives: Array<FileReference>
    var importedFiles: Array<FileReference>
    var ambientExternalModules: Array<String>
    var isLibFile: Boolean
}
external interface `T$5` {
    var message: String
    var start: Number
    var length: Number
    var category: String
    var code: Number
}
external fun realizeDiagnostics(diagnostics: Array<Diagnostic>, newLine: String): Array<`T$5`> = definedExternally
external interface `T$6` {
    var message: String
    var start: Number
    var length: Number
    var category: String
    var code: Number
}
external fun realizeDiagnostic(diagnostic: Diagnostic, newLine: String): `T$6` = definedExternally
external interface HostCancellationToken {
    fun isCancellationRequested(): Boolean
}
external interface LanguageServiceHost {
    fun getCompilationSettings(): CompilerOptions
    val getNewLine: (() -> String)? get() = definedExternally
    val getProjectVersion: (() -> String)? get() = definedExternally
    fun getScriptFileNames(): Array<String>
    val getScriptKind: ((fileName: String) -> ScriptKind)? get() = definedExternally
    fun getScriptVersion(fileName: String): String
    fun getScriptSnapshot(fileName: String): IScriptSnapshot?
    val getLocalizedDiagnosticMessages: (() -> Any)? get() = definedExternally
    val getCancellationToken: (() -> HostCancellationToken)? get() = definedExternally
    fun getCurrentDirectory(): String
    fun getDefaultLibFileName(options: CompilerOptions): String
    val log: ((s: String) -> Unit)? get() = definedExternally
    val trace: ((s: String) -> Unit)? get() = definedExternally
    val error: ((s: String) -> Unit)? get() = definedExternally
    val useCaseSensitiveFileNames: (() -> Boolean)? get() = definedExternally
    val readDirectory: ((path: String, extensions: Array<String>? /*= null*/, exclude: Array<String>? /*= null*/, include: Array<String>? /*= null*/) -> Array<String>)? get() = definedExternally
    val readFile: ((path: String, encoding: String? /*= null*/) -> String)? get() = definedExternally
    val fileExists: ((path: String) -> Boolean)? get() = definedExternally
    val getTypeRootsVersion: (() -> Number)? get() = definedExternally
    val resolveModuleNames: ((moduleNames: Array<String>, containingFile: String) -> Array<ResolvedModule>)? get() = definedExternally
    val resolveTypeReferenceDirectives: ((typeDirectiveNames: Array<String>, containingFile: String) -> Array<ResolvedTypeReferenceDirective>)? get() = definedExternally
    val directoryExists: ((directoryName: String) -> Boolean)? get() = definedExternally
    val getDirectories: ((directoryName: String) -> Array<String>)? get() = definedExternally
}
external interface LanguageService {
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
    fun getNavigateToItems(searchValue: String, maxResultCount: Number? = definedExternally /* null */, excludeDts: Boolean? = definedExternally /* null */): Array<NavigateToItem>
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
    fun getEmitOutput(fileName: String, emitOnlyDtsFiles: Boolean? = definedExternally /* null */): EmitOutput
    fun getProgram(): Program
    fun dispose()
}
external interface Classifications {
    var spans: Array<Number>
    var endOfLineState: EndOfLineState
}
external interface ClassifiedSpan {
    var textSpan: TextSpan
    var classificationType: String
}
external interface NavigationBarItem {
    var text: String
    var kind: String
    var kindModifiers: String
    var spans: Array<TextSpan>
    var childItems: Array<NavigationBarItem>
    var indent: Number
    var bolded: Boolean
    var grayed: Boolean
}
external interface NavigationTree {
    var text: String
    var kind: String
    var kindModifiers: String
    var spans: Array<TextSpan>
    var childItems: Array<NavigationTree>? get() = definedExternally; set(value) = definedExternally
}
external interface TodoCommentDescriptor {
    var text: String
    var priority: Number
}
external interface TodoComment {
    var descriptor: TodoCommentDescriptor
    var message: String
    var position: Number
}
external open class TextChange {
    open var span: TextSpan = definedExternally
    open var newText: String = definedExternally
}
external interface TextInsertion {
    var newText: String
    var caretOffset: Number
}
external interface RenameLocation {
    var textSpan: TextSpan
    var fileName: String
}
external interface ReferenceEntry {
    var textSpan: TextSpan
    var fileName: String
    var isWriteAccess: Boolean
    var isDefinition: Boolean
}
external interface DocumentHighlights {
    var fileName: String
    var highlightSpans: Array<HighlightSpan>
}
external interface HighlightSpan {
    var fileName: String? get() = definedExternally; set(value) = definedExternally
    var textSpan: TextSpan
    var kind: String
}
external interface NavigateToItem {
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
external interface EditorOptions {
    var BaseIndentSize: Number? get() = definedExternally; set(value) = definedExternally
    var IndentSize: Number
    var TabSize: Number
    var NewLineCharacter: String
    var ConvertTabsToSpaces: Boolean
    var IndentStyle: IndentStyle
}
external interface EditorSettings {
    var baseIndentSize: Number? get() = definedExternally; set(value) = definedExternally
    var indentSize: Number? get() = definedExternally; set(value) = definedExternally
    var tabSize: Number? get() = definedExternally; set(value) = definedExternally
    var newLineCharacter: String? get() = definedExternally; set(value) = definedExternally
    var convertTabsToSpaces: Boolean? get() = definedExternally; set(value) = definedExternally
    var indentStyle: IndentStyle? get() = definedExternally; set(value) = definedExternally
}
external enum class IndentStyle {
    None /* = 0 */,
    Block /* = 1 */,
    Smart /* = 2 */
}
external interface FormatCodeOptions : EditorOptions {
    var InsertSpaceAfterCommaDelimiter: Boolean
    var InsertSpaceAfterSemicolonInForStatements: Boolean
    var InsertSpaceBeforeAndAfterBinaryOperators: Boolean
    var InsertSpaceAfterKeywordsInControlFlowStatements: Boolean
    var InsertSpaceAfterFunctionKeywordForAnonymousFunctions: Boolean
    var InsertSpaceAfterOpeningAndBeforeClosingNonemptyParenthesis: Boolean
    var InsertSpaceAfterOpeningAndBeforeClosingNonemptyBrackets: Boolean
    var InsertSpaceAfterOpeningAndBeforeClosingTemplateStringBraces: Boolean
    var InsertSpaceAfterOpeningAndBeforeClosingJsxExpressionBraces: Boolean? get() = definedExternally; set(value) = definedExternally
    var PlaceOpenBraceOnNewLineForFunctions: Boolean
    var PlaceOpenBraceOnNewLineForControlBlocks: Boolean
}
external interface FormatCodeSettings : EditorSettings {
    var insertSpaceAfterCommaDelimiter: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterSemicolonInForStatements: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceBeforeAndAfterBinaryOperators: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterKeywordsInControlFlowStatements: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterFunctionKeywordForAnonymousFunctions: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterOpeningAndBeforeClosingNonemptyParenthesis: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterOpeningAndBeforeClosingNonemptyBrackets: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterOpeningAndBeforeClosingTemplateStringBraces: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterOpeningAndBeforeClosingJsxExpressionBraces: Boolean? get() = definedExternally; set(value) = definedExternally
    var placeOpenBraceOnNewLineForFunctions: Boolean? get() = definedExternally; set(value) = definedExternally
    var placeOpenBraceOnNewLineForControlBlocks: Boolean? get() = definedExternally; set(value) = definedExternally
}
external fun toEditorSettings(options: EditorOptions): EditorSettings = definedExternally
external fun toEditorSettings(options: EditorSettings): EditorSettings = definedExternally
external interface DefinitionInfo {
    var fileName: String
    var textSpan: TextSpan
    var kind: String
    var name: String
    var containerKind: String
    var containerName: String
}
external interface ReferencedSymbolDefinitionInfo : DefinitionInfo {
    var displayParts: Array<SymbolDisplayPart>
}
external interface ReferencedSymbol {
    var definition: ReferencedSymbolDefinitionInfo
    var references: Array<ReferenceEntry>
}
external enum class SymbolDisplayPartKind {
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
external interface SymbolDisplayPart {
    var text: String
    var kind: String
}
external interface QuickInfo {
    var kind: String
    var kindModifiers: String
    var textSpan: TextSpan
    var displayParts: Array<SymbolDisplayPart>
    var documentation: Array<SymbolDisplayPart>
}
external interface RenameInfo {
    var canRename: Boolean
    var localizedErrorMessage: String
    var displayName: String
    var fullDisplayName: String
    var kind: String
    var kindModifiers: String
    var triggerSpan: TextSpan
}
external interface SignatureHelpParameter {
    var name: String
    var documentation: Array<SymbolDisplayPart>
    var displayParts: Array<SymbolDisplayPart>
    var isOptional: Boolean
}
external interface SignatureHelpItem {
    var isVariadic: Boolean
    var prefixDisplayParts: Array<SymbolDisplayPart>
    var suffixDisplayParts: Array<SymbolDisplayPart>
    var separatorDisplayParts: Array<SymbolDisplayPart>
    var parameters: Array<SignatureHelpParameter>
    var documentation: Array<SymbolDisplayPart>
}
external interface SignatureHelpItems {
    var items: Array<SignatureHelpItem>
    var applicableSpan: TextSpan
    var selectedItemIndex: Number
    var argumentIndex: Number
    var argumentCount: Number
}
external interface CompletionInfo {
    var isMemberCompletion: Boolean
    var isNewIdentifierLocation: Boolean
    var entries: Array<CompletionEntry>
}
external interface CompletionEntry {
    var name: String
    var kind: String
    var kindModifiers: String
    var sortText: String
    var replacementSpan: TextSpan? get() = definedExternally; set(value) = definedExternally
}
external interface CompletionEntryDetails {
    var name: String
    var kind: String
    var kindModifiers: String
    var displayParts: Array<SymbolDisplayPart>
    var documentation: Array<SymbolDisplayPart>
}
external interface OutliningSpan {
    var textSpan: TextSpan
    var hintSpan: TextSpan
    var bannerText: String
    var autoCollapse: Boolean
}
external interface EmitOutput {
    var outputFiles: Array<OutputFile>
    var emitSkipped: Boolean
}
external enum class OutputFileType {
    JavaScript /* = 0 */,
    SourceMap /* = 1 */,
    Declaration /* = 2 */
}
external interface OutputFile {
    var name: String
    var writeByteOrderMark: Boolean
    var text: String
}
external enum class EndOfLineState {
    None /* = 0 */,
    InMultiLineCommentTrivia /* = 1 */,
    InSingleQuoteStringLiteral /* = 2 */,
    InDoubleQuoteStringLiteral /* = 3 */,
    InTemplateHeadOrNoSubstitutionTemplate /* = 4 */,
    InTemplateMiddleOrTail /* = 5 */,
    InTemplateSubstitutionPosition /* = 6 */
}
external enum class TokenClass {
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
external interface ClassificationResult {
    var finalLexState: EndOfLineState
    var entries: Array<ClassificationInfo>
}
external interface ClassificationInfo {
    var length: Number
    var classification: TokenClass
}
external interface Classifier {
    fun getClassificationsForLine(text: String, lexState: EndOfLineState, syntacticClassifierAbsent: Boolean): ClassificationResult
    fun getEncodedLexicalClassifications(text: String, endOfLineState: EndOfLineState, syntacticClassifierAbsent: Boolean): Classifications
}
external interface DocumentRegistry {
    fun acquireDocument(fileName: String, compilationSettings: CompilerOptions, scriptSnapshot: IScriptSnapshot, version: String, scriptKind: ScriptKind? = definedExternally /* null */): SourceFile
    fun acquireDocumentWithKey(fileName: String, path: Path, compilationSettings: CompilerOptions, key: DocumentRegistryBucketKey, scriptSnapshot: IScriptSnapshot, version: String, scriptKind: ScriptKind? = definedExternally /* null */): SourceFile
    fun updateDocument(fileName: String, compilationSettings: CompilerOptions, scriptSnapshot: IScriptSnapshot, version: String, scriptKind: ScriptKind? = definedExternally /* null */): SourceFile
    fun updateDocumentWithKey(fileName: String, path: Path, compilationSettings: CompilerOptions, key: DocumentRegistryBucketKey, scriptSnapshot: IScriptSnapshot, version: String, scriptKind: ScriptKind? = definedExternally /* null */): SourceFile
    fun getKeyForCompilationSettings(settings: CompilerOptions): DocumentRegistryBucketKey
    fun releaseDocument(fileName: String, compilationSettings: CompilerOptions)
    fun releaseDocumentWithKey(path: Path, key: DocumentRegistryBucketKey)
    fun reportStats(): String
}
external interface `T$7` {
    var __bucketKey: Any
}
external open class ClassificationTypeNames {
    companion object {
        var comment: String = definedExternally
        var identifier: String = definedExternally
        var keyword: String = definedExternally
        var numericLiteral: String = definedExternally
        var operator: String = definedExternally
        var stringLiteral: String = definedExternally
        var whiteSpace: String = definedExternally
        var text: String = definedExternally
        var punctuation: String = definedExternally
        var className: String = definedExternally
        var enumName: String = definedExternally
        var interfaceName: String = definedExternally
        var moduleName: String = definedExternally
        var typeParameterName: String = definedExternally
        var typeAliasName: String = definedExternally
        var parameterName: String = definedExternally
        var docCommentTagName: String = definedExternally
        var jsxOpenTagName: String = definedExternally
        var jsxCloseTagName: String = definedExternally
        var jsxSelfClosingTagName: String = definedExternally
        var jsxAttribute: String = definedExternally
        var jsxText: String = definedExternally
        var jsxAttributeStringLiteralValue: String = definedExternally
    }
}
external enum class ClassificationType {
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
external interface DisplayPartsSymbolWriter : SymbolWriter {
    fun displayParts(): Array<SymbolDisplayPart>
}
external fun displayPartsToString(displayParts: Array<SymbolDisplayPart>): String = definedExternally
external fun getDefaultCompilerOptions(): CompilerOptions = definedExternally
external interface TranspileOptions {
    var compilerOptions: CompilerOptions? get() = definedExternally; set(value) = definedExternally
    var fileName: String? get() = definedExternally; set(value) = definedExternally
    var reportDiagnostics: Boolean? get() = definedExternally; set(value) = definedExternally
    var moduleName: String? get() = definedExternally; set(value) = definedExternally
    var renamedDependencies: MapLike<String>? get() = definedExternally; set(value) = definedExternally
}
external interface TranspileOutput {
    var outputText: String
    var diagnostics: Array<Diagnostic>? get() = definedExternally; set(value) = definedExternally
    var sourceMapText: String? get() = definedExternally; set(value) = definedExternally
}
external fun transpileModule(input: String, transpileOptions: TranspileOptions): TranspileOutput = definedExternally
external fun transpile(input: String, compilerOptions: CompilerOptions? = definedExternally /* null */, fileName: String? = definedExternally /* null */, diagnostics: Array<Diagnostic>? = definedExternally /* null */, moduleName: String? = definedExternally /* null */): String = definedExternally
external fun createLanguageServiceSourceFile(fileName: String, scriptSnapshot: IScriptSnapshot, scriptTarget: ScriptTarget, version: String, setNodeParents: Boolean, scriptKind: ScriptKind? = definedExternally /* null */): SourceFile = definedExternally
external var disableIncrementalParsing: Boolean = definedExternally
external fun updateLanguageServiceSourceFile(sourceFile: SourceFile, scriptSnapshot: IScriptSnapshot, version: String, textChangeRange: TextChangeRange, aggressiveChecks: Boolean? = definedExternally /* null */): SourceFile = definedExternally
external fun createDocumentRegistry(useCaseSensitiveFileNames: Boolean? = definedExternally /* null */, currentDirectory: String? = definedExternally /* null */): DocumentRegistry = definedExternally
external fun preProcessFile(sourceText: String, readImportFiles: Boolean? = definedExternally /* null */, detectJavaScriptImports: Boolean? = definedExternally /* null */): PreProcessedFileInfo = definedExternally
external fun createLanguageService(host: LanguageServiceHost, documentRegistry: DocumentRegistry? = definedExternally /* null */): LanguageService = definedExternally
external fun createClassifier(): Classifier = definedExternally
external fun getDefaultLibFilePath(options: CompilerOptions): String = definedExternally
