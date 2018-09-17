package converter

import ts2kt.*
import ts2kt.kotlin.ast.*
import ts2kt.utils.DiagnosticLevel
import ts2kt.utils.report
import typescriptServices.ts.*
import kotlin.collections.Map

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

    if (type in typesInMappingProcess) {
        report(
                "Recursion is detected when resolve type: \"${type.symbol?.name}\" for the declaration at ${declaration?.location()}",
                maxLevelToShow = DiagnosticLevel.WARNING_WITH_STACKTRACE
        )
        return KtTypeUnion(KtType(DYNAMIC))
    }

    typesInMappingProcess += type

    val mappedType = when {
        declaration?.kind == SyntaxKind.ThisType -> {
            val possibleTypes = mapTypeToUnion(type.unsafeCast<TypeParameter>().constraint!!, null).possibleTypes
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
            KtTypeUnion(KtType(STRING, comment = "\"" + type.unsafeCast<LiteralType>().value + "\""))
        }
        // TODO: add test if it's allowed
        TypeFlags.NumberLiteral in flags -> {
            KtTypeUnion(KtType(NUMBER, comment = type.unsafeCast<LiteralType>().value))
        }
        // TODO: add test if it's allowed
        TypeFlags.BooleanLiteral in flags -> {
            KtTypeUnion(KtType(BOOLEAN, comment = type.unsafeCast<LiteralType>().value))
        }

        TypeFlags.Union in flags -> mapUnionType(type.unsafeCast<UnionType>())
        TypeFlags.Intersection in flags -> mapIntersectionType(type.unsafeCast<IntersectionType>())

        TypeFlags.TypeParameter in flags -> KtTypeUnion(KtType(KtQualifiedName(unescapeIdentifier(type.getSymbol()!!.name))))

        TypeFlags.Object in flags -> {
            val objectFlags = (type as ObjectType).objectFlags
            when {
                ObjectFlags.Anonymous in objectFlags -> KtTypeUnion(mapAnonymousType(type, declaration))
                ObjectFlags.ClassOrInterface in objectFlags -> KtTypeUnion(mapInterfaceType(type.unsafeCast<InterfaceType>(), declaration))
                ObjectFlags.Reference in objectFlags -> KtTypeUnion(mapTypeReference(type.unsafeCast<TypeReference>(), declaration))

                else -> KtTypeUnion(KtType(ANY, isNullable = true))
            }
        }

        TypeFlags.Enum in flags -> KtTypeUnion(mapObjectType(type.unsafeCast<ObjectType>()))

        else -> KtTypeUnion(KtType(ANY, isNullable = true))
    }

    typesInMappingProcess -= type

    return mappedType
}

private fun ObjectTypeToKotlinTypeMapper.mapUnionType(type: UnionOrIntersectionType): KtTypeUnion {
    val notNullTypes = type.types.filter {
        TypeFlags.Undefined !in it.getFlags() &&
                TypeFlags.Null !in it.getFlags()
    }
    val nullable = notNullTypes.size != type.types.size || type.containsNull || type.containsUndefined

    val mappedTypes = notNullTypes.map { mapType(it, null) }
    return KtTypeUnion(when {
        !nullable -> mappedTypes.mergeToPreventCompilationConflicts()
        notNullTypes.size == 1 -> mappedTypes.map { it.copy(isNullable = true) }
        else -> (mappedTypes + KtType(NOTHING, isNullable = true)).distinct()
    })
}

/**
 * Normalize to a KtType such that equals will be true if the KotlinJS compiler would consider them
 * conflicting if both were the only parameter to identically named functions.
 */
private fun KtType.normalizeToDetectCompilationConflicts(): KtType {
    return copy(comment = null, typeArgs = typeArgs.map { it.normalizeToDetectCompilationConflicts() })
}

/**
 * Handle the case where a function is overloaded with the same Kotlin parameter types by merging them.
 * Comments are not taken into account for the comparison, but are preserved by concatenation using "|" since a "union".
 * This is especially useful for Typescript string literal unions.
 */
