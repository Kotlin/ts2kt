package converter

import ts2kt.*
import ts2kt.kotlin.ast.KtType
import ts2kt.kotlin.ast.KtTypeUnion
import ts2kt.kotlin.ast.stringify
import typescriptServices.ts.*

fun ObjectTypeToKotlinTypeMapper.mapType(type: Node): KtType {
    val resolvedType: Type? = typeChecker.getTypeAtLocation(type)
    return if (resolvedType != null) {
        mapType(resolvedType, type)
    }
    else {
        (type.unsafeCast<TypeNode>()).toKotlinType(this)
    }
}

fun ObjectTypeToKotlinTypeMapper.mapTypeToUnion(type: Node): KtTypeUnion {
    val resolvedType: Type? = typeChecker.getTypeAtLocation(type)
    return if (resolvedType != null) {
        mapTypeToUnion(resolvedType, type)
    }
    else {
        (type.unsafeCast<TypeNode>()).toKotlinTypeUnion(this)
    }
}

private fun ObjectTypeToKotlinTypeMapper.mapType(type: Type, declaration: Node?): KtType =
        mapTypeToUnion(type, declaration).singleType

private fun ObjectTypeToKotlinTypeMapper.mapTypeToUnion(type: Type, declaration: Node?): KtTypeUnion {
    val resultingDeclaration = declaration ?: type.symbol?.declarations?.singleOrNull()

    val flags = type.getFlags()
    if (resultingDeclaration != null && type.symbol == null && TypeFlags.Any in flags) {
        return resultingDeclaration.unsafeCast<TypeNode>().toKotlinTypeUnion(this)
    }

    if (resultingDeclaration?.kind == SyntaxKind.UnionType && TypeFlags.Union !in flags) {
        return resultingDeclaration.unsafeCast<UnionTypeNode>().toKotlinTypeUnion(this)
    }

    return when {
        TypeFlags.ThisType in flags -> {
            val possibleTypes = mapTypeToUnion(type.unsafeCast<TypeParameter>().constraint, null).possibleTypes
                    .map { it.copy(comment = "this") }
            KtTypeUnion(possibleTypes)
        }

        TypeFlags.Any in flags -> KtTypeUnion(KtType(ANY))
        TypeFlags.String in flags -> KtTypeUnion(KtType(STRING))
        TypeFlags.Boolean in flags -> KtTypeUnion(KtType(BOOLEAN))
        TypeFlags.Number in flags -> KtTypeUnion(KtType(NUMBER))
        TypeFlags.Void in flags -> KtTypeUnion(KtType(UNIT))

        TypeFlags.Undefined in flags ||
                TypeFlags.Null in flags -> KtTypeUnion(KtType(NOTHING, isNullable = true))

        TypeFlags.StringLiteral in flags -> {
            KtTypeUnion(KtType(STRING, comment = "\"" + type.unsafeCast<LiteralType>().text + "\""))
        }
        // TODO: add test if it's allowed
        TypeFlags.NumberLiteral in flags -> {
            KtTypeUnion(KtType(NUMBER, comment = type.unsafeCast<LiteralType>().text))
        }
        // TODO: add test if it's allowed
        TypeFlags.BooleanLiteral in flags -> {
            KtTypeUnion(KtType(BOOLEAN, comment = type.unsafeCast<LiteralType>().text))
        }

        TypeFlags.Union in flags -> mapUnionType(type.unsafeCast<UnionType>())
        TypeFlags.Intersection in flags -> mapIntersectionType(type.unsafeCast<IntersectionType>())

        TypeFlags.Anonymous in flags -> KtTypeUnion(mapAnonymousType(type))

        TypeFlags.Reference in flags -> KtTypeUnion(mapTypeReference(type.unsafeCast<TypeReference>(), declaration))

        TypeFlags.TypeParameter in flags -> KtTypeUnion(KtType(unescapeIdentifier(type.getSymbol().name)))

        TypeFlags.ObjectType in flags ||
                TypeFlags.Enum in flags -> KtTypeUnion(mapObjectType(type.unsafeCast<ObjectType>()))

        else -> KtTypeUnion(KtType(ANY, isNullable = true))
    }
}

