package accessModifierMethods

external open class FooWithAccessModifierMethods {
    open fun publicMethod(s: String): String = definedExternally
    protected open fun protectedMethod(s: String): String = definedExternally
}
