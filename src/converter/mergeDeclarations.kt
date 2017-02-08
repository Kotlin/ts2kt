package ts2kt

import ts2kt.kotlin.ast.*
import ts2kt.utils.assert
import ts2kt.utils.merge

fun List<PackagePart>.merge(): List<PackagePart> =
        groupBy { it.fqName }
                .map { (_, parts) ->
                    val fqName = parts.first().fqName
                    val members = parts.flatMap { it.members }
                    val annotations = parts.flatMap { it.annotations }.distinct()

                    PackagePart(fqName, members, annotations)
                }


fun MutableList<Member>.mergeDeclarationsWithSameNameIfNeed() {
    this.merge({ it !is Function }, COMPARE_BY_NAME) { a, b ->
        val result =
                when (a) {
                    is Classifier ->
                        when (b) {
                            is Classifier -> mergeClassifiers(a, b)
                            is Variable -> mergeClassifierAndVariable(a, b)
                            else -> throw IllegalStateException("Merging ${a.kind} and ??? unsupported yet, a: $a, b: $b")
                        }

                    is Variable ->
                        when (b) {
                            is Classifier -> mergeClassifierAndVariable(b, a)
                            else -> throw IllegalStateException("Merging Variable and ??? unsupported yet, a: $a, b: $b")
                        }

                    else ->
                        throw IllegalStateException("Unsupported types for merging, a: $a, b: $b")
                }


        result.annotations = mergeAnnotations(a.annotations, b.annotations)

        result
    }
}

private fun mergeClassifiers(a: Classifier, b: Classifier): Classifier {
    when (a.kind) {
        ClassKind.CLASS -> {
            if (b.kind === ClassKind.OBJECT) return mergeClassAndObject(a, b)
        }
        ClassKind.INTERFACE -> {
            if (b.kind === ClassKind.OBJECT) return mergeClassAndObject(a, b)
            if (b.kind === ClassKind.INTERFACE) return mergeClassifierMembers(a, b)
        }
        ClassKind.OBJECT -> {
            if (b.kind === ClassKind.CLASS || b.kind === ClassKind.INTERFACE) return mergeClassAndObject(b, a)
            if (a.hasModuleAnnotation() && b.isModule()) return mergeClassifierMembers(a, b)
        }
        else -> {} // TODO is it bug?
    }

    throw IllegalStateException("Merging ${a.kind} and ${b.kind} unsupported yet, a: $a, b: $b")
}

private fun mergeClassifierAndVariable(a: Classifier, b: Variable): Member {
    if (a.members.isEmpty()) return b

    // TODO is it right?
    assert(a.getClassObject() == null, "Unxpected `class object` when merge Classifier(kind=${a.kind}) and Variable($b)")

    if (a.kind === ClassKind.INTERFACE || a.isModule()) {
        val newTrait = Classifier(ClassKind.INTERFACE, a.name, a.paramsOfConstructors, a.typeParams, a.parents, a.members, a.annotations, hasOpenModifier = false)

        val varTypeName = b.type.type.stringify()
        val delegation = listOf(HeritageType("${varTypeName} by ${NO_IMPL}: ${varTypeName}"))

        // TODO drop hacks
        val classObject = Classifier(ClassKind.COMPANION_OBJECT, "", listOf(), listOf(), delegation, listOf(), listOf(), hasOpenModifier = false)

        newTrait.addMember(classObject)

        return newTrait
    }

    throw IllegalStateException("Merging non-empty Classifier(kind=${a.kind}) and Variable unsupported yet, a: $a, b: $b")
}

private fun mergeAnnotations(a: List<Annotation>, b: List<Annotation>): List<Annotation> =
        if (a.isEmpty()) {
            b
        }
        else if (b.isEmpty()) {
            a
        }
        else {
            val merged = arrayListOf<Annotation>()
            merged.addAll(a)
            merged.addAll(b)

            merged.merge({ true }, COMPARE_BY_NAME) { a, b ->
                when {
                    a.parameters.isEmpty() -> b
                    b.parameters.isEmpty() -> a
                    a.parameters == b.parameters -> a
                // TODO
                    else -> throw IllegalStateException("Merging annotations with different arguments unsupported yet, a: $a, b: $b")
                }
            }

            merged
        }

private fun mergeClassAndObject(a: Classifier, b: Classifier): Classifier {
    val classObject = a.getClassObject()

    if (classObject == null) {
        // TODO drop hack
        a.addMember(Classifier(ClassKind.COMPANION_OBJECT, "", listOf(), listOf(), listOf(), b.members, NO_ANNOTATIONS, hasOpenModifier = false))
    }
    else {
        // TODO drop hack
        classObject.addMembersFrom(b)
    }

    return a
}

private fun mergeClassifierMembers(a: Classifier, b: Classifier): Classifier {
    // TODO drop hack
    a.addMembersFrom(b)
    return a
}

private fun Classifier.addMembersFrom(another: Classifier) {
    val members = members as MutableList
    members.addAll(another.members)
    members.mergeDeclarationsWithSameNameIfNeed()
}

private fun Classifier.addMember(member: Member) {
    (members as MutableList).add(member)
}
