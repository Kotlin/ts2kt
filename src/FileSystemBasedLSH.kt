package ts2kt

import typescript.LanguageServiceHost
import typescript.ts

class FileSystemBasedLSH(file2scriptSnapshot: Map<String, dynamic>, var currentDirectory: String) : LanguageServiceHost {
    private var filesCache = arrayOf<String>()

    var file2scriptSnapshot = file2scriptSnapshot
        get() = field
        set(value) {
            field = value
            filesCache = value.keys.toTypedArray()
        }

    override fun getCompilationSettings() = ts.getDefaultCompilerOptions()

    override fun getScriptFileNames(): Array<String> = filesCache

    override fun getScriptVersion(fileName: String) = 1 // ???

    override fun getScriptIsOpen(fileName: String) = file2scriptSnapshot.containsKey(fileName)

    override fun getScriptByteOrderMark(fileName: String) = ts.ByteOrderMark.None

    override fun getScriptSnapshot(fileName: String): dynamic = file2scriptSnapshot[fileName]

    // getLocalizedDiagnosticMessages?(): any
//    fun getLocalizedDiagnosticMessages(): Any = throw UnsupportedOperationException() // ???

    // getCancellationToken?(): CancellationToken
//    fun getCancellationToken(): dynamic =
//            object {
//                fun isCancellationRequested() = false
//            }

    override fun getCurrentDirectory() = currentDirectory
    override fun getDefaultLibFilename(options: dynamic) = "lib.d.ts"

    override fun log(message: Any) = console.log(message)
}
