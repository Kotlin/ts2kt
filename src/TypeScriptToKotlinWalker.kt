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

package ts2kt

import typescript.*
import ts2kt.utils.*

fun FunctionTypeSyntax.toKotlinTypeName(): String {
    val tr = TypeScriptToKotlinWalker()
    tr.visitNode(parameterList)
    return "${tr.out} -> ${`type`.toKotlinTypeName()}"
}

fun ITypeSyntax.toKotlinTypeNameIfStandardType(): String? {
    return when (this.kind()) {
        AnyKeyword -> "Any"
        NumberKeyword -> "Number"
        StringKeyword -> "String"
        BooleanKeyword -> "Boolean"
        VoidKeyword -> "Unit"
        ArrayType -> "Array<${(this as ArrayTypeSyntax).`type`.toKotlinTypeName()}>"
        FunctionType -> (this as FunctionTypeSyntax).toKotlinTypeName()
        else -> null
    }
}

fun ITypeSyntax.getText(): String {
    if (this.isToken()) return (this as ISyntaxToken).text()

    return this.fullText()
}

fun ITypeSyntax?.toKotlinTypeName(): String {
    if (this == null) return "Unit"

    return this.toKotlinTypeNameIfStandardType() ?: this.getText()
}

fun String?.toKotlinTypeName(): String {
    if (this == null) return "Unit"

    return when (this) {
        "any" -> "Any"
        "number" -> "Number"
        "string" -> "String"
        "boolean" -> "Boolean"
        "void" -> "Unit"
        else -> this
    }
}

fun TypeAnnotationSyntax?.toKotlinTypeName(): String = this?.`type`.toKotlinTypeName()

class TypeScriptToKotlinWalker : SyntaxWalker() {
    var out = ""
        private set

    private val INDENT = "    "
    private val indents = listOf("") as MutableList<String>
    private var indentIdx = 0
    private var isNewLine = true

    private val NATIVE = "native"
    private val PUBLIC = "public"
    private val VAL = "val"
    private val VAR = "var"
    private val FUN = "fun"
    private val VARARG = "vararg"
    private val TRAIT = "trait"
    private val CLASS = "class"
    val INVOKE = "invoke"
    val GET = "get"
    val SET = "set"
    val OPEN_PAREN = "("
    val CLOSE_PAREN = ")"
    var spaceSuppressed = false

    val suppressSpaceBeforeNodes = listOf(CommaToken)

//  Helpers

    fun print(s: String?, suppressSpace: Boolean = false, suppressNextSpace: Boolean = false) {
        if (s == null) return

        val spaces =
                if (isNewLine) {
                    isNewLine = false
                    indents[indentIdx]
                }
                else {
                    if (suppressSpace || spaceSuppressed) "" else " "
                }
        spaceSuppressed = suppressNextSpace

        out += spaces
        out += s
    }

    fun println() {
        out += "\n"
        isNewLine = true
    }

    fun println(s: String) {
        print(s)
        println()
    }

    fun enterBlock() {
        indentIdx++
        if (indents.size() <= indentIdx) {
            indents.add(indents[indentIdx - 1] + INDENT)
        }
    }

    fun exitBlock() {
        indentIdx--
    }

    fun ISyntaxList.containsBy<T>(a: T, f: (ISyntaxNodeOrToken) -> T): Boolean {
        for (i in 0..childCount() - 1) {
            val e = f(childAt(i))
            if (e == a) return true
        }

        return false
    }

    val SHOULD_BE_ESCAPED =
            setOf("val", "var", "is", "as", "trait", "package", "object", "when", "type", "fun", "in", "This")

    fun String.escapedIfNeed(): String {
        return if (this in SHOULD_BE_ESCAPED || this.contains("$")) {
            "`$this`"
        }
        else {
            this
        }
    }

//  Translation

    override fun visitToken(token: ISyntaxToken) {
        //TODO: HACK with `toKotlinTypeNameIfStandardType` because sometimes we get raw type here
        val tokenAsString = token.toKotlinTypeNameIfStandardType() ?: token.text()
        print(tokenAsString.escapedIfNeed(), suppressSpaceBeforeNodes.contains(token.tokenKind))
    }

//  Variables

