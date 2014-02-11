/*
 * Copyright 2000-2013 JetBrains s.r.o.
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
        fun addSourceUnit(path: String, scriptSnapshot: IScriptSnapshot, byteOrderMark: ByteOrderMark,
                          version: Int, isOpen: Boolean /*, referencedFiles */): Unit = noImpl
        fun getSyntaxTree(path: String): SyntaxTree = noImpl
    }

    trait SourceFile {
        val scriptSnapshot: IScriptSnapshot
        val byteOrderMark: ByteOrderMark
    }

    native("typescript.BatchCompiler")
    class BatchCompiler(io: typescript.IO) {
        public fun getSourceFile(path: String): SourceFile = noImpl
    }

    native("typescript.DiagnosticsLogger")
    class DiagnosticsLogger(io: typescript.IO)

//    object Foo {
//
//    }
//
//    native object Bar {
//
//    }
//
//    class A
//    native class B
//    inner class C
//    native inner class D
}