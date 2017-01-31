package typeParams

external var fooMap: Map<String, List<Number>> = noImpl
external fun mapKey(a: Map<Number, List<String>>): Unit = noImpl
external var fooStringOrMap: dynamic /* String | Map<String, List<Number>> */ = noImpl
external fun stringOrMapKey(a: String): Unit = noImpl
external fun stringOrMapKey(a: Map<Number, List<String>>): Unit = noImpl
external var listOfStringOrNumber: dynamic /* String | List<dynamic /* String | Number */> */ = noImpl
external fun listOfNumberOrString(a: List<dynamic /* Number | String */>): Unit = noImpl
external var headers: Map<String, List<String>> = noImpl
external fun getHeaders(): Map<String, List<String>> = noImpl
external fun addHeaders(headers: Map<String, List<String>>): Unit = noImpl
external var someRef: dynamic /* String | (instance: T) -> Any */ = noImpl
external fun addRef(ref: String): Unit = noImpl
external fun addRef(ref: (instance: T) -> Any): Unit = noImpl
