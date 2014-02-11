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

import typescript.SyntaxWalker
import typescript.VariableDeclarationSyntax
import typescript.ISyntaxToken
import typescript.VariableDeclaratorSyntax
import typescript.TypeAnnotationSyntax

fun tsTypeNameToKotlinTypeName(name: String?) =
        when (name) {
            "number" -> "Number"
            "string" -> "String"
            "boolean" -> "Boolean"
            "void" -> "Unit"
//            "Function" -> "()->Unit"
            else -> "Any"
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

//    private var indent = ""
//
//    override fun visitToken(token: ISyntaxToken) {
//        out += " ${token.text()} "
//    }
////    override fun visitInterfaceDeclaration(node: InterfaceDeclarationSyntax) {
////        super<SyntaxWalker>.visitInterfaceDeclaration(node)
////        node.accept(ClassOrTraitRenderer())
////        visitList(node.modifiers);
////        visitToken(node.interfaceKeyword);
////        visitToken(node.identifier);
////        visitOptionalNode(node.typeParameterList);
////        visitList(node.heritageClauses);
////        visitNode(node.body);
////    }
//
//
//    override fun visitVariableDeclaration(node: VariableDeclarationSyntax) {
//        out += indent
//        visitToken(node.varKeyword);
//        visitSeparatedList(node.variableDeclarators);
//    }
//
//    override fun visitVariableDeclarator(node: VariableDeclaratorSyntax) {
//        this.visitToken(node.identifier);
//        out += node.typeAnnotation.toKotlinTypeName()
////        this.visitOptionalNode(node.equalsValueClause);
//    }
}

//class Foo{
//    var i = 0
//
//    fun bar() {
//        i = 1
//    }
//}