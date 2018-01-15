package ts2kt

import ts2kt.kotlin.ast.*
import ts2kt.utils.cast
import ts2kt.utils.reportUnsupportedNode
import typescriptServices.ts.*

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
private val JS_NAME = "JsName"

fun moduleAnnotation(moduleName: String): KtAnnotation =
        KtAnnotation(JS_MODULE, listOf(KtArgument("\"$moduleName\"")))

fun jsNameAnnotation(name: String): KtAnnotation =
        KtAnnotation(JS_NAME, listOf(KtArgument("\"$name\"")))

fun PropertyName.asString() = when (kind) {
    SyntaxKind.Identifier -> {
        this.cast<Identifier>().unescapedText
    }
    SyntaxKind.NumericLiteral -> {
        (this.cast<LiteralExpression>()).text
    }
    else -> {
        reportUnsupportedNode(this)
        null
    }
}

fun DeclarationName.asString() = when (kind) {
    SyntaxKind.Identifier -> {
        this.cast<Identifier>().unescapedText
    }
    else -> {
        reportUnsupportedNode(this)
        null
    }
}