    override fun visitVariableStatement(node: VariableStatementSyntax) {
        // Skip if not declare
        if (!node.modifiers.containsBy(DeclareKeyword) { it.kind() } ) return

        println(NATIVE)
        print(PUBLIC)
//      TODO  node.modifiers
        visitVariableDeclaration(node.variableDeclaration)
        println("= noImpl")
    }

    override fun visitVariableDeclaration(node: VariableDeclarationSyntax) {
        print(VAR)
        visitSeparatedList(node.variableDeclarators)
    }

//  Type

    fun printTypeAnnotation(typeNode: ITypeSyntax?, suppressSpace: Boolean = false) {
        if (typeNode == null) return
        print(":", suppressSpace)
        print(typeNode.toKotlinTypeName())
    }

    override fun visitTypeAnnotation(node: TypeAnnotationSyntax?) {
        printTypeAnnotation(node?.`type`, suppressSpace = true)
    }

//    Functions

    override fun visitFunctionDeclaration(node: FunctionDeclarationSyntax) {
        // Skip if not declare
        if (!node.modifiers.containsBy(DeclareKeyword) { it.kind() } ) return

        println(NATIVE)
        print(PUBLIC)
//      TODO  visitList(node.modifiers)
        print(FUN)
        visitToken(node.identifier)
        translateCallSignature(node.callSignature)
        println("= noImpl")
    }

//  Function arguments

    override fun visitParameterList(node: ParameterListSyntax) {
        print(OPEN_PAREN, suppressSpace = true, suppressNextSpace = true)
        visitSeparatedList(node.parameters)
        print(CLOSE_PAREN, suppressSpace = true)
    }

    override fun visitParameter(node: ParameterSyntax) {
        val originalNodeType = node.typeAnnotation?.`type`
        val nodeType =
                if (node.dotDotDotToken != null) {
                    if (originalNodeType?.kind() != ArrayType) throw Exception("Rest prarameter must be array types")
                    print(VARARG)
                    (originalNodeType as? ArrayTypeSyntax)?.`type`
                }
                else {
                    originalNodeType
                }

        visitOptionalToken(node.publicOrPrivateKeyword)

        if (node.typeAnnotation != null) {
            visitToken(node.identifier)
            print(":", suppressSpace = true)
        }

        if (node.questionToken != null && nodeType?.kind() == FunctionType) {
            print(OPEN_PAREN, suppressNextSpace = true)
        }

        if (node.typeAnnotation == null) {
            print(node.identifier.fullText().toKotlinTypeName())
        }
        else {
            print(nodeType.toKotlinTypeName())
        }

        if (node.questionToken != null) {
            if (nodeType?.kind() == FunctionType) {
                print(CLOSE_PAREN, suppressSpace = true)
            }

            print("?", suppressSpace = true)
            if (node.equalsValueClause == null) {
                print("= null") // TODO replace `null` with `undefined`
            }
        }

        visitOptionalNode(node.equalsValueClause)
    }

    //  Generic parameters

    override fun visitTypeParameterList(node: TypeParameterListSyntax) {
        print(node.lessThanToken.text(), suppressSpace = true, suppressNextSpace = true)
        visitSeparatedList(node.typeParameters)
        print(node.greaterThanToken.text(), suppressSpace = true)
    }

    override fun visitConstraint(node: ConstraintSyntax) {
        printTypeAnnotation(node.`type`, suppressSpace = false)
    }

//    Interfaces

    override fun visitInterfaceDeclaration(node: InterfaceDeclarationSyntax) {
        println(NATIVE)
        print(PUBLIC)
//      todo visitList(node.modifiers)
        print(TRAIT)
        visitToken(node.identifier)
        visitOptionalNode(node.typeParameterList)
        visitList(node.heritageClauses)
        visitNode(node.body)
    }

    override fun visitHeritageClause(node: HeritageClauseSyntax) {
        print(":")
        visitSeparatedList(node.typeNames)
    }

    override fun visitTypeArgumentList(node: TypeArgumentListSyntax) {
        print(node.lessThanToken.text(), suppressSpace = true, suppressNextSpace = true)
        visitSeparatedList(node.typeArguments)
        print(node.greaterThanToken.text(), suppressSpace = true)
    }

    override fun visitObjectType(node: ObjectTypeSyntax) {
        println(node.openBraceToken.text())
        enterBlock()

        for (nodeOrToken in node.typeMembers.toNonSeparatorArray()) {
            visitOptionalNodeOrToken(nodeOrToken)
            println()
        }

        exitBlock()
        println(node.closeBraceToken.text())
    }

    override fun visitPropertySignature(node: PropertySignatureSyntax) {
        print(PUBLIC)
        print(VAR)
        visitToken(node.propertyName)

        print(":", suppressSpace = true)

        val needParens = node.questionToken != null && node.typeAnnotation.`type`.kind() == FunctionType
        if (needParens) {
            print(OPEN_PAREN, suppressNextSpace = true)
        }

        print(node.typeAnnotation.toKotlinTypeName())

        if (needParens) {
            print(CLOSE_PAREN, suppressSpace = true)
        }
        print(node.questionToken?.text(), suppressSpace = true)
    }

    override fun visitMethodSignature(node: MethodSignatureSyntax) {
        print(PUBLIC)

        if (node.questionToken == null) {
            print(FUN)
            visitToken(node.propertyName)
            translateCallSignature(node.callSignature)
        }
        else {
            val call = node.callSignature

            print(VAL)
            if (call.typeParameterList != null) {
                print("")
                visitTypeParameterList(call.typeParameterList)
            }
            visitToken(node.propertyName)
            print(":", suppressSpace = true)
            print(OPEN_PAREN, suppressNextSpace = true)
            visitNode(call.parameterList)
            print("->")
            print(call.typeAnnotation.toKotlinTypeName())
            print(CLOSE_PAREN, suppressSpace = true)
            print("?", suppressSpace = true)
        }
    }

    private fun translateCallSignature(node: CallSignatureSyntax) {
        visitOptionalNode(node.typeParameterList)
        visitNode(node.parameterList)
        visitOptionalNode(node.typeAnnotation)
    }

    override fun visitCallSignature(node: CallSignatureSyntax) {
        print(PUBLIC)
        print(FUN)
        print(INVOKE)
        translateCallSignature(node)
    }

    private fun translateAccessor(node: IndexSignatureSyntax, isGetter: Boolean = true) {
        val methodName = if (isGetter) GET else SET

        print(PUBLIC)
        print(FUN)
        print(methodName)

        print(OPEN_PAREN, suppressSpace = true, suppressNextSpace = true)
        visitNode(node.parameter)
        if (!isGetter) {
            print(",", suppressSpace = true)
            print("value")
            visitOptionalNode(node.typeAnnotation)
        }

        print(CLOSE_PAREN, suppressSpace = true)

        if (isGetter) {
            visitOptionalNode(node.typeAnnotation)
        }
    }

    override fun visitIndexSignature(node: IndexSignatureSyntax) {
        translateAccessor(node)
        println()
        translateAccessor(node, isGetter = false)
    }

//  Classes

    override fun visitClassDeclaration(node: ClassDeclarationSyntax) {
        println(NATIVE)
        print(PUBLIC)
//      todo visitList(node.modifiers)
        print(CLASS)
        visitToken(node.identifier)
        visitOptionalNode(node.typeParameterList)
        visitList(node.heritageClauses)

        //this.visitList(node.classElements);

//      Class body

        println(node.openBraceToken.text())
        enterBlock()

        for (nodeOrToken in node.classElements.toArray()) {
            visitOptionalNodeOrToken(nodeOrToken)
            println()
        }

        exitBlock()
        println(node.closeBraceToken.text())

    }

    override fun visitMemberFunctionDeclaration(node: MemberFunctionDeclarationSyntax) {
        print(PUBLIC)
        print(FUN)
//        visitList(node.modifiers)
        visitToken(node.propertyName)
        translateCallSignature(node.callSignature)

//      TODO assert null?
//        visitOptionalNode(node.block)
//        visitOptionalToken(node.semicolonToken)
    }


    override fun visitMemberVariableDeclaration(node: MemberVariableDeclarationSyntax) {
        print(PUBLIC)
        print(VAR)

//        visitList(node.modifiers)
        visitNode(node.variableDeclarator)
    }


}
