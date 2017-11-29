/*
 * Copyright 2013-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ts2kt

import node.fs
import node.module
import node.path
import node.process
import ts2kt.kotlin.ast.stringify
import ts2kt.utils.DiagnosticLevel
import ts2kt.utils.diagnosticLevel
import ts2kt.utils.reportUnsupportedKinds
import ts2kt.utils.trackUnsupportedKinds

private val KOTLIN_FILE_EXT = ".kt"

// Used from tests
@Suppress("unused")
fun translateToFile(srcPath: String, outPath: String) {
    val srcName = path.basename(srcPath, TYPESCRIPT_DEFINITION_FILE_EXT)
    val packageParts = translate(srcPath, srcName)

    val out =
            if (packageParts.isNotEmpty()) {
                packageParts.joinToString("\n// ${"-".repeat(90)}\n") {
                            it.stringify(packagePartPrefix = srcName)
                        }
            }
            else "// NO DECLARATIONS"

    fs.writeFileSync(outPath, out)
}

// TODO share more code between [translateToDir] and [translateToFile]
fun translateToDir(sources: List<String>, outDir: String, libraries: List<String> = emptyList()) {
    for (src in sources) {
        console.log("Converting $src")
        val baseSrcName = path.basename(src, TYPESCRIPT_DEFINITION_FILE_EXT)
        val packageParts = translate(src, baseSrcName)

        if (packageParts.isEmpty()) {
            console.log("Nothing was converted")
            continue
        }

        console.log("Save declarations:")

        packageParts.forEach {
            val outFileName = baseSrcName + (if (it.fqName.isNotEmpty()) "." else "") + it.fqName.joinToString(".") + KOTLIN_FILE_EXT
            val outFilePath = outDir + "/" + outFileName

            console.log("\t$outFilePath")

            val imports = listOf(
                "kotlin.js.*",
                "kotlin.js.Json",
                "org.khronos.webgl.*",
                "org.w3c.dom.*",
                "org.w3c.dom.events.*",
                "org.w3c.dom.parsing.*",
                "org.w3c.dom.svg.*",
                "org.w3c.dom.url.*",
                "org.w3c.fetch.*",
                "org.w3c.files.*",
                "org.w3c.notifications.*",
                "org.w3c.performance.*",
                "org.w3c.workers.*",
                "org.w3c.xhr.*")

            val suppressedDiagnostics = listOf(
                    "INTERFACE_WITH_SUPERCLASS",
                    "OVERRIDING_FINAL_MEMBER",
                    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
                    "CONFLICTING_OVERLOADS")

            fs.writeFileSync(outFilePath, it.stringify(packagePartPrefix = null, topLevel = true, additionalImports = imports, suppressedDiagnostics = suppressedDiagnostics))
        }
    }
}

data class CliArguments(val sources: List<String>, val outDir: String, val libraries: List<String>)

private fun printUsage(program: String) {
    console.log("""
                Usage: $program [<options>] <d.ts files>
                where possible options include:
                    -d <path>                   Destination directory for files with converted declarations,
                                                current directory is used by default
                    -h                          Print a synopsis of standard options
                    -v, -version                Print version
                    -X                          Print a synopsis of advanced options
                """.trimIndent())
}

fun parseArguments(): CliArguments? {
    fun Iterator<String>.readArg(): String? {
        if (!hasNext()) return null
        val v = next()
        if (v.startsWith("-")) return null
        return v
    }

    val program = "ts2kt"

    fun printVersion() {
        val version = js("require('./package.json')").version
        console.log("$program version: $version")
    }

    val args = process.argv.drop(2)

    if (args.isEmpty()) {
        printUsage(program)
        return null
    }

    val it = args.iterator()

    val other = mutableListOf<String>()

    var destination: String? = null

    while (it.hasNext()) {
        val arg = it.next()

        when (arg) {
            "-h" -> {
                printUsage(program)
                return null
            }
            "-d" -> {
                val p = it.readArg()
                if (p == null) {
                    console.error("'-d' should be followed by path to destination directory")
                    return null
                }
                destination = p
            }
            "-l" -> {
                console.error("'-l' not supported yet")
                return null
            }
            "-v", "-version" -> {
                printVersion()
                return null
            }
            "-X" -> {
                console.log("""
                            Usage: $program <options> <d.ts files>
                            where possible options include:
                                -Xdiagnostic-level <level>  How report diagnostics, ${DiagnosticLevel.DEFAULT} by default,
                                        where level can be any of {${DiagnosticLevel.values().joinToString()}}
                                -Xtrack-unsupported-kinds   Enable tracking unsupported node kinds and print statistic at the finish
                            """.trimIndent())
                return null
            }
            "-Xdiagnostic-level" -> {
                val p = it.readArg()
                val level = p?.let { DiagnosticLevel.valueOf(p) }
                if (level == null) {
                    console.error("'-Xdiagnostic-level' should be followed by one of " + DiagnosticLevel.values().joinToString())
                    return null
                }
                diagnosticLevel = level
            }
            "-Xtrack-unsupported-kinds" -> {
                trackUnsupportedKinds = true
            }
            else -> {
                other += arg
            }
        }
    }

    val (_, allSources) = other.partition { it.startsWith("-") }

    val sources = allSources.filter { it.endsWith(TYPESCRIPT_DEFINITION_FILE_EXT) }

    printVersion()

    if (sources.size != allSources.size) {
        console.error("$program supports to convert only TypeScript definition files (d.ts)")
        return null
    }

    if (sources.isEmpty()) {
        console.error("No files to convert")
        return null
    }

    return CliArguments(sources, destination ?: ".", emptyList())
}

fun main(args: Array<String>) {
    // do nothing when it loaded as library
    if (module.parent != null) return

    val (sources, destination, libraries) = parseArguments() ?: return

    translateToDir(sources, destination, libraries)

    if (trackUnsupportedKinds) {
        reportUnsupportedKinds()
    }
}
