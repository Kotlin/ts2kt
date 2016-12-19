@file:Suppress("NOTHING_TO_INLINE")

package typescript

inline fun TS.unescapeIdentifier(identifier: String): String = asDynamic().unescapeIdentifier(identifier)

inline fun TS.normalizePath(path: String): String = asDynamic().normalizePath(path)

inline fun TS.getDirectoryPath(path: String): String = asDynamic().getDirectoryPath(path)
