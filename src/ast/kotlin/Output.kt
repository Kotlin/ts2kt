package ts2kt.kotlin.ast

import ts2kt.utils.assert

class Output(indentWidth: Int = 4) {
    private var buffer = ""

    private val singleIndent = " ".repeat(indentWidth)
    private val indentCache = listOf("") as MutableList<String>
    private var currentDepth = 0
    private var indent = ""

    override fun toString(): String {
        return buffer
    }

    fun print(value: String) {
        buffer += value
    }

    fun println(value: String) {
        print(value)
        println()
    }

    fun println() {
        print("\n")
    }

    fun printIndent() {
        print(indent)
    }

    fun printWithIndent(value: String) {
        printIndent()
        print(value)
    }

    fun printlnWithIndent(value: String) {
        printWithIndent(value)
        println()
    }

    fun printlnWithIndent() {
        printWithIndent("\n")
    }

    private fun getIndent(depth: Int): String {
        assert(depth >= 0, "The indent index should be >= 0")
        if (depth < indentCache.size) return indentCache[depth]

        for (i in indentCache.size..depth) {
            indentCache.add(indentCache[i - 1] + singleIndent)
        }

        return indentCache[depth]
    }

    fun pushIndent() {
        currentDepth++
        indent = getIndent(currentDepth)
    }

    fun popIndent() {
        currentDepth--
        indent = getIndent(currentDepth)
    }
}

fun Output.indent(f: Output.() -> Unit) {
    pushIndent()
    f()
    popIndent()
}
