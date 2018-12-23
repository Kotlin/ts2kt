package converter

import ts2kt.*
import ts2kt.kotlin.ast.*
import ts2kt.utils.DiagnosticLevel
import ts2kt.utils.report
import typescriptServices.ts.*
import kotlin.collections.Map

fun ObjectTypeToKotlinTypeMapper.mapType(type: Node): KtType {
    return mapToEnhancedType(type).singleType
}

fun ObjectTypeToKotlinTypeMapper.mapToEnhancedType(type: Node): EnhancedKtType {
    val resolvedType: Type? = typeChecker.getTypeAtLocation(type)
    return if (resolvedType != null) {
        mapToEnhancedType(resolvedType, type)
    }
    else {
        (type.unsafeCast<TypeNode>()).toEnhancedType(this)
    }
}

private fun ObjectTypeToKotlinTypeMapper.mapType(type: Type, declaration: Node?): KtType =
        mapToEnhancedType(type, declaration).singleType

private fun ObjectTypeToKotlinTypeMapper.mapToEnhancedType(type: Type, declaration: Node?): EnhancedKtType {
    val resultingDeclaration = declaration ?: type.symbol?.declarations?.singleOrNull()

    val flags = type.getFlags()
    if (resultingDeclaration != null && type.symbol == null && TypeFlags.Any in flags) {
        return resultingDeclaration.unsafeCast<TypeNode>().toEnhancedType(this)
    }

    if (resultingDeclaration?.kind == SyntaxKind.UnionType) {
        return resultingDeclaration.unsafeCast<UnionTypeNode>().toEnhancedType(this)
    }

    if (TypeFlags.Union in flags) {
        return mapUnionType(type.unsafeCast<UnionType>())
    }

    if (type in typesInMappingProcess) {
        report(
                "Recursion is detected when resolve type: \"${type.symbol?.name}\" for the declaration at ${declaration?.location()}",
                maxLevelToShow = DiagnosticLevel.WARNING_WITH_STACKTRACE
        )
        return SingleKtType(KtType(DYNAMIC))
    }

    typesInMappingProcess += type

    val mappedType = when {
        declaration?.kind == SyntaxKind.ThisType -> mapToEnhancedType(type.unsafeCast<TypeParameter>().constraint!!, null).withComment("this")

        TypeFlags.Any in flags -> SingleKtType(KtType(ANY))
        TypeFlags.String in flags -> SingleKtType(KtType(STRING))
        TypeFlags.Boolean in flags -> SingleKtType(KtType(BOOLEAN))
        TypeFlags.Number in flags -> SingleKtType(KtType(NUMBER))
        TypeFlags.Void in flags -> SingleKtType(KtType(UNIT))

        TypeFlags.Undefined in flags ||
                TypeFlags.Null in flags -> SingleKtType(KtType(NOTHING, isNullable = true))

        TypeFlags.StringLiteral in flags -> {
            SingleKtType(KtType(STRING, comment = "\"" + type.unsafeCast<LiteralType>().value + "\""))
        }
        // TODO: add test if it's allowed
        TypeFlags.NumberLiteral in flags -> {
            SingleKtType(KtType(NUMBER, comment = type.unsafeCast<LiteralType>().value))
        }
        // TODO: add test if it's allowed
        TypeFlags.BooleanLiteral in flags -> {
            SingleKtType(KtType(BOOLEAN, comment = type.unsafeCast<LiteralType>().value))
        }

        TypeFlags.Intersection in flags -> mapIntersectionType(type.unsafeCast<IntersectionType>())

        TypeFlags.TypeParameter in flags -> SingleKtType(KtType(KtQualifiedName(unescapeIdentifier(type.getSymbol()!!.name))))

        TypeFlags.Object in flags -> {
            val objectFlags = (type as ObjectType).objectFlags
            when {
                ObjectFlags.Anonymous in objectFlags -> SingleKtType(mapAnonymousType(type, declaration))
                ObjectFlags.ClassOrInterface in objectFlags -> SingleKtType(mapInterfaceType(type.unsafeCast<InterfaceType>(), declaration))
                ObjectFlags.Reference in objectFlags -> SingleKtType(mapTypeReference(type.unsafeCast<TypeReference>(), declaration))

                else -> SingleKtType(KtType(ANY, isNullable = true))
            }
        }

        TypeFlags.Enum in flags -> SingleKtType(mapObjectType(type.unsafeCast<ObjectType>()))

        else -> SingleKtType(KtType(ANY, isNullable = true))
    }

    typesInMappingProcess -= type

    return mappedType
}

private fun ObjectTypeToKotlinTypeMapper.mapUnionType(type: UnionType): EnhancedKtType {
    val forceNullable = type.containsNull || type.containsUndefined
    return mapUnionType(type.types.map { mapToEnhancedType(it, null) }).forceNullable(forceNullable)
}

/**
 * Normalize to a KtTypeUnion such that equals will be true if the KotlinJS compiler would consider them
 * conflicting if both were the only parameter to identically named functions.
 */
private fun EnhancedKtType.normalizeToDetectCompilationConflicts(): EnhancedKtType {
    return when (this) {
        is KtTypeUnion -> copy(possibleTypes = possibleTypes.map { it.normalizeToDetectCompilationConflicts() })
        is KtTypeIntersection -> copy(requiredTypes = requiredTypes.map { it.normalizeToDetectCompilationConflicts() })
        is SingleKtType -> copy(singleType = singleType.normalizeToDetectCompilationConflicts())
    }
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
fun List<EnhancedKtType>.mergeToPreventCompilationConflicts(): List<EnhancedKtType> {
    return groupBy { it.normalizeToDetectCompilationConflicts() }.map { entry ->
        val comments = entry.value.mapNotNull { it.comment }
        entry.key.withComment(comment = if (comments.isEmpty()) null else comments.joinToString(" | "))
    }
}

/**
 * Handle the case where a function is overloaded with the same Kotlin parameter types by merging them.
 * Comments are not taken into account for the comparison, but are preserved by concatenation using "|" since a "union".
 * This is especially useful for Typescript string literal unions.
 */
fun List<KtType>.mergeToPreventCompilationConflicts(): List<KtType> {
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

private fun ObjectTypeToKotlinTypeMapper.mapIntersectionType(type: IntersectionType): EnhancedKtType {
    return KtTypeIntersection(type.types.map { SingleKtType(mapType(it, null)) })
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
): Sequence<EnhancedKtType> {
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
        mapToEnhancedType(argType, arg)
    }
}

// TODO: is it correct name???
private fun ObjectTypeToKotlinTypeMapper.mapObjectType(type: Type): KtType {
    val fqn = buildFqn(type.getSymbol()!!)
    if (fqn == KtQualifiedName("Function")) return KtType(KtQualifiedName("Function"), typeArgs = listOf(SingleKtType(starType())))
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

fun EnhancedKtType.replaceTypeParameters(substitution: kotlin.collections.Map<String, KtType>): EnhancedKtType {
    return when (this) {
        is KtTypeUnion -> this.copy(possibleTypes = this.possibleTypes.map { it.replaceTypeParameters(substitution) })
        is KtTypeIntersection -> this.copy(requiredTypes = this.requiredTypes.map { it.replaceTypeParameters(substitution) })
        is SingleKtType -> copy(singleType = singleType.replaceTypeParameters(substitution))
    }
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