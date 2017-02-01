package exportClassFromGlobalModule

@module
external open class SampleView : _atom.ScrollView {
    open var foo: String = definedExternally
}
