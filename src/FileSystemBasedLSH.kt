package ts2kt

import typescript.ts

public class FileSystemBasedLSH(file2scriptSnapshot: Map<String, dynamic>, var currentDirectory: String) {
    var filesCache = arrayOf<String>()

    var file2scriptSnapshot = file2scriptSnapshot
        get() = field
        set(value) {
            field = value
            filesCache = value.keys.toTypedArray()
        }

    fun getCompilationSettings() = ts.getDefaultCompilerOptions()

    fun getScriptFileNames(): Array<String> = filesCache

    fun getScriptVersion(fileName: String) = 1 // ???

    fun getScriptIsOpen(fileName: String) = file2scriptSnapshot.containsKey(fileName)

    fun getScriptByteOrderMark(fileName: String) = ts.ByteOrderMark.None

    fun getScriptSnapshot(fileName: String): dynamic = file2scriptSnapshot[fileName]

    // getLocalizedDiagnosticMessages?(): any
//    fun getLocalizedDiagnosticMessages(): Any = throw UnsupportedOperationException() // ???

    // getCancellationToken?(): CancellationToken
//    fun getCancellationToken(): dynamic =
//            object {
//                fun isCancellationRequested() = false
//            }

    fun getCurrentDirectory() = currentDirectory
    fun getDefaultLibFilename(options: dynamic) = "lib.d.ts"

    fun log(message: Any) = console.log(message)
}
