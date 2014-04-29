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
import ts2kt.kotlin.ast.*
import java.util.ArrayList

private val NATIVE_ANNOTATION = listOf(Annotation("native"))
private val INVOKE = "invoke"
private val GET = "get"
private val SET = "set"

abstract class TypeScriptToKotlinBase : SyntaxWalker() {
    abstract val result: Node?

    open val defaultAnnotations: List<Annotation> = listOf()

    val declarations = ArrayList<Member>()

    fun addVariable(name: String, `type`: String, typeParams: List<TypeParam>? = null, isVar: Boolean = true, isNullable: Boolean = false, isLambda: Boolean = false, needsNoImpl: Boolean = true) {
        declarations.add(Variable(name, TypeAnnotation(`type`, isNullable = isNullable, isLambda = isLambda), defaultAnnotations, typeParams, isVar = isVar, needsNoImpl = needsNoImpl))
    }

    fun addFunction(name: String, params: List<FunParam>, returnType: String, typeParams: List<TypeParam>?, needsNoImpl: Boolean = true) {
        declarations.add(Function(name, params, TypeAnnotation(returnType), typeParams, defaultAnnotations, needsNoImpl = needsNoImpl))
    }

}

class TypeScriptToKotlinWalker(val packageFqName: String? = null) : TypeScriptToKotlinBase() {
    override val result: KotlinFile
        get() = KotlinFile(if (packageFqName != null) Package(packageFqName) else null, declarations)

    override val defaultAnnotations: List<Annotation> = NATIVE_ANNOTATION

//    override fun visitToken(token: ISyntaxToken) {
////        return SimpleNode(token.getText())
//        //TODO: HACK with `toKotlinTypeNameIfStandardType` because sometimes we get raw type here
////        val tokenAsString = token.toKotlinTypeNameIfStandardType() ?: token.text()
////        print(tokenAsString.escapedIfNeed(), suppressSpaceBeforeNodes.contains(token.tokenKind))
//    }

//  Variables

    override fun visitVariableStatement(node: VariableStatementSyntax) {
        // Skip if not declare
        if (!node.modifiers.containsBy(DeclareKeyword) { it.kind() } ) return

//      TODO  node.modifiers
//      TODO  test many declarations
        val declarators = node.variableDeclaration.variableDeclarators
        for (d in declarators) {
            val name = d.identifier.getText()
            val `type` = d.typeAnnotation?.toKotlinTypeName() ?: "Any"
            addVariable(name, `type`)
        }
    }

//    Functions

    override fun visitFunctionDeclaration(node: FunctionDeclarationSyntax) {
        // Skip if not declare
        if (!node.modifiers.containsBy(DeclareKeyword) { it.kind() } ) return

//      TODO  visitList(node.modifiers)
        val name = node.identifier.getText()
        val returnType = node.callSignature.typeAnnotation?.toKotlinTypeName() ?: "Unit"
        val params = node.callSignature.parameterList.toKotlinParams()
        val typeParams = node.callSignature.typeParameterList?.toKotlinTypeParams()

        addFunction(name, params, returnType, typeParams)
    }

//    Interfaces

    override fun visitInterfaceDeclaration(node: InterfaceDeclarationSyntax) {
        val translator = TsInterfaceToKt()
        translator.visitInterfaceDeclaration(node)
        declarations.add(translator.result)
    }

////  Classes

    override fun visitClassDeclaration(node: ClassDeclarationSyntax) {
        val translator = TsClassToKt()
        translator.visitClassDeclaration(node)

        val result = translator.result
        if (result != null) {
            declarations.add(result)
        }
    }
}

abstract class TsClassifierToKt() : TypeScriptToKotlinBase() {
    abstract val needsNoImpl: Boolean

    var parents = ArrayList<Type>()

    override fun visitHeritageClause(node: HeritageClauseSyntax) {
        val types = node.typeNames.map {(id: IIdentifierSyntax) -> Type(id.toKotlinTypeName()) }
        parents.addAll(types)
    }

    override fun visitIndexSignature(node: IndexSignatureSyntax) {
        translateAccessor(node, isGetter = true)
        translateAccessor(node, isGetter = false)
    }

    private fun translateAccessor(node: IndexSignatureSyntax, isGetter: Boolean) {
        val param = node.parameter.toKotlinParam()
        val propType = node.typeAnnotation.toKotlinTypeName()

        if (isGetter) {
            addFunction(GET, listOf(param), propType, listOf(), needsNoImpl)
        }
        else {
            addFunction(SET, listOf(param, FunParam("value", TypeAnnotation(propType))), "Unit", listOf(), needsNoImpl)
        }
    }
}

