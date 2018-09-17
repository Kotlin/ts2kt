package stringValues

external interface MapGenerator {
    fun generate(scope: String /* "city" | "state" | "country" | "world" */)
}
