package exportedByDefault

@module
object Boo {
    fun foo(): String = noImpl
    var bar: Number = noImpl
    interface IBaz {
        fun doSomething()
    }
    open class Klass {
        open fun method(s: Any): String = noImpl
    }
}
