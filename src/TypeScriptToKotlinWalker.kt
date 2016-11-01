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

import js.JsError
import ts2kt.kotlin.ast.*
import ts2kt.kotlin.ast.Annotation
import ts2kt.kotlin.ast.Function
import ts2kt.utils.assert
import ts2kt.utils.cast
import ts2kt.utils.join
import ts2kt.utils.merge
import typescript.TS

private val NATIVE_ANNOTATION = Annotation(NATIVE)
private val NATIVE_GETTER_ANNOTATION = Annotation("nativeGetter")
private val NATIVE_SETTER_ANNOTATION = Annotation("nativeSetter")
private val NATIVE_INVOKE_ANNOTATION = Annotation("nativeInvoke")
private val NATIVE_NEW_ANNOTATION = Annotation("native(\"new\")")
private val MODULE_ANNOTATION = Annotation(MODULE)
private val DEFAULT_ANNOTATION = listOf(NATIVE_ANNOTATION)
private val DEFAULT_MODULE_ANNOTATION = listOf(MODULE_ANNOTATION)
private val NO_ANNOTATIONS = listOf<Annotation>()
private val INVOKE = "invoke"
private val GET = "get"
private val SET = "set"

private val COMPARE_BY_NAME = { a: Named, b: Named -> a.name == b.name }
private val IS_NATIVE_ANNOTATION = { a: Annotation -> a.name == NATIVE }

abstract class TypeScriptToKotlinBase : Visitor {
    abstract val result: Node?
    abstract val hasMembersOpenModifier: Boolean
    abstract val isInterface: Boolean

    open val defaultAnnotations: List<Annotation> = listOf()

    val declarations = arrayListOf<Member>()
    val typesByTypeAlias = mutableMapOf<String,TS.TypeNode>()

    open fun addVariable(name: String, type: Type, extendsType: String? = null, typeParams: List<TypeParam>? = null, isVar: Boolean = true, needsNoImpl: Boolean = true, additionalAnnotations: List<Annotation> = listOf(), isOverride: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        declarations.add(Variable(name, TypeAnnotation(type), extendsType?.let { HeritageType(it) }, annotations, typeParams, isVar = isVar, needsNoImpl = needsNoImpl, isInInterface = isInterface, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier))
    }

    open fun addFunction(name: String, callSignature: CallSignature, extendsType: String? = null, needsNoImpl: Boolean = true, additionalAnnotations: List<Annotation> = listOf(), isOverride: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        declarations.add(Function(name, callSignature, extendsType?.let { HeritageType(it) }, annotations, needsNoImpl = needsNoImpl, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier))
    }

    // TODO
    open fun visitList(node: TS.Node) {
        forEachChild(this, node)
    }
}

