package ts2kt

import ts2kt.kotlin.ast.KtClassKind
import ts2kt.kotlin.ast.KtClassifier
import ts2kt.kotlin.ast.KtMember

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


