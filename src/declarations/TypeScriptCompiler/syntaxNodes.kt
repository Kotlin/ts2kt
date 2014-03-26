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
abstract class SourceUnitSyntax(
        public val moduleElements: ISyntaxList,
        public val endOfFileToken: ISyntaxToken,
        parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode)
{
    public fun update(moduleElements: ISyntaxList, endOfFileToken: ISyntaxToken): SourceUnitSyntax = noImpl
    public fun withModuleElements(moduleElements: ISyntaxList): SourceUnitSyntax = noImpl
    public fun withModuleElement(moduleElement: IModuleElementSyntax): SourceUnitSyntax = noImpl
    public fun withEndOfFileToken(endOfFileToken: ISyntaxToken): SourceUnitSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ModuleReferenceSyntax(parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IModuleReferenceSyntax {
    public fun isModuleReference(): Boolean = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ExternalModuleReferenceSyntax(
        public val moduleOrRequireKeyword: ISyntaxToken,
        public val openParenToken: ISyntaxToken,
        public val stringLiteral: ISyntaxToken,
        public val closeParenToken: ISyntaxToken,
        parsedInStrictMode: Boolean) : ModuleReferenceSyntax(parsedInStrictMode)
{
    public fun update(moduleOrRequireKeyword: ISyntaxToken,
                      openParenToken: ISyntaxToken,
                      stringLiteral: ISyntaxToken,
                      closeParenToken: ISyntaxToken): ExternalModuleReferenceSyntax = noImpl

    public fun withModuleOrRequireKeyword(moduleOrRequireKeyword: ISyntaxToken): ExternalModuleReferenceSyntax = noImpl
    public fun withOpenParenToken(openParenToken: ISyntaxToken): ExternalModuleReferenceSyntax = noImpl
    public fun withStringLiteral(stringLiteral: ISyntaxToken): ExternalModuleReferenceSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): ExternalModuleReferenceSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ModuleNameModuleReferenceSyntax(
        public val moduleName: INameSyntax,
        parsedInStrictMode: Boolean) : ModuleReferenceSyntax(parsedInStrictMode)
{
    public fun update(moduleName: INameSyntax): ModuleNameModuleReferenceSyntax = noImpl
    public fun withModuleName(moduleName: INameSyntax): ModuleNameModuleReferenceSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ImportDeclarationSyntax(
        public val modifiers: ISyntaxList,
        public val importKeyword: ISyntaxToken,
        public val identifier: ISyntaxToken,
        public val equalsToken: ISyntaxToken,
        public val moduleReference: ModuleReferenceSyntax,
        public val semicolonToken: ISyntaxToken,
        parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IModuleElementSyntax
{
    public fun update(modifiers: ISyntaxList,
                      importKeyword: ISyntaxToken,
                      identifier: ISyntaxToken,
                      equalsToken: ISyntaxToken,
                      moduleReference: ModuleReferenceSyntax,
                      semicolonToken: ISyntaxToken): ImportDeclarationSyntax = noImpl

    public fun withModifiers(modifiers: ISyntaxList): ImportDeclarationSyntax = noImpl
    public fun withModifier(modifier: ISyntaxToken): ImportDeclarationSyntax = noImpl
    public fun withImportKeyword(importKeyword: ISyntaxToken): ImportDeclarationSyntax = noImpl
    public fun withIdentifier(identifier: ISyntaxToken): ImportDeclarationSyntax = noImpl
    public fun withEqualsToken(equalsToken: ISyntaxToken): ImportDeclarationSyntax = noImpl
    public fun withModuleReference(moduleReference: ModuleReferenceSyntax): ImportDeclarationSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): ImportDeclarationSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ExportAssignmentSyntax(public val exportKeyword: ISyntaxToken,
                                      public val equalsToken: ISyntaxToken,
                                      public val identifier: ISyntaxToken,
                                      public val semicolonToken: ISyntaxToken,
                                      parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IModuleElementSyntax {

    public fun update(exportKeyword: ISyntaxToken,
                      equalsToken: ISyntaxToken,
                      identifier: ISyntaxToken,
                      semicolonToken: ISyntaxToken): ExportAssignmentSyntax = noImpl

    public fun withExportKeyword(exportKeyword: ISyntaxToken): ExportAssignmentSyntax = noImpl
    public fun withEqualsToken(equalsToken: ISyntaxToken): ExportAssignmentSyntax = noImpl
    public fun withIdentifier(identifier: ISyntaxToken): ExportAssignmentSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): ExportAssignmentSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ClassDeclarationSyntax(public val modifiers: ISyntaxList,
                                      public val classKeyword: ISyntaxToken,
                                      public val identifier: ISyntaxToken,
                                      public val typeParameterList: TypeParameterListSyntax,
                                      public val heritageClauses: ISyntaxList,
                                      public val openBraceToken: ISyntaxToken,
                                      public val classElements: ISyntaxList,
                                      public val closeBraceToken: ISyntaxToken,
                                      parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IModuleElementSyntax {

    public fun update(modifiers: ISyntaxList,
                      classKeyword: ISyntaxToken,
                      identifier: ISyntaxToken,
                      typeParameterList: TypeParameterListSyntax,
                      heritageClauses: ISyntaxList,
                      openBraceToken: ISyntaxToken,
                      classElements: ISyntaxList,
                      closeBraceToken: ISyntaxToken): ClassDeclarationSyntax = noImpl

    public fun withModifiers(modifiers: ISyntaxList): ClassDeclarationSyntax = noImpl
    public fun withModifier(modifier: ISyntaxToken): ClassDeclarationSyntax = noImpl
    public fun withClassKeyword(classKeyword: ISyntaxToken): ClassDeclarationSyntax = noImpl
    public fun withIdentifier(identifier: ISyntaxToken): ClassDeclarationSyntax = noImpl
    public fun withTypeParameterList(typeParameterList: TypeParameterListSyntax): ClassDeclarationSyntax = noImpl
    public fun withHeritageClauses(heritageClauses: ISyntaxList): ClassDeclarationSyntax = noImpl
    public fun withHeritageClause(heritageClause: HeritageClauseSyntax): ClassDeclarationSyntax = noImpl
    public fun withOpenBraceToken(openBraceToken: ISyntaxToken): ClassDeclarationSyntax = noImpl
    public fun withClassElements(classElements: ISyntaxList): ClassDeclarationSyntax = noImpl
    public fun withClassElement(classElement: IClassElementSyntax): ClassDeclarationSyntax = noImpl
    public fun withCloseBraceToken(closeBraceToken: ISyntaxToken): ClassDeclarationSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class InterfaceDeclarationSyntax(public val modifiers: ISyntaxList,
                                          public val interfaceKeyword: ISyntaxToken,
                                          public val identifier: ISyntaxToken,
                                          public val typeParameterList: TypeParameterListSyntax,
                                          public val heritageClauses: ISyntaxList,
                                          public val body: ObjectTypeSyntax,
                                          parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IModuleElementSyntax
{
    public fun update(modifiers: ISyntaxList,
                      interfaceKeyword: ISyntaxToken,
                      identifier: ISyntaxToken,
                      typeParameterList: TypeParameterListSyntax,
                      heritageClauses: ISyntaxList,
                      body: ObjectTypeSyntax): InterfaceDeclarationSyntax = noImpl

    public fun withModifiers(modifiers: ISyntaxList): InterfaceDeclarationSyntax = noImpl
    public fun withModifier(modifier: ISyntaxToken): InterfaceDeclarationSyntax = noImpl
    public fun withInterfaceKeyword(interfaceKeyword: ISyntaxToken): InterfaceDeclarationSyntax = noImpl
    public fun withIdentifier(identifier: ISyntaxToken): InterfaceDeclarationSyntax = noImpl
    public fun withTypeParameterList(typeParameterList: TypeParameterListSyntax): InterfaceDeclarationSyntax = noImpl
    public fun withHeritageClauses(heritageClauses: ISyntaxList): InterfaceDeclarationSyntax = noImpl
    public fun withHeritageClause(heritageClause: HeritageClauseSyntax): InterfaceDeclarationSyntax = noImpl
    public fun withBody(body: ObjectTypeSyntax): InterfaceDeclarationSyntax = noImpl

}

[suppress("UNUSED_PARAMETER")]
native
abstract class HeritageClauseSyntax(public val extendsOrImplementsKeyword: ISyntaxToken,
                                    public val typeNames: ISeparatedSyntaxList,
                                    parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode)
{
    public fun update(extendsOrImplementsKeyword: ISyntaxToken, typeNames: ISeparatedSyntaxList): HeritageClauseSyntax = noImpl
    public fun withExtendsOrImplementsKeyword(extendsOrImplementsKeyword: ISyntaxToken): HeritageClauseSyntax = noImpl
    public fun withTypeNames(typeNames: ISeparatedSyntaxList): HeritageClauseSyntax = noImpl
    public fun withTypeName(typeName: INameSyntax): HeritageClauseSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ModuleDeclarationSyntax(public val modifiers: ISyntaxList,
                                       public val moduleKeyword: ISyntaxToken,
                                       public val moduleName: INameSyntax,
                                       public val stringLiteral: ISyntaxToken,
                                       public val openBraceToken: ISyntaxToken,
                                       public val moduleElements: ISyntaxList,
                                       public val closeBraceToken: ISyntaxToken,
                                       parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IModuleElementSyntax
{
    public fun update(modifiers: ISyntaxList,
                      moduleKeyword: ISyntaxToken,
                      moduleName: INameSyntax,
                      stringLiteral: ISyntaxToken,
                      openBraceToken: ISyntaxToken,
                      moduleElements: ISyntaxList,
                      closeBraceToken: ISyntaxToken): ModuleDeclarationSyntax = noImpl

    public fun withModifiers(modifiers: ISyntaxList): ModuleDeclarationSyntax = noImpl
    public fun withModifier(modifier: ISyntaxToken): ModuleDeclarationSyntax = noImpl
    public fun withModuleKeyword(moduleKeyword: ISyntaxToken): ModuleDeclarationSyntax = noImpl
    public fun withModuleName(moduleName: INameSyntax): ModuleDeclarationSyntax = noImpl
    public fun withStringLiteral(stringLiteral: ISyntaxToken): ModuleDeclarationSyntax = noImpl
    public fun withOpenBraceToken(openBraceToken: ISyntaxToken): ModuleDeclarationSyntax = noImpl
    public fun withModuleElements(moduleElements: ISyntaxList): ModuleDeclarationSyntax = noImpl
    public fun withModuleElement(moduleElement: IModuleElementSyntax): ModuleDeclarationSyntax = noImpl
    public fun withCloseBraceToken(closeBraceToken: ISyntaxToken): ModuleDeclarationSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class FunctionDeclarationSyntax(public val modifiers: ISyntaxList,
                                         public val functionKeyword: ISyntaxToken,
                                         public val identifier: ISyntaxToken,
                                         public val callSignature: CallSignatureSyntax,
                                         public val block: BlockSyntax,
                                         public val semicolonToken: ISyntaxToken,
                                         parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax
{
    public fun update(modifiers: ISyntaxList,
                      functionKeyword: ISyntaxToken,
                      identifier: ISyntaxToken,
                      callSignature: CallSignatureSyntax,
                      block: BlockSyntax,
                      semicolonToken: ISyntaxToken): FunctionDeclarationSyntax = noImpl

    public fun withModifiers(modifiers: ISyntaxList): FunctionDeclarationSyntax = noImpl
    public fun withModifier(modifier: ISyntaxToken): FunctionDeclarationSyntax = noImpl
    public fun withFunctionKeyword(functionKeyword: ISyntaxToken): FunctionDeclarationSyntax = noImpl
    public fun withIdentifier(identifier: ISyntaxToken): FunctionDeclarationSyntax = noImpl
    public fun withCallSignature(callSignature: CallSignatureSyntax): FunctionDeclarationSyntax = noImpl
    public fun withBlock(block: BlockSyntax): FunctionDeclarationSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): FunctionDeclarationSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class VariableStatementSyntax(public val modifiers: ISyntaxList,
                                       public val variableDeclaration: VariableDeclarationSyntax,
                                       public val semicolonToken: ISyntaxToken,
                                       parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax
{
    public fun update(modifiers: ISyntaxList,
                      variableDeclaration: VariableDeclarationSyntax,
                      semicolonToken: ISyntaxToken): VariableStatementSyntax = noImpl

    public fun withModifiers(modifiers: ISyntaxList): VariableStatementSyntax = noImpl
    public fun withModifier(modifier: ISyntaxToken): VariableStatementSyntax = noImpl
    public fun withVariableDeclaration(variableDeclaration: VariableDeclarationSyntax): VariableStatementSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): VariableStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class VariableDeclarationSyntax(public val varKeyword: ISyntaxToken,
                                         public val variableDeclarators: ISeparatedSyntaxList,
                                         parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode)
{
    public fun update(varKeyword: ISyntaxToken, variableDeclarators: ISeparatedSyntaxList): VariableDeclarationSyntax = noImpl
    public fun withVarKeyword(varKeyword: ISyntaxToken): VariableDeclarationSyntax = noImpl
    public fun withVariableDeclarators(variableDeclarators: ISeparatedSyntaxList): VariableDeclarationSyntax = noImpl
    public fun withVariableDeclarator(variableDeclarator: VariableDeclaratorSyntax): VariableDeclarationSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class VariableDeclaratorSyntax(public val identifier: ISyntaxToken,
                                        public val typeAnnotation: TypeAnnotationSyntax?,
                                        public val equalsValueClause: EqualsValueClauseSyntax,
                                        parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode)
{

    public fun update(identifier: ISyntaxToken, typeAnnotation: TypeAnnotationSyntax,
                      equalsValueClause: EqualsValueClauseSyntax): VariableDeclaratorSyntax = noImpl

    public fun withIdentifier(identifier: ISyntaxToken): VariableDeclaratorSyntax = noImpl
    public fun withTypeAnnotation(typeAnnotation: TypeAnnotationSyntax): VariableDeclaratorSyntax = noImpl
    public fun withEqualsValueClause(equalsValueClause: EqualsValueClauseSyntax): VariableDeclaratorSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class EqualsValueClauseSyntax(public val equalsToken: ISyntaxToken,
                                       public val value: IExpressionSyntax,
                                       parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode) {
    public fun update(equalsToken: ISyntaxToken,
                      value: IExpressionSyntax): EqualsValueClauseSyntax = noImpl

    public fun withEqualsToken(equalsToken: ISyntaxToken): EqualsValueClauseSyntax = noImpl
    public fun withValue(value: IExpressionSyntax): EqualsValueClauseSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class PrefixUnaryExpressionSyntax(private val _kind: SyntaxKind,
                                           public val operatorToken: ISyntaxToken,
                                           public val operand: IUnaryExpressionSyntax,
                                           parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax
{
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl
    public fun update(kind: SyntaxKind,
                      operatorToken: ISyntaxToken,
                      operand: IUnaryExpressionSyntax): PrefixUnaryExpressionSyntax = noImpl

    public fun withKind(kind: SyntaxKind): PrefixUnaryExpressionSyntax = noImpl

    public fun withOperatorToken(operatorToken: ISyntaxToken): PrefixUnaryExpressionSyntax = noImpl

    public fun withOperand(operand: IUnaryExpressionSyntax): PrefixUnaryExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ArrayLiteralExpressionSyntax(public val openBracketToken: ISyntaxToken,
                                            public val expressions: ISeparatedSyntaxList,
                                            public val closeBracketToken: ISyntaxToken,
                                            parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax
{

    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl

    public fun update(openBracketToken: ISyntaxToken,
                      expressions: ISeparatedSyntaxList,
                      closeBracketToken: ISyntaxToken): ArrayLiteralExpressionSyntax = noImpl

    public fun withOpenBracketToken(openBracketToken: ISyntaxToken): ArrayLiteralExpressionSyntax = noImpl

    public fun withExpressions(expressions: ISeparatedSyntaxList): ArrayLiteralExpressionSyntax = noImpl

    public fun withExpression(expression: IExpressionSyntax): ArrayLiteralExpressionSyntax = noImpl

    public fun withCloseBracketToken(closeBracketToken: ISyntaxToken): ArrayLiteralExpressionSyntax = noImpl

}

[suppress("UNUSED_PARAMETER")]
native
abstract class OmittedExpressionSyntax(parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IExpressionSyntax {
    public fun isExpression(): Boolean = noImpl
    public fun update(): OmittedExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ParenthesizedExpressionSyntax(public val openParenToken: ISyntaxToken,
                                             public val expression: IExpressionSyntax,
                                             public val closeParenToken: ISyntaxToken,
                                             parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax
{
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl
    public fun update(openParenToken: ISyntaxToken,
                      expression: IExpressionSyntax,
                      closeParenToken: ISyntaxToken): ParenthesizedExpressionSyntax = noImpl

    public fun withOpenParenToken(openParenToken: ISyntaxToken): ParenthesizedExpressionSyntax = noImpl
    public fun withExpression(expression: IExpressionSyntax): ParenthesizedExpressionSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): ParenthesizedExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ArrowFunctionExpressionSyntax(public val equalsGreaterThanToken: ISyntaxToken,
                                             public val body: ISyntaxNodeOrToken,
                                             parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax
{
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class SimpleArrowFunctionExpressionSyntax(public val identifier: ISyntaxToken,
                                                   equalsGreaterThanToken: ISyntaxToken,
                                                   body: ISyntaxNodeOrToken,
                                                   parsedInStrictMode: Boolean) : ArrowFunctionExpressionSyntax(equalsGreaterThanToken, body, parsedInStrictMode)
{
    public fun update(identifier: ISyntaxToken,
                      equalsGreaterThanToken: ISyntaxToken,
                      body: ISyntaxNodeOrToken): SimpleArrowFunctionExpressionSyntax = noImpl

    public fun withIdentifier(identifier: ISyntaxToken): SimpleArrowFunctionExpressionSyntax = noImpl
    public fun withEqualsGreaterThanToken(equalsGreaterThanToken: ISyntaxToken): SimpleArrowFunctionExpressionSyntax = noImpl
    public fun withBody(body: ISyntaxNodeOrToken): SimpleArrowFunctionExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ParenthesizedArrowFunctionExpressionSyntax(public val callSignature: CallSignatureSyntax,
                                                          equalsGreaterThanToken: ISyntaxToken,
                                                          body: ISyntaxNodeOrToken,
                                                          parsedInStrictMode: Boolean) : ArrowFunctionExpressionSyntax(equalsGreaterThanToken, body, parsedInStrictMode)
{
    public fun update(callSignature: CallSignatureSyntax,
                      equalsGreaterThanToken: ISyntaxToken,
                      body: ISyntaxNodeOrToken): ParenthesizedArrowFunctionExpressionSyntax = noImpl

    public fun withCallSignature(callSignature: CallSignatureSyntax): ParenthesizedArrowFunctionExpressionSyntax = noImpl
    public fun withEqualsGreaterThanToken(equalsGreaterThanToken: ISyntaxToken): ParenthesizedArrowFunctionExpressionSyntax = noImpl
    public fun withBody(body: ISyntaxNodeOrToken): ParenthesizedArrowFunctionExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class QualifiedNameSyntax(public val left: INameSyntax,
                                   public val dotToken: ISyntaxToken,
                                   public val right: ISyntaxToken,
                                   parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), INameSyntax
{
    public fun isName(): Boolean = noImpl
    public fun isType(): Boolean = noImpl
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl

    public fun update(left: INameSyntax,
                      dotToken: ISyntaxToken,
                      right: ISyntaxToken): QualifiedNameSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): QualifiedNameSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): QualifiedNameSyntax = noImpl

    public fun withLeft(left: INameSyntax): QualifiedNameSyntax = noImpl
    public fun withDotToken(dotToken: ISyntaxToken): QualifiedNameSyntax = noImpl
    public fun withRight(right: ISyntaxToken): QualifiedNameSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class TypeArgumentListSyntax(public val lessThanToken: ISyntaxToken,
                                      public val typeArguments: ISeparatedSyntaxList,
                                      public val greaterThanToken: ISyntaxToken,
                                      parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode)
{
    public fun update(lessThanToken: ISyntaxToken,
                      typeArguments: ISeparatedSyntaxList,
                      greaterThanToken: ISyntaxToken): TypeArgumentListSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): TypeArgumentListSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): TypeArgumentListSyntax = noImpl

    public fun withLessThanToken(lessThanToken: ISyntaxToken): TypeArgumentListSyntax = noImpl
    public fun withTypeArguments(typeArguments: ISeparatedSyntaxList): TypeArgumentListSyntax = noImpl
    public fun withTypeArgument(typeArgument: ITypeSyntax): TypeArgumentListSyntax = noImpl
    public fun withGreaterThanToken(greaterThanToken: ISyntaxToken): TypeArgumentListSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ConstructorTypeSyntax(public val newKeyword: ISyntaxToken,
                                     public val typeParameterList: TypeParameterListSyntax,
                                     public val parameterList: ParameterListSyntax,
                                     public val equalsGreaterThanToken: ISyntaxToken,
                                     public val `type`: ITypeSyntax,
                                     parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), ITypeSyntax
{
    public fun isType(): Boolean = noImpl
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl

    public fun update(newKeyword: ISyntaxToken,
                      typeParameterList: TypeParameterListSyntax,
                      parameterList: ParameterListSyntax,
                      equalsGreaterThanToken: ISyntaxToken,
                      `type`: ITypeSyntax): ConstructorTypeSyntax = noImpl


    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ConstructorTypeSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ConstructorTypeSyntax = noImpl

    public fun withNewKeyword(newKeyword: ISyntaxToken): ConstructorTypeSyntax = noImpl
    public fun withTypeParameterList(typeParameterList: TypeParameterListSyntax): ConstructorTypeSyntax = noImpl
    public fun withParameterList(parameterList: ParameterListSyntax): ConstructorTypeSyntax = noImpl
    public fun withEqualsGreaterThanToken(equalsGreaterThanToken: ISyntaxToken): ConstructorTypeSyntax = noImpl
    public fun withType(`type`: ITypeSyntax): ConstructorTypeSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class FunctionTypeSyntax(public val typeParameterList: TypeParameterListSyntax,
                                  public val parameterList: ParameterListSyntax,
                                  public val equalsGreaterThanToken: ISyntaxToken,
                                  public val `type`: ITypeSyntax,
                                  parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), ITypeSyntax
{
    public fun isType(): Boolean = noImpl
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl
    public fun update(typeParameterList: TypeParameterListSyntax,
                      parameterList: ParameterListSyntax,
                      equalsGreaterThanToken: ISyntaxToken,
                      `type`: ITypeSyntax): FunctionTypeSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): FunctionTypeSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): FunctionTypeSyntax = noImpl

    public fun withTypeParameterList(typeParameterList: TypeParameterListSyntax): FunctionTypeSyntax = noImpl
    public fun withParameterList(parameterList: ParameterListSyntax): FunctionTypeSyntax = noImpl
    public fun withEqualsGreaterThanToken(equalsGreaterThanToken: ISyntaxToken): FunctionTypeSyntax = noImpl
    public fun withType(`type`: ITypeSyntax): FunctionTypeSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ObjectTypeSyntax(public val openBraceToken: ISyntaxToken,
                                public val typeMembers: ISeparatedSyntaxList,
                                public val closeBraceToken: ISyntaxToken,
                                parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), ITypeSyntax
{
    public fun isType(): Boolean = noImpl
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl
    public fun update(openBraceToken: ISyntaxToken,
                      typeMembers: ISeparatedSyntaxList,
                      closeBraceToken: ISyntaxToken): ObjectTypeSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ObjectTypeSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ObjectTypeSyntax = noImpl

    public fun withOpenBraceToken(openBraceToken: ISyntaxToken): ObjectTypeSyntax = noImpl
    public fun withTypeMembers(typeMembers: ISeparatedSyntaxList): ObjectTypeSyntax = noImpl
    public fun withTypeMember(typeMember: ITypeMemberSyntax): ObjectTypeSyntax = noImpl
    public fun withCloseBraceToken(closeBraceToken: ISyntaxToken): ObjectTypeSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ArrayTypeSyntax(public val `type`: ITypeSyntax,
                               public val openBracketToken: ISyntaxToken,
                               public val closeBracketToken: ISyntaxToken,
                               parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), ITypeSyntax
{
    public fun isType(): Boolean = noImpl
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl
    public fun update(`type`: ITypeSyntax,
                      openBracketToken: ISyntaxToken,
                      closeBracketToken: ISyntaxToken): ArrayTypeSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ArrayTypeSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ArrayTypeSyntax = noImpl

    public fun withType(`type`: ITypeSyntax): ArrayTypeSyntax = noImpl
    public fun withOpenBracketToken(openBracketToken: ISyntaxToken): ArrayTypeSyntax = noImpl
    public fun withCloseBracketToken(closeBracketToken: ISyntaxToken): ArrayTypeSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class GenericTypeSyntax(public val name: INameSyntax,
                                 public val typeArgumentList: TypeArgumentListSyntax,
                                 parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), ITypeSyntax
{
    public fun isType(): Boolean = noImpl
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl
    public fun update(name: INameSyntax,
                      typeArgumentList: TypeArgumentListSyntax): GenericTypeSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): GenericTypeSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): GenericTypeSyntax = noImpl

    public fun withName(name: INameSyntax): GenericTypeSyntax = noImpl
    public fun withTypeArgumentList(typeArgumentList: TypeArgumentListSyntax): GenericTypeSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class TypeQuerySyntax(public val typeOfKeyword: ISyntaxToken,
                               public val name: INameSyntax,
                               parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), ITypeSyntax
{
    public fun isType(): Boolean = noImpl
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl

    public fun update(typeOfKeyword: ISyntaxToken,
                      name: INameSyntax): TypeQuerySyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): TypeQuerySyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): TypeQuerySyntax = noImpl

    public fun withTypeOfKeyword(typeOfKeyword: ISyntaxToken): TypeQuerySyntax = noImpl
    public fun withName(name: INameSyntax): TypeQuerySyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class TypeAnnotationSyntax(public val colonToken: ISyntaxToken,
                                    public val `type`: ITypeSyntax,
                                    parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode)
{
    public fun update(colonToken: ISyntaxToken,
                      `type`: ITypeSyntax): TypeAnnotationSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): TypeAnnotationSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): TypeAnnotationSyntax = noImpl

    public fun withColonToken(colonToken: ISyntaxToken): TypeAnnotationSyntax = noImpl
    public fun withType(`type`: ITypeSyntax): TypeAnnotationSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class BlockSyntax(public val openBraceToken: ISyntaxToken,
                           public val statements: ISyntaxList,
                           public val closeBraceToken: ISyntaxToken,
                           parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax
{
    public fun update(openBraceToken: ISyntaxToken,
                      statements: ISyntaxList,
                      closeBraceToken: ISyntaxToken): BlockSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): BlockSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): BlockSyntax = noImpl

    public fun withOpenBraceToken(openBraceToken: ISyntaxToken): BlockSyntax = noImpl
    public fun withStatements(statements: ISyntaxList): BlockSyntax = noImpl
    public fun withStatement(statement: IStatementSyntax): BlockSyntax = noImpl
    public fun withCloseBraceToken(closeBraceToken: ISyntaxToken): BlockSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ParameterSyntax(public val dotDotDotToken: ISyntaxToken?,
                               public val publicOrPrivateKeyword: ISyntaxToken,
                               public val identifier: ISyntaxToken,
                               public val questionToken: ISyntaxToken?,
                               public val typeAnnotation: TypeAnnotationSyntax?,
                               public val equalsValueClause: EqualsValueClauseSyntax?,
                               parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode)
{
    public fun update(dotDotDotToken: ISyntaxToken,
                      publicOrPrivateKeyword: ISyntaxToken,
                      identifier: ISyntaxToken,
                      questionToken: ISyntaxToken,
                      typeAnnotation: TypeAnnotationSyntax,
                      equalsValueClause: EqualsValueClauseSyntax): ParameterSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ParameterSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ParameterSyntax = noImpl

    public fun withDotDotDotToken(dotDotDotToken: ISyntaxToken): ParameterSyntax = noImpl
    public fun withPublicOrPrivateKeyword(publicOrPrivateKeyword: ISyntaxToken): ParameterSyntax = noImpl
    public fun withIdentifier(identifier: ISyntaxToken): ParameterSyntax = noImpl
    public fun withQuestionToken(questionToken: ISyntaxToken): ParameterSyntax = noImpl
    public fun withTypeAnnotation(typeAnnotation: TypeAnnotationSyntax): ParameterSyntax = noImpl
    public fun withEqualsValueClause(equalsValueClause: EqualsValueClauseSyntax): ParameterSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class MemberAccessExpressionSyntax(public val expression: IExpressionSyntax,
                                            public val dotToken: ISyntaxToken,
                                            public val name: ISyntaxToken,
                                            parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax
{
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl

    public fun update(expression: IExpressionSyntax,
                      dotToken: ISyntaxToken,
                      name: ISyntaxToken): MemberAccessExpressionSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): MemberAccessExpressionSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): MemberAccessExpressionSyntax = noImpl

    public fun withExpression(expression: IExpressionSyntax): MemberAccessExpressionSyntax = noImpl
    public fun withDotToken(dotToken: ISyntaxToken): MemberAccessExpressionSyntax = noImpl
    public fun withName(name: ISyntaxToken): MemberAccessExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class PostfixUnaryExpressionSyntax(private val _kind: SyntaxKind,
                                            public val operand: IExpressionSyntax,
                                            public val operatorToken: ISyntaxToken,
                                            parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax
{
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl

    public fun update(kind: SyntaxKind,
                      operand: IExpressionSyntax,
                      operatorToken: ISyntaxToken): PostfixUnaryExpressionSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): PostfixUnaryExpressionSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): PostfixUnaryExpressionSyntax = noImpl

    public fun withKind(kind: SyntaxKind): PostfixUnaryExpressionSyntax = noImpl
    public fun withOperand(operand: IExpressionSyntax): PostfixUnaryExpressionSyntax = noImpl
    public fun withOperatorToken(operatorToken: ISyntaxToken): PostfixUnaryExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ElementAccessExpressionSyntax(public val expression: IExpressionSyntax,
                                             public val openBracketToken: ISyntaxToken,
                                             public val argumentExpression: IExpressionSyntax,
                                             public val closeBracketToken: ISyntaxToken,
                                             parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax
{
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl

    public fun update(expression: IExpressionSyntax,
                      openBracketToken: ISyntaxToken,
                      argumentExpression: IExpressionSyntax,
                      closeBracketToken: ISyntaxToken): ElementAccessExpressionSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ElementAccessExpressionSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ElementAccessExpressionSyntax = noImpl

    public fun withExpression(expression: IExpressionSyntax): ElementAccessExpressionSyntax = noImpl
    public fun withOpenBracketToken(openBracketToken: ISyntaxToken): ElementAccessExpressionSyntax = noImpl
    public fun withArgumentExpression(argumentExpression: IExpressionSyntax): ElementAccessExpressionSyntax = noImpl
    public fun withCloseBracketToken(closeBracketToken: ISyntaxToken): ElementAccessExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class InvocationExpressionSyntax(public val expression: IExpressionSyntax,
                                          public val argumentList: ArgumentListSyntax,
                                          parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax
{
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl
    public fun update(expression: IExpressionSyntax,
                      argumentList: ArgumentListSyntax): InvocationExpressionSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): InvocationExpressionSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): InvocationExpressionSyntax = noImpl

    public fun withExpression(expression: IExpressionSyntax): InvocationExpressionSyntax = noImpl
    public fun withArgumentList(argumentList: ArgumentListSyntax): InvocationExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ArgumentListSyntax(public val typeArgumentList: TypeArgumentListSyntax,
                                  public val openParenToken: ISyntaxToken,
                                  public val arguments: ISeparatedSyntaxList,
                                  public val closeParenToken: ISyntaxToken,
                                  parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode)
{
    public fun update(typeArgumentList: TypeArgumentListSyntax,
                      openParenToken: ISyntaxToken,
                      _arguments: ISeparatedSyntaxList,
                      closeParenToken: ISyntaxToken): ArgumentListSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ArgumentListSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ArgumentListSyntax = noImpl

    public fun withTypeArgumentList(typeArgumentList: TypeArgumentListSyntax): ArgumentListSyntax = noImpl
    public fun withOpenParenToken(openParenToken: ISyntaxToken): ArgumentListSyntax = noImpl
    public fun withArguments(_arguments: ISeparatedSyntaxList): ArgumentListSyntax = noImpl
    public fun withArgument(_argument: IExpressionSyntax): ArgumentListSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): ArgumentListSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class BinaryExpressionSyntax(private val _kind: SyntaxKind,
                                      public val left: IExpressionSyntax,
                                      public val operatorToken: ISyntaxToken,
                                      public val right: IExpressionSyntax,
                                      parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IExpressionSyntax
{
    public fun isExpression(): Boolean = noImpl

    public fun update(kind: SyntaxKind,
                      left: IExpressionSyntax,
                      operatorToken: ISyntaxToken,
                      right: IExpressionSyntax): BinaryExpressionSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): BinaryExpressionSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): BinaryExpressionSyntax = noImpl

    public fun withKind(kind: SyntaxKind): BinaryExpressionSyntax = noImpl
    public fun withLeft(left: IExpressionSyntax): BinaryExpressionSyntax = noImpl
    public fun withOperatorToken(operatorToken: ISyntaxToken): BinaryExpressionSyntax = noImpl
    public fun withRight(right: IExpressionSyntax): BinaryExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ConditionalExpressionSyntax(public val condition: IExpressionSyntax,
                                           public val questionToken: ISyntaxToken,
                                           public val whenTrue: IExpressionSyntax,
                                           public val colonToken: ISyntaxToken,
                                           public val whenFalse: IExpressionSyntax,
                                           parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IExpressionSyntax {
    public fun isExpression(): Boolean = noImpl
    public fun update(condition: IExpressionSyntax,
                      questionToken: ISyntaxToken,
                      whenTrue: IExpressionSyntax,
                      colonToken: ISyntaxToken,
                      whenFalse: IExpressionSyntax): ConditionalExpressionSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ConditionalExpressionSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ConditionalExpressionSyntax = noImpl

    public fun withCondition(condition: IExpressionSyntax): ConditionalExpressionSyntax = noImpl
    public fun withQuestionToken(questionToken: ISyntaxToken): ConditionalExpressionSyntax = noImpl
    public fun withWhenTrue(whenTrue: IExpressionSyntax): ConditionalExpressionSyntax = noImpl
    public fun withColonToken(colonToken: ISyntaxToken): ConditionalExpressionSyntax = noImpl
    public fun withWhenFalse(whenFalse: IExpressionSyntax): ConditionalExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ConstructSignatureSyntax(public val newKeyword: ISyntaxToken,
                                        public val callSignature: CallSignatureSyntax,
                                        parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), ITypeMemberSyntax
{
    public fun update(newKeyword: ISyntaxToken,
                      callSignature: CallSignatureSyntax): ConstructSignatureSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ConstructSignatureSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ConstructSignatureSyntax = noImpl

    public fun withNewKeyword(newKeyword: ISyntaxToken): ConstructSignatureSyntax = noImpl
    public fun withCallSignature(callSignature: CallSignatureSyntax): ConstructSignatureSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class MethodSignatureSyntax(public val propertyName: ISyntaxToken,
                                     public val questionToken: ISyntaxToken?,
                                     public val callSignature: CallSignatureSyntax,
                                     parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), ITypeMemberSyntax {
    public fun update(propertyName: ISyntaxToken,
                      questionToken: ISyntaxToken,
                      callSignature: CallSignatureSyntax): MethodSignatureSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): MethodSignatureSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): MethodSignatureSyntax = noImpl

    public fun withPropertyName(propertyName: ISyntaxToken): MethodSignatureSyntax = noImpl
    public fun withQuestionToken(questionToken: ISyntaxToken): MethodSignatureSyntax = noImpl
    public fun withCallSignature(callSignature: CallSignatureSyntax): MethodSignatureSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class IndexSignatureSyntax(public val openBracketToken: ISyntaxToken,
                                    public val parameter: ParameterSyntax,
                                    public val closeBracketToken: ISyntaxToken,
                                    public val typeAnnotation: TypeAnnotationSyntax,
                                    parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), ITypeMemberSyntax, IClassElementSyntax
{
    public fun update(openBracketToken: ISyntaxToken,
                      parameter: ParameterSyntax,
                      closeBracketToken: ISyntaxToken,
                      typeAnnotation: TypeAnnotationSyntax): IndexSignatureSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): IndexSignatureSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): IndexSignatureSyntax = noImpl

    public fun withOpenBracketToken(openBracketToken: ISyntaxToken): IndexSignatureSyntax = noImpl
    public fun withParameter(parameter: ParameterSyntax): IndexSignatureSyntax = noImpl
    public fun withCloseBracketToken(closeBracketToken: ISyntaxToken): IndexSignatureSyntax = noImpl
    public fun withTypeAnnotation(typeAnnotation: TypeAnnotationSyntax): IndexSignatureSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class PropertySignatureSyntax(public val propertyName: ISyntaxToken,
                                       public val questionToken: ISyntaxToken?,
                                       public val typeAnnotation: TypeAnnotationSyntax,
                                       parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), ITypeMemberSyntax {
    public fun update(propertyName: ISyntaxToken,
                      questionToken: ISyntaxToken,
                      typeAnnotation: TypeAnnotationSyntax): PropertySignatureSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): PropertySignatureSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): PropertySignatureSyntax = noImpl

    public fun withPropertyName(propertyName: ISyntaxToken): PropertySignatureSyntax = noImpl
    public fun withQuestionToken(questionToken: ISyntaxToken): PropertySignatureSyntax = noImpl
    public fun withTypeAnnotation(typeAnnotation: TypeAnnotationSyntax): PropertySignatureSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class CallSignatureSyntax(public val typeParameterList: TypeParameterListSyntax?,
                                   public val parameterList: ParameterListSyntax,
                                   public val typeAnnotation: TypeAnnotationSyntax?,
                                   parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), ITypeMemberSyntax
{
    public fun update(typeParameterList: TypeParameterListSyntax,
                      parameterList: ParameterListSyntax,
                      typeAnnotation: TypeAnnotationSyntax): CallSignatureSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): CallSignatureSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): CallSignatureSyntax = noImpl

    public fun withTypeParameterList(typeParameterList: TypeParameterListSyntax): CallSignatureSyntax = noImpl
    public fun withParameterList(parameterList: ParameterListSyntax): CallSignatureSyntax = noImpl
    public fun withTypeAnnotation(typeAnnotation: TypeAnnotationSyntax): CallSignatureSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ParameterListSyntax(public val openParenToken: ISyntaxToken,
                                   public val parameters: ISeparatedSyntaxList,
                                   public val closeParenToken: ISyntaxToken,
                                   parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode)
{

    public fun update(openParenToken: ISyntaxToken,
                      parameters: ISeparatedSyntaxList,
                      closeParenToken: ISyntaxToken): ParameterListSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ParameterListSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ParameterListSyntax = noImpl

    public fun withOpenParenToken(openParenToken: ISyntaxToken): ParameterListSyntax = noImpl
    public fun withParameters(parameters: ISeparatedSyntaxList): ParameterListSyntax = noImpl
    public fun withParameter(parameter: ParameterSyntax): ParameterListSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): ParameterListSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class TypeParameterListSyntax(public val lessThanToken: ISyntaxToken,
                                       public val typeParameters: ISeparatedSyntaxList,
                                       public val greaterThanToken: ISyntaxToken,
                                       parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode) {
    public fun update(lessThanToken: ISyntaxToken,
                      typeParameters: ISeparatedSyntaxList,
                      greaterThanToken: ISyntaxToken): TypeParameterListSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): TypeParameterListSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): TypeParameterListSyntax = noImpl

    public fun withLessThanToken(lessThanToken: ISyntaxToken): TypeParameterListSyntax = noImpl
    public fun withTypeParameters(typeParameters: ISeparatedSyntaxList): TypeParameterListSyntax = noImpl
    public fun withTypeParameter(typeParameter: TypeParameterSyntax): TypeParameterListSyntax = noImpl
    public fun withGreaterThanToken(greaterThanToken: ISyntaxToken): TypeParameterListSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class TypeParameterSyntax(public val identifier: ISyntaxToken,
                                   public val constraint: ConstraintSyntax,
                                   parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode) {
    public fun update(identifier: ISyntaxToken,
                      constraint: ConstraintSyntax): TypeParameterSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): TypeParameterSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): TypeParameterSyntax = noImpl

    public fun withIdentifier(identifier: ISyntaxToken): TypeParameterSyntax = noImpl
    public fun withConstraint(constraint: ConstraintSyntax): TypeParameterSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ConstraintSyntax(public val extendsKeyword: ISyntaxToken,
                                public val `type`: ITypeSyntax,
                                parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode) {
    public fun update(extendsKeyword: ISyntaxToken, `type`: ITypeSyntax): ConstraintSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ConstraintSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ConstraintSyntax = noImpl

    public fun withExtendsKeyword(extendsKeyword: ISyntaxToken): ConstraintSyntax = noImpl
    public fun withType(`type`: ITypeSyntax): ConstraintSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ElseClauseSyntax(public val elseKeyword: ISyntaxToken,
                                public val statement: IStatementSyntax,
                                parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode) {
    public fun update(elseKeyword: ISyntaxToken,
                      statement: IStatementSyntax): ElseClauseSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ElseClauseSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ElseClauseSyntax = noImpl

    public fun withElseKeyword(elseKeyword: ISyntaxToken): ElseClauseSyntax = noImpl
    public fun withStatement(statement: IStatementSyntax): ElseClauseSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class IfStatementSyntax(public val ifKeyword: ISyntaxToken,
                                 public val openParenToken: ISyntaxToken,
                                 public val condition: IExpressionSyntax,
                                 public val closeParenToken: ISyntaxToken,
                                 public val statement: IStatementSyntax,
                                 public val elseClause: ElseClauseSyntax,
                                 parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax {
    public fun update(ifKeyword: ISyntaxToken,
                      openParenToken: ISyntaxToken,
                      condition: IExpressionSyntax,
                      closeParenToken: ISyntaxToken,
                      statement: IStatementSyntax,
                      elseClause: ElseClauseSyntax): IfStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): IfStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): IfStatementSyntax = noImpl

    public fun withIfKeyword(ifKeyword: ISyntaxToken): IfStatementSyntax = noImpl
    public fun withOpenParenToken(openParenToken: ISyntaxToken): IfStatementSyntax = noImpl
    public fun withCondition(condition: IExpressionSyntax): IfStatementSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): IfStatementSyntax = noImpl
    public fun withStatement(statement: IStatementSyntax): IfStatementSyntax = noImpl
    public fun withElseClause(elseClause: ElseClauseSyntax): IfStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ExpressionStatementSyntax(public val expression: IExpressionSyntax,
                                         public val semicolonToken: ISyntaxToken,
                                         parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax {
    public fun update(expression: IExpressionSyntax,
                      semicolonToken: ISyntaxToken): ExpressionStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ExpressionStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ExpressionStatementSyntax = noImpl

    public fun withExpression(expression: IExpressionSyntax): ExpressionStatementSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): ExpressionStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ConstructorDeclarationSyntax(public val constructorKeyword: ISyntaxToken,
                                            public val parameterList: ParameterListSyntax,
                                            public val block: BlockSyntax,
                                            public val semicolonToken: ISyntaxToken,
                                            parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IClassElementSyntax {
    public fun update(constructorKeyword: ISyntaxToken,
                      parameterList: ParameterListSyntax,
                      block: BlockSyntax,
                      semicolonToken: ISyntaxToken): ConstructorDeclarationSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ConstructorDeclarationSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ConstructorDeclarationSyntax = noImpl

    public fun withConstructorKeyword(constructorKeyword: ISyntaxToken): ConstructorDeclarationSyntax = noImpl
    public fun withParameterList(parameterList: ParameterListSyntax): ConstructorDeclarationSyntax = noImpl
    public fun withBlock(block: BlockSyntax): ConstructorDeclarationSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): ConstructorDeclarationSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class MemberFunctionDeclarationSyntax(public val modifiers: ISyntaxList,
                                               public val propertyName: ISyntaxToken,
                                               public val callSignature: CallSignatureSyntax,
                                               public val block: BlockSyntax,
                                               public val semicolonToken: ISyntaxToken,
                                               parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IMemberDeclarationSyntax {
    public fun isMemberDeclaration(): Boolean = noImpl

    public fun update(modifiers: ISyntaxList,
                      propertyName: ISyntaxToken,
                      callSignature: CallSignatureSyntax,
                      block: BlockSyntax,
                      semicolonToken: ISyntaxToken): MemberFunctionDeclarationSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): MemberFunctionDeclarationSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): MemberFunctionDeclarationSyntax = noImpl

    public fun withModifiers(modifiers: ISyntaxList): MemberFunctionDeclarationSyntax = noImpl
    public fun withModifier(modifier: ISyntaxToken): MemberFunctionDeclarationSyntax = noImpl
    public fun withPropertyName(propertyName: ISyntaxToken): MemberFunctionDeclarationSyntax = noImpl
    public fun withCallSignature(callSignature: CallSignatureSyntax): MemberFunctionDeclarationSyntax = noImpl
    public fun withBlock(block: BlockSyntax): MemberFunctionDeclarationSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): MemberFunctionDeclarationSyntax = noImpl

}

[suppress("UNUSED_PARAMETER")]
native
abstract class MemberAccessorDeclarationSyntax(public val modifiers: ISyntaxList,
                                               public val propertyName: ISyntaxToken,
                                               public val parameterList: ParameterListSyntax,
                                               public val block: BlockSyntax,
                                               parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IMemberDeclarationSyntax
{
    public fun isMemberDeclaration(): Boolean = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): MemberAccessorDeclarationSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): MemberAccessorDeclarationSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class GetMemberAccessorDeclarationSyntax(modifiers: ISyntaxList,
                                                  public val getKeyword: ISyntaxToken,
                                                  propertyName: ISyntaxToken,
                                                  parameterList: ParameterListSyntax,
                                                  public val typeAnnotation: TypeAnnotationSyntax,
                                                  block: BlockSyntax,
                                                  parsedInStrictMode: Boolean) : MemberAccessorDeclarationSyntax(modifiers, propertyName, parameterList, block, parsedInStrictMode) {
    public fun update(modifiers: ISyntaxList,
                      getKeyword: ISyntaxToken,
                      propertyName: ISyntaxToken,
                      parameterList: ParameterListSyntax,
                      typeAnnotation: TypeAnnotationSyntax,
                      block: BlockSyntax): GetMemberAccessorDeclarationSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): GetMemberAccessorDeclarationSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): GetMemberAccessorDeclarationSyntax = noImpl

    public fun withModifiers(modifiers: ISyntaxList): GetMemberAccessorDeclarationSyntax = noImpl
    public fun withModifier(modifier: ISyntaxToken): GetMemberAccessorDeclarationSyntax = noImpl
    public fun withGetKeyword(getKeyword: ISyntaxToken): GetMemberAccessorDeclarationSyntax = noImpl
    public fun withPropertyName(propertyName: ISyntaxToken): GetMemberAccessorDeclarationSyntax = noImpl
    public fun withParameterList(parameterList: ParameterListSyntax): GetMemberAccessorDeclarationSyntax = noImpl
    public fun withTypeAnnotation(typeAnnotation: TypeAnnotationSyntax): GetMemberAccessorDeclarationSyntax = noImpl
    public fun withBlock(block: BlockSyntax): GetMemberAccessorDeclarationSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class SetMemberAccessorDeclarationSyntax(modifiers: ISyntaxList,
                                                  public val setKeyword: ISyntaxToken,
                                                  propertyName: ISyntaxToken,
                                                  parameterList: ParameterListSyntax,
                                                  block: BlockSyntax,
                                                  parsedInStrictMode: Boolean) : MemberAccessorDeclarationSyntax(modifiers, propertyName, parameterList, block, parsedInStrictMode) {
    public fun update(modifiers: ISyntaxList,
                      setKeyword: ISyntaxToken,
                      propertyName: ISyntaxToken,
                      parameterList: ParameterListSyntax,
                      block: BlockSyntax): SetMemberAccessorDeclarationSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): SetMemberAccessorDeclarationSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): SetMemberAccessorDeclarationSyntax = noImpl

    public fun withModifiers(modifiers: ISyntaxList): SetMemberAccessorDeclarationSyntax = noImpl
    public fun withModifier(modifier: ISyntaxToken): SetMemberAccessorDeclarationSyntax = noImpl
    public fun withSetKeyword(setKeyword: ISyntaxToken): SetMemberAccessorDeclarationSyntax = noImpl
    public fun withPropertyName(propertyName: ISyntaxToken): SetMemberAccessorDeclarationSyntax = noImpl
    public fun withParameterList(parameterList: ParameterListSyntax): SetMemberAccessorDeclarationSyntax = noImpl
    public fun withBlock(block: BlockSyntax): SetMemberAccessorDeclarationSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class MemberVariableDeclarationSyntax(public val modifiers: ISyntaxList,
                                               public val variableDeclarator: VariableDeclaratorSyntax,
                                               public val semicolonToken: ISyntaxToken,
                                               parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IMemberDeclarationSyntax {
    public fun isMemberDeclaration(): Boolean = noImpl

    public fun update(modifiers: ISyntaxList,
                      variableDeclarator: VariableDeclaratorSyntax,
                      semicolonToken: ISyntaxToken): MemberVariableDeclarationSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): MemberVariableDeclarationSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): MemberVariableDeclarationSyntax = noImpl

    public fun withModifiers(modifiers: ISyntaxList): MemberVariableDeclarationSyntax = noImpl
    public fun withModifier(modifier: ISyntaxToken): MemberVariableDeclarationSyntax = noImpl
    public fun withVariableDeclarator(variableDeclarator: VariableDeclaratorSyntax): MemberVariableDeclarationSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): MemberVariableDeclarationSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ThrowStatementSyntax(public val throwKeyword: ISyntaxToken,
                                    public val expression: IExpressionSyntax,
                                    public val semicolonToken: ISyntaxToken,
                                    parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax {
    public fun update(throwKeyword: ISyntaxToken,
                      expression: IExpressionSyntax,
                      semicolonToken: ISyntaxToken): ThrowStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ThrowStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ThrowStatementSyntax = noImpl

    public fun withThrowKeyword(throwKeyword: ISyntaxToken): ThrowStatementSyntax = noImpl
    public fun withExpression(expression: IExpressionSyntax): ThrowStatementSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): ThrowStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ReturnStatementSyntax(public val returnKeyword: ISyntaxToken,
                                     public val expression: IExpressionSyntax,
                                     public val semicolonToken: ISyntaxToken,
                                     parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax {
    public fun update(returnKeyword: ISyntaxToken,
                      expression: IExpressionSyntax,
                      semicolonToken: ISyntaxToken): ReturnStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ReturnStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ReturnStatementSyntax = noImpl

    public fun withReturnKeyword(returnKeyword: ISyntaxToken): ReturnStatementSyntax = noImpl
    public fun withExpression(expression: IExpressionSyntax): ReturnStatementSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): ReturnStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ObjectCreationExpressionSyntax(public val newKeyword: ISyntaxToken,
                                              public val expression: IExpressionSyntax,
                                              public val argumentList: ArgumentListSyntax,
                                              parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax {
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl

    public fun update(newKeyword: ISyntaxToken,
                      expression: IExpressionSyntax,
                      argumentList: ArgumentListSyntax): ObjectCreationExpressionSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ObjectCreationExpressionSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ObjectCreationExpressionSyntax = noImpl

    public fun withNewKeyword(newKeyword: ISyntaxToken): ObjectCreationExpressionSyntax = noImpl
    public fun withExpression(expression: IExpressionSyntax): ObjectCreationExpressionSyntax = noImpl
    public fun withArgumentList(argumentList: ArgumentListSyntax): ObjectCreationExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class SwitchStatementSyntax(public val switchKeyword: ISyntaxToken,
                                     public val openParenToken: ISyntaxToken,
                                     public val expression: IExpressionSyntax,
                                     public val closeParenToken: ISyntaxToken,
                                     public val openBraceToken: ISyntaxToken,
                                     public val switchClauses: ISyntaxList,
                                     public val closeBraceToken: ISyntaxToken,
                                     parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax {
    public fun update(switchKeyword: ISyntaxToken,
                      openParenToken: ISyntaxToken,
                      expression: IExpressionSyntax,
                      closeParenToken: ISyntaxToken,
                      openBraceToken: ISyntaxToken,
                      switchClauses: ISyntaxList,
                      closeBraceToken: ISyntaxToken): SwitchStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): SwitchStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): SwitchStatementSyntax = noImpl

    public fun withSwitchKeyword(switchKeyword: ISyntaxToken): SwitchStatementSyntax = noImpl
    public fun withOpenParenToken(openParenToken: ISyntaxToken): SwitchStatementSyntax = noImpl
    public fun withExpression(expression: IExpressionSyntax): SwitchStatementSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): SwitchStatementSyntax = noImpl
    public fun withOpenBraceToken(openBraceToken: ISyntaxToken): SwitchStatementSyntax = noImpl
    public fun withSwitchClauses(switchClauses: ISyntaxList): SwitchStatementSyntax = noImpl
    public fun withSwitchClause(switchClause: SwitchClauseSyntax): SwitchStatementSyntax = noImpl
    public fun withCloseBraceToken(closeBraceToken: ISyntaxToken): SwitchStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class SwitchClauseSyntax(public val colonToken: ISyntaxToken,
                                  public val statements: ISyntaxList,
                                  parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), ISwitchClauseSyntax
{
    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): SwitchClauseSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): SwitchClauseSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class CaseSwitchClauseSyntax(public val caseKeyword: ISyntaxToken,
                                      public val expression: IExpressionSyntax,
                                      colonToken: ISyntaxToken,
                                      statements: ISyntaxList,
                                      parsedInStrictMode: Boolean) : SwitchClauseSyntax(colonToken, statements, parsedInStrictMode)
{
    public fun update(caseKeyword: ISyntaxToken,
                      expression: IExpressionSyntax,
                      colonToken: ISyntaxToken,
                      statements: ISyntaxList): CaseSwitchClauseSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): CaseSwitchClauseSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): CaseSwitchClauseSyntax = noImpl

    public fun withCaseKeyword(caseKeyword: ISyntaxToken): CaseSwitchClauseSyntax = noImpl
    public fun withExpression(expression: IExpressionSyntax): CaseSwitchClauseSyntax = noImpl
    public fun withColonToken(colonToken: ISyntaxToken): CaseSwitchClauseSyntax = noImpl
    public fun withStatements(statements: ISyntaxList): CaseSwitchClauseSyntax = noImpl
    public fun withStatement(statement: IStatementSyntax): CaseSwitchClauseSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class DefaultSwitchClauseSyntax(public val defaultKeyword: ISyntaxToken,
                                         colonToken: ISyntaxToken,
                                         statements: ISyntaxList,
                                         parsedInStrictMode: Boolean) : SwitchClauseSyntax(colonToken, statements, parsedInStrictMode)
{
    public fun update(defaultKeyword: ISyntaxToken,
                      colonToken: ISyntaxToken,
                      statements: ISyntaxList): DefaultSwitchClauseSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): DefaultSwitchClauseSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): DefaultSwitchClauseSyntax = noImpl

    public fun withDefaultKeyword(defaultKeyword: ISyntaxToken): DefaultSwitchClauseSyntax = noImpl
    public fun withColonToken(colonToken: ISyntaxToken): DefaultSwitchClauseSyntax = noImpl
    public fun withStatements(statements: ISyntaxList): DefaultSwitchClauseSyntax = noImpl
    public fun withStatement(statement: IStatementSyntax): DefaultSwitchClauseSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class BreakStatementSyntax(public val breakKeyword: ISyntaxToken,
                                    public val identifier: ISyntaxToken,
                                    public val semicolonToken: ISyntaxToken,
                                    parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax
{
    public fun update(breakKeyword: ISyntaxToken,
                      identifier: ISyntaxToken,
                      semicolonToken: ISyntaxToken): BreakStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): BreakStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): BreakStatementSyntax = noImpl

    public fun withBreakKeyword(breakKeyword: ISyntaxToken): BreakStatementSyntax = noImpl
    public fun withIdentifier(identifier: ISyntaxToken): BreakStatementSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): BreakStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ContinueStatementSyntax(public val continueKeyword: ISyntaxToken,
                                       public val identifier: ISyntaxToken,
                                       public val semicolonToken: ISyntaxToken,
                                       parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax {
    public fun update(continueKeyword: ISyntaxToken,
                      identifier: ISyntaxToken,
                      semicolonToken: ISyntaxToken): ContinueStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ContinueStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ContinueStatementSyntax = noImpl

    public fun withContinueKeyword(continueKeyword: ISyntaxToken): ContinueStatementSyntax = noImpl
    public fun withIdentifier(identifier: ISyntaxToken): ContinueStatementSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): ContinueStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class IterationStatementSyntax(public val openParenToken: ISyntaxToken,
                                        public val closeParenToken: ISyntaxToken,
                                        public val statement: IStatementSyntax,
                                        parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax
{
    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): IterationStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): IterationStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class BaseForStatementSyntax(public val forKeyword: ISyntaxToken,
                                      openParenToken: ISyntaxToken,
                                      public val variableDeclaration: VariableDeclarationSyntax,
                                      closeParenToken: ISyntaxToken,
                                      statement: IStatementSyntax,
                                      parsedInStrictMode: Boolean) : IterationStatementSyntax(openParenToken, closeParenToken, statement, parsedInStrictMode)
{
    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): BaseForStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): BaseForStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ForStatementSyntax(forKeyword: ISyntaxToken,
                                  openParenToken: ISyntaxToken,
                                  variableDeclaration: VariableDeclarationSyntax,
                                  public val initializer: IExpressionSyntax,
                                  public val firstSemicolonToken: ISyntaxToken,
                                  public val condition: IExpressionSyntax,
                                  public val secondSemicolonToken: ISyntaxToken,
                                  public val incrementor: IExpressionSyntax,
                                  closeParenToken: ISyntaxToken,
                                  statement: IStatementSyntax,
                                  parsedInStrictMode: Boolean) : BaseForStatementSyntax(forKeyword, openParenToken, variableDeclaration, closeParenToken, statement, parsedInStrictMode)
{
    public fun update(forKeyword: ISyntaxToken,
                      openParenToken: ISyntaxToken,
                      variableDeclaration: VariableDeclarationSyntax,
                      initializer: IExpressionSyntax,
                      firstSemicolonToken: ISyntaxToken,
                      condition: IExpressionSyntax,
                      secondSemicolonToken: ISyntaxToken,
                      incrementor: IExpressionSyntax,
                      closeParenToken: ISyntaxToken,
                      statement: IStatementSyntax): ForStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ForStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ForStatementSyntax = noImpl

    public fun withForKeyword(forKeyword: ISyntaxToken): ForStatementSyntax = noImpl
    public fun withOpenParenToken(openParenToken: ISyntaxToken): ForStatementSyntax = noImpl
    public fun withVariableDeclaration(variableDeclaration: VariableDeclarationSyntax): ForStatementSyntax = noImpl
    public fun withInitializer(initializer: IExpressionSyntax): ForStatementSyntax = noImpl
    public fun withFirstSemicolonToken(firstSemicolonToken: ISyntaxToken): ForStatementSyntax = noImpl
    public fun withCondition(condition: IExpressionSyntax): ForStatementSyntax = noImpl
    public fun withSecondSemicolonToken(secondSemicolonToken: ISyntaxToken): ForStatementSyntax = noImpl
    public fun withIncrementor(incrementor: IExpressionSyntax): ForStatementSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): ForStatementSyntax = noImpl
    public fun withStatement(statement: IStatementSyntax): ForStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ForInStatementSyntax(forKeyword: ISyntaxToken,
                                    openParenToken: ISyntaxToken,
                                    variableDeclaration: VariableDeclarationSyntax,
                                    public val left: IExpressionSyntax,
                                    public val inKeyword: ISyntaxToken,
                                    public val expression: IExpressionSyntax,
                                    closeParenToken: ISyntaxToken,
                                    statement: IStatementSyntax,
                                    parsedInStrictMode: Boolean) : BaseForStatementSyntax(forKeyword, openParenToken, variableDeclaration, closeParenToken, statement, parsedInStrictMode) {
    public fun update(forKeyword: ISyntaxToken,
                      openParenToken: ISyntaxToken,
                      variableDeclaration: VariableDeclarationSyntax,
                      left: IExpressionSyntax,
                      inKeyword: ISyntaxToken,
                      expression: IExpressionSyntax,
                      closeParenToken: ISyntaxToken,
                      statement: IStatementSyntax): ForInStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ForInStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ForInStatementSyntax = noImpl

    public fun withForKeyword(forKeyword: ISyntaxToken): ForInStatementSyntax = noImpl
    public fun withOpenParenToken(openParenToken: ISyntaxToken): ForInStatementSyntax = noImpl
    public fun withVariableDeclaration(variableDeclaration: VariableDeclarationSyntax): ForInStatementSyntax = noImpl
    public fun withLeft(left: IExpressionSyntax): ForInStatementSyntax = noImpl
    public fun withInKeyword(inKeyword: ISyntaxToken): ForInStatementSyntax = noImpl
    public fun withExpression(expression: IExpressionSyntax): ForInStatementSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): ForInStatementSyntax = noImpl
    public fun withStatement(statement: IStatementSyntax): ForInStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class WhileStatementSyntax(public val whileKeyword: ISyntaxToken,
                                    openParenToken: ISyntaxToken,
                                    public val condition: IExpressionSyntax,
                                    closeParenToken: ISyntaxToken,
                                    statement: IStatementSyntax,
                                    parsedInStrictMode: Boolean) : IterationStatementSyntax(openParenToken, closeParenToken, statement, parsedInStrictMode) {
    public fun update(whileKeyword: ISyntaxToken,
                      openParenToken: ISyntaxToken,
                      condition: IExpressionSyntax,
                      closeParenToken: ISyntaxToken,
                      statement: IStatementSyntax): WhileStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): WhileStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): WhileStatementSyntax = noImpl

    public fun withWhileKeyword(whileKeyword: ISyntaxToken): WhileStatementSyntax = noImpl
    public fun withOpenParenToken(openParenToken: ISyntaxToken): WhileStatementSyntax = noImpl
    public fun withCondition(condition: IExpressionSyntax): WhileStatementSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): WhileStatementSyntax = noImpl
    public fun withStatement(statement: IStatementSyntax): WhileStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class WithStatementSyntax(public val withKeyword: ISyntaxToken,
                                   public val openParenToken: ISyntaxToken,
                                   public val condition: IExpressionSyntax,
                                   public val closeParenToken: ISyntaxToken,
                                   public val statement: IStatementSyntax,
                                   parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax {
    public fun update(withKeyword: ISyntaxToken,
                      openParenToken: ISyntaxToken,
                      condition: IExpressionSyntax,
                      closeParenToken: ISyntaxToken,
                      statement: IStatementSyntax): WithStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): WithStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): WithStatementSyntax = noImpl

    public fun withWithKeyword(withKeyword: ISyntaxToken): WithStatementSyntax = noImpl
    public fun withOpenParenToken(openParenToken: ISyntaxToken): WithStatementSyntax = noImpl
    public fun withCondition(condition: IExpressionSyntax): WithStatementSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): WithStatementSyntax = noImpl
    public fun withStatement(statement: IStatementSyntax): WithStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class EnumDeclarationSyntax(public val modifiers: ISyntaxList,
                                     public val enumKeyword: ISyntaxToken,
                                     public val identifier: ISyntaxToken,
                                     public val openBraceToken: ISyntaxToken,
                                     public val enumElements: ISeparatedSyntaxList,
                                     public val closeBraceToken: ISyntaxToken,
                                     parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IModuleElementSyntax {
    public fun update(modifiers: ISyntaxList,
                      enumKeyword: ISyntaxToken,
                      identifier: ISyntaxToken,
                      openBraceToken: ISyntaxToken,
                      enumElements: ISeparatedSyntaxList,
                      closeBraceToken: ISyntaxToken): EnumDeclarationSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): EnumDeclarationSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): EnumDeclarationSyntax = noImpl

    public fun withModifiers(modifiers: ISyntaxList): EnumDeclarationSyntax = noImpl
    public fun withModifier(modifier: ISyntaxToken): EnumDeclarationSyntax = noImpl
    public fun withEnumKeyword(enumKeyword: ISyntaxToken): EnumDeclarationSyntax = noImpl
    public fun withIdentifier(identifier: ISyntaxToken): EnumDeclarationSyntax = noImpl
    public fun withOpenBraceToken(openBraceToken: ISyntaxToken): EnumDeclarationSyntax = noImpl
    public fun withEnumElements(enumElements: ISeparatedSyntaxList): EnumDeclarationSyntax = noImpl
    public fun withEnumElement(enumElement: EnumElementSyntax): EnumDeclarationSyntax = noImpl
    public fun withCloseBraceToken(closeBraceToken: ISyntaxToken): EnumDeclarationSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class EnumElementSyntax(public val propertyName: ISyntaxToken,
                                 public val equalsValueClause: EqualsValueClauseSyntax,
                                 parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode) {
    public fun update(propertyName: ISyntaxToken,
                      equalsValueClause: EqualsValueClauseSyntax): EnumElementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): EnumElementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): EnumElementSyntax = noImpl

    public fun withPropertyName(propertyName: ISyntaxToken): EnumElementSyntax = noImpl
    public fun withEqualsValueClause(equalsValueClause: EqualsValueClauseSyntax): EnumElementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class CastExpressionSyntax(public val lessThanToken: ISyntaxToken,
                                    public val `type`: ITypeSyntax,
                                    public val greaterThanToken: ISyntaxToken,
                                    public val expression: IUnaryExpressionSyntax,
                                    parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax {
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl

    public fun update(lessThanToken: ISyntaxToken,
                      `type`: ITypeSyntax,
                      greaterThanToken: ISyntaxToken,
                      expression: IUnaryExpressionSyntax): CastExpressionSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): CastExpressionSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): CastExpressionSyntax = noImpl

    public fun withLessThanToken(lessThanToken: ISyntaxToken): CastExpressionSyntax = noImpl
    public fun withType(`type`: ITypeSyntax): CastExpressionSyntax = noImpl
    public fun withGreaterThanToken(greaterThanToken: ISyntaxToken): CastExpressionSyntax = noImpl
    public fun withExpression(expression: IUnaryExpressionSyntax): CastExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class ObjectLiteralExpressionSyntax(public val openBraceToken: ISyntaxToken,
                                             public val propertyAssignments: ISeparatedSyntaxList,
                                             public val closeBraceToken: ISyntaxToken,
                                             parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax {
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl

    public fun update(openBraceToken: ISyntaxToken,
                      propertyAssignments: ISeparatedSyntaxList,
                      closeBraceToken: ISyntaxToken): ObjectLiteralExpressionSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): ObjectLiteralExpressionSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): ObjectLiteralExpressionSyntax = noImpl

    public fun withOpenBraceToken(openBraceToken: ISyntaxToken): ObjectLiteralExpressionSyntax = noImpl
    public fun withPropertyAssignments(propertyAssignments: ISeparatedSyntaxList): ObjectLiteralExpressionSyntax = noImpl
    public fun withPropertyAssignment(propertyAssignment: PropertyAssignmentSyntax): ObjectLiteralExpressionSyntax = noImpl
    public fun withCloseBraceToken(closeBraceToken: ISyntaxToken): ObjectLiteralExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class PropertyAssignmentSyntax(public val propertyName: ISyntaxToken,
                                        parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode)
{
    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): PropertyAssignmentSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): PropertyAssignmentSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class SimplePropertyAssignmentSyntax(propertyName: ISyntaxToken,
                                              public val colonToken: ISyntaxToken,
                                              public val expression: IExpressionSyntax,
                                              parsedInStrictMode: Boolean) : PropertyAssignmentSyntax(propertyName, parsedInStrictMode) {
    public fun update(propertyName: ISyntaxToken,
                      colonToken: ISyntaxToken,
                      expression: IExpressionSyntax): SimplePropertyAssignmentSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): SimplePropertyAssignmentSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): SimplePropertyAssignmentSyntax = noImpl

    public fun withPropertyName(propertyName: ISyntaxToken): SimplePropertyAssignmentSyntax = noImpl
    public fun withColonToken(colonToken: ISyntaxToken): SimplePropertyAssignmentSyntax = noImpl
    public fun withExpression(expression: IExpressionSyntax): SimplePropertyAssignmentSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class FunctionPropertyAssignmentSyntax(propertyName: ISyntaxToken,
                                                public val callSignature: CallSignatureSyntax,
                                                public val block: BlockSyntax,
                                                parsedInStrictMode: Boolean) : PropertyAssignmentSyntax(propertyName, parsedInStrictMode) {
    public fun update(propertyName: ISyntaxToken,
                      callSignature: CallSignatureSyntax,
                      block: BlockSyntax): FunctionPropertyAssignmentSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): FunctionPropertyAssignmentSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): FunctionPropertyAssignmentSyntax = noImpl

    public fun withPropertyName(propertyName: ISyntaxToken): FunctionPropertyAssignmentSyntax = noImpl
    public fun withCallSignature(callSignature: CallSignatureSyntax): FunctionPropertyAssignmentSyntax = noImpl
    public fun withBlock(block: BlockSyntax): FunctionPropertyAssignmentSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class AccessorPropertyAssignmentSyntax(propertyName: ISyntaxToken,
                                                public val openParenToken: ISyntaxToken,
                                                public val closeParenToken: ISyntaxToken,
                                                public val block: BlockSyntax,
                                                parsedInStrictMode: Boolean) : PropertyAssignmentSyntax(propertyName, parsedInStrictMode) {
    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): AccessorPropertyAssignmentSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): AccessorPropertyAssignmentSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class GetAccessorPropertyAssignmentSyntax(public val getKeyword: ISyntaxToken,
                                                   propertyName: ISyntaxToken,
                                                   openParenToken: ISyntaxToken,
                                                   closeParenToken: ISyntaxToken,
                                                   public val typeAnnotation: TypeAnnotationSyntax,
                                                   block: BlockSyntax,
                                                   parsedInStrictMode: Boolean) : AccessorPropertyAssignmentSyntax(propertyName, openParenToken, closeParenToken, block, parsedInStrictMode) {
    public fun update(getKeyword: ISyntaxToken,
                      propertyName: ISyntaxToken,
                      openParenToken: ISyntaxToken,
                      closeParenToken: ISyntaxToken,
                      typeAnnotation: TypeAnnotationSyntax,
                      block: BlockSyntax): GetAccessorPropertyAssignmentSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): GetAccessorPropertyAssignmentSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): GetAccessorPropertyAssignmentSyntax = noImpl

    public fun withGetKeyword(getKeyword: ISyntaxToken): GetAccessorPropertyAssignmentSyntax = noImpl
    public fun withPropertyName(propertyName: ISyntaxToken): GetAccessorPropertyAssignmentSyntax = noImpl
    public fun withOpenParenToken(openParenToken: ISyntaxToken): GetAccessorPropertyAssignmentSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): GetAccessorPropertyAssignmentSyntax = noImpl
    public fun withTypeAnnotation(typeAnnotation: TypeAnnotationSyntax): GetAccessorPropertyAssignmentSyntax = noImpl
    public fun withBlock(block: BlockSyntax): GetAccessorPropertyAssignmentSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class SetAccessorPropertyAssignmentSyntax(public val setKeyword: ISyntaxToken,
                                                   propertyName: ISyntaxToken,
                                                   openParenToken: ISyntaxToken,
                                                   public val parameter: ParameterSyntax,
                                                   closeParenToken: ISyntaxToken,
                                                   block: BlockSyntax,
                                                   parsedInStrictMode: Boolean) : AccessorPropertyAssignmentSyntax(propertyName, openParenToken, closeParenToken, block, parsedInStrictMode) {
    public fun update(setKeyword: ISyntaxToken,
                      propertyName: ISyntaxToken,
                      openParenToken: ISyntaxToken,
                      parameter: ParameterSyntax,
                      closeParenToken: ISyntaxToken,
                      block: BlockSyntax): SetAccessorPropertyAssignmentSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): SetAccessorPropertyAssignmentSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): SetAccessorPropertyAssignmentSyntax = noImpl

    public fun withSetKeyword(setKeyword: ISyntaxToken): SetAccessorPropertyAssignmentSyntax = noImpl
    public fun withPropertyName(propertyName: ISyntaxToken): SetAccessorPropertyAssignmentSyntax = noImpl
    public fun withOpenParenToken(openParenToken: ISyntaxToken): SetAccessorPropertyAssignmentSyntax = noImpl
    public fun withParameter(parameter: ParameterSyntax): SetAccessorPropertyAssignmentSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): SetAccessorPropertyAssignmentSyntax = noImpl
    public fun withBlock(block: BlockSyntax): SetAccessorPropertyAssignmentSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class FunctionExpressionSyntax(public val functionKeyword: ISyntaxToken,
                                        public val identifier: ISyntaxToken,
                                        public val callSignature: CallSignatureSyntax,
                                        public val block: BlockSyntax,
                                        parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax {
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl

    public fun update(functionKeyword: ISyntaxToken,
                      identifier: ISyntaxToken,
                      callSignature: CallSignatureSyntax,
                      block: BlockSyntax): FunctionExpressionSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): FunctionExpressionSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): FunctionExpressionSyntax = noImpl

    public fun withFunctionKeyword(functionKeyword: ISyntaxToken): FunctionExpressionSyntax = noImpl
    public fun withIdentifier(identifier: ISyntaxToken): FunctionExpressionSyntax = noImpl
    public fun withCallSignature(callSignature: CallSignatureSyntax): FunctionExpressionSyntax = noImpl
    public fun withBlock(block: BlockSyntax): FunctionExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class EmptyStatementSyntax(public val semicolonToken: ISyntaxToken,
                                    parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax {
    public fun update(semicolonToken: ISyntaxToken): EmptyStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): EmptyStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): EmptyStatementSyntax = noImpl

    public fun withSemicolonToken(semicolonToken: ISyntaxToken): EmptyStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class TryStatementSyntax(public val tryKeyword: ISyntaxToken,
                                  public val block: BlockSyntax,
                                  public val catchClause: CatchClauseSyntax,
                                  public val finallyClause: FinallyClauseSyntax,
                                  parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax {
    public fun update(tryKeyword: ISyntaxToken,
                      block: BlockSyntax,
                      catchClause: CatchClauseSyntax,
                      finallyClause: FinallyClauseSyntax): TryStatementSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): TryStatementSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): TryStatementSyntax = noImpl

    public fun withTryKeyword(tryKeyword: ISyntaxToken): TryStatementSyntax = noImpl
    public fun withBlock(block: BlockSyntax): TryStatementSyntax = noImpl
    public fun withCatchClause(catchClause: CatchClauseSyntax): TryStatementSyntax = noImpl
    public fun withFinallyClause(finallyClause: FinallyClauseSyntax): TryStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class CatchClauseSyntax(public val catchKeyword: ISyntaxToken,
                                 public val openParenToken: ISyntaxToken,
                                 public val identifier: ISyntaxToken,
                                 public val typeAnnotation: TypeAnnotationSyntax,
                                 public val closeParenToken: ISyntaxToken,
                                 public val block: BlockSyntax,
                                 parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode) {
    public fun update(catchKeyword: ISyntaxToken,
                      openParenToken: ISyntaxToken,
                      identifier: ISyntaxToken,
                      typeAnnotation: TypeAnnotationSyntax,
                      closeParenToken: ISyntaxToken,
                      block: BlockSyntax): CatchClauseSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): CatchClauseSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): CatchClauseSyntax = noImpl

    public fun withCatchKeyword(catchKeyword: ISyntaxToken): CatchClauseSyntax = noImpl
    public fun withOpenParenToken(openParenToken: ISyntaxToken): CatchClauseSyntax = noImpl
    public fun withIdentifier(identifier: ISyntaxToken): CatchClauseSyntax = noImpl
    public fun withTypeAnnotation(typeAnnotation: TypeAnnotationSyntax): CatchClauseSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): CatchClauseSyntax = noImpl
    public fun withBlock(block: BlockSyntax): CatchClauseSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class FinallyClauseSyntax(public val finallyKeyword: ISyntaxToken,
                                   public val block: BlockSyntax,
                                   parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode) {
    public fun update(finallyKeyword: ISyntaxToken,
                      block: BlockSyntax): FinallyClauseSyntax = noImpl

    public override fun withLeadingTrivia(trivia: ISyntaxTriviaList): FinallyClauseSyntax = noImpl
    public override fun withTrailingTrivia(trivia: ISyntaxTriviaList): FinallyClauseSyntax = noImpl

    public fun withFinallyKeyword(finallyKeyword: ISyntaxToken): FinallyClauseSyntax = noImpl
    public fun withBlock(block: BlockSyntax): FinallyClauseSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class LabeledStatementSyntax(public val identifier: ISyntaxToken,
                                      public val colonToken: ISyntaxToken,
                                      public val statement: IStatementSyntax,
                                      parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax
{
    public fun update(identifier: ISyntaxToken,
                      colonToken: ISyntaxToken,
                      statement: IStatementSyntax): LabeledStatementSyntax = noImpl
    public fun withIdentifier(identifier: ISyntaxToken): LabeledStatementSyntax = noImpl
    public fun withColonToken(colonToken: ISyntaxToken): LabeledStatementSyntax = noImpl
    public fun withStatement(statement: IStatementSyntax): LabeledStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class DoStatementSyntax(public val doKeyword: ISyntaxToken,
                                 statement: IStatementSyntax,
                                 public val whileKeyword: ISyntaxToken,
                                 openParenToken: ISyntaxToken,
                                 public val condition: IExpressionSyntax,
                                 closeParenToken: ISyntaxToken,
                                 public val semicolonToken: ISyntaxToken,
                                 parsedInStrictMode: Boolean) : IterationStatementSyntax(openParenToken, closeParenToken, statement, parsedInStrictMode) {

    public fun update(doKeyword: ISyntaxToken,
                      statement: IStatementSyntax,
                      whileKeyword: ISyntaxToken,
                      openParenToken: ISyntaxToken,
                      condition: IExpressionSyntax,
                      closeParenToken: ISyntaxToken,
                      semicolonToken: ISyntaxToken): DoStatementSyntax = noImpl

    public fun withDoKeyword(doKeyword: ISyntaxToken): DoStatementSyntax = noImpl
    public fun withStatement(statement: IStatementSyntax): DoStatementSyntax = noImpl
    public fun withWhileKeyword(whileKeyword: ISyntaxToken): DoStatementSyntax = noImpl
    public fun withOpenParenToken(openParenToken: ISyntaxToken): DoStatementSyntax = noImpl
    public fun withCondition(condition: IExpressionSyntax): DoStatementSyntax = noImpl
    public fun withCloseParenToken(closeParenToken: ISyntaxToken): DoStatementSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): DoStatementSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class TypeOfExpressionSyntax(public val typeOfKeyword: ISyntaxToken,
                                      public val expression: IExpressionSyntax,
                                      parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax
{
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl
    public fun update(typeOfKeyword: ISyntaxToken, expression: IExpressionSyntax): TypeOfExpressionSyntax = noImpl
    public fun withTypeOfKeyword(typeOfKeyword: ISyntaxToken): TypeOfExpressionSyntax = noImpl
    public fun withExpression(expression: IExpressionSyntax): TypeOfExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class DeleteExpressionSyntax(public val deleteKeyword: ISyntaxToken,
                                      public val expression: IExpressionSyntax,
                                      parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax
{
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl
    public fun update(deleteKeyword: ISyntaxToken, expression: IExpressionSyntax): DeleteExpressionSyntax = noImpl
    public fun withDeleteKeyword(deleteKeyword: ISyntaxToken): DeleteExpressionSyntax = noImpl
    public fun withExpression(expression: IExpressionSyntax): DeleteExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class VoidExpressionSyntax(public val voidKeyword: ISyntaxToken,
                                    public val expression: IExpressionSyntax,
                                    parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IUnaryExpressionSyntax
{
    public fun isUnaryExpression(): Boolean = noImpl
    public fun isExpression(): Boolean = noImpl
    public fun update(voidKeyword: ISyntaxToken, expression: IExpressionSyntax): VoidExpressionSyntax = noImpl
    public fun withVoidKeyword(voidKeyword: ISyntaxToken): VoidExpressionSyntax = noImpl
    public fun withExpression(expression: IExpressionSyntax): VoidExpressionSyntax = noImpl
}

[suppress("UNUSED_PARAMETER")]
native
abstract class DebuggerStatementSyntax(public val debuggerKeyword: ISyntaxToken,
                                       public val semicolonToken: ISyntaxToken,
                                       parsedInStrictMode: Boolean) : SyntaxNode(parsedInStrictMode), IStatementSyntax
{
    public fun update(debuggerKeyword: ISyntaxToken, semicolonToken: ISyntaxToken): DebuggerStatementSyntax = noImpl
    public fun withDebuggerKeyword(debuggerKeyword: ISyntaxToken): DebuggerStatementSyntax = noImpl
    public fun withSemicolonToken(semicolonToken: ISyntaxToken): DebuggerStatementSyntax = noImpl
}
