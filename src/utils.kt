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

//TODO: unused?
fun <T> List<T>.filter(f: (T) -> Boolean): List<T> {
    val list = ArrayList<T>()

    for (e in this) {
        if (f(e)) {
            list.add(e)
        }
    }

    return list
}

fun <T, R> List<T>.map(f: (T) -> R): List<R> {
    val list = ArrayList<R>()

    for (e in this) {
        list.add(f(e))
    }

    return list
}

fun <T, R> List<T>.fold(first: R, f: (R, T) -> R): R {
    var acc = first
    for (e in this) {
        acc = f(acc, e)
    }

    return acc
}

fun <T: Any> List<T>.find(f: (T) -> Boolean): T? {
    for (e in this) {
        if (f(e)) return e
    }

    return null
}

fun <T> List<T>.all(f: (T) -> Boolean): Boolean {
    for (e in this) {
        if (!f(e)) return false
    }

    return true
}

fun <T> List<T>.any(f: (T) -> Boolean): Boolean {
    for (e in this) {
        if (f(e)) return true
    }

    return false
}

fun <T> List<T>.join(
        delimiter: String = ", ",
        start: String = "",
        end: String = "",
        startWithIfNotEmpty: String = "",
        endWithIfNotEmpty: String = "",
        filter: ((T) -> Boolean)? = null
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
        s += e.toString()
    }

    if (first) return start + end

    return start + startWithIfNotEmpty + s + endWithIfNotEmpty + end
}

fun <T> List<T>.plus(another: List<T>): List<T> = when {
        this.isEmpty() -> {
            another
        }
        another.isEmpty() -> {
            this
        }
        else -> {
            val list = ArrayList<T>()
            list.addAll(this)
            list.addAll(another)
            list
        }
    }

fun <T: Any> MutableList<T>.merge(acceptor:(T) -> Boolean, comparator: (T, T) -> Boolean, merger: (T, T) -> T) {
    var i = 0;
    while (i < size()) {
        val current = this[i]
        if (!acceptor(current)) {
            i++
            continue
        }

        val candidates = ArrayList<Int>()

        val size = size()
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

    var i = candidateIndexes.size() - 1
    while(i >= 0) {
        this.remove(candidateIndexes[i])
        i--
    }

}

[suppress("UNUSED_PARAMETER")]
native
fun <T> Array<T>.join(delimiter: String = ","): String = noImpl

fun assert(condition: Boolean, message: String) {
    if (!condition) throw Exception(message)
}
