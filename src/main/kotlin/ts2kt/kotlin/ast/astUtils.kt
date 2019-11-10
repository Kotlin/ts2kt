package ts2kt.kotlin.ast


// TODO: review usages
fun KtNode.stringify(allowEnhanced: Boolean = false) = stringify(null, false, allowEnhanced = allowEnhanced)
fun KtNode.stringify(packagePartPrefix: String?,
                     topLevel: Boolean = true,
                     additionalImports: List<String> = listOf(),
                     suppressedDiagnostics: List<String> = listOf(),
                     allowEnhanced: Boolean = false) =
        Stringify(packagePartPrefix, topLevel, additionalImports, suppressedDiagnostics, allowEnhanced).also { this.accept(it) }.result

fun KtAnnotation.getFirstParamAsString(): String? {
    if (this.parameters.isEmpty()) return null

    val annotationParam = this.parameters[0].value as String
    return annotationParam.substring(1, annotationParam.length - 1)
}

fun KtClassifier.isModule() = kind === KtClassKind.OBJECT && hasModuleAnnotation()

fun KtClassifier.hasModuleAnnotation() = annotations.any { it.name == MODULE }

fun KtClassifier.getClassObject(): KtClassifier? =
        this.members.firstOrNull { it is KtClassifier && it.kind === KtClassKind.COMPANION_OBJECT } as? KtClassifier

fun createFunctionType(parameters: List<KtFunParam>, returnType: KtType, isNullable: Boolean = false): KtType {
    return KtType(
            KtQualifiedName("Function"),
            callSignature = KtCallSignature(parameters, null, KtTypeAnnotation(returnType)),
            isNullable = isNullable
    )
}
