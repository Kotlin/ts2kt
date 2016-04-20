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
interface AsyncTimesCallback<T> {
    @nativeInvoke
    fun invoke(n: Number, callback: AsyncResultArrayCallback<T>)
}
@native
interface AsyncIterator<T> {
    @nativeInvoke
    fun invoke(item: T, callback: ErrorCallback)
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
interface AsyncWorker<T> {
    @nativeInvoke
    fun invoke(task: T, callback: ErrorCallback)
}
@native
interface AsyncFunction<T> {
    @nativeInvoke
    fun invoke(callback: AsyncResultCallback<T>)
}
@native
interface AsyncVoidFunction {
    @nativeInvoke
    fun invoke(callback: ErrorCallback)
}
@native
interface AsyncQueue<T> {
    fun length(): Number
    var concurrency: Number
    var started: Boolean
    var paused: Boolean
    fun push(task: T, callback: ErrorCallback? = null)
    fun push(task: Array<T>, callback: ErrorCallback? = null)
    fun unshift(task: T, callback: ErrorCallback? = null)
    fun unshift(task: Array<T>, callback: ErrorCallback? = null)
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
interface Async {
    fun each<T>(arr: Array<T>, iterator: AsyncIterator<T>, callback: ErrorCallback)
    fun eachSeries<T>(arr: Array<T>, iterator: AsyncIterator<T>, callback: ErrorCallback)
    fun eachLimit<T>(arr: Array<T>, limit: Number, iterator: AsyncIterator<T>, callback: ErrorCallback)
    fun map<T, R>(arr: Array<T>, iterator: AsyncResultIterator<T,R>, callback: AsyncResultArrayCallback<R>): Any
    fun mapSeries<T, R>(arr: Array<T>, iterator: AsyncResultIterator<T,R>, callback: AsyncResultArrayCallback<R>): Any
    fun mapLimit<T, R>(arr: Array<T>, limit: Number, iterator: AsyncResultIterator<T,R>, callback: AsyncResultArrayCallback<R>): Any
    fun filter<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (results: Array<T>) -> Any): Any
    fun select<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (results: Array<T>) -> Any): Any
    fun filterSeries<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (results: Array<T>) -> Any): Any
    fun selectSeries<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (results: Array<T>) -> Any): Any
    fun reject<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (results: Array<T>) -> Any): Any
    fun rejectSeries<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (results: Array<T>) -> Any): Any
    fun reduce<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    fun inject<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    fun foldl<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    fun reduceRight<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    fun foldr<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    fun detect<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: AsyncResultArrayCallback<T>): Any
    fun detectSeries<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: AsyncResultArrayCallback<T>): Any
    fun sortBy<T, V>(arr: Array<T>, iterator: AsyncResultIterator<T,V>, callback: AsyncResultArrayCallback<T>): Any
    fun some<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: AsyncResultArrayCallback<T>): Any
    fun any<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: AsyncResultArrayCallback<T>): Any
    fun every<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (result: Boolean) -> Any): Any
    fun all<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (result: Boolean) -> Any): Any
    fun concat<T, R>(arr: Array<T>, iterator: AsyncResultIterator<T,Array<R>>, callback: AsyncResultArrayCallback<R>): Any
    fun concatSeries<T, R>(arr: Array<T>, iterator: AsyncResultIterator<T,Array<R>>, callback: AsyncResultArrayCallback<R>): Any
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
    fun waterfall(tasks: Array<Function>, callback: AsyncResultArrayCallback<Any>? = null)
    fun queue<T>(worker: AsyncWorker<T>, concurrency: Number): AsyncQueue<T>
    fun priorityQueue<T>(worker: AsyncWorker<T>, concurrency: Number): AsyncPriorityQueue<T>
    fun auto(tasks: Any, callback: AsyncResultArrayCallback<Any>? = null)
    fun iterator(tasks: Array<Function>): Function
    fun apply(fn: Function, vararg arguments: Any): AsyncFunction<Any>
    fun nextTick(callback: Function)
    fun times<T>(n: Number, callback: AsyncTimesCallback<T>)
    fun timesSeries<T>(n: Number, callback: AsyncTimesCallback<T>)
    fun memoize(fn: Function, hasher: Function? = null): Function
    fun unmemoize(fn: Function): Function
    fun log(fn: Function, vararg arguments: Any)
    fun dir(fn: Function, vararg arguments: Any)
    fun noConflict(): Async
}
@native
@module("async")
var async: Async = noImpl
