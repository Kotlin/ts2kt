package ts2kt.utils

import ts2kt.location
import ts2kt.str
import typescriptServices.ts.Node
import typescriptServices.ts.SyntaxKind

internal enum class DiagnosticLevel {
    EXCEPTION,
    WARNING_WITH_STACKTRACE,
    WARNING,
    QUIET;

    companion object {
        val DEFAULT = WARNING
    }
}

internal var diagnosticLevel: DiagnosticLevel = DiagnosticLevel.DEFAULT

internal fun report(message: String, maxLevelToShow: DiagnosticLevel? = null): String? {
    if (maxLevelToShow != null && diagnosticLevel > maxLevelToShow) return null

    return when (diagnosticLevel) {
        DiagnosticLevel.EXCEPTION ->
            throw IllegalStateException(message)
        DiagnosticLevel.WARNING_WITH_STACKTRACE -> {
            console.warn("ts2kt: " + message)
            console.warn("Stacktrace:" + Exception().asDynamic().stack)
            message
        }
        DiagnosticLevel.WARNING -> {
            console.warn("ts2kt: " + message)
            message
        }
        DiagnosticLevel.QUIET ->
            null
    }
}

fun assert(condition: Boolean, message: String) {
    if (!condition) report(message)
}

fun reportUnsupportedNode(node: Node): Nothing? {
    reportUnsupportedNodeAndGetMessage(node)
    return null
}

internal var trackUnsupportedKinds = false
private val unsupportedKinds = HashMap<SyntaxKind, Int>()

fun reportUnsupportedNodeAndGetMessage(node: Node): String? {
    if (trackUnsupportedKinds) {
        unsupportedKinds[node.kind] = (unsupportedKinds[node.kind] ?: 0) + 1
    }
    return report("\"${node.kind.str}\" kind unsupported yet here! (${node.location()})")
}

fun reportUnsupportedKinds() {
    if (!trackUnsupportedKinds) {
        console.warn("Tracking unsupported node kinds is disabled")
        return
    }

    console.warn("Unsupported node kinds (${unsupportedKinds.size}):")
    console.warn("count\t\tname(id)")
    unsupportedKinds.toList().sortedByDescending { it.second }.forEach {
        console.warn("${it.second}\t\t${it.first.str} (${it.first})")
    }
}
