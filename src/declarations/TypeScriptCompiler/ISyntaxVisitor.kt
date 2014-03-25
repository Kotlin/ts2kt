/*
 * Copyright 2000-2013 JetBrains s.r.o.
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
trait ISyntaxVisitor {
    fun visitToken(token: ISyntaxToken)
    fun visitSourceUnit(node: SourceUnitSyntax)
    fun visitExternalModuleReference(node: ExternalModuleReferenceSyntax)
    fun visitModuleNameModuleReference(node: ModuleNameModuleReferenceSyntax)
    fun visitImportDeclaration(node: ImportDeclarationSyntax)
    fun visitExportAssignment(node: ExportAssignmentSyntax)
    fun visitClassDeclaration(node: ClassDeclarationSyntax)
    fun visitInterfaceDeclaration(node: InterfaceDeclarationSyntax)
    fun visitHeritageClause(node: HeritageClauseSyntax)
    fun visitModuleDeclaration(node: ModuleDeclarationSyntax)
    fun visitFunctionDeclaration(node: FunctionDeclarationSyntax)
    fun visitVariableStatement(node: VariableStatementSyntax)
    fun visitVariableDeclaration(node: VariableDeclarationSyntax)
    fun visitVariableDeclarator(node: VariableDeclaratorSyntax)
    fun visitEqualsValueClause(node: EqualsValueClauseSyntax)
    fun visitPrefixUnaryExpression(node: PrefixUnaryExpressionSyntax)
    fun visitArrayLiteralExpression(node: ArrayLiteralExpressionSyntax)
    fun visitOmittedExpression(node: OmittedExpressionSyntax)
    fun visitParenthesizedExpression(node: ParenthesizedExpressionSyntax)
    fun visitSimpleArrowFunctionExpression(node: SimpleArrowFunctionExpressionSyntax)
    fun visitParenthesizedArrowFunctionExpression(node: ParenthesizedArrowFunctionExpressionSyntax)
    fun visitQualifiedName(node: QualifiedNameSyntax)
    fun visitTypeArgumentList(node: TypeArgumentListSyntax)
    fun visitConstructorType(node: ConstructorTypeSyntax)
    fun visitFunctionType(node: FunctionTypeSyntax)
    fun visitObjectType(node: ObjectTypeSyntax)
    fun visitArrayType(node: ArrayTypeSyntax)
    fun visitGenericType(node: GenericTypeSyntax)
    fun visitTypeQuery(node: TypeQuerySyntax)
    fun visitTypeAnnotation(node: TypeAnnotationSyntax?)
    fun visitBlock(node: BlockSyntax)
    fun visitParameter(node: ParameterSyntax)
    fun visitMemberAccessExpression(node: MemberAccessExpressionSyntax)
    fun visitPostfixUnaryExpression(node: PostfixUnaryExpressionSyntax)
    fun visitElementAccessExpression(node: ElementAccessExpressionSyntax)
    fun visitInvocationExpression(node: InvocationExpressionSyntax)
    fun visitArgumentList(node: ArgumentListSyntax)
    fun visitBinaryExpression(node: BinaryExpressionSyntax)
    fun visitConditionalExpression(node: ConditionalExpressionSyntax)
    fun visitConstructSignature(node: ConstructSignatureSyntax)
    fun visitMethodSignature(node: MethodSignatureSyntax)
    fun visitIndexSignature(node: IndexSignatureSyntax)
    fun visitPropertySignature(node: PropertySignatureSyntax)
    fun visitCallSignature(node: CallSignatureSyntax)
    fun visitParameterList(node: ParameterListSyntax)
    fun visitTypeParameterList(node: TypeParameterListSyntax)
    fun visitTypeParameter(node: TypeParameterSyntax)
    fun visitConstraint(node: ConstraintSyntax)
    fun visitElseClause(node: ElseClauseSyntax)
    fun visitIfStatement(node: IfStatementSyntax)
    fun visitExpressionStatement(node: ExpressionStatementSyntax)
    fun visitConstructorDeclaration(node: ConstructorDeclarationSyntax)
    fun visitMemberFunctionDeclaration(node: MemberFunctionDeclarationSyntax)
    fun visitGetMemberAccessorDeclaration(node: GetMemberAccessorDeclarationSyntax)
    fun visitSetMemberAccessorDeclaration(node: SetMemberAccessorDeclarationSyntax)
    fun visitMemberVariableDeclaration(node: MemberVariableDeclarationSyntax)
    fun visitThrowStatement(node: ThrowStatementSyntax)
    fun visitReturnStatement(node: ReturnStatementSyntax)
    fun visitObjectCreationExpression(node: ObjectCreationExpressionSyntax)
    fun visitSwitchStatement(node: SwitchStatementSyntax)
    fun visitCaseSwitchClause(node: CaseSwitchClauseSyntax)
    fun visitDefaultSwitchClause(node: DefaultSwitchClauseSyntax)
    fun visitBreakStatement(node: BreakStatementSyntax)
    fun visitContinueStatement(node: ContinueStatementSyntax)
    fun visitForStatement(node: ForStatementSyntax)
    fun visitForInStatement(node: ForInStatementSyntax)
    fun visitWhileStatement(node: WhileStatementSyntax)
    fun visitWithStatement(node: WithStatementSyntax)
    fun visitEnumDeclaration(node: EnumDeclarationSyntax)
    fun visitEnumElement(node: EnumElementSyntax)
    fun visitCastExpression(node: CastExpressionSyntax)
    fun visitObjectLiteralExpression(node: ObjectLiteralExpressionSyntax)
    fun visitSimplePropertyAssignment(node: SimplePropertyAssignmentSyntax)
    fun visitFunctionPropertyAssignment(node: FunctionPropertyAssignmentSyntax)
    fun visitGetAccessorPropertyAssignment(node: GetAccessorPropertyAssignmentSyntax)
    fun visitSetAccessorPropertyAssignment(node: SetAccessorPropertyAssignmentSyntax)
    fun visitFunctionExpression(node: FunctionExpressionSyntax)
    fun visitEmptyStatement(node: EmptyStatementSyntax)
    fun visitTryStatement(node: TryStatementSyntax)
    fun visitCatchClause(node: CatchClauseSyntax)
    fun visitFinallyClause(node: FinallyClauseSyntax)
    fun visitLabeledStatement(node: LabeledStatementSyntax)
    fun visitDoStatement(node: DoStatementSyntax)
    fun visitTypeOfExpression(node: TypeOfExpressionSyntax)
    fun visitDeleteExpression(node: DeleteExpressionSyntax)
    fun visitVoidExpression(node: VoidExpressionSyntax)
    fun visitDebuggerStatement(node: DebuggerStatementSyntax)
}