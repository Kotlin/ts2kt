package async

native
public trait Dictionary<T> {
    nativeGetter
    public fun get(key: String): T
    nativeSetter
    public fun set(key: String, value: T)
}
native
public trait ErrorCallback {
    nativeInvoke
    public fun invoke(err: Error? = null)
}
native
public trait AsyncResultCallback<T> {
    nativeInvoke
    public fun invoke(err: Error, result: T)
}
native
public trait AsyncResultArrayCallback<T> {
    nativeInvoke
    public fun invoke(err: Error, results: Array<T>)
}
native
public trait AsyncResultObjectCallback<T> {
    nativeInvoke
    public fun invoke(err: Error, results: Dictionary<T>)
}
native
public trait AsyncTimesCallback<T> {
    nativeInvoke
    public fun invoke(n: Number, callback: AsyncResultArrayCallback<T>)
}
native
public trait AsyncIterator<T> {
    nativeInvoke
    public fun invoke(item: T, callback: ErrorCallback)
}
native
public trait AsyncResultIterator<T, R> {
    nativeInvoke
    public fun invoke(item: T, callback: AsyncResultCallback<R>)
}
native
public trait AsyncMemoIterator<T, R> {
    nativeInvoke
    public fun invoke(memo: R, item: T, callback: AsyncResultCallback<R>)
}
native
public trait AsyncWorker<T> {
    nativeInvoke
    public fun invoke(task: T, callback: ErrorCallback)
}
native
public trait AsyncFunction<T> {
    nativeInvoke
    public fun invoke(callback: AsyncResultCallback<T>)
}
native
public trait AsyncVoidFunction {
    nativeInvoke
    public fun invoke(callback: ErrorCallback)
}
native
public trait AsyncQueue<T> {
    public fun length(): Number
    public var concurrency: Number
    public var started: Boolean
    public var paused: Boolean
    public fun push(task: T, callback: ErrorCallback? = null)
    public fun push(task: Array<T>, callback: ErrorCallback? = null)
    public fun unshift(task: T, callback: ErrorCallback? = null)
    public fun unshift(task: Array<T>, callback: ErrorCallback? = null)
    public var saturated: () -> Any
    public var empty: () -> Any
    public var drain: () -> Any
    public fun running(): Number
    public fun idle(): Boolean
    public fun pause()
    public fun resume()
    public fun kill()
}
native
public trait AsyncPriorityQueue<T> {
    public fun length(): Number
    public var concurrency: Number
    public var started: Boolean
    public var paused: Boolean
    public fun push(task: T, priority: Number, callback: AsyncResultArrayCallback<T>? = null)
    public fun push(task: Array<T>, priority: Number, callback: AsyncResultArrayCallback<T>? = null)
    public var saturated: () -> Any
    public var empty: () -> Any
    public var drain: () -> Any
    public fun running(): Number
    public fun idle(): Boolean
    public fun pause()
    public fun resume()
    public fun kill()
}
native
public trait Async {
    public fun each<T>(arr: Array<T>, iterator: AsyncIterator<T>, callback: ErrorCallback)
    public fun eachSeries<T>(arr: Array<T>, iterator: AsyncIterator<T>, callback: ErrorCallback)
    public fun eachLimit<T>(arr: Array<T>, limit: Number, iterator: AsyncIterator<T>, callback: ErrorCallback)
    public fun map<T, R>(arr: Array<T>, iterator: AsyncResultIterator<T,R>, callback: AsyncResultArrayCallback<R>): Any
    public fun mapSeries<T, R>(arr: Array<T>, iterator: AsyncResultIterator<T,R>, callback: AsyncResultArrayCallback<R>): Any
    public fun mapLimit<T, R>(arr: Array<T>, limit: Number, iterator: AsyncResultIterator<T,R>, callback: AsyncResultArrayCallback<R>): Any
    public fun filter<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (results: Array<T>) -> Any): Any
    public fun select<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (results: Array<T>) -> Any): Any
    public fun filterSeries<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (results: Array<T>) -> Any): Any
    public fun selectSeries<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (results: Array<T>) -> Any): Any
    public fun reject<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (results: Array<T>) -> Any): Any
    public fun rejectSeries<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (results: Array<T>) -> Any): Any
    public fun reduce<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    public fun inject<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    public fun foldl<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    public fun reduceRight<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    public fun foldr<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T,R>, callback: AsyncResultCallback<R>): Any
    public fun detect<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: AsyncResultArrayCallback<T>): Any
    public fun detectSeries<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: AsyncResultArrayCallback<T>): Any
    public fun sortBy<T, V>(arr: Array<T>, iterator: AsyncResultIterator<T,V>, callback: AsyncResultArrayCallback<T>): Any
    public fun some<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: AsyncResultArrayCallback<T>): Any
    public fun any<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: AsyncResultArrayCallback<T>): Any
    public fun every<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (result: Boolean) -> Any): Any
    public fun all<T>(arr: Array<T>, iterator: AsyncResultIterator<T,Boolean>, callback: (result: Boolean) -> Any): Any
    public fun concat<T, R>(arr: Array<T>, iterator: AsyncResultIterator<T,Array<R>>, callback: AsyncResultArrayCallback<R>): Any
    public fun concatSeries<T, R>(arr: Array<T>, iterator: AsyncResultIterator<T,Array<R>>, callback: AsyncResultArrayCallback<R>): Any
    public fun series<T>(tasks: Array<AsyncFunction<T>>, callback: AsyncResultArrayCallback<T>? = null)
    public fun series<T>(tasks: Dictionary<AsyncFunction<T>>, callback: AsyncResultObjectCallback<T>? = null)
    public fun parallel<T>(tasks: Array<AsyncFunction<T>>, callback: AsyncResultArrayCallback<T>? = null)
    public fun parallel<T>(tasks: Dictionary<AsyncFunction<T>>, callback: AsyncResultObjectCallback<T>? = null)
    public fun parallelLimit<T>(tasks: Array<AsyncFunction<T>>, limit: Number, callback: AsyncResultArrayCallback<T>? = null)
    public fun parallelLimit<T>(tasks: Dictionary<AsyncFunction<T>>, limit: Number, callback: AsyncResultObjectCallback<T>? = null)
    public fun whilst(test: () -> Boolean, fn: AsyncVoidFunction, callback: (err: Any) -> Unit)
    public fun doWhilst(fn: AsyncVoidFunction, test: () -> Boolean, callback: (err: Any) -> Unit)
    public fun until(test: () -> Boolean, fn: AsyncVoidFunction, callback: (err: Any) -> Unit)
    public fun doUntil(fn: AsyncVoidFunction, test: () -> Boolean, callback: (err: Any) -> Unit)
    public fun waterfall(tasks: Array<Function>, callback: AsyncResultArrayCallback<Any>? = null)
    public fun queue<T>(worker: AsyncWorker<T>, concurrency: Number): AsyncQueue<T>
    public fun priorityQueue<T>(worker: AsyncWorker<T>, concurrency: Number): AsyncPriorityQueue<T>
    public fun auto(tasks: Any, callback: AsyncResultArrayCallback<Any>? = null)
    public fun iterator(tasks: Array<Function>): Function
    public fun apply(fn: Function, vararg arguments: Any): AsyncFunction<Any>
    public fun nextTick(callback: Function)
    public fun times<T>(n: Number, callback: AsyncTimesCallback<T>)
    public fun timesSeries<T>(n: Number, callback: AsyncTimesCallback<T>)
    public fun memoize(fn: Function, hasher: Function? = null): Function
    public fun unmemoize(fn: Function): Function
    public fun log(fn: Function, vararg arguments: Any)
    public fun dir(fn: Function, vararg arguments: Any)
    public fun noConflict(): Async
}
native
module("async")
public var async: Async = noImpl
