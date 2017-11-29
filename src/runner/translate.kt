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

import node.__dirname
import node.fs
import ts2kt.kotlin.ast.KtPackagePart
import ts2kt.kotlin.ast.isNotAnnotatedAsFake
import ts2kt.utils.cast
import ts2kt.utils.push
import ts2kt.utils.reportUnsupportedNode
import ts2kt.utils.shift
import typescript.declarationName
import typescript.propertyName
import typescriptServices.ts.*
import typescriptServices.ts.ScriptSnapshot.fromString

internal val TYPESCRIPT_DEFINITION_FILE_EXT = ".d.ts"
private val PATH_TO_LIB_D_TS =
        (listOf(getDefaultLibFilePath(getDefaultCompilerOptions())) + listOf(".", __dirname).map { it + "/lib/lib.d.ts" }).first { fs.existsSync(it) }

private val file2scriptSnapshotCache: MutableMap<String, IScriptSnapshot> = hashMapOf()

// TODO drop? Probably we don't need own caching
private fun getScriptSnapshotFromFile(path: String): IScriptSnapshot {
    var scriptSnapshot  = file2scriptSnapshotCache[path]

    if (scriptSnapshot == null) {
        scriptSnapshot = fromString(fs.readFileSync(path).toString())
        file2scriptSnapshotCache[path] = scriptSnapshot
    }

    return scriptSnapshot
}

private val LIB_D_TS_WITH_SNAPSHOT = "lib.d.ts" to getScriptSnapshotFromFile(PATH_TO_LIB_D_TS)

private val host = FileSystemBasedLSH(mapOf(), "")
private val documentRegistry = createDocumentRegistry()
private val languageService = createLanguageService(host, documentRegistry)