class TypeScriptToKotlinWalker(
        val packageFqName: String? = null,
        override val defaultAnnotations: List<Annotation> = DEFAULT_ANNOTATION,
        val requiredModifier: TS.SyntaxKind? = TS.SyntaxKind.DeclareKeyword,
        val moduleName: String? = null,
        typeMapper: ObjectTypeToKotlinTypeMapper? = null,
        override val isInterface: Boolean = false,
        val isOwnDeclaration: (TS.Node) -> Boolean = { true },
        val isOverride: (TS.MethodDeclaration) -> Boolean,
        val isOverrideProperty: (TS.PropertyDeclaration) -> Boolean
) : TypeScriptToKotlinBase() {

    init {
        // TODO drop hack for reset temp class indexer for each file
        if (packageFqName != null) ObjectTypeToKotlinTypeMapperImpl.reset()
    }

    private val typeParameterDeclarations = mutableListOf<TS.TypeParameterDeclaration>()

    override val result: KotlinFile
        get()  {
            assert(exportedByAssignment.isEmpty(), "exportedByAssignment should be empty, but it contains: ${exportedByAssignment.keys.toString()}")
            return KotlinFile(if (packageFqName != null) Package(packageFqName) else null, declarations)
        }

    override val hasMembersOpenModifier = false

    val exportedByAssignment = hashMapOf<String, Annotation>()

    val typeMapper = typeMapper ?: ObjectTypeToKotlinTypeMapperImpl(defaultAnnotations, declarations, typesByTypeAlias, typeParameterDeclarations)

    fun addModule(qualifier: List<String>, name: String, members: List<Member>, additionalAnnotations: List<Annotation> = listOf()) {
        val annotations = DEFAULT_MODULE_ANNOTATION + additionalAnnotations
        val module = Classifier(ClassKind.OBJECT, name, listOf(), listOf(), listOf(), members, annotations, hasOpenModifier = false)

        var nestedModules = module

        var i = qualifier.size
        while (i --> 0) {
            nestedModules = Classifier(ClassKind.OBJECT, qualifier[i], listOf(), listOf(), listOf(), listOf(nestedModules), annotations, hasOpenModifier = false)
        }

        declarations.add(nestedModules)
    }

    fun getAdditionalAnnotations(node: TS.Node): List<Annotation> {
        val isShouldSkip = requiredModifier === TS.SyntaxKind.DeclareKeyword && !(node.modifiers?.arr?.any { it.kind === requiredModifier } ?: false )
        if (isShouldSkip) return DEFAULT_FAKE_ANNOTATION

        return NO_ANNOTATIONS
    }

    override fun visitTypeAliasDeclaration(node: TS.TypeAliasDeclaration) {
        typesByTypeAlias.put(node.identifierName.text, node.type)
    }

    override fun visitVariableStatement(node: TS.VariableStatement) {
        val additionalAnnotations = getAdditionalAnnotations(node)

//      TODO  node.modifiers
//      TODO  test many declarations
        val declarations = node.declarationList.declarations.arr
        for (d in declarations) {
            val name = d.declarationName!!.unescapedText
            val varType = d.type?.toKotlinType(typeMapper) ?: Type(ANY)
            addVariable(name, varType, additionalAnnotations = additionalAnnotations)
        }
    }

    override fun visitFunctionDeclaration(node: TS.FunctionDeclaration) {
        val additionalAnnotations = getAdditionalAnnotations(node)

//      TODO  visitList(node.modifiers)
        val name = node.propertyName!!.unescapedText
        node.toKotlinCallSignatureOverloads(typeMapper).forEach { callSignature ->
            addFunction(name, callSignature, additionalAnnotations = additionalAnnotations)
        }
    }

    override fun visitInterfaceDeclaration(node: TS.InterfaceDeclaration) {
//        // TODO: is it hack?
//        if (requiredModifier != DeclareKeyword && isShouldSkip(node)) return

        if (!isOwnDeclaration(node.identifierName)) {
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

    override fun visitClassDeclaration(node: TS.ClassDeclaration) {
        val additionalAnnotations = getAdditionalAnnotations(node)

        val translator = TsClassToKt(typeMapper, annotations = defaultAnnotations + additionalAnnotations, isOverride = isOverride, isOverrideProperty = isOverrideProperty)
        translator.visitClassDeclaration(node)

        val result = translator.result
        if (result != null) {
            declarations.add(result)
        }
    }

    override fun visitEnumDeclaration(node: TS.EnumDeclaration) {
        val entries = node.members.arr.map { entry ->
            EnumEntry(entry.declarationName.unescapedText, entry.initializer?.let{
                when (it.kind) {
                    TS.SyntaxKind.FirstLiteralToken -> (it.cast<TS.LiteralExpression>()).text
                    else -> unsupportedNode(it)
                }
            })
        }

        val enumClass =
                Classifier(ClassKind.ENUM, node.identifierName.unescapedText, listOf(), listOf(), listOf(),
                        entries, listOf(), hasOpenModifier = false)

        declarations.add(enumClass)
    }

    override fun visitModuleDeclaration(node: TS.ModuleDeclaration) {
        val additionalAnnotations = getAdditionalAnnotations(node)

        fun getName(node: TS.ModuleDeclaration): String {
            return when(node.declarationName!!.kind) {
                TS.SyntaxKind.Identifier,
                TS.SyntaxKind.StringLiteral -> node.declarationName!!.unescapedText

                else -> unsupportedNode(node.declarationName!!)
            }
        }

        var rightNode = node
        var body = node.body
        val qualifier = arrayListOf<String>()
        while (body.kind !== TS.SyntaxKind.ModuleBlock) {
            assert(body.kind === TS.SyntaxKind.ModuleDeclaration, "Expected that it is ModuleDeclaration, but ${body.kind.str}")

            qualifier.add(getName(rightNode))

            rightNode = body
            body = body.body
        }

        val name = getName(rightNode)

        val tr =
                TypeScriptToKotlinWalker(
                        moduleName = name,
                        defaultAnnotations = listOf(),
                        requiredModifier = TS.SyntaxKind.ExportKeyword,
                        isOwnDeclaration = isOwnDeclaration,
                        isOverride = isOverride,
                        isOverrideProperty = isOverrideProperty)

        tr.visitList(body)

        val isExternalModule = rightNode.declarationName!!.kind === TS.SyntaxKind.StringLiteral

        if (isExternalModule && tr.exportedByAssignment.isEmpty()) {
            val areAllFakeOrInterface = tr.declarations.all {
                it.annotations.any { it == FAKE_ANNOTATION } ||
                (it is Classifier && it.kind === ClassKind.INTERFACE && it.annotations.all { it.name != MODULE })
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
                if (tr.declarations.size == 1 && tr.declarations[0] is Variable) {
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

        addModule(qualifier, name, tr.declarations, additionalAnnotations = additionalAnnotations)

        exportedByAssignment.putAll(tr.exportedByAssignment)
    }

    override fun visitExportAssignment(node: TS.ExportAssignment) {
        // TODO is it right?
        val exportName =
                node.identifierName?.unescapedText ?:
                        run {
                            if (node.expression.kind == TS.SyntaxKind.Identifier)
                                (node.expression.cast<TS.Identifier>()).text
                            else
                                unsupportedNode(node)
                        }

        exportedByAssignment[exportName] =
                Annotation(MODULE, if (moduleName == null) listOf() else listOf(Argument(value = "\"$moduleName\"")))
    }

    override fun visitList(node: TS.Node) {
        super<TypeScriptToKotlinBase>.visitList(node)
        // TODO: Is it good place for call finish?
        finish()
    }

    fun finish() {
        fixExportAssignments()
        declarations.mergeDeclarationsWithSameNameIfNeed()
    }

    fun fixExportAssignments() {
        val found = hashSetOf<String>()

        overDeclarations@
        for (declaration in declarations) {
            val annotation = exportedByAssignment[declaration.name]
            if (annotation != null) {
                val annotationParamString = annotation.getFirstParamAsString()

                // TODO: fix this HACK
                val t = arrayListOf<Annotation>()
                for (a in declaration.annotations) {
                    if (a == FAKE_ANNOTATION) continue

                    if (a.name == MODULE) {
                        if (declaration.name == annotationParamString) continue@overDeclarations

                        continue
                    }

                    t.add(a)
                }

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
                                else -> throw JsError("Merging ${a.kind} and ??? unsupported yet, a: $a, b: $b")
                            }

                        is Variable ->
                            when (b) {
                                is Classifier -> mergeClassifierAndVariable(b, a)
                                else -> throw JsError("Merging Variable and ??? unsupported yet, a: $a, b: $b")
                            }

                        else ->
                            throw JsError("Unsupported types for merging, a: $a, b: $b")
                    }


            result.annotations = mergeAnnotations(a.annotations, b.annotations)

            result
        }
    }

    fun mergeClassifiers(a: Classifier, b: Classifier): Classifier {
        when (a.kind) {
             ClassKind.CLASS -> {
                if (b.kind === ClassKind.OBJECT) return mergeClassAndObject(a, b)
            }
            ClassKind.INTERFACE -> {
                if (b.kind === ClassKind.OBJECT) return mergeClassAndObject(a, b)
                if (b.kind === ClassKind.INTERFACE) return mergeClassifierMembers(a, b)
            }
            ClassKind.OBJECT -> {
                if (b.kind === ClassKind.CLASS || b.kind === ClassKind.INTERFACE) return mergeClassAndObject(b, a)
                if (a.hasModuleAnnotation() && b.isModule()) return mergeClassifierMembers(a, b)
            }
            else -> {} // TODO is it bug?
        }

        throw JsError("Merging ${a.kind} and ${b.kind} unsupported yet, a: $a, b: $b")
    }

    fun mergeClassifierAndVariable(a: Classifier, b: Variable): Member {
        if (a.members.isEmpty()) return b

        // TODO is it right?
        assert(a.getClassObject() == null, "Unxpected `class object` when merge Classifier(kind=${a.kind}) and Variable($b)")

        if (a.kind === ClassKind.INTERFACE || a.isModule()) {
            val newTrait = Classifier(ClassKind.INTERFACE, a.name, a.paramsOfConstructors, a.typeParams, a.parents, a.members, a.annotations, hasOpenModifier = false)

            val varTypeName = b.type.type.stringify()
            val delegation = listOf(HeritageType("${varTypeName} by $NO_IMPL: ${varTypeName}"))

            // TODO drop hacks
            val classObject = Classifier(ClassKind.COMPANION_OBJECT, "", listOf(), listOf(), delegation, listOf(), listOf(), hasOpenModifier = false)

            newTrait.addMember(classObject)

            return newTrait
        }

        throw JsError("Merging non-empty Classifier(kind=${a.kind}) and Variable unsupported yet, a: $a, b: $b")
    }

    fun mergeAnnotations(a: List<Annotation>, b: List<Annotation>): List<Annotation> =
            if (a.isEmpty()) {
                b
            }
            else if (b.isEmpty()) {
                a
            }
            else {
                val merged = arrayListOf<Annotation>()
                merged.addAll(a)
                merged.addAll(b)

                merged.merge({ true }, COMPARE_BY_NAME) { a, b ->
                    when {
                        a.parameters.isEmpty() -> b
                        b.parameters.isEmpty() -> a
                        a.parameters == b.parameters -> a
                        // TODO
                        else -> throw JsError("Merging annotations with different arguments unsupported yet, a: $a, b: $b")
                    }
                }

                merged
            }

    fun mergeClassAndObject(a: Classifier, b: Classifier): Classifier {
        val classObject = a.getClassObject()

        if (classObject == null) {
            // TODO drop hack
            a.addMember(Classifier(ClassKind.COMPANION_OBJECT, "", listOf(), listOf(), listOf(), b.members, NO_ANNOTATIONS, hasOpenModifier = false))
        }
        else {
            // TODO drop hack
            classObject.addMembersFrom(b)
        }

        return a
    }

    fun mergeClassifierMembers(a: Classifier, b: Classifier): Classifier {
        // TODO drop hack
        a.addMembersFrom(b)
        return a
    }

    private fun Classifier.addMembersFrom(another: Classifier) {
        val members = members as MutableList
        members.addAll(another.members)
        members.mergeDeclarationsWithSameNameIfNeed()
    }

    private fun Classifier.addMember(member: Member) {
        (members as MutableList).add(member)
    }
}

abstract class TsClassifierToKt(
        val typeMapper: ObjectTypeToKotlinTypeMapper,
        val isOverride: (TS.MethodDeclaration) -> Boolean,
        val isOverrideProperty: (TS.PropertyDeclaration) -> Boolean
) : TypeScriptToKotlinBase() {
    abstract val needsNoImpl: Boolean

    var parents = arrayListOf<HeritageType>()

    override fun visitHeritageClause(node: TS.HeritageClause) {
        val containingInInterface = this is TsInterfaceToKt
        val isExtends = node.token === TS.SyntaxKind.ExtendsKeyword
        val needParens = !containingInInterface && isExtends

        val types = node.types?.arr?.map { id -> HeritageType(id.toKotlinType(typeMapper).stringify(), needParens) } ?: listOf()
        parents.addAll(types)
    }

    override fun visitIndexSignature(node: TS.IndexSignatureDeclaration) {
        translateAccessor(node, isGetter = true)
        translateAccessor(node, isGetter = false)
    }

    private fun translateAccessor(node: TS.IndexSignatureDeclaration, isGetter: Boolean) {
        // TODO type params?
        node.parameters.toKotlinParamsOverloads(typeMapper).forEach { params ->
            val propTypeOverloads = if (isGetter) {
                listOf(node.type?.toKotlinType(typeMapper) ?: Type(ANY))
            } else {
                node.type?.toKotlinTypeOverloads(typeMapper) ?: listOf(Type(ANY))
            }
            propTypeOverloads.forEach { propType ->
                val callSignature: CallSignature
                val accessorName: String
                val annotation: Annotation
                if (isGetter) {
                    // per Kotlin, all @nativeGetter's must be nullable
                    callSignature = CallSignature(params, listOf(), TypeAnnotation(propType.copy(isNullable = true)))
                    accessorName = GET
                    annotation = NATIVE_GETTER_ANNOTATION
                }
                else {
                    callSignature = CallSignature(listOf(params[0], FunParam("value", TypeAnnotation(propType))), listOf(), TypeAnnotation(Type(UNIT)))
                    accessorName = SET
                    annotation = NATIVE_SETTER_ANNOTATION
                }

                addFunction(accessorName, callSignature, needsNoImpl = needsNoImpl, additionalAnnotations = listOf(annotation))
            }
        }
    }

    var name: String? = null

    var staticTranslator: TsClassToKt? = null

    ///???
    // TODO should be abstract? is static declarations inside (TS) interfaces allowed?
    fun getTranslator(node: TS.ClassElement): TsClassifierToKt {
        if (node.modifiers?.arr?.any { it.kind === TS.SyntaxKind.StaticKeyword } ?: false) {
            if (staticTranslator == null) {
                // TODO support override for static members
                staticTranslator = TsClassToKt(typeMapper, ClassKind.COMPANION_OBJECT, listOf(), NOT_OVERRIDE, NOT_OVERRIDE, hasMembersOpenModifier = false)
                staticTranslator?.name = ""
            }
            return staticTranslator!!
        }

        return this
    }

    open fun needsNoImpl(node: TS.PropertyDeclaration): Boolean = true
    open fun isNullable(node: TS.PropertyDeclaration): Boolean = false
    open fun isLambda(node: TS.PropertyDeclaration): Boolean = false

    open fun needsNoImpl(node: TS.MethodDeclaration): Boolean = true

    override fun visitPropertyDeclaration(node: TS.PropertyDeclaration) {
        val declarationName = node.propertyName!!

        val name = declarationName.unescapedText
        val varType = node.type?.toKotlinType(typeMapper) ?: Type(ANY)

        val isOverride = isOverrideProperty(node)

        getTranslator(node).addVariable(name, type = varType.copy(isNullable = isNullable(node), isLambda = isLambda(node)),
                isOverride = isOverride,
                needsNoImpl = needsNoImpl(node)
        )
    }

    open fun TsClassifierToKt.addFunction(name: String, isOverride: Boolean, needsNoImpl: Boolean, node: TS.MethodDeclaration) {
        node.toKotlinCallSignatureOverloads(typeMapper).forEach { callSignature ->
            addFunction(name, callSignature, isOverride = isOverride, needsNoImpl = needsNoImpl(node))
        }

        assert(node.body == null, "An function in declarations file should not have body, function '${this.name}.$name'")
    }

    override fun visitMethodDeclaration(node: TS.MethodDeclaration) {
        val declarationName = node.propertyName!!
        val name = declarationName.unescapedText
        val isOverride = isOverride(node)

        getTranslator(node).addFunction(name, isOverride, needsNoImpl, node)
    }
}

open class TsInterfaceToKt(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        val annotations: List<Annotation>,
        isOverride: (TS.MethodDeclaration) -> Boolean,
        isOverrideProperty: (TS.PropertyDeclaration) -> Boolean
) : TsClassifierToKt(typeMapper, isOverride, isOverrideProperty) {
    override val result: Classifier
        get() = Classifier(ClassKind.INTERFACE, name!!, listOf(), typeParams, parents, declarations, annotations, hasOpenModifier = false)

    override val hasMembersOpenModifier = false

    override val needsNoImpl = false

    override val isInterface: Boolean = true

    var typeParams: List<TypeParam>? = null

    override fun needsNoImpl(node: TS.PropertyDeclaration) = node.questionToken != null
    override fun isNullable(node: TS.PropertyDeclaration) = node.questionToken != null
    override fun isLambda(node: TS.PropertyDeclaration) = node.type?.kind === TS.SyntaxKind.FunctionType

    override fun needsNoImpl(node: TS.MethodDeclaration) = false
    override fun TsClassifierToKt.addFunction(name: String, isOverride: Boolean, needsNoImpl: Boolean, node: TS.MethodDeclaration) {
        val isOptional = node.questionToken != null
        if (isOptional) {
            val call = node.toKotlinCallSignature(typeMapper)
            val typeAsString = "(${call.params.join(", ")}) -> ${call.returnType.type.stringify()}"
            addVariable(name, type = Type(typeAsString, isNullable = true, isLambda = true), typeParams = call.typeParams, isVar = false, needsNoImpl = true, isOverride = isOverride)
        }
        else {
            node.toKotlinCallSignatureOverloads(typeMapper).forEach { call ->
                addFunction(name, call, needsNoImpl = false, isOverride = isOverride)
            }
        }

    }

    override fun visitInterfaceDeclaration(node: TS.InterfaceDeclaration) {
//      todo visitList(node.modifiers)
        name = node.identifierName.unescapedText
        typeParams = node.typeParameters?.toKotlinTypeParams(typeMapper)

        // TODO merge with class?
        node.heritageClauses?.arr?.forEach { visitNode(this, it) }
        node.members.arr.forEach { visitNode(this, it) }
    }

    override fun visitSignatureDeclaration(node: TS.SignatureDeclaration) {
        node.toKotlinCallSignatureOverloads(typeMapper).forEach { callSignature ->
            addFunction(INVOKE, callSignature, needsNoImpl = false, additionalAnnotations = listOf(NATIVE_INVOKE_ANNOTATION))
        }
    }

    override fun visitConstructSignatureDeclaration(node: TS.ConstructorDeclaration) {
        node.toKotlinCallSignatureOverloads(typeMapper).forEach { callSignature ->
            addFunction(INVOKE, callSignature, needsNoImpl = false, additionalAnnotations = listOf(NATIVE_NEW_ANNOTATION))
        }
    }
}

class TsInterfaceToKtExtensions(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        annotations: List<Annotation>,
        isOverride: (TS.MethodDeclaration) -> Boolean,
        isOverrideProperty: (TS.PropertyDeclaration) -> Boolean
) : TsInterfaceToKt(typeMapper, annotations, isOverride, isOverrideProperty){

    val cachedExtendsType by lazy { getExtendsType(typeParams) }

    fun getExtendsType(typeParams: List<TypeParam>?) = name!! + (typeParams?.join(startWithIfNotEmpty = "<", endWithIfNotEmpty = ">") ?: "")

    fun List<TypeParam>?.fixIfClashWith(another: List<TypeParam>?): List<TypeParam>? {
        if (this == null || another == null) return this

        assert(!(this === another), "expected this !== another, this = $this, another = $another")

        val extendsTypeParams = arrayListOf<TypeParam>()
        for (e in this) {
            var toAdd = e.name
            var i = 0
            while (another.any { it.name == toAdd }) toAdd = e.name + i++

            extendsTypeParams.add(TypeParam(toAdd, e.upperBound))
        }

        return extendsTypeParams
    }

    infix fun List<TypeParam>?.merge(another: List<TypeParam>?): List<TypeParam>? = when {
                this == null -> another
                another == null -> this
                else -> this + another
            }

    fun List<Annotation>.withNativeAnnotation() = when {
                defaultAnnotations.any(IS_NATIVE_ANNOTATION) || this.any(IS_NATIVE_ANNOTATION) -> {
                    this
                }
                else -> {
                    val list = arrayListOf<Annotation>()
                    list.add(NATIVE_ANNOTATION)
                    list.addAll(this)
                    list
                }
            }

    override fun addVariable(name: String, type: Type, extendsType: String?, typeParams: List<TypeParam>?, isVar: Boolean, needsNoImpl: Boolean, additionalAnnotations: List<Annotation>, isOverride: Boolean) {
        val typeParamsWithoutClashes = this.typeParams.fixIfClashWith(typeParams)
        val actualExtendsType = if (typeParamsWithoutClashes === this.typeParams) cachedExtendsType else getExtendsType(typeParamsWithoutClashes)
        val annotations = additionalAnnotations.withNativeAnnotation()

        super.addVariable(name, type, actualExtendsType, typeParamsWithoutClashes merge typeParams, isVar,
                needsNoImpl = true, additionalAnnotations = annotations, isOverride = isOverride)
    }

    override fun addFunction(name: String, callSignature: CallSignature, extendsType: String?, needsNoImpl: Boolean, additionalAnnotations: List<Annotation>, isOverride: Boolean) {
        val typeParamsWithoutClashes = this.typeParams.fixIfClashWith(callSignature.typeParams)
        val actualExtendsType = if (typeParamsWithoutClashes === this.typeParams) cachedExtendsType else getExtendsType(typeParamsWithoutClashes)
        val annotations = additionalAnnotations.withNativeAnnotation()

        super.addFunction(name, CallSignature(callSignature.params, typeParamsWithoutClashes merge callSignature.typeParams, callSignature.returnType), actualExtendsType, true, annotations, isOverride)
    }

}

class TsClassToKt(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        val kind: ClassKind = ClassKind.CLASS,
        val annotations: List<Annotation> = DEFAULT_ANNOTATION,
        isOverride: (TS.MethodDeclaration) -> Boolean,
        isOverrideProperty: (TS.PropertyDeclaration) -> Boolean,
        override val hasMembersOpenModifier: Boolean = true
) : TsClassifierToKt(typeMapper, isOverride, isOverrideProperty) {
    override val result: Classifier?
        get()  {
            if (name == null) return null

            if (cachedDeclarations == null) {
                cachedDeclarations =
                        if (staticTranslator == null) {
                            declarations
                        } else {
                            val t = arrayListOf<Member>()
                            t.addAll(declarations)
                            t.add(staticTranslator!!.result!!)
                            t
                        }
            }

            return Classifier(kind, name!!, paramsOfConstructors, typeParams, parents, cachedDeclarations!!, annotations, hasOpenModifier = kind === ClassKind.CLASS)
        }

    var cachedDeclarations: List<Member>? = null

    override val needsNoImpl = true

    override val isInterface = false

    var typeParams: List<TypeParam>? = null
    val paramsOfConstructors = arrayListOf<List<FunParam>>()

    override fun visitClassDeclaration(node: TS.ClassDeclaration) {
//      todo visitList(node.modifiers)
        name = node.identifierName!!.unescapedText
        typeParams = node.typeParameters?.toKotlinTypeParams(typeMapper)

        node.heritageClauses?.arr?.forEach { visitNode(this, it) }
        node.members.arr.forEach { visitNode(this, it) }
    }

    override fun visitConstructorDeclaration(node: TS.ConstructorDeclaration) {
        val paramsOverloads = node.parameters.toKotlinParamsOverloads(typeMapper)
        paramsOfConstructors.addAll(paramsOverloads)

        assert(node.body == null, "A constructor in declarations file should not have body, constructor in '${this.name}")
    }
}
