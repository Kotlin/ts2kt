package converter

import ts2kt.*
import ts2kt.kotlin.ast.*
import ts2kt.mergeClassesAndPackages
import ts2kt.moduleAnnotation
import ts2kt.sanitize
import typescriptServices.ts.Symbol

class ConverterContext {
    val packageParts: MutableList<KtPackagePartBuilder> = mutableListOf()
    val packagePartsBySymbol: MutableMap<Symbol, KtPackagePartBuilder> = mutableMapOf()
    val declarations: MutableMap<Symbol, MutableList<KtMember>> = mutableMapOf()
}

fun ConverterContext.build(): List<KtPackagePart> {
    processExportedDeclarations()
    packageParts.forEach { it.mergeClassesAndPackages() }
    return packageParts.map { it.build() }.filter { it.members.isNotEmpty() }
}

private fun ConverterContext.processExportedDeclarations() {
    val declarationToModule = packageParts.asSequence()
            .flatMap { packagePart ->
                packagePart.members.asSequence().zip(generateSequence { packagePart })
            }
            .associateTo(mutableMapOf()) { it }

    for (builder in packageParts) {
        val exportedNamespace = builder.exportedSymbol?.let { packagePartsBySymbol[it] }
        if (exportedNamespace != null) {
            exportedNamespace.module = builder.module
        }

        val exportedDeclarations = builder.exportedSymbol?.let { declarations[it] }
        if (exportedDeclarations != null) {
            val module = builder.module
            if (module != null) {
                for (exportedDeclaration in exportedDeclarations) {
                    val currentOwner = declarationToModule[exportedDeclaration]

                    exportedDeclaration.annotations += moduleAnnotation(module)
                    if (builder.isExportDefault) {
                        exportedDeclaration.annotations += KtAnnotation(JS_NAME, listOf(KtArgument("\"default\"")))
                    }

                    if (exportedDeclaration is KtVariable) {
                        exportedDeclaration.isVar = false

                        if (currentOwner == builder) {
                            exportedDeclaration.name = module.sanitize()
                        }
                    }
                }
            }
        }
    }
}

