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
import ts2kt.kotlin.ast
import kotlin.properties.Delegates
import java.util.ArrayList
import java.util.HashSet
import java.util.HashMap

private val NATIVE_ANNOTATION = ast.Annotation(NATIVE)
private val NATIVE_GETTER_ANNOTATION = ast.Annotation("nativeGetter")
private val NATIVE_SETTER_ANNOTATION = ast.Annotation("nativeSetter")
private val NATIVE_INVOKE_ANNOTATION = ast.Annotation("nativeInvoke")
private val MODULE_ANNOTATION = ast.Annotation(MODULE)
private val DEFAULT_ANNOTATION = listOf(NATIVE_ANNOTATION)
private val DEFAULT_MODULE_ANNOTATION = listOf(MODULE_ANNOTATION)
private val NO_ANNOTATIONS = listOf<ast.Annotation>()
private val INVOKE = "invoke"
private val GET = "get"
private val SET = "set"

private val COMPARE_BY_NAME = { (a: Named, b: Named) -> a.name == b.name }
private val IS_NATIVE_ANNOTATION = { (a: ast.Annotation) -> a.name == NATIVE }


abstract class TypeScriptToKotlinBase : Visitor {
    abstract val result: Node?
    abstract val hasMembersOpenModifier: Boolean

    open val defaultAnnotations: List<ast.Annotation> = listOf()

    val declarations = ArrayList<Member>()

    open fun addVariable(name: String, type: String, extendsType: String? = null, typeParams: List<TypeParam>? = null, isVar: Boolean = true, isNullable: Boolean = false, isLambda: Boolean = false, needsNoImpl: Boolean = true, additionalAnnotations: List<ast.Annotation> = listOf(), isOverride: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        declarations.add(Variable(name, TypeAnnotation(type, isNullable = isNullable, isLambda = isLambda), extendsType?.let { Type(it) }, annotations, typeParams, isVar = isVar, needsNoImpl = needsNoImpl, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier))
    }

    open fun addFunction(name: String, callSignature: CallSignature, extendsType: String? = null, needsNoImpl: Boolean = true, additionalAnnotations: List<ast.Annotation> = listOf(), isOverride: Boolean = false) {
        val annotations = defaultAnnotations + additionalAnnotations
        declarations.add(Function(name, callSignature, extendsType?.let { Type(it) }, annotations, needsNoImpl = needsNoImpl, isOverride = isOverride, hasOpenModifier = hasMembersOpenModifier))
    }

    // TODO
    open fun visitList(node: TS.Node) {
        forEachChild(this, node)
    }
}

class TypeScriptToKotlinWalker(
        val packageFqName: String? = null,
        override val defaultAnnotations: List<ast.Annotation> = DEFAULT_ANNOTATION,
        val requiredModifier: TS.SyntaxKind? = TS.SyntaxKind.DeclareKeyword,
        val moduleName: String? = null,
        typeMapper: ObjectTypeToKotlinTypeMapper? = null,
        val isOwnDeclaration: (TS.Node) -> Boolean = { true },
        val isOverride: (TS.MethodDeclaration) -> Boolean,
        val isOverrideProperty: (TS.PropertyDeclaration) -> Boolean
) : TypeScriptToKotlinBase() {

    {
        // TODO drop hack for reset temp class indexer for each file
        if (packageFqName != null) ObjectTypeToKotlinTypeMapperImpl.reset()
    }

    override val result: KotlinFile
        get()  {
            assert(exportedByAssignment.isEmpty(), "exportedByAssignment should be empty, but it contains: ${exportedByAssignment.keySet().toString()}")
            return KotlinFile(if (packageFqName != null) Package(packageFqName) else null, declarations)
        }

    override val hasMembersOpenModifier = false

    // TODO fix PrimitiveHashMap for some special keys like 'hasOwnProperty'
    [suppress("CAST_NEVER_SUCCEEDS")]
    val exportedByAssignment = HashMap<Any, ast.Annotation>() as HashMap<String, ast.Annotation>

    val typeMapper = typeMapper ?: ObjectTypeToKotlinTypeMapperImpl(defaultAnnotations, declarations)

    fun addModule(qualifier: List<String>, name: String, members: List<Member>, additionalAnnotations: List<ast.Annotation> = listOf()) {
        val annotations = DEFAULT_MODULE_ANNOTATION + additionalAnnotations
        val module = Classifier(ClassKind.OBJECT, name, listOf(), listOf(), listOf(), members, annotations, hasOpenModifier = false)

        var nestedModules = module

        var i = qualifier.size()
        while (i --> 0) {
            nestedModules = Classifier(ClassKind.OBJECT, qualifier[i], listOf(), listOf(), listOf(), listOf(nestedModules), annotations, hasOpenModifier = false)
        }

        declarations.add(nestedModules)
    }

    fun getAdditionalAnnotations(node: TS.Node): List<ast.Annotation> {
        val isShouldSkip = requiredModifier === TS.SyntaxKind.DeclareKeyword && !(node.modifiers?.arr?.any { it.kind === requiredModifier } ?: false )
        if (isShouldSkip) return DEFAULT_FAKE_ANNOTATION

        return NO_ANNOTATIONS
    }

    override fun visitVariableStatement(node: TS.VariableStatement) {
        val additionalAnnotations = getAdditionalAnnotations(node)

//      TODO  node.modifiers
//      TODO  test many declarations
        val declarators = node.declarations.arr
        for (d in declarators) {
            val name = d.name.text
            val varType = d.type?.toKotlinTypeName(typeMapper) ?: ANY
            addVariable(name, varType, additionalAnnotations = additionalAnnotations)
        }
    }

    override fun visitFunctionDeclaration(node: TS.FunctionDeclaration) {
        val additionalAnnotations = getAdditionalAnnotations(node)

//      TODO  visitList(node.modifiers)
        val name = node.name.text
        val callSignature = node.toKotlinCallSignature(typeMapper)
        addFunction(name, callSignature, additionalAnnotations = additionalAnnotations)
    }

    override fun visitInterfaceDeclaration(node: TS.InterfaceDeclaration) {
//        // TODO: is it hack?
//        if (requiredModifier != DeclareKeyword && isShouldSkip(node)) return

        if (!isOwnDeclaration(node.name)) {
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
            EnumEntry(entry.declarationName.text, entry.initializer?.let{
                when (it.kind) {
                    TS.SyntaxKind.FirstLiteralToken -> (it as TS.LiteralExpression).text
                    else -> unsupportedNode(it)
                }
            })
        }

        val enumClass =
                Classifier(ClassKind.ENUM, node.name.text, listOf(), listOf(), listOf(),
                        entries, listOf(), hasOpenModifier = false)

        declarations.add(enumClass)
    }

    override fun visitModuleDeclaration(node: TS.ModuleDeclaration) {
        val additionalAnnotations = getAdditionalAnnotations(node)

        fun getName(node: TS.ModuleDeclaration): String {
            return when(node.name.kind) {
                TS.SyntaxKind.Identifier,
                TS.SyntaxKind.StringLiteral -> node.name.text

                else -> unsupportedNode(node.name)
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

        val isExternalModule = rightNode.name.kind === TS.SyntaxKind.StringLiteral

        if (isExternalModule && tr.exportedByAssignment.isEmpty()) {
            val areAllFakeOrInterface = tr.declarations.all {
                it.annotations.any { it == FAKE_ANNOTATION } ||
                (it is Classifier && it.kind === ClassKind.TRAIT && it.annotations.all { it.name != MODULE })
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

        addModule(qualifier, name, tr.declarations, additionalAnnotations = additionalAnnotations)

        exportedByAssignment.putAll(tr.exportedByAssignment)
    }

    override fun visitExportAssignment(node: TS.ExportAssignment) {
        exportedByAssignment[node.exportName.text] =
                ast.Annotation(MODULE, if (moduleName == null) listOf() else listOf(Argument(value = "\"$moduleName\"")))
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
        val found = HashSet<String>()

        for (declaration in declarations) {
            val annotation = exportedByAssignment[declaration.name]
            if (annotation != null) {
                val annotationParamString = annotation.getFirstParamAsString()

                // TODO: fix after KT-5257 will be fixed
                var needContinue = false;
                // TODO: fix this HACK
                val t = ArrayList<ast.Annotation>(declaration.annotations.size() + 1)
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
                if (b.kind === ClassKind.OBJECT) return mergeClassAndObject(a, b)
            }
            ClassKind.TRAIT -> {
                if (b.kind === ClassKind.OBJECT) return mergeClassAndObject(a, b)
                if (b.kind === ClassKind.TRAIT) return mergeClassifierMembers(a, b)
            }
            ClassKind.OBJECT -> {
                if (b.kind === ClassKind.CLASS || b.kind === ClassKind.TRAIT) return mergeClassAndObject(b, a)
                if (a.hasModuleAnnotation() && b.isModule()) return mergeClassifierMembers(a, b)
            }
        }

        throw Exception("Merging ${a.kind} and ${b.kind} unsupported yet, a: $a, b: $b")
    }

    fun mergeClassifierAndVariable(a: Classifier, b: Variable): Member {
        if (a.members.isEmpty()) return b

        // TODO is it right?
        assert(a.getClassObject() == null, "Unxpected `class object` when merge Classifier(kind=${a.kind}) and Variable($b)")

        if (a.kind === ClassKind.TRAIT || a.isModule()) {
            val newTrait = Classifier(ClassKind.TRAIT, a.name, a.paramsOfConstructors, a.typeParams, a.parents, a.members, a.annotations, hasOpenModifier = false)

            val varTypeName = b.type.name
            val delegation = listOf(Type("${varTypeName} by $NO_IMPL: ${varTypeName}"))

            // TODO drop hacks
            val classObject = Classifier(ClassKind.CLASS_OBJECT, "", listOf(), listOf(), delegation, listOf(), listOf(), hasOpenModifier = false)

            newTrait.addMember(classObject)

            return newTrait
        }

        throw Exception("Merging non-empty Classifier(kind=${a.kind}) and Variable unsupported yet, a: $a, b: $b")
    }

    fun mergeAnnotations(a: List<ast.Annotation>, b: List<ast.Annotation>): List<ast.Annotation> =
            if (a.isEmpty()) {
                b
            }
            else if (b.isEmpty()) {
                a
            }
            else {
                val merged = ArrayList<ast.Annotation>()
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
            a.addMember(Classifier(ClassKind.CLASS_OBJECT, "", listOf(), listOf(), listOf(), b.members, NO_ANNOTATIONS, hasOpenModifier = false))
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
        val members = members as ArrayList
        members.addAll(another.members)
        members.mergeDeclarationsWithSameNameIfNeed()
    }

    private fun Classifier.addMember(member: Member) {
        (members as ArrayList).add(member)
    }
}

abstract class TsClassifierToKt(
        val typeMapper: ObjectTypeToKotlinTypeMapper,
        val isOverride: (TS.MethodDeclaration) -> Boolean,
        val isOverrideProperty: (TS.PropertyDeclaration) -> Boolean
) : TypeScriptToKotlinBase() {
    abstract val needsNoImpl: Boolean

    var parents = ArrayList<Type>()

    override fun visitHeritageClause(node: TS.HeritageClause) {
        val containingInInterface = this is TsInterfaceToKt
        val isExtends = node.token === TS.SyntaxKind.ExtendsKeyword
        val needParens = !containingInInterface && isExtends

        val types = node.types?.arr?.map { id -> Type(id.toKotlinTypeName(typeMapper), needParens) } ?: listOf()
        parents.addAll(types)
    }

    override fun visitIndexSignature(node: TS.IndexSignatureDeclaration) {
        translateAccessor(node, isGetter = true)
        translateAccessor(node, isGetter = false)
    }

    private fun translateAccessor(node: TS.IndexSignatureDeclaration, isGetter: Boolean) {
        // TODO type params?
        val params = node.parameters.toKotlinParams(typeMapper)
        val propType = node.type?.toKotlinTypeName(typeMapper) ?: ANY

        val callSignature: CallSignature
        val accessorName: String
        val annotation: ast.Annotation
        if (isGetter) {
            callSignature = CallSignature(params, listOf(), TypeAnnotation(propType))
            accessorName = GET
            annotation = NATIVE_GETTER_ANNOTATION
        }
        else {
            callSignature = CallSignature(listOf(params[0], FunParam("value", TypeAnnotation(propType))), listOf(), TypeAnnotation(UNIT))
            accessorName = SET
            annotation = NATIVE_SETTER_ANNOTATION
        }

        addFunction(accessorName, callSignature, needsNoImpl = needsNoImpl, additionalAnnotations = listOf(annotation))
    }

    var name: String? = null

    var staticTranslator: TsClassToKt? = null

    ///???
    // TODO should be abstract? is static declarations inside (TS) interfaces allowed?
    fun getTranslator(node: TS.ClassElement): TsClassifierToKt {
        if (node.modifiers?.arr?.any { it.kind === TS.SyntaxKind.StaticKeyword } ?: false) {
            if (staticTranslator == null) {
                // TODO support override for static members
                staticTranslator = TsClassToKt(typeMapper, ClassKind.CLASS_OBJECT, listOf(), NOT_OVERRIDE, NOT_OVERRIDE, hasMembersOpenModifier = false)
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
        val declarationName = node.declarationName!!

        val name = declarationName.text
        val varType = node.type?.toKotlinTypeName(typeMapper) ?: ANY

        val isOverride = isOverrideProperty(node)

        getTranslator(node).addVariable(name, varType,
                isOverride = isOverride,
                needsNoImpl = needsNoImpl(node),
                isNullable = isNullable(node),
                isLambda = isLambda(node)
        )
    }

    open fun TsClassifierToKt.addFunction(name: String, isOverride: Boolean, needsNoImpl: Boolean, node: TS.MethodDeclaration) {
        addFunction(name, node.toKotlinCallSignature(typeMapper), isOverride = isOverride, needsNoImpl = needsNoImpl(node))

        assert(node.body == null, "An function in declarations file should not have body, function '${this.name}.$name'")
    }

    override fun visitMethodDeclaration(node: TS.MethodDeclaration) {
        val declarationName = node.declarationName!!
        val name = declarationName.text
        val isOverride = isOverride(node)

        getTranslator(node).addFunction(name, isOverride, needsNoImpl, node)
    }
}

open class TsInterfaceToKt(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        val annotations: List<ast.Annotation>,
        isOverride: (TS.MethodDeclaration) -> Boolean,
        isOverrideProperty: (TS.PropertyDeclaration) -> Boolean
) : TsClassifierToKt(typeMapper, isOverride, isOverrideProperty) {
    override val result: Classifier
        get() = Classifier(ClassKind.TRAIT, name!!, listOf(), typeParams, parents, declarations, annotations, hasOpenModifier = false)

    override val hasMembersOpenModifier = false

    override val needsNoImpl = false

    var typeParams: List<TypeParam>? = null

    override fun needsNoImpl(node: TS.PropertyDeclaration) = node.questionToken != null
    override fun isNullable(node: TS.PropertyDeclaration) = node.questionToken != null
    override fun isLambda(node: TS.PropertyDeclaration) = node.type?.kind === TS.SyntaxKind.FunctionType

    override fun needsNoImpl(node: TS.MethodDeclaration) = false
    override fun TsClassifierToKt.addFunction(name: String, isOverride: Boolean, needsNoImpl: Boolean, node: TS.MethodDeclaration) {
        val isOptional = node.questionToken != null
        val call = node.toKotlinCallSignature(typeMapper)

        if (isOptional) {
            val typeAsString = "(${call.params.join(", ")}) -> ${call.returnType.escapedName}" ///??? escapedName
            addVariable(name, typeAsString, typeParams = call.typeParams, isVar = false, isNullable = true, isLambda = true, needsNoImpl = true, isOverride = isOverride)
        }
        else {
            addFunction(name, call, needsNoImpl = false, isOverride = isOverride)
        }

    }

    override fun visitInterfaceDeclaration(node: TS.InterfaceDeclaration) {
//      todo visitList(node.modifiers)
        name = node.name.text
        typeParams = node.typeParameters?.toKotlinTypeParams(typeMapper)

        // TODO merge with class?
        node.heritageClauses?.arr?.forEach { visitNode(this, it) }
        node.members.arr.forEach { visitNode(this, it) }
    }

    override fun visitSignatureDeclaration(node: TS.SignatureDeclaration) {
        addFunction(INVOKE, node.toKotlinCallSignature(typeMapper), needsNoImpl = false, additionalAnnotations = listOf(NATIVE_INVOKE_ANNOTATION))
    }
}

class TsInterfaceToKtExtensions(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        annotations: List<ast.Annotation>,
        isOverride: (TS.MethodDeclaration) -> Boolean,
        isOverrideProperty: (TS.PropertyDeclaration) -> Boolean
) : TsInterfaceToKt(typeMapper, annotations, isOverride, isOverrideProperty){

    val cachedExtendsType by Delegates.lazy { getExtendsType(typeParams) }

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

    fun List<ast.Annotation>.withNativeAnnotation() = when {
                defaultAnnotations.any(IS_NATIVE_ANNOTATION),
                this.any(IS_NATIVE_ANNOTATION) -> {
                    this
                }
                else -> {
                    val list = ArrayList<ast.Annotation>()
                    list.add(NATIVE_ANNOTATION)
                    list.addAll(this)
                    list
                }
            }

    override fun addVariable(name: String, type: String, extendsType: String?, typeParams: List<TypeParam>?, isVar: Boolean, isNullable: Boolean, isLambda: Boolean, needsNoImpl: Boolean, additionalAnnotations: List<ast.Annotation>, isOverride: Boolean) {
        val typeParamsWithoutClashes = this.typeParams.fixIfClashWith(typeParams)
        val actualExtendsType = if (typeParamsWithoutClashes identityEquals this.typeParams) cachedExtendsType else getExtendsType(typeParamsWithoutClashes)
        val annotations = additionalAnnotations.withNativeAnnotation()

        super.addVariable(name, type, actualExtendsType, typeParamsWithoutClashes merge typeParams, isVar, isNullable, isLambda, true, annotations, isOverride)
    }

    override fun addFunction(name: String, callSignature: CallSignature, extendsType: String?, needsNoImpl: Boolean, additionalAnnotations: List<ast.Annotation>, isOverride: Boolean) {
        val typeParamsWithoutClashes = this.typeParams.fixIfClashWith(callSignature.typeParams)
        val actualExtendsType = if (typeParamsWithoutClashes identityEquals this.typeParams) cachedExtendsType else getExtendsType(typeParamsWithoutClashes)
        val annotations = additionalAnnotations.withNativeAnnotation()

        super.addFunction(name, CallSignature(callSignature.params, typeParamsWithoutClashes merge callSignature.typeParams, callSignature.returnType), actualExtendsType, true, annotations, isOverride)
    }

}

class TsClassToKt(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        val kind: ClassKind = ClassKind.CLASS,
        val annotations: List<ast.Annotation> = DEFAULT_ANNOTATION,
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
                            val t = ArrayList<Member>()
                            t.addAll(declarations)
                            t.add(staticTranslator!!.result!!)
                            t
                        }
            }

            return Classifier(kind, name!!, paramsOfConstructors, typeParams, parents, cachedDeclarations!!, annotations, hasOpenModifier = kind === ClassKind.CLASS)
        }

    var cachedDeclarations: List<Member>? = null

    override val needsNoImpl = true

    var typeParams: List<TypeParam>? = null
    val paramsOfConstructors = ArrayList<List<FunParam>>()

    override fun visitClassDeclaration(node: TS.ClassDeclaration) {
//      todo visitList(node.modifiers)
        name = node.name.text
        typeParams = node.typeParameters?.toKotlinTypeParams(typeMapper)

        node.heritageClauses?.arr?.forEach { visitNode(this, it) }
        node.members.arr.forEach { visitNode(this, it) }
    }

    override fun visitConstructorDeclaration(node: TS.ConstructorDeclaration) {
        val params = node.parameters.toKotlinParams(typeMapper)
        paramsOfConstructors.add(params)

        assert(node.body == null, "A constructor in declarations file should not have body, constructor in '${this.name}")
    }
}
