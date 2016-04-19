package ts2kt

import typescript.TS
import typescript.ts

class FileSystemBasedLSH(file2scriptSnapshot: Map<String, dynamic>, var currentDirectory: String) : TS.LanguageServiceHost {
    private var filesCache = arrayOf<String>()

    var file2scriptSnapshot = file2scriptSnapshot
        get() = field
        set(value) {
            field = value
            filesCache = value.keys.toTypedArray()
        }

    override fun getCompilationSettings() = ts.getDefaultCompilerOptions()

    override fun getScriptFileNames(): Array<String> = filesCache

    override fun getScriptVersion(fileName: String) = "0" // ???

    override fun getScriptSnapshot(fileName: String): dynamic = file2scriptSnapshot[fileName]

    override fun getCurrentDirectory() = currentDirectory

    override fun getDefaultLibFileName(options: dynamic) = "lib.d.ts"

    override val log = { message: String -> console.log(message) }
}
