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
