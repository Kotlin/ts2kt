package ts2kt

import ts2kt.kotlin.ast.ClassKind
import ts2kt.kotlin.ast.Classifier
import ts2kt.kotlin.ast.Member

fun TsInterfaceToKt.createClassifier() =
        Classifier(ClassKind.INTERFACE, name!!, listOf(), typeParams, parents, declarations, annotations, hasOpenModifier = false)

fun TsClassToKt.createClassifier(): Classifier? {
    if (name == null) return null

    val members =
            staticTranslator?.let {
                arrayListOf<Member>().apply {
                    this += declarations
                    this += it.createClassifier()!!
                }
            } ?: declarations

    return Classifier(kind, name!!, paramsOfConstructors, typeParams, parents, members, annotations, hasOpenModifier = kind === ts2kt.kotlin.ast.ClassKind.CLASS)
}


