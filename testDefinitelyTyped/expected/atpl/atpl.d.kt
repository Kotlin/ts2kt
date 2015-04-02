[file: nativePackageRoot]
package atpl

/* ============= */
[file: nativeModule]
package atpl.atpl

native
public fun compile(templateString: String, options: Any): (context: Any) -> String = noImpl
native
public fun __express(filename: String, options: Any, callback: Function): Any = noImpl
native
public fun registerExtension(items: Any): Unit = noImpl
native
public fun registerTags(items: Any): Unit = noImpl
native
public fun registerFunctions(items: Any): Unit = noImpl
native
public fun registerFilters(items: Any): Unit = noImpl
native
public fun registerTests(items: Any): Unit = noImpl
native
public fun renderFileSync(viewsPath: String, filename: String, parameters: Any, cache: Boolean): String = noImpl
native
public fun renderFile(viewsPath: String, filename: String, parameters: Any, cache: Boolean, done: (err: Error, result: String? = null) -> Unit): Unit = noImpl
