package exportClassFromGlobalModule

@native
@module
open class SampleView : _atom.ScrollView() {
    open var foo: String = noImpl
}
