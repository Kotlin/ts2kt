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
import ts2kt.utils.reportUnsupportedNode
import typescript.declarationName
import typescript.identifierName
import typescript.propertyName
import typescriptServices.ts.*

private val JS_MODULE = "JsModule"
private val JS_QUALIFIER = "JsQualifier"
private val NATIVE = "native"

val NATIVE_ANNOTATION = KtAnnotation(NATIVE)
internal val NATIVE_GETTER_ANNOTATION = KtAnnotation("nativeGetter")
internal val NATIVE_SETTER_ANNOTATION = KtAnnotation("nativeSetter")
internal val NATIVE_INVOKE_ANNOTATION = KtAnnotation("nativeInvoke")
internal val DEFAULT_ANNOTATION = listOf(NATIVE_ANNOTATION)
internal val NO_ANNOTATIONS = emptyList<KtAnnotation>()
internal val INVOKE = "invoke"
internal val GET = "get"
internal val SET = "set"

internal val COMPARE_BY_NAME = { a: KtNamed, b: KtNamed -> a.name == b.name }
internal val IS_NATIVE_ANNOTATION = { a: KtAnnotation -> a.name == NATIVE }

class TypeScriptToKotlin(
        override val defaultAnnotations: List<KtAnnotation> = DEFAULT_ANNOTATION,
        val requiredModifier: SyntaxKind? = SyntaxKind.DeclareKeyword,
        val moduleName: String? = null,
        typeMapper: ObjectTypeToKotlinTypeMapper? = null,
        override val isInterface: Boolean = false,
        val isOwnDeclaration: (Node) -> Boolean = { true },
        val isOverride: (MethodDeclaration) -> Boolean,
        val isOverrideProperty: (PropertyDeclaration) -> Boolean,
        private val qualifier: List<String> = listOf()
) : TypeScriptToKotlinBase() {

    fun packagePartAnnotations(): List<KtAnnotation> {
        if (qualifier.isEmpty()) return defaultAnnotations
        return defaultAnnotations + KtAnnotation(JS_QUALIFIER, listOf(KtArgument(qualifier.joinToString(".", "\"", "\""))))
    }

    private val _packageParts = mutableListOf(KtPackagePart(qualifier, declarations, packagePartAnnotations()))

    val packageParts: List<KtPackagePart>
        get() {
            assert(exportedByAssignment.isEmpty(), "exportedByAssignment should be empty, but it contains: ${exportedByAssignment.keys.toString()}")
            return _packageParts
        }

    override val hasMembersOpenModifier = false

    val exportedByAssignment = hashMapOf<String, KtAnnotation>()

    private val typeAliases = mutableListOf<KtTypeAlias>()

    val typeMapper = typeMapper ?: ObjectTypeToKotlinTypeMapperImpl(defaultAnnotations, declarations, typeAliases)

    fun getAdditionalAnnotations(node: Node): List<KtAnnotation> {
        val isShouldSkip = requiredModifier === SyntaxKind.DeclareKeyword && !(node.modifiers?.arr?.any { it.kind === requiredModifier } ?: false )
        if (isShouldSkip) return DEFAULT_FAKE_ANNOTATION

        return NO_ANNOTATIONS
    }

    override fun visitTypeAliasDeclaration(node: TypeAliasDeclaration) {
        val newTypeMapper = typeMapper.withTypeParameters(node.typeParameters)
        val typeParams = node.typeParameters?.toKotlinTypeParams(newTypeMapper)
        typeAliases.add(KtTypeAlias(node.identifierName.text, typeParams, node.type.toKotlinTypeUnion(newTypeMapper)))
    }

    override fun visitVariableStatement(node: VariableStatement) {
        val additionalAnnotations = getAdditionalAnnotations(node)

//      TODO  node.modifiers
//      TODO  test many declarations
        val declarations = node.declarationList.declarations.arr
        for (d in declarations) {
            val name = d.declarationName!!.unescapedText
            val varType = d.type?.toKotlinType(typeMapper) ?: KtType(ANY)
            addVariable(name, varType, additionalAnnotations = additionalAnnotations)
        }
    }

    override fun visitFunctionDeclaration(node: FunctionDeclaration) {
        val additionalAnnotations = getAdditionalAnnotations(node)

//      TODO  visitList(node.modifiers)
        val name = node.propertyName!!.unescapedText
        node.toKotlinCallSignatureOverloads(typeMapper).forEach { callSignature ->
            addFunction(name, callSignature, additionalAnnotations = additionalAnnotations)
        }
    }

    override fun visitInterfaceDeclaration(node: InterfaceDeclaration) {
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

    override fun visitClassDeclaration(node: ClassDeclaration) {
        val additionalAnnotations = getAdditionalAnnotations(node)

        val translator = TsClassToKt(typeMapper, annotations = defaultAnnotations + additionalAnnotations, isOverride = isOverride, isOverrideProperty = isOverrideProperty)
        translator.visitClassDeclaration(node)

        val result = translator.createClassifier()
        if (result != null) {
            declarations.add(result)
        }
    }

    override fun visitEnumDeclaration(node: EnumDeclaration) {
        val entries = node.members.arr.map { entry ->
            KtEnumEntry(entry.declarationName.unescapedText, entry.initializer?.let {
                when (it.kind) {
                    SyntaxKind.FirstLiteralToken -> (it.cast<LiteralExpression>()).text
                    else -> reportUnsupportedNode(it)
                }
            })
        }

        val enumClass =
                KtClassifier(KtClassKind.ENUM, node.identifierName.unescapedText, listOf(), listOf(), listOf(),
                        entries, listOf(), hasOpenModifier = false)

        declarations.add(enumClass)
    }

    override fun visitModuleDeclaration(node: ModuleDeclaration) {
        val additionalAnnotations = getAdditionalAnnotations(node)

        fun getName(node: ModuleDeclaration): String {
            return when(node.declarationName!!.kind) {
                SyntaxKind.Identifier,
                SyntaxKind.StringLiteral -> node.declarationName!!.unescapedText

                else -> {
                    reportUnsupportedNode(node.declarationName!!)
                    "???"
                }
            }
        }

        var rightNode = node
        var body = node.body
        val qualifiedName = arrayListOf<String>()
        while (body.kind !== SyntaxKind.ModuleBlock) {
            assert(body.kind === SyntaxKind.ModuleDeclaration, "Expected that it is ModuleDeclaration, but ${body.kind.str}")

            qualifiedName += getName(rightNode)

            rightNode = body
            body = body.body
        }

        val name = getName(rightNode)
        qualifiedName += name

        val tr = TypeScriptToKotlin(
                        moduleName = name,
                        defaultAnnotations = additionalAnnotations,
                        requiredModifier = SyntaxKind.ExportKeyword,
                        isOwnDeclaration = isOwnDeclaration,
                        isOverride = isOverride,
                        isOverrideProperty = isOverrideProperty,
                        qualifier = this.qualifier + qualifiedName)

        tr.visitList(body)

        val isExternalModule = rightNode.declarationName!!.kind === SyntaxKind.StringLiteral

        if (isExternalModule && tr.exportedByAssignment.isEmpty()) {
            val areAllFakeOrInterface = tr.declarations.all {
                it.annotations.any { it == FAKE_ANNOTATION } ||
                (it is KtClassifier && it.kind === KtClassKind.INTERFACE && it.annotations.all { it.name != JS_MODULE })
            }
            val areAllPartOfThisModule = { tr.declarations.all { it.annotations.any { it.name == JS_MODULE && it.getFirstParamAsString() == name } } }

            if (areAllFakeOrInterface) {
                // unfake all
                for (d in tr.declarations) {
                    d.annotations = d.annotations.filter { it != FAKE_ANNOTATION }
                }
            }
            else if (areAllPartOfThisModule()) {
                // TODO: is it right?
                if (tr.declarations.size == 1 && tr.declarations[0] is KtVariable) {
                    val d = tr.declarations[0]
                    d.annotations.firstOrNull { it.name == JS_MODULE }?.getFirstParamAsString()?.let( {
                        d.name = it
                    })
                }

                this.declarations.addAll(tr.declarations)
                return
            }
        }

        _packageParts += tr._packageParts

        exportedByAssignment.putAll(tr.exportedByAssignment)
    }

    override fun visitExportAssignment(node: ExportAssignment) {
        // TODO is it right?
        val exportIdentifier =
                node.identifierName ?:
                        run {
                            if (node.expression.kind == SyntaxKind.Identifier)
                                @Suppress("UNCHECKED_CAST_TO_NATIVE_INTERFACE")
                                node.expression as Identifier
                            else
                                reportUnsupportedNode(node)
                        } ?: return

        val exportName = exportIdentifier.unescapedText
        exportedByAssignment[exportName] =
                KtAnnotation(JS_MODULE, listOf(KtArgument("\"${moduleName ?: exportName}\"")))
    }

    override fun visitList(node: Node) {
        super.visitList(node)
        // TODO: Is it good place for call finish?
        finish()
    }

    fun finish() {
        fixExportAssignments()
    }

    fun fixExportAssignments() {
        if (exportedByAssignment.isEmpty()) return

        val found = hashSetOf<String>()

        fun process(annotated: KtAnnotated, declarationName: String) {
            val annotation = exportedByAssignment[declarationName] ?: return

            val annotationParamString = annotation.getFirstParamAsString()

            val t = arrayListOf<KtAnnotation>()
            for (a in annotated.annotations) {
                if (a == FAKE_ANNOTATION) continue

                if (a.name == JS_MODULE) {
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