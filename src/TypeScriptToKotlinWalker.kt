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
private val IS_NATIVE_ANNOTATION = { (a: Annotation) -> a.name == NATIVE }

abstract class TypeScriptToKotlinBase : SyntaxWalker() {
    abstract val result: Node?
    abstract val hasMembersOpenModifier: Boolean

    open val defaultAnnotations: List<Annotation> = listOf()

    val declarations = ArrayList<Member>()

    open fun addVariable(name: String, `type`: String, extendsType: String? = null, typeParams: List<TypeParam>? = null, isVar: Boolean = true, isNullable: Boolean = false, isLambda: Boolean = false, needsNoImpl: Boolean = true, additionalAnnotations: List<Annotation> = listOf(), isOverride: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        declarations.add(Variable(name, TypeAnnotation(`type`, isNullable = isNullable, isLambda = isLambda), extendsType?.let { Type(it) }, annotations, typeParams, isVar = isVar, needsNoImpl = needsNoImpl, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier))
    }

    open fun addFunction(name: String, callSignature: CallSignature, extendsType: String? = null, needsNoImpl: Boolean = true, additionalAnnotations: List<Annotation> = listOf(), isOverride: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        declarations.add(Function(name, callSignature, extendsType?.let { Type(it) }, annotations, needsNoImpl = needsNoImpl, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier))
    }
}

