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

import java.util.*

fun <T> List<T>.join(
        delimiter: String = ", ",
        start: String = "",
        end: String = "",
        startWithIfNotEmpty: String = "",
        endWithIfNotEmpty: String = "",
        filter: ((T) -> Boolean)? = null,
        stringify: ((T) -> String)? = null
): String {
    if (this.isEmpty()) return start + end

    var s = ""
    var first = true

    for (e in this) {
        if (filter != null && !filter(e)) continue

        if (!first) {
            s += delimiter
        }
        else {
            first = false
        }
        s += if (stringify == null) e.toString() else stringify(e)
    }

    if (first) return start + end

    return start + startWithIfNotEmpty + s + endWithIfNotEmpty + end
}

fun <T: Any> MutableList<T>.merge(acceptor: (T) -> Boolean, comparator: (T, T) -> Boolean, merger: (T, T) -> T) {
    var i = 0
    while (i < size) {
        val current = this[i]
        if (!acceptor(current)) {
            i++
            continue
        }

        val candidates = ArrayList<Int>()

        val size = size
        var j =  i + 1
        while (j < size) {
            val e = this[j]

            if (!acceptor(e)) {
                j++
                continue
            }

            if (comparator(current, e)) {
                candidates.add(j)
            }

            j++
        }

        if (!candidates.isEmpty()) {
            this.mergeAllTo(i, candidates, merger)
        }

        i++
    }
}

private fun <T: Any> MutableList<T>.mergeAllTo(mergeTo: Int, candidateIndexes: List<Int>, merger: (T, T) -> T) {
    val merged = candidateIndexes.fold(this[mergeTo]) { a, bi -> merger(a, this[bi]) }

    this[mergeTo] = merged

    var i = candidateIndexes.size - 1
    while(i >= 0) {
        this.removeAt(candidateIndexes[i])
        i--
    }

}

// JS Array methods

@native
fun <T> Array<T>.push(vararg element: T): Unit = noImpl

@native
fun <T> Array<T>.shift(): T = noImpl

@native
fun <T> Array<T>.splice(index: Int, removeCount: Int, vararg newItems: T): Array<T> = noImpl

//

@native
class RegExp(s: String, flags: String = "")

// JS String methods

@native
fun String.replace(r: RegExp, s: String): String = noImpl

fun String.replaceAll(r: String, s: String): String = replace(RegExp(r, "g"), s)


@native
fun <T> eval(code: String): T = noImpl

// Assert

fun assert(condition: Boolean, message: String) {
    if (!condition) throw Exception(message)
}
