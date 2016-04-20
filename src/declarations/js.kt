package js

@native("Error") class JsError(override val message: String) : Throwable(message)
