package interface

module
public object AceAjax {
    public trait KeyBinding {
        public fun setDefaultHandler(kb: Any)
        public fun setKeyboardHandler(kb: Any)
        public fun addKeyboardHandler(kb: Any, pos: Any)
        public fun removeKeyboardHandler(kb: Any): Boolean
        public fun getKeyboardHandler(): Any
        public fun onCommandKey(e: Any, hashId: Any, keyCode: Any)
        public fun onTextInput(text: Any)
        public class object : Foo by noImpl: Foo {

        }
    }
    public trait Foo {
        public fun foo(editor: Editor): Boolean
    }
}
