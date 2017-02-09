package `interface`.AceAjax

interface KeyBinding {
    fun setDefaultHandler(kb: Any)
    fun setKeyboardHandler(kb: Any)
    fun addKeyboardHandler(kb: Any, pos: Any)
    fun removeKeyboardHandler(kb: Any): Boolean
    fun getKeyboardHandler(): Any
    fun onCommandKey(e: Any, hashId: Any, keyCode: Any)
    fun onTextInput(text: Any)
    companion object : Foo by definedExternally: Foo {
    }
}
interface Foo {
    fun foo(editor: Editor): Boolean
}
