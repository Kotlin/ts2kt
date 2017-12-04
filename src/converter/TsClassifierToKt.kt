package ts2kt

import converter.mapType
import converter.mapTypeToUnion
import ts2kt.kotlin.ast.*
import ts2kt.utils.assert
import ts2kt.utils.reportUnsupportedNode
import typescript.PropertyName
import typescript.propertyName
import typescriptServices.ts.*

abstract class TsClassifierToKt(
        val typeMapper: ObjectTypeToKotlinTypeMapper,
        val isOverride: (MethodDeclaration) -> Boolean,
        val isOverrideProperty: (PropertyDeclaration) -> Boolean
) : TypeScriptToKotlinBase(mutableListOf()) {
    abstract val needsNoImpl: Boolean

    var parents = arrayListOf<KtHeritageType>()

    override fun visitHeritageClause(node: HeritageClause) {
        val types = node.types?.arr?.map { id -> KtHeritageType(typeMapper.mapType(id).stringify()) } ?: listOf()
        parents.addAll(types)
    }

    override fun visitIndexSignature(node: IndexSignatureDeclaration) {
        translateAccessor(node, isGetter = true)
        translateAccessor(node, isGetter = false)
    }

    private fun translateAccessor(node: IndexSignatureDeclaration, isGetter: Boolean) {
        // TODO type params?
        node.parameters.toKotlinParamsOverloads(typeMapper).forEach { params ->
            val propTypeUnion = if (isGetter) {
                KtTypeUnion(node.type?.let { typeMapper.mapType(it) } ?: KtType(ANY))
            } else {
                node.type?.let { typeMapper.mapTypeToUnion(it) } ?: KtTypeUnion(KtType(ANY))
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

                addFunction(accessorName, callSignature, needsNoImpl = needsNoImpl, additionalAnnotations = listOf(annotation), isOperator = true)
            }
        }
    }

    var name: String? = null

    var staticTranslator: TsClassToKt? = null

    ///???
    // TODO should be abstract? is static declarations inside (TS) interfaces allowed?
    fun getTranslator(node: ClassElement): TsClassifierToKt {
        if (node.modifiers?.arr?.any { it.kind === SyntaxKind.StaticKeyword } ?: false) {
            if (staticTranslator == null) {
                // TODO support override for static members
                staticTranslator = TsClassToKt(typeMapper, KtClassKind.COMPANION_OBJECT, listOf(), NOT_OVERRIDE, NOT_OVERRIDE, hasMembersOpenModifier = false)
                staticTranslator?.name = ""
            }
            return staticTranslator!!
        }

        return this
    }

    open fun needsNoImpl(node: PropertyDeclaration): Boolean = true
    open fun isNullable(node: PropertyDeclaration): Boolean = false
    open fun isLambda(node: PropertyDeclaration): Boolean = false

    open fun needsNoImpl(node: MethodDeclaration): Boolean = true

    override fun visitPropertyDeclaration(node: PropertyDeclaration) {
        val declarationName = node.propertyName!!

        val name = declarationName.asString() ?: return
        val varType = node.type?.let { typeMapper.mapType(it) } ?: KtType(ANY)

        val isOverride = isOverrideProperty(node)

        getTranslator(node).addVariable(
                name,
                type = varType.copy(isNullable = varType.isNullable || isNullable(node), isLambda = isLambda(node)),
                isOverride = isOverride,
                needsNoImpl = needsNoImpl(node)
        )
    }

    open fun TsClassifierToKt.addFunction(name: String, isOverride: Boolean, needsNoImpl: Boolean, node: MethodDeclaration) {
        node.toKotlinCallSignatureOverloads(typeMapper).forEach { callSignature ->
            addFunction(name, callSignature, isOverride = isOverride, needsNoImpl = needsNoImpl(node))
        }

        assert(node.body == null, "An function in declarations file should not have body, function '${this.name}.$name'")
    }

    override fun visitMethodDeclaration(node: MethodDeclaration) {
        val declarationName = node.propertyName!!
        val name = declarationName.asString() ?: return
        val isOverride = isOverride(node)

        getTranslator(node).addFunction(name, isOverride, needsNoImpl, node)
    }

    private fun PropertyName.asString() = when (kind as Any) {
        SyntaxKind.Identifier -> {
            unescapedText
        }
        else -> {
            reportUnsupportedNode(this)
            null
        }
    }
}
