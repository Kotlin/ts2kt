package ts2kt.kotlin.ast

import ts2kt.escapeIfNeed


// TODO: review usages
fun KtNode.stringify() = stringify(null)
fun KtNode.stringify(packagePartPrefix: String?) = Stringify(packagePartPrefix).also { this.accept(it) }.result

fun KtAnnotation.getFirstParamAsString(): String? {
    if (this.parameters.isEmpty()) return null

    val annotationParam = this.parameters[0].value as String
    return annotationParam.substring(1, annotationParam.size - 1)
}

fun KtClassifier.isModule() = kind === KtClassKind.OBJECT && hasModuleAnnotation()

fun KtClassifier.hasModuleAnnotation() = annotations.any { it.name == MODULE }

fun KtClassifier.getClassObject(): KtClassifier? =
        this.members.firstOrNull { it is KtClassifier && it.kind === KtClassKind.COMPANION_OBJECT } as? KtClassifier

val KtNamed.escapedName: String
    get() = name.escapeIfNeed()
