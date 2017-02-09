package ts2kt.kotlin.ast

interface KtVisitor {
    fun visitNode(node: KtNode)
    fun visitAnnotation(annotation: KtAnnotation)
    fun visitClassifier(classifier: KtClassifier)
    fun visitFunction(function: KtFunction)
    fun  visitVariable(variable: KtVariable)
    fun visitPackagePart(packagePart: KtPackagePart)
    fun visitFunParam(funParam: KtFunParam)
    fun visitCallSignature(signature: KtCallSignature)
    fun visitEnumEntry(enumEntry: KtEnumEntry)
    fun visitTypeParam(typeParam: KtTypeParam)
    fun visitTypeAnnotation(typeAnnotation: KtTypeAnnotation)
    fun visitType(type: KtType)
    fun visitTypeUnion(typeUnion: KtTypeUnion)
    fun visitHeritageType(heritageType: KtHeritageType)
    fun visitArgument(argument: KtArgument)
}