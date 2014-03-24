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

package ts2kt

import typescript.*
import ts2kt.utils.listOf

fun tsTypeNameToKotlinTypeName(name: String) =
        when (name) {
            "any" -> "Any"
            "number" -> "Number"
            "string" -> "String"
            "boolean" -> "Boolean"
            "void" -> "Unit"
//            "Function" -> "()->Unit"
            else -> name
        }

fun TypeAnnotationSyntax?.toKotlinTypeName(): String {
    if (this == null) return "Any"

    return tsTypeNameToKotlinTypeName(this.`type`.fullText())
}

class ClassOrTraitRenderer : SyntaxWalker() {
//    var out = ""
//        private set
//
//    override fun visitToken(token: ISyntaxToken) {
//            out += " ${token.text()} "
//    }

}

class TypeScriptToKotlinWalker : SyntaxWalker() {
    var out = ""
        private set

    private var indent = ""
    private var isNewLine = true

    private val NATIVE = "native"
    private val PUBLIC = "public"
    private val FUN = "fun"
    val OPEN_PAREN = "("
    val CLOSE_PAREN = ")"
    var spaceSuppressed = false

    val suppressSpaceBeforeNodes = listOf(CommaToken)

    fun print(s: String, suppressSpace: Boolean = false, suppressNextSpace: Boolean = false) {
        val spaces =
                if (isNewLine) {
                    isNewLine = false
                    indent
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

    override fun visitToken(token: ISyntaxToken) {
        print(token.text(), suppressSpaceBeforeNodes.contains(token.tokenKind))
    }

//    override fun visitInterfaceDeclaration(node: InterfaceDeclarationSyntax) {
//        super<SyntaxWalker>.visitInterfaceDeclaration(node)
//        node.accept(ClassOrTraitRenderer())
//        visitList(node.modifiers);
//        visitToken(node.interfaceKeyword);
//        visitToken(node.identifier);
//        visitOptionalNode(node.typeParameterList);
//        visitList(node.heritageClauses);
//        visitNode(node.body);
//    }

    fun ISyntaxList.containsBy<T>(a: T, f: (ISyntaxNodeOrToken) -> T): Boolean {
        for (i in 0..childCount() - 1) {
            val e = f(childAt(i))
            if (e == a) return true
        }

        return false
    }

    override fun visitVariableStatement(node: VariableStatementSyntax) {
        // Skip if not declare
        if (!node.modifiers.containsBy(DeclareKeyword) { it.kind() } ) return

        println(NATIVE)
        print(PUBLIC)
//      TODO  node.modifiers
        visitVariableDeclaration(node.variableDeclaration);
        println("= noImpl")
    }

    override fun visitVariableDeclaration(node: VariableDeclarationSyntax) {
        visitToken(node.varKeyword);
        visitSeparatedList(node.variableDeclarators);
    }

    override fun visitTypeAnnotation(node: TypeAnnotationSyntax) {
        print(":", suppressSpace = true);
        val tsType = node.`type`.fullText()
        val ktType = tsTypeNameToKotlinTypeName(tsType)
        print(ktType)
    }

    override fun visitFunctionDeclaration(node: FunctionDeclarationSyntax) {
        // Skip if not declare
        if (!node.modifiers.containsBy(DeclareKeyword) { it.kind() } ) return

        println(NATIVE)
        print(PUBLIC)
//      TODO  visitList(node.modifiers);
        print(FUN);
        visitToken(node.identifier);
        visitNode(node.callSignature);
        println("= noImpl")
    }

    override fun visitParameterList(node: ParameterListSyntax) {
        print(OPEN_PAREN, suppressSpace = true, suppressNextSpace = true);
        visitSeparatedList(node.parameters);
        print(CLOSE_PAREN, suppressSpace = true);
    }
}