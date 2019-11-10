package typeParams

external interface Printable
external interface Readable
external interface Map<K, V>
external interface List<T>
external var fooMap: Map<String, List<Number>> = definedExternally
external fun mapKey(a: Map<Number, List<String>>): Unit = definedExternally
external var fooStringOrMap: dynamic /* String | Map<String, List<Number>> */ = definedExternally
external fun stringOrMapKey(a: String): Unit = definedExternally
external fun stringOrMapKey(a: Map<Number, List<String>>): Unit = definedExternally
external var listOfStringOrNumber: dynamic /* String | List<String | Number> */ = definedExternally
external var listOfPrintableAndReadable: dynamic /* String | List<Printable & Readable> */ = definedExternally
external var listOfNullablePrintableAndReadable: List<Printable? /* (Printable & Readable)? */> = definedExternally
external var listOfNullableString: List<String?> = definedExternally
external var listOfNullableStringOrNumber: List<dynamic /* String? | Number? */> = definedExternally
external fun <T : dynamic /* String? | Number? */> mapNullableStringOrNumber(item: T): T = definedExternally
external fun listOfNumberOrString(a: List<dynamic /* Number | String */>): Unit = definedExternally
external fun normalizeListOfNullableNumberOrString(a: List<dynamic /* Number? | String? */>): List<dynamic /* Number? | String? */> = definedExternally
external fun normalizeListOfNullableNumberAndString(a: List<Number? /* (Number & String)? */>): List<Number? /* (Number & String)? */> = definedExternally
external var headers: Map<String, List<String>> = definedExternally
external fun getHeaders(): Map<String, List<String>> = definedExternally
external fun addHeaders(headers: Map<String, List<String>>): Unit = definedExternally
external var someRef: dynamic /* String | (instance: T) -> Any */ = definedExternally
external fun addRef(ref: String): Unit = definedExternally
external fun addRef(ref: (instance: T) -> Any): Unit = definedExternally
