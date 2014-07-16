/*
 * Copyright 2013-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing software
 * distributed under the License is distributed on an "AS IS" BASIS
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package typescript

native
class SyntaxKind

native("typescript.SyntaxKind.DeclareKeyword")
val DeclareKeyword: SyntaxKind = noImpl

native("typescript.SyntaxKind.PrivateKeyword")
val PrivateKeyword: SyntaxKind = noImpl

native("typescript.SyntaxKind.ProtectedKeyword")
val ProtectedKeyword: SyntaxKind = noImpl

native("typescript.SyntaxKind.PublicKeyword")
val PublicKeyword: SyntaxKind = noImpl

native("typescript.SyntaxKind.StaticKeyword")
val StaticKeyword: SyntaxKind = noImpl

native("typescript.SyntaxKind.ExportKeyword")
val ExportKeyword: SyntaxKind = noImpl

native("typescript.SyntaxKind.ExtendsKeyword")
val ExtendsKeyword: SyntaxKind = noImpl

native("typescript.SyntaxKind.CommaToken")
val CommaToken: SyntaxKind = noImpl

native("typescript.SyntaxKind.VoidKeyword")
val VoidKeyword: SyntaxKind = noImpl

native("typescript.SyntaxKind.AnyKeyword")
val AnyKeyword: SyntaxKind = noImpl

native("typescript.SyntaxKind.BooleanKeyword")
val BooleanKeyword: SyntaxKind = noImpl

native("typescript.SyntaxKind.NumberKeyword")
val NumberKeyword: SyntaxKind = noImpl

native("typescript.SyntaxKind.StringKeyword")
val StringKeyword: SyntaxKind = noImpl

native("typescript.SyntaxKind.ArrayType")
val ArrayType: SyntaxKind = noImpl

native("typescript.SyntaxKind.GenericType")
val GenericType: SyntaxKind = noImpl

native("typescript.SyntaxKind.FunctionType")
val FunctionType: SyntaxKind = noImpl

native("typescript.SyntaxKind.ObjectType")
val ObjectType: SyntaxKind = noImpl

native("typescript.SyntaxKind")
val syntaxKindToName: Map<SyntaxKind, String> = noImpl

fun SyntaxKind.asString(): String = syntaxKindToName[this]!!
