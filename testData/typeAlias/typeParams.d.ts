interface Printable
interface Readable
interface Map<K, V> {
}
interface List<T> {
}

type Values<V> = List<V>;
type MultiMap<K,V> = Map<K,Values<V>>;
type MyHeaders = MultiMap<String,String>
type Ref<T> = string | ((instance: T) => any);

declare var fooMap: MultiMap<string,number>;

declare function mapKey(a: MultiMap<number,String>);

declare var fooStringOrMap: string | MultiMap<string,number>;

declare function stringOrMapKey(a: string | MultiMap<number,String>);

declare var listOfStringOrNumber: string | List<string | number>;

declare var listOfPrintableAndReadable: string | List<Printable & Readable>;

declare var listOfNullablePrintableAndReadable: List<null | (Printable & Readable)>;

declare var listOfNullableString: List<string | null>;

declare var listOfNullableStringOrNumber: List<null | string | number>;

declare function mapNullableStringOrNumber<T extends string | number | null>(item: T): T;

declare function listOfNumberOrString(a: List<number | String>);

declare function normalizeListOfNullableNumberOrString(a: List<null | number | String>): List<null | number | String>;

declare function normalizeListOfNullableNumberAndString(a: List<null | (number & String)>): List<null | (number & String)>;

declare var headers: MyHeaders;

declare function getHeaders(): MyHeaders;

declare function addHeaders(headers: MyHeaders);

declare var someRef: Ref<number>;

declare function addRef(ref: Ref<number>);
