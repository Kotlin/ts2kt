package ts2kt

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
            if (b.kind === KtClassKind.OBJECT) return mergeClassAndObject(a, b)
        }
        KtClassKind.INTERFACE -> {
            if (b.kind === KtClassKind.OBJECT) return mergeClassAndObject(a, b)
            if (b.kind === KtClassKind.INTERFACE) return mergeClassifierMembers(a, b)
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

private fun mergeClassifierAndVariable(a: KtClassifier, b: KtVariable): KtMember? {
    if (a.members.isEmpty()) return b

    // TODO is it right?
    assert(a.getClassObject() == null, "Unxpected `class object` when merge Classifier(kind=${a.kind}) and Variable(${b.stringify()})")

    if (a.kind === KtClassKind.INTERFACE || a.isModule()) {
        val newTrait = KtClassifier(KtClassKind.INTERFACE, a.name, a.paramsOfConstructors, a.typeParams, a.parents, a.members, a.annotations, hasOpenModifier = false)

        val varTypeName = b.type.type.stringify()
        val delegation = listOf(KtHeritageType("${varTypeName} by ${NO_IMPL}: ${varTypeName}"))

        // TODO drop hacks
        val classObject = KtClassifier(KtClassKind.COMPANION_OBJECT, "", listOf(), listOf(), delegation, listOf(), listOf(), hasOpenModifier = false)

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
        a.addMember(KtClassifier(KtClassKind.COMPANION_OBJECT, "", listOf(), listOf(), listOf(), b.members, NO_ANNOTATIONS, hasOpenModifier = false))
    }
    else {
        // TODO drop hack
        classObject.addMembersFrom(b)
    }

    return a
}

private fun mergeClassifierMembers(a: KtClassifier, b: KtClassifier): KtClassifier {
    // TODO drop hack
    a.addMembersFrom(b)
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
