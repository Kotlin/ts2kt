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

import converter.ConverterContext
import converter.KtPackagePartBuilder
import converter.mapType
import ts2kt.kotlin.ast.*
import ts2kt.utils.cast
import ts2kt.utils.reportUnsupportedNode
import typescriptServices.ts.*

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
        private val context: ConverterContext,
        private val currentPackagePartBuilder: KtPackagePartBuilder,
        private val typeChecker: TypeChecker,
        declarations: MutableList<KtMember>,
        override val defaultAnnotations: List<KtAnnotation>,
        val requiredModifier: SyntaxKind? = SyntaxKind.DeclareKeyword,
        val typeMapper: ObjectTypeToKotlinTypeMapper,
        override val isInterface: Boolean = false,
        val isOwnDeclaration: (Node) -> Boolean = { true },
        val isOverride: (MethodDeclaration) -> Boolean,
        val isOverrideProperty: (PropertyDeclaration) -> Boolean,
        private val qualifier: List<String> = listOf()
) : TypeScriptToKotlinBase(declarations, context.declarations) {

    override val hasMembersOpenModifier = false

    fun getAdditionalAnnotations(node: Node): List<KtAnnotation> {
        val isShouldSkip = requiredModifier === SyntaxKind.DeclareKeyword && !(node.modifiers?.arr?.any { it.kind === requiredModifier } ?: false )
        if (isShouldSkip) return DEFAULT_FAKE_ANNOTATION

        return NO_ANNOTATIONS
    }

    override fun visitTypeAliasDeclaration(node: TypeAliasDeclaration) {
        if (node.type.kind != SyntaxKind.TypeLiteral) return

        val translator = TsInterfaceToKt(
                annotations = defaultAnnotations, typeMapper = typeMapper,
                isOverride = NOT_OVERRIDE, isOverrideProperty = NOT_OVERRIDE
        )
        forEachChild(translator, node.type.unsafeCast<TypeLiteralNode>())
        translator.name = node.name?.unescapedText
        translator.typeParams = node.typeParameters?.toKotlinTypeParams(typeMapper)

        addDeclaration(typeChecker.getSymbolAtLocation(node), translator.createClassifier())
    }

    override fun visitVariableStatement(node: VariableStatement) {
        val additionalAnnotations = getAdditionalAnnotations(node)

//      TODO  node.modifiers
//      TODO  test many declarations
        val declarations = node.declarationList.declarations.arr
        for (d in declarations) {
            val name = (d.declarationName as Identifier)!!.unescapedText
            val symbol = typeChecker.getSymbolResolvingAliases(d.name.unsafeCast<Node>())

            if (d.type?.kind == SyntaxKind.TypeLiteral) {
                val asObject = tryTranslateTypeLiteralAsObject(d, name, additionalAnnotations)
                if (asObject != null) {
                    addDeclaration(symbol, asObject)
                    return
                }
            }
            val varType = d.type?.let { typeMapper.mapType(it) } ?: KtType(ANY)
            addVariable(symbol, name, varType, additionalAnnotations = additionalAnnotations)
        }
    }

    private fun tryTranslateTypeLiteralAsObject(
            d: VariableDeclaration, name: String,
            additionalAnnotations: List<KtAnnotation>
    ): KtClassifier? {
        val translator = TsClassToKt(
                typeMapper, kind = KtClassKind.OBJECT,
                annotations = defaultAnnotations + additionalAnnotations,
                isOverride = isOverride, isOverrideProperty = isOverrideProperty,
                hasMembersOpenModifier = false, needsNoImpl = false)
        val typeLiteral = d.type.unsafeCast<TypeLiteralNode>()
        forEachChild(translator, typeLiteral)

        // TODO should we add more heuristics?
        // E.g. shouldn't we avoid generating object when an anonymous type is used more than one place?
        if (translator.declarations.toStringKey() == ObjectTypeToKotlinTypeMapperImpl.jsonTypeKey) return null

        translator.name = name
        return translator.createClassifier()!!
    }

    override fun visitFunctionDeclaration(node: FunctionDeclaration) {
        val additionalAnnotations = getAdditionalAnnotations(node)

//      TODO  visitList(node.modifiers)
        val name = (node.propertyName as Identifier)!!.unescapedText
        val symbol = node.name?.let { typeChecker.getSymbolResolvingAliases(it) }
        node.toKotlinCallSignatureOverloads(typeMapper).forEach { callSignature ->
            addFunction(symbol, name, callSignature, additionalAnnotations = additionalAnnotations)
        }
        processDefaultExport(node, symbol)
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
            val symbol = node.name?.let { typeChecker.getSymbolResolvingAliases(it) }
            addDeclaration(symbol, translator.createClassifier())
            processDefaultExport(node, symbol)
        }
    }

    override fun visitClassDeclaration(node: ClassDeclaration) {
        val additionalAnnotations = getAdditionalAnnotations(node)

        val translator = TsClassToKt(typeMapper, annotations = defaultAnnotations + additionalAnnotations, isOverride = isOverride, isOverrideProperty = isOverrideProperty)
        translator.visitClassDeclaration(node)

        val result = translator.createClassifier()
        if (result != null) {
            val symbol = node.name?.let { typeChecker.getSymbolResolvingAliases(it) }
            addDeclaration(symbol, result)
            processDefaultExport(node, symbol)
        }
    }

    private fun processDefaultExport(node: Node, symbol: Symbol?) {
        if (node.modifiers?.arr?.any { it.kind == SyntaxKind.DefaultKeyword } == true) {
            addJsNameAnnotation(symbol, "default")
        }
    }

    private fun addJsNameAnnotation(symbol: Symbol?, name: String) {
        if (symbol == null) return

        declarationsBySymbol[symbol]?.forEach { it.annotations += jsNameAnnotation(name) }
    }

    override fun visitEnumDeclaration(node: EnumDeclaration) {
        val entries = node.members.arr.map { entry ->
            KtEnumEntry((entry.declarationName as Identifier).unescapedText, entry.initializer?.let {
                when (it.kind as Any) {
                    SyntaxKind.NumericLiteral -> (it.cast<LiteralExpression>()).text
                    else -> reportUnsupportedNode(it)
                }
            })
        }

        val enumClass =
                KtClassifier(KtClassKind.ENUM, node.identifierName.unescapedText, listOf(), listOf(), listOf(),
                        entries, listOf(), hasOpenModifier = false)

        val symbol = node.name?.let { typeChecker.getSymbolResolvingAliases(it) }
        addDeclaration(symbol, enumClass)
    }

    override fun visitModuleDeclaration(node: ModuleDeclaration) {
        val additionalAnnotations = getAdditionalAnnotations(node)

        fun getName(node: ModuleDeclaration): String {
            return when(node.declarationName!!.kind as Any) {
                SyntaxKind.Identifier -> (node.declarationName as Identifier)!!.unescapedText
                SyntaxKind.StringLiteral -> (node.declarationName as Identifier)!!.unescapedText.replace('/', '.')

                else -> {
                    reportUnsupportedNode(node.declarationName!!)
                    "???"
                }
            }
        }

        val body = node.body.unsafeCast<Node>()
        val ownName = getName(node)

        val newQualifier = this.qualifier + ownName

        val packageSymbol: Symbol? = typeChecker.getSymbolResolvingAliases(node.name.unsafeCast<Node>())
        fun createPackagePart() = KtPackagePartBuilder(packageSymbol, currentPackagePartBuilder, ownName).also {
            currentPackagePartBuilder.nestedPackages += it
            context.packageParts += it
        }

        val innerPackagePartBuilder = if (packageSymbol != null) {
            context.packagePartsBySymbol.getOrPut(packageSymbol, ::createPackagePart)
        }
        else {
            createPackagePart()
        }

        if (node.name.unsafeCast<Node>().kind == SyntaxKind.StringLiteral) {
            innerPackagePartBuilder.module = node.name.unsafeCast<StringLiteral>().text
        }

        val innerTypeMapper = ObjectTypeToKotlinTypeMapperImpl(
                declarations = innerPackagePartBuilder.members,
                defaultAnnotations = additionalAnnotations,
                typeChecker = typeChecker,
                currentPackage = newQualifier.joinToString(".")
        )
        val tr = TypeScriptToKotlin(
                currentPackagePartBuilder = innerPackagePartBuilder,
                context = context,
                declarations = innerPackagePartBuilder.members,
                typeChecker = typeChecker,
                typeMapper = innerTypeMapper,
                defaultAnnotations = additionalAnnotations,
                isOwnDeclaration = isOwnDeclaration,
                isOverride = isOverride,
                isOverrideProperty = isOverrideProperty,
                qualifier = newQualifier,
                requiredModifier = SyntaxKind.ExportKeyword
        )

        if (body.kind == SyntaxKind.ModuleDeclaration) {
            tr.visitModuleDeclaration(body.unsafeCast<ModuleDeclaration>())
        }
        else {
            tr.visitList(body)
        }
    }

    override fun visitExportAssignment(node: ExportAssignment) {
        val symbol = typeChecker.getSymbolResolvingAliases(node.expression)
        if (node.isExportEquals == true) {
            currentPackagePartBuilder.exportedSymbol = symbol
        }
        else if(symbol?.declarations?.none { ModifierFlags.Export in getCombinedModifierFlags(it) } == true) {
            addJsNameAnnotation(symbol, "default")
        }
    }
}