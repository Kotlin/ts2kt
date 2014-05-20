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
import java.util.HashSet
import java.util.HashMap

private val NATIVE_ANNOTATION = Annotation(NATIVE)
private val MODULE_ANNOTATION = Annotation(MODULE)
private val DEFAULT_ANNOTATION = listOf(NATIVE_ANNOTATION)
private val DEFAULT_MODULE_ANNOTATION = listOf(MODULE_ANNOTATION)
private val NO_ANNOTATIONS = listOf<Annotation>()
private val INVOKE = "invoke"
private val GET = "get"
private val SET = "set"

private val COMPARE_BY_NAME = { (a: Named, b: Named) -> a.name == b.name }
private val IS_MODULE_ANNOTATION = { (a: Annotation) -> a.name == MODULE }

abstract class TypeScriptToKotlinBase : SyntaxWalker() {
    abstract val result: Node?

    open val defaultAnnotations: List<Annotation> = listOf()

    val declarations = ArrayList<Member>()

    fun addVariable(name: String, `type`: String, typeParams: List<TypeParam>? = null, isVar: Boolean = true, isNullable: Boolean = false, isLambda: Boolean = false, needsNoImpl: Boolean = true, additionalAnnotations: List<Annotation> = listOf()) {
        val annotations = defaultAnnotations + additionalAnnotations
        declarations.add(Variable(name, TypeAnnotation(`type`, isNullable = isNullable, isLambda = isLambda), annotations, typeParams, isVar = isVar, needsNoImpl = needsNoImpl))
    }

    fun addFunction(name: String, callSignature: CallSignature, needsNoImpl: Boolean = true, additionalAnnotations: List<Annotation> = listOf()) {
        val annotations = defaultAnnotations + additionalAnnotations
        declarations.add(Function(name, callSignature, annotations, needsNoImpl = needsNoImpl))
    }
}

class TypeScriptToKotlinWalker(
        val packageFqName: String? = null,
        override val defaultAnnotations: List<Annotation> = DEFAULT_ANNOTATION,
        val requiredModifier: SyntaxKind = DeclareKeyword,
        val moduleName: String? = null
) : TypeScriptToKotlinBase() {
    override val result: KotlinFile
        get()  {
            assert(exportedByAssignment.isEmpty(), "exportedByAssignment should be empty, but it contains: $exportedByAssignment")
            return KotlinFile(if (packageFqName != null) Package(packageFqName) else null, declarations)
        }

    val exportedByAssignment = HashMap<String, Annotation>()

    fun addModule(name: String, members: List<Member>, additionalAnnotations: List<Annotation> = listOf()) {
        val annotations = DEFAULT_MODULE_ANNOTATION + additionalAnnotations
        declarations.add(Classifier(ClassKind.OBJECT, name, listOf(), listOf(), listOf(), members, annotations))
    }

    fun isShouldSkip(node: SyntaxNode) = !node.modifiers.contains(requiredModifier)


    fun getAdditionalAnnotations(node: SyntaxNode): List<Annotation> =
            if (isShouldSkip(node)) DEFAULT_FAKE_ANNOTATION else NO_ANNOTATIONS

    override fun visitVariableStatement(node: VariableStatementSyntax) {
        val additionalAnnotations = getAdditionalAnnotations(node)

//      TODO  node.modifiers
//      TODO  test many declarations
        val declarators = node.variableDeclaration.variableDeclarators
        for (d in declarators) {
            val name = d.identifier.getText()
            val varType = d.typeAnnotation?.toKotlinTypeName() ?: ANY
            addVariable(name, varType, additionalAnnotations = additionalAnnotations)
        }
    }

    override fun visitFunctionDeclaration(node: FunctionDeclarationSyntax) {
        val additionalAnnotations = getAdditionalAnnotations(node)

//      TODO  visitList(node.modifiers)
        val name = node.identifier.getText()
        val callSignature = node.callSignature.toKotlinCallSignature()
        addFunction(name, callSignature, additionalAnnotations = additionalAnnotations)
    }

    override fun visitInterfaceDeclaration(node: InterfaceDeclarationSyntax) {
//        // TODO: is it hack?
//        if (requiredModifier != DeclareKeyword && isShouldSkip(node)) return

        val translator = TsInterfaceToKt(annotations = defaultAnnotations)
        translator.visitInterfaceDeclaration(node)
        declarations.add(translator.result)
    }

    override fun visitClassDeclaration(node: ClassDeclarationSyntax) {
        val additionalAnnotations = getAdditionalAnnotations(node)

        val translator = TsClassToKt(annotations = defaultAnnotations + additionalAnnotations)
        translator.visitClassDeclaration(node)

        val result = translator.result
        if (result != null) {
            declarations.add(result)
        }
    }

    override fun visitModuleDeclaration(node: ModuleDeclarationSyntax) {
        val additionalAnnotations = getAdditionalAnnotations(node)

        val name = node.moduleName?.getText() ?: node.stringLiteral?.getText() ?: throw Exception("Anonimus module")

        val tr = TypeScriptToKotlinWalker(moduleName = name, defaultAnnotations = listOf(), requiredModifier = ExportKeyword)
        tr.visitList(node.moduleElements)

        val isExternalModule = node.moduleName == null && node.stringLiteral != null

        if (isExternalModule && tr.exportedByAssignment.isEmpty()) {
            val areAllFakeOrInterface = tr.declarations.all {
                it.annotations.any { it == FAKE_ANNOTATION } ||
                (it is Classifier && it.kind == ClassKind.TRAIT && it.annotations.all { it.name != MODULE })
            }
            val areAllPartOfThisModule = { tr.declarations.all { it.annotations.any { it.name == MODULE && it.getFirstParamAsString() == name } } }

            if (areAllFakeOrInterface) {
                // unfake all
                for (d in tr.declarations) {
                    d.annotations = d.annotations.filter { it != FAKE_ANNOTATION }
                }
            }
            else if (areAllPartOfThisModule()) {
                // TODO: is it right?
                if (tr.declarations.size() == 1 && tr.declarations[0] is Variable) {
                    val d = tr.declarations[0]

                    var s: String = d.name
                    d.annotations = d.annotations.map {
                        if (it.name == MODULE && !it.parameters.isEmpty()) {
                            s = it.getFirstParamAsString()!!
                            MODULE_ANNOTATION
                        } else {
                            it
                        }
                    }
                    d.name = s
                }

                this.declarations.addAll(tr.declarations)
                return
            }
        }

        addModule(name, tr.declarations, additionalAnnotations = additionalAnnotations)

        exportedByAssignment.putAll(tr.exportedByAssignment)
    }

    override fun visitExportAssignment(node: ExportAssignmentSyntax) {
        exportedByAssignment[node.identifier.getText()] =
                Annotation(MODULE, if (moduleName == null) listOf() else listOf(Argument(value = "\"$moduleName\"")))
    }

    override fun visitList(list: ISyntaxList) {
        super<TypeScriptToKotlinBase>.visitList(list)
        // TODO: Is it good place for call finish?
        finish()
    }

    fun finish() {
        fixExportAssignments()
        mergeDeclarationsWithSameNameIfNeed()
    }

    fun fixExportAssignments() {
        val found = HashSet<String>()

        for (declaration in declarations) {
            val annotation = exportedByAssignment[declaration.name]
            if (annotation != null) {
                val annotationParamString = annotation.getFirstParamAsString()

                // TODO: fix in compiler
                var needContinue = false;
                // TODO: fix this HACK
                val t = ArrayList<Annotation>(declaration.annotations.size() + 1)
                for (a in declaration.annotations) {
                    if (a == FAKE_ANNOTATION) continue

                    if (a.name == MODULE) {
                        if (declaration.name == annotationParamString) {
                            needContinue = true
                            break
                        }

                        continue
                    }

                    t.add(a)
                }

                if (needContinue) continue

                t.add(annotation)
                declaration.annotations = t

                found.add(declaration.name)
            }
        }

        for (key in found) {
            exportedByAssignment.remove(key)
        }
    }

    fun mergeDeclarationsWithSameNameIfNeed() {
        declarations.merge({ it !is Function }, COMPARE_BY_NAME) { a, b ->
            val result =
                    if (a is Classifier) {
                        when (b) {
                            is Classifier -> mergeClassifiers(a, b)
                            is Variable -> mergeClassifierAndVariable(a, b)
                            else -> throw Exception("Merging ${a.kind} and ??? unsupported yet, a: $a, b: $b")
                        }
                    }
                    else if (a is Variable) {
                        if (b is Classifier) {
                            mergeClassifierAndVariable(b, a)
                        }
                        else {
                            throw Exception("Merging Variable and ??? unsupported yet, a: $a, b: $b")
                        }
                    }
                    else {
                        throw Exception("Unsupported types for merging, a: $a, b: $b")
                    }


            result.annotations = mergeAnnotations(a.annotations, b.annotations)

            result
        }
    }

    fun mergeClassifiers(a: Classifier, b: Classifier): Classifier {
        when (a.kind) {
             ClassKind.CLASS -> {
                if (b.kind == ClassKind.OBJECT) return mergeClassAndObject(a, b)
            }
            ClassKind.TRAIT -> {
                if (b.kind == ClassKind.OBJECT) return mergeClassAndObject(a, b)
                if (b.kind == ClassKind.TRAIT) return mergeClassifierMembers(a, b)
            }
            ClassKind.OBJECT -> {
                if (b.kind == ClassKind.CLASS || b.kind == ClassKind.TRAIT) return mergeClassAndObject(b, a)
                if (b.kind == ClassKind.OBJECT &&
                    a.annotations.any(IS_MODULE_ANNOTATION) &&
                    b.annotations.any(IS_MODULE_ANNOTATION)
                ) {
                    return mergeClassifierMembers(a, b)
                }
            }
        }

        throw Exception("Merging ${a.kind} and ${b.kind} unsupported yet, a: $a, b: $b")
    }

    fun mergeClassifierAndVariable(a: Classifier, b: Variable): Member {
        if (a.members.isEmpty()) return b

//        if (a.kind == ClassKind.OBJECT) {
//            // TODO drop hacks
//            val merged = Classifier(ClassKind.TRAIT, "`${a.name}\$`", listOf(), listOf(), listOf(Type(b.`type`.name)), a.members, a.annotations.filter { it.name != MODULE })
//            declarations.add(merged)
//            b.`type`.name = merged.name
//            return b
//        }

        throw Exception("Merging non-empty Classifier(kind=${a.kind}) and Variable unsupported yet, a: $a, b: $b")
    }

    fun mergeAnnotations(a: List<Annotation>, b: List<Annotation>): List<Annotation> =
            if (a.isEmpty()) {
                b
            }
            else if (b.isEmpty()) {
                a
            }
            else {
                val merged = ArrayList<Annotation>()
                merged.addAll(a)
                merged.addAll(b)

                merged.merge({ true }, COMPARE_BY_NAME) { a, b ->
                    when {
                        a.parameters.isEmpty() -> b
                        b.parameters.isEmpty() -> a
                        a.parameters == b.parameters -> a
                        // TODO
                        else -> throw Exception("Merging annotations with different arguments unsupported yet, a: $a, b: $b")
                    }
                }

                merged
            }

    fun mergeClassAndObject(a: Classifier, b: Classifier): Classifier {
        val classObject = a.members.find { it is Classifier && it.kind == ClassKind.CLASS_OBJECT } as? Classifier

        if (classObject == null) {
            // TODO drop hack
            (a.members as ArrayList).add(Classifier(ClassKind.CLASS_OBJECT, "", listOf(), listOf(), listOf(), b.members, NO_ANNOTATIONS))
        }
        else {
            // TODO drop hack
            (classObject.members as ArrayList).addAll(b.members)
        }

        return a
    }

    fun mergeClassifierMembers(a: Classifier, b: Classifier): Classifier {
        // TODO drop hack
        (a.members as ArrayList).addAll(b.members)
        return a
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
        val typeName = node.typeAnnotation?.toKotlinTypeName() ?: ANY
        val isNullable = node.questionToken != null
        val isLambda = node.typeAnnotation?.`type`?.kind() == FunctionType

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
