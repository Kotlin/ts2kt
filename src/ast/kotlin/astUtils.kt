package ts2kt.kotlin.ast

import ts2kt.escapeIfNeed
import ts2kt.utils.join


// TODO: review usages
fun KtNode.stringify() = stringify(null, false)
fun KtNode.stringify(packagePartPrefix: String?, topLevel: Boolean = true, additionalImports: List<String> = listOf(), suppressedDiagnostics: List<String> = listOf()) =
        Stringify(packagePartPrefix, topLevel, additionalImports, suppressedDiagnostics).also { this.accept(it) }.result

fun KtAnnotation.getFirstParamAsString(): String? {
    if (this.parameters.isEmpty()) return null

    val annotationParam = this.parameters[0].value as String
    return annotationParam.substring(1, annotationParam.length - 1)
}

fun KtClassifier.isModule() = kind === KtClassKind.OBJECT && hasModuleAnnotation()

fun KtClassifier.hasModuleAnnotation() = annotations.any { it.name == MODULE }

fun KtClassifier.getClassObject(): KtClassifier? =
        this.members.firstOrNull { it is KtClassifier && it.kind === KtClassKind.COMPANION_OBJECT } as? KtClassifier

val KtNamed.escapedName: String
    get() = name.escapeIfNeed()

fun createFunctionType(parameters: List<KtFunParam>, returnType: KtType, isNullable: Boolean = false): KtType {
    val params = parameters.join(", ") { it.name + it.type.stringify() + (it.defaultValue?.let { " /*= $it*/" } ?: "") }
    val typeAsString = "($params) -> ${returnType.stringify()}"
    return KtType(typeAsString, isLambda = true, isNullable = isNullable)
}
