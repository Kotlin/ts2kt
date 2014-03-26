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

native
trait ISyntaxToken : ISyntaxNodeOrToken, INameSyntax {
    // Same as kind(), just exposed through a property for perf.
    val tokenKind: SyntaxKind

    // Text for this token, not including leading or trailing trivia.
    fun text(): String

    fun value(): Any
    fun valueText(): String

    fun hasLeadingTrivia(): Boolean
    fun hasLeadingComment(): Boolean
    fun hasLeadingNewLine(): Boolean
    fun hasLeadingSkippedText(): Boolean

    fun hasTrailingTrivia(): Boolean
    fun hasTrailingComment(): Boolean
    fun hasTrailingNewLine(): Boolean
    fun hasTrailingSkippedText(): Boolean

    fun hasSkippedToken(): Boolean

//    fun leadingTrivia(): ISyntaxTriviaList
//    fun trailingTrivia(): ISyntaxTriviaList

//    fun withLeadingTrivia(leadingTrivia: ISyntaxTriviaList): ISyntaxToken
//    fun withTrailingTrivia(trailingTrivia: ISyntaxTriviaList): ISyntaxToken

    fun clone(): ISyntaxToken;
}

native
trait ITokenInfo {
    val leadingTrivia: Array<ISyntaxTrivia>?
    val text: String?
    val trailingTrivia: Array<ISyntaxTrivia>?
}
