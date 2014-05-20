package interface

module
public object AceAjax {
    public trait KeyBinding {
        public fun setDefaultHandler(kb: Any): Unit
        public fun setKeyboardHandler(kb: Any): Unit
        public fun addKeyboardHandler(kb: Any, pos: Any): Unit
        public fun removeKeyboardHandler(kb: Any): Boolean
        public fun getKeyboardHandler(): Any
        public fun onCommandKey(e: Any, hashId: Any, keyCode: Any): Unit
        public fun onTextInput(text: Any): Unit
        public class object : Foo by noImpl: Foo {

        }
    }
    public trait Foo {
        public fun foo(editor: Editor): Boolean
    }
}
