package typescript

@native
val ts: dynamic

@native
fun <E : Enum<E>> TS.hasFlag(flags: Enum<E>, flag: E): Boolean = noImpl

@native
fun TS.unescapeIdentifier(identifier: String): String = noImpl
