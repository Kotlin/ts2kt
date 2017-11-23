package converter

import ts2kt.*
import ts2kt.kotlin.ast.KtAnnotation
import ts2kt.kotlin.ast.KtMember
import ts2kt.kotlin.ast.KtTypeAlias
import typescript.identifierName
import typescriptServices.ts.*

class TypeAliasPreprocessor(
        defaultAnnotations: List<KtAnnotation>,
        val declarations: MutableList<KtMember>,
        private val typeAliases: MutableList<KtTypeAlias>
) : Visitor {
    val typeMapper = ObjectTypeToKotlinTypeMapperImpl(defaultAnnotations, declarations, typeAliases)

    override fun visitModuleDeclaration(node: ModuleDeclaration) {
        visitList(node.body.unsafeCast<Node>())
    }

    override fun visitFunctionDeclaration(node: FunctionDeclaration) {
    }

    override fun visitTypeAliasDeclaration(node: TypeAliasDeclaration) {
        val newTypeMapper = typeMapper.withTypeParameters(node.typeParameters)
        val typeParams = node.typeParameters?.toKotlinTypeParams(newTypeMapper)
        typeAliases.add(KtTypeAlias(node.identifierName.text, typeParams, node.type.toKotlinTypeUnion(newTypeMapper)))
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

    fun visitList(node: Node) {
        forEachChild(this, node)
    }
}