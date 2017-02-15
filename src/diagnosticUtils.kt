package ts2kt.utils

import ts2kt.location
import ts2kt.str
import typescriptServices.ts.Node
import typescriptServices.ts.SyntaxKind

private enum class DiagnosticLevel {
    EXCEPTION,
    WARNING_WITH_STACKTRACE,
    WARNING,
    QUIET
}

private val diagnosticLevel: DiagnosticLevel = DiagnosticLevel.WARNING

fun report(message: String): String? = when (diagnosticLevel) {
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

fun assert(condition: Boolean, message: String) {
    if (!condition) report(message)
}

fun reportUnsupportedNode(node: Node): Nothing? {
    reportUnsupportedNodeAndGetMessage(node)
    return null
}

private val trackUnsupportedKinds = false
private val unsupportedKinds = HashMap<SyntaxKind, Int>()

fun reportUnsupportedNodeAndGetMessage(node: Node): String? {
    if (trackUnsupportedKinds) {
        unsupportedKinds[node.kind] = (unsupportedKinds[node.kind] ?: 0) + 1
    }
    return report("\"${node.kind.str}\" kind unsupported yet here! (${node.location()})")
}

// Used from tests
@Suppress("unused")
fun reportUnsupportedKinds() {
    if (!trackUnsupportedKinds) {
        console.warn("Tracking unsupported node kinds is disabled")
        return
    }

    console.warn("Unsupported node kinds (${unsupportedKinds.size}):")
    console.warn("count\tname(id)")
    unsupportedKinds.toList().sortedByDescending { it.second }.forEach {
        console.warn("${it.second}\t${it.first.str} (${it.first})")
    }
}