class TsInterfaceToKt() : TsClassifierToKt() {
    override val result: Classifier
        get() = Classifier(ClassKind.TRAIT, name!!, typeParams, parents, declarations, NATIVE_ANNOTATION)

    override val needsNoImpl = false

    var name: String? = null
    var typeParams: List<TypeParam>? = null

    override fun visitInterfaceDeclaration(node: InterfaceDeclarationSyntax) {
//      todo visitList(node.modifiers)
        name = node.identifier.getText()
        typeParams = node.typeParameterList?.toKotlinTypeParams()

        visitList(node.heritageClauses)
        visitNode(node.body)
    }

    override fun visitPropertySignature(node: PropertySignatureSyntax) {
        val name = node.propertyName.getText()
        val typeName = node.typeAnnotation.toKotlinTypeName()
        val isNullable = node.questionToken != null
        val isLambda = node.typeAnnotation.`type`.kind() == FunctionType

        addVariable(name, typeName, isNullable = isNullable, isLambda = isLambda, needsNoImpl = false)
    }

    override fun visitMethodSignature(node: MethodSignatureSyntax) {
        val name = node.propertyName.getText()
        val isOptional = node.questionToken != null

        val call = node.callSignature

        // TODO extract
        val typeParams = call.typeParameterList?.toKotlinTypeParams()
        val params = call.parameterList.toKotlinParams()
        val returnType = call.typeAnnotation?.toKotlinTypeName() ?: "Unit"

        if (isOptional) {
            addVariable(name, "(${params.join(", ")}) -> $returnType", typeParams, isVar = false, isNullable = true, isLambda = true, needsNoImpl = false)
        }
        else {
            addFunction(name, params, returnType, typeParams, needsNoImpl = false)
        }
    }

    override fun visitCallSignature(node: CallSignatureSyntax) {
        //TODO extract this code???
        val typeParams = node.typeParameterList?.toKotlinTypeParams()
        val params = node.parameterList.toKotlinParams()
        val returnType = node.typeAnnotation?.toKotlinTypeName() ?: "Unit"

        addFunction(INVOKE, params, returnType, typeParams, needsNoImpl = false)
    }
}

class TsClassToKt() : TsClassifierToKt() {
    override val result: Classifier?
        get() = if (name == null) null else Classifier(ClassKind.CLASS, name!!, typeParams, parents, declarations, NATIVE_ANNOTATION)

    override val needsNoImpl = true

    var name: String? = null
    var typeParams: List<TypeParam>? = null

    override fun visitClassDeclaration(node: ClassDeclarationSyntax) {
        // Skip if not declare
        if (!node.modifiers.containsBy(DeclareKeyword) { it.kind() } ) return

//      todo visitList(node.modifiers)
        name = node.identifier.getText()
        typeParams = node.typeParameterList?.toKotlinTypeParams()

        visitList(node.heritageClauses)
        visitList(node.classElements)

//        val elements = node.classElements
//        for (i in 0..elements.childCount() - 1) {
//            val nodeOrToken = elements.childAt(i)
//            visitOptionalNodeOrToken(nodeOrToken)
//        }
    }

    override fun visitMemberVariableDeclaration(node: MemberVariableDeclarationSyntax) {
//        TODO visitList(node.modifiers)
        val declarator = node.variableDeclarator

        // TODO extract??? (see TypeScriptToKotlinWalker::visitVariableStatement)
        val name = declarator.identifier.getText()
        val `type` = declarator.typeAnnotation?.toKotlinTypeName() ?: "Any"

        addVariable(name, `type`)
    }


    override fun visitMemberFunctionDeclaration(node: MemberFunctionDeclarationSyntax) {
//        TODO visitList(node.modifiers)
        val name = node.propertyName.getText()

        val call = node.callSignature
        // TODO extract
        val typeParams = call.typeParameterList?.toKotlinTypeParams()
        val params = call.parameterList.toKotlinParams()
        val returnType = call.typeAnnotation?.toKotlinTypeName() ?: "Unit"

        addFunction(name, params, returnType, typeParams)

//      TODO assert null?
//        visitOptionalNode(node.block)
//        visitOptionalToken(node.semicolonToken)
    }
}
