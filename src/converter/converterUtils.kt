package ts2kt

import converter.ImportNamespacePreprocessor
import converter.TypeAliasPreprocessor
import ts2kt.kotlin.ast.KtAnnotation
import ts2kt.kotlin.ast.KtClassKind
import ts2kt.kotlin.ast.KtClassifier
import ts2kt.kotlin.ast.KtMember
import typescriptServices.ts.MethodDeclaration
import typescriptServices.ts.Node
import typescriptServices.ts.PropertyDeclaration
import typescriptServices.ts.SyntaxKind

fun TsInterfaceToKt.createClassifier() =
        KtClassifier(KtClassKind.INTERFACE, name!!, listOf(), typeParams, parents, declarations, annotations, hasOpenModifier = false)

fun TsClassToKt.createClassifier(): KtClassifier? {
    if (name == null) return null

    val members =
            staticTranslator?.let {
                arrayListOf<KtMember>().apply {
                    this += declarations
                    this += it.createClassifier()!!
                }
            } ?: declarations

    return KtClassifier(kind, name!!, paramsOfConstructors, typeParams, parents, members, annotations, hasOpenModifier = kind === ts2kt.kotlin.ast.KtClassKind.CLASS)
}


fun createConverter(
        packageName: String,
        typeMapper: ObjectTypeToKotlinTypeMapper?,
        additionalAnnotations: List<KtAnnotation>,
        moduleName: String?,
        isOwnDeclaration: (Node) -> Boolean,
        isOverride: (MethodDeclaration) -> Boolean,
        isOverrideProperty: (PropertyDeclaration) -> Boolean,
        qualifier: List<String>,
        requiredModifier: SyntaxKind?,
        body: Node
): TypeScriptToKotlin {
    val importNamespacePreprocessor = ImportNamespacePreprocessor(packageName)
    typeMapper?.let { importNamespacePreprocessor.putAliases(it.namespaceAliases) }
    importNamespacePreprocessor.visitList(body)

    val typeAliasPreprocessor = TypeAliasPreprocessor(
            importNamespacePreprocessor.createNamespaceResolver(),
            additionalAnnotations,
            mutableListOf(), mutableListOf()
    )
    typeAliasPreprocessor.visitList(body)

    return TypeScriptToKotlin(
            declarations = typeAliasPreprocessor.declarations,
            moduleName = moduleName,
            defaultAnnotations = additionalAnnotations,
            requiredModifier = requiredModifier,
            isOwnDeclaration = isOwnDeclaration,
            isOverride = isOverride,
            isOverrideProperty = isOverrideProperty,
            qualifier = qualifier,
            typeMapper = typeAliasPreprocessor.typeMapper
    )
}