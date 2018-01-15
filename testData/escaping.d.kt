package escaping

external var `val`: Any = definedExternally
external var `$foo`: Boolean = definedExternally
external fun `bar$`(`ba$z`: Number): Unit = definedExternally
external fun `fun`(): Unit = definedExternally
external interface This {
    var `when`: String
    var `typealias`: Number
    var `typeof`: Number
    fun `in`(`object`: Foo)
    companion object {
        var `$foo`: Boolean = definedExternally
        fun `bar$`(`ba$z`: Number): Unit = definedExternally
    }
}
external open class `is`<`interface`> {
    open var `as`: Number = definedExternally
    open fun `package`(a: Any): Boolean = definedExternally
}

// ------------------------------------------------------------------------------------------
@file:JsQualifier("when")
package escaping.`when`

external var `$`: Boolean = definedExternally
external fun `package`(`as`: Number): `$tring` = definedExternally
