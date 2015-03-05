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
import node.*
import ts2kt.utils.*

native
fun require(name: String): Any = noImpl

val SRC_FILE_PATH_ARG_INDEX = 2
val OUT_FILE_PATH_ARG_INDEX = 3
val TYPESCRIPT_DEFINITION_FILE_EXT = ".d.ts"
// TODO fix
val PATH_TO_LIB_D_TS = "/Users/user/dev/ts2kt/lib/lib.d.ts"

val fs = require("fs") as node.fs

private val reportedKinds = HashSet<Int>()

val file2scriptSnapshotCache: MutableMap<String, dynamic> = hashMapOf()

// todo move to utils?
fun getScriptSnapshotFromFile(path: String): dynamic {
    var scriptSnapshot  = file2scriptSnapshotCache[path]

    if (scriptSnapshot == null) {
        scriptSnapshot = ts.ScriptSnapshot.fromString(fs.readFileSync(path).toString())
        file2scriptSnapshotCache[path] = scriptSnapshot
    }

    return scriptSnapshot
}

fun translate(srcPath: String): String {
    val file2scriptSnapshot: MutableMap<String, dynamic> = hashMapOf("lib.d.ts" to getScriptSnapshotFromFile(PATH_TO_LIB_D_TS))
    var currentVersion = 1
    val version: () -> Int = { currentVersion }

    val normalizeSrcPath = ts.normalizePath(srcPath)
    val dir = ts.getDirectoryPath(normalizeSrcPath)
    val host = FileSystemBasedLSH(file2scriptSnapshot, dir, version)

    file2scriptSnapshot[normalizeSrcPath] = getScriptSnapshotFromFile(normalizeSrcPath)

    val documentRegistry = ts.createDocumentRegistry()
    val languageService = ts.createLanguageService(host, documentRegistry)

//    languageService.getSyntacticDiagnostics("foo.d.ts")
//    languageService.getSemanticDiagnostics("foo.d.ts")

    val fileNode = languageService.getSourceFile(normalizeSrcPath)

    val filesToProcess = array(normalizeSrcPath)
    while(filesToProcess.isNotEmpty()) {
        val curFile = filesToProcess.shift()
        val curDir = ts.getDirectoryPath(curFile) + "/"

        var result = ts.preProcessFile(file2scriptSnapshot[curFile].getText());

        for (referencedFile in result.referencedFiles: Array<dynamic>) {
            val referencedFilePath = ts.normalizePath(curDir + referencedFile.filename)

            if (referencedFilePath in file2scriptSnapshot) continue

            filesToProcess.push(referencedFilePath)
            file2scriptSnapshot[referencedFilePath] = getScriptSnapshotFromFile(referencedFilePath)
        }
//        currentVersion++
    }
    // replace with `refresh()`?
    currentVersion++
//    val fileNode = languageService.getSourceFile(normalizeSrcPath)
    val fileNode = languageService.getProgram().getSourceFile(normalizeSrcPath)

    val path = require("path") as node.path
    val srcName = path.basename(normalizeSrcPath, TYPESCRIPT_DEFINITION_FILE_EXT)

    [inline] fun isAnyMember(node: TS.MethodDeclaration): Boolean {
        val params = node.parameters.arr

        return when (node.declarationName?.text) {
            "equals" ->
                params.size() == 1 && params[0].type?.let { it.kind === TS.SyntaxKind.AnyKeyword } ?: true
            // TODO check return type ???
            "hashCode", "toString" ->
                params.size() == 0
            else ->
                false
        }
    }

    [inline] fun isOverrideHelper(
            node: TS.Declaration,
            [inlineOptions(InlineOption.ONLY_LOCAL_RETURN)] f: (TS.TypeChecker, TS.Type, String) -> Boolean
    ): Boolean {
        val parentNode = node.parent!! as TS.ClassDeclaration

        if (parentNode.heritageClauses == null) return false

        val typechecker: TS.TypeChecker = languageService.getTypecheker()

        val nodeName = node.declarationName!!.text

        val visited = hashSetOf<TS.Type>()

        fun TS.ClassDeclaration.forEachBaseTypeNode(): Boolean {
            val heritages = heritageClauses
            if (heritages == null) return false

            for (heritage in heritages.arr) {
                val types = heritage.types
                if (types == null) continue

                for (typeNode in types.arr) {
                    val type = typechecker.getTypeAtLocation(typeNode)

                    if (!visited.add(type)) continue

                    if (f(typechecker, type, nodeName)) return true

                    if ((type.symbol?.declarations?.get(0) as? TS.ClassDeclaration)?.forEachBaseTypeNode() ?: false) return true
                }
            }

            return false
        }

        return parentNode.forEachBaseTypeNode()
    }

    fun isOverride(node: TS.MethodDeclaration): Boolean {
        if (isAnyMember(node)) return true

        var nodeSignature: TS.Signature? = null

        return isOverrideHelper(node) { (typechecker, type, nodeName) ->
            if (nodeSignature == null) {
                nodeSignature = typechecker.getSignatureFromDeclaration(node)
            }

            val candidates = typechecker.getPropertyOfType(type, nodeName)

            candidates?.declarations?.any {
                val signature = typechecker.getSignatureFromDeclaration(it as TS.SignatureDeclaration)
                (typechecker: dynamic).isSignatureAssignableTo(nodeSignature, signature)
            } ?: false
        }
    }

    fun isOverrideProperty(node: TS.PropertyDeclaration): Boolean {
        return isOverrideHelper(node) { (typechecker, type, nodeName) ->
            typechecker.getPropertyOfType(type, nodeName)?.valueDeclaration?.kind === TS.SyntaxKind.Property
        }
    }


    val typeScriptToKotlinWalker = TypeScriptToKotlinWalker(srcName,
            isOwnDeclaration = {
                val definitions: Array<dynamic> = languageService.getDefinitionAtPosition(normalizeSrcPath, it.end)
                definitions.all { it.fileName === normalizeSrcPath }
            },
            isOverride = ::isOverride,
            isOverrideProperty = ::isOverrideProperty
    );

    // TODO fix
    // note we have side effect here
    typeScriptToKotlinWalker.visitList(fileNode)

    val ktTree = typeScriptToKotlinWalker.result

    var out = ktTree.toString()

    // TODO drop?
    file2scriptSnapshot.remove(normalizeSrcPath)

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
