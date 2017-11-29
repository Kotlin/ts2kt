package converter

class NamespaceResolver(val aliases: Map<String, String>) {
    fun resolveNamespace(fqn: String): String {
        val firstDotIndex = fqn.indexOf('.').let { if (it < 0) fqn.length else it }
        val mainPart = fqn.substring(0, firstDotIndex)

        val namespaceInMap = aliases[mainPart]
        val resolvedNamespace = if (namespaceInMap != null && namespaceInMap != mainPart) {
            resolveNamespace(namespaceInMap)
        }
        else {
            mainPart
        }

        return resolvedNamespace + fqn.substring(firstDotIndex)
    }
}
