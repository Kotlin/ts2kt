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

@file:Suppress("NOTHING_TO_INLINE")

package ts2kt.utils

inline fun <T> Any?.cast(): T = this.unsafeCast<T>()

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

fun <T: Any> List<T>.merge(acceptor: (T) -> Boolean, comparator: (T, T) -> Boolean, merger: (T, T) -> T?): List<T> =
        toMutableList().apply { merge(acceptor, comparator, merger) }

private fun <T: Any> MutableList<T>.merge(acceptor: (T) -> Boolean, comparator: (T, T) -> Boolean, merger: (T, T) -> T?) {
    var i = 0
    while (i < size) {
        val current = this[i]
        if (!acceptor(current)) {
            i++
            continue
        }

        val candidates = arrayListOf<Int>()

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

private fun <T: Any> MutableList<T>.mergeAllTo(mergeTo: Int, candidateIndexes: List<Int>, merger: (T, T) -> T?) {
    var acc = this[mergeTo]
    val indexesToRemove = mutableSetOf<Int>()
    for (i in candidateIndexes) {
        val result = merger(acc, this[i])
        if (result != null) {
            acc = result
            indexesToRemove += i
        }
    }

    indexesToRemove.sortedDescending().forEach { this.removeAt(it) }
}

// JS Array methods

//inline fun <T> Array<T>.push(vararg elements: T): Unit = asDynamic().push.apply(this, elements)
inline fun <T> Array<T>.push(element: T): Unit {
    asDynamic().push(element)
}

inline fun <T> Array<T>.shift(): T = asDynamic().shift().unsafeCast<T>()

//fun <T> Array<T>.splice(index: Int, removeCount: Int, vararg newItems: T): Array<T> = ...
inline fun <T> Array<T>.splice(index: Int, removeCount: Int, newItem: T): Array<T> = asDynamic().splice(index, removeCount, newItem).unsafeCast<Array<T>>()
