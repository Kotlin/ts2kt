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

import js.debug.console
import typescript.typescript
import ts2kt.utils.*
import typescript.PositionedElement

[suppress("UNUSED_PARAMETER")]
native
fun require(name: String): Any = noImpl

val SRC_FILE_PATH_ARG_INDEX = 2;
val OUT_FILE_PATH_ARG_INDEX = 3;
val TYPESCRIPT_DEFINITION_FILE_EXT = ".d.ts";
//val LIB_D_TS = "testDefinitelyTyped/DefinitelyTyped/_infrastructure/tests/typescript/1.0.0/lib.d.ts"
//val LIB_D_TS_RESOLVED_FILE: typescript.IResolvedFile = eval("""({ path:"$LIB_D_TS", referencedFiles: [], importedFiles: [] })""")

fun typescript.TypeScriptCompiler.addFile(resolvedFile: typescript.IResolvedFile, batch: typescript.BatchCompiler) {
    var sourceFile = batch.getSourceFile(resolvedFile.path);
    addSourceUnit(resolvedFile.path, sourceFile.scriptSnapshot, sourceFile.byteOrderMark, 0, false, resolvedFile.referencedFiles);
}

fun translate(srcPath: String): String {
    val compiler = typescript.TypeScriptCompiler(typescript.DiagnosticsLogger(typescript.IO));
    val batch = typescript.BatchCompiler(typescript.IO);
    batch.compilationSettings.noLib = true
    batch.inputFiles = array(srcPath);
    batch.resolve();

//    batch.resolvedFiles.splice(0, 0, LIB_D_TS_RESOLVED_FILE)

//    var compiler = typescript.TypeScriptCompiler(batch.logger, batch.compilationSettings);

    for (resolvedFile in batch.resolvedFiles) {
        compiler.addFile(resolvedFile, batch);
    }

    compiler.pullTypeCheck();

    // TODO report diagnostics and exit here?

    val path = require("path") as node.path
    val srcName = path.basename(srcPath, TYPESCRIPT_DEFINITION_FILE_EXT)
    val srcResolvedPath = batch.resolvePath(srcPath)

    fun isAnyMember(name: String, signature: typescript.PullSignatureSymbol?): Boolean {
        if (signature == null || signature.parameters == null) return false

        return when (name) {
            "equals" ->
                signature.parameters.size == 1 && signature.parameters[0].`type`?.name == "any"
            // TODO check return type ???
            "hashCode", "toString" ->
                signature.parameters.size == 0
            else ->
                false
        }
    }

    fun getOverrideChecker(isOverridesBy: typescript.PullSymbol.(signature: typescript.PullSignatureSymbol?) -> Boolean): (PositionedElement) -> Boolean {
        return {
            val resolveResult = compiler.resolvePosition(it.start(), compiler.getDocument(srcResolvedPath)!!)
            val signature = resolveResult.candidateSignature

            val name = resolveResult.symbol.name

            val f: (typescript.PullTypeSymbol) -> Boolean = {
                    it.findMember(name)?.isOverridesBy(signature) ?: false
                }

            (isAnyMember(name,  signature) ||
                    resolveResult.enclosingScopeSymbol.getExtendedTypes().any(f) ||
                    resolveResult.enclosingScopeSymbol.getImplementedTypes().any(f))
        }
    }

    val typeScriptToKotlinWalker = TypeScriptToKotlinWalker(srcName,
            isOwnDeclaration = {
                val resolveResult = compiler.resolvePosition(it.start(), compiler.getDocument(srcResolvedPath)!!)
                resolveResult.symbol.getDeclarations().all { it.scriptName == srcResolvedPath }
            },
            isOverride = getOverrideChecker { signature ->
                this.`type` != null &&
                this.`type`.getCallSignatures().any {
                    // TODO can use share it with many checks?
                    val pullTypeResolutionContext = typescript.PullTypeResolutionContext()
                    compiler.resolver.signatureIsAssignableToTarget(signature!!, it, pullTypeResolutionContext)
                }
            },
            isOverrideProperty = getOverrideChecker { true }
    );

    val tsTree = compiler.getSyntaxTree(srcResolvedPath);
    tsTree.sourceUnit().accept(typeScriptToKotlinWalker)

    val ktTree = typeScriptToKotlinWalker.result

    var out = ktTree.toString()

    return out
}

fun translateToFile(srcPath: String, outPath: String) {
    val fs = require("fs") as node.fs
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
