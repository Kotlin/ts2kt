package ts2kt.kotlin.ast

import ts2kt.DYNAMIC
import ts2kt.NATIVE_ANNOTATION
import ts2kt.escapeIfNeed
import ts2kt.sanitize


val NO_IMPL = "definedExternally"
private val EQ_NO_IMPL = " = $NO_IMPL"
private val NO_IMPL_PROPERTY_GETTER = " get()" + EQ_NO_IMPL
private val NO_IMPL_PROPERTY_SETTER = " set(value)" + EQ_NO_IMPL
private val EXTERNAL = "external"
private val OPEN = "open"
private val OVERRIDE = "override"
private val OPERATOR = "operator"
private val VAR = "var"
private val VAL = "val"
private val FUN = "fun"
private val VARARG = "vararg"


class Stringify(
        private val packagePartPrefix: String?,
        private val topLevel: Boolean,
        private val additionalImports: List<String> = listOf(),
        private val suppressedDiagnostics: List<String> = listOf(),
        private val out: Output = Output()
) : KtVisitor {
    val result: String
        get() = out.toString()

    private fun List<KtNode>.acceptForEach(visitor: KtVisitor, delimiter: String? = null, startWithIfNotEmpty: String? = null, endWithIfNotEmpty: String? = null) {
        if (isNotEmpty() && startWithIfNotEmpty != null) {
            out.print(startWithIfNotEmpty)
        }

        for (i in indices) {
            if (delimiter != null && i > 0) {
                out.print(delimiter)
            }
            this[i].accept(visitor)
        }

        if (isNotEmpty() && endWithIfNotEmpty != null) {
            out.print(endWithIfNotEmpty)
        }
    }

    override fun visitNode(node: KtNode) {
        TODO()
    }

    override fun visitAnnotation(annotation: KtAnnotation) {
        // TODO remove hack
        if (annotation == NATIVE_ANNOTATION) return

        out.printWithIndent("@")
        printAnnotation(annotation)
        out.println()
    }

    // TODO remove hack
    private fun printExternalIfNeed() {
        if (topLevel) {
            out.print(EXTERNAL + " ")
        }
    }

    private fun printAnnotation(annotation: KtAnnotation) {
        out.print(annotation.name.asString())
        annotation.parameters.acceptForEach(this, delimiter = ", ", startWithIfNotEmpty = "(", endWithIfNotEmpty = ")")
    }

    override fun visitClassifier(classifier: KtClassifier) {
        with (classifier) {
            annotations.acceptForEach(this@Stringify)

            out.printIndent()

            printExternalIfNeed()

            if (hasOpenModifier) {
                out.print(OPEN + " ")
            }

            out.print(kind.keyword)

            val nameToPrint = name.asString()

            if (nameToPrint.isNotEmpty()) {
                out.print(" $nameToPrint")
            }

            typeParams?.acceptForEach(this@Stringify, ", ", startWithIfNotEmpty = "<", endWithIfNotEmpty = ">")

            if (paramsOfConstructors.size == 1) {
                paramsOfConstructors[0].acceptForEach(this@Stringify, delimiter = ", ", startWithIfNotEmpty = "(", endWithIfNotEmpty = ")")
            }

            parents.acceptForEach(this@Stringify, delimiter = ", ", startWithIfNotEmpty = " : ")

            val bracesRequired = kind.bracesAlwaysRequired || (paramsOfConstructors.size > 1) || !members.isEmpty()

            if (bracesRequired) {
                out.println(" {")
            }

            out.indent {
                if (paramsOfConstructors.size > 1) {
                    paramsOfConstructors.forEach {
                        printWithIndent("constructor(")
                        it.acceptForEach(this@Stringify, delimiter = ", ")
                        println(")")
                    }
                }

                members.filter(isNotAnnotatedAsFake)
                        .acceptForEach(innerStringifier(),
                                delimiter = if (kind == KtClassKind.ENUM) ",\n" else "",
                                endWithIfNotEmpty = if (kind == KtClassKind.ENUM) "\n" else "")
            }

            if (bracesRequired) {
                out.printWithIndent("}")
            }
        }
        out.println()
    }

    override fun visitFunction(function: KtFunction) {
        with(function) {
            annotations.acceptForEach(this@Stringify)

            out.printIndent()

            // TODO remove hack
            printExternalIfNeed()

            if (isOverride) {
                out.print(OVERRIDE + " ")
            }
            else if (hasOpenModifier) {
                out.print(OPEN + " ")
            }

            if (isOperator) {
                out.print(OPERATOR + " ")
            }

            out.print(FUN + " ")

            callSignature.printTypeParams(withSpaceAfter = true)

            if (extendsType != null) {
                extendsType.accept(this@Stringify)
                out.print(".")
            }

            out.print(name.asString())

            callSignature.printToOut(withTypeParams = false, printUnitReturnType = needsNoImpl, printDefaultValues = !isOverride)

            if (needsNoImpl) {
                out.print(EQ_NO_IMPL)
            }
        }
        out.println()
    }

    override fun visitVariable(variable: KtVariable) {
        with(variable) {
            annotations.acceptForEach(this@Stringify)

            out.printIndent()

            // TODO remove hack
            printExternalIfNeed()

            // TODO extract common logic between Variable and Function
            if (isOverride) {
                out.print(OVERRIDE + " ")
            } else if (hasOpenModifier) {
                out.print(OPEN + " ")
            }

            out.print((if (isVar) VAR else VAL) + " ")

            typeParams?.acceptForEach(this@Stringify, ", ", startWithIfNotEmpty = "<", endWithIfNotEmpty = "> ")

            extendsType?.let {
                it.accept(this@Stringify)
                out.print(".")
            }

            out.print(name.asString())

            type.printToOut(printUnitType = !needsNoImpl)

            if (needsNoImpl) {
                if (isInInterface) {
                    out.print(NO_IMPL_PROPERTY_GETTER)
                    if (isVar) {
                        out.print(";" + NO_IMPL_PROPERTY_SETTER)
                    }
                } else {
                    out.print(EQ_NO_IMPL)
                }
            }
        }
        out.println()
    }

    override fun visitPackagePart(packagePart: KtPackagePart) {
        val annotations = packagePart.annotations.filter { it != NATIVE_ANNOTATION }

        if (suppressedDiagnostics.isNotEmpty()) {
            out.printlnWithIndent("@file:Suppress(${suppressedDiagnostics.joinToString { "\"$it\"" } })")
            if (annotations.isEmpty()) out.println()
        }

        annotations.let {
            if (it.isNotEmpty()) {
                out.print("@file:")
                if (it.size == 1) {
                    printAnnotation(it.first())
                }
                else {
                    out.print("[")
                    it.forEachIndexed { i, annotation ->
                        if (i > 0) {
                            out.print(" ")
                        }
                        printAnnotation(annotation)
                    }
                    out.print("]")
                }
                out.println()
            }
        }

        val packageNameParts = (packagePartPrefix?.let(::listOf) ?: emptyList()) + packagePart.fqName

        if (packageNameParts.isNotEmpty()) {
            out.println("package " + packageNameParts.joinToString(".", transform = { it.sanitize().escapeIfNeed() }))
            out.println()
        }

        if (additionalImports.isNotEmpty()) {
            additionalImports.forEach {
                out.printlnWithIndent("import " + it)
            }
            out.println()
        }

        packagePart.members.filter(isNotAnnotatedAsFake).acceptForEach(this)
    }

    fun KtFunParam.printToOut(printDefaultValue: Boolean) {
        if (isVar) {
            out.print("$OPEN $VAR ")
        }
        if (type.isVararg) {
            out.print(VARARG + " ")
        }

        out.print(name.asString())

        type.printToOut(printUnitType = true)

        if (defaultValue != null && printDefaultValue) {
            out.print(" = $NO_IMPL /* $defaultValue */")
        }
    }

    override fun visitFunParam(funParam: KtFunParam) {
        funParam.printToOut(printDefaultValue = true)
    }

    override fun visitCallSignature(signature: KtCallSignature) {
        signature.printToOut(withTypeParams = true, printUnitReturnType = true, printDefaultValues = true)
    }

    fun KtCallSignature.printTypeParams(withSpaceAfter: Boolean) {
        typeParams?.acceptForEach(
                this@Stringify,
                delimiter = ", ",
                startWithIfNotEmpty = "<",
                endWithIfNotEmpty = ">" + if (withSpaceAfter) " " else "")
    }

    fun KtCallSignature.printToOut(withTypeParams: Boolean, printUnitReturnType: Boolean, printDefaultValues: Boolean) {
        if (withTypeParams) {
            printTypeParams(withSpaceAfter = false)
        }

        out.print("(")
        params.forEachIndexed { index, funParam ->
            if (index > 0) out.print(", ")
            funParam.printToOut(printDefaultValues)
        }
        out.print(")")

        returnType.printToOut(printUnitType = printUnitReturnType)
    }

    override fun visitEnumEntry(enumEntry: KtEnumEntry) {
        out.printWithIndent(enumEntry.name.asString())
        enumEntry.value?.let { out.print(" /* = $it */") }
    }

    override fun visitTypeParam(typeParam: KtTypeParam) {
        out.print(typeParam.name.asString())
        typeParam.upperBound?.let {
            out.print(" : ")
            it.accept(this)
        }
    }

    fun KtTypeAnnotation.printToOut(printUnitType: Boolean) {
        val isUnit = type.isUnit() && !isVararg
        if (!printUnitType && isUnit) return

        out.print(": ")
        type.accept(this@Stringify)
    }

    override fun visitTypeAnnotation(typeAnnotation: KtTypeAnnotation) {
        typeAnnotation.printToOut(true)
    }

    override fun visitType(type: KtType) {
        with(type) {
            val callSignature = type.callSignature
            if (callSignature != null) {
                if (isNullable) out.print("(")

                val params = callSignature.params.joinToString(", ") {
                    it.name.asString() + it.type.stringify() + (it.defaultValue?.let { " /*= $it*/" } ?: "")
                }
                val typeAsString = "($params) -> ${callSignature.returnType.type.stringify()}"
                out.print(typeAsString)

                if (isNullable) out.print(")")
            }
            else {
                out.print(qualifiedName.asString())

                typeArgs.acceptForEach(this@Stringify, ", ", startWithIfNotEmpty = "<", endWithIfNotEmpty = ">")
            }

            if (isNullable && qualifiedName != DYNAMIC) {
                out.print("?")
            }

            comment?.let {
                out.print(" /* $it */")
            }
        }
    }

    override fun visitTypeUnion(typeUnion: KtTypeUnion) {
        typeUnion.possibleTypes.acceptForEach(this, " | ")
    }

    override fun visitHeritageType(heritageType: KtHeritageType) {
        visitType(heritageType.type)
        heritageType.byExpression?.let {
            out.print(" by $it")
        }
    }

    override fun visitArgument(argument: KtArgument) {
        argument.name?.let {
            out.print("$it = ")
        }
        out.print(argument.value.toString())
    }

    private fun innerStringifier() =
            Stringify(packagePartPrefix, /*topLevel = */false, additionalImports, suppressedDiagnostics, out)
}
