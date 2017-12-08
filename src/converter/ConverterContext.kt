package converter

import ts2kt.kotlin.ast.KtMember
import ts2kt.kotlin.ast.KtPackagePart
import ts2kt.kotlin.ast.KtVariable
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
    return packageParts.map { it.build(declarations) }.filter { it.members.isNotEmpty() }
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
            builder.exportedSymbol = null

            val module = builder.module
            if (module != null) {
                for (exportedDeclaration in exportedDeclarations) {
                    val currentOwner = declarationToModule[exportedDeclaration]
                    val parentPackage = builder.parent
                    if (currentOwner != null && parentPackage != null && exportedDeclaration in currentOwner.members) {
                        currentOwner.members -= exportedDeclaration
                        parentPackage.members += exportedDeclaration
                    }

                    exportedDeclaration.annotations += moduleAnnotation(module)

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

