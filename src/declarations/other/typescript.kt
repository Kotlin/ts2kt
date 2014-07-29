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

package typescript

[suppress("UNUSED_PARAMETER")]
native
object typescript {
    object IO {}

    trait IScriptSnapshot
    trait ByteOrderMark

    class SyntaxTree {
        fun sourceUnit(): SourceUnitSyntax = noImpl
    }

    native("typescript.TypeScriptCompiler")
    class TypeScriptCompiler(logger: DiagnosticsLogger) {
        val resolver: PullTypeResolver = noImpl
        fun addSourceUnit(path: String, scriptSnapshot: IScriptSnapshot, byteOrderMark: ByteOrderMark,
                          version: Int, isOpen: Boolean , referencedFiles: Array<String>): Unit = noImpl
        fun updateSourceUnit(path: String, scriptSnapshot: IScriptSnapshot,
                             version: Int, isOpen: Boolean/*, textChangeRange */): Unit = noImpl

        fun getSyntaxTree(path: String): SyntaxTree = noImpl
        fun getDocument(path: String): Document? = noImpl

        fun getSyntacticDiagnostics(path: String): Array<String> = noImpl
        fun getSemanticDiagnostics(path: String): Array<String> = noImpl
        fun reportDiagnostics(diagnostics: Array<String>, reporter: Any): Unit = noImpl

        fun pullTypeCheck(): Unit = noImpl
        fun resolvePosition(position: Int, document: Document): ResolveResult = noImpl
    }

    trait SourceFile {
        val scriptSnapshot: IScriptSnapshot
        val byteOrderMark: ByteOrderMark
    }

    class Document

    trait IResolvedFile {
        val path: String
        val referencedFiles: Array<String>
        val importedFiles: Array<String>
    }

    class CompilationSettings {
        public var propagateEnumConstants: Boolean = noImpl
        public var removeComments: Boolean = noImpl
        public var watch: Boolean = noImpl
        public var noResolve: Boolean = noImpl
        public var allowAutomaticSemicolonInsertion: Boolean = noImpl
        public var noImplicitAny: Boolean = noImpl
        public var noLib: Boolean = noImpl
//        public var codeGenTarget: LanguageVersion = noImpl
//        public var moduleGenTarget: ModuleGenTarget = noImpl
        public var outFileOption: String = noImpl
        public var outDirOption: String = noImpl
        public var mapSourceFiles: Boolean = noImpl
        public var mapRoot: String = noImpl
        public var sourceRoot: String = noImpl
        public var generateDeclarationFiles: Boolean = noImpl
        public var useCaseSensitiveFileResolution: Boolean = noImpl
        public var gatherDiagnostics: Boolean = noImpl
        public var codepage: Int = noImpl
        public var createFileLog: Boolean = noImpl
    }


    native("typescript.BatchCompiler")
    class BatchCompiler(io: typescript.IO) {
        val compilationSettings: CompilationSettings = noImpl
        var inputFiles: Array<String>? = null
        var resolvedFiles: Array<IResolvedFile> = noImpl
        var logger: DiagnosticsLogger? = null

        public fun resolve(): Unit = noImpl
        public fun updateCompile(): Unit = noImpl
        public fun resolvePath(path: String): String = noImpl
        public fun getSourceFile(path: String): SourceFile = noImpl
    }

    native("typescript.DiagnosticsLogger")
    class DiagnosticsLogger(io: typescript.IO)

    trait ResolveResult {
//        val ast: AST
        val symbol: PullTypeSymbol
        val enclosingScopeSymbol: PullTypeSymbol
        val candidateSignature: PullSignatureSymbol?
    }

    class PullSignatureSymbol {
        val parameters: Array<PullSymbol>? = noImpl
        val returnType: PullTypeSymbol = noImpl
    }

    class PullTypeSymbol {
        public val name: String = noImpl
        public fun getDeclarations(): Array<PullDecl> = noImpl
        public fun getExtendedTypes(): Array<PullTypeSymbol> = noImpl
        public fun getImplementedTypes(): Array<PullTypeSymbol> = noImpl
        public fun findMember(name: String, lookInParent: Boolean = true): PullSymbol? = noImpl
        public fun getMembers(): Array<PullSymbol> = noImpl
        public fun getAllMembers(searchDeclKind: PullElementKind, memberVisiblity: GetAllMembersVisiblity): Array<PullSymbol> = noImpl
        public fun getCallSignatures(collectBaseSignatures: Boolean = true): Array<PullSignatureSymbol> = noImpl
    }

    class PullDecl {
        val scriptName: String = noImpl
    }

    class PullSymbol {
        public val name: String = noImpl
        public val `type`: PullTypeSymbol? = noImpl
    }

    enum class PullElementKind
    enum class GetAllMembersVisiblity

    class PullTypeResolver {
        public fun signatureIsAssignableToTarget(s1: Any, s2: Any, context: Any, comparisonInfo: Any? = null): Boolean = noImpl
    }

    native("typescript.PullTypeResolutionContext")
    class PullTypeResolutionContext
}
