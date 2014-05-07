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
abstract class SyntaxNode(parsedInStrictMode: Boolean) : ISyntaxNodeOrToken {
    public abstract val modifiers: ISyntaxList

    fun toJSON(key: Any): Any = noImpl

    fun replaceToken(token1: ISyntaxToken, token2: ISyntaxToken): SyntaxNode = noImpl

    fun hasLeadingTrivia(): Boolean = noImpl

    fun hasTrailingTrivia(): Boolean = noImpl

    // True if this node was parsed while the parser was in 'strict' mode.  A node parsed in strict
    // mode cannot be reused if the parser is non-strict mode (and vice versa).  This is because
    // the parser parses things differently in strict mode and thus the tokens may be interpretted
    // differently if the mode is changed.
    fun parsedInStrictMode(): Boolean = noImpl

    fun computeData(): Int /* number */ = noImpl

    fun data(): Int /* number */ = noImpl

    /**
     * Finds a token according to the following rules:
     * 1) If position matches the End of the node/s FullSpan and the node is SourceUnit,
     *    then the EOF token is returned.
     *
     *  2) If node.FullSpan.Contains(position) then the token that contains given position is
     *     returned.
     *
     *  3) Otherwise an ArgumentOutOfRangeException is thrown
     *
     * Note: findToken will always return a non-missing token with width greater than or equal to
     * 1 (except for EOF).  Empty tokens synthesized by the parser are never returned.
     */
    //fun findToken(position: Int /* number */, includeSkippedTokens: Boolean = false): PositionedToken = noImpl
    //
    //fun tryGetEndOfFileAt(position: Int /* number */): PositionedToken = noImpl
    //
    //fun findTokenInternal(parent: PositionedElement, position: Int /* number */, fullStart: Int /* number */): PositionedToken = noImpl
    //
    //fun findTokenOnLeft(position: Int /* number */, includeSkippedTokens: Boolean = false): PositionedToken = noImpl
    //
    //fun findCompleteTokenOnLeft(position: Int /* number */, includeSkippedTokens: Boolean = false): PositionedToken = noImpl

    fun isModuleElement(): Boolean = noImpl

    fun isClassElement(): Boolean = noImpl

    fun isTypeMember(): Boolean = noImpl

    fun isStatement(): Boolean = noImpl

    fun isSwitchClause(): Boolean = noImpl

    fun structuralEquals(node: SyntaxNode): Boolean = noImpl
}
 
