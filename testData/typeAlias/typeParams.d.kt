package typeParams

@native
var fooMap: Map<String, List<Number>> = noImpl
@native
fun mapKey(a: Map<Number, List<String>>): Unit = noImpl
@native
var fooStringOrMap: dynamic /* String | Map<String, List<Number>> */ = noImpl
@native
fun stringOrMapKey(a: String): Unit = noImpl
@native
fun stringOrMapKey(a: Map<Number, List<String>>): Unit = noImpl
@native
var listOfStringOrNumber: dynamic /* String | List<dynamic /* String | Number */> */ = noImpl
@native
fun listOfNumberOrString(a: List<dynamic /* Number | String */>): Unit = noImpl
@native
var headers: Map<String, List<String>> = noImpl
@native
fun getHeaders(): Map<String, List<String>> = noImpl
@native
fun addHeaders(headers: Map<String, List<String>>): Unit = noImpl
@native
var someRef: dynamic /* String | (instance: T) -> Any */ = noImpl
@native
fun addRef(ref: String): Unit = noImpl
@native
fun addRef(ref: (instance: T) -> Any): Unit = noImpl
