package ts2kt

import typescript.*

interface Visitor {
    fun visitModuleDeclaration(node: TS.ModuleDeclaration): Unit = TODO()

    fun visitFunctionDeclaration(node: TS.FunctionDeclaration): Unit = TODO()
    fun visitTypeAliasDeclaration(node: TS.TypeAliasDeclaration): Unit = TODO()
    fun visitVariableStatement(node: TS.VariableStatement): Unit = TODO()

    fun visitEnumDeclaration(node: TS.EnumDeclaration): Unit = TODO()

    fun visitClassDeclaration(node: TS.ClassDeclaration): Unit = TODO()
    fun visitInterfaceDeclaration(node: TS.InterfaceDeclaration): Unit = TODO()

    fun visitHeritageClause(node: TS.HeritageClause): Unit = TODO()

    fun visitConstructorDeclaration(node: TS.ConstructorDeclaration): Unit = TODO()
    fun visitConstructSignatureDeclaration(node: TS.ConstructorDeclaration): Unit = TODO()

    fun visitMethodDeclaration(node: TS.MethodDeclaration): Unit = TODO()
    fun visitPropertyDeclaration(node: TS.PropertyDeclaration): Unit = TODO()
    fun visitIndexSignature(node: TS.IndexSignatureDeclaration): Unit = TODO()
    fun visitSignatureDeclaration(node: TS.SignatureDeclaration): Unit = TODO()

    fun visitExportAssignment(node: TS.ExportAssignment): Unit = TODO()
}
