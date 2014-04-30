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

package ts2kt.utils

import java.util.ArrayList
import java.util.HashSet

fun listOf<T>(vararg elements: T): List<T> {
    val list = ArrayList<T>(elements.size)
    for (e in elements) {
        list.add(e)
    }
    return list
}

fun setOf<T>(vararg elements: T): Set<T> {
    val set = HashSet<T>(elements.size)
    for (e in elements) {
        set.add(e)
    }
    return set
}

fun <T> List<T>.filter(f: (T) -> Boolean): List<T> {
    val list = ArrayList<T>()

    for (e in this) {
        if (f(e)) {
            list.add(e)
        }
    }

    return list
}

fun <T> List<T>.join(
        delimiter: String = ", ",
        start: String = "",
        end: String = "",
        startWithIfNotEmpty: String = "",
        endWithIfNotEmpty: String = ""
): String {
    if (this.isEmpty()) return start + end

    var s = ""
    var first = true


    for (e in this) {
        if (!first) {
            s += delimiter
        }
        else {
            first = false
        }
        s += e.toString()
    }

    return start + startWithIfNotEmpty + s + endWithIfNotEmpty + end
}

[suppress("UNUSED_PARAMETER")]
native
fun <T> Array<T>.join(delimiter: String = ","): String = noImpl

fun assert(condition: Boolean, message: String) {
    if (!condition) throw Exception(message)
}
