package inInterface

@native
interface MyInterface {
    var self: MyInterface /* this */
    fun that(): MyInterface /* this */
}