fun translate(srcPath: String, basePackageName: String): List<KtPackagePart> {
    val normalizeSrcPath = normalizePath(srcPath)

    val file2scriptSnapshot = hashMapOf(LIB_D_TS_WITH_SNAPSHOT, normalizeSrcPath to getScriptSnapshotFromFile(normalizeSrcPath))

    val filesToProcess = arrayOf(normalizeSrcPath)
    while(filesToProcess.isNotEmpty()) {
        val curFile = filesToProcess.shift()
        val curDir = getDirectoryPath(curFile) + "/"

        val result = preProcessFile(file2scriptSnapshot[curFile]!!.getText())

        val referencedFiles = result.referencedFiles
        for (referencedFile in referencedFiles) {
            val referencedFilePath = normalizePath(curDir + referencedFile.fileName)

            if (referencedFilePath in file2scriptSnapshot) continue

            filesToProcess.push(referencedFilePath)
            file2scriptSnapshot[referencedFilePath] = getScriptSnapshotFromFile(referencedFilePath)
        }
    }

    host.file2scriptSnapshot = file2scriptSnapshot
    host.currentDirectory = getDirectoryPath(normalizeSrcPath)

//    languageService.getSyntacticDiagnostics("foo.d.ts")
//    languageService.getSemanticDiagnostics("foo.d.ts")

//    val fileNode = languageService.getSourceFile(normalizeSrcPath)
    val fileNode = languageService.getProgram().getSourceFile(normalizeSrcPath)

    inline fun isAnyMember(node: MethodDeclaration): Boolean {
        val params = node.parameters.arr

        return when (node.propertyName?.text) {
            "equals" ->
                params.size == 1 && params[0].type?.let { it.kind === SyntaxKind.AnyKeyword } ?: true
            // TODO check return type ???
            "hashCode", "toString" ->
                params.size == 0
            else ->
                false
        }
    }

    /*inline*/ fun isOverrideHelper(
            node: Declaration,
            /*crossinline*/ f: (TypeChecker, Type, String) -> Boolean
    ): Boolean {
        val parentNode = node.parent!!.cast<ClassDeclaration>()

        if (parentNode.heritageClauses == null) return false

        val typechecker = languageService.getProgram().getTypeChecker()

        val nodeName = node.declarationName!!.unescapedText

        val visited = hashSetOf<Type>()

        fun ClassDeclaration.forEachBaseTypeNode(): Boolean {
            val heritages = heritageClauses ?: return false

            for (heritage in heritages.arr) {
                val types = heritage.types ?: continue

                for (typeNode in types.arr) {
                    val type = typechecker.getTypeAtLocation(typeNode) ?: continue

                    if (!visited.add(type)) continue

                    if (f(typechecker, type, nodeName)) return true

                    if ((type.symbol?.declarations?.get(0) as? ClassDeclaration)?.forEachBaseTypeNode() ?: false) return true
                }
            }

            return false
        }

        return parentNode.forEachBaseTypeNode()
    }

    fun Type.isSubtypeOf(other: Type): Boolean {
        if (this == other) return true

        // other as Any
//        if (other == null) return true

        // other is Any?
        if (hasFlag(other.flags, TypeFlags.Any)) return true

        // this as Any
//        if (this == null) return false

        return getBaseTypes()?.any { it.isSubtypeOf(other) } ?: false
    }

    fun TypeChecker.getTypeOfSymbol(symbol: Symbol) : Type =
            // TODO find better solution
            getTypeOfSymbolAtLocation(symbol, symbol.valueDeclaration.cast()/*.asDynamic().type*/)

    fun TypeChecker.isOverride(candidate: Signature, other: Signature): Boolean {
        if (candidate.parameters.size != other.parameters.size) return false

        // no need to check the return type.  If they are incompatible, It will be a Kotlin compilation error.

        for (i in candidate.parameters.indices) {
            val candidateType = getTypeOfSymbol(candidate.parameters[i])
            val otherType = getTypeOfSymbol(other.parameters[i])

            if (candidateType != otherType) return false
        }

        return true
    }

    fun isOverride(node: MethodDeclaration): Boolean {
        if (isAnyMember(node)) return true

        var nodeSignature: Signature? = null

        return isOverrideHelper(node) { typechecker, type, nodeName ->
            nodeSignature = nodeSignature ?: typechecker.getSignatureFromDeclaration(node)

            val candidates = typechecker.getPropertyOfType(type, nodeName)

            candidates?.declarations?.any {
                // TODO add test
                if (it.kind === SyntaxKind.PropertyDeclaration || it.kind === SyntaxKind.PropertySignature) return@any false

                val signature: Signature = when (it.kind as Any) {
                    SyntaxKind.MethodSignature,
                    SyntaxKind.MethodDeclaration -> typechecker.getSignatureFromDeclaration(it.cast<SignatureDeclaration>())
                    else -> {
                        reportUnsupportedNode(it)
                        return@any false
                    }
                }


                typechecker.isOverride(nodeSignature!!, signature)
            } ?: false
        }
    }

    fun isOverrideProperty(node: PropertyDeclaration): Boolean {
        return isOverrideHelper(node) { typechecker, type, nodeName ->
            // no need to check the property type.  If they are incompatible, It will be a Kotlin compilation error.
            typechecker.getPropertyOfType(type, nodeName) != null
        }
    }


    // TODO drop hack for reset temp class indexer for each file
    ObjectTypeToKotlinTypeMapperImpl.reset()

    val typeScriptToKotlin = createConverter(
            packageName = basePackageName,
            typeMapper = null,
            additionalAnnotations = DEFAULT_ANNOTATION,
            moduleName = null,
            isOwnDeclaration = {
                val definitions = languageService.getDefinitionAtPosition(normalizeSrcPath, it.end)
                definitions.all { it.fileName == normalizeSrcPath }
            },
            isOverride = ::isOverride,
            isOverrideProperty = ::isOverrideProperty,
            qualifier = listOf(),
            requiredModifier = SyntaxKind.DeclareKeyword,
            body = fileNode
    )

    // TODO fix
    // note we have side effect here
    typeScriptToKotlin.visitList(fileNode)

    val packageParts = typeScriptToKotlin.packageParts
    val mergedPackageParts = packageParts.merge().withMissedOverloads().filter { it.members.any(isNotAnnotatedAsFake) }

    return mergedPackageParts
}
