package ts2kt.utils

import java.util.ArrayList

fun listOf<T>(vararg elements: T): List<T> {
    val list = ArrayList<T>(elements.size)
    for (e in elements) {
        list.add(e)
    }
    return list
}
