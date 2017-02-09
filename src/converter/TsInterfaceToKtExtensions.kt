package ts2kt

import ts2kt.kotlin.ast.*
import ts2kt.utils.assert
import ts2kt.utils.join
import typescript.TS

class TsInterfaceToKtExtensions(
        typeMapper: ObjectTypeToKotlinTypeMapper,
        annotations: List<KtAnnotation>,
        isOverride: (TS.MethodDeclaration) -> Boolean,
        isOverrideProperty: (TS.PropertyDeclaration) -> Boolean
) : TsInterfaceToKt(typeMapper, annotations, isOverride, isOverrideProperty){

    val cachedExtendsType by lazy { getExtendsType(typeParams) }

    fun getExtendsType(typeParams: List<KtTypeParam>?) = name!! + (typeParams?.join(startWithIfNotEmpty = "<", endWithIfNotEmpty = ">", stringify = KtTypeParam::stringify) ?: "")

    fun List<KtTypeParam>?.fixIfClashWith(another: List<KtTypeParam>?): List<KtTypeParam>? {
        if (this == null || another == null) return this

        assert(!(this === another), "expected this !== another, this = $this, another = $another")

        val extendsTypeParams = arrayListOf<KtTypeParam>()
        for (e in this) {
            var toAdd = e.name
            var i = 0
            while (another.any { it.name == toAdd }) toAdd = e.name + i++

            extendsTypeParams.add(KtTypeParam(toAdd, e.upperBound))
        }

        return extendsTypeParams
    }

    infix fun List<KtTypeParam>?.merge(another: List<KtTypeParam>?): List<KtTypeParam>? = when {
        this == null -> another
        another == null -> this
        else -> this + another
    }

    fun List<KtAnnotation>.withNativeAnnotation() = when {
        defaultAnnotations.any(IS_NATIVE_ANNOTATION) || this.any(IS_NATIVE_ANNOTATION) -> {
            this
        }
        else -> {
            val list = arrayListOf<KtAnnotation>()
            list.add(NATIVE_ANNOTATION)
            list.addAll(this)
            list
        }
    }

    override fun addVariable(name: String, type: KtType, extendsType: String?, typeParams: List<KtTypeParam>?, isVar: Boolean, needsNoImpl: Boolean, additionalAnnotations: List<KtAnnotation>, isOverride: Boolean) {
        val typeParamsWithoutClashes = this.typeParams.fixIfClashWith(typeParams)
        val actualExtendsType = if (typeParamsWithoutClashes === this.typeParams) cachedExtendsType else getExtendsType(typeParamsWithoutClashes)
        val annotations = additionalAnnotations.withNativeAnnotation()

        super.addVariable(name, type, actualExtendsType, typeParamsWithoutClashes merge typeParams, isVar,
                needsNoImpl = true, additionalAnnotations = annotations, isOverride = isOverride)
    }

    override fun addFunction(name: String, callSignature: KtCallSignature, extendsType: String?, needsNoImpl: Boolean, additionalAnnotations: List<KtAnnotation>, isOverride: Boolean) {
        val typeParamsWithoutClashes = this.typeParams.fixIfClashWith(callSignature.typeParams)
        val actualExtendsType = if (typeParamsWithoutClashes === this.typeParams) cachedExtendsType else getExtendsType(typeParamsWithoutClashes)
        val annotations = additionalAnnotations.withNativeAnnotation()

        super.addFunction(name, KtCallSignature(callSignature.params, typeParamsWithoutClashes merge callSignature.typeParams, callSignature.returnType), actualExtendsType, true, annotations, isOverride)
    }

}
