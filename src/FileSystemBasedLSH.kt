package ts2kt

import typescript.ts

public class FileSystemBasedLSH(val file2scriptSnapshot: Map<String, dynamic>, val version: () -> Int) {
    var filesCache = array<String>()
    var versionCache = -1

    fun getCompilationSettings() = ts.getDefaultCompilerOptions()

    fun getScriptFileNames(): Array<String> {
        val currentVersion = version()
        if (versionCache != currentVersion) {
            versionCache = currentVersion
            filesCache = file2scriptSnapshot.keySet().copyToArray()
        }

        return filesCache
    }

    fun getScriptVersion(fileName: String) = 1 // ???

    fun getScriptIsOpen(fileName: String) = file2scriptSnapshot.containsKey(fileName)

    fun getScriptByteOrderMark(fileName: String) = ts.ByteOrderMark.None

    fun getScriptSnapshot(fileName: String): dynamic = file2scriptSnapshot[fileName]

    // getLocalizedDiagnosticMessages?(): any;
//    fun getLocalizedDiagnosticMessages(): Any = throw UnsupportedOperationException() // ???

    // getCancellationToken?(): CancellationToken;
//    fun getCancellationToken(): dynamic =
//            object {
//                fun isCancellationRequested() = false
//            }

    fun getCurrentDirectory() = ""
    fun getDefaultLibFilename(options: dynamic) = "lib.d.ts"

    fun log(message: Any) = console.log(message)
}
