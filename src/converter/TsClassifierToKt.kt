package ts2kt

import ts2kt.kotlin.ast.*
import ts2kt.utils.assert
import typescript.TS
import typescript.propertyName

abstract class TsClassifierToKt(
        val typeMapper: ObjectTypeToKotlinTypeMapper,
        val isOverride: (TS.MethodDeclaration) -> Boolean,
        val isOverrideProperty: (TS.PropertyDeclaration) -> Boolean
) : TypeScriptToKotlinBase() {
    abstract val needsNoImpl: Boolean

    var parents = arrayListOf<KtHeritageType>()

    override fun visitHeritageClause(node: TS.HeritageClause) {
        val types = node.types?.arr?.map { id -> KtHeritageType(id.toKotlinType(typeMapper).stringify()) } ?: listOf()
        parents.addAll(types)
    }

    override fun visitIndexSignature(node: TS.IndexSignatureDeclaration) {
        translateAccessor(node, isGetter = true)
        translateAccessor(node, isGetter = false)
    }

    private fun translateAccessor(node: TS.IndexSignatureDeclaration, isGetter: Boolean) {
        // TODO type params?
        node.parameters.toKotlinParamsOverloads(typeMapper).forEach { params ->
            val propTypeUnion = if (isGetter) {
                KtTypeUnion(node.type?.toKotlinType(typeMapper) ?: KtType(ANY))
            } else {
                node.type?.toKotlinTypeUnion(typeMapper) ?: KtTypeUnion(KtType(ANY))
            }
            propTypeUnion.possibleTypes.forEach { propType ->
                val callSignature: KtCallSignature
                val accessorName: String
                val annotation: KtAnnotation
                if (isGetter) {
                    // per Kotlin, all @nativeGetter's must be nullable
                    callSignature = KtCallSignature(params, listOf(), KtTypeAnnotation(propType.copy(isNullable = true)))
                    accessorName = GET
                    annotation = NATIVE_GETTER_ANNOTATION
                }
                else {
                    callSignature = KtCallSignature(listOf(params[0], KtFunParam("value", KtTypeAnnotation(propType))), listOf(), KtTypeAnnotation(KtType(UNIT)))
                    accessorName = SET
                    annotation = NATIVE_SETTER_ANNOTATION
                }

                addFunction(accessorName, callSignature, needsNoImpl = needsNoImpl, additionalAnnotations = listOf(annotation))
            }
        }
    }

    var name: String? = null

    var staticTranslator: TsClassToKt? = null

    ///???
    // TODO should be abstract? is static declarations inside (TS) interfaces allowed?
    fun getTranslator(node: TS.ClassElement): TsClassifierToKt {
        if (node.modifiers?.arr?.any { it.kind === TS.SyntaxKind.StaticKeyword } ?: false) {
            if (staticTranslator == null) {
                // TODO support override for static members
                staticTranslator = TsClassToKt(typeMapper, KtClassKind.COMPANION_OBJECT, listOf(), NOT_OVERRIDE, NOT_OVERRIDE, hasMembersOpenModifier = false)
                staticTranslator?.name = ""
            }
            return staticTranslator!!
        }

        return this
    }

    open fun needsNoImpl(node: TS.PropertyDeclaration): Boolean = true
    open fun isNullable(node: TS.PropertyDeclaration): Boolean = false
    open fun isLambda(node: TS.PropertyDeclaration): Boolean = false

    open fun needsNoImpl(node: TS.MethodDeclaration): Boolean = true

    override fun visitPropertyDeclaration(node: TS.PropertyDeclaration) {
        val declarationName = node.propertyName!!

        val name = declarationName.unescapedText
        val varType = node.type?.toKotlinType(typeMapper) ?: KtType(ANY)

        val isOverride = isOverrideProperty(node)

        getTranslator(node).addVariable(
                name,
                type = varType.copy(isNullable = varType.isNullable || isNullable(node), isLambda = isLambda(node)),
                isOverride = isOverride,
                needsNoImpl = needsNoImpl(node)
        )
    }

    open fun TsClassifierToKt.addFunction(name: String, isOverride: Boolean, needsNoImpl: Boolean, node: TS.MethodDeclaration) {
        node.toKotlinCallSignatureOverloads(typeMapper).forEach { callSignature ->
            addFunction(name, callSignature, isOverride = isOverride, needsNoImpl = needsNoImpl(node))
        }

        assert(node.body == null, "An function in declarations file should not have body, function '${this.name}.$name'")
    }

    override fun visitMethodDeclaration(node: TS.MethodDeclaration) {
        val declarationName = node.propertyName!!
        val name = declarationName.unescapedText
        val isOverride = isOverride(node)

        getTranslator(node).addFunction(name, isOverride, needsNoImpl, node)
    }
}
