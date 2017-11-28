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

@JsModule("path")
external object path {
    val sep: String
    fun basename(path: String, postfix: String): String
    fun basename(path: String): String
    fun dirname(path: String): String
}

@JsModule("process")
external object process {
    val argv: Array<String>
    val argv0: String
}

@JsModule("fs")
external object fs {
    fun argv(index: Int): String
    fun writeFileSync(path: String, text: String): Unit
    fun readFileSync(path: String): String
    fun existsSync(path: String): Boolean
    fun mkdirSync(path: String): Unit
}

external object module {
    val parent: Any?
}

external val __dirname: String
external val __filename: String