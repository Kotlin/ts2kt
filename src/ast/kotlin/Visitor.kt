package ts2kt.kotlin.ast

interface Visitor {
    fun visitNode(node: Node)
    fun visitAnnotation(annotation: Annotation)
    fun visitClassifier(classifier: Classifier)
    fun visitFunction(function: Function)
    fun  visitVariable(variable: Variable)
    fun visitFile(kotlinFile: KotlinFile)
    fun visitPackage(package_: Package)
    fun visitFunParam(funParam: FunParam)
    fun visitCallSignature(signature: CallSignature)
    fun visitEnumEntry(enumEntry: EnumEntry)
    fun visitTypeParam(typeParam: TypeParam)
    fun visitTypeAnnotation(typeAnnotation: TypeAnnotation)
    fun visitType(type: Type)
    fun visitTypeUnion(typeUnion: TypeUnion)
    fun visitHeritageType(heritageType: HeritageType)
    fun visitArgument(argument: Argument)
}