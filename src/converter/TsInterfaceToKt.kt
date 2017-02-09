package ts2kt

import ts2kt.kotlin.ast.*
import ts2kt.utils.join
import typescript.TS
import typescript.identifierName

open class TsInterfaceToKt(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        val annotations: List<KtAnnotation>,
        isOverride: (TS.MethodDeclaration) -> Boolean,
        isOverrideProperty: (TS.PropertyDeclaration) -> Boolean
) : TsClassifierToKt(typeMapper, isOverride, isOverrideProperty) {

    override val hasMembersOpenModifier = false

    override val needsNoImpl = false

    override val isInterface: Boolean = true

    var typeParams: List<KtTypeParam>? = null

    override fun needsNoImpl(node: TS.PropertyDeclaration) = node.questionToken != null
    override fun isNullable(node: TS.PropertyDeclaration) = node.questionToken != null
    override fun isLambda(node: TS.PropertyDeclaration) = node.type?.kind === TS.SyntaxKind.FunctionType

    override fun needsNoImpl(node: TS.MethodDeclaration) = false
    override fun TsClassifierToKt.addFunction(name: String, isOverride: Boolean, needsNoImpl: Boolean, node: TS.MethodDeclaration) {
        val isOptional = node.questionToken != null
        if (isOptional) {
            val call = node.toKotlinCallSignature(typeMapper)
            val typeAsString = "(${call.params.join(", ", stringify = KtFunParam::stringify)}) -> ${call.returnType.type.stringify()}"
            addVariable(name, type = KtType(typeAsString, isNullable = true, isLambda = true), typeParams = call.typeParams, isVar = false, needsNoImpl = true, isOverride = isOverride)
        }
        else {
            node.toKotlinCallSignatureOverloads(typeMapper).forEach { call ->
                addFunction(name, call, needsNoImpl = false, isOverride = isOverride)
            }
        }

    }

    override fun visitInterfaceDeclaration(node: TS.InterfaceDeclaration) {
//      todo visitList(node.modifiers)
        name = node.identifierName.unescapedText
        typeParams = node.typeParameters?.toKotlinTypeParams(typeMapper)

        // TODO merge with class?
        node.heritageClauses?.arr?.forEach { visitNode(this, it) }
        node.members.arr.forEach { visitNode(this, it) }
    }

    override fun visitSignatureDeclaration(node: TS.SignatureDeclaration) {
        node.toKotlinCallSignatureOverloads(typeMapper).forEach { callSignature ->
            addFunction(INVOKE, callSignature, needsNoImpl = false, additionalAnnotations = listOf(NATIVE_INVOKE_ANNOTATION))
        }
    }

    override fun visitConstructSignatureDeclaration(node: TS.ConstructorDeclaration) {
        node.toKotlinCallSignatureOverloads(typeMapper).forEach { callSignature ->
            addFunction(INVOKE, callSignature, needsNoImpl = false, additionalAnnotations = listOf(NATIVE_NEW_ANNOTATION))
        }
    }
}
