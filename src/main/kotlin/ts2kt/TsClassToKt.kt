package ts2kt

import ts2kt.kotlin.ast.KtAnnotation
import ts2kt.kotlin.ast.KtClassKind
import ts2kt.kotlin.ast.KtFunParam
import ts2kt.kotlin.ast.KtTypeParam
import ts2kt.utils.assert
import typescriptServices.ts.identifierName
import typescriptServices.ts.*

class TsClassToKt(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        val kind: KtClassKind = KtClassKind.CLASS,
        val annotations: List<KtAnnotation> = DEFAULT_ANNOTATION,
        isOverride: (MethodDeclaration) -> Boolean,
        isOverrideProperty: (PropertyDeclaration) -> Boolean,
        override val hasMembersOpenModifier: Boolean = true,
        override val needsNoImpl: Boolean = true
) : TsClassifierToKt(typeMapper, isOverride, isOverrideProperty) {

    override val isInterface = false

    var typeParams: List<KtTypeParam>? = null
    val paramsOfConstructors = arrayListOf<List<KtFunParam>>()

    override fun visitClassDeclaration(node: ClassDeclaration) {
//      todo visitList(node.modifiers)
        name = node.identifierName!!.unescapedText
        typeParams = node.typeParameters?.toKotlinTypeParams(typeMapper)

        node.heritageClauses?.arr?.forEach { visitNode(this, it) }
        node.members.arr.forEach { visitNode(this, it) }
    }

    override fun visitConstructorDeclaration(node: ConstructorDeclaration) {
        val paramsOverloads = node.parameters.toKotlinParamsOverloads(typeMapper)
        val nonVarParamOverloads = paramsOverloads.map { params ->
            params.map { param ->
                if (param.isVar) {
                    addVariable(null, param.name.value, param.type.type, isVar = param.isVar)
                }
                param.copy(isVar = false)
            }
        }
        paramsOfConstructors.addAll(nonVarParamOverloads)

        assert(node.body == null, "A constructor in declarations file should not have body, constructor in '${this.name}")
    }
}
