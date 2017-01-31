package unionTypeParams

external var aliasUnionVar: dynamic /* List<Number> | Map<String, List<Number>> */ = noImpl
external fun aliasUnionFunction(a: List<String>): Unit = noImpl
external fun aliasUnionFunction(a: Map<Number, List<String>>): Unit = noImpl
external var listOfUnionVar: List<dynamic /* String | Number */> = noImpl
external fun listOfUnionFunction(a: List<dynamic /* Number | String */>): Unit = noImpl
