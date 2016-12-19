package js

@Suppress("EXTERNAL_TYPE_EXTENDS_NON_EXTERNAL_TYPE")
@JsName("Error")
external class JsError(override val message: String) : Throwable(message)