private fun ObjectTypeToKotlinTypeMapper.mapUnionType(type: UnionOrIntersectionType): KtTypeUnion {
    val notNullTypes = type.types.filter {
        TypeFlags.Undefined !in it.getFlags() &&
                TypeFlags.Null !in it.getFlags()
    }
    val nullable = notNullTypes.size != type.types.size || type.containsNull || type.containsUndefined

    val mappedTypes = notNullTypes.map { mapType(it, null) }
    return KtTypeUnion(when {
        !nullable -> mappedTypes.distinct()
        notNullTypes.size == 1 -> mappedTypes.map { it.copy(isNullable = true) }
        else -> (mappedTypes + KtType(NOTHING, isNullable = true)).distinct()
    })
}

private inline val UnionOrIntersectionType.containsUndefined: Boolean
    get() {
        val array = types.asDynamic()
        return jsTypeOf(array.containsUndefined) == "boolean" && array.containsUndefined.unsafeCast<Boolean>()
    }

private inline val UnionOrIntersectionType.containsNull: Boolean
    get() {
        val array = types.asDynamic()
        return jsTypeOf(array.containsNull) == "boolean" && array.containsNull.unsafeCast<Boolean>()
    }

private fun ObjectTypeToKotlinTypeMapper.mapIntersectionType(type: IntersectionType): KtTypeUnion {
    return KtTypeUnion(mapType(type.types.first(), null).copy(
            comment = type.types.joinToString(" & ") { mapType(it, null).stringify() }
    ))
}

private fun ObjectTypeToKotlinTypeMapper.mapTypeReference(type: TypeReference, declaration: Node?): KtType {
    val argumentDeclarations = if (declaration != null) {
        when (declaration.kind as Any) {
            SyntaxKind.TypeReference -> {
                declaration.unsafeCast<ExpressionWithTypeArguments>()
                        .typeArguments?.unsafeCast<Array<Node>?>()
                        ?.asSequence() ?: emptySequence()
            }
            SyntaxKind.ArrayType -> {
                sequenceOf(declaration.unsafeCast<ArrayTypeNode>().elementType)
            }
            else -> {
                emptySequence()
            }
        }
    }
    else {
        emptySequence()
    }

    val typeArgsWithDeclarations = type.typeArguments.orEmpty().asSequence()
            .zip(argumentDeclarations + generateSequence { 0 }.map { null })
    val mappedArgs = typeArgsWithDeclarations.map { (argType, arg) ->
        mapType(argType, arg)
    }
    return mapObjectType(type.target).copy(typeArgs = mappedArgs.toList())
}

private fun ObjectTypeToKotlinTypeMapper.mapObjectType(type: ObjectType): KtType {
    val fqn = typeChecker.getFullyQualifiedName(type.getSymbol())
    if (fqn == "Function") return KtType("Function", typeArgs = listOf(KtType("*")))
    return KtType(when (fqn) {
        "Object" -> ANY
        else -> {
            if (currentPackage.isNotEmpty() && fqn.startsWith(currentPackage + ".") &&
                    fqn.indexOf('.', currentPackage.length + 1) < 0
                    ) {
                fqn.substring(currentPackage.length + 1)
            }
            else {
                fqn
            }
        }
    })
}

private fun ObjectTypeToKotlinTypeMapper.mapAnonymousType(type: Type): KtType {
    val decl = type.getSymbol().getDeclarations().singleOrNull() ?: return KtType(ANY, isNullable = true)
    return when (decl.kind as Any) {
        SyntaxKind.FunctionType -> decl.unsafeCast<FunctionTypeNode>().toKotlinType(this)
        SyntaxKind.TypeLiteral -> getKotlinTypeForObjectType(decl.unsafeCast<TypeLiteralNode>())
        else -> KtType(ANY, isNullable = true)
    }
}