package converter

import ts2kt.*
import ts2kt.kotlin.ast.KtAnnotation
import ts2kt.kotlin.ast.KtMember
import ts2kt.kotlin.ast.KtTypeAlias
import typescript.identifierName
import typescriptServices.ts.*

class TypeAliasPreprocessor(
        private val namespaceResolver: NamespaceResolver,
        defaultAnnotations: List<KtAnnotation>,
        val declarations: MutableList<KtMember>,
        private val typeAliases: MutableList<KtTypeAlias>
) : BaseVisitor() {
    val typeMapper = ObjectTypeToKotlinTypeMapperImpl(namespaceResolver, defaultAnnotations, declarations, typeAliases)

    override fun visitTypeAliasDeclaration(node: TypeAliasDeclaration) {
        val newTypeMapper = typeMapper.withTypeParameters(node.typeParameters)
        val typeParams = node.typeParameters?.toKotlinTypeParams(newTypeMapper)
        typeAliases.add(KtTypeAlias(node.identifierName.text, typeParams, node.type.toKotlinTypeUnion(newTypeMapper)))
    }
}