package ts2kt.kotlin.ast

import ts2kt.utils.join
import ts2kt.*

fun <T> List<T>.stringify() = join("\n", endWithIfNotEmpty = "\n")

fun Annotation.getFirstParamAsString(): String? {
    if (this.parameters.isEmpty()) return null

    val annotationParam = this.parameters[0].value as String
    return annotationParam.substring(1, annotationParam.size - 1)
}

fun Classifier.isModule() = kind === ClassKind.OBJECT && hasModuleAnnotation()

fun Classifier.isModule() = isExternalModule() || isInternalModule()

fun Classifier.isExternalModule() = kind === ClassKind.OBJECT && hasAnnotation(NATIVE_MODULE)
fun Classifier.isInternalModule() = kind === ClassKind.OBJECT && hasAnnotation(NATIVE_PACKAGE)

fun Classifier.hasAnnotation(vararg names: String) = annotations.any { it.name in names }

fun Classifier.getClassObject(): Classifier? =
        this.members.firstOrNull { it is Classifier && it.kind === ClassKind.CLASS_OBJECT } as? Classifier

val Named.escapedName: String
    get() = name.escapeIfNeed()
