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

import typescript.*
import java.util.*

native
fun require(name: String): Any = noImpl

val SRC_FILE_PATH_ARG_INDEX = 2
val OUT_FILE_PATH_ARG_INDEX = 3
val TYPESCRIPT_DEFINITION_FILE_EXT = ".d.ts"
// TODO fix
val PATH_TO_LIB_D_TS = "/Users/user/dev/ts2kt/lib/lib.d.ts"

val fs = require("fs") as node.fs

val file2scriptSnapshot: MutableMap<String, dynamic> = hashMapOf("lib.d.ts" to getScriptSnapshotFromFile(PATH_TO_LIB_D_TS))
var currentVersion = 0
val version: () -> Int = { currentVersion }

private val reportedKinds = HashSet<Int>()

// todo move to utils?
fun getScriptSnapshotFromFile(path: String) = ts.ScriptSnapshot.fromString(fs.readFileSync(path).toString())

fun translate(srcPath: String): String {
    currentVersion++
    val host = FileSystemBasedLSH(file2scriptSnapshot, version)

    file2scriptSnapshot[srcPath] = getScriptSnapshotFromFile(srcPath)

    val documentRegistry = ts.createDocumentRegistry()
    val languageService = ts.createLanguageService(host, documentRegistry)

//    languageService.getSyntacticDiagnostics("foo.d.ts")
//    languageService.getSemanticDiagnostics("foo.d.ts")

    val fileNode = languageService.getSourceFile(srcPath)

    val path = require("path") as node.path
    val srcName = path.basename(srcPath, TYPESCRIPT_DEFINITION_FILE_EXT)

//    fun isAnyMember(name: String, signature: typescript.PullSignatureSymbol?): Boolean {
//        if (signature == null || signature.parameters == null) return false
//
//        return when (name) {
//            "equals" ->
//                signature.parameters.size() == 1 && signature.parameters[0].type?.name == "any"
//            // TODO check return type ???
//            "hashCode", "toString" ->
//                signature.parameters.size() == 0
//            else ->
//                false
//        }
//    }

    fun getOverrideChecker(isOverridesBy: /*typescript.PullSymbol.(signature: typescript.PullSignatureSymbol?)*/(Any) -> Boolean): (TS.Node) -> Boolean {
        return {
            false
//            val resolveResult = compiler.resolvePosition(it.start(), compiler.getDocument(srcResolvedPath)!!)
//            val signature = resolveResult.candidateSignature
//
//            val name = resolveResult.symbol.name
//
//            val f: (typescript.PullTypeSymbol) -> Boolean = {
//                    it.findMember(name)?.isOverridesBy(signature) ?: false
//                }
//
//            (isAnyMember(name,  signature) ||
//                    resolveResult.enclosingScopeSymbol.getExtendedTypes().any(f) ||
//                    resolveResult.enclosingScopeSymbol.getImplementedTypes().any(f))
        }
    }

    val typeScriptToKotlinWalker = TypeScriptToKotlinWalker(srcName,
            isOwnDeclaration = {
                true
//                val resolveResult = compiler.resolvePosition(it.start(), compiler.getDocument(srcResolvedPath)!!)
//                resolveResult.symbol.getDeclarations().all { it.scriptName == srcResolvedPath }
            },
            isOverride = getOverrideChecker { signature ->
                false
//                this.type != null &&
//                this.type.getCallSignatures().any {
//                    // TODO can use share it with many checks?
//                    val pullTypeResolutionContext = typescript.PullTypeResolutionContext()
//                    compiler.resolver.signatureIsAssignableToTarget(signature!!, it, pullTypeResolutionContext)
//                }
            },
            isOverrideProperty = getOverrideChecker { true }
    );

    // TODO fix
    // note we have side effect here
    typeScriptToKotlinWalker.visitList(fileNode)

    val ktTree = typeScriptToKotlinWalker.result

    var out = ktTree.toString()

    file2scriptSnapshot.remove(srcPath)

    return out
}

fun translateToFile(srcPath: String, outPath: String) {
    fs.writeFileSync(outPath, translate(srcPath));
}

native
object module {
    val parent: Any? = null
}

fun main(args: Array<String>) {
    if (module.parent != null) return

    val process = require("process") as node.process

    val srcPath = process.argv[SRC_FILE_PATH_ARG_INDEX];
    val outPath = process.argv[OUT_FILE_PATH_ARG_INDEX];

    console.log(srcPath);
    console.log(outPath);

    if (srcPath == null || outPath == null) return

    translateToFile(srcPath, outPath);
}
