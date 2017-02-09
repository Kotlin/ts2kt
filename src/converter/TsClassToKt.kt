package ts2kt

import ts2kt.kotlin.ast.KtAnnotation
import ts2kt.kotlin.ast.KtClassKind
import ts2kt.kotlin.ast.KtFunParam
import ts2kt.kotlin.ast.KtTypeParam
import ts2kt.utils.assert
import typescript.TS
import typescript.identifierName

class TsClassToKt(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        val kind: KtClassKind = KtClassKind.CLASS,
        val annotations: List<KtAnnotation> = DEFAULT_ANNOTATION,
        isOverride: (TS.MethodDeclaration) -> Boolean,
        isOverrideProperty: (TS.PropertyDeclaration) -> Boolean,
        override val hasMembersOpenModifier: Boolean = true
) : TsClassifierToKt(typeMapper, isOverride, isOverrideProperty) {

    override val needsNoImpl = true

    override val isInterface = false

    var typeParams: List<KtTypeParam>? = null
    val paramsOfConstructors = arrayListOf<List<KtFunParam>>()

    override fun visitClassDeclaration(node: TS.ClassDeclaration) {
//      todo visitList(node.modifiers)
        name = node.identifierName!!.unescapedText
        typeParams = node.typeParameters?.toKotlinTypeParams(typeMapper)

        node.heritageClauses?.arr?.forEach { visitNode(this, it) }
        node.members.arr.forEach { visitNode(this, it) }
    }

    override fun visitConstructorDeclaration(node: TS.ConstructorDeclaration) {
        val paramsOverloads = node.parameters.toKotlinParamsOverloads(typeMapper)
        paramsOfConstructors.addAll(paramsOverloads)

        assert(node.body == null, "A constructor in declarations file should not have body, constructor in '${this.name}")
    }
}
