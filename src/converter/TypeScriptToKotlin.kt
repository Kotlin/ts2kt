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

import ts2kt.kotlin.ast.*
import ts2kt.utils.assert
import ts2kt.utils.cast
import typescript.TS
import typescript.declarationName
import typescript.identifierName
import typescript.propertyName

// workaround for new compiler
private val MODULE = "module"
private val NATIVE = "native"

val NATIVE_ANNOTATION = Annotation(NATIVE)
internal val NATIVE_GETTER_ANNOTATION = Annotation("nativeGetter")
internal val NATIVE_SETTER_ANNOTATION = Annotation("nativeSetter")
internal val NATIVE_INVOKE_ANNOTATION = Annotation("nativeInvoke")
internal val NATIVE_NEW_ANNOTATION = Annotation("native(\"new\")")
private val MODULE_ANNOTATION = Annotation(MODULE)
internal val DEFAULT_ANNOTATION = listOf(NATIVE_ANNOTATION)
private val DEFAULT_MODULE_ANNOTATION = listOf(MODULE_ANNOTATION)
internal val NO_ANNOTATIONS = listOf<Annotation>()
internal val INVOKE = "invoke"
internal val GET = "get"
internal val SET = "set"

internal val COMPARE_BY_NAME = { a: Named, b: Named -> a.name == b.name }
internal val IS_NATIVE_ANNOTATION = { a: Annotation -> a.name == NATIVE }

class TypeScriptToKotlin(
        override val defaultAnnotations: List<Annotation> = DEFAULT_ANNOTATION,
        val requiredModifier: TS.SyntaxKind? = TS.SyntaxKind.DeclareKeyword,
        val moduleName: String? = null,
        typeMapper: ObjectTypeToKotlinTypeMapper? = null,
        override val isInterface: Boolean = false,
        val isOwnDeclaration: (TS.Node) -> Boolean = { true },
        val isOverride: (TS.MethodDeclaration) -> Boolean,
        val isOverrideProperty: (TS.PropertyDeclaration) -> Boolean,
        private val qualifier: List<String> = listOf()
) : TypeScriptToKotlinBase() {

    private val _packageParts = mutableListOf(PackagePart(qualifier, declarations, defaultAnnotations))
    val packageParts: List<PackagePart>
        get() {
            assert(exportedByAssignment.isEmpty(), "exportedByAssignment should be empty, but it contains: ${exportedByAssignment.keys.toString()}")
            return _packageParts
        }

    override val hasMembersOpenModifier = false

    val exportedByAssignment = hashMapOf<String, Annotation>()

    private val typeAliases = mutableListOf<TypeAlias>()

    val typeMapper = typeMapper ?: ObjectTypeToKotlinTypeMapperImpl(defaultAnnotations, declarations, typeAliases)

    fun getAdditionalAnnotations(node: TS.Node): List<Annotation> {
        val isShouldSkip = requiredModifier === TS.SyntaxKind.DeclareKeyword && !(node.modifiers?.arr?.any { it.kind === requiredModifier } ?: false )
        if (isShouldSkip) return DEFAULT_FAKE_ANNOTATION

        return NO_ANNOTATIONS
    }

    override fun visitTypeAliasDeclaration(node: TS.TypeAliasDeclaration) {
        val newTypeMapper = typeMapper.withTypeParameters(node.typeParameters)
        val typeParams = node.typeParameters?.toKotlinTypeParams(newTypeMapper)
        typeAliases.add(TypeAlias(node.identifierName.text, typeParams, node.type.toKotlinTypeUnion(newTypeMapper)))
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
            declarations.add(translator.createClassifier())
        }
    }

    override fun visitClassDeclaration(node: TS.ClassDeclaration) {
        val additionalAnnotations = getAdditionalAnnotations(node)

        val translator = TsClassToKt(typeMapper, annotations = defaultAnnotations + additionalAnnotations, isOverride = isOverride, isOverrideProperty = isOverrideProperty)
        translator.visitClassDeclaration(node)

        val result = translator.createClassifier()
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
        val qualifiedName = arrayListOf<String>()
        while (body.kind !== TS.SyntaxKind.ModuleBlock) {
            assert(body.kind === TS.SyntaxKind.ModuleDeclaration, "Expected that it is ModuleDeclaration, but ${body.kind.str}")

            qualifiedName += getName(rightNode)

            rightNode = body
            body = body.body
        }

        val name = getName(rightNode)
        qualifiedName += name

        val tr = TypeScriptToKotlin(
                        moduleName = name,
                        defaultAnnotations = additionalAnnotations,
                        requiredModifier = TS.SyntaxKind.ExportKeyword,
                        isOwnDeclaration = isOwnDeclaration,
                        isOverride = isOverride,
                        isOverrideProperty = isOverrideProperty,
                        qualifier = this.qualifier + qualifiedName)

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

        _packageParts += tr._packageParts

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
    }

    fun fixExportAssignments() {
        val found = hashSetOf<String>()

        fun process(annotated: Annotated, declarationName: String) {
            val annotation = exportedByAssignment[declarationName] ?: return

            val annotationParamString = annotation.getFirstParamAsString()

            val t = arrayListOf<Annotation>()
            for (a in annotated.annotations) {
                if (a == FAKE_ANNOTATION) continue

                if (a.name == MODULE) {
                    if (declarationName == annotationParamString) return

                    continue
                }

                t.add(a)
            }

            t.add(annotation)
            annotated.annotations = t

            found.add(declarationName)
        }

        declarations
                .forEach { process(it, it.name) }

        _packageParts
                .filter { it.fqName.isNotEmpty() && it.fqName.dropLast(1) == qualifier }
                .forEach { process(it, it.fqName.last()) }

        for (key in found) {
            exportedByAssignment.remove(key)
        }
    }
}