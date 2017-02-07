package ts2kt

import ts2kt.kotlin.ast.Annotation
import ts2kt.kotlin.ast.ClassKind
import ts2kt.kotlin.ast.FunParam
import ts2kt.kotlin.ast.TypeParam
import ts2kt.utils.assert
import typescript.TS
import typescript.identifierName

class TsClassToKt(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        val kind: ClassKind = ClassKind.CLASS,
        val annotations: List<Annotation> = DEFAULT_ANNOTATION,
        isOverride: (TS.MethodDeclaration) -> Boolean,
        isOverrideProperty: (TS.PropertyDeclaration) -> Boolean,
        override val hasMembersOpenModifier: Boolean = true
) : TsClassifierToKt(typeMapper, isOverride, isOverrideProperty) {

    override val needsNoImpl = true

    override val isInterface = false

    var typeParams: List<TypeParam>? = null
    val paramsOfConstructors = arrayListOf<List<FunParam>>()

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
