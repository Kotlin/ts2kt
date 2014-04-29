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

native
trait ISyntaxVisitor<out T> {
    fun visitToken(token: ISyntaxToken): T
    fun visitSourceUnit(node: SourceUnitSyntax): T
    fun visitExternalModuleReference(node: ExternalModuleReferenceSyntax): T
    fun visitModuleNameModuleReference(node: ModuleNameModuleReferenceSyntax): T
    fun visitImportDeclaration(node: ImportDeclarationSyntax): T
    fun visitExportAssignment(node: ExportAssignmentSyntax): T
    fun visitClassDeclaration(node: ClassDeclarationSyntax): T
    fun visitInterfaceDeclaration(node: InterfaceDeclarationSyntax): T
    fun visitHeritageClause(node: HeritageClauseSyntax): T
    fun visitModuleDeclaration(node: ModuleDeclarationSyntax): T
    fun visitFunctionDeclaration(node: FunctionDeclarationSyntax): T
    fun visitVariableStatement(node: VariableStatementSyntax): T
    fun visitVariableDeclaration(node: VariableDeclarationSyntax): T
    fun visitVariableDeclarator(node: VariableDeclaratorSyntax): T
    fun visitEqualsValueClause(node: EqualsValueClauseSyntax): T
    fun visitPrefixUnaryExpression(node: PrefixUnaryExpressionSyntax): T
    fun visitArrayLiteralExpression(node: ArrayLiteralExpressionSyntax): T
    fun visitOmittedExpression(node: OmittedExpressionSyntax): T
    fun visitParenthesizedExpression(node: ParenthesizedExpressionSyntax): T
    fun visitSimpleArrowFunctionExpression(node: SimpleArrowFunctionExpressionSyntax): T
    fun visitParenthesizedArrowFunctionExpression(node: ParenthesizedArrowFunctionExpressionSyntax): T
    fun visitQualifiedName(node: QualifiedNameSyntax): T
    fun visitTypeArgumentList(node: TypeArgumentListSyntax): T
    fun visitConstructorType(node: ConstructorTypeSyntax): T
    fun visitFunctionType(node: FunctionTypeSyntax): T
    fun visitObjectType(node: ObjectTypeSyntax): T
    fun visitArrayType(node: ArrayTypeSyntax): T
    fun visitGenericType(node: GenericTypeSyntax): T
    fun visitTypeQuery(node: TypeQuerySyntax): T
    fun visitTypeAnnotation(node: TypeAnnotationSyntax?): T
    fun visitBlock(node: BlockSyntax): T
    fun visitParameter(node: ParameterSyntax): T
    fun visitMemberAccessExpression(node: MemberAccessExpressionSyntax): T
    fun visitPostfixUnaryExpression(node: PostfixUnaryExpressionSyntax): T
    fun visitElementAccessExpression(node: ElementAccessExpressionSyntax): T
    fun visitInvocationExpression(node: InvocationExpressionSyntax): T
    fun visitArgumentList(node: ArgumentListSyntax): T
    fun visitBinaryExpression(node: BinaryExpressionSyntax): T
    fun visitConditionalExpression(node: ConditionalExpressionSyntax): T
    fun visitConstructSignature(node: ConstructSignatureSyntax): T
    fun visitMethodSignature(node: MethodSignatureSyntax): T
    fun visitIndexSignature(node: IndexSignatureSyntax): T
    fun visitPropertySignature(node: PropertySignatureSyntax): T
    fun visitCallSignature(node: CallSignatureSyntax): T
    fun visitParameterList(node: ParameterListSyntax): T
    fun visitTypeParameterList(node: TypeParameterListSyntax): T
    fun visitTypeParameter(node: TypeParameterSyntax): T
    fun visitConstraint(node: ConstraintSyntax): T
    fun visitElseClause(node: ElseClauseSyntax): T
    fun visitIfStatement(node: IfStatementSyntax): T
    fun visitExpressionStatement(node: ExpressionStatementSyntax): T
    fun visitConstructorDeclaration(node: ConstructorDeclarationSyntax): T
    fun visitMemberFunctionDeclaration(node: MemberFunctionDeclarationSyntax): T
    fun visitGetMemberAccessorDeclaration(node: GetMemberAccessorDeclarationSyntax): T
    fun visitSetMemberAccessorDeclaration(node: SetMemberAccessorDeclarationSyntax): T
    fun visitMemberVariableDeclaration(node: MemberVariableDeclarationSyntax): T
    fun visitThrowStatement(node: ThrowStatementSyntax): T
    fun visitReturnStatement(node: ReturnStatementSyntax): T
    fun visitObjectCreationExpression(node: ObjectCreationExpressionSyntax): T
    fun visitSwitchStatement(node: SwitchStatementSyntax): T
    fun visitCaseSwitchClause(node: CaseSwitchClauseSyntax): T
    fun visitDefaultSwitchClause(node: DefaultSwitchClauseSyntax): T
    fun visitBreakStatement(node: BreakStatementSyntax): T
    fun visitContinueStatement(node: ContinueStatementSyntax): T
    fun visitForStatement(node: ForStatementSyntax): T
    fun visitForInStatement(node: ForInStatementSyntax): T
    fun visitWhileStatement(node: WhileStatementSyntax): T
    fun visitWithStatement(node: WithStatementSyntax): T
    fun visitEnumDeclaration(node: EnumDeclarationSyntax): T
    fun visitEnumElement(node: EnumElementSyntax): T
    fun visitCastExpression(node: CastExpressionSyntax): T
    fun visitObjectLiteralExpression(node: ObjectLiteralExpressionSyntax): T
    fun visitSimplePropertyAssignment(node: SimplePropertyAssignmentSyntax): T
    fun visitFunctionPropertyAssignment(node: FunctionPropertyAssignmentSyntax): T
    fun visitGetAccessorPropertyAssignment(node: GetAccessorPropertyAssignmentSyntax): T
    fun visitSetAccessorPropertyAssignment(node: SetAccessorPropertyAssignmentSyntax): T
    fun visitFunctionExpression(node: FunctionExpressionSyntax): T
    fun visitEmptyStatement(node: EmptyStatementSyntax): T
    fun visitTryStatement(node: TryStatementSyntax): T
    fun visitCatchClause(node: CatchClauseSyntax): T
    fun visitFinallyClause(node: FinallyClauseSyntax): T
    fun visitLabeledStatement(node: LabeledStatementSyntax): T
    fun visitDoStatement(node: DoStatementSyntax): T
    fun visitTypeOfExpression(node: TypeOfExpressionSyntax): T
    fun visitDeleteExpression(node: DeleteExpressionSyntax): T
    fun visitVoidExpression(node: VoidExpressionSyntax): T
    fun visitDebuggerStatement(node: DebuggerStatementSyntax): T
}
