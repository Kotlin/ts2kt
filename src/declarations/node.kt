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

package node

native
class path private () {
    fun basename(path: String, postfix: String): String = noImpl
}

native
class process private() {
    val argv: Array<String?> = noImpl
}

native
class fs private() {
    fun argv(index: Int): String = noImpl
    fun writeFileSync(path: String, text: String): Unit = noImpl
    fun readFileSync(path: String): String = noImpl
}
