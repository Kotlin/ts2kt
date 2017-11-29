package converter

import ts2kt.*
import typescriptServices.ts.*

open class BaseVisitor : Visitor {
    override fun visitModuleDeclaration(node: ModuleDeclaration) {
        visitList(node.body.unsafeCast<Node>())
    }

    override fun visitFunctionDeclaration(node: FunctionDeclaration) {
    }

    override fun visitTypeAliasDeclaration(node: TypeAliasDeclaration) {
    }

    override fun visitVariableStatement(node: VariableStatement) {
    }

    override fun visitEnumDeclaration(node: EnumDeclaration) {
    }

    override fun visitClassDeclaration(node: ClassDeclaration) {
        node.members.arr.forEach { visitNode(this, it) }
    }

    override fun visitInterfaceDeclaration(node: InterfaceDeclaration) {
        node.members.arr.forEach { visitNode(this, it) }
    }

    override fun visitHeritageClause(node: HeritageClause) {
    }

    override fun visitConstructorDeclaration(node: ConstructorDeclaration) {
    }

    override fun visitConstructSignatureDeclaration(node: ConstructorDeclaration) {
    }

    override fun visitMethodDeclaration(node: MethodDeclaration) {
    }

    override fun visitPropertyDeclaration(node: PropertyDeclaration) {
    }

    override fun visitIndexSignature(node: IndexSignatureDeclaration) {
    }

    override fun visitSignatureDeclaration(node: SignatureDeclaration) {
    }

    override fun visitExportAssignment(node: ExportAssignment) {
    }

    override fun visitImportEqualsDeclaration(node: ImportEqualsDeclaration) {
    }

    fun visitList(node: Node) {
        forEachChild(this, node)
    }
}