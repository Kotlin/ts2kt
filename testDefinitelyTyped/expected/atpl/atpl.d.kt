package atpl

@module
object atpl {
    fun compile(templateString: String, options: Any): (context: Any) -> String = noImpl
    fun __express(filename: String, options: Any, callback: Function): Any = noImpl
    fun registerExtension(items: Any): Unit = noImpl
    fun registerTags(items: Any): Unit = noImpl
    fun registerFunctions(items: Any): Unit = noImpl
    fun registerFilters(items: Any): Unit = noImpl
    fun registerTests(items: Any): Unit = noImpl
    fun renderFileSync(viewsPath: String, filename: String, parameters: Any, cache: Boolean): String = noImpl
    fun renderFile(viewsPath: String, filename: String, parameters: Any, cache: Boolean, done: (err: Error, result: String? = null) -> Unit): Unit = noImpl
}
