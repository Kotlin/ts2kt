package ts2kt

import typescript.*

@native
interface Visitor {
    public open fun visitModuleDeclaration(node: TS.ModuleDeclaration): Unit = noImpl

    public open fun visitFunctionDeclaration(node: TS.FunctionDeclaration): Unit = noImpl
    public open fun visitVariableStatement(node: TS.VariableStatement): Unit = noImpl

    public open fun visitEnumDeclaration(node: TS.EnumDeclaration): Unit = noImpl

    public open fun visitClassDeclaration(node: TS.ClassDeclaration): Unit = noImpl
    public open fun visitInterfaceDeclaration(node: TS.InterfaceDeclaration): Unit = noImpl

    public open fun visitHeritageClause(node: TS.HeritageClause): Unit = noImpl

    public open fun visitConstructorDeclaration(node: TS.ConstructorDeclaration): Unit = noImpl
    public open fun visitConstructSignatureDeclaration(node: TS.ConstructorDeclaration): Unit = noImpl

    public open fun visitMethodDeclaration(node: TS.MethodDeclaration): Unit = noImpl
    public open fun visitPropertyDeclaration(node: TS.PropertyDeclaration): Unit = noImpl
    public open fun visitIndexSignature(node: TS.IndexSignatureDeclaration): Unit = noImpl
    public open fun visitSignatureDeclaration(node: TS.SignatureDeclaration): Unit = noImpl

    public open fun visitExportAssignment(node: TS.ExportAssignment): Unit = noImpl
}
