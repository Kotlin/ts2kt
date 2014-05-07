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

private val NATIVE_ANNOTATION = Annotation("native")
private val MODULE_ANNOTATION = Annotation("module")
private val DEFAULT_ANNOTATION = listOf(NATIVE_ANNOTATION)
private val DEFAULT_MODULE_ANNOTATION = listOf(MODULE_ANNOTATION)
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

    fun addFunction(name: String, callSignature: CallSignature, needsNoImpl: Boolean = true) {
        declarations.add(Function(name, callSignature, defaultAnnotations, needsNoImpl = needsNoImpl))
    }
}

class TypeScriptToKotlinWalker(
        val packageFqName: String? = null,
        override val defaultAnnotations: List<Annotation> = DEFAULT_ANNOTATION,
        val requiredModifier: SyntaxKind = DeclareKeyword
) : TypeScriptToKotlinBase() {
    override val result: KotlinFile
        get() = KotlinFile(if (packageFqName != null) Package(packageFqName) else null, declarations)

    fun addModule(name: String, members: List<Member>) {
        declarations.add(Classifier(ClassKind.OBJECT, name, listOf(), listOf(), listOf(), members, DEFAULT_MODULE_ANNOTATION))
    }

    fun isShouldSkip(node: SyntaxNode) = !node.modifiers.contains(requiredModifier)

    override fun visitVariableStatement(node: VariableStatementSyntax) {
        if (isShouldSkip(node)) return

//      TODO  node.modifiers
//      TODO  test many declarations
        val declarators = node.variableDeclaration.variableDeclarators
        for (d in declarators) {
            val name = d.identifier.getText()
            val varType = d.typeAnnotation?.toKotlinTypeName() ?: ANY
            addVariable(name, varType)
        }
    }

//  Functions

    override fun visitFunctionDeclaration(node: FunctionDeclarationSyntax) {
        if (isShouldSkip(node)) return

//      TODO  visitList(node.modifiers)
        val name = node.identifier.getText()
        val callSignature = node.callSignature.toKotlinCallSignature()
        addFunction(name, callSignature)
    }

    override fun visitInterfaceDeclaration(node: InterfaceDeclarationSyntax) {
        // TODO: is it hack?
        if (requiredModifier != DeclareKeyword && isShouldSkip(node)) return

        val translator = TsInterfaceToKt(annotations = defaultAnnotations)
        translator.visitInterfaceDeclaration(node)
        declarations.add(translator.result)
    }

    override fun visitClassDeclaration(node: ClassDeclarationSyntax) {
        if (isShouldSkip(node)) return

        val translator = TsClassToKt(annotations = defaultAnnotations)
        translator.visitClassDeclaration(node)

        val result = translator.result
        if (result != null) {
            declarations.add(result)
        }
    }

    override fun visitModuleDeclaration(node: ModuleDeclarationSyntax) {
        if (isShouldSkip(node)) return

        val name = node.moduleName?.getText() ?: node.stringLiteral?.getText() ?: throw Exception("Anonimus module")

        val tr = TypeScriptToKotlinWalker(defaultAnnotations = listOf(), requiredModifier = ExportKeyword)

        tr.visitList(node.moduleElements)

        addModule(name, tr.declarations)
    }
}

abstract class TsClassifierToKt : TypeScriptToKotlinBase() {

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

        val callSignature: CallSignature
        val accessorName: String
        if (isGetter) {
            callSignature = CallSignature(listOf(param), listOf(), TypeAnnotation(propType))
            accessorName = GET
        }
        else {
            callSignature = CallSignature(listOf(param, FunParam("value", TypeAnnotation(propType))), listOf(), TypeAnnotation(UNIT))
            accessorName = SET
        }

        addFunction(accessorName, callSignature, needsNoImpl)
    }
}

class TsInterfaceToKt(val annotations: List<Annotation>) : TsClassifierToKt() {
    override val result: Classifier
        get() = Classifier(ClassKind.TRAIT, name!!, listOf(), typeParams, parents, declarations, annotations)

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

        val call = node.callSignature.toKotlinCallSignature()

        if (isOptional) {
            val typeAsString = "(${call.params.join(", ")}) -> ${call.returnType.name}"
            addVariable(name, typeAsString, call.typeParams, isVar = false, isNullable = true, isLambda = true, needsNoImpl = false)
        }
        else {
            addFunction(name, call, needsNoImpl = false)
        }
    }

    override fun visitCallSignature(node: CallSignatureSyntax) {
        addFunction(INVOKE, node.toKotlinCallSignature(), needsNoImpl = false)
    }
}

class TsClassToKt(
        val kind: ClassKind = ClassKind.CLASS,
        val annotations: List<Annotation> = DEFAULT_ANNOTATION
) : TsClassifierToKt() {
    override val result: Classifier?
        get()  {
            if (name == null) return null

            if (cachedDeclarations == null) {
                cachedDeclarations =
                        if (staticTranslator == null) {
                            declarations
                        } else {
                            val t = ArrayList<Member>()
                            t.addAll(declarations)
                            t.add(staticTranslator!!.result!!)
                            t
                        }
            }

            return Classifier(kind, name!!, paramsOfConstructors, typeParams, parents, cachedDeclarations!!, annotations)
        }

    var cachedDeclarations: List<Member>? = null

    override val needsNoImpl = true

    var name: String? = null
    var typeParams: List<TypeParam>? = null
    var staticTranslator: TsClassToKt? = null
    val paramsOfConstructors = ArrayList<List<FunParam>>()

    fun getTranslator(node: IMemberDeclarationSyntax): TsClassToKt {
        if (node.modifiers.contains(StaticKeyword)) {
            if (staticTranslator == null) {
                staticTranslator = TsClassToKt(ClassKind.CLASS_OBJECT, listOf())
                staticTranslator?.name = ""
            }
            return staticTranslator!!
        }

        return this
    }

    override fun visitClassDeclaration(node: ClassDeclarationSyntax) {
//      todo visitList(node.modifiers)
        name = node.identifier.getText()
        typeParams = node.typeParameterList?.toKotlinTypeParams()

        visitList(node.heritageClauses)
        visitList(node.classElements)
    }

    override fun visitMemberVariableDeclaration(node: MemberVariableDeclarationSyntax) {
        val declarator = node.variableDeclarator

        val name = declarator.identifier.getText()
        val varType = declarator.typeAnnotation?.toKotlinTypeName() ?: ANY

        getTranslator(node).addVariable(name, varType)
    }


    override fun visitMemberFunctionDeclaration(node: MemberFunctionDeclarationSyntax) {
        val name = node.propertyName.getText()

        getTranslator(node).addFunction(name, node.callSignature.toKotlinCallSignature())

        assert(node.block == null, "An function in declarations file should not have body, function '${this.name}.$name'")
    }

    override fun visitConstructorDeclaration(node: ConstructorDeclarationSyntax) {
        val params = node.parameterList.toKotlinParams()
        paramsOfConstructors.add(params)

        assert(node.block == null, "A constructor in declarations file should not have body, constructor in '${this.name}")
    }
}
