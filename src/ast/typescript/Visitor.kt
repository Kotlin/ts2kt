package ts2kt

import typescriptServices.ts.*

interface Visitor {
    fun visitModuleDeclaration(node: ModuleDeclaration): Unit = TODO()

    fun visitFunctionDeclaration(node: FunctionDeclaration): Unit = TODO()
    fun visitTypeAliasDeclaration(node: TypeAliasDeclaration): Unit = TODO()
    fun visitVariableStatement(node: VariableStatement): Unit = TODO()

    fun visitEnumDeclaration(node: EnumDeclaration): Unit = TODO()

    fun visitClassDeclaration(node: ClassDeclaration): Unit = TODO()
    fun visitInterfaceDeclaration(node: InterfaceDeclaration): Unit = TODO()

    fun visitHeritageClause(node: HeritageClause): Unit = TODO()

    fun visitConstructorDeclaration(node: ConstructorDeclaration): Unit = TODO()
    fun visitConstructSignatureDeclaration(node: ConstructorDeclaration): Unit = TODO()

    fun visitMethodDeclaration(node: MethodDeclaration): Unit = TODO()
    fun visitPropertyDeclaration(node: PropertyDeclaration): Unit = TODO()
    fun visitIndexSignature(node: IndexSignatureDeclaration): Unit = TODO()
    fun visitSignatureDeclaration(node: SignatureDeclaration): Unit = TODO()

    fun visitExportAssignment(node: ExportAssignment): Unit = TODO()
    fun visitImportEqualsDeclaration(node: ImportEqualsDeclaration): Unit = TODO()
}
