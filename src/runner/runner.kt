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

import js.JsError
import node.require
import ts2kt.utils.cast
import ts2kt.utils.hasFlag
import ts2kt.utils.push
import ts2kt.utils.shift
import typescript.TS
import typescript.getDirectoryPath
import typescript.normalizePath
import java.util.*
import kotlin.js.native

// HACK to replace `Kotlin.throwNPE` since Kotlin Exceptions unusable now because don't have stacktrace
private val init = run {
    js("Kotlin").throwNPE = { message: String -> throw JsError(message) }
}

val SRC_FILE_PATH_ARG_INDEX = 2
val OUT_FILE_PATH_ARG_INDEX = 3
val TYPESCRIPT_DEFINITION_FILE_EXT = ".d.ts"
val PATH_TO_LIB_D_TS = "lib/lib.d.ts"

val fs: node.fs = require("fs")

internal val reportedKinds = HashSet<Int>()

private val file2scriptSnapshotCache: MutableMap<String, TS.IScriptSnapshot> = hashMapOf()

// TODO drop? Probably we don't need own caching
private fun getScriptSnapshotFromFile(path: String): TS.IScriptSnapshot {
    var scriptSnapshot  = file2scriptSnapshotCache[path]

    if (scriptSnapshot == null) {
        scriptSnapshot = TS.ScriptSnapshot.fromString(fs.readFileSync(path).toString())
        file2scriptSnapshotCache[path] = scriptSnapshot
    }

    return scriptSnapshot
}

val LIB_D_TS_WITH_SNAPSHOT = "lib.d.ts" to getScriptSnapshotFromFile(PATH_TO_LIB_D_TS)

val host = FileSystemBasedLSH(mapOf(), "")
val documentRegistry = TS.createDocumentRegistry()
val languageService = TS.createLanguageService(host, documentRegistry)

fun translate(srcPath: String): String {
    val normalizeSrcPath = TS.normalizePath(srcPath)

    val file2scriptSnapshot = hashMapOf(LIB_D_TS_WITH_SNAPSHOT, normalizeSrcPath to getScriptSnapshotFromFile(normalizeSrcPath))

    val filesToProcess = arrayOf(normalizeSrcPath)
    while(filesToProcess.isNotEmpty()) {
        val curFile = filesToProcess.shift()
        val curDir = TS.getDirectoryPath(curFile) + "/"

        val result = TS.preProcessFile(file2scriptSnapshot[curFile]!!.getText())

        val referencedFiles = result.referencedFiles
        for (referencedFile in referencedFiles) {
            val referencedFilePath = TS.normalizePath(curDir + referencedFile.fileName)

            if (referencedFilePath in file2scriptSnapshot) continue

            filesToProcess.push(referencedFilePath)
            file2scriptSnapshot[referencedFilePath] = getScriptSnapshotFromFile(referencedFilePath)
        }
    }

    host.file2scriptSnapshot = file2scriptSnapshot
    host.currentDirectory = TS.getDirectoryPath(normalizeSrcPath)

//    languageService.getSyntacticDiagnostics("foo.d.ts")
//    languageService.getSemanticDiagnostics("foo.d.ts")

//    val fileNode = languageService.getSourceFile(normalizeSrcPath)
    val fileNode = languageService.getProgram().getSourceFile(normalizeSrcPath)

    val path: node.path = require("path")
    val srcName = path.basename(normalizeSrcPath, TYPESCRIPT_DEFINITION_FILE_EXT)

    inline fun isAnyMember(node: TS.MethodDeclaration): Boolean {
        val params = node.parameters.arr

        return when (node.propertyName?.text) {
            "equals" ->
                params.size == 1 && params[0].type?.let { it.kind === TS.SyntaxKind.AnyKeyword } ?: true
            // TODO check return type ???
            "hashCode", "toString" ->
                params.size == 0
            else ->
                false
        }
    }

    inline fun isOverrideHelper(
            node: TS.Declaration,
            crossinline f: (TS.TypeChecker, TS.Type, String) -> Boolean
    ): Boolean {
        val parentNode = node.parent!!.cast<TS.ClassDeclaration>()

        if (parentNode.heritageClauses == null) return false

        val typechecker = languageService.getProgram().getTypeChecker()

        val nodeName = node.declarationName!!.unescapedText

        val visited = hashSetOf<TS.Type>()

        fun TS.ClassDeclaration.forEachBaseTypeNode(): Boolean {
            val heritages = heritageClauses ?: return false

            for (heritage in heritages.arr) {
                val types = heritage.types ?: continue

                for (typeNode in types.arr) {
                    val type = typechecker.getTypeAtLocation(typeNode) ?: continue

                    if (!visited.add(type)) continue

                    if (f(typechecker, type, nodeName)) return true

                    if ((type.symbol?.declarations?.get(0) as? TS.ClassDeclaration)?.forEachBaseTypeNode() ?: false) return true
                }
            }

            return false
        }

        return parentNode.forEachBaseTypeNode()
    }

    fun TS.Type.isSubtypeOf(other: TS.Type): Boolean {
        if (this == other) return true

        // other as Any
//        if (other == null) return true

        // other is Any?
        if (hasFlag(other.flags, TS.TypeFlags.Any)) return true

        // this as Any
//        if (this == null) return false

        return getBaseTypes()?.any { it.isSubtypeOf(other) } ?: false
    }

    fun TS.TypeChecker.getTypeOfSymbol(symbol: TS.Symbol) : TS.Type =
            // TODO find better solution
            getTypeOfSymbolAtLocation(symbol, symbol.valueDeclaration.asDynamic().type)

    fun TS.TypeChecker.isOverride(candidate: TS.Signature, other: TS.Signature): Boolean {
        if (candidate.parameters.size != other.parameters.size) return false

        // no need to check the return type.  If they are incompatible, It will be a Kotlin compilation error.

        for (i in candidate.parameters.indices) {
            val candidateType = getTypeOfSymbol(candidate.parameters[i])
            val otherType = getTypeOfSymbol(other.parameters[i])

            if (candidateType != otherType) return false
        }

        return true
    }

    fun isOverride(node: TS.MethodDeclaration): Boolean {
        if (isAnyMember(node)) return true

        var nodeSignature: TS.Signature? = null

        return isOverrideHelper(node) { typechecker, type, nodeName ->
            nodeSignature = nodeSignature ?: typechecker.getSignatureFromDeclaration(node)

            val candidates = typechecker.getPropertyOfType(type, nodeName)

            candidates?.declarations?.any {
                // TODO add test
                if (it.kind === TS.SyntaxKind.PropertyDeclaration || it.kind === TS.SyntaxKind.PropertySignature) return@any false

                val signature: TS.Signature = when (it.kind) {
                    TS.SyntaxKind.MethodSignature,
                    TS.SyntaxKind.MethodDeclaration -> typechecker.getSignatureFromDeclaration(it.cast<TS.SignatureDeclaration>())
                    else -> unsupportedNode(it)
                }


                typechecker.isOverride(nodeSignature!!, signature)
            } ?: false
        }
    }

    fun isOverrideProperty(node: TS.PropertyDeclaration): Boolean {
        return isOverrideHelper(node) { typechecker, type, nodeName ->
            // no need to check the property type.  If they are incompatible, It will be a Kotlin compilation error.
            return@isOverrideHelper typechecker.getPropertyOfType(type, nodeName) != null
        }
    }


    val typeScriptToKotlinWalker = TypeScriptToKotlinWalker(srcName,
            isOwnDeclaration = {
                val definitions = languageService.getDefinitionAtPosition(normalizeSrcPath, it.end)
                definitions.all { it.fileName == normalizeSrcPath }
            },
            isOverride = ::isOverride,
            isOverrideProperty = ::isOverrideProperty
    )

    // TODO fix
    // note we have side effect here
    typeScriptToKotlinWalker.visitList(fileNode)

    val ktTree = typeScriptToKotlinWalker.result

    val out = ktTree.toString()

    return out
}

fun translateToFile(srcPath: String, outPath: String) {
    fs.writeFileSync(outPath, translate(srcPath))
}

@native
object module {
    val parent: Any? = null
}

fun main(args: Array<String>) {
    if (module.parent != null) return

    val process: node.process = require("process")

    val srcPath = process.argv[SRC_FILE_PATH_ARG_INDEX]
    val outPath = process.argv[OUT_FILE_PATH_ARG_INDEX]

    console.log(srcPath)
    console.log(outPath)

    if (srcPath == null || outPath == null) return

    translateToFile(srcPath, outPath)
}
