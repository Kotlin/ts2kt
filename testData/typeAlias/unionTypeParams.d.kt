package unionTypeParams

@native
var aliasUnionVar: dynamic /* List<Number> | Map<String, List<Number>> */ = noImpl
@native
fun aliasUnionFunction(a: List<String>): Unit = noImpl
@native
fun aliasUnionFunction(a: Map<Number, List<String>>): Unit = noImpl
@native
var listOfUnionVar: List<dynamic /* String | Number */> = noImpl
@native
fun listOfUnionFunction(a: List<dynamic /* Number | String */>): Unit = noImpl