private fun List<KtType>.mergeToPreventCompilationConflicts(): List<KtType> {
    return groupBy { it.normalizeToDetectCompilationConflicts() }.map { entry ->
        val comments = entry.value.mapNotNull { it.comment }
        entry.key.copy(comment = if (comments.isEmpty()) null else comments.joinToString(" | "))
    }
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
    val mappedArgs = mapTypeArguments(type.typeArguments, declaration)

    if (ObjectFlags.Tuple in type.target.objectFlags) {
        return KtType(
                qualifiedName = DYNAMIC,
                comment = "JsTuple<" + mappedArgs.joinToString(", ") { it.stringify() } + ">"
        )
    }

    return mapObjectType(type.target).copy(typeArgs = mappedArgs.toList())
}

private fun ObjectTypeToKotlinTypeMapper.mapInterfaceType(type: InterfaceType, declaration: Node?): KtType {
    val mappedArgs = mapTypeArguments(type.typeParameters?.map { it }?.toTypedArray(), declaration)

    val mappedType = mapObjectType(type)

    if (mappedType.qualifiedName == KtQualifiedName("Function")) return mappedType

    return mappedType.copy(typeArgs = mappedArgs.toList())
}

private fun ObjectTypeToKotlinTypeMapper.mapTypeArguments(
        typeArguments: Array<Type>?, declaration: Node?
): Sequence<KtType> {
    val typeArgsFromDeclaration = if (declaration != null) {
        when (declaration.kind as Any) {
            SyntaxKind.ExpressionWithTypeArguments,
            SyntaxKind.TypeReference -> {
                declaration.unsafeCast<ExpressionWithTypeArguments>()
                        .typeArguments?.arr
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

    val typeArgsWithDeclarations =
            typeArguments.orEmpty()
                    .filter { if (TypeFlags.TypeParameter in it.flags) (it as TypeParameter).isThisType != true else true }
                    .asSequence()
                    .zip(typeArgsFromDeclaration + generateSequence { 0 }.map { null })
    return typeArgsWithDeclarations.map { (argType, arg) ->
        mapType(argType, arg)
    }
}

// TODO: is it correct name???
private fun ObjectTypeToKotlinTypeMapper.mapObjectType(type: Type): KtType {
    val fqn = buildFqn(type.getSymbol()!!)
    if (fqn == KtQualifiedName("Function")) return KtType(KtQualifiedName("Function"), typeArgs = listOf(starType()))
    return KtType(when (fqn) {
        KtQualifiedName("Object") -> ANY
        else -> {
            // TODO currentPackage should be KtName too
            if (currentPackage.isNotEmpty() && fqn.asString().startsWith(currentPackage + ".") &&
                    fqn.asString().indexOf('.', currentPackage.length + 1) < 0
            ) {
                fqn.asString().substring(currentPackage.length + 1).split(".").fold<String, KtQualifiedName?>(null) { p, s -> KtQualifiedName(s, p) }!!
            }
            else {
                fqn
            }
        }
    })
}

private fun ObjectTypeToKotlinTypeMapper.buildFqn(symbol: Symbol): KtQualifiedName {
    // TODO: make something better for the case when we have more than one declaration for this symbol.
    // For example see how it work for testData/typeAlias/typeParams.d.ts after renaming `MyHeaders` to `Headers`
    val declaration = symbol.declarations?.singleOrNull()
    return declaration?.let { buildFqn(it) } ?: KtQualifiedName(typeChecker.getFullyQualifiedName(symbol))
}

private fun ObjectTypeToKotlinTypeMapper.buildFqn(declaration: Node): KtQualifiedName? {
    val parent = declaration.getParentDeclaration()
    val parentSymbol = parent?.let { typeChecker.getSymbolResolvingAliases(it) }
    val parentName = when {
        parentSymbol != null -> buildFqn(parentSymbol)
        parent != null -> buildFqn(parent)
        else -> null
    }
    when (declaration.kind as Any) {
        SyntaxKind.InterfaceDeclaration,
        SyntaxKind.ClassDeclaration -> {
            return KtQualifiedName(declaration.unsafeCast<ClassOrInterfaceDeclaration>().identifierName!!.unescapedText, parentName)
        }
        SyntaxKind.ModuleDeclaration -> {
            val nameExpr = declaration.unsafeCast<ModuleDeclaration>().name.unsafeCast<Node>()
            val name = when (nameExpr.kind as Any) {
                /// TODO is it right to replace "/" with "."? If so, should we generate KtQulifiedName?
                SyntaxKind.StringLiteral -> nameExpr.unsafeCast<StringLiteral>().text.replace('/', '.')
                SyntaxKind.Identifier -> nameExpr.unsafeCast<Identifier>().unescapedText
                else -> "UNKNOWN"
            }
            return KtQualifiedName(name.sanitize(), parentName)
        }
    }
    return null
}

private fun Node.getParentDeclaration(): Declaration? = parent?.getEnclosingDeclaration()

private fun Node.getEnclosingDeclaration(): Declaration? = when (kind as Any) {
    SyntaxKind.ModuleBlock -> parent.unsafeCast<Declaration>().getEnclosingDeclaration()
    SyntaxKind.ClassDeclaration,
    SyntaxKind.InterfaceDeclaration,
    SyntaxKind.ModuleDeclaration -> unsafeCast<Declaration>()
    else -> null
}

private fun ObjectTypeToKotlinTypeMapper.mapAnonymousType(type: Type, declaration: Node?): KtType {
    val resolvedDeclaration =
            type.getSymbol()?.getDeclarations()?.singleOrNull() ?:
                    // TODO: foo(a: {}) -- symbol of type of `a` doesn't have declarations, is it bug in tsc?
                    declaration ?:
                    return KtType(ANY, isNullable = true)

    if (resolvedDeclaration.kind == SyntaxKind.TypeLiteral) {
        type.aliasSymbol?.let { aliasSymbol ->
            val typeArguments = mapTypeArguments(type.aliasTypeArguments, declaration).toList()
            return KtType(buildFqn(aliasSymbol), typeArguments)
        }
    }

    val parent = resolvedDeclaration.parent
    val (mapper, substitution) = if (parent?.kind == SyntaxKind.TypeAliasDeclaration) {
        val typeParameters = parent.unsafeCast<TypeAliasDeclaration>().typeParameters
        val substitution = typeParameters?.arr.orEmpty()
                .map { it.name.text }
                .zip(type.aliasTypeArguments.orEmpty().map { mapType(it, null) })
                .toMap()
        Pair(withTypeParameters(typeParameters), substitution)
    }
    else {
        Pair(this, emptyMap())
    }

    val kotlinType = when (resolvedDeclaration.kind as Any) {
        SyntaxKind.FunctionType -> resolvedDeclaration.unsafeCast<SignatureDeclaration>().toKotlinType(mapper)
        SyntaxKind.TypeLiteral -> mapper.getKotlinTypeForObjectType(resolvedDeclaration.unsafeCast<TypeLiteralNode>())
        else -> KtType(ANY, isNullable = true)
    }

    return if (substitution.isNotEmpty()) kotlinType.replaceTypeParameters(substitution) else kotlinType
}

fun KtType.replaceTypeParameters(substitution: kotlin.collections.Map<String, KtType>): KtType =
        if (typeArgs.isEmpty() && callSignature == null) {
            substitution[qualifiedName.asString()] ?: this
        }
        else {
            copy(
                    typeArgs = typeArgs.map { it.replaceTypeParameters(substitution) },
                    callSignature = callSignature?.replaceTypeParameters(substitution)
            )
        }

private fun KtCallSignature.replaceTypeParameters(substitution: Map<String, KtType>): KtCallSignature =
        copy(
                params = params.map { it.replaceTypeParameters(substitution) },
                returnType = returnType.replaceTypeParameters(substitution)
        )

private fun KtFunParam.replaceTypeParameters(substitution: Map<String, KtType>): KtFunParam =
        copy(
                type = type.replaceTypeParameters(substitution)
        )

private fun KtTypeAnnotation.replaceTypeParameters(substitution: Map<String, KtType>): KtTypeAnnotation =
        copy(
                type = type.replaceTypeParameters(substitution)
        )