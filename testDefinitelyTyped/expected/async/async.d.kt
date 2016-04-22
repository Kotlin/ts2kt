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
    fun each<T>(arr: Array<T>, iterator: AsyncIterator<T>, callback: ErrorCallback? = null)
    fun eachSeries<T>(arr: Array<T>, iterator: AsyncIterator<T>, callback: ErrorCallback? = null)
    fun eachLimit<T>(arr: Array<T>, limit: Number, iterator: AsyncIterator<T>, callback: ErrorCallback? = null)
    fun forEachOf(obj: Any, iterator: (item: Any, key: dynamic /* String | Number */, callback: ErrorCallback? = null) -> Unit, callback: ErrorCallback)
    fun forEachOf<T>(obj: Array<T>, iterator: AsyncForEachOfIterator<T>, callback: ErrorCallback? = null)
    fun forEachOfSeries(obj: Any, iterator: (item: Any, key: dynamic /* String | Number */, callback: ErrorCallback? = null) -> Unit, callback: ErrorCallback)
    fun forEachOfSeries<T>(obj: Array<T>, iterator: AsyncForEachOfIterator<T>, callback: ErrorCallback? = null)
    fun forEachOfLimit(obj: Any, limit: Number, iterator: (item: Any, key: dynamic /* String | Number */, callback: ErrorCallback? = null) -> Unit, callback: ErrorCallback)
    fun forEachOfLimit<T>(obj: Array<T>, limit: Number, iterator: AsyncForEachOfIterator<T>, callback: ErrorCallback? = null)
    fun map<T, R>(arr: Array<T>, iterator: AsyncResultIterator<T,R>, callback: AsyncResultArrayCallback<R>? = null): Any
    fun mapSeries<T, R>(arr: Array<T>, iterator: AsyncResultIterator<T,R>, callback: AsyncResultArrayCallback<R>? = null): Any
    fun mapLimit<T, R>(arr: Array<T>, limit: Number, iterator: AsyncResultIterator<T,R>, callback: AsyncResultArrayCallback<R>? = null): Any
    fun filter<T>(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun select<T>(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun filterSeries<T>(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun selectSeries<T>(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun filterLimit<T>(arr: Array<T>, limit: Number, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun selectLimit<T>(arr: Array<T>, limit: Number, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun reject<T>(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun rejectSeries<T>(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun rejectLimit<T>(arr: Array<T>, limit: Number, iterator: AsyncBooleanIterator<T>, callback: ((results: Array<T>) -> Any)? = null): Any
    fun reduce<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>? = null): Any
    fun inject<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>? = null): Any
    fun foldl<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>? = null): Any
    fun reduceRight<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    fun foldr<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    fun detect<T>(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((result: T) -> Unit)? = null): Any
    fun detectSeries<T>(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((result: T) -> Unit)? = null): Any
    fun detectLimit<T>(arr: Array<T>, limit: Number, iterator: AsyncBooleanIterator<T>, callback: ((result: T) -> Unit)? = null): Any
    fun sortBy<T, V>(arr: Array<T>, iterator: AsyncResultIterator<T,V>, callback: AsyncResultArrayCallback<T>? = null): Any
    fun some<T>(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((result: Boolean) -> Unit)? = null): Any
    fun someLimit<T>(arr: Array<T>, limit: Number, iterator: AsyncBooleanIterator<T>, callback: ((result: Boolean) -> Unit)? = null): Any
    fun any<T>(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((result: Boolean) -> Unit)? = null): Any
    fun every<T>(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((result: Boolean) -> Any)? = null): Any
    fun everyLimit<T>(arr: Array<T>, limit: Number, iterator: AsyncBooleanIterator<T>, callback: ((result: Boolean) -> Any)? = null): Any
    fun all<T>(arr: Array<T>, iterator: AsyncBooleanIterator<T>, callback: ((result: Boolean) -> Any)? = null): Any
    fun concat<T, R>(arr: Array<T>, iterator: AsyncResultIterator<T,Array<R>>, callback: AsyncResultArrayCallback<R>? = null): Any
    fun concatSeries<T, R>(arr: Array<T>, iterator: AsyncResultIterator<T,Array<R>>, callback: AsyncResultArrayCallback<R>? = null): Any
    fun series<T>(tasks: Array<AsyncFunction<T>>, callback: AsyncResultArrayCallback<T>? = null)
    fun series<T>(tasks: Dictionary<AsyncFunction<T>>, callback: AsyncResultObjectCallback<T>? = null)
    fun parallel<T>(tasks: Array<AsyncFunction<T>>, callback: AsyncResultArrayCallback<T>? = null)
    fun parallel<T>(tasks: Dictionary<AsyncFunction<T>>, callback: AsyncResultObjectCallback<T>? = null)
    fun parallelLimit<T>(tasks: Array<AsyncFunction<T>>, limit: Number, callback: AsyncResultArrayCallback<T>? = null)
    fun parallelLimit<T>(tasks: Dictionary<AsyncFunction<T>>, limit: Number, callback: AsyncResultObjectCallback<T>? = null)
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
    fun queue<T>(worker: AsyncWorker<T>, concurrency: Number? = null): AsyncQueue<T>
    fun priorityQueue<T>(worker: AsyncWorker<T>, concurrency: Number): AsyncPriorityQueue<T>
    fun cargo(worker: (tasks: Array<Any>, callback: ErrorCallback) -> Unit, payload: Number? = null): AsyncCargo
    fun auto(tasks: Any, callback: ((error: Error, results: Any) -> Unit)? = null)
    fun retry<T>(opts: Number, task: (callback: AsyncResultCallback<T>, results: Any) -> Unit, callback: (error: Error, results: Any) -> Unit)
    fun retry<T>(opts: `T$0`, task: (callback: AsyncResultCallback<T>, results: Any) -> Unit, callback: (error: Error, results: Any) -> Unit)
    fun iterator(tasks: Array<Function>): Function
    fun apply(fn: Function, vararg arguments: Any): AsyncFunction<Any>
    fun nextTick(callback: Function)
    fun setImmediate(callback: Function)
    fun times<T>(n: Number, iterator: AsyncResultIterator<Number,T>, callback: AsyncResultArrayCallback<T>)
    fun timesSeries<T>(n: Number, iterator: AsyncResultIterator<Number,T>, callback: AsyncResultArrayCallback<T>)
    fun timesLimit<T>(n: Number, limit: Number, iterator: AsyncResultIterator<Number,T>, callback: AsyncResultArrayCallback<T>)
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
