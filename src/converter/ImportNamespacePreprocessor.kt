package converter

import ts2kt.toKotlinTypeName
import typescript.EntityName
import typescriptServices.ts.*

class ImportNamespacePreprocessor(private val currentNamespace: String) : BaseVisitor() {
    private val namespaceAliases = mutableMapOf<String, String>()

    override fun visitImportEqualsDeclaration(node: ImportEqualsDeclaration) {
        val alias = node.name?.text ?: return
        namespaceAliases[alias] = node.moduleReference.unsafeCast<EntityName>().toKotlinTypeName()
    }

    override fun visitModuleDeclaration(node: ModuleDeclaration) {
        if ((node.flags.unsafeCast<Int>() and NodeFlags.Namespace.unsafeCast<Int>()) == 0) return

        val name = node.name.unsafeCast<Node>()
        if (name.kind != SyntaxKind.Identifier) return

        val alias = name.unsafeCast<Identifier>().text
        namespaceAliases[alias] = if (currentNamespace.isNotEmpty()) "$currentNamespace.$alias" else alias
    }

    fun putAliases(aliases: kotlin.collections.Map<String, String>) {
        namespaceAliases += aliases
    }

    fun createNamespaceResolver(): NamespaceResolver {
        val incompleteResolver = NamespaceResolver(namespaceAliases)
        val resolvedAliases = namespaceAliases.entries.associate { (alias, namespaceName) ->
            alias to incompleteResolver.resolveNamespace(namespaceName)
        }
        return NamespaceResolver(resolvedAliases)
    }
}