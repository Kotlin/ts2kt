package ts2kt

import ts2kt.kotlin.ast.*

fun List<KtPackagePart>.withMissedOverloads(): List<KtPackagePart> = this.map { it.withMissedOverloads() }

private fun <T : KtWithMembers> T.withMissedOverloads(): T {
    members.map {
        if (it is KtWithMembers) {
            it.withMissedOverloads() as KtMember
        }
        else {
            it
        }
    }
    members = members.withMissedOverloads()

    return this
}

private fun List<KtMember>.withMissedOverloads(): List<KtMember> {
    fun List<KtFunParam>.hasDefaultParameters() = any { it.defaultValue != null }

    fun KtFunction.hasDefaultParameters() = callSignature.params.hasDefaultParameters()

    fun KtFunction.possibleSignatures(): List<List<KtFunParam>> {
        val params = callSignature.params
        val first = params.indexOfFirst { it.defaultValue != null }

        if (first < 0) return emptyList()

        val count = params.subList(first, params.size).indexOfFirst { it.defaultValue == null }
        val last = if (count < 0) params.size else -1

        val r = (first..last).map { params.subList(0, it).toList() }

        return r
    }

    val (withDefaultParams, withoutDefaultParams) = filterIsInstance<KtFunction>()
            .groupBy { it.copy(callSignature = it.callSignature.copy(params = listOf())) }
            .toList()
            .partition {
                it.second.count { it.hasDefaultParameters() } > 1
            }

    val m = withoutDefaultParams.toMap().mapValues { it.value.map { it.callSignature.params } }

    val newFunctions = mutableListOf<KtFunction>()

    withDefaultParams.forEach { a ->
        a.second.flatMap { it.possibleSignatures() }
                .filterNot { it.hasDefaultParameters() }
                .groupBy { it }
                .filter { it.value.size > 1 }
                .map { it.value.first() }
                .distinct()
                .forEach {
                    if (m[a.first]?.contains(it) != true) {
                        newFunctions.add(a.first.copy(callSignature = a.first.callSignature.copy(params = it)))
                    }
                }
    }

    return this + newFunctions
}