class TypeScriptToKotlinWalker(
        val packageFqName: String? = null,
        override val defaultAnnotations: List<Annotation> = DEFAULT_ANNOTATION,
        val requiredModifier: SyntaxKind? = DeclareKeyword,
        val moduleName: String? = null,
        typeMapper: ObjectTypeToKotlinTypeMapper? = null,
        val isOwnDeclaration: (PositionedElement) -> Boolean = { true },
        val isOverride: (PositionedElement) -> Boolean,
        val isOverrideProperty: (PositionedElement) -> Boolean
) : TypeScriptToKotlinBase() {

    {
        // TODO drop hack for reset temp class indexer for each file
        if (packageFqName != null) ObjectTypeToKotlinTypeMapperImpl.reset()
    }

    override val result: KotlinFile
        get()  {
            assert(exportedByAssignment.isEmpty(), "exportedByAssignment should be empty, but it contains: $exportedByAssignment")
            return KotlinFile(if (packageFqName != null) Package(packageFqName) else null, declarations)
        }

    override val hasMembersOpenModifier = false

    // TODO fix PrimitiveHashMap for some special keys like 'hasOwnProperty'
    [suppress("CAST_NEVER_SUCCEEDS")]
    val exportedByAssignment = HashMap<Any, Annotation>() as HashMap<String, Annotation>

    val typeMapper = typeMapper ?: ObjectTypeToKotlinTypeMapperImpl(defaultAnnotations, declarations)

    fun addModule(qualifier: List<String>, name: String, members: List<Member>, additionalAnnotations: List<Annotation> = listOf()) {
        val annotations = DEFAULT_MODULE_ANNOTATION + additionalAnnotations
        val module = Classifier(ClassKind.OBJECT, name, listOf(), listOf(), listOf(), members, annotations, hasOpenModifier = false)

        var nestedModules = module

        var i = qualifier.size()
        while (i --> 0) {
            nestedModules = Classifier(ClassKind.OBJECT, qualifier[i], listOf(), listOf(), listOf(), listOf(nestedModules), annotations, hasOpenModifier = false)
        }

        declarations.add(nestedModules)
    }

    fun getAdditionalAnnotations(node: SyntaxNode): List<Annotation> {
        val isShouldSkip = requiredModifier == DeclareKeyword && !node.modifiers.contains(requiredModifier)
        if (isShouldSkip) return DEFAULT_FAKE_ANNOTATION

        return NO_ANNOTATIONS
    }

    override fun visitVariableStatement(node: VariableStatementSyntax) {
        val additionalAnnotations = getAdditionalAnnotations(node)

//      TODO  node.modifiers
//      TODO  test many declarations
        val declarators = node.variableDeclaration.variableDeclarators
        for (d in declarators) {
            val name = d.identifier.getText()
            val varType = d.typeAnnotation?.toKotlinTypeName(typeMapper) ?: ANY
            addVariable(name, varType, additionalAnnotations = additionalAnnotations)
        }
    }

    override fun visitFunctionDeclaration(node: FunctionDeclarationSyntax) {
        val additionalAnnotations = getAdditionalAnnotations(node)

//      TODO  visitList(node.modifiers)
        val name = node.identifier.getText()
        val callSignature = node.callSignature.toKotlinCallSignature(typeMapper)
        addFunction(name, callSignature, additionalAnnotations = additionalAnnotations)
    }

    override fun visitInterfaceDeclaration(node: InterfaceDeclarationSyntax) {
//        // TODO: is it hack?
//        if (requiredModifier != DeclareKeyword && isShouldSkip(node)) return

        if (!isOwnDeclaration(node.identifier)) {
            val translator = TsInterfaceToKtExtensions(typeMapper, annotations = defaultAnnotations, isOverride = isOverride, isOverrideProperty = isOverrideProperty)
            translator.visitInterfaceDeclaration(node)
            declarations.addAll(translator.declarations)
        }
        else {
            val translator = TsInterfaceToKt(typeMapper, annotations = defaultAnnotations, isOverride = isOverride, isOverrideProperty = isOverrideProperty)
            translator.visitInterfaceDeclaration(node)
            declarations.add(translator.result)
        }
    }

    override fun visitClassDeclaration(node: ClassDeclarationSyntax) {
        val additionalAnnotations = getAdditionalAnnotations(node)

        val translator = TsClassToKt(typeMapper, annotations = defaultAnnotations + additionalAnnotations, isOverride = isOverride, isOverrideProperty = isOverrideProperty)
        translator.visitClassDeclaration(node)

        val result = translator.result
        if (result != null) {
            declarations.add(result)
        }
    }

    override fun visitEnumDeclaration(node: EnumDeclarationSyntax) {
        val entries = node.enumElements.map {(entry: EnumElementSyntax) ->
            EnumEntry(entry.propertyName.getText(), entry.equalsValueClause?.value?.getText())
        }

        val enumClass =
                Classifier(ClassKind.ENUM, node.identifier.getText(), listOf(), listOf(), listOf(),
                        entries, listOf(), hasOpenModifier = false)

        declarations.add(enumClass)
    }

    override fun visitModuleDeclaration(node: ModuleDeclarationSyntax) {
        val additionalAnnotations = getAdditionalAnnotations(node)

        val name = when(node.moduleName) {
            null -> { // TODO w/o braces compiler generated wrong code
                node.stringLiteral?.getText() ?: throw Exception("Anonimus module")
            }
            is QualifiedNameSyntax -> {
                node.moduleName.right.getText()
            }
            else  -> {
                node.moduleName.getText()
            }
        }

        val tr =
                TypeScriptToKotlinWalker(
                        moduleName = name,
                        defaultAnnotations = listOf(),
                        requiredModifier = ExportKeyword,
                        isOwnDeclaration = isOwnDeclaration,
                        isOverride = isOverride,
                        isOverrideProperty = isOverrideProperty)

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

        fun INameSyntax.getQualifier(qualifier: MutableList<String>) {
            if (this is QualifiedNameSyntax) {
                this.left.getQualifier(qualifier)
                qualifier.add(this.right.getText())
            }
            else {
                qualifier.add(this.getText())
            }
        }

        fun INameSyntax?.getQualifier(): List<String> {
            if (this !is QualifiedNameSyntax) return listOf()

            val result = ArrayList<String>()
            this.left.getQualifier(result)
            return result
        }
        val qualifier = node.moduleName.getQualifier()

        addModule(qualifier, name, tr.declarations, additionalAnnotations = additionalAnnotations)

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
        declarations.mergeDeclarationsWithSameNameIfNeed()
    }

    fun fixExportAssignments() {
        val found = HashSet<String>()

        for (declaration in declarations) {
            val annotation = exportedByAssignment[declaration.name]
            if (annotation != null) {
                val annotationParamString = annotation.getFirstParamAsString()

                // TODO: fix after KT-5257 will be fixed
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

    fun MutableList<Member>.mergeDeclarationsWithSameNameIfNeed() {
        this.merge({ it !is Function }, COMPARE_BY_NAME) { a, b ->
            val result =
                    when (a) {
                        is Classifier ->
                            when (b) {
                                is Classifier -> mergeClassifiers(a, b)
                                is Variable -> mergeClassifierAndVariable(a, b)
                                else -> throw Exception("Merging ${a.kind} and ??? unsupported yet, a: $a, b: $b")
                            }

                        is Variable ->
                            when (b) {
                                is Classifier -> mergeClassifierAndVariable(b, a)
                                else -> throw Exception("Merging Variable and ??? unsupported yet, a: $a, b: $b")
                            }

                        else ->
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
                if (a.hasModuleAnnotation() && b.isModule()) return mergeClassifierMembers(a, b)
            }
        }

        throw Exception("Merging ${a.kind} and ${b.kind} unsupported yet, a: $a, b: $b")
    }

    fun mergeClassifierAndVariable(a: Classifier, b: Variable): Member {
        if (a.members.isEmpty()) return b

        // TODO is it right?
        assert(a.getClassObject() == null, "Unxpected `class object` when merge Classifier(kind=${a.kind}) and Variable($b)")

        if (a.kind == ClassKind.TRAIT || a.isModule()) {
            val newTrait = Classifier(ClassKind.TRAIT, a.name, a.paramsOfConstructors, a.typeParams, a.parents, a.members, a.annotations, hasOpenModifier = false)

            val varTypeName = b.`type`.name
            val delegation = listOf(Type("${varTypeName} by $NO_IMPL: ${varTypeName}"))

            // TODO drop hacks
            val classObject = Classifier(ClassKind.CLASS_OBJECT, "", listOf(), listOf(), delegation, listOf(), listOf(), hasOpenModifier = false)

            (newTrait.members as ArrayList).add(classObject)

            return newTrait
        }

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
        val classObject = a.getClassObject()

        if (classObject == null) {
            // TODO drop hack
            (a.members as ArrayList).add(Classifier(ClassKind.CLASS_OBJECT, "", listOf(), listOf(), listOf(), b.members, NO_ANNOTATIONS, hasOpenModifier = false))
        }
        else {
            // TODO drop hack
            (classObject.members as ArrayList).addAll(b.members)
            (classObject.members as ArrayList).mergeDeclarationsWithSameNameIfNeed()
        }

        return a
    }

    fun mergeClassifierMembers(a: Classifier, b: Classifier): Classifier {
        // TODO drop hack
        (a.members as ArrayList).addAll(b.members)
        (a.members as ArrayList).mergeDeclarationsWithSameNameIfNeed()
        return a
    }
}

abstract class TsClassifierToKt(val typeMapper: ObjectTypeToKotlinTypeMapper) : TypeScriptToKotlinBase() {
    abstract val needsNoImpl: Boolean

    var parents = ArrayList<Type>()

    override fun visitHeritageClause(node: HeritageClauseSyntax) {
        val containingInInterface = this is TsInterfaceToKt
        val isExtends = node.extendsOrImplementsKeyword.kind() == ExtendsKeyword
        val needParens = !containingInInterface && isExtends

        val types = node.typeNames.map {(id: IIdentifierSyntax) -> Type(id.toKotlinTypeName(typeMapper), needParens) }
        parents.addAll(types)
    }

    override fun visitIndexSignature(node: IndexSignatureSyntax) {
        translateAccessor(node, isGetter = true)
        translateAccessor(node, isGetter = false)
    }

    private fun translateAccessor(node: IndexSignatureSyntax, isGetter: Boolean) {
        val param = node.parameter.toKotlinParam(typeMapper)
        val propType = node.typeAnnotation.toKotlinTypeName(typeMapper)

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

        addFunction(accessorName, callSignature, needsNoImpl = needsNoImpl)
    }
}

open class TsInterfaceToKt(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        val annotations: List<Annotation>,
        val isOverride: (PositionedElement) -> Boolean,
        val isOverrideProperty: (PositionedElement) -> Boolean
) : TsClassifierToKt(typeMapper) {
    override val result: Classifier
        get() = Classifier(ClassKind.TRAIT, name!!, listOf(), typeParams, parents, declarations, annotations, hasOpenModifier = false)

    override val hasMembersOpenModifier = false

    override val needsNoImpl = false

    var name: String? = null
    var typeParams: List<TypeParam>? = null

    override fun visitInterfaceDeclaration(node: InterfaceDeclarationSyntax) {
//      todo visitList(node.modifiers)
        name = node.identifier.getText()
        typeParams = node.typeParameterList?.toKotlinTypeParams(typeMapper)

        visitList(node.heritageClauses)
        visitNode(node.body)
    }

    override fun visitPropertySignature(node: PropertySignatureSyntax) {
        val name = node.propertyName.getText()
        val typeName = node.typeAnnotation?.toKotlinTypeName(typeMapper) ?: ANY
        val isOptional = node.questionToken != null
        val isLambda = node.typeAnnotation?.`type`?.kind() == FunctionType
        val isOverride = isOverrideProperty(node.propertyName)

        addVariable(name, typeName, isNullable = isOptional, isLambda = isLambda, needsNoImpl = isOptional, isOverride = isOverride)
    }

    override fun visitMethodSignature(node: MethodSignatureSyntax) {
        val name = node.propertyName.getText()
        val isOptional = node.questionToken != null

        val isOverride = isOverride(node.propertyName)

        val call = node.callSignature.toKotlinCallSignature(typeMapper)

        if (isOptional) {
            val typeAsString = "(${call.params.join(", ")}) -> ${call.returnType.name}"
            addVariable(name, typeAsString, typeParams = call.typeParams, isVar = false, isNullable = true, isLambda = true, needsNoImpl = true, isOverride = isOverride)
        }
        else {
            addFunction(name, call, needsNoImpl = false, isOverride = isOverride)
        }
    }

    override fun visitCallSignature(node: CallSignatureSyntax) {
        addFunction(INVOKE, node.toKotlinCallSignature(typeMapper), needsNoImpl = false)
    }
}

class TsInterfaceToKtExtensions(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        annotations: List<Annotation>,
        isOverride: (PositionedElement) -> Boolean,
        isOverrideProperty: (PositionedElement) -> Boolean
) : TsInterfaceToKt(typeMapper, annotations, isOverride, isOverrideProperty){

    val cachedExtendsType by lazy { getExtendsType(typeParams) }

    fun getExtendsType(typeParams: List<TypeParam>?) = name!! + (typeParams?.join(startWithIfNotEmpty = "<", endWithIfNotEmpty = ">") ?: "")

    fun List<TypeParam>?.fixIfClashWith(another: List<TypeParam>?): List<TypeParam>? {
        if (this == null || another == null) return this

        assert(!(this identityEquals another), "expected this !== another, this = $this, another = $another")

        val extendsTypeParams = ArrayList<TypeParam>()
        for (e in this) {
            var toAdd = e.name
            var i = 0;
            while (another.any { it.name == toAdd }) toAdd = e.name + i++

            extendsTypeParams.add(TypeParam(toAdd, e.upperBound))
        }

        return extendsTypeParams
    }

    fun List<TypeParam>?.merge(another: List<TypeParam>?): List<TypeParam>? = when {
                this == null -> another
                another == null -> this
                else -> this + another
            }

    fun List<Annotation>.withNativeAnnotation() = when {
                defaultAnnotations.any(IS_NATIVE_ANNOTATION),
                this.any(IS_NATIVE_ANNOTATION) -> {
                    this
                }
                else -> {
                    val list = ArrayList<Annotation>()
                    list.add(NATIVE_ANNOTATION)
                    list.addAll(this)
                    list
                }
            }

    override fun addVariable(name: String, `type`: String, extendsType: String?, typeParams: List<TypeParam>?, isVar: Boolean, isNullable: Boolean, isLambda: Boolean, needsNoImpl: Boolean, additionalAnnotations: List<Annotation>, isOverride: Boolean) {
        val typeParamsWithoutClashes = this.typeParams.fixIfClashWith(typeParams)
        val actualExtendsType = if (typeParamsWithoutClashes identityEquals this.typeParams) cachedExtendsType else getExtendsType(typeParamsWithoutClashes)
        val annotations = additionalAnnotations.withNativeAnnotation()

        super.addVariable(name, `type`, actualExtendsType, typeParamsWithoutClashes merge typeParams, isVar, isNullable, isLambda, true, annotations, isOverride)
    }

    override fun addFunction(name: String, callSignature: CallSignature, extendsType: String?, needsNoImpl: Boolean, additionalAnnotations: List<Annotation>, isOverride: Boolean) {
        val typeParamsWithoutClashes = this.typeParams.fixIfClashWith(callSignature.typeParams)
        val actualExtendsType = if (typeParamsWithoutClashes identityEquals this.typeParams) cachedExtendsType else getExtendsType(typeParamsWithoutClashes)
        val annotations = additionalAnnotations.withNativeAnnotation()

        super.addFunction(name, CallSignature(callSignature.params, typeParamsWithoutClashes merge callSignature.typeParams, callSignature.returnType), actualExtendsType, true, annotations, isOverride)
    }

}

class TsClassToKt(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        val kind: ClassKind = ClassKind.CLASS,
        val annotations: List<Annotation> = DEFAULT_ANNOTATION,
        val isOverride: (PositionedElement) -> Boolean,
        val isOverrideProperty: (PositionedElement) -> Boolean,
        override val hasMembersOpenModifier: Boolean = true
) : TsClassifierToKt(typeMapper) {
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

            return Classifier(kind, name!!, paramsOfConstructors, typeParams, parents, cachedDeclarations!!, annotations, hasOpenModifier = kind == ClassKind.CLASS)
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
                // TODO support override for static members
                staticTranslator = TsClassToKt(typeMapper, ClassKind.CLASS_OBJECT, listOf(), NOT_OVERRIDE, NOT_OVERRIDE, hasMembersOpenModifier = false)
                staticTranslator?.name = ""
            }
            return staticTranslator!!
        }

        return this
    }

    override fun visitClassDeclaration(node: ClassDeclarationSyntax) {
//      todo visitList(node.modifiers)
        name = node.identifier.getText()
        typeParams = node.typeParameterList?.toKotlinTypeParams(typeMapper)

        visitList(node.heritageClauses)
        visitList(node.classElements)
    }

    override fun visitMemberVariableDeclaration(node: MemberVariableDeclarationSyntax) {
        val declarator = node.variableDeclarator

        val name = declarator.identifier.getText()
        val varType = declarator.typeAnnotation?.toKotlinTypeName(typeMapper) ?: ANY
        val isOverride = isOverrideProperty(declarator.identifier)

        getTranslator(node).addVariable(name, varType, isOverride = isOverride)
    }


    override fun visitMemberFunctionDeclaration(node: MemberFunctionDeclarationSyntax) {
        val name = node.propertyName.getText()
        val isOverride = isOverride(node.propertyName)

        getTranslator(node).addFunction(name, node.callSignature.toKotlinCallSignature(typeMapper), isOverride = isOverride)

        assert(node.block == null, "An function in declarations file should not have body, function '${this.name}.$name'")
    }

    override fun visitConstructorDeclaration(node: ConstructorDeclarationSyntax) {
        val params = node.parameterList.toKotlinParams(typeMapper)
        paramsOfConstructors.add(params)

        assert(node.block == null, "A constructor in declarations file should not have body, constructor in '${this.name}")
    }
}
