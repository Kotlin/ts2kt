package async

native
public trait AsyncMultipleResultsCallback<T> {
    public fun invoke(err: Error, results: Array<T>): Any
}
native
public trait AsyncSingleResultCallback<T> {
    public fun invoke(err: Error, result: T)
}
native
public trait AsyncTimesCallback<T> {
    public fun invoke(n: Number, callback: AsyncMultipleResultsCallback<T>)
}
native
public trait AsyncIterator<T, R> {
    public fun invoke(item: T, callback: AsyncSingleResultCallback<R>)
}
native
public trait AsyncMemoIterator<T, R> {
    public fun invoke(memo: R, item: T, callback: AsyncSingleResultCallback<R>)
}
native
public trait AsyncWorker<T> {
    public fun invoke(task: T, callback: Function)
}
native
public trait AsyncQueue<T> {
    public fun length(): Number
    public var concurrency: Number
    public var started: Boolean
    public var paused: Boolean
    public fun push(task: T, callback: AsyncMultipleResultsCallback<T>? = null)
    public fun push(task: Array<T>, callback: AsyncMultipleResultsCallback<T>? = null)
    public fun unshift(task: T, callback: AsyncMultipleResultsCallback<T>? = null)
    public fun unshift(task: Array<T>, callback: AsyncMultipleResultsCallback<T>? = null)
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
    public fun forEach<T, R>(arr: Array<T>, iterator: AsyncIterator<T, R>, callback: AsyncMultipleResultsCallback<R>)
    public fun forEachSeries<T, R>(arr: Array<T>, iterator: AsyncIterator<T, R>, callback: AsyncMultipleResultsCallback<R>)
    public fun forEachLimit<T, R>(arr: Array<T>, limit: Number, iterator: AsyncIterator<T, R>, callback: AsyncMultipleResultsCallback<R>)
    public fun map<T, R>(arr: Array<T>, iterator: AsyncIterator<T, R>, callback: AsyncMultipleResultsCallback<R>): Any
    public fun mapSeries<T, R>(arr: Array<T>, iterator: AsyncIterator<T, R>, callback: AsyncMultipleResultsCallback<R>): Any
    public fun filter<T>(arr: Array<T>, iterator: AsyncIterator<T, Boolean>, callback: AsyncMultipleResultsCallback<T>): Any
    public fun select<T, R>(arr: Array<T>, iterator: AsyncIterator<T, Boolean>, callback: AsyncMultipleResultsCallback<T>): Any
    public fun filterSeries<T, R>(arr: Array<T>, iterator: AsyncIterator<T, Boolean>, callback: AsyncMultipleResultsCallback<T>): Any
    public fun selectSeries<T, R>(arr: Array<T>, iterator: AsyncIterator<T, Boolean>, callback: AsyncMultipleResultsCallback<T>): Any
    public fun reject<T>(arr: Array<T>, iterator: AsyncIterator<T, Boolean>, callback: AsyncMultipleResultsCallback<T>): Any
    public fun rejectSeries<T>(arr: Array<T>, iterator: AsyncIterator<T, Boolean>, callback: AsyncMultipleResultsCallback<T>): Any
    public fun reduce<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T, R>, callback: AsyncSingleResultCallback<R>): Any
    public fun inject<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T, R>, callback: AsyncSingleResultCallback<R>): Any
    public fun foldl<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T, R>, callback: AsyncSingleResultCallback<R>): Any
    public fun reduceRight<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T, R>, callback: AsyncSingleResultCallback<R>): Any
    public fun foldr<T, R>(arr: Array<T>, memo: R, iterator: AsyncMemoIterator<T, R>, callback: AsyncSingleResultCallback<R>): Any
    public fun detect<T>(arr: Array<T>, iterator: AsyncIterator<T, Boolean>, callback: AsyncMultipleResultsCallback<T>): Any
    public fun detectSeries<T>(arr: Array<T>, iterator: AsyncIterator<T, Boolean>, callback: AsyncMultipleResultsCallback<T>): Any
    public fun sortBy<T, V>(arr: Array<T>, iterator: AsyncIterator<T, V>, callback: AsyncMultipleResultsCallback<T>): Any
    public fun some<T>(arr: Array<T>, iterator: AsyncIterator<T, Boolean>, callback: AsyncMultipleResultsCallback<T>): Any
    public fun any<T>(arr: Array<T>, iterator: AsyncIterator<T, Boolean>, callback: AsyncMultipleResultsCallback<T>): Any
    public fun every<T>(arr: Array<T>, iterator: AsyncIterator<T, Boolean>, callback: (result: Boolean) -> Any): Any
    public fun all<T>(arr: Array<T>, iterator: AsyncIterator<T, Boolean>, callback: (result: Boolean) -> Any): Any
    public fun concat<T, R>(arr: Array<T>, iterator: AsyncIterator<T, Array<R>>, callback: AsyncMultipleResultsCallback<R>): Any
    public fun concatSeries<T, R>(arr: Array<T>, iterator: AsyncIterator<T, Array<R>>, callback: AsyncMultipleResultsCallback<R>): Any
    public fun series<T>(tasks: Array<T>, callback: AsyncMultipleResultsCallback<T>? = null)
    public fun series<T>(tasks: T, callback: AsyncMultipleResultsCallback<T>? = null)
    public fun parallel<T>(tasks: Array<T>, callback: AsyncMultipleResultsCallback<T>? = null)
    public fun parallel<T>(tasks: T, callback: AsyncMultipleResultsCallback<T>? = null)
    public fun parallelLimit<T>(tasks: Array<T>, limit: Number, callback: AsyncMultipleResultsCallback<T>? = null)
    public fun parallelLimit<T>(tasks: T, limit: Number, callback: AsyncMultipleResultsCallback<T>? = null)
    public fun whilst(test: Function, fn: Function, callback: Function)
    public fun until(test: Function, fn: Function, callback: Function)
    public fun waterfall<T>(tasks: Array<T>, callback: AsyncMultipleResultsCallback<T>? = null)
    public fun waterfall<T>(tasks: T, callback: AsyncMultipleResultsCallback<T>? = null)
    public fun queue<T>(worker: AsyncWorker<T>, concurrency: Number): AsyncQueue<T>
    public fun auto(tasks: Any, callback: AsyncMultipleResultsCallback<Any>? = null)
    public fun iterator(tasks: Array<Function>): Function
    public fun apply(fn: Function, vararg arguments: Any)
    public fun nextTick<T>(callback: Function)
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
