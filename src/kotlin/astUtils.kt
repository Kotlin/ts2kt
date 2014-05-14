package ts2kt.kotlin.ast

import ts2kt.utils.join

fun <T> List<T>.stringify() = join("\n", endWithIfNotEmpty = "\n")

fun Annotation.getFirstParamAsString(): String? {
    if (this.parameters.isEmpty()) return null

    val annotationParam = this.parameters[0].value as String
    return annotationParam.substring(1, annotationParam.size - 1)
}
