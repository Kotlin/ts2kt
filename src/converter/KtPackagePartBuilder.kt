package converter

import ts2kt.JS_QUALIFIER
import ts2kt.kotlin.ast.KtAnnotation
import ts2kt.kotlin.ast.KtArgument
import ts2kt.kotlin.ast.KtMember
import ts2kt.kotlin.ast.KtPackagePart
import ts2kt.moduleAnnotation
import typescriptServices.ts.Symbol

class KtPackagePartBuilder(
        val id: Symbol?,
        var parent: KtPackagePartBuilder?,
        val ownName: String
) {
    val members: MutableList<KtMember> = mutableListOf()
    val annotations: MutableList<KtAnnotation> = mutableListOf()
    var module: String? = null
    var exportedSymbol: Symbol? = null
    val nestedPackages: MutableList<KtPackagePartBuilder> = mutableListOf()

    fun build(declarations: MutableMap<Symbol, MutableList<KtMember>>): KtPackagePart {
        val allAnnotations = annotations.toMutableList()
        val packageAnnotations = mutableListOf<KtAnnotation>()

        getEnclosingModule()?.let {
            allAnnotations += moduleAnnotation(it)
        }
        val qualifier = buildQualifier()
        if (qualifier.isNotEmpty()) {
            allAnnotations += KtAnnotation(JS_QUALIFIER, listOf(KtArgument("\"$qualifier\"")))
        }

        val exportedDeclarations = exportedSymbol?.let { declarations[it] }
        if (exportedDeclarations != null) {
            for (exportedDeclaration in exportedDeclarations) {
                exportedDeclaration.annotations += allAnnotations
            }
        }
        else {
            packageAnnotations += allAnnotations
        }
        return KtPackagePart(buildFqName(), members, packageAnnotations)
    }

    private fun getEnclosingModule(): String? = generateSequence(this) { it.parent }
            .map { it.module }
            .firstOrNull { it != null }

    private fun buildQualifier(): String = generateSequence(this) { it.parent }
            .takeWhile { it.module == null }
            .toFqName()
            .joinToString(".")

    private fun buildFqName(): List<String> = generateSequence(this) { it.parent }.toFqName()

    private fun Sequence<KtPackagePartBuilder>.toFqName() = map { it.ownName }
            .filter { it.isNotEmpty() }
            .toList().asReversed()
}

