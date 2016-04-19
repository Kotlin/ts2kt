package typescript

@native
val ts: dynamic

@native
fun <E : Enum<E>> TS.hasFlag(flags: Enum<E>, flag: E): Boolean = noImpl

@native
fun TS.unescapeIdentifier(identifier: String): String = noImpl

@native
interface LanguageServiceHost {
    fun getCompilationSettings(): dynamic

    fun getScriptFileNames(): Array<String>

    fun getScriptVersion(fileName: String): Int

    fun getScriptIsOpen(fileName: String): Boolean

    fun getScriptByteOrderMark(fileName: String): dynamic

    fun getScriptSnapshot(fileName: String): dynamic

//    getLocalizedDiagnosticMessages?(): any
//    fun getLocalizedDiagnosticMessages(): Any

//    getCancellationToken?(): CancellationToken
//    fun getCancellationToken()

    fun getCurrentDirectory(): String
    fun getDefaultLibFilename(options: dynamic): String

    fun log(message: Any) = console.log(message)

}