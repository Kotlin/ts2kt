package ts2kt

import ts2kt.kotlin.ast.KtAnnotation
import ts2kt.kotlin.ast.KtTypeParam
import ts2kt.kotlin.ast.createFunctionType
import typescript.identifierName
import typescriptServices.ts.*

open class TsInterfaceToKt(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        val annotations: List<KtAnnotation>,
        isOverride: (MethodDeclaration) -> Boolean,
        isOverrideProperty: (PropertyDeclaration) -> Boolean
) : TsClassifierToKt(typeMapper, isOverride, isOverrideProperty) {

    override val hasMembersOpenModifier = false

    override val needsNoImpl = false

    override val isInterface: Boolean = true

    var typeParams: List<KtTypeParam>? = null

    override fun needsNoImpl(node: PropertyDeclaration) = node.questionToken != null
    override fun isNullable(node: PropertyDeclaration) = node.questionToken != null
    override fun isLambda(node: PropertyDeclaration) = node.type?.kind === SyntaxKind.FunctionType

    override fun needsNoImpl(node: MethodDeclaration) = false
    override fun TsClassifierToKt.addFunction(name: String, isOverride: Boolean, needsNoImpl: Boolean, node: MethodDeclaration) {
        val isOptional = node.questionToken != null
        val symbol = typeMapper.typeChecker.getSymbolResolvingAliases(node)
        if (isOptional) {
            val call = node.toKotlinCallSignature(typeMapper)
            addVariable(symbol, name, type = createFunctionType(call.params, call.returnType.type).copy(isNullable = true), typeParams = call.typeParams, isVar = false, needsNoImpl = true, isOverride = isOverride)
        } else {
            node.toKotlinCallSignatureOverloads(typeMapper).forEach { call ->
                addFunction(symbol, name, call, needsNoImpl = false, isOverride = isOverride)
            }
        }

    }

    override fun visitInterfaceDeclaration(node: InterfaceDeclaration) {
//      todo visitList(node.modifiers)
        name = node.identifierName.unescapedText
        typeParams = node.typeParameters?.toKotlinTypeParams(typeMapper)

        // TODO merge with class?
        node.heritageClauses?.arr?.forEach { visitNode(this, it) }
        node.members.arr.forEach { visitNode(this, it) }
    }

    override fun visitSignatureDeclaration(node: SignatureDeclaration) {
        node.toKotlinCallSignatureOverloads(typeMapper).forEach { callSignature ->
            addFunction(null, INVOKE, callSignature, needsNoImpl = false, additionalAnnotations = listOf(NATIVE_INVOKE_ANNOTATION), isOperator = true)
        }
    }

    override fun visitConstructSignatureDeclaration(node: ConstructorDeclaration) {
          // TODO: support ConstructorDeclaration
//        node.toKotlinCallSignatureOverloads(typeMapper).forEach { callSignature ->
//            addFunction(INVOKE, callSignature, needsNoImpl = false, additionalAnnotations = listOf(NATIVE_NEW_ANNOTATION))
//        }
    }
}
