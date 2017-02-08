package ts2kt.kotlin.ast

import ts2kt.DYNAMIC
import ts2kt.NATIVE_ANNOTATION
import ts2kt.escapeIfNeed


val NO_IMPL = "definedExternally"
private val EQ_NO_IMPL = " = $NO_IMPL"
private val NO_IMPL_PROPERTY_GETTER = " get()" + EQ_NO_IMPL
private val NO_IMPL_PROPERTY_SETTER = " set(value)" + EQ_NO_IMPL
private val EXTERNAL = "external"
private val OPEN = "open"
private val OVERRIDE = "override"
private val VAR = "var"
private val VAL = "val"
private val FUN = "fun"
private val VARARG = "vararg"


class Stringify(private val packagePartPrefix: String?) : Visitor {
    val result: String
        get() = out.toString()

    private val out = Output()

    private fun List<Node>.acceptForEach(visitor: Visitor, delimiter: String? = null, startWithIfNotEmpty: String? = null, endWithIfNotEmpty: String? = null) {
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

    override fun visitNode(node: Node) {
        TODO()
    }

    override fun visitAnnotation(annotation: Annotation) {
        // TODO remove hack
        if (annotation == NATIVE_ANNOTATION) return

        out.printWithIndent("@" + annotation.escapedName)
        annotation.parameters.acceptForEach(this, delimiter = ", ", startWithIfNotEmpty = "(", endWithIfNotEmpty = ")")
        out.println()
    }

    override fun visitClassifier(classifier: Classifier) {
        with (classifier) {
            annotations.acceptForEach(this@Stringify)

            out.printIndent()

            // TODO remove hack
            if (annotations.any { it == NATIVE_ANNOTATION }) {
                out.print(EXTERNAL + " ")
            }

            if (hasOpenModifier) {
                out.print(OPEN + " ")
            }

            out.print(kind.keyword)

            if (name.isNotEmpty()) {
                out.print(" ")
            }

            out.print(escapedName)
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

                members.filter(takeIfNotAnnotatedAsFake)
                        .acceptForEach(this@Stringify,
                                delimiter = if (kind == ClassKind.ENUM) ",\n" else "",
                                endWithIfNotEmpty = if (kind == ClassKind.ENUM) "\n" else "")
            }

            if (bracesRequired) {
                out.printWithIndent("}")
            }
        }
        out.println()
    }

    override fun visitFunction(function: Function) {
        with(function) {
            annotations.acceptForEach(this@Stringify)

            out.printIndent()

            // TODO remove hack
            if (annotations.any { it == NATIVE_ANNOTATION }) {
                out.print(EXTERNAL + " ")
            }

            if (isOverride) {
                out.print(OVERRIDE + " ")
            }
            else if (hasOpenModifier) {
                out.print(OPEN + " ")
            }
            out.print(FUN + " ")

            callSignature.printTypeParams(withSpaceAfter = true)

            if (extendsType != null) {
                extendsType.accept(this@Stringify)
                out.print(".")
            }

            out.print(escapedName)

            callSignature.printToOut(withTypeParams = false, printUnitReturnType = needsNoImpl, printDefaultValues = !isOverride)

            if (needsNoImpl) {
                out.print(EQ_NO_IMPL)
            }
        }
        out.println()
    }

    override fun visitVariable(variable: Variable) {
        with(variable) {
            annotations.acceptForEach(this@Stringify)

            out.printIndent()

            // TODO remove hack
            if (annotations.any { it == NATIVE_ANNOTATION }) {
                out.print(EXTERNAL + " ")
            }

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

            out.print(name.escapeIfNeed())

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

    override fun visitPackagePart(packagePart: PackagePart) {
        val packageNameParts = (packagePartPrefix?.let(::listOf) ?: emptyList()) + packagePart.fqName

        if (packageNameParts.isNotEmpty()) {
            out.println("package " + packageNameParts.joinToString(".", transform = String::escapeIfNeed))
            out.println()
        }

        packagePart.members.filter(takeIfNotAnnotatedAsFake).acceptForEach(this)
    }

    fun FunParam.printToOut(printDefaultValue: Boolean) {
        if (isVar) {
            out.print("$OPEN $VAR ")
        }
        if (type.isVararg) {
            out.print(VARARG + " ")
        }

        out.print(escapedName)

        type.printToOut(printUnitType = true)

        if (defaultValue != null && printDefaultValue) {
            out.print(" = $NO_IMPL /* $defaultValue */")
        }
    }

    override fun visitFunParam(funParam: FunParam) {
        funParam.printToOut(printDefaultValue = true)
    }

    override fun visitCallSignature(signature: CallSignature) {
        signature.printToOut(withTypeParams = true, printUnitReturnType = true, printDefaultValues = true)
    }

    fun CallSignature.printTypeParams(withSpaceAfter: Boolean) {
        typeParams?.acceptForEach(
                this@Stringify,
                delimiter = ", ",
                startWithIfNotEmpty = "<",
                endWithIfNotEmpty = ">" + if (withSpaceAfter) " " else "")
    }

    fun CallSignature.printToOut(withTypeParams: Boolean, printUnitReturnType: Boolean, printDefaultValues: Boolean) {
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



    override fun visitEnumEntry(enumEntry: EnumEntry) {
        out.printWithIndent(enumEntry.escapedName)
        enumEntry.value?.let { out.print(" /* = $it */") }
    }

    override fun visitTypeParam(typeParam: TypeParam) {
        out.print(typeParam.escapedName)
        typeParam.upperBound?.let {
            out.print(" : ")
            it.accept(this)
        }
    }

    fun TypeAnnotation.printToOut(printUnitType: Boolean) {
        val isUnit = type.isUnit() && !isVararg
        if (!printUnitType && isUnit) return

        out.print(": ")
        type.accept(this@Stringify)
    }

    override fun visitTypeAnnotation(typeAnnotation: TypeAnnotation) {
        typeAnnotation.printToOut(true)
    }

    override fun visitType(type: Type) {
        with(type) {
            if (isLambda && isNullable) {
                out.print("(")
            }

            out.print(escapedName)

            typeArgs.acceptForEach(this@Stringify, ", ", startWithIfNotEmpty = "<", endWithIfNotEmpty = ">")

            if (isLambda && isNullable) {
                out.print(")")
            }


            if (isNullable && name != DYNAMIC) {
                out.print("?")
            }

            comment?.let {
                out.print(" /* $it */")
            }
        }
    }

    override fun visitTypeUnion(typeUnion: TypeUnion) {
        typeUnion.possibleTypes.acceptForEach(this, " | ")
    }

    override fun visitHeritageType(heritageType: HeritageType) {
        out.print(heritageType.escapedName)
    }

    override fun visitArgument(argument: Argument) {
        argument.name?.let {
            out.print("$it = ")
        }
        out.print(argument.value.toString())
    }
}
