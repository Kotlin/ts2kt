package ts2kt

import typescriptServices.ts.CompilerOptions
import typescriptServices.ts.IScriptSnapshot
import typescriptServices.ts.LanguageServiceHost
import typescriptServices.ts.getDefaultCompilerOptions

class FileSystemBasedLSH(file2scriptSnapshot: Map<String, IScriptSnapshot>, var currentDirectory: String) : LanguageServiceHost {
    private var filesCache = arrayOf<String>()

    var file2scriptSnapshot = file2scriptSnapshot
        get() = field
        set(value) {
            field = value
            filesCache = value.keys.toTypedArray()
        }

    override fun getCompilationSettings() = getDefaultCompilerOptions()

    override fun getScriptFileNames(): Array<String> = filesCache

    override fun getScriptVersion(fileName: String) = "0" // ???

    override fun getScriptSnapshot(fileName: String): IScriptSnapshot? = file2scriptSnapshot[fileName]

    override fun getCurrentDirectory() = currentDirectory

    override fun getDefaultLibFileName(options: CompilerOptions) = "lib.d.ts"

    override val log = { message: String -> console.log(message) }
}
