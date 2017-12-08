package ts2kt

import ts2kt.kotlin.ast.*

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

val JS_MODULE = "JsModule"
val JS_QUALIFIER = "JsQualifier"

fun moduleAnnotation(moduleName: String): KtAnnotation =
        KtAnnotation(JS_MODULE, listOf(KtArgument("\"$moduleName\"")))
