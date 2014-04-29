/*
 * Copyright 2013-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package typescript

[suppress("UNUSED_PARAMETER")]
native
open class SyntaxWalker : ISyntaxVisitor<Unit> {
    override fun visitToken(token: ISyntaxToken): Unit = noImpl
    override fun visitSourceUnit(node: SourceUnitSyntax): Unit = noImpl
    override fun visitExternalModuleReference(node: ExternalModuleReferenceSyntax): Unit = noImpl
    override fun visitModuleNameModuleReference(node: ModuleNameModuleReferenceSyntax): Unit = noImpl
    override fun visitImportDeclaration(node: ImportDeclarationSyntax): Unit = noImpl
    override fun visitExportAssignment(node: ExportAssignmentSyntax): Unit = noImpl
    override fun visitClassDeclaration(node: ClassDeclarationSyntax): Unit = noImpl
    override fun visitInterfaceDeclaration(node: InterfaceDeclarationSyntax): Unit = noImpl
    override fun visitHeritageClause(node: HeritageClauseSyntax): Unit = noImpl
    override fun visitModuleDeclaration(node: ModuleDeclarationSyntax): Unit = noImpl
    override fun visitFunctionDeclaration(node: FunctionDeclarationSyntax): Unit = noImpl
    override fun visitVariableStatement(node: VariableStatementSyntax): Unit = noImpl
    override fun visitVariableDeclaration(node: VariableDeclarationSyntax): Unit = noImpl
    override fun visitVariableDeclarator(node: VariableDeclaratorSyntax): Unit = noImpl
    override fun visitEqualsValueClause(node: EqualsValueClauseSyntax): Unit = noImpl
    override fun visitPrefixUnaryExpression(node: PrefixUnaryExpressionSyntax): Unit = noImpl
    override fun visitArrayLiteralExpression(node: ArrayLiteralExpressionSyntax): Unit = noImpl
    override fun visitOmittedExpression(node: OmittedExpressionSyntax): Unit = noImpl
    override fun visitParenthesizedExpression(node: ParenthesizedExpressionSyntax): Unit = noImpl
    override fun visitSimpleArrowFunctionExpression(node: SimpleArrowFunctionExpressionSyntax): Unit = noImpl
    override fun visitParenthesizedArrowFunctionExpression(node: ParenthesizedArrowFunctionExpressionSyntax): Unit = noImpl
    override fun visitQualifiedName(node: QualifiedNameSyntax): Unit = noImpl
    override fun visitTypeArgumentList(node: TypeArgumentListSyntax): Unit = noImpl
    override fun visitConstructorType(node: ConstructorTypeSyntax): Unit = noImpl
    override fun visitFunctionType(node: FunctionTypeSyntax): Unit = noImpl
    override fun visitObjectType(node: ObjectTypeSyntax): Unit = noImpl
    override fun visitArrayType(node: ArrayTypeSyntax): Unit = noImpl
    override fun visitGenericType(node: GenericTypeSyntax): Unit = noImpl
    override fun visitTypeQuery(node: TypeQuerySyntax): Unit = noImpl
    override fun visitTypeAnnotation(node: TypeAnnotationSyntax?): Unit = noImpl
    override fun visitBlock(node: BlockSyntax): Unit = noImpl
    override fun visitParameter(node: ParameterSyntax): Unit = noImpl
    override fun visitMemberAccessExpression(node: MemberAccessExpressionSyntax): Unit = noImpl
    override fun visitPostfixUnaryExpression(node: PostfixUnaryExpressionSyntax): Unit = noImpl
    override fun visitElementAccessExpression(node: ElementAccessExpressionSyntax): Unit = noImpl
    override fun visitInvocationExpression(node: InvocationExpressionSyntax): Unit = noImpl
    override fun visitArgumentList(node: ArgumentListSyntax): Unit = noImpl
    override fun visitBinaryExpression(node: BinaryExpressionSyntax): Unit = noImpl
    override fun visitConditionalExpression(node: ConditionalExpressionSyntax): Unit = noImpl
    override fun visitConstructSignature(node: ConstructSignatureSyntax): Unit = noImpl
    override fun visitMethodSignature(node: MethodSignatureSyntax): Unit = noImpl
    override fun visitIndexSignature(node: IndexSignatureSyntax): Unit = noImpl
    override fun visitPropertySignature(node: PropertySignatureSyntax): Unit = noImpl
    override fun visitCallSignature(node: CallSignatureSyntax): Unit = noImpl
    override fun visitParameterList(node: ParameterListSyntax): Unit = noImpl
    override fun visitTypeParameterList(node: TypeParameterListSyntax): Unit = noImpl
    override fun visitTypeParameter(node: TypeParameterSyntax): Unit = noImpl
    override fun visitConstraint(node: ConstraintSyntax): Unit = noImpl
    override fun visitElseClause(node: ElseClauseSyntax): Unit = noImpl
    override fun visitIfStatement(node: IfStatementSyntax): Unit = noImpl
    override fun visitExpressionStatement(node: ExpressionStatementSyntax): Unit = noImpl
    override fun visitConstructorDeclaration(node: ConstructorDeclarationSyntax): Unit = noImpl
    override fun visitMemberFunctionDeclaration(node: MemberFunctionDeclarationSyntax): Unit = noImpl
    override fun visitGetMemberAccessorDeclaration(node: GetMemberAccessorDeclarationSyntax): Unit = noImpl
    override fun visitSetMemberAccessorDeclaration(node: SetMemberAccessorDeclarationSyntax): Unit = noImpl
    override fun visitMemberVariableDeclaration(node: MemberVariableDeclarationSyntax): Unit = noImpl
    override fun visitThrowStatement(node: ThrowStatementSyntax): Unit = noImpl
    override fun visitReturnStatement(node: ReturnStatementSyntax): Unit = noImpl
    override fun visitObjectCreationExpression(node: ObjectCreationExpressionSyntax): Unit = noImpl
    override fun visitSwitchStatement(node: SwitchStatementSyntax): Unit = noImpl
    override fun visitCaseSwitchClause(node: CaseSwitchClauseSyntax): Unit = noImpl
    override fun visitDefaultSwitchClause(node: DefaultSwitchClauseSyntax): Unit = noImpl
    override fun visitBreakStatement(node: BreakStatementSyntax): Unit = noImpl
    override fun visitContinueStatement(node: ContinueStatementSyntax): Unit = noImpl
    override fun visitForStatement(node: ForStatementSyntax): Unit = noImpl
    override fun visitForInStatement(node: ForInStatementSyntax): Unit = noImpl
    override fun visitWhileStatement(node: WhileStatementSyntax): Unit = noImpl
    override fun visitWithStatement(node: WithStatementSyntax): Unit = noImpl
    override fun visitEnumDeclaration(node: EnumDeclarationSyntax): Unit = noImpl
    override fun visitEnumElement(node: EnumElementSyntax): Unit = noImpl
    override fun visitCastExpression(node: CastExpressionSyntax): Unit = noImpl
    override fun visitObjectLiteralExpression(node: ObjectLiteralExpressionSyntax): Unit = noImpl
    override fun visitSimplePropertyAssignment(node: SimplePropertyAssignmentSyntax): Unit = noImpl
    override fun visitFunctionPropertyAssignment(node: FunctionPropertyAssignmentSyntax): Unit = noImpl
    override fun visitGetAccessorPropertyAssignment(node: GetAccessorPropertyAssignmentSyntax): Unit = noImpl
    override fun visitSetAccessorPropertyAssignment(node: SetAccessorPropertyAssignmentSyntax): Unit = noImpl
    override fun visitFunctionExpression(node: FunctionExpressionSyntax): Unit = noImpl
    override fun visitEmptyStatement(node: EmptyStatementSyntax): Unit = noImpl
    override fun visitTryStatement(node: TryStatementSyntax): Unit = noImpl
    override fun visitCatchClause(node: CatchClauseSyntax): Unit = noImpl
    override fun visitFinallyClause(node: FinallyClauseSyntax): Unit = noImpl
    override fun visitLabeledStatement(node: LabeledStatementSyntax): Unit = noImpl
    override fun visitDoStatement(node: DoStatementSyntax): Unit = noImpl
    override fun visitTypeOfExpression(node: TypeOfExpressionSyntax): Unit = noImpl
    override fun visitDeleteExpression(node: DeleteExpressionSyntax): Unit = noImpl
    override fun visitVoidExpression(node: VoidExpressionSyntax): Unit = noImpl
    override fun visitDebuggerStatement(node: DebuggerStatementSyntax): Unit = noImpl

    public open fun visitNode(node: SyntaxNode): Unit = noImpl
    public open fun visitNodeOrToken(nodeOrToken: ISyntaxNodeOrToken): Unit = noImpl
    public open fun visitList(list: ISyntaxList): Unit = noImpl
    public open fun visitSeparatedList(list: ISeparatedSyntaxList): Unit = noImpl
    public open fun visitOptionalNode(node: SyntaxNode?): Unit = noImpl
    public open fun visitOptionalToken(token: ISyntaxToken?): Unit = noImpl
    public open fun visitOptionalNodeOrToken(nodeOrToken: ISyntaxNodeOrToken?): Unit = noImpl
}
