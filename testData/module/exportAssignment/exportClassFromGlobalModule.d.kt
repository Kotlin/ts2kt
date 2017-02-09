package exportClassFromGlobalModule

@JsModule("SampleView")
external open class SampleView : _atom.ScrollView {
    open var foo: String = definedExternally
}
