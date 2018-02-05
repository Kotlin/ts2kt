package ts2kt

import ts2kt.utils.reportUnsupportedNode
import typescriptServices.ts.*

interface Visitor {
    fun visitModuleDeclaration(node: ModuleDeclaration): Unit = unsupported(node)

    fun visitFunctionDeclaration(node: FunctionDeclaration): Unit = unsupported(node)
    fun visitTypeAliasDeclaration(node: TypeAliasDeclaration): Unit = unsupported(node)
    fun visitVariableStatement(node: VariableStatement): Unit = unsupported(node)

    fun visitEnumDeclaration(node: EnumDeclaration): Unit = unsupported(node)

    fun visitClassDeclaration(node: ClassDeclaration): Unit = unsupported(node)
    fun visitInterfaceDeclaration(node: InterfaceDeclaration): Unit = unsupported(node)

    fun visitHeritageClause(node: HeritageClause): Unit = unsupported(node)

    fun visitConstructorDeclaration(node: ConstructorDeclaration): Unit = unsupported(node)
    fun visitConstructSignatureDeclaration(node: ConstructorDeclaration): Unit = unsupported(node)

    fun visitMethodDeclaration(node: MethodDeclaration): Unit = unsupported(node)
    fun visitPropertyDeclaration(node: PropertyDeclaration): Unit = unsupported(node)
    fun visitIndexSignature(node: IndexSignatureDeclaration): Unit = unsupported(node)
    fun visitSignatureDeclaration(node: SignatureDeclaration): Unit = unsupported(node)

    fun visitExportAssignment(node: ExportAssignment): Unit = unsupported(node)
    fun visitImportEqualsDeclaration(node: ImportEqualsDeclaration): Unit = unsupported(node)
}

@Suppress("NOTHING_TO_INLINE")
inline fun unsupported(node: Node) {
    reportUnsupportedNode(node)
}
