@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsQualifier("ts")
package ts

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

external interface MapLike<T> {
    @nativeGetter
    operator fun get(index: String): T?
    @nativeSetter
    operator fun set(index: String, value: T)
}
external interface Map<T> {
    fun get(key: String): T?
    fun has(key: String): Boolean
    fun set(key: String, value: T): Map<T> /* this */
    fun delete(key: String): Boolean
    fun clear()
    fun forEach(action: (value: T, key: String) -> Unit)
    var size: Number
    fun keys(): Iterator<String>
    fun values(): Iterator<T>
    fun entries(): Iterator<dynamic /* "TupleType" kind unsupported yet here! (node_modules/typescript/lib/typescriptServices.d.ts:36:29 to 36:40) */>
}
external interface `T$0` {
    var value: T
    var done: Any /* "null" */
}
external interface `T$1` {
    var value: dynamic /* "NeverKeyword" kind unsupported yet here! (node_modules/typescript/lib/typescriptServices.d.ts:44:19 to 44:25) */
    var done: Any /* "null" */
}
external interface Iterator<T> {
    fun next(): dynamic /* `T$0` | `T$1` */
}
external interface `T$2` {
    var __pathBrand: Any
}
external interface FileMap<T> {
    fun get(fileName: String /* String & `T$2` */): T
    fun set(fileName: String /* String & `T$2` */, value: T)
    fun contains(fileName: String /* String & `T$2` */): Boolean
    fun remove(fileName: String /* String & `T$2` */)
    fun forEachValue(f: `(key: String /* String & `T$2` */, v: T) -> Unit`)
    fun getKeys(): Array<String /* String & `T$2` */>
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
    JsxText /* = 10 */,
    JsxTextAllWhiteSpaces /* = 11 */,
    RegularExpressionLiteral /* = 12 */,
    NoSubstitutionTemplateLiteral /* = 13 */,
    TemplateHead /* = 14 */,
    TemplateMiddle /* = 15 */,
    TemplateTail /* = 16 */,
    OpenBraceToken /* = 17 */,
    CloseBraceToken /* = 18 */,
    OpenParenToken /* = 19 */,
    CloseParenToken /* = 20 */,
    OpenBracketToken /* = 21 */,
    CloseBracketToken /* = 22 */,
    DotToken /* = 23 */,
    DotDotDotToken /* = 24 */,
    SemicolonToken /* = 25 */,
    CommaToken /* = 26 */,
    LessThanToken /* = 27 */,
    LessThanSlashToken /* = 28 */,
    GreaterThanToken /* = 29 */,
    LessThanEqualsToken /* = 30 */,
    GreaterThanEqualsToken /* = 31 */,
    EqualsEqualsToken /* = 32 */,
    ExclamationEqualsToken /* = 33 */,
    EqualsEqualsEqualsToken /* = 34 */,
    ExclamationEqualsEqualsToken /* = 35 */,
    EqualsGreaterThanToken /* = 36 */,
    PlusToken /* = 37 */,
    MinusToken /* = 38 */,
    AsteriskToken /* = 39 */,
    AsteriskAsteriskToken /* = 40 */,
    SlashToken /* = 41 */,
    PercentToken /* = 42 */,
    PlusPlusToken /* = 43 */,
    MinusMinusToken /* = 44 */,
    LessThanLessThanToken /* = 45 */,
    GreaterThanGreaterThanToken /* = 46 */,
    GreaterThanGreaterThanGreaterThanToken /* = 47 */,
    AmpersandToken /* = 48 */,
    BarToken /* = 49 */,
    CaretToken /* = 50 */,
    ExclamationToken /* = 51 */,
    TildeToken /* = 52 */,
    AmpersandAmpersandToken /* = 53 */,
    BarBarToken /* = 54 */,
    QuestionToken /* = 55 */,
    ColonToken /* = 56 */,
    AtToken /* = 57 */,
    EqualsToken /* = 58 */,
    PlusEqualsToken /* = 59 */,
    MinusEqualsToken /* = 60 */,
    AsteriskEqualsToken /* = 61 */,
    AsteriskAsteriskEqualsToken /* = 62 */,
    SlashEqualsToken /* = 63 */,
    PercentEqualsToken /* = 64 */,
    LessThanLessThanEqualsToken /* = 65 */,
    GreaterThanGreaterThanEqualsToken /* = 66 */,
    GreaterThanGreaterThanGreaterThanEqualsToken /* = 67 */,
    AmpersandEqualsToken /* = 68 */,
    BarEqualsToken /* = 69 */,
    CaretEqualsToken /* = 70 */,
    Identifier /* = 71 */,
    BreakKeyword /* = 72 */,
    CaseKeyword /* = 73 */,
    CatchKeyword /* = 74 */,
    ClassKeyword /* = 75 */,
    ConstKeyword /* = 76 */,
    ContinueKeyword /* = 77 */,
    DebuggerKeyword /* = 78 */,
    DefaultKeyword /* = 79 */,
    DeleteKeyword /* = 80 */,
    DoKeyword /* = 81 */,
    ElseKeyword /* = 82 */,
    EnumKeyword /* = 83 */,
    ExportKeyword /* = 84 */,
    ExtendsKeyword /* = 85 */,
    FalseKeyword /* = 86 */,
    FinallyKeyword /* = 87 */,
    ForKeyword /* = 88 */,
    FunctionKeyword /* = 89 */,
    IfKeyword /* = 90 */,
    ImportKeyword /* = 91 */,
    InKeyword /* = 92 */,
    InstanceOfKeyword /* = 93 */,
    NewKeyword /* = 94 */,
    NullKeyword /* = 95 */,
    ReturnKeyword /* = 96 */,
    SuperKeyword /* = 97 */,
    SwitchKeyword /* = 98 */,
    ThisKeyword /* = 99 */,
    ThrowKeyword /* = 100 */,
    TrueKeyword /* = 101 */,
    TryKeyword /* = 102 */,
    TypeOfKeyword /* = 103 */,
    VarKeyword /* = 104 */,
    VoidKeyword /* = 105 */,
    WhileKeyword /* = 106 */,
    WithKeyword /* = 107 */,
    ImplementsKeyword /* = 108 */,
    InterfaceKeyword /* = 109 */,
    LetKeyword /* = 110 */,
    PackageKeyword /* = 111 */,
    PrivateKeyword /* = 112 */,
    ProtectedKeyword /* = 113 */,
    PublicKeyword /* = 114 */,
    StaticKeyword /* = 115 */,
    YieldKeyword /* = 116 */,
    AbstractKeyword /* = 117 */,
    AsKeyword /* = 118 */,
    AnyKeyword /* = 119 */,
    AsyncKeyword /* = 120 */,
    AwaitKeyword /* = 121 */,
    BooleanKeyword /* = 122 */,
    ConstructorKeyword /* = 123 */,
    DeclareKeyword /* = 124 */,
    GetKeyword /* = 125 */,
    IsKeyword /* = 126 */,
    KeyOfKeyword /* = 127 */,
    ModuleKeyword /* = 128 */,
    NamespaceKeyword /* = 129 */,
    NeverKeyword /* = 130 */,
    ReadonlyKeyword /* = 131 */,
    RequireKeyword /* = 132 */,
    NumberKeyword /* = 133 */,
    ObjectKeyword /* = 134 */,
    SetKeyword /* = 135 */,
    StringKeyword /* = 136 */,
    SymbolKeyword /* = 137 */,
    TypeKeyword /* = 138 */,
    UndefinedKeyword /* = 139 */,
    FromKeyword /* = 140 */,
    GlobalKeyword /* = 141 */,
    OfKeyword /* = 142 */,
    QualifiedName /* = 143 */,
    ComputedPropertyName /* = 144 */,
    TypeParameter /* = 145 */,
    Parameter /* = 146 */,
    Decorator /* = 147 */,
    PropertySignature /* = 148 */,
    PropertyDeclaration /* = 149 */,
    MethodSignature /* = 150 */,
    MethodDeclaration /* = 151 */,
    Constructor /* = 152 */,
    GetAccessor /* = 153 */,
    SetAccessor /* = 154 */,
    CallSignature /* = 155 */,
    ConstructSignature /* = 156 */,
    IndexSignature /* = 157 */,
    TypePredicate /* = 158 */,
    TypeReference /* = 159 */,
    FunctionType /* = 160 */,
    ConstructorType /* = 161 */,
    TypeQuery /* = 162 */,
    TypeLiteral /* = 163 */,
    ArrayType /* = 164 */,
    TupleType /* = 165 */,
    UnionType /* = 166 */,
    IntersectionType /* = 167 */,
    ParenthesizedType /* = 168 */,
    ThisType /* = 169 */,
    TypeOperator /* = 170 */,
    IndexedAccessType /* = 171 */,
    MappedType /* = 172 */,
    LiteralType /* = 173 */,
    ObjectBindingPattern /* = 174 */,
    ArrayBindingPattern /* = 175 */,
    BindingElement /* = 176 */,
    ArrayLiteralExpression /* = 177 */,
    ObjectLiteralExpression /* = 178 */,
    PropertyAccessExpression /* = 179 */,
    ElementAccessExpression /* = 180 */,
    CallExpression /* = 181 */,
    NewExpression /* = 182 */,
    TaggedTemplateExpression /* = 183 */,
    TypeAssertionExpression /* = 184 */,
    ParenthesizedExpression /* = 185 */,
    FunctionExpression /* = 186 */,
    ArrowFunction /* = 187 */,
    DeleteExpression /* = 188 */,
    TypeOfExpression /* = 189 */,
    VoidExpression /* = 190 */,
    AwaitExpression /* = 191 */,
    PrefixUnaryExpression /* = 192 */,
    PostfixUnaryExpression /* = 193 */,
    BinaryExpression /* = 194 */,
    ConditionalExpression /* = 195 */,
    TemplateExpression /* = 196 */,
    YieldExpression /* = 197 */,
    SpreadElement /* = 198 */,
    ClassExpression /* = 199 */,
    OmittedExpression /* = 200 */,
    ExpressionWithTypeArguments /* = 201 */,
    AsExpression /* = 202 */,
    NonNullExpression /* = 203 */,
    MetaProperty /* = 204 */,
    TemplateSpan /* = 205 */,
    SemicolonClassElement /* = 206 */,
    Block /* = 207 */,
    VariableStatement /* = 208 */,
    EmptyStatement /* = 209 */,
    ExpressionStatement /* = 210 */,
    IfStatement /* = 211 */,
    DoStatement /* = 212 */,
    WhileStatement /* = 213 */,
    ForStatement /* = 214 */,
    ForInStatement /* = 215 */,
    ForOfStatement /* = 216 */,
    ContinueStatement /* = 217 */,
    BreakStatement /* = 218 */,
    ReturnStatement /* = 219 */,
    WithStatement /* = 220 */,
    SwitchStatement /* = 221 */,
    LabeledStatement /* = 222 */,
    ThrowStatement /* = 223 */,
    TryStatement /* = 224 */,
    DebuggerStatement /* = 225 */,
    VariableDeclaration /* = 226 */,
    VariableDeclarationList /* = 227 */,
    FunctionDeclaration /* = 228 */,
    ClassDeclaration /* = 229 */,
    InterfaceDeclaration /* = 230 */,
    TypeAliasDeclaration /* = 231 */,
    EnumDeclaration /* = 232 */,
    ModuleDeclaration /* = 233 */,
    ModuleBlock /* = 234 */,
    CaseBlock /* = 235 */,
    NamespaceExportDeclaration /* = 236 */,
    ImportEqualsDeclaration /* = 237 */,
    ImportDeclaration /* = 238 */,
    ImportClause /* = 239 */,
    NamespaceImport /* = 240 */,
    NamedImports /* = 241 */,
    ImportSpecifier /* = 242 */,
    ExportAssignment /* = 243 */,
    ExportDeclaration /* = 244 */,
    NamedExports /* = 245 */,
    ExportSpecifier /* = 246 */,
    MissingDeclaration /* = 247 */,
    ExternalModuleReference /* = 248 */,
    JsxElement /* = 249 */,
    JsxSelfClosingElement /* = 250 */,
    JsxOpeningElement /* = 251 */,
    JsxClosingElement /* = 252 */,
    JsxAttribute /* = 253 */,
    JsxAttributes /* = 254 */,
    JsxSpreadAttribute /* = 255 */,
    JsxExpression /* = 256 */,
    CaseClause /* = 257 */,
    DefaultClause /* = 258 */,
    HeritageClause /* = 259 */,
    CatchClause /* = 260 */,
    PropertyAssignment /* = 261 */,
    ShorthandPropertyAssignment /* = 262 */,
    SpreadAssignment /* = 263 */,
    EnumMember /* = 264 */,
    SourceFile /* = 265 */,
    Bundle /* = 266 */,
    JSDocTypeExpression /* = 267 */,
    JSDocAllType /* = 268 */,
    JSDocUnknownType /* = 269 */,
    JSDocArrayType /* = 270 */,
    JSDocUnionType /* = 271 */,
    JSDocTupleType /* = 272 */,
    JSDocNullableType /* = 273 */,
    JSDocNonNullableType /* = 274 */,
    JSDocRecordType /* = 275 */,
    JSDocRecordMember /* = 276 */,
    JSDocTypeReference /* = 277 */,
    JSDocOptionalType /* = 278 */,
    JSDocFunctionType /* = 279 */,
    JSDocVariadicType /* = 280 */,
    JSDocConstructorType /* = 281 */,
    JSDocThisType /* = 282 */,
    JSDocComment /* = 283 */,
    JSDocTag /* = 284 */,
    JSDocAugmentsTag /* = 285 */,
    JSDocParameterTag /* = 286 */,
    JSDocReturnTag /* = 287 */,
    JSDocTypeTag /* = 288 */,
    JSDocTemplateTag /* = 289 */,
    JSDocTypedefTag /* = 290 */,
    JSDocPropertyTag /* = 291 */,
    JSDocTypeLiteral /* = 292 */,
    JSDocLiteralType /* = 293 */,
    SyntaxList /* = 294 */,
    NotEmittedStatement /* = 295 */,
    PartiallyEmittedExpression /* = 296 */,
    MergeDeclarationMarker /* = 297 */,
    EndOfDeclarationMarker /* = 298 */,
    Count /* = 299 */,
    FirstAssignment /* = 58 */,
    LastAssignment /* = 70 */,
    FirstCompoundAssignment /* = 59 */,
    LastCompoundAssignment /* = 70 */,
    FirstReservedWord /* = 72 */,
    LastReservedWord /* = 107 */,
    FirstKeyword /* = 72 */,
    LastKeyword /* = 142 */,
    FirstFutureReservedWord /* = 108 */,
    LastFutureReservedWord /* = 116 */,
    FirstTypeNode /* = 158 */,
    LastTypeNode /* = 173 */,
    FirstPunctuation /* = 17 */,
    LastPunctuation /* = 70 */,
    FirstToken /* = 0 */,
    LastToken /* = 142 */,
    FirstTriviaToken /* = 2 */,
    LastTriviaToken /* = 7 */,
    FirstLiteralToken /* = 8 */,
    LastLiteralToken /* = 13 */,
    FirstTemplateToken /* = 13 */,
    LastTemplateToken /* = 16 */,
    FirstBinaryOperator /* = 27 */,
    LastBinaryOperator /* = 70 */,
    FirstNode /* = 143 */,
    FirstJSDocNode /* = 267 */,
    LastJSDocNode /* = 293 */,
    FirstJSDocTagNode /* = 283 */,
    LastJSDocTagNode /* = 293 */
}
external enum class NodeFlags {
    None /* = 0 */,
    Let /* = 1 */,
    Const /* = 2 */,
    NestedNamespace /* = 4 */,
    Synthesized /* = 8 */,
    Namespace /* = 16 */,
    ExportContext /* = 32 */,
    ContainsThis /* = 64 */,
    HasImplicitReturn /* = 128 */,
    HasExplicitReturn /* = 256 */,
    GlobalAugmentation /* = 512 */,
    HasAsyncFunctions /* = 1024 */,
    DisallowInContext /* = 2048 */,
    YieldContext /* = 4096 */,
    DecoratorContext /* = 8192 */,
    AwaitContext /* = 16384 */,
    ThisNodeHasError /* = 32768 */,
    JavaScriptFile /* = 65536 */,
    ThisNodeOrAnySubNodesHasError /* = 131072 */,
    HasAggregatedChildData /* = 262144 */,
    BlockScoped /* = 3 */,
    ReachabilityCheckFlags /* = 384 */,
    ReachabilityAndEmitFlags /* = 1408 */,
    ContextFlags /* = 96256 */,
    TypeExcludesFlags /* = 20480 */
}
external enum class ModifierFlags {
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
    Const /* = 2048 */,
    HasComputedFlags /* = 536870912 */,
    AccessibilityModifier /* = 28 */,
    ParameterPropertyModifier /* = 92 */,
    NonPublicAccessibilityModifier /* = 24 */,
    TypeScriptModifier /* = 2270 */,
    ExportDefault /* = 513 */
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
    fun <T> forEachChild(cbNode: (node: Node) -> T, cbNodeArray: ((nodes: Array<Node>) -> T)? = definedExternally /* null */): T
}
external interface NodeArray<T : Node> : Array<T>, TextRange {
    var hasTrailingComma: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface Token<TKind : SyntaxKind> : Node {
    override var kind: TKind
}
external interface Identifier : PrimaryExpression {
    override var kind: SyntaxKind.Identifier
    var text: String
    var originalKeywordKind: SyntaxKind? get() = definedExternally; set(value) = definedExternally
    var isInJSDocNamespace: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface TransientIdentifier : Identifier {
    var resolvedSymbol: Symbol
}
external interface QualifiedName : Node {
    override var kind: SyntaxKind.QualifiedName
    var left: EntityName
    var right: Identifier
}
external interface Declaration : Node {
    var _declarationBrand: Any
    var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName | BindingPattern */ get() = definedExternally; set(value) = definedExternally
}
external interface NamedDeclaration : Declaration {
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName | BindingPattern */ get() = definedExternally; set(value) = definedExternally
}
external interface DeclarationStatement : NamedDeclaration, Statement {
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral */ get() = definedExternally; set(value) = definedExternally
}
external interface ComputedPropertyName : Node {
    override var kind: SyntaxKind.ComputedPropertyName
    var expression: Expression
}
external interface Decorator : Node {
    override var kind: SyntaxKind.Decorator
    var expression: LeftHandSideExpression
}
external interface TypeParameterDeclaration : NamedDeclaration {
    override var kind: SyntaxKind.TypeParameter
    override var parent: DeclarationWithTypeParameters? get() = definedExternally; set(value) = definedExternally
    override var name: Identifier
    var constraint: TypeNode? get() = definedExternally; set(value) = definedExternally
    var default: TypeNode? get() = definedExternally; set(value) = definedExternally
    var expression: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface SignatureDeclaration : NamedDeclaration {
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
    var typeParameters: NodeArray<TypeParameterDeclaration>? get() = definedExternally; set(value) = definedExternally
    var parameters: NodeArray<ParameterDeclaration>
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
}
external interface CallSignatureDeclaration : SignatureDeclaration, TypeElement {
    override var kind: SyntaxKind.CallSignature
}
external interface ConstructSignatureDeclaration : SignatureDeclaration, TypeElement {
    override var kind: SyntaxKind.ConstructSignature
}
external interface VariableDeclaration : NamedDeclaration {
    override var kind: SyntaxKind.VariableDeclaration
    override var parent: dynamic /* VariableDeclarationList | CatchClause */ get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | BindingPattern */
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface VariableDeclarationList : Node {
    override var kind: SyntaxKind.VariableDeclarationList
    override var parent: dynamic /* VariableStatement | ForStatement | ForOfStatement | ForInStatement */ get() = definedExternally; set(value) = definedExternally
    var declarations: NodeArray<VariableDeclaration>
}
external interface ParameterDeclaration : NamedDeclaration {
    override var kind: SyntaxKind.Parameter
    override var parent: SignatureDeclaration? get() = definedExternally; set(value) = definedExternally
    var dotDotDotToken: Token<SyntaxKind.DotDotDotToken>? get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | BindingPattern */
    var questionToken: Token<SyntaxKind.QuestionToken>? get() = definedExternally; set(value) = definedExternally
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface BindingElement : NamedDeclaration {
    override var kind: SyntaxKind.BindingElement
    override var parent: BindingPattern? get() = definedExternally; set(value) = definedExternally
    var propertyName: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
    var dotDotDotToken: Token<SyntaxKind.DotDotDotToken>? get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | BindingPattern */
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface PropertySignature : TypeElement {
    override var kind: dynamic /* SyntaxKind.PropertySignature | SyntaxKind.JSDocRecordMember */
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */
    override var questionToken: Token<SyntaxKind.QuestionToken>? get() = definedExternally; set(value) = definedExternally
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface PropertyDeclaration : ClassElement {
    override var kind: SyntaxKind.PropertyDeclaration
    var questionToken: Token<SyntaxKind.QuestionToken>? get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface ObjectLiteralElement : NamedDeclaration {
    var _objectLiteralBrandBrand: Any
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
}
external interface PropertyAssignment : ObjectLiteralElement {
    override var kind: SyntaxKind.PropertyAssignment
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */
    var questionToken: Token<SyntaxKind.QuestionToken>? get() = definedExternally; set(value) = definedExternally
    var initializer: Expression
}
external interface ShorthandPropertyAssignment : ObjectLiteralElement {
    override var kind: SyntaxKind.ShorthandPropertyAssignment
    override var name: Identifier
    var questionToken: Token<SyntaxKind.QuestionToken>? get() = definedExternally; set(value) = definedExternally
    var equalsToken: Token<SyntaxKind.EqualsToken>? get() = definedExternally; set(value) = definedExternally
    var objectAssignmentInitializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface SpreadAssignment : ObjectLiteralElement {
    override var kind: SyntaxKind.SpreadAssignment
    var expression: Expression
}
external interface VariableLikeDeclaration : NamedDeclaration {
    var propertyName: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
    var dotDotDotToken: Token<SyntaxKind.DotDotDotToken>? get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName | BindingPattern */
    var questionToken: Token<SyntaxKind.QuestionToken>? get() = definedExternally; set(value) = definedExternally
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface PropertyLikeDeclaration : NamedDeclaration {
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */
}
external interface ObjectBindingPattern : Node {
    override var kind: SyntaxKind.ObjectBindingPattern
    override var parent: dynamic /* VariableDeclaration | ParameterDeclaration | BindingElement */ get() = definedExternally; set(value) = definedExternally
    var elements: NodeArray<BindingElement>
}
external interface ArrayBindingPattern : Node {
    override var kind: SyntaxKind.ArrayBindingPattern
    override var parent: dynamic /* VariableDeclaration | ParameterDeclaration | BindingElement */ get() = definedExternally; set(value) = definedExternally
    var elements: NodeArray<ArrayBindingElement>
}
external interface FunctionLikeDeclaration : SignatureDeclaration {
    var _functionLikeDeclarationBrand: Any
    var asteriskToken: Token<SyntaxKind.AsteriskToken>? get() = definedExternally; set(value) = definedExternally
    var questionToken: Token<SyntaxKind.QuestionToken>? get() = definedExternally; set(value) = definedExternally
    var body: dynamic /* Block | Expression */ get() = definedExternally; set(value) = definedExternally
}
external interface FunctionDeclaration : FunctionLikeDeclaration, DeclarationStatement {
    override var kind: SyntaxKind.FunctionDeclaration
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
    override var body: FunctionBody? get() = definedExternally; set(value) = definedExternally
}
external interface MethodSignature : SignatureDeclaration, TypeElement {
    override var kind: SyntaxKind.MethodSignature
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */
}
external interface MethodDeclaration : FunctionLikeDeclaration, ClassElement, ObjectLiteralElement {
    override var kind: SyntaxKind.MethodDeclaration
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */
    override var body: FunctionBody? get() = definedExternally; set(value) = definedExternally
}
external interface ConstructorDeclaration : FunctionLikeDeclaration, ClassElement {
    override var kind: SyntaxKind.Constructor
    override var parent: dynamic /* ClassDeclaration | ClassExpression */ get() = definedExternally; set(value) = definedExternally
    override var body: FunctionBody? get() = definedExternally; set(value) = definedExternally
}
external interface SemicolonClassElement : ClassElement {
    override var kind: SyntaxKind.SemicolonClassElement
    override var parent: dynamic /* ClassDeclaration | ClassExpression */ get() = definedExternally; set(value) = definedExternally
}
external interface GetAccessorDeclaration : FunctionLikeDeclaration, ClassElement, ObjectLiteralElement {
    override var kind: SyntaxKind.GetAccessor
    override var parent: dynamic /* ClassDeclaration | ClassExpression | ObjectLiteralExpression */ get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */
    override var body: FunctionBody
}
external interface SetAccessorDeclaration : FunctionLikeDeclaration, ClassElement, ObjectLiteralElement {
    override var kind: SyntaxKind.SetAccessor
    override var parent: dynamic /* ClassDeclaration | ClassExpression | ObjectLiteralExpression */ get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */
    override var body: FunctionBody
}
external interface IndexSignatureDeclaration : SignatureDeclaration, ClassElement, TypeElement {
    override var kind: SyntaxKind.IndexSignature
    override var parent: dynamic /* ClassDeclaration | ClassExpression | InterfaceDeclaration | TypeLiteralNode */ get() = definedExternally; set(value) = definedExternally
}
external interface TypeNode : Node {
    var _typeNodeBrand: Any
}
external interface KeywordTypeNode : TypeNode {
    override var kind: dynamic /* SyntaxKind.AnyKeyword | SyntaxKind.NumberKeyword | SyntaxKind.ObjectKeyword | SyntaxKind.BooleanKeyword | SyntaxKind.StringKeyword | SyntaxKind.SymbolKeyword | SyntaxKind.ThisKeyword | SyntaxKind.VoidKeyword | SyntaxKind.UndefinedKeyword | SyntaxKind.NullKeyword | SyntaxKind.NeverKeyword */
}
external interface ThisTypeNode : TypeNode {
    override var kind: SyntaxKind.ThisType
}
external interface FunctionTypeNode : TypeNode, SignatureDeclaration {
    override var kind: SyntaxKind.FunctionType
}
external interface ConstructorTypeNode : TypeNode, SignatureDeclaration {
    override var kind: SyntaxKind.ConstructorType
}
external interface TypeReferenceNode : TypeNode {
    override var kind: SyntaxKind.TypeReference
    var typeName: dynamic /* Identifier | QualifiedName */
    var typeArguments: NodeArray<TypeNode>? get() = definedExternally; set(value) = definedExternally
}
external interface TypePredicateNode : TypeNode {
    override var kind: SyntaxKind.TypePredicate
    var parameterName: dynamic /* Identifier | ThisTypeNode */
    var type: TypeNode
}
external interface TypeQueryNode : TypeNode {
    override var kind: SyntaxKind.TypeQuery
    var exprName: dynamic /* Identifier | QualifiedName */
}
external interface TypeLiteralNode : TypeNode, Declaration {
    override var kind: SyntaxKind.TypeLiteral
    var members: NodeArray<TypeElement>
}
external interface ArrayTypeNode : TypeNode {
    override var kind: SyntaxKind.ArrayType
    var elementType: TypeNode
}
external interface TupleTypeNode : TypeNode {
    override var kind: SyntaxKind.TupleType
    var elementTypes: NodeArray<TypeNode>
}
external interface UnionTypeNode : TypeNode {
    override var kind: SyntaxKind.UnionType
    var types: NodeArray<TypeNode>
}
external interface IntersectionTypeNode : TypeNode {
    override var kind: SyntaxKind.IntersectionType
    var types: NodeArray<TypeNode>
}
external interface ParenthesizedTypeNode : TypeNode {
    override var kind: SyntaxKind.ParenthesizedType
    var type: TypeNode
}
external interface TypeOperatorNode : TypeNode {
    override var kind: SyntaxKind.TypeOperator
    var operator: SyntaxKind.KeyOfKeyword
    var type: TypeNode
}
external interface IndexedAccessTypeNode : TypeNode {
    override var kind: SyntaxKind.IndexedAccessType
    var objectType: TypeNode
    var indexType: TypeNode
}
external interface MappedTypeNode : TypeNode, Declaration {
    override var kind: SyntaxKind.MappedType
    override var parent: TypeAliasDeclaration? get() = definedExternally; set(value) = definedExternally
    var readonlyToken: Token<SyntaxKind.ReadonlyKeyword>? get() = definedExternally; set(value) = definedExternally
    var typeParameter: TypeParameterDeclaration
    var questionToken: Token<SyntaxKind.QuestionToken>? get() = definedExternally; set(value) = definedExternally
    var type: TypeNode? get() = definedExternally; set(value) = definedExternally
}
external interface LiteralTypeNode : TypeNode {
    override var kind: SyntaxKind.LiteralType
    var literal: Expression
}
external interface StringLiteral : LiteralExpression {
    override var kind: SyntaxKind.StringLiteral
}
external interface Expression : Node {
    var _expressionBrand: Any
}
external interface OmittedExpression : Expression {
    override var kind: SyntaxKind.OmittedExpression
}
external interface PartiallyEmittedExpression : LeftHandSideExpression {
    override var kind: SyntaxKind.PartiallyEmittedExpression
    var expression: Expression
}
external interface UnaryExpression : Expression {
    var _unaryExpressionBrand: Any
}
external interface IncrementExpression : UnaryExpression {
    var _incrementExpressionBrand: Any
}
external interface PrefixUnaryExpression : IncrementExpression {
    override var kind: SyntaxKind.PrefixUnaryExpression
    var operator: dynamic /* SyntaxKind.PlusPlusToken | SyntaxKind.MinusMinusToken | SyntaxKind.PlusToken | SyntaxKind.MinusToken | SyntaxKind.TildeToken | SyntaxKind.ExclamationToken */
    var operand: UnaryExpression
}
external interface PostfixUnaryExpression : IncrementExpression {
    override var kind: SyntaxKind.PostfixUnaryExpression
    var operand: LeftHandSideExpression
    var operator: dynamic /* SyntaxKind.PlusPlusToken | SyntaxKind.MinusMinusToken */
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
external interface NullLiteral : PrimaryExpression, TypeNode {
    override var kind: SyntaxKind.NullKeyword
}
external interface BooleanLiteral : PrimaryExpression, TypeNode {
    override var kind: dynamic /* SyntaxKind.TrueKeyword | SyntaxKind.FalseKeyword */
}
external interface ThisExpression : PrimaryExpression, KeywordTypeNode {
    override var kind: SyntaxKind.ThisKeyword
}
external interface SuperExpression : PrimaryExpression {
    override var kind: SyntaxKind.SuperKeyword
}
external interface DeleteExpression : UnaryExpression {
    override var kind: SyntaxKind.DeleteExpression
    var expression: UnaryExpression
}
external interface TypeOfExpression : UnaryExpression {
    override var kind: SyntaxKind.TypeOfExpression
    var expression: UnaryExpression
}
external interface VoidExpression : UnaryExpression {
    override var kind: SyntaxKind.VoidExpression
    var expression: UnaryExpression
}
external interface AwaitExpression : UnaryExpression {
    override var kind: SyntaxKind.AwaitExpression
    var expression: UnaryExpression
}
external interface YieldExpression : Expression {
    override var kind: SyntaxKind.YieldExpression
    var asteriskToken: Token<SyntaxKind.AsteriskToken>? get() = definedExternally; set(value) = definedExternally
    var expression: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface BinaryExpression : Expression, Declaration {
    override var kind: SyntaxKind.BinaryExpression
    var left: Expression
    var operatorToken: Token<dynamic /* SyntaxKind.AsteriskAsteriskToken | SyntaxKind.AsteriskToken | SyntaxKind.SlashToken | SyntaxKind.PercentToken | SyntaxKind.PlusToken | SyntaxKind.MinusToken | SyntaxKind.LessThanLessThanToken | SyntaxKind.GreaterThanGreaterThanToken | SyntaxKind.GreaterThanGreaterThanGreaterThanToken | SyntaxKind.LessThanToken | SyntaxKind.LessThanEqualsToken | SyntaxKind.GreaterThanToken | SyntaxKind.GreaterThanEqualsToken | SyntaxKind.InstanceOfKeyword | SyntaxKind.InKeyword | SyntaxKind.EqualsEqualsToken | SyntaxKind.EqualsEqualsEqualsToken | SyntaxKind.ExclamationEqualsEqualsToken | SyntaxKind.ExclamationEqualsToken | SyntaxKind.AmpersandToken | SyntaxKind.BarToken | SyntaxKind.CaretToken | SyntaxKind.AmpersandAmpersandToken | SyntaxKind.BarBarToken | SyntaxKind.EqualsToken | SyntaxKind.PlusEqualsToken | SyntaxKind.MinusEqualsToken | SyntaxKind.AsteriskAsteriskEqualsToken | SyntaxKind.AsteriskEqualsToken | SyntaxKind.SlashEqualsToken | SyntaxKind.PercentEqualsToken | SyntaxKind.AmpersandEqualsToken | SyntaxKind.BarEqualsToken | SyntaxKind.CaretEqualsToken | SyntaxKind.LessThanLessThanEqualsToken | SyntaxKind.GreaterThanGreaterThanGreaterThanEqualsToken | SyntaxKind.GreaterThanGreaterThanEqualsToken | SyntaxKind.CommaToken */>
    var right: Expression
}
external interface AssignmentExpression<TOperator : Token<dynamic /* SyntaxKind.EqualsToken | SyntaxKind.PlusEqualsToken | SyntaxKind.MinusEqualsToken | SyntaxKind.AsteriskAsteriskEqualsToken | SyntaxKind.AsteriskEqualsToken | SyntaxKind.SlashEqualsToken | SyntaxKind.PercentEqualsToken | SyntaxKind.AmpersandEqualsToken | SyntaxKind.BarEqualsToken | SyntaxKind.CaretEqualsToken | SyntaxKind.LessThanLessThanEqualsToken | SyntaxKind.GreaterThanGreaterThanGreaterThanEqualsToken | SyntaxKind.GreaterThanGreaterThanEqualsToken */>> : BinaryExpression {
    override var left: LeftHandSideExpression
    override var operatorToken: TOperator
}
external interface ObjectDestructuringAssignment : AssignmentExpression<Token<SyntaxKind.EqualsToken>> {
    override var left: ObjectLiteralExpression
}
external interface ArrayDestructuringAssignment : AssignmentExpression<Token<SyntaxKind.EqualsToken>> {
    override var left: ArrayLiteralExpression
}
external interface ConditionalExpression : Expression {
    override var kind: SyntaxKind.ConditionalExpression
    var condition: Expression
    var questionToken: Token<SyntaxKind.QuestionToken>
    var whenTrue: Expression
    var colonToken: Token<SyntaxKind.ColonToken>
    var whenFalse: Expression
}
external interface FunctionExpression : PrimaryExpression, FunctionLikeDeclaration {
    override var kind: SyntaxKind.FunctionExpression
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
    override var body: Block
}
external interface ArrowFunction : Expression, FunctionLikeDeclaration {
    override var kind: SyntaxKind.ArrowFunction
    var equalsGreaterThanToken: Token<SyntaxKind.EqualsGreaterThanToken>
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
external interface RegularExpressionLiteral : LiteralExpression {
    override var kind: SyntaxKind.RegularExpressionLiteral
}
external interface NoSubstitutionTemplateLiteral : LiteralExpression {
    override var kind: SyntaxKind.NoSubstitutionTemplateLiteral
}
external interface NumericLiteral : LiteralExpression {
    override var kind: SyntaxKind.NumericLiteral
}
external interface TemplateHead : LiteralLikeNode {
    override var kind: SyntaxKind.TemplateHead
    override var parent: TemplateExpression? get() = definedExternally; set(value) = definedExternally
}
external interface TemplateMiddle : LiteralLikeNode {
    override var kind: SyntaxKind.TemplateMiddle
    override var parent: TemplateSpan? get() = definedExternally; set(value) = definedExternally
}
external interface TemplateTail : LiteralLikeNode {
    override var kind: SyntaxKind.TemplateTail
    override var parent: TemplateSpan? get() = definedExternally; set(value) = definedExternally
}
external interface TemplateExpression : PrimaryExpression {
    override var kind: SyntaxKind.TemplateExpression
    var head: TemplateHead
    var templateSpans: NodeArray<TemplateSpan>
}
external interface TemplateSpan : Node {
    override var kind: SyntaxKind.TemplateSpan
    override var parent: TemplateExpression? get() = definedExternally; set(value) = definedExternally
    var expression: Expression
    var literal: dynamic /* TemplateMiddle | TemplateTail */
}
external interface ParenthesizedExpression : PrimaryExpression {
    override var kind: SyntaxKind.ParenthesizedExpression
    var expression: Expression
}
external interface ArrayLiteralExpression : PrimaryExpression {
    override var kind: SyntaxKind.ArrayLiteralExpression
    var elements: NodeArray<Expression>
}
external interface SpreadElement : Expression {
    override var kind: SyntaxKind.SpreadElement
    var expression: Expression
}
external interface ObjectLiteralExpressionBase<T : ObjectLiteralElement> : PrimaryExpression, Declaration {
    var properties: NodeArray<T>
}
external interface ObjectLiteralExpression : ObjectLiteralExpressionBase<dynamic /* PropertyAssignment | ShorthandPropertyAssignment | SpreadAssignment | MethodDeclaration | GetAccessorDeclaration | SetAccessorDeclaration */> {
    override var kind: SyntaxKind.ObjectLiteralExpression
}
external interface PropertyAccessExpression : MemberExpression, NamedDeclaration {
    override var kind: SyntaxKind.PropertyAccessExpression
    var expression: LeftHandSideExpression
    override var name: Identifier
}
external interface SuperPropertyAccessExpression : PropertyAccessExpression {
    override var expression: SuperExpression
}
external interface PropertyAccessEntityNameExpression : PropertyAccessExpression {
    var _propertyAccessExpressionLikeQualifiedNameBrand: Any? get() = definedExternally; set(value) = definedExternally
    override var expression: dynamic /* Identifier | PropertyAccessEntityNameExpression | ParenthesizedExpression */
}
external interface ElementAccessExpression : MemberExpression {
    override var kind: SyntaxKind.ElementAccessExpression
    var expression: LeftHandSideExpression
    var argumentExpression: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface SuperElementAccessExpression : ElementAccessExpression {
    override var expression: SuperExpression
}
external interface CallExpression : LeftHandSideExpression, Declaration {
    override var kind: SyntaxKind.CallExpression
    var expression: LeftHandSideExpression
    var typeArguments: NodeArray<TypeNode>? get() = definedExternally; set(value) = definedExternally
    var arguments: NodeArray<Expression>
}
external interface SuperCall : CallExpression {
    override var expression: SuperExpression
}
external interface ExpressionWithTypeArguments : TypeNode {
    override var kind: SyntaxKind.ExpressionWithTypeArguments
    override var parent: HeritageClause? get() = definedExternally; set(value) = definedExternally
    var expression: LeftHandSideExpression
    var typeArguments: NodeArray<TypeNode>? get() = definedExternally; set(value) = definedExternally
}
external interface NewExpression : PrimaryExpression, Declaration {
    override var kind: SyntaxKind.NewExpression
    var expression: LeftHandSideExpression
    var typeArguments: NodeArray<TypeNode>? get() = definedExternally; set(value) = definedExternally
    var arguments: NodeArray<Expression>? get() = definedExternally; set(value) = definedExternally
}
external interface TaggedTemplateExpression : MemberExpression {
    override var kind: SyntaxKind.TaggedTemplateExpression
    var tag: LeftHandSideExpression
    var template: dynamic /* TemplateExpression | NoSubstitutionTemplateLiteral */
}
external interface AsExpression : Expression {
    override var kind: SyntaxKind.AsExpression
    var expression: Expression
    var type: TypeNode
}
external interface TypeAssertion : UnaryExpression {
    override var kind: SyntaxKind.TypeAssertionExpression
    var type: TypeNode
    var expression: UnaryExpression
}
external interface NonNullExpression : LeftHandSideExpression {
    override var kind: SyntaxKind.NonNullExpression
    var expression: Expression
}
external interface MetaProperty : PrimaryExpression {
    override var kind: SyntaxKind.MetaProperty
    var keywordToken: SyntaxKind
    var name: Identifier
}
external interface JsxElement : PrimaryExpression {
    override var kind: SyntaxKind.JsxElement
    var openingElement: JsxOpeningElement
    var children: NodeArray<JsxChild>
    var closingElement: JsxClosingElement
}
external interface JsxAttributes : ObjectLiteralExpressionBase<dynamic /* JsxAttribute | JsxSpreadAttribute */> {
    override var parent: dynamic /* JsxSelfClosingElement | JsxOpeningElement */ get() = definedExternally; set(value) = definedExternally
}
external interface JsxOpeningElement : Expression {
    override var kind: SyntaxKind.JsxOpeningElement
    override var parent: JsxElement? get() = definedExternally; set(value) = definedExternally
    var tagName: dynamic /* PrimaryExpression | PropertyAccessExpression */
    var attributes: JsxAttributes
}
external interface JsxSelfClosingElement : PrimaryExpression {
    override var kind: SyntaxKind.JsxSelfClosingElement
    var tagName: dynamic /* PrimaryExpression | PropertyAccessExpression */
    var attributes: JsxAttributes
}
external interface JsxAttribute : ObjectLiteralElement {
    override var kind: SyntaxKind.JsxAttribute
    override var parent: JsxAttributes? get() = definedExternally; set(value) = definedExternally
    override var name: Identifier
    var initializer: dynamic /* StringLiteral | JsxExpression */ get() = definedExternally; set(value) = definedExternally
}
external interface JsxSpreadAttribute : ObjectLiteralElement {
    override var kind: SyntaxKind.JsxSpreadAttribute
    override var parent: JsxAttributes? get() = definedExternally; set(value) = definedExternally
    var expression: Expression
}
external interface JsxClosingElement : Node {
    override var kind: SyntaxKind.JsxClosingElement
    override var parent: JsxElement? get() = definedExternally; set(value) = definedExternally
    var tagName: dynamic /* PrimaryExpression | PropertyAccessExpression */
}
external interface JsxExpression : Expression {
    override var kind: SyntaxKind.JsxExpression
    override var parent: dynamic /* JsxElement | JsxAttribute | JsxSpreadAttribute */ get() = definedExternally; set(value) = definedExternally
    var dotDotDotToken: Token<SyntaxKind.DotDotDotToken>? get() = definedExternally; set(value) = definedExternally
    var expression: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface JsxText : Node {
    override var kind: SyntaxKind.JsxText
    var containsOnlyWhiteSpaces: Boolean
    override var parent: JsxElement? get() = definedExternally; set(value) = definedExternally
}
external interface Statement : Node {
    var _statementBrand: Any
}
external interface NotEmittedStatement : Statement {
    override var kind: SyntaxKind.NotEmittedStatement
}
external interface EmptyStatement : Statement {
    override var kind: SyntaxKind.EmptyStatement
}
external interface DebuggerStatement : Statement {
    override var kind: SyntaxKind.DebuggerStatement
}
external interface MissingDeclaration : DeclarationStatement, ClassElement, ObjectLiteralElement, TypeElement {
    override var kind: SyntaxKind.MissingDeclaration
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
}
external interface Block : Statement {
    override var kind: SyntaxKind.Block
    var statements: NodeArray<Statement>
}
external interface VariableStatement : Statement {
    override var kind: SyntaxKind.VariableStatement
    var declarationList: VariableDeclarationList
}
external interface ExpressionStatement : Statement {
    override var kind: SyntaxKind.ExpressionStatement
    var expression: Expression
}
external interface IfStatement : Statement {
    override var kind: SyntaxKind.IfStatement
    var expression: Expression
    var thenStatement: Statement
    var elseStatement: Statement? get() = definedExternally; set(value) = definedExternally
}
external interface IterationStatement : Statement {
    var statement: Statement
}
external interface DoStatement : IterationStatement {
    override var kind: SyntaxKind.DoStatement
    var expression: Expression
}
external interface WhileStatement : IterationStatement {
    override var kind: SyntaxKind.WhileStatement
    var expression: Expression
}
external interface ForStatement : IterationStatement {
    override var kind: SyntaxKind.ForStatement
    var initializer: dynamic /* VariableDeclarationList | Expression */ get() = definedExternally; set(value) = definedExternally
    var condition: Expression? get() = definedExternally; set(value) = definedExternally
    var incrementor: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface ForInStatement : IterationStatement {
    override var kind: SyntaxKind.ForInStatement
    var initializer: dynamic /* VariableDeclarationList | Expression */
    var expression: Expression
}
external interface ForOfStatement : IterationStatement {
    override var kind: SyntaxKind.ForOfStatement
    var awaitModifier: Token<SyntaxKind.AwaitKeyword>? get() = definedExternally; set(value) = definedExternally
    var initializer: dynamic /* VariableDeclarationList | Expression */
    var expression: Expression
}
external interface BreakStatement : Statement {
    override var kind: SyntaxKind.BreakStatement
    var label: Identifier? get() = definedExternally; set(value) = definedExternally
}
external interface ContinueStatement : Statement {
    override var kind: SyntaxKind.ContinueStatement
    var label: Identifier? get() = definedExternally; set(value) = definedExternally
}
external interface ReturnStatement : Statement {
    override var kind: SyntaxKind.ReturnStatement
    var expression: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface WithStatement : Statement {
    override var kind: SyntaxKind.WithStatement
    var expression: Expression
    var statement: Statement
}
external interface SwitchStatement : Statement {
    override var kind: SyntaxKind.SwitchStatement
    var expression: Expression
    var caseBlock: CaseBlock
    var possiblyExhaustive: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface CaseBlock : Node {
    override var kind: SyntaxKind.CaseBlock
    override var parent: SwitchStatement? get() = definedExternally; set(value) = definedExternally
    var clauses: NodeArray<CaseOrDefaultClause>
}
external interface CaseClause : Node {
    override var kind: SyntaxKind.CaseClause
    override var parent: CaseBlock? get() = definedExternally; set(value) = definedExternally
    var expression: Expression
    var statements: NodeArray<Statement>
}
external interface DefaultClause : Node {
    override var kind: SyntaxKind.DefaultClause
    override var parent: CaseBlock? get() = definedExternally; set(value) = definedExternally
    var statements: NodeArray<Statement>
}
external interface LabeledStatement : Statement {
    override var kind: SyntaxKind.LabeledStatement
    var label: Identifier
    var statement: Statement
}
external interface ThrowStatement : Statement {
    override var kind: SyntaxKind.ThrowStatement
    var expression: Expression
}
external interface TryStatement : Statement {
    override var kind: SyntaxKind.TryStatement
    var tryBlock: Block
    var catchClause: CatchClause? get() = definedExternally; set(value) = definedExternally
    var finallyBlock: Block? get() = definedExternally; set(value) = definedExternally
}
external interface CatchClause : Node {
    override var kind: SyntaxKind.CatchClause
    override var parent: TryStatement? get() = definedExternally; set(value) = definedExternally
    var variableDeclaration: VariableDeclaration
    var block: Block
}
external interface ClassLikeDeclaration : NamedDeclaration {
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
    var typeParameters: NodeArray<TypeParameterDeclaration>? get() = definedExternally; set(value) = definedExternally
    var heritageClauses: NodeArray<HeritageClause>? get() = definedExternally; set(value) = definedExternally
    var members: NodeArray<ClassElement>
}
external interface ClassDeclaration : ClassLikeDeclaration, DeclarationStatement {
    override var kind: SyntaxKind.ClassDeclaration
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
}
external interface ClassExpression : ClassLikeDeclaration, PrimaryExpression {
    override var kind: SyntaxKind.ClassExpression
}
external interface ClassElement : NamedDeclaration {
    var _classElementBrand: Any
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
}
external interface TypeElement : NamedDeclaration {
    var _typeElementBrand: Any
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */ get() = definedExternally; set(value) = definedExternally
    var questionToken: Token<SyntaxKind.QuestionToken>? get() = definedExternally; set(value) = definedExternally
}
external interface InterfaceDeclaration : DeclarationStatement {
    override var kind: SyntaxKind.InterfaceDeclaration
    override var name: Identifier
    var typeParameters: NodeArray<TypeParameterDeclaration>? get() = definedExternally; set(value) = definedExternally
    var heritageClauses: NodeArray<HeritageClause>? get() = definedExternally; set(value) = definedExternally
    var members: NodeArray<TypeElement>
}
external interface HeritageClause : Node {
    override var kind: SyntaxKind.HeritageClause
    override var parent: dynamic /* InterfaceDeclaration | ClassDeclaration | ClassExpression */ get() = definedExternally; set(value) = definedExternally
    var token: dynamic /* SyntaxKind.ExtendsKeyword | SyntaxKind.ImplementsKeyword */
    var types: NodeArray<ExpressionWithTypeArguments>
}
external interface TypeAliasDeclaration : DeclarationStatement {
    override var kind: SyntaxKind.TypeAliasDeclaration
    override var name: Identifier
    var typeParameters: NodeArray<TypeParameterDeclaration>? get() = definedExternally; set(value) = definedExternally
    var type: TypeNode
}
external interface EnumMember : NamedDeclaration {
    override var kind: SyntaxKind.EnumMember
    override var parent: EnumDeclaration? get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral | ComputedPropertyName */
    var initializer: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface EnumDeclaration : DeclarationStatement {
    override var kind: SyntaxKind.EnumDeclaration
    override var name: Identifier
    var members: NodeArray<EnumMember>
}
external interface ModuleDeclaration : DeclarationStatement {
    override var kind: SyntaxKind.ModuleDeclaration
    override var parent: dynamic /* NamespaceBody | JSDocNamespaceBody | SourceFile */ get() = definedExternally; set(value) = definedExternally
    override var name: dynamic /* Identifier | StringLiteral */
    var body: dynamic /* NamespaceBody | JSDocNamespaceBody | JSDocNamespaceDeclaration */ get() = definedExternally; set(value) = definedExternally
}
external interface NamespaceDeclaration : ModuleDeclaration {
    override var name: Identifier
    override var body: dynamic /* ModuleBlock | NamespaceDeclaration */
}
external interface JSDocNamespaceDeclaration : ModuleDeclaration {
    override var name: Identifier
    override var body: dynamic /* Identifier | JSDocNamespaceDeclaration */
}
external interface ModuleBlock : Node, Statement {
    override var kind: SyntaxKind.ModuleBlock
    override var parent: ModuleDeclaration? get() = definedExternally; set(value) = definedExternally
    var statements: NodeArray<Statement>
}
external interface ImportEqualsDeclaration : DeclarationStatement {
    override var kind: SyntaxKind.ImportEqualsDeclaration
    override var parent: dynamic /* SourceFile | ModuleBlock */ get() = definedExternally; set(value) = definedExternally
    override var name: Identifier
    var moduleReference: dynamic /* Identifier | QualifiedName | ExternalModuleReference */
}
external interface ExternalModuleReference : Node {
    override var kind: SyntaxKind.ExternalModuleReference
    override var parent: ImportEqualsDeclaration? get() = definedExternally; set(value) = definedExternally
    var expression: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface ImportDeclaration : Statement {
    override var kind: SyntaxKind.ImportDeclaration
    override var parent: dynamic /* SourceFile | ModuleBlock */ get() = definedExternally; set(value) = definedExternally
    var importClause: ImportClause? get() = definedExternally; set(value) = definedExternally
    var moduleSpecifier: Expression
}
external interface ImportClause : NamedDeclaration {
    override var kind: SyntaxKind.ImportClause
    override var parent: ImportDeclaration? get() = definedExternally; set(value) = definedExternally
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
    var namedBindings: dynamic /* NamespaceImport | NamedImports */ get() = definedExternally; set(value) = definedExternally
}
external interface NamespaceImport : NamedDeclaration {
    override var kind: SyntaxKind.NamespaceImport
    override var parent: ImportClause? get() = definedExternally; set(value) = definedExternally
    override var name: Identifier
}
external interface NamespaceExportDeclaration : DeclarationStatement {
    override var kind: SyntaxKind.NamespaceExportDeclaration
    override var name: Identifier
}
external interface ExportDeclaration : DeclarationStatement {
    override var kind: SyntaxKind.ExportDeclaration
    override var parent: dynamic /* SourceFile | ModuleBlock */ get() = definedExternally; set(value) = definedExternally
    var exportClause: NamedExports? get() = definedExternally; set(value) = definedExternally
    var moduleSpecifier: Expression? get() = definedExternally; set(value) = definedExternally
}
external interface NamedImports : Node {
    override var kind: SyntaxKind.NamedImports
    override var parent: ImportClause? get() = definedExternally; set(value) = definedExternally
    var elements: NodeArray<ImportSpecifier>
}
external interface NamedExports : Node {
    override var kind: SyntaxKind.NamedExports
    override var parent: ExportDeclaration? get() = definedExternally; set(value) = definedExternally
    var elements: NodeArray<ExportSpecifier>
}
external interface ImportSpecifier : NamedDeclaration {
    override var kind: SyntaxKind.ImportSpecifier
    override var parent: NamedImports? get() = definedExternally; set(value) = definedExternally
    var propertyName: Identifier? get() = definedExternally; set(value) = definedExternally
    override var name: Identifier
}
external interface ExportSpecifier : NamedDeclaration {
    override var kind: SyntaxKind.ExportSpecifier
    override var parent: NamedExports? get() = definedExternally; set(value) = definedExternally
    var propertyName: Identifier? get() = definedExternally; set(value) = definedExternally
    override var name: Identifier
}
external interface ExportAssignment : DeclarationStatement {
    override var kind: SyntaxKind.ExportAssignment
    override var parent: SourceFile? get() = definedExternally; set(value) = definedExternally
    var isExportEquals: Boolean? get() = definedExternally; set(value) = definedExternally
    var expression: Expression
}
external interface FileReference : TextRange {
    var fileName: String
}
external interface CheckJsDirective : TextRange {
    var enabled: Boolean
}
external interface CommentRange : TextRange {
    var hasTrailingNewLine: Boolean? get() = definedExternally; set(value) = definedExternally
    var kind: dynamic /* SyntaxKind.SingleLineCommentTrivia | SyntaxKind.MultiLineCommentTrivia */
}
external interface SynthesizedComment : CommentRange {
    var text: String
    override var pos: Any /* "null" */
    override var end: Any /* "null" */
}
external interface JSDocTypeExpression : Node {
    override var kind: SyntaxKind.JSDocTypeExpression
    var type: JSDocType
}
external interface JSDocType : TypeNode {
    var _jsDocTypeBrand: Any
}
external interface JSDocAllType : JSDocType {
    override var kind: SyntaxKind.JSDocAllType
}
external interface JSDocUnknownType : JSDocType {
    override var kind: SyntaxKind.JSDocUnknownType
}
external interface JSDocArrayType : JSDocType {
    override var kind: SyntaxKind.JSDocArrayType
    var elementType: JSDocType
}
external interface JSDocUnionType : JSDocType {
    override var kind: SyntaxKind.JSDocUnionType
    var types: NodeArray<JSDocType>
}
external interface JSDocTupleType : JSDocType {
    override var kind: SyntaxKind.JSDocTupleType
    var types: NodeArray<JSDocType>
}
external interface JSDocNonNullableType : JSDocType {
    override var kind: SyntaxKind.JSDocNonNullableType
    var type: JSDocType
}
external interface JSDocNullableType : JSDocType {
    override var kind: SyntaxKind.JSDocNullableType
    var type: JSDocType
}
external interface JSDocRecordType : JSDocType {
    override var kind: SyntaxKind.JSDocRecordType
    var literal: TypeLiteralNode
}
external interface JSDocTypeReference : JSDocType {
    override var kind: SyntaxKind.JSDocTypeReference
    var name: dynamic /* Identifier | QualifiedName */
    var typeArguments: NodeArray<JSDocType>
}
external interface JSDocOptionalType : JSDocType {
    override var kind: SyntaxKind.JSDocOptionalType
    var type: JSDocType
}
external interface JSDocFunctionType : JSDocType, SignatureDeclaration {
    override var kind: SyntaxKind.JSDocFunctionType
    override var parameters: NodeArray<ParameterDeclaration>
    override var type: JSDocType
}
external interface JSDocVariadicType : JSDocType {
    override var kind: SyntaxKind.JSDocVariadicType
    var type: JSDocType
}
external interface JSDocConstructorType : JSDocType {
    override var kind: SyntaxKind.JSDocConstructorType
    var type: JSDocType
}
external interface JSDocThisType : JSDocType {
    override var kind: SyntaxKind.JSDocThisType
    var type: JSDocType
}
external interface JSDocLiteralType : JSDocType {
    override var kind: SyntaxKind.JSDocLiteralType
    var literal: LiteralTypeNode
}
external interface JSDocRecordMember : PropertySignature {
    override var kind: SyntaxKind.JSDocRecordMember
    override var name: dynamic /* Identifier | StringLiteral | NumericLiteral */
    override var type: JSDocType? get() = definedExternally; set(value) = definedExternally
}
external interface JSDoc : Node {
    override var kind: SyntaxKind.JSDocComment
    var tags: NodeArray<JSDocTag>?
    var comment: String?
}
external interface JSDocTag : Node {
    var atToken: Token<SyntaxKind.AtToken>
    var tagName: Identifier
    var comment: String?
}
external interface JSDocUnknownTag : JSDocTag {
    override var kind: SyntaxKind.JSDocTag
}
external interface JSDocAugmentsTag : JSDocTag {
    override var kind: SyntaxKind.JSDocAugmentsTag
    var typeExpression: JSDocTypeExpression
}
external interface JSDocTemplateTag : JSDocTag {
    override var kind: SyntaxKind.JSDocTemplateTag
    var typeParameters: NodeArray<TypeParameterDeclaration>
}
external interface JSDocReturnTag : JSDocTag {
    override var kind: SyntaxKind.JSDocReturnTag
    var typeExpression: JSDocTypeExpression
}
external interface JSDocTypeTag : JSDocTag {
    override var kind: SyntaxKind.JSDocTypeTag
    var typeExpression: JSDocTypeExpression
}
external interface JSDocTypedefTag : JSDocTag, NamedDeclaration {
    override var kind: SyntaxKind.JSDocTypedefTag
    var fullName: dynamic /* JSDocNamespaceDeclaration | Identifier */ get() = definedExternally; set(value) = definedExternally
    override var name: Identifier? get() = definedExternally; set(value) = definedExternally
    var typeExpression: JSDocTypeExpression? get() = definedExternally; set(value) = definedExternally
    var jsDocTypeLiteral: JSDocTypeLiteral? get() = definedExternally; set(value) = definedExternally
}
external interface JSDocPropertyTag : JSDocTag, TypeElement {
    override var kind: SyntaxKind.JSDocPropertyTag
    override var name: Identifier
    var typeExpression: JSDocTypeExpression
}
external interface JSDocTypeLiteral : JSDocType {
    override var kind: SyntaxKind.JSDocTypeLiteral
    var jsDocPropertyTags: NodeArray<JSDocPropertyTag>? get() = definedExternally; set(value) = definedExternally
    var jsDocTypeTag: JSDocTypeTag? get() = definedExternally; set(value) = definedExternally
}
external interface JSDocParameterTag : JSDocTag {
    override var kind: SyntaxKind.JSDocParameterTag
    var preParameterName: Identifier? get() = definedExternally; set(value) = definedExternally
    var typeExpression: JSDocTypeExpression? get() = definedExternally; set(value) = definedExternally
    var postParameterName: Identifier? get() = definedExternally; set(value) = definedExternally
    var parameterName: Identifier
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
    ArrayMutation /* = 256 */,
    Referenced /* = 512 */,
    Shared /* = 1024 */,
    PreFinally /* = 2048 */,
    AfterFinally /* = 4096 */,
    Label /* = 12 */,
    Condition /* = 96 */
}
external interface FlowLock {
    var locked: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface AfterFinallyFlow : FlowNode, FlowLock {
    var antecedent: FlowNode
}
external interface PreFinallyFlow : FlowNode {
    var antecedent: FlowNode
    var lock: FlowLock
}
external interface FlowNode {
    var flags: FlowFlags
    var id: Number? get() = definedExternally; set(value) = definedExternally
}
external interface FlowStart : FlowNode {
    var container: dynamic /* FunctionExpression | ArrowFunction | MethodDeclaration */ get() = definedExternally; set(value) = definedExternally
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
external interface FlowArrayMutation : FlowNode {
    var node: dynamic /* CallExpression | BinaryExpression */
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
    override var kind: SyntaxKind.SourceFile
    var statements: NodeArray<Statement>
    var endOfFileToken: Token<SyntaxKind.EndOfFileToken>
    var fileName: String
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
    fun getLineEndOfPosition(pos: Number): Number
    fun getLineStarts(): Array<Number>
    fun getPositionOfLineAndCharacter(line: Number, character: Number): Number
    fun update(newText: String, textChangeRange: TextChangeRange): SourceFile
}
external interface Bundle : Node {
    override var kind: SyntaxKind.Bundle
    var sourceFiles: Array<SourceFile>
}
external interface ScriptReferenceHost {
    fun getCompilerOptions(): CompilerOptions
    fun getSourceFile(fileName: String): SourceFile
    fun getSourceFileByPath(path: String /* String & `T$2` */): SourceFile
    fun getCurrentDirectory(): String
}
external interface ParseConfigHost {
    var useCaseSensitiveFileNames: Boolean
    fun readDirectory(rootDir: String, extensions: Array<String>, excludes: Array<String>, includes: Array<String>): Array<String>
    fun fileExists(path: String): Boolean
    fun readFile(path: String): String
}
external interface WriteFileCallback {
    @nativeInvoke
    operator fun invoke(fileName: String, data: String, writeByteOrderMark: Boolean, onError: ((message: String) -> Unit)? = definedExternally /* null */, sourceFiles: Array<SourceFile>? = definedExternally /* null */)
}
external open class OperationCanceledException
external interface CancellationToken {
    fun isCancellationRequested(): Boolean
    fun throwIfCancellationRequested()
}
external interface Program : ScriptReferenceHost {
    fun getRootFileNames(): Array<String>
    fun getSourceFiles(): Array<SourceFile>
    fun emit(targetSourceFile: SourceFile? = definedExternally /* null */, writeFile: WriteFileCallback? = definedExternally /* null */, cancellationToken: CancellationToken? = definedExternally /* null */, emitOnlyDtsFiles: Boolean? = definedExternally /* null */, customTransformers: CustomTransformers? = definedExternally /* null */): EmitResult
    fun getOptionsDiagnostics(cancellationToken: CancellationToken? = definedExternally /* null */): Array<Diagnostic>
    fun getGlobalDiagnostics(cancellationToken: CancellationToken? = definedExternally /* null */): Array<Diagnostic>
    fun getSyntacticDiagnostics(sourceFile: SourceFile? = definedExternally /* null */, cancellationToken: CancellationToken? = definedExternally /* null */): Array<Diagnostic>
    fun getSemanticDiagnostics(sourceFile: SourceFile? = definedExternally /* null */, cancellationToken: CancellationToken? = definedExternally /* null */): Array<Diagnostic>
    fun getDeclarationDiagnostics(sourceFile: SourceFile? = definedExternally /* null */, cancellationToken: CancellationToken? = definedExternally /* null */): Array<Diagnostic>
    fun getTypeChecker(): TypeChecker
}
external interface CustomTransformers {
    var before: Array<TransformerFactory<SourceFile>>? get() = definedExternally; set(value) = definedExternally
    var after: Array<TransformerFactory<SourceFile>>? get() = definedExternally; set(value) = definedExternally
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
    fun getIndexInfoOfType(type: Type, kind: IndexKind): IndexInfo
    fun getSignaturesOfType(type: Type, kind: SignatureKind): Array<Signature>
    fun getIndexTypeOfType(type: Type, kind: IndexKind): Type
    fun getBaseTypes(type: InterfaceType): Array<BaseType>
    fun getBaseTypeOfLiteralType(type: Type): Type
    fun getWidenedType(type: Type): Type
    fun getReturnTypeOfSignature(signature: Signature): Type
    fun getNonNullableType(type: Type): Type
    fun typeToTypeNode(type: Type, enclosingDeclaration: Node? = definedExternally /* null */, flags: NodeBuilderFlags? = definedExternally /* null */): TypeNode
    fun signatureToSignatureDeclaration(signature: Signature, kind: SyntaxKind, enclosingDeclaration: Node? = definedExternally /* null */, flags: NodeBuilderFlags? = definedExternally /* null */): SignatureDeclaration
    fun indexInfoToIndexSignatureDeclaration(indexInfo: IndexInfo, kind: IndexKind, enclosingDeclaration: Node? = definedExternally /* null */, flags: NodeBuilderFlags? = definedExternally /* null */): IndexSignatureDeclaration
    fun getSymbolsInScope(location: Node, meaning: SymbolFlags): Array<Symbol>
    fun getSymbolAtLocation(node: Node): Symbol?
    fun getSymbolsOfParameterPropertyDeclaration(parameter: ParameterDeclaration, parameterName: String): Array<Symbol>
    fun getShorthandAssignmentValueSymbol(location: Node): Symbol
    fun getExportSpecifierLocalTargetSymbol(location: ExportSpecifier): Symbol
    fun getPropertySymbolOfDestructuringAssignment(location: Identifier): Symbol
    fun getTypeAtLocation(node: Node): Type
    fun getTypeFromTypeNode(node: TypeNode): Type
    fun signatureToString(signature: Signature, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */, kind: SignatureKind? = definedExternally /* null */): String
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
    fun getResolvedSignature(node: JsxSelfClosingElement, candidatesOutArray: Array<Signature>? = definedExternally /* null */): Signature
    fun getResolvedSignature(node: JsxOpeningElement, candidatesOutArray: Array<Signature>? = definedExternally /* null */): Signature
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
    fun getAllAttributesTypeFromJsxOpeningLikeElement(elementNode: JsxSelfClosingElement): Type
    fun getAllAttributesTypeFromJsxOpeningLikeElement(elementNode: JsxOpeningElement): Type
    fun getJsxIntrinsicTagNames(): Array<Symbol>
    fun isOptionalParameter(node: ParameterDeclaration): Boolean
    fun getAmbientModules(): Array<Symbol>
    fun tryGetMemberInModuleExports(memberName: String, moduleSymbol: Symbol): Symbol?
    fun getApparentType(type: Type): Type
}
external enum class NodeBuilderFlags {
    None /* = 0 */,
    allowThisInObjectLiteral /* = 1 */,
    allowQualifedNameInPlaceOfIdentifier /* = 2 */,
    allowTypeParameterInQualifiedName /* = 4 */,
    allowAnonymousIdentifier /* = 8 */,
    allowEmptyUnionOrIntersection /* = 16 */,
    allowEmptyTuple /* = 32 */
}
external interface SymbolDisplayBuilder {
    fun buildTypeDisplay(type: Type, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */)
    fun buildSymbolDisplay(symbol: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, meaning: SymbolFlags? = definedExternally /* null */, flags: SymbolFormatFlags? = definedExternally /* null */)
    fun buildSignatureDisplay(signatures: Signature, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */, kind: SignatureKind? = definedExternally /* null */)
    fun buildIndexSignatureDisplay(info: IndexInfo, writer: SymbolWriter, kind: IndexKind, enclosingDeclaration: Node? = definedExternally /* null */, globalFlags: TypeFormatFlags? = definedExternally /* null */, symbolStack: Array<Symbol>? = definedExternally /* null */)
    fun buildParameterDisplay(parameter: Symbol, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */)
    fun buildTypeParameterDisplay(tp: TypeParameter, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */)
    fun buildTypePredicateDisplay(predicate: TypePredicate, writer: SymbolWriter, enclosingDeclaration: Node? = definedExternally /* null */, flags: TypeFormatFlags? = definedExternally /* null */)
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
    fun writeProperty(text: String)
    fun writeSymbol(text: String, symbol: Symbol)
    fun writeLine()
    fun increaseIndent()
    fun decreaseIndent()
    fun clear()
    fun trackSymbol(symbol: Symbol, enclosingDeclaration: Node? = definedExternally /* null */, meaning: SymbolFlags? = definedExternally /* null */)
    fun reportInaccessibleThisError()
    fun reportIllegalExtends()
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
    InTypeAlias /* = 512 */,
    UseTypeAliasValue /* = 1024 */,
    SuppressAnyReturnType /* = 2048 */,
    AddUndefined /* = 4096 */
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
    override var kind: TypePredicateKind.This
}
external interface IdentifierTypePredicate : TypePredicateBase {
    override var kind: TypePredicateKind.Identifier
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
    Prototype /* = 16777216 */,
    ExportStar /* = 33554432 */,
    Optional /* = 67108864 */,
    Transient /* = 134217728 */,
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
    fun getJsDocTags(): Array<JSDocTagInfo>
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
    Object /* = 32768 */,
    Union /* = 65536 */,
    Intersection /* = 131072 */,
    Index /* = 262144 */,
    IndexedAccess /* = 524288 */,
    NonPrimitive /* = 16777216 */,
    Literal /* = 480 */,
    StringOrNumberLiteral /* = 96 */,
    PossiblyFalsy /* = 7406 */,
    StringLike /* = 262178 */,
    NumberLike /* = 340 */,
    BooleanLike /* = 136 */,
    EnumLike /* = 272 */,
    UnionOrIntersection /* = 196608 */,
    StructuredType /* = 229376 */,
    StructuredOrTypeVariable /* = 1032192 */,
    TypeVariable /* = 540672 */,
    Narrowable /* = 17810431 */,
    NotUnionOrUnit /* = 16810497 */
}
external interface Type {
    var flags: TypeFlags
    var symbol: Symbol? get() = definedExternally; set(value) = definedExternally
    var pattern: dynamic /* ObjectBindingPattern | ArrayBindingPattern | ObjectLiteralExpression | ArrayLiteralExpression */ get() = definedExternally; set(value) = definedExternally
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
    fun getBaseTypes(): Array<BaseType>
    fun getNonNullableType(): Type
}
external interface LiteralType : Type {
    var text: String
    var freshType: LiteralType? get() = definedExternally; set(value) = definedExternally
    var regularType: LiteralType? get() = definedExternally; set(value) = definedExternally
}
external interface EnumType : Type {
    var memberTypes: Array<EnumLiteralType>
}
external interface EnumLiteralType : LiteralType {
    var baseType: EnumType /* EnumType & UnionType */
}
external enum class ObjectFlags {
    Class /* = 1 */,
    Interface /* = 2 */,
    Reference /* = 4 */,
    Tuple /* = 8 */,
    Anonymous /* = 16 */,
    Mapped /* = 32 */,
    Instantiated /* = 64 */,
    ObjectLiteral /* = 128 */,
    EvolvingArray /* = 256 */,
    ObjectLiteralPatternWithComputedProperties /* = 512 */,
    ClassOrInterface /* = 3 */
}
external interface ObjectType : Type {
    var objectFlags: ObjectFlags
}
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
external interface EvolvingArrayType : ObjectType {
    var elementType: Type
    var finalArrayType: Type? get() = definedExternally; set(value) = definedExternally
}
external interface TypeVariable : Type
external interface TypeParameter : TypeVariable {
    var constraint: Type
    var default: Type? get() = definedExternally; set(value) = definedExternally
}
external interface IndexedAccessType : TypeVariable {
    var objectType: Type
    var indexType: Type
    var constraint: Type? get() = definedExternally; set(value) = definedExternally
}
external interface IndexType : Type {
    var type: dynamic /* TypeVariable | UnionOrIntersectionType */
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
    fun getTypeParameters(): Array<TypeParameter>
    fun getParameters(): Array<Symbol>
    fun getReturnType(): Type
    fun getDocumentationComment(): Array<SymbolDisplayPart>
    fun getJsDocTags(): Array<JSDocTagInfo>
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
external interface JsFileExtensionInfo {
    var extension: String
    var isMixedContent: Boolean
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
    var source: String? get() = definedExternally; set(value) = definedExternally
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
external interface PluginImport {
    var name: String
}
external interface CompilerOptions {
    var allowJs: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowSyntheticDefaultImports: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowUnreachableCode: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowUnusedLabels: Boolean? get() = definedExternally; set(value) = definedExternally
    var alwaysStrict: Boolean? get() = definedExternally; set(value) = definedExternally
    var baseUrl: String? get() = definedExternally; set(value) = definedExternally
    var charset: String? get() = definedExternally; set(value) = definedExternally
    var checkJs: Boolean? get() = definedExternally; set(value) = definedExternally
    var declaration: Boolean? get() = definedExternally; set(value) = definedExternally
    var declarationDir: String? get() = definedExternally; set(value) = definedExternally
    var disableSizeLimit: Boolean? get() = definedExternally; set(value) = definedExternally
    var downlevelIteration: Boolean? get() = definedExternally; set(value) = definedExternally
    var emitBOM: Boolean? get() = definedExternally; set(value) = definedExternally
    var emitDecoratorMetadata: Boolean? get() = definedExternally; set(value) = definedExternally
    var experimentalDecorators: Boolean? get() = definedExternally; set(value) = definedExternally
    var forceConsistentCasingInFileNames: Boolean? get() = definedExternally; set(value) = definedExternally
    var importHelpers: Boolean? get() = definedExternally; set(value) = definedExternally
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
    var jsxFactory: String? get() = definedExternally; set(value) = definedExternally
    var removeComments: Boolean? get() = definedExternally; set(value) = definedExternally
    var rootDir: String? get() = definedExternally; set(value) = definedExternally
    var rootDirs: Array<String>? get() = definedExternally; set(value) = definedExternally
    var skipLibCheck: Boolean? get() = definedExternally; set(value) = definedExternally
    var skipDefaultLibCheck: Boolean? get() = definedExternally; set(value) = definedExternally
    var sourceMap: Boolean? get() = definedExternally; set(value) = definedExternally
    var sourceRoot: String? get() = definedExternally; set(value) = definedExternally
    var strict: Boolean? get() = definedExternally; set(value) = definedExternally
    var strictNullChecks: Boolean? get() = definedExternally; set(value) = definedExternally
    var suppressExcessPropertyErrors: Boolean? get() = definedExternally; set(value) = definedExternally
    var suppressImplicitAnyIndexErrors: Boolean? get() = definedExternally; set(value) = definedExternally
    var target: ScriptTarget? get() = definedExternally; set(value) = definedExternally
    var traceResolution: Boolean? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
    var typeRoots: Array<String>? get() = definedExternally; set(value) = definedExternally
    @nativeGetter
    operator fun get(option: String): dynamic /* String | Number | Boolean | Array<dynamic /* String | Number */> | Array<String> | MapLike<Array<String>> | Array<PluginImport> | Nothing? */
    @nativeSetter
    operator fun set(option: String, value: String)
    @nativeSetter
    operator fun set(option: String, value: Number)
    @nativeSetter
    operator fun set(option: String, value: Boolean)
    @nativeSetter
    operator fun set(option: String, value: Array<dynamic /* String | Number */>)
    @nativeSetter
    operator fun set(option: String, value: Array<String>)
    @nativeSetter
    operator fun set(option: String, value: MapLike<Array<String>>)
    @nativeSetter
    operator fun set(option: String, value: Array<PluginImport>)
    @nativeSetter
    operator fun set(option: String, value: Nothing?)
}
external interface TypeAcquisition {
    var enableAutoDiscovery: Boolean? get() = definedExternally; set(value) = definedExternally
    var enable: Boolean? get() = definedExternally; set(value) = definedExternally
    var include: Array<String>? get() = definedExternally; set(value) = definedExternally
    var exclude: Array<String>? get() = definedExternally; set(value) = definedExternally
    @nativeGetter
    operator fun get(option: String): dynamic /* Array<String> | Boolean | Nothing? */
    @nativeSetter
    operator fun set(option: String, value: Array<String>)
    @nativeSetter
    operator fun set(option: String, value: Boolean)
    @nativeSetter
    operator fun set(option: String, value: Nothing?)
}
external interface DiscoverTypingsInfo {
    var fileNames: Array<String>
    var projectRootPath: String
    var safeListPath: String
    var packageNameToTypingLocation: Map<String>
    var typeAcquisition: TypeAcquisition
    var compilerOptions: CompilerOptions
    var unresolvedImports: ReadonlyArray<String>
}
external enum class ModuleKind {
    None /* = 0 */,
    CommonJS /* = 1 */,
    AMD /* = 2 */,
    UMD /* = 3 */,
    System /* = 4 */,
    ES2015 /* = 5 */
}
external enum class JsxEmit {
    None /* = 0 */,
    Preserve /* = 1 */,
    React /* = 2 */,
    ReactNative /* = 3 */
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
    TSX /* = 4 */,
    External /* = 5 */
}
external enum class ScriptTarget {
    ES3 /* = 0 */,
    ES5 /* = 1 */,
    ES2015 /* = 2 */,
    ES2016 /* = 3 */,
    ES2017 /* = 4 */,
    ESNext /* = 5 */,
    Latest /* = 5 */
}
external enum class LanguageVariant {
    Standard /* = 0 */,
    JSX /* = 1 */
}
external interface ParsedCommandLine {
    var options: CompilerOptions
    var typeAcquisition: TypeAcquisition? get() = definedExternally; set(value) = definedExternally
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
external interface ResolvedModuleFull : ResolvedModule {
    var extension: Extension
}
external enum class Extension {
    Ts /* = 0 */,
    Tsx /* = 1 */,
    Dts /* = 2 */,
    Js /* = 3 */,
    Jsx /* = 4 */,
    LastTypeScriptExtension /* = 2 */
}
external interface ResolvedModuleWithFailedLookupLocations {
    var resolvedModule: ResolvedModuleFull?
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
    val getSourceFileByPath: (`(fileName: String, path: String /* String & `T$2` */, languageVersion: ScriptTarget, onError: ((message: String) -> Unit)? /*= null*/) -> SourceFile`)? get() = definedExternally
    val getCancellationToken: (() -> CancellationToken)? get() = definedExternally
    fun getDefaultLibFileName(options: CompilerOptions): String
    val getDefaultLibLocation: (() -> String)? get() = definedExternally
    var writeFile: WriteFileCallback
    override fun getCurrentDirectory(): String
    override fun getDirectories(path: String): Array<String>
    fun getCanonicalFileName(fileName: String): String
    fun useCaseSensitiveFileNames(): Boolean
    fun getNewLine(): String
    val resolveModuleNames: ((moduleNames: Array<String>, containingFile: String) -> Array<ResolvedModule>)? get() = definedExternally
    val resolveTypeReferenceDirectives: ((typeReferenceDirectiveNames: Array<String>, containingFile: String) -> Array<ResolvedTypeReferenceDirective>)? get() = definedExternally
    val getEnvironmentVariable: ((name: String) -> String)? get() = definedExternally
}
external enum class EmitFlags {
    SingleLine /* = 1 */,
    AdviseOnEmitNode /* = 2 */,
    NoSubstitution /* = 4 */,
    CapturesThis /* = 8 */,
    NoLeadingSourceMap /* = 16 */,
    NoTrailingSourceMap /* = 32 */,
    NoSourceMap /* = 48 */,
    NoNestedSourceMaps /* = 64 */,
    NoTokenLeadingSourceMaps /* = 128 */,
    NoTokenTrailingSourceMaps /* = 256 */,
    NoTokenSourceMaps /* = 384 */,
    NoLeadingComments /* = 512 */,
    NoTrailingComments /* = 1024 */,
    NoComments /* = 1536 */,
    NoNestedComments /* = 2048 */,
    HelperName /* = 4096 */,
    ExportName /* = 8192 */,
    LocalName /* = 16384 */,
    InternalName /* = 32768 */,
    Indented /* = 65536 */,
    NoIndentation /* = 131072 */,
    AsyncFunctionBody /* = 262144 */,
    ReuseTempVariableScope /* = 524288 */,
    CustomPrologue /* = 1048576 */,
    NoHoisting /* = 2097152 */,
    HasEndOfDeclarationMarker /* = 4194304 */,
    Iterator /* = 8388608 */
}
external interface EmitHelper {
    var name: String
    var scoped: Boolean
    var text: String
    var priority: Number? get() = definedExternally; set(value) = definedExternally
}
external enum class EmitHint {
    SourceFile /* = 0 */,
    Expression /* = 1 */,
    IdentifierName /* = 2 */,
    Unspecified /* = 3 */
}
external interface TransformationContext {
    fun getCompilerOptions(): CompilerOptions
    fun startLexicalEnvironment()
    fun suspendLexicalEnvironment()
    fun resumeLexicalEnvironment()
    fun endLexicalEnvironment(): Array<Statement>
    fun hoistFunctionDeclaration(node: FunctionDeclaration)
    fun hoistVariableDeclaration(node: Identifier)
    fun requestEmitHelper(helper: EmitHelper)
    fun readEmitHelpers(): Array<EmitHelper>?
    fun enableSubstitution(kind: SyntaxKind)
    fun isSubstitutionEnabled(node: Node): Boolean
    var onSubstituteNode: (hint: EmitHint, node: Node) -> Node
    fun enableEmitNotification(kind: SyntaxKind)
    fun isEmitNotificationEnabled(node: Node): Boolean
    var onEmitNode: (hint: EmitHint, node: Node, emitCallback: (hint: EmitHint, node: Node) -> Unit) -> Unit
}
external interface TransformationResult<T : Node> {
    var transformed: Array<T>
    var diagnostics: Array<Diagnostic>? get() = definedExternally; set(value) = definedExternally
    fun substituteNode(hint: EmitHint, node: Node): Node
    fun emitNodeWithNotification(hint: EmitHint, node: Node, emitCallback: (hint: EmitHint, node: Node) -> Unit)
    fun dispose()
}
external interface Printer {
    fun printNode(hint: EmitHint, node: Node, sourceFile: SourceFile): String
    fun printFile(sourceFile: SourceFile): String
    fun printBundle(bundle: Bundle): String
}
external interface PrintHandlers {
    val hasGlobalName: ((name: String) -> Boolean)? get() = definedExternally
    val onEmitNode: ((hint: EmitHint, node: Node, emitCallback: (hint: EmitHint, node: Node) -> Unit) -> Unit)? get() = definedExternally
    val substituteNode: ((hint: EmitHint, node: Node) -> Node)? get() = definedExternally
}
external interface PrinterOptions {
    var removeComments: Boolean? get() = definedExternally; set(value) = definedExternally
    var newLine: NewLineKind? get() = definedExternally; set(value) = definedExternally
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
external var version: Any = definedExternally
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
    val setTimeout: ((callback: (args: Any) -> Unit, ms: Number, args: Any) -> Any)? get() = definedExternally
    val clearTimeout: ((timeoutId: Any) -> Unit)? get() = definedExternally
}
external interface FileWatcher {
    fun close()
}
external interface DirectoryWatcher : FileWatcher {
    var directoryName: String
    var referenceCount: Number
}
external fun getNodeMajorVersion(): Number = definedExternally
external var sys: System = definedExternally
external interface ErrorCallback {
    @nativeInvoke
    operator fun invoke(message: DiagnosticMessage, length: Number)
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
    fun scanJsxAttributeValue(): SyntaxKind
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
external fun isWhiteSpaceLike(ch: Number): Boolean = definedExternally
external fun isWhiteSpaceSingleLine(ch: Number): Boolean = definedExternally
external fun isLineBreak(ch: Number): Boolean = definedExternally
external fun couldStartTrivia(text: String, pos: Number): Boolean = definedExternally
external fun <T, U> forEachLeadingCommentRange(text: String, pos: Number, cb: (pos: Number, end: Number, kind: CommentKind, hasTrailingNewLine: Boolean, state: T) -> U, state: T? = definedExternally /* null */): U = definedExternally
external fun <T, U> forEachTrailingCommentRange(text: String, pos: Number, cb: (pos: Number, end: Number, kind: CommentKind, hasTrailingNewLine: Boolean, state: T) -> U, state: T? = definedExternally /* null */): U = definedExternally
external fun <T, U> reduceEachLeadingCommentRange(text: String, pos: Number, cb: (pos: Number, end: Number, kind: CommentKind, hasTrailingNewLine: Boolean, state: T, memo: U) -> U, state: T, initial: U): U = definedExternally
external fun <T, U> reduceEachTrailingCommentRange(text: String, pos: Number, cb: (pos: Number, end: Number, kind: CommentKind, hasTrailingNewLine: Boolean, state: T, memo: U) -> U, state: T, initial: U): U = definedExternally
external fun getLeadingCommentRanges(text: String, pos: Number): Array<CommentRange>? = definedExternally
external fun getTrailingCommentRanges(text: String, pos: Number): Array<CommentRange>? = definedExternally
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
external fun isParameterPropertyDeclaration(node: Node): Boolean = definedExternally
external fun getCombinedModifierFlags(node: Node): ModifierFlags = definedExternally
external fun getCombinedNodeFlags(node: Node): NodeFlags = definedExternally
external interface `T$3` {
    fun getExecutingFilePath(): String
    fun resolvePath(path: String): String
    fun fileExists(fileName: String): Boolean
    fun readFile(fileName: String): String
}
external fun validateLocaleAndSetLanguage(locale: String, sys: `T$3`, errors: Array<Diagnostic>? = definedExternally /* null */): Unit = definedExternally
external fun getOriginalNode(node: Node): Node = definedExternally
external fun <T : Node> getOriginalNode(node: Node, nodeTest: (node: Node) -> Boolean): T = definedExternally
external fun isParseTreeNode(node: Node): Boolean = definedExternally
external fun getParseTreeNode(node: Node): Node = definedExternally
external fun <T : Node> getParseTreeNode(node: Node, nodeTest: ((node: Node) -> Boolean)? = definedExternally /* null */): T = definedExternally
external fun unescapeIdentifier(identifier: String): String = definedExternally
external fun <T : Node> createNodeArray(elements: Array<T>? = definedExternally /* null */, hasTrailingComma: Boolean? = definedExternally /* null */): NodeArray<T> = definedExternally
external fun createLiteral(value: String): StringLiteral = definedExternally
external fun createLiteral(value: Number): NumericLiteral = definedExternally
external fun createLiteral(value: Boolean): BooleanLiteral = definedExternally
external fun createLiteral(sourceNode: StringLiteral): StringLiteral = definedExternally
external fun createLiteral(sourceNode: NumericLiteral): StringLiteral = definedExternally
external fun createLiteral(sourceNode: Identifier): StringLiteral = definedExternally
external fun createLiteral(value: String): PrimaryExpression = definedExternally
external fun createLiteral(value: Number): PrimaryExpression = definedExternally
external fun createLiteral(value: Boolean): PrimaryExpression = definedExternally
external fun createNumericLiteral(value: String): NumericLiteral = definedExternally
external fun createIdentifier(text: String): Identifier = definedExternally
external fun createTempVariable(recordTempVariable: (node: Identifier) -> Unit?): Identifier = definedExternally
external fun createLoopVariable(): Identifier = definedExternally
external fun createUniqueName(text: String): Identifier = definedExternally
external fun getGeneratedNameForNode(node: Node): Identifier = definedExternally
external fun <TKind : SyntaxKind> createToken(token: TKind): Token<TKind> = definedExternally
external fun createSuper(): SuperExpression = definedExternally
external fun createThis(): ThisExpression /* ThisExpression & Token<SyntaxKind.ThisKeyword> */ = definedExternally
external fun createNull(): NullLiteral /* NullLiteral & Token<SyntaxKind.NullKeyword> */ = definedExternally
external fun createTrue(): BooleanLiteral /* BooleanLiteral & Token<SyntaxKind.TrueKeyword> */ = definedExternally
external fun createFalse(): BooleanLiteral /* BooleanLiteral & Token<SyntaxKind.FalseKeyword> */ = definedExternally
external fun createQualifiedName(left: EntityName, right: String): QualifiedName = definedExternally
external fun createQualifiedName(left: EntityName, right: Identifier): QualifiedName = definedExternally
external fun updateQualifiedName(node: QualifiedName, left: EntityName, right: Identifier): QualifiedName = definedExternally
external fun createComputedPropertyName(expression: Expression): ComputedPropertyName = definedExternally
external fun updateComputedPropertyName(node: ComputedPropertyName, expression: Expression): ComputedPropertyName = definedExternally
external fun createSignatureDeclaration(kind: SyntaxKind, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?): SignatureDeclaration = definedExternally
external fun createFunctionTypeNode(typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?): FunctionTypeNode = definedExternally
external fun updateFunctionTypeNode(node: FunctionTypeNode, typeParameters: NodeArray<TypeParameterDeclaration>?, parameters: NodeArray<ParameterDeclaration>, type: TypeNode?): FunctionTypeNode = definedExternally
external fun createConstructorTypeNode(typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?): ConstructorTypeNode = definedExternally
external fun updateConstructorTypeNode(node: ConstructorTypeNode, typeParameters: NodeArray<TypeParameterDeclaration>?, parameters: NodeArray<ParameterDeclaration>, type: TypeNode?): ConstructorTypeNode = definedExternally
external fun createCallSignatureDeclaration(typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?): CallSignatureDeclaration = definedExternally
external fun updateCallSignatureDeclaration(node: CallSignatureDeclaration, typeParameters: NodeArray<TypeParameterDeclaration>?, parameters: NodeArray<ParameterDeclaration>, type: TypeNode?): CallSignatureDeclaration = definedExternally
external fun createConstructSignatureDeclaration(typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?): ConstructSignatureDeclaration = definedExternally
external fun updateConstructSignatureDeclaration(node: ConstructSignatureDeclaration, typeParameters: NodeArray<TypeParameterDeclaration>?, parameters: NodeArray<ParameterDeclaration>, type: TypeNode?): ConstructSignatureDeclaration = definedExternally
external fun createMethodSignature(typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, name: String, questionToken: QuestionToken?): MethodSignature = definedExternally
external fun createMethodSignature(typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, name: PropertyName, questionToken: QuestionToken?): MethodSignature = definedExternally
external fun updateMethodSignature(node: MethodSignature, typeParameters: NodeArray<TypeParameterDeclaration>?, parameters: NodeArray<ParameterDeclaration>, type: TypeNode?, name: PropertyName, questionToken: QuestionToken?): MethodSignature = definedExternally
external fun createKeywordTypeNode(kind: dynamic /* "IndexedAccessType" kind unsupported yet here! (node_modules/typescript/lib/typescriptServices.d.ts:2744:41 to 2744:65) */): KeywordTypeNode = definedExternally
external fun createThisTypeNode(): ThisTypeNode = definedExternally
external fun createLiteralTypeNode(literal: Expression): LiteralTypeNode = definedExternally
external fun updateLiteralTypeNode(node: LiteralTypeNode, literal: Expression): LiteralTypeNode = definedExternally
external fun createTypeReferenceNode(typeName: String, typeArguments: Array<TypeNode>?): TypeReferenceNode = definedExternally
external fun createTypeReferenceNode(typeName: EntityName, typeArguments: Array<TypeNode>?): TypeReferenceNode = definedExternally
external fun updateTypeReferenceNode(node: TypeReferenceNode, typeName: EntityName, typeArguments: NodeArray<TypeNode>?): TypeReferenceNode = definedExternally
external fun createTypePredicateNode(parameterName: Identifier, type: TypeNode): TypePredicateNode = definedExternally
external fun createTypePredicateNode(parameterName: ThisTypeNode, type: TypeNode): TypePredicateNode = definedExternally
external fun createTypePredicateNode(parameterName: String, type: TypeNode): TypePredicateNode = definedExternally
external fun updateTypePredicateNode(node: TypePredicateNode, parameterName: Identifier, type: TypeNode): TypePredicateNode = definedExternally
external fun updateTypePredicateNode(node: TypePredicateNode, parameterName: ThisTypeNode, type: TypeNode): TypePredicateNode = definedExternally
external fun createTypeQueryNode(exprName: EntityName): TypeQueryNode = definedExternally
external fun updateTypeQueryNode(node: TypeQueryNode, exprName: EntityName): TypeQueryNode = definedExternally
external fun createArrayTypeNode(elementType: TypeNode): ArrayTypeNode = definedExternally
external fun updateArrayTypeNode(node: ArrayTypeNode, elementType: TypeNode): ArrayTypeNode = definedExternally
external fun createUnionOrIntersectionTypeNode(kind: SyntaxKind.UnionType, types: Array<TypeNode>): UnionTypeNode = definedExternally
external fun createUnionOrIntersectionTypeNode(kind: SyntaxKind.IntersectionType, types: Array<TypeNode>): IntersectionTypeNode = definedExternally
external fun createUnionOrIntersectionTypeNode(kind: SyntaxKind.UnionType, types: Array<TypeNode>): UnionOrIntersectionTypeNode = definedExternally
external fun createUnionOrIntersectionTypeNode(kind: SyntaxKind.IntersectionType, types: Array<TypeNode>): UnionOrIntersectionTypeNode = definedExternally
external fun updateUnionOrIntersectionTypeNode(node: UnionOrIntersectionTypeNode, types: NodeArray<TypeNode>): UnionOrIntersectionTypeNode = definedExternally
external fun createTypeLiteralNode(members: Array<TypeElement>): TypeLiteralNode = definedExternally
external fun updateTypeLiteralNode(node: TypeLiteralNode, members: NodeArray<TypeElement>): TypeLiteralNode = definedExternally
external fun createTupleTypeNode(elementTypes: Array<TypeNode>): TupleTypeNode = definedExternally
external fun updateTypleTypeNode(node: TupleTypeNode, elementTypes: Array<TypeNode>): TupleTypeNode = definedExternally
external fun createMappedTypeNode(readonlyToken: ReadonlyToken?, typeParameter: TypeParameterDeclaration, questionToken: QuestionToken?, type: TypeNode?): MappedTypeNode = definedExternally
external fun updateMappedTypeNode(node: MappedTypeNode, readonlyToken: ReadonlyToken?, typeParameter: TypeParameterDeclaration, questionToken: QuestionToken?, type: TypeNode?): MappedTypeNode = definedExternally
external fun createTypeOperatorNode(type: TypeNode): TypeOperatorNode = definedExternally
external fun updateTypeOperatorNode(node: TypeOperatorNode, type: TypeNode): TypeOperatorNode = definedExternally
external fun createIndexedAccessTypeNode(objectType: TypeNode, indexType: TypeNode): IndexedAccessTypeNode = definedExternally
external fun updateIndexedAccessTypeNode(node: IndexedAccessTypeNode, objectType: TypeNode, indexType: TypeNode): IndexedAccessTypeNode = definedExternally
external fun createTypeParameterDeclaration(name: String, constraint: TypeNode?, defaultType: TypeNode?): TypeParameterDeclaration = definedExternally
external fun createTypeParameterDeclaration(name: Identifier, constraint: TypeNode?, defaultType: TypeNode?): TypeParameterDeclaration = definedExternally
external fun updateTypeParameterDeclaration(node: TypeParameterDeclaration, name: Identifier, constraint: TypeNode?, defaultType: TypeNode?): TypeParameterDeclaration = definedExternally
external fun createPropertySignature(name: PropertyName, questionToken: QuestionToken?, type: TypeNode?, initializer: Expression?): PropertySignature = definedExternally
external fun createPropertySignature(name: String, questionToken: QuestionToken?, type: TypeNode?, initializer: Expression?): PropertySignature = definedExternally
external fun updatePropertySignature(node: PropertySignature, name: PropertyName, questionToken: QuestionToken?, type: TypeNode?, initializer: Expression?): PropertySignature = definedExternally
external fun createIndexSignatureDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, parameters: Array<ParameterDeclaration>, type: TypeNode): IndexSignatureDeclaration = definedExternally
external fun updateIndexSignatureDeclaration(node: IndexSignatureDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, parameters: Array<ParameterDeclaration>, type: TypeNode): IndexSignatureDeclaration = definedExternally
external fun createParameter(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, dotDotDotToken: DotDotDotToken?, name: String, questionToken: QuestionToken? = definedExternally /* null */, type: TypeNode? = definedExternally /* null */, initializer: Expression? = definedExternally /* null */): ParameterDeclaration = definedExternally
external fun createParameter(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, dotDotDotToken: DotDotDotToken?, name: BindingName, questionToken: QuestionToken? = definedExternally /* null */, type: TypeNode? = definedExternally /* null */, initializer: Expression? = definedExternally /* null */): ParameterDeclaration = definedExternally
external fun updateParameter(node: ParameterDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, dotDotDotToken: DotDotDotToken?, name: String, questionToken: QuestionToken?, type: TypeNode?, initializer: Expression?): ParameterDeclaration = definedExternally
external fun updateParameter(node: ParameterDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, dotDotDotToken: DotDotDotToken?, name: BindingName, questionToken: QuestionToken?, type: TypeNode?, initializer: Expression?): ParameterDeclaration = definedExternally
external fun createDecorator(expression: Expression): Decorator = definedExternally
external fun updateDecorator(node: Decorator, expression: Expression): Decorator = definedExternally
external fun createProperty(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: String, questionToken: QuestionToken?, type: TypeNode?, initializer: Expression): PropertyDeclaration = definedExternally
external fun createProperty(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: PropertyName, questionToken: QuestionToken?, type: TypeNode?, initializer: Expression): PropertyDeclaration = definedExternally
external fun updateProperty(node: PropertyDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: PropertyName, type: TypeNode?, initializer: Expression): PropertyDeclaration = definedExternally
external fun createMethodDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, asteriskToken: AsteriskToken?, name: String, questionToken: QuestionToken?, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block?): MethodDeclaration = definedExternally
external fun createMethodDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, asteriskToken: AsteriskToken?, name: PropertyName, questionToken: QuestionToken?, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block?): MethodDeclaration = definedExternally
external fun updateMethod(node: MethodDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, asteriskToken: AsteriskToken?, name: PropertyName, questionToken: QuestionToken?, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block?): MethodDeclaration = definedExternally
external fun createConstructor(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, parameters: Array<ParameterDeclaration>, body: Block?): ConstructorDeclaration = definedExternally
external fun updateConstructor(node: ConstructorDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, parameters: Array<ParameterDeclaration>, body: Block?): ConstructorDeclaration = definedExternally
external fun createGetAccessor(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: String, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block?): GetAccessorDeclaration = definedExternally
external fun createGetAccessor(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: PropertyName, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block?): GetAccessorDeclaration = definedExternally
external fun updateGetAccessor(node: GetAccessorDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: PropertyName, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block?): GetAccessorDeclaration = definedExternally
external fun createSetAccessor(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: String, parameters: Array<ParameterDeclaration>, body: Block?): SetAccessorDeclaration = definedExternally
external fun createSetAccessor(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: PropertyName, parameters: Array<ParameterDeclaration>, body: Block?): SetAccessorDeclaration = definedExternally
external fun updateSetAccessor(node: SetAccessorDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: PropertyName, parameters: Array<ParameterDeclaration>, body: Block?): SetAccessorDeclaration = definedExternally
external fun createObjectBindingPattern(elements: Array<BindingElement>): ObjectBindingPattern = definedExternally
external fun updateObjectBindingPattern(node: ObjectBindingPattern, elements: Array<BindingElement>): ObjectBindingPattern = definedExternally
external fun createArrayBindingPattern(elements: Array<ArrayBindingElement>): ArrayBindingPattern = definedExternally
external fun updateArrayBindingPattern(node: ArrayBindingPattern, elements: Array<ArrayBindingElement>): ArrayBindingPattern = definedExternally
external fun createBindingElement(dotDotDotToken: DotDotDotToken?, propertyName: String, name: String, initializer: Expression? = definedExternally /* null */): BindingElement = definedExternally
external fun createBindingElement(dotDotDotToken: DotDotDotToken?, propertyName: String, name: BindingName, initializer: Expression? = definedExternally /* null */): BindingElement = definedExternally
external fun createBindingElement(dotDotDotToken: DotDotDotToken?, propertyName: PropertyName, name: String, initializer: Expression? = definedExternally /* null */): BindingElement = definedExternally
external fun createBindingElement(dotDotDotToken: DotDotDotToken?, propertyName: PropertyName, name: BindingName, initializer: Expression? = definedExternally /* null */): BindingElement = definedExternally
external fun createBindingElement(dotDotDotToken: DotDotDotToken?, propertyName: Nothing?, name: String, initializer: Expression? = definedExternally /* null */): BindingElement = definedExternally
external fun createBindingElement(dotDotDotToken: DotDotDotToken?, propertyName: Nothing?, name: BindingName, initializer: Expression? = definedExternally /* null */): BindingElement = definedExternally
external fun updateBindingElement(node: BindingElement, dotDotDotToken: DotDotDotToken?, propertyName: PropertyName?, name: BindingName, initializer: Expression?): BindingElement = definedExternally
external fun createArrayLiteral(elements: Array<Expression>? = definedExternally /* null */, multiLine: Boolean? = definedExternally /* null */): ArrayLiteralExpression = definedExternally
external fun updateArrayLiteral(node: ArrayLiteralExpression, elements: Array<Expression>): ArrayLiteralExpression = definedExternally
external fun createObjectLiteral(properties: Array<ObjectLiteralElementLike>? = definedExternally /* null */, multiLine: Boolean? = definedExternally /* null */): ObjectLiteralExpression = definedExternally
external fun updateObjectLiteral(node: ObjectLiteralExpression, properties: Array<ObjectLiteralElementLike>): ObjectLiteralExpression = definedExternally
external fun createPropertyAccess(expression: Expression, name: String): PropertyAccessExpression = definedExternally
external fun createPropertyAccess(expression: Expression, name: Identifier): PropertyAccessExpression = definedExternally
external fun updatePropertyAccess(node: PropertyAccessExpression, expression: Expression, name: Identifier): PropertyAccessExpression = definedExternally
external fun createElementAccess(expression: Expression, index: Number): ElementAccessExpression = definedExternally
external fun createElementAccess(expression: Expression, index: Expression): ElementAccessExpression = definedExternally
external fun updateElementAccess(node: ElementAccessExpression, expression: Expression, argumentExpression: Expression): ElementAccessExpression = definedExternally
external fun createCall(expression: Expression, typeArguments: Array<TypeNode>?, argumentsArray: Array<Expression>): CallExpression = definedExternally
external fun updateCall(node: CallExpression, expression: Expression, typeArguments: Array<TypeNode>?, argumentsArray: Array<Expression>): CallExpression = definedExternally
external fun createNew(expression: Expression, typeArguments: Array<TypeNode>?, argumentsArray: Array<Expression>?): NewExpression = definedExternally
external fun updateNew(node: NewExpression, expression: Expression, typeArguments: Array<TypeNode>?, argumentsArray: Array<Expression>?): NewExpression = definedExternally
external fun createTaggedTemplate(tag: Expression, template: TemplateLiteral): TaggedTemplateExpression = definedExternally
external fun updateTaggedTemplate(node: TaggedTemplateExpression, tag: Expression, template: TemplateLiteral): TaggedTemplateExpression = definedExternally
external fun createTypeAssertion(type: TypeNode, expression: Expression): TypeAssertion = definedExternally
external fun updateTypeAssertion(node: TypeAssertion, type: TypeNode, expression: Expression): TypeAssertion = definedExternally
external fun createParen(expression: Expression): ParenthesizedExpression = definedExternally
external fun updateParen(node: ParenthesizedExpression, expression: Expression): ParenthesizedExpression = definedExternally
external fun createFunctionExpression(modifiers: Array<Modifier>?, asteriskToken: AsteriskToken?, name: String, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block): FunctionExpression = definedExternally
external fun createFunctionExpression(modifiers: Array<Modifier>?, asteriskToken: AsteriskToken?, name: Identifier, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block): FunctionExpression = definedExternally
external fun createFunctionExpression(modifiers: Array<Modifier>?, asteriskToken: AsteriskToken?, name: Nothing?, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block): FunctionExpression = definedExternally
external fun updateFunctionExpression(node: FunctionExpression, modifiers: Array<Modifier>?, asteriskToken: AsteriskToken?, name: Identifier?, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block): FunctionExpression = definedExternally
external fun createArrowFunction(modifiers: Array<Modifier>?, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, equalsGreaterThanToken: EqualsGreaterThanToken?, body: ConciseBody): ArrowFunction = definedExternally
external fun updateArrowFunction(node: ArrowFunction, modifiers: Array<Modifier>?, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: ConciseBody): ArrowFunction = definedExternally
external fun createDelete(expression: Expression): DeleteExpression = definedExternally
external fun updateDelete(node: DeleteExpression, expression: Expression): DeleteExpression = definedExternally
external fun createTypeOf(expression: Expression): TypeOfExpression = definedExternally
external fun updateTypeOf(node: TypeOfExpression, expression: Expression): TypeOfExpression = definedExternally
external fun createVoid(expression: Expression): VoidExpression = definedExternally
external fun updateVoid(node: VoidExpression, expression: Expression): VoidExpression = definedExternally
external fun createAwait(expression: Expression): AwaitExpression = definedExternally
external fun updateAwait(node: AwaitExpression, expression: Expression): AwaitExpression = definedExternally
external fun createPrefix(operator: PrefixUnaryOperator, operand: Expression): PrefixUnaryExpression = definedExternally
external fun updatePrefix(node: PrefixUnaryExpression, operand: Expression): PrefixUnaryExpression = definedExternally
external fun createPostfix(operand: Expression, operator: PostfixUnaryOperator): PostfixUnaryExpression = definedExternally
external fun updatePostfix(node: PostfixUnaryExpression, operand: Expression): PostfixUnaryExpression = definedExternally
external fun createBinary(left: Expression, operator: BinaryOperator, right: Expression): BinaryExpression = definedExternally
external fun createBinary(left: Expression, operator: BinaryOperatorToken, right: Expression): BinaryExpression = definedExternally
external fun updateBinary(node: BinaryExpression, left: Expression, right: Expression): BinaryExpression = definedExternally
external fun createConditional(condition: Expression, whenTrue: Expression, whenFalse: Expression): ConditionalExpression = definedExternally
external fun createConditional(condition: Expression, questionToken: QuestionToken, whenTrue: Expression, colonToken: ColonToken, whenFalse: Expression): ConditionalExpression = definedExternally
external fun updateConditional(node: ConditionalExpression, condition: Expression, whenTrue: Expression, whenFalse: Expression): ConditionalExpression = definedExternally
external fun createTemplateExpression(head: TemplateHead, templateSpans: Array<TemplateSpan>): TemplateExpression = definedExternally
external fun updateTemplateExpression(node: TemplateExpression, head: TemplateHead, templateSpans: Array<TemplateSpan>): TemplateExpression = definedExternally
external fun createYield(expression: Expression? = definedExternally /* null */): YieldExpression = definedExternally
external fun createYield(asteriskToken: AsteriskToken, expression: Expression): YieldExpression = definedExternally
external fun updateYield(node: YieldExpression, asteriskToken: AsteriskToken?, expression: Expression): YieldExpression = definedExternally
external fun createSpread(expression: Expression): SpreadElement = definedExternally
external fun updateSpread(node: SpreadElement, expression: Expression): SpreadElement = definedExternally
external fun createClassExpression(modifiers: Array<Modifier>?, name: String, typeParameters: Array<TypeParameterDeclaration>?, heritageClauses: Array<HeritageClause>, members: Array<ClassElement>): ClassExpression = definedExternally
external fun createClassExpression(modifiers: Array<Modifier>?, name: Identifier, typeParameters: Array<TypeParameterDeclaration>?, heritageClauses: Array<HeritageClause>, members: Array<ClassElement>): ClassExpression = definedExternally
external fun createClassExpression(modifiers: Array<Modifier>?, name: Nothing?, typeParameters: Array<TypeParameterDeclaration>?, heritageClauses: Array<HeritageClause>, members: Array<ClassElement>): ClassExpression = definedExternally
external fun updateClassExpression(node: ClassExpression, modifiers: Array<Modifier>?, name: Identifier?, typeParameters: Array<TypeParameterDeclaration>?, heritageClauses: Array<HeritageClause>, members: Array<ClassElement>): ClassExpression = definedExternally
external fun createOmittedExpression(): OmittedExpression = definedExternally
external fun createExpressionWithTypeArguments(typeArguments: Array<TypeNode>, expression: Expression): ExpressionWithTypeArguments = definedExternally
external fun updateExpressionWithTypeArguments(node: ExpressionWithTypeArguments, typeArguments: Array<TypeNode>, expression: Expression): ExpressionWithTypeArguments = definedExternally
external fun createAsExpression(expression: Expression, type: TypeNode): AsExpression = definedExternally
external fun updateAsExpression(node: AsExpression, expression: Expression, type: TypeNode): AsExpression = definedExternally
external fun createNonNullExpression(expression: Expression): NonNullExpression = definedExternally
external fun updateNonNullExpression(node: NonNullExpression, expression: Expression): NonNullExpression = definedExternally
external fun createTemplateSpan(expression: Expression, literal: TemplateMiddle): TemplateSpan = definedExternally
external fun createTemplateSpan(expression: Expression, literal: TemplateTail): TemplateSpan = definedExternally
external fun updateTemplateSpan(node: TemplateSpan, expression: Expression, literal: TemplateMiddle): TemplateSpan = definedExternally
external fun updateTemplateSpan(node: TemplateSpan, expression: Expression, literal: TemplateTail): TemplateSpan = definedExternally
external fun createBlock(statements: Array<Statement>, multiLine: Boolean? = definedExternally /* null */): Block = definedExternally
external fun updateBlock(node: Block, statements: Array<Statement>): Block = definedExternally
external fun createVariableStatement(modifiers: Array<Modifier>?, declarationList: VariableDeclarationList): VariableStatement = definedExternally
external fun createVariableStatement(modifiers: Array<Modifier>?, declarationList: Array<VariableDeclaration>): VariableStatement = definedExternally
external fun updateVariableStatement(node: VariableStatement, modifiers: Array<Modifier>?, declarationList: VariableDeclarationList): VariableStatement = definedExternally
external fun createVariableDeclarationList(declarations: Array<VariableDeclaration>, flags: NodeFlags? = definedExternally /* null */): VariableDeclarationList = definedExternally
external fun updateVariableDeclarationList(node: VariableDeclarationList, declarations: Array<VariableDeclaration>): VariableDeclarationList = definedExternally
external fun createVariableDeclaration(name: String, type: TypeNode? = definedExternally /* null */, initializer: Expression? = definedExternally /* null */): VariableDeclaration = definedExternally
external fun createVariableDeclaration(name: BindingName, type: TypeNode? = definedExternally /* null */, initializer: Expression? = definedExternally /* null */): VariableDeclaration = definedExternally
external fun updateVariableDeclaration(node: VariableDeclaration, name: BindingName, type: TypeNode?, initializer: Expression?): VariableDeclaration = definedExternally
external fun createEmptyStatement(): EmptyStatement = definedExternally
external fun createStatement(expression: Expression): ExpressionStatement = definedExternally
external fun updateStatement(node: ExpressionStatement, expression: Expression): ExpressionStatement = definedExternally
external fun createIf(expression: Expression, thenStatement: Statement, elseStatement: Statement? = definedExternally /* null */): IfStatement = definedExternally
external fun updateIf(node: IfStatement, expression: Expression, thenStatement: Statement, elseStatement: Statement?): IfStatement = definedExternally
external fun createDo(statement: Statement, expression: Expression): DoStatement = definedExternally
external fun updateDo(node: DoStatement, statement: Statement, expression: Expression): DoStatement = definedExternally
external fun createWhile(expression: Expression, statement: Statement): WhileStatement = definedExternally
external fun updateWhile(node: WhileStatement, expression: Expression, statement: Statement): WhileStatement = definedExternally
external fun createFor(initializer: ForInitializer?, condition: Expression?, incrementor: Expression?, statement: Statement): ForStatement = definedExternally
external fun updateFor(node: ForStatement, initializer: ForInitializer?, condition: Expression?, incrementor: Expression?, statement: Statement): ForStatement = definedExternally
external fun createForIn(initializer: ForInitializer, expression: Expression, statement: Statement): ForInStatement = definedExternally
external fun updateForIn(node: ForInStatement, initializer: ForInitializer, expression: Expression, statement: Statement): ForInStatement = definedExternally
external fun createForOf(awaitModifier: AwaitKeywordToken, initializer: ForInitializer, expression: Expression, statement: Statement): ForOfStatement = definedExternally
external fun updateForOf(node: ForOfStatement, awaitModifier: AwaitKeywordToken, initializer: ForInitializer, expression: Expression, statement: Statement): ForOfStatement = definedExternally
external fun createContinue(label: String? = definedExternally /* null */): ContinueStatement = definedExternally
external fun createContinue(label: Identifier? = definedExternally /* null */): ContinueStatement = definedExternally
external fun updateContinue(node: ContinueStatement, label: Identifier?): ContinueStatement = definedExternally
external fun createBreak(label: String? = definedExternally /* null */): BreakStatement = definedExternally
external fun createBreak(label: Identifier? = definedExternally /* null */): BreakStatement = definedExternally
external fun updateBreak(node: BreakStatement, label: Identifier?): BreakStatement = definedExternally
external fun createReturn(expression: Expression? = definedExternally /* null */): ReturnStatement = definedExternally
external fun updateReturn(node: ReturnStatement, expression: Expression?): ReturnStatement = definedExternally
external fun createWith(expression: Expression, statement: Statement): WithStatement = definedExternally
external fun updateWith(node: WithStatement, expression: Expression, statement: Statement): WithStatement = definedExternally
external fun createSwitch(expression: Expression, caseBlock: CaseBlock): SwitchStatement = definedExternally
external fun updateSwitch(node: SwitchStatement, expression: Expression, caseBlock: CaseBlock): SwitchStatement = definedExternally
external fun createLabel(label: String, statement: Statement): LabeledStatement = definedExternally
external fun createLabel(label: Identifier, statement: Statement): LabeledStatement = definedExternally
external fun updateLabel(node: LabeledStatement, label: Identifier, statement: Statement): LabeledStatement = definedExternally
external fun createThrow(expression: Expression): ThrowStatement = definedExternally
external fun updateThrow(node: ThrowStatement, expression: Expression): ThrowStatement = definedExternally
external fun createTry(tryBlock: Block, catchClause: CatchClause?, finallyBlock: Block?): TryStatement = definedExternally
external fun updateTry(node: TryStatement, tryBlock: Block, catchClause: CatchClause?, finallyBlock: Block?): TryStatement = definedExternally
external fun createFunctionDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, asteriskToken: AsteriskToken?, name: String, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block?): FunctionDeclaration = definedExternally
external fun createFunctionDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, asteriskToken: AsteriskToken?, name: Identifier, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block?): FunctionDeclaration = definedExternally
external fun createFunctionDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, asteriskToken: AsteriskToken?, name: Nothing?, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block?): FunctionDeclaration = definedExternally
external fun updateFunctionDeclaration(node: FunctionDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, asteriskToken: AsteriskToken?, name: Identifier?, typeParameters: Array<TypeParameterDeclaration>?, parameters: Array<ParameterDeclaration>, type: TypeNode?, body: Block?): FunctionDeclaration = definedExternally
external fun createClassDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: String, typeParameters: Array<TypeParameterDeclaration>?, heritageClauses: Array<HeritageClause>, members: Array<ClassElement>): ClassDeclaration = definedExternally
external fun createClassDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: Identifier, typeParameters: Array<TypeParameterDeclaration>?, heritageClauses: Array<HeritageClause>, members: Array<ClassElement>): ClassDeclaration = definedExternally
external fun createClassDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: Nothing?, typeParameters: Array<TypeParameterDeclaration>?, heritageClauses: Array<HeritageClause>, members: Array<ClassElement>): ClassDeclaration = definedExternally
external fun updateClassDeclaration(node: ClassDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: Identifier?, typeParameters: Array<TypeParameterDeclaration>?, heritageClauses: Array<HeritageClause>, members: Array<ClassElement>): ClassDeclaration = definedExternally
external fun createEnumDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: String, members: Array<EnumMember>): EnumDeclaration = definedExternally
external fun createEnumDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: Identifier, members: Array<EnumMember>): EnumDeclaration = definedExternally
external fun updateEnumDeclaration(node: EnumDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: Identifier, members: Array<EnumMember>): EnumDeclaration = definedExternally
external fun createModuleDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: ModuleName, body: ModuleBody?, flags: NodeFlags? = definedExternally /* null */): ModuleDeclaration = definedExternally
external fun updateModuleDeclaration(node: ModuleDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: ModuleName, body: ModuleBody?): ModuleDeclaration = definedExternally
external fun createModuleBlock(statements: Array<Statement>): ModuleBlock = definedExternally
external fun updateModuleBlock(node: ModuleBlock, statements: Array<Statement>): ModuleBlock = definedExternally
external fun createCaseBlock(clauses: Array<CaseOrDefaultClause>): CaseBlock = definedExternally
external fun updateCaseBlock(node: CaseBlock, clauses: Array<CaseOrDefaultClause>): CaseBlock = definedExternally
external fun createImportEqualsDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: String, moduleReference: ModuleReference): ImportEqualsDeclaration = definedExternally
external fun createImportEqualsDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: Identifier, moduleReference: ModuleReference): ImportEqualsDeclaration = definedExternally
external fun updateImportEqualsDeclaration(node: ImportEqualsDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, name: Identifier, moduleReference: ModuleReference): ImportEqualsDeclaration = definedExternally
external fun createImportDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, importClause: ImportClause?, moduleSpecifier: Expression? = definedExternally /* null */): ImportDeclaration = definedExternally
external fun updateImportDeclaration(node: ImportDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, importClause: ImportClause?, moduleSpecifier: Expression?): ImportDeclaration = definedExternally
external fun createImportClause(name: Identifier, namedBindings: NamedImportBindings): ImportClause = definedExternally
external fun updateImportClause(node: ImportClause, name: Identifier, namedBindings: NamedImportBindings): ImportClause = definedExternally
external fun createNamespaceImport(name: Identifier): NamespaceImport = definedExternally
external fun updateNamespaceImport(node: NamespaceImport, name: Identifier): NamespaceImport = definedExternally
external fun createNamedImports(elements: Array<ImportSpecifier>): NamedImports = definedExternally
external fun updateNamedImports(node: NamedImports, elements: Array<ImportSpecifier>): NamedImports = definedExternally
external fun createImportSpecifier(propertyName: Identifier?, name: Identifier): ImportSpecifier = definedExternally
external fun updateImportSpecifier(node: ImportSpecifier, propertyName: Identifier?, name: Identifier): ImportSpecifier = definedExternally
external fun createExportAssignment(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, isExportEquals: Boolean, expression: Expression): ExportAssignment = definedExternally
external fun updateExportAssignment(node: ExportAssignment, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, expression: Expression): ExportAssignment = definedExternally
external fun createExportDeclaration(decorators: Array<Decorator>?, modifiers: Array<Modifier>?, exportClause: NamedExports?, moduleSpecifier: Expression? = definedExternally /* null */): ExportDeclaration = definedExternally
external fun updateExportDeclaration(node: ExportDeclaration, decorators: Array<Decorator>?, modifiers: Array<Modifier>?, exportClause: NamedExports?, moduleSpecifier: Expression?): ExportDeclaration = definedExternally
external fun createNamedExports(elements: Array<ExportSpecifier>): NamedExports = definedExternally
external fun updateNamedExports(node: NamedExports, elements: Array<ExportSpecifier>): NamedExports = definedExternally
external fun createExportSpecifier(propertyName: String, name: String): ExportSpecifier = definedExternally
external fun createExportSpecifier(propertyName: String, name: Identifier): ExportSpecifier = definedExternally
external fun createExportSpecifier(propertyName: Identifier, name: String): ExportSpecifier = definedExternally
external fun createExportSpecifier(propertyName: Identifier, name: Identifier): ExportSpecifier = definedExternally
external fun createExportSpecifier(propertyName: Nothing?, name: String): ExportSpecifier = definedExternally
external fun createExportSpecifier(propertyName: Nothing?, name: Identifier): ExportSpecifier = definedExternally
external fun updateExportSpecifier(node: ExportSpecifier, propertyName: Identifier?, name: Identifier): ExportSpecifier = definedExternally
external fun createExternalModuleReference(expression: Expression): ExternalModuleReference = definedExternally
external fun updateExternalModuleReference(node: ExternalModuleReference, expression: Expression): ExternalModuleReference = definedExternally
external fun createJsxElement(openingElement: JsxOpeningElement, children: Array<JsxChild>, closingElement: JsxClosingElement): JsxElement = definedExternally
external fun updateJsxElement(node: JsxElement, openingElement: JsxOpeningElement, children: Array<JsxChild>, closingElement: JsxClosingElement): JsxElement = definedExternally
external fun createJsxSelfClosingElement(tagName: JsxTagNameExpression, attributes: JsxAttributes): JsxSelfClosingElement = definedExternally
external fun updateJsxSelfClosingElement(node: JsxSelfClosingElement, tagName: JsxTagNameExpression, attributes: JsxAttributes): JsxSelfClosingElement = definedExternally
external fun createJsxOpeningElement(tagName: JsxTagNameExpression, attributes: JsxAttributes): JsxOpeningElement = definedExternally
external fun updateJsxOpeningElement(node: JsxOpeningElement, tagName: JsxTagNameExpression, attributes: JsxAttributes): JsxOpeningElement = definedExternally
external fun createJsxClosingElement(tagName: JsxTagNameExpression): JsxClosingElement = definedExternally
external fun updateJsxClosingElement(node: JsxClosingElement, tagName: JsxTagNameExpression): JsxClosingElement = definedExternally
external fun createJsxAttributes(properties: Array<JsxAttributeLike>): JsxAttributes = definedExternally
external fun updateJsxAttributes(jsxAttributes: JsxAttributes, properties: Array<JsxAttributeLike>): JsxAttributes = definedExternally
external fun createJsxAttribute(name: Identifier, initializer: StringLiteral): JsxAttribute = definedExternally
external fun createJsxAttribute(name: Identifier, initializer: JsxExpression): JsxAttribute = definedExternally
external fun updateJsxAttribute(node: JsxAttribute, name: Identifier, initializer: StringLiteral): JsxAttribute = definedExternally
external fun updateJsxAttribute(node: JsxAttribute, name: Identifier, initializer: JsxExpression): JsxAttribute = definedExternally
external fun createJsxSpreadAttribute(expression: Expression): JsxSpreadAttribute = definedExternally
external fun updateJsxSpreadAttribute(node: JsxSpreadAttribute, expression: Expression): JsxSpreadAttribute = definedExternally
external fun createJsxExpression(dotDotDotToken: DotDotDotToken?, expression: Expression?): JsxExpression = definedExternally
external fun updateJsxExpression(node: JsxExpression, expression: Expression?): JsxExpression = definedExternally
external fun createHeritageClause(token: dynamic /* "IndexedAccessType" kind unsupported yet here! (node_modules/typescript/lib/typescriptServices.d.ts:2942:41 to 2942:65) */, types: Array<ExpressionWithTypeArguments>): HeritageClause = definedExternally
external fun updateHeritageClause(node: HeritageClause, types: Array<ExpressionWithTypeArguments>): HeritageClause = definedExternally
external fun createCaseClause(expression: Expression, statements: Array<Statement>): CaseClause = definedExternally
external fun updateCaseClause(node: CaseClause, expression: Expression, statements: Array<Statement>): CaseClause = definedExternally
external fun createDefaultClause(statements: Array<Statement>): DefaultClause = definedExternally
external fun updateDefaultClause(node: DefaultClause, statements: Array<Statement>): DefaultClause = definedExternally
external fun createCatchClause(variableDeclaration: String, block: Block): CatchClause = definedExternally
external fun createCatchClause(variableDeclaration: VariableDeclaration, block: Block): CatchClause = definedExternally
external fun updateCatchClause(node: CatchClause, variableDeclaration: VariableDeclaration, block: Block): CatchClause = definedExternally
external fun createPropertyAssignment(name: String, initializer: Expression): PropertyAssignment = definedExternally
external fun createPropertyAssignment(name: PropertyName, initializer: Expression): PropertyAssignment = definedExternally
external fun updatePropertyAssignment(node: PropertyAssignment, name: PropertyName, initializer: Expression): PropertyAssignment = definedExternally
external fun createShorthandPropertyAssignment(name: String, objectAssignmentInitializer: Expression? = definedExternally /* null */): ShorthandPropertyAssignment = definedExternally
external fun createShorthandPropertyAssignment(name: Identifier, objectAssignmentInitializer: Expression? = definedExternally /* null */): ShorthandPropertyAssignment = definedExternally
external fun updateShorthandPropertyAssignment(node: ShorthandPropertyAssignment, name: Identifier, objectAssignmentInitializer: Expression?): ShorthandPropertyAssignment = definedExternally
external fun createSpreadAssignment(expression: Expression): SpreadAssignment = definedExternally
external fun updateSpreadAssignment(node: SpreadAssignment, expression: Expression): SpreadAssignment = definedExternally
external fun createEnumMember(name: String, initializer: Expression? = definedExternally /* null */): EnumMember = definedExternally
external fun createEnumMember(name: PropertyName, initializer: Expression? = definedExternally /* null */): EnumMember = definedExternally
external fun updateEnumMember(node: EnumMember, name: PropertyName, initializer: Expression?): EnumMember = definedExternally
external fun updateSourceFileNode(node: SourceFile, statements: Array<Statement>): SourceFile = definedExternally
external fun <T : Node> getMutableClone(node: T): T = definedExternally
external fun createNotEmittedStatement(original: Node): NotEmittedStatement = definedExternally
external fun createPartiallyEmittedExpression(expression: Expression, original: Node? = definedExternally /* null */): PartiallyEmittedExpression = definedExternally
external fun updatePartiallyEmittedExpression(node: PartiallyEmittedExpression, expression: Expression): PartiallyEmittedExpression = definedExternally
external fun createBundle(sourceFiles: Array<SourceFile>): Bundle = definedExternally
external fun updateBundle(node: Bundle, sourceFiles: Array<SourceFile>): Bundle = definedExternally
external fun createComma(left: Expression, right: Expression): Expression = definedExternally
external fun createLessThan(left: Expression, right: Expression): Expression = definedExternally
external fun createAssignment(left: ObjectLiteralExpression, right: Expression): DestructuringAssignment = definedExternally
external fun createAssignment(left: ArrayLiteralExpression, right: Expression): DestructuringAssignment = definedExternally
external fun createAssignment(left: Expression, right: Expression): BinaryExpression = definedExternally
external fun createStrictEquality(left: Expression, right: Expression): BinaryExpression = definedExternally
external fun createStrictInequality(left: Expression, right: Expression): BinaryExpression = definedExternally
external fun createAdd(left: Expression, right: Expression): BinaryExpression = definedExternally
external fun createSubtract(left: Expression, right: Expression): BinaryExpression = definedExternally
external fun createPostfixIncrement(operand: Expression): PostfixUnaryExpression = definedExternally
external fun createLogicalAnd(left: Expression, right: Expression): BinaryExpression = definedExternally
external fun createLogicalOr(left: Expression, right: Expression): BinaryExpression = definedExternally
external fun createLogicalNot(operand: Expression): PrefixUnaryExpression = definedExternally
external fun createVoidZero(): VoidExpression = definedExternally
external fun createExportDefault(expression: Expression): ExportAssignment = definedExternally
external fun createExternalModuleExport(exportName: Identifier): ExportDeclaration = definedExternally
external fun disposeEmitNodes(sourceFile: SourceFile): Unit = definedExternally
external fun <T : TextRange> setTextRange(range: T, location: TextRange?): T = definedExternally
external fun getEmitFlags(node: Node): EmitFlags? = definedExternally
external fun <T : Node> setEmitFlags(node: T, emitFlags: EmitFlags): T = definedExternally
external fun getSourceMapRange(node: Node): TextRange = definedExternally
external fun <T : Node> setSourceMapRange(node: T, range: TextRange?): T = definedExternally
external fun getTokenSourceMapRange(node: Node, token: SyntaxKind): TextRange? = definedExternally
external fun <T : Node> setTokenSourceMapRange(node: T, token: SyntaxKind, range: TextRange?): T = definedExternally
external fun getCommentRange(node: Node): TextRange = definedExternally
external fun <T : Node> setCommentRange(node: T, range: TextRange): T = definedExternally
external fun getSyntheticLeadingComments(node: Node): Array<SynthesizedComment>? = definedExternally
external fun <T : Node> setSyntheticLeadingComments(node: T, comments: Array<SynthesizedComment>): T = definedExternally
external fun <T : Node> addSyntheticLeadingComment(node: T, kind: SyntaxKind.SingleLineCommentTrivia, text: String, hasTrailingNewLine: Boolean? = definedExternally /* null */): T = definedExternally
external fun <T : Node> addSyntheticLeadingComment(node: T, kind: SyntaxKind.MultiLineCommentTrivia, text: String, hasTrailingNewLine: Boolean? = definedExternally /* null */): T = definedExternally
external fun getSyntheticTrailingComments(node: Node): Array<SynthesizedComment>? = definedExternally
external fun <T : Node> setSyntheticTrailingComments(node: T, comments: Array<SynthesizedComment>): T = definedExternally
external fun <T : Node> addSyntheticTrailingComment(node: T, kind: SyntaxKind.SingleLineCommentTrivia, text: String, hasTrailingNewLine: Boolean? = definedExternally /* null */): T = definedExternally
external fun <T : Node> addSyntheticTrailingComment(node: T, kind: SyntaxKind.MultiLineCommentTrivia, text: String, hasTrailingNewLine: Boolean? = definedExternally /* null */): T = definedExternally
external fun getConstantValue(node: PropertyAccessExpression): Number = definedExternally
external fun getConstantValue(node: ElementAccessExpression): Number = definedExternally
external fun setConstantValue(node: PropertyAccessExpression, value: Number): dynamic /* PropertyAccessExpression | ElementAccessExpression */ = definedExternally
external fun setConstantValue(node: ElementAccessExpression, value: Number): dynamic /* PropertyAccessExpression | ElementAccessExpression */ = definedExternally
external fun <T : Node> addEmitHelper(node: T, helper: EmitHelper): T = definedExternally
external fun <T : Node> addEmitHelpers(node: T, helpers: Array<EmitHelper>?): T = definedExternally
external fun removeEmitHelper(node: Node, helper: EmitHelper): Boolean = definedExternally
external fun getEmitHelpers(node: Node): Array<EmitHelper>? = definedExternally
external fun moveEmitHelpers(source: Node, target: Node, predicate: (helper: EmitHelper) -> Boolean): Unit = definedExternally
external fun <T : Node> setOriginalNode(node: T, original: Node?): T = definedExternally
external fun createNode(kind: SyntaxKind, pos: Number? = definedExternally /* null */, end: Number? = definedExternally /* null */): Node = definedExternally
external fun <T> forEachChild(node: Node, cbNode: (node: Node) -> T, cbNodeArray: ((nodes: Array<Node>) -> T)? = definedExternally /* null */): T = definedExternally
external fun createSourceFile(fileName: String, sourceText: String, languageVersion: ScriptTarget, setParentNodes: Boolean? = definedExternally /* null */, scriptKind: ScriptKind? = definedExternally /* null */): SourceFile = definedExternally
external fun parseIsolatedEntityName(text: String, languageVersion: ScriptTarget): EntityName = definedExternally
external fun isExternalModule(file: SourceFile): Boolean = definedExternally
external fun updateSourceFile(sourceFile: SourceFile, newText: String, textChangeRange: TextChangeRange, aggressiveChecks: Boolean? = definedExternally /* null */): SourceFile = definedExternally
external interface Push<T> {
    fun push(value: T)
}
external fun moduleHasNonRelativeName(moduleName: String): Boolean = definedExternally
external interface `T$4` {
    var directoryExists: ((directoryName: String) -> Boolean)? get() = definedExternally; set(value) = definedExternally
    var getCurrentDirectory: (() -> String)? get() = definedExternally; set(value) = definedExternally
}
external fun getEffectiveTypeRoots(options: CompilerOptions, host: `T$4`): Array<String>? = definedExternally
external fun resolveTypeReferenceDirective(typeReferenceDirectiveName: String, containingFile: String?, options: CompilerOptions, host: ModuleResolutionHost): ResolvedTypeReferenceDirectiveWithFailedLookupLocations = definedExternally
external fun getAutomaticTypeDirectiveNames(options: CompilerOptions, host: ModuleResolutionHost): Array<String> = definedExternally
external interface ModuleResolutionCache : NonRelativeModuleNameResolutionCache {
    fun getOrCreateCacheForDirectory(directoryName: String): Map<ResolvedModuleWithFailedLookupLocations>
}
external interface NonRelativeModuleNameResolutionCache {
    fun getOrCreateCacheForModuleName(nonRelativeModuleName: String): PerModuleNameCache
}
external interface PerModuleNameCache {
    fun get(directory: String): ResolvedModuleWithFailedLookupLocations
    fun set(directory: String, result: ResolvedModuleWithFailedLookupLocations)
}
external fun createModuleResolutionCache(currentDirectory: String, getCanonicalFileName: (s: String) -> String): ModuleResolutionCache = definedExternally
external fun resolveModuleName(moduleName: String, containingFile: String, compilerOptions: CompilerOptions, host: ModuleResolutionHost, cache: ModuleResolutionCache? = definedExternally /* null */): ResolvedModuleWithFailedLookupLocations = definedExternally
external fun nodeModuleNameResolver(moduleName: String, containingFile: String, compilerOptions: CompilerOptions, host: ModuleResolutionHost, cache: ModuleResolutionCache? = definedExternally /* null */): ResolvedModuleWithFailedLookupLocations = definedExternally
external fun classicNameResolver(moduleName: String, containingFile: String, compilerOptions: CompilerOptions, host: ModuleResolutionHost, cache: NonRelativeModuleNameResolutionCache? = definedExternally /* null */): ResolvedModuleWithFailedLookupLocations = definedExternally
external fun <T : Node> visitNode(node: T, visitor: Visitor, test: ((node: Node) -> Boolean)? = definedExternally /* null */, lift: ((node: NodeArray<Node>) -> T)? = definedExternally /* null */): T = definedExternally
external fun <T : Node> visitNode(node: T?, visitor: Visitor, test: ((node: Node) -> Boolean)? = definedExternally /* null */, lift: ((node: NodeArray<Node>) -> T)? = definedExternally /* null */): T? = definedExternally
external fun <T : Node> visitNodes(nodes: NodeArray<T>, visitor: Visitor, test: ((node: Node) -> Boolean)? = definedExternally /* null */, start: Number? = definedExternally /* null */, count: Number? = definedExternally /* null */): NodeArray<T> = definedExternally
external fun <T : Node> visitNodes(nodes: NodeArray<T>?, visitor: Visitor, test: ((node: Node) -> Boolean)? = definedExternally /* null */, start: Number? = definedExternally /* null */, count: Number? = definedExternally /* null */): NodeArray<T>? = definedExternally
external fun visitLexicalEnvironment(statements: NodeArray<Statement>, visitor: Visitor, context: TransformationContext, start: Number? = definedExternally /* null */, ensureUseStrict: Boolean? = definedExternally /* null */): NodeArray<Statement> = definedExternally
external fun visitParameterList(nodes: NodeArray<ParameterDeclaration>, visitor: Visitor, context: TransformationContext, nodesVisitor: dynamic /* "TypeQuery" kind unsupported yet here! (node_modules/typescript/lib/typescriptServices.d.ts:3175:137 to 3175:155) */ = definedExternally /* null */): NodeArray<ParameterDeclaration> = definedExternally
external fun visitFunctionBody(node: FunctionBody, visitor: Visitor, context: TransformationContext): FunctionBody = definedExternally
external fun visitFunctionBody(node: FunctionBody?, visitor: Visitor, context: TransformationContext): FunctionBody? = definedExternally
external fun visitFunctionBody(node: ConciseBody, visitor: Visitor, context: TransformationContext): ConciseBody = definedExternally
external fun <T : Node> visitEachChild(node: T, visitor: Visitor, context: TransformationContext): T = definedExternally
external fun <T : Node> visitEachChild(node: T?, visitor: Visitor, context: TransformationContext, nodesVisitor: dynamic /* "TypeQuery" kind unsupported yet here! (node_modules/typescript/lib/typescriptServices.d.ts:3206:130 to 3206:148) */ = definedExternally /* null */, tokenVisitor: Visitor? = definedExternally /* null */): T? = definedExternally
external fun createPrinter(printerOptions: PrinterOptions? = definedExternally /* null */, handlers: PrintHandlers? = definedExternally /* null */): Printer = definedExternally
external fun findConfigFile(searchPath: String, fileExists: (fileName: String) -> Boolean, configName: String? = definedExternally /* null */): String = definedExternally
external fun resolveTripleslashReference(moduleName: String, containingFile: String): String = definedExternally
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
external fun createProgram(rootNames: Array<String>, options: CompilerOptions, host: CompilerHost? = definedExternally /* null */, oldProgram: Program? = definedExternally /* null */): Program = definedExternally
external fun parseCommandLine(commandLine: Array<String>, readFile: ((path: String) -> String)? = definedExternally /* null */): ParsedCommandLine = definedExternally
external interface `T$5` {
    var config: Any? get() = definedExternally; set(value) = definedExternally
    var error: Diagnostic? get() = definedExternally; set(value) = definedExternally
}
external fun readConfigFile(fileName: String, readFile: (path: String) -> String): `T$5` = definedExternally
external interface `T$6` {
    var config: Any? get() = definedExternally; set(value) = definedExternally
    var error: Diagnostic? get() = definedExternally; set(value) = definedExternally
}
external fun parseConfigFileTextToJson(fileName: String, jsonText: String, stripComments: Boolean? = definedExternally /* null */): `T$6` = definedExternally
external fun parseJsonConfigFileContent(json: Any, host: ParseConfigHost, basePath: String, existingOptions: CompilerOptions? = definedExternally /* null */, configFileName: String? = definedExternally /* null */, resolutionStack: Array<Path>? = definedExternally /* null */, extraFileExtensions: Array<JsFileExtensionInfo>? = definedExternally /* null */): ParsedCommandLine = definedExternally
external fun convertCompileOnSaveOptionFromJson(jsonOption: Any, basePath: String, errors: Array<Diagnostic>): Boolean? = definedExternally
external interface `T$7` {
    var options: CompilerOptions
    var errors: Array<Diagnostic>
}
external fun convertCompilerOptionsFromJson(jsonOptions: Any, basePath: String, configFileName: String? = definedExternally /* null */): `T$7` = definedExternally
external interface `T$8` {
    var options: TypeAcquisition
    var errors: Array<Diagnostic>
}
external fun convertTypeAcquisitionFromJson(jsonOptions: Any, basePath: String, configFileName: String? = definedExternally /* null */): `T$8` = definedExternally
external interface SourceFileLike {
    fun getLineAndCharacterOfPosition(pos: Number): LineAndCharacter
}
external interface IScriptSnapshot {
    fun getText(start: Number, end: Number): String
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
    val getCustomTransformers: (() -> CustomTransformers?)? get() = definedExternally
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
    fun getCompletionEntrySymbol(fileName: String, position: Number, entryName: String): Symbol
    fun getQuickInfoAtPosition(fileName: String, position: Number): QuickInfo
    fun getNameOrDottedNameSpan(fileName: String, startPos: Number, endPos: Number): TextSpan
    fun getBreakpointStatementAtPosition(fileName: String, position: Number): TextSpan
    fun getSignatureHelpItems(fileName: String, position: Number): SignatureHelpItems
    fun getRenameInfo(fileName: String, position: Number): RenameInfo
    fun findRenameLocations(fileName: String, position: Number, findInStrings: Boolean, findInComments: Boolean): Array<RenameLocation>
    fun getDefinitionAtPosition(fileName: String, position: Number): Array<DefinitionInfo>
    fun getTypeDefinitionAtPosition(fileName: String, position: Number): Array<DefinitionInfo>
    fun getImplementationAtPosition(fileName: String, position: Number): Array<ImplementationLocation>
    fun getReferencesAtPosition(fileName: String, position: Number): Array<ReferenceEntry>
    fun findReferences(fileName: String, position: Number): Array<ReferencedSymbol>
    fun getDocumentHighlights(fileName: String, position: Number, filesToSearch: Array<String>): Array<DocumentHighlights>
    fun getOccurrencesAtPosition(fileName: String, position: Number): Array<ReferenceEntry>
    fun getNavigateToItems(searchValue: String, maxResultCount: Number? = definedExternally /* null */, fileName: String? = definedExternally /* null */, excludeDtsFiles: Boolean? = definedExternally /* null */): Array<NavigateToItem>
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
    fun getCodeFixesAtPosition(fileName: String, start: Number, end: Number, errorCodes: Array<Number>, formatOptions: FormatCodeSettings): Array<CodeAction>
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
external interface FileTextChanges {
    var fileName: String
    var textChanges: Array<TextChange>
}
external interface CodeAction {
    var description: String
    var changes: Array<FileTextChanges>
}
external interface TextInsertion {
    var newText: String
    var caretOffset: Number
}
external interface DocumentSpan {
    var textSpan: TextSpan
    var fileName: String
}
external interface RenameLocation : DocumentSpan
external interface ReferenceEntry : DocumentSpan {
    var isWriteAccess: Boolean
    var isDefinition: Boolean
    var isInString: Any? /* "null" */ get() = definedExternally; set(value) = definedExternally
}
external interface ImplementationLocation : DocumentSpan {
    var kind: String
    var displayParts: Array<SymbolDisplayPart>
}
external interface DocumentHighlights {
    var fileName: String
    var highlightSpans: Array<HighlightSpan>
}
external interface HighlightSpan {
    var fileName: String? get() = definedExternally; set(value) = definedExternally
    var isInString: Any? /* "null" */ get() = definedExternally; set(value) = definedExternally
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
external enum class IndentStyle {
    None /* = 0 */,
    Block /* = 1 */,
    Smart /* = 2 */
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
external interface FormatCodeOptions : EditorOptions {
    var InsertSpaceAfterCommaDelimiter: Boolean
    var InsertSpaceAfterSemicolonInForStatements: Boolean
    var InsertSpaceBeforeAndAfterBinaryOperators: Boolean
    var InsertSpaceAfterConstructor: Boolean? get() = definedExternally; set(value) = definedExternally
    var InsertSpaceAfterKeywordsInControlFlowStatements: Boolean
    var InsertSpaceAfterFunctionKeywordForAnonymousFunctions: Boolean
    var InsertSpaceAfterOpeningAndBeforeClosingNonemptyParenthesis: Boolean
    var InsertSpaceAfterOpeningAndBeforeClosingNonemptyBrackets: Boolean
    var InsertSpaceAfterOpeningAndBeforeClosingNonemptyBraces: Boolean? get() = definedExternally; set(value) = definedExternally
    var InsertSpaceAfterOpeningAndBeforeClosingTemplateStringBraces: Boolean
    var InsertSpaceAfterOpeningAndBeforeClosingJsxExpressionBraces: Boolean? get() = definedExternally; set(value) = definedExternally
    var InsertSpaceAfterTypeAssertion: Boolean? get() = definedExternally; set(value) = definedExternally
    var InsertSpaceBeforeFunctionParenthesis: Boolean? get() = definedExternally; set(value) = definedExternally
    var PlaceOpenBraceOnNewLineForFunctions: Boolean
    var PlaceOpenBraceOnNewLineForControlBlocks: Boolean
}
external interface FormatCodeSettings : EditorSettings {
    var insertSpaceAfterCommaDelimiter: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterSemicolonInForStatements: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceBeforeAndAfterBinaryOperators: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterConstructor: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterKeywordsInControlFlowStatements: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterFunctionKeywordForAnonymousFunctions: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterOpeningAndBeforeClosingNonemptyParenthesis: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterOpeningAndBeforeClosingNonemptyBrackets: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterOpeningAndBeforeClosingNonemptyBraces: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterOpeningAndBeforeClosingTemplateStringBraces: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterOpeningAndBeforeClosingJsxExpressionBraces: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceAfterTypeAssertion: Boolean? get() = definedExternally; set(value) = definedExternally
    var insertSpaceBeforeFunctionParenthesis: Boolean? get() = definedExternally; set(value) = definedExternally
    var placeOpenBraceOnNewLineForFunctions: Boolean? get() = definedExternally; set(value) = definedExternally
    var placeOpenBraceOnNewLineForControlBlocks: Boolean? get() = definedExternally; set(value) = definedExternally
}
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
external interface JSDocTagInfo {
    var name: String
    var text: String? get() = definedExternally; set(value) = definedExternally
}
external interface QuickInfo {
    var kind: String
    var kindModifiers: String
    var textSpan: TextSpan
    var displayParts: Array<SymbolDisplayPart>
    var documentation: Array<SymbolDisplayPart>
    var tags: Array<JSDocTagInfo>
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
    var tags: Array<JSDocTagInfo>
}
external interface SignatureHelpItems {
    var items: Array<SignatureHelpItem>
    var applicableSpan: TextSpan
    var selectedItemIndex: Number
    var argumentIndex: Number
    var argumentCount: Number
}
external interface CompletionInfo {
    var isGlobalCompletion: Boolean
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
    var tags: Array<JSDocTagInfo>
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
external fun createClassifier(): Classifier = definedExternally
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
external interface `T$9` {
    var __bucketKey: Any
}
external fun createDocumentRegistry(useCaseSensitiveFileNames: Boolean? = definedExternally /* null */, currentDirectory: String? = definedExternally /* null */): DocumentRegistry = definedExternally
external fun preProcessFile(sourceText: String, readImportFiles: Boolean? = definedExternally /* null */, detectJavaScriptImports: Boolean? = definedExternally /* null */): PreProcessedFileInfo = definedExternally
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
external var servicesVersion: Any = definedExternally
external interface DisplayPartsSymbolWriter : SymbolWriter {
    fun displayParts(): Array<SymbolDisplayPart>
}
external fun toEditorSettings(options: EditorOptions): EditorSettings = definedExternally
external fun toEditorSettings(options: EditorSettings): EditorSettings = definedExternally
external fun displayPartsToString(displayParts: Array<SymbolDisplayPart>): String = definedExternally
external fun getDefaultCompilerOptions(): CompilerOptions = definedExternally
external fun getSupportedCodeFixes(): Array<String> = definedExternally
external fun createLanguageServiceSourceFile(fileName: String, scriptSnapshot: IScriptSnapshot, scriptTarget: ScriptTarget, version: String, setNodeParents: Boolean, scriptKind: ScriptKind? = definedExternally /* null */): SourceFile = definedExternally
external var disableIncrementalParsing: Boolean = definedExternally
external fun updateLanguageServiceSourceFile(sourceFile: SourceFile, scriptSnapshot: IScriptSnapshot, version: String, textChangeRange: TextChangeRange, aggressiveChecks: Boolean? = definedExternally /* null */): SourceFile = definedExternally
external fun createLanguageService(host: LanguageServiceHost, documentRegistry: DocumentRegistry? = definedExternally /* null */): LanguageService = definedExternally
external fun getDefaultLibFilePath(options: CompilerOptions): String = definedExternally
external fun <T : Node> transform(source: T, transformers: Array<TransformerFactory<T>>, compilerOptions: CompilerOptions? = definedExternally /* null */): TransformationResult<T> = definedExternally
external fun <T : Node> transform(source: Array<T>, transformers: Array<TransformerFactory<T>>, compilerOptions: CompilerOptions? = definedExternally /* null */): TransformationResult<T> = definedExternally
