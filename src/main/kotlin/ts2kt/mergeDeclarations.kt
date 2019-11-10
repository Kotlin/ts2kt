package ts2kt

import converter.KtPackagePartBuilder
import ts2kt.kotlin.ast.*
import ts2kt.utils.assert
import ts2kt.utils.merge
import ts2kt.utils.report

fun List<KtPackagePart>.merge(): List<KtPackagePart> =
        groupBy { it.fqName }
                .map { (_, parts) ->
                    val fqName = parts.first().fqName
                    val members = parts.flatMap { it.members }
                    val annotations = parts.flatMap { it.annotations }.distinct()

                    val mergedMembers = members.mergeDeclarationsWithSameNameIfNeed()
                    KtPackagePart(fqName, mergedMembers, mergeAnnotations(annotations))
                }


private fun List<KtMember>.mergeDeclarationsWithSameNameIfNeed() =
        merge({ it !is KtFunction }, COMPARE_BY_NAME) { a, b ->
            val result =
                    when (a) {
                        is KtClassifier ->
                            when (b) {
                                is KtClassifier -> mergeClassifiers(a, b)
                                is KtVariable -> mergeClassifierAndVariable(a, b)
                                else -> {
                                    report("Merging ${a.kind} and ??? unsupported yet, a: ${a.stringify()}, b: ${b.stringify()}")
                                    null
                                }
                            }

                        is KtVariable ->
                            when (b) {
                                is KtClassifier -> mergeClassifierAndVariable(b, a)
                                else -> {
                                    report("Merging Variable and ??? unsupported yet, a: ${a.stringify()}, b: ${b.stringify()}")
                                    null
                                }
                            }

                        else -> {
                            report("Unsupported types for merging, a: ${a.stringify()}, b: ${b.stringify()}")
                            null
                        }
                    }


            result?.also {
                it.annotations = mergeAnnotations(a.annotations, b.annotations)
            }
        }

private fun mergeClassifiers(a: KtClassifier, b: KtClassifier): KtClassifier? {
    when (a.kind) {
        KtClassKind.CLASS -> {
            when(b.kind) {
                KtClassKind.OBJECT -> return mergeClassAndObject(a, b)
                KtClassKind.INTERFACE -> return mergeClassAndInterface(a, b)
            }
        }
        KtClassKind.INTERFACE -> {
            when (b.kind) {
                KtClassKind.OBJECT -> return mergeClassAndObject(a, b)
                KtClassKind.INTERFACE -> return mergeClassifierMembers(a, b)
                KtClassKind.CLASS -> return mergeClassAndInterface(b, a)
            }
        }
        KtClassKind.OBJECT -> {
            if (b.kind === KtClassKind.CLASS || b.kind === KtClassKind.INTERFACE) return mergeClassAndObject(b, a)
            if (a.hasModuleAnnotation() && b.isModule()) return mergeClassifierMembers(a, b)
        }
        else -> {} // TODO is it bug?
    }

    report("Merging ${a.kind} and ${b.kind} unsupported yet, a: ${a.stringify()}, b: ${b.stringify()}")

    return null
}

private fun mergeClassAndInterface(klass: KtClassifier, iface: KtClassifier): KtClassifier? {
    if (klass.typeParams != iface.typeParams) {
        report("Can't merge classifiers with different type parameters -- klass: ${klass.stringify()}, iface: ${iface.stringify()}")
        return null
    }

    val result =
            KtClassifier(
                    KtClassKind.CLASS,
                    klass.name,
                    klass.paramsOfConstructors,
                    klass.typeParams,
                    (klass.parents + iface.parents).distinct(),
                    mutableListOf(),
                    mutableListOf() /*annotations will be merged later*/,
                    klass.hasOpenModifier /* TODO: should it be open? */,
                    klass.isAbstract
            )

    return mergeClassifierMembers(result, klass, iface)
}

private fun mergeClassifierAndVariable(a: KtClassifier, b: KtVariable): KtMember? {
    // TODO is it right?
    assert(a.getClassObject() == null, "Unxpected `class object` when merge Classifier(kind=${a.kind}) and Variable(${b.stringify()})")

    if (a.kind === KtClassKind.INTERFACE || a.isModule()) {
        val newTrait = KtClassifier(KtClassKind.INTERFACE, a.name, a.paramsOfConstructors, a.typeParams, a.parents, a.members, a.annotations, hasOpenModifier = false, isAbstract = false)

        val delegation = listOf(KtHeritageType(b.type.type, byExpression = NO_IMPL))

        // TODO drop hacks
        val classObject = KtClassifier(KtClassKind.COMPANION_OBJECT, KtName.NO_NAME, listOf(), listOf(), delegation, listOf(), listOf(), hasOpenModifier = false, isAbstract = false)

        newTrait.addMember(classObject)

        return newTrait
    }

    report("Merging non-empty Classifier(kind=${a.kind}) and Variable unsupported yet, a: ${a.stringify()}, b: ${b.stringify()}")
    return null
}

private fun mergeAnnotations(a: List<KtAnnotation>, b: List<KtAnnotation>): List<KtAnnotation> =
        when {
            a.isEmpty() -> b
            b.isEmpty() -> a
            else -> mergeAnnotations(a + b)
        }

private fun mergeAnnotations(annotations: List<KtAnnotation>): List<KtAnnotation> =
        annotations.merge({ true }, COMPARE_BY_NAME) { a, b ->
            when {
                a.parameters.isEmpty() -> b
                b.parameters.isEmpty() -> a
                a.parameters == b.parameters -> a
                else -> {
                    report("Merging annotations with different arguments unsupported yet, a: ${a.stringify()}, b: ${b.stringify()}")
                    null
                }
            }
        }

private fun mergeClassAndObject(a: KtClassifier, b: KtClassifier): KtClassifier {
    val classObject = a.getClassObject()

    if (classObject == null) {
        // TODO drop hack
        a.addMember(KtClassifier(KtClassKind.COMPANION_OBJECT, KtName.NO_NAME, listOf(), listOf(), listOf(), b.members, NO_ANNOTATIONS, hasOpenModifier = false, isAbstract = false))
    }
    else {
        // TODO drop hack
        classObject.addMembersFrom(b)
    }

    return a
}

private fun mergeClassifierMembers(a: KtClassifier, vararg other: KtClassifier): KtClassifier {
    for (b in other){
        // TODO drop hack
        a.addMembersFrom(b)
    }
    return a
}

private fun KtClassifier.addMembersFrom(another: KtClassifier) {
    val members = members as MutableList
    members.addAll(another.members)
    members.mergeDeclarationsWithSameNameIfNeed()
}

private fun KtClassifier.addMember(member: KtMember) {
    (members as MutableList).add(member)
}

fun KtPackagePartBuilder.mergeClassesAndPackages() {
    val classesByName = members.filterIsInstance<KtClassifier>()
            .filter { it.kind == KtClassKind.CLASS || it.kind == KtClassKind.INTERFACE }
            .associateBy { it.name }

    for (nestedPackage in nestedPackages) {
        if (nestedPackage.nestedPackages.isNotEmpty()) continue

        val classToMerge = classesByName[KtName(nestedPackage.ownName)] ?: continue
        var companion = classToMerge.members
                .filterIsInstance<KtClassifier>()
                .singleOrNull { it.kind == KtClassKind.COMPANION_OBJECT }
        val companionFound = companion != null
        if (companion == null) {
            companion = KtClassifier(
                    KtClassKind.COMPANION_OBJECT, KtName.NO_NAME, emptyList(), null, emptyList(),
                    emptyList(), emptyList(), false, isAbstract = false)
        }

        val (classifiers, nonClassifiers) = nestedPackage.members.partition { it is KtClassifier }
        companion.members = companion.members + nonClassifiers
        classToMerge.members = classToMerge.members + classifiers

        if (!companionFound && companion.members.isNotEmpty()) {
            classToMerge.members += companion
        }

        nestedPackage.members.clear()
    }
}