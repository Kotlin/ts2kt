package typescript

@native
fun TS.unescapeIdentifier(identifier: String): String

@native
fun TS.normalizePath(path: String): String

@native
fun TS.getDirectoryPath(path: String): String
