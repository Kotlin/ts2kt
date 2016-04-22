package async

@native
interface Dictionary<T> {
    @nativeGetter
    fun get(key: String): T
    @nativeSetter
    fun set(key: String, value: T)
}
@native
interface ErrorCallback {
    @nativeInvoke
    fun invoke(err: Error? = null)
}
@native
interface AsyncResultCallback<T> {
    @nativeInvoke
    fun invoke(err: Error, result: T)
}
@native
interface AsyncResultArrayCallback<T> {
    @nativeInvoke
    fun invoke(err: Error, results: Array<T>)
}
@native
interface AsyncResultObjectCallback<T> {
    @nativeInvoke
    fun invoke(err: Error, results: Dictionary<T>)
}
@native
interface AsyncFunction<T> {
    @nativeInvoke
    fun invoke(callback: (err: Error? = null, result: T? = null) -> Unit)
}
@native
interface AsyncIterator<T> {
    @nativeInvoke
    fun invoke(item: T, callback: ErrorCallback)
}
@native
interface AsyncForEachOfIterator<T> {
    @nativeInvoke
    fun invoke(item: T, key: Number, callback: ErrorCallback)
}
@native
interface AsyncResultIterator<T, R> {
    @nativeInvoke
    fun invoke(item: T, callback: AsyncResultCallback<R>)
}
@native
interface AsyncMemoIterator<T, R> {
    @nativeInvoke
    fun invoke(memo: R, item: T, callback: AsyncResultCallback<R>)
}
@native
interface AsyncBooleanIterator<T> {
    @nativeInvoke
    fun invoke(item: T, callback: (truthValue: Boolean) -> Unit)
}
@native
interface AsyncWorker<T> {
    @nativeInvoke
    fun invoke(task: T, callback: ErrorCallback)
}
@native
interface AsyncVoidFunction {
    @nativeInvoke
    fun invoke(callback: ErrorCallback)
}
@native
interface AsyncQueue<T> {
    fun length(): Number
    var started: Boolean
    fun running(): Number
    fun idle(): Boolean
    var concurrency: Number
    fun push(task: T, callback: ErrorCallback? = null)
    fun push(task: Array<T>, callback: ErrorCallback? = null)
    fun unshift(task: T, callback: ErrorCallback? = null)
    fun unshift(task: Array<T>, callback: ErrorCallback? = null)
    var saturated: () -> Any
    var empty: () -> Any
    var drain: () -> Any
    var paused: Boolean
    fun pause()
    fun resume()
    fun kill()
}
@native
interface AsyncPriorityQueue<T> {
    fun length(): Number
    var concurrency: Number
    var started: Boolean
    var paused: Boolean
    fun push(task: T, priority: Number, callback: AsyncResultArrayCallback<T>? = null)
    fun push(task: Array<T>, priority: Number, callback: AsyncResultArrayCallback<T>? = null)
    var saturated: () -> Any
    var empty: () -> Any
    var drain: () -> Any
    fun running(): Number
    fun idle(): Boolean
    fun pause()
    fun resume()
    fun kill()
}
@native
interface AsyncCargo {
    fun length(): Number
    var payload: Number
    fun push(task: Any, callback: Function? = null)
    fun push(task: Array<Any>, callback: Function? = null)
    fun saturated()
    fun empty()
    fun drain()
    fun idle(): Boolean
    fun pause()
    fun resume()
    fun kill()
}
@native
interface `T$0` {
    var times: Number
    var interval: Number
}
@native
interface Async {
    fun <T> each(arr: Array<T>, iterator: AsyncIterator<T>, callback: ErrorCallback? = null)
    fun <T> eachSeries(arr: Array<T>, iterator: AsyncIterator<T>, callback: ErrorCallback? = null)
    fun <T> eachLimit(arr: Array<T>, limit: Number, iterator: AsyncIterator<T>, callback: ErrorCallback? = null)
    fun forEachOf(obj: Any, iterator: (item: Any, key: dynamic /* String | Number */, callback: ErrorCallback? = null) -> Unit, callback: ErrorCallback)
    fun <T> forEachOf(obj: Array<T>, iterator: AsyncForEachOfIterator<T>, callback: ErrorCallback? = null)
    fun forEachOfSeries(obj: Any, iterator: (item: Any, key: dynamic /* String | Number */, callback: ErrorCallback? = null) -> Unit, callback: ErrorCallback)
    fun <T> forEachOfSeries(obj: Array<T>, iterator: AsyncForEachOfIterator<T>, callback: ErrorCallback? = null)
    fun forEachOfLimit(obj: Any, limit: Number, iterator: (item: Any, key: dynamic /* String | Number */, callback: ErrorCallback? = null) -> Unit, callback: ErrorCallback)
    fun <T> forEachOfLimit(obj: Array<T>, limit: Number, iterator: AsyncForEachOfIterator<T>, callback: ErrorCallback? = null)
    fun <T, R> map(arr: Array<T>, iterator: AsyncResultIterator<T,R>, callback: AsyncResultArrayCallback<R>? = null): Any
    fun <T, R> mapSeries(arr: Array<T>, iterator: AsyncResultIterator<T,R>, callback: AsyncResultArrayCallback<R>? = null): Any
    fun <T, R> mapLimit(arr: Array<T>, limit: Number, iterator: AsyncResultIterator<T,R>, callback: AsyncResultArrayCallback<R>? = null): Any
    fun <T> filter(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun <T> select(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun <T> filterSeries(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun <T> selectSeries(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun <T> filterLimit(arr: Array<T>, limit: Number, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun <T> selectLimit(arr: Array<T>, limit: Number, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun <T> reject(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun <T> rejectSeries(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun <T> rejectLimit(arr: Array<T>, limit: Number, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun <T, R> reduce(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>? = null): Any
    fun <T, R> inject(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>? = null): Any
    fun <T, R> foldl(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>? = null): Any
    fun <T, R> reduceRight(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    fun <T, R> foldr(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    fun <T> detect(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((result: T) -> Unit)? = null): Any
    fun <T> detectSeries(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((result: T) -> Unit)? = null): Any
    fun <T> detectLimit(arr: Array<T>, limit: Number, iterator: AsyncBooleanIterator<T>, callback: ((result: T) -> Unit)? = null): Any
    fun <T, V> sortBy(arr: Array<T>, iterator: AsyncResultIterator<T,V>, callback: AsyncResultArrayCallback<T>? = null): Any
    fun <T> some(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((result: Boolean) -> Unit)? = null): Any
    fun <T> someLimit(arr: Array<T>, limit: Number, iterator: AsyncBooleanIterator<T>, callback: ((result: Boolean) -> Unit)? = null): Any
    fun <T> any(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((result: Boolean) -> Unit)? = null): Any
    fun <T> every(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((result: Boolean) -> Any)? = null): Any
    fun <T> everyLimit(arr: Array<T>, limit: Number, iterator: AsyncBooleanIterator<T>, callback: ((result: Boolean) -> Any)? = null): Any
    fun <T> all(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((result: Boolean) -> Any)? = null): Any
    fun <T, R> concat(arr: Array<T>, iterator: AsyncResultIterator<T,Array<R>>, callback: AsyncResultArrayCallback<R>? = null): Any
    fun <T, R> concatSeries(arr: Array<T>, iterator: AsyncResultIterator<T,Array<R>>, callback: AsyncResultArrayCallback<R>? = null): Any
    fun <T> series(tasks: Array<AsyncFunction<T>>, callback: AsyncResultArrayCallback<T>? = null)
    fun <T> series(tasks: Dictionary<AsyncFunction<T>>, callback: AsyncResultObjectCallback<T>? = null)
    fun <T> parallel(tasks: Array<AsyncFunction<T>>, callback: AsyncResultArrayCallback<T>? = null)
    fun <T> parallel(tasks: Dictionary<AsyncFunction<T>>, callback: AsyncResultObjectCallback<T>? = null)
    fun <T> parallelLimit(tasks: Array<AsyncFunction<T>>, limit: Number, callback: AsyncResultArrayCallback<T>? = null)
    fun <T> parallelLimit(tasks: Dictionary<AsyncFunction<T>>, limit: Number, callback: AsyncResultObjectCallback<T>? = null)
    fun whilst(test: () -> Boolean, fn: AsyncVoidFunction, callback: (err: Any) -> Unit)
    fun doWhilst(fn: AsyncVoidFunction, test: () -> Boolean, callback: (err: Any) -> Unit)
    fun until(test: () -> Boolean, fn: AsyncVoidFunction, callback: (err: Any) -> Unit)
    fun doUntil(fn: AsyncVoidFunction, test: () -> Boolean, callback: (err: Any) -> Unit)
    fun during(test: (testCallback: (error: Error, truth: Boolean) -> Unit) -> Unit, fn: AsyncVoidFunction, callback: (err: Any) -> Unit)
    fun doDuring(fn: AsyncVoidFunction, test: (testCallback: (error: Error, truth: Boolean) -> Unit) -> Unit, callback: (err: Any) -> Unit)
    fun forever(next: (errCallback: (err: Error) -> Unit) -> Unit, errBack: (err: Error) -> Unit)
    fun waterfall(tasks: Array<Function>, callback: ((err: Error, results: Any? = null) -> Unit)? = null)
    fun compose(vararg fns: Function): Function
    fun seq(vararg fns: Function): Function
    fun applyEach(fns: Array<Function>, argsAndCallback: Array<Any>)
    fun applyEachSeries(fns: Array<Function>, argsAndCallback: Array<Any>)
    fun <T> queue(worker: AsyncWorker<T>, concurrency: Number? = null): AsyncQueue<T>
    fun <T> priorityQueue(worker: AsyncWorker<T>, concurrency: Number): AsyncPriorityQueue<T>
    fun cargo(worker: (tasks: Array<Any>, callback: ErrorCallback) -> Unit, payload: Number? = null): AsyncCargo
    fun auto(tasks: Any, callback: ((error: Error, results: Any) -> Unit)? = null)
    fun <T> retry(opts: Number, task: (callback: AsyncResultCallback<T>, results: Any) -> Unit, callback: (error: Error, results: Any) -> Unit)
    fun <T> retry(opts: `T$0`, task: (callback: AsyncResultCallback<T>, results: Any) -> Unit, callback: (error: Error, results: Any) -> Unit)
    fun iterator(tasks: Array<Function>): Function
    fun apply(fn: Function, vararg arguments: Any): AsyncFunction<Any>
    fun nextTick(callback: Function)
    fun setImmediate(callback: Function)
    fun <T> times(n: Number, iterator: AsyncResultIterator<Number,T>, callback: AsyncResultArrayCallback<T>)
    fun <T> timesSeries(n: Number, iterator: AsyncResultIterator<Number,T>, callback: AsyncResultArrayCallback<T>)
    fun <T> timesLimit(n: Number, limit: Number, iterator: AsyncResultIterator<Number,T>, callback: AsyncResultArrayCallback<T>)
    fun memoize(fn: Function, hasher: Function? = null): Function
    fun unmemoize(fn: Function): Function
    fun ensureAsync(fn: (vararg argsAndCallback: Any) -> Unit): Function
    fun constant(vararg values: Any): Function
    fun asyncify(fn: Function): Function
    fun wrapSync(fn: Function): Function
    fun log(fn: Function, vararg arguments: Any)
    fun dir(fn: Function, vararg arguments: Any)
    fun noConflict(): Async
}
@native
@module("async")
var async: Async = noImpl
