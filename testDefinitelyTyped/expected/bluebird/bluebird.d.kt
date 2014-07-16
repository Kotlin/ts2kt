// OUT:
// WRONG
package bluebird

native
module("bluebird")
public class Promise<R>(callback: (resolve: (thenable: Promise.Thenable<R>) -> Unit, reject: (error: Any) -> Unit) -> Unit) : Promise.Thenable<R> {
    public fun then<U>(onFulfill: (value: R) -> Promise.Thenable<U>, onReject: (error: Any) -> Promise.Thenable<U>, onProgress: ((note: Any) -> Any)? = null): Promise<U> = noImpl
    public fun then<U>(onFulfill: (value: R) -> Promise.Thenable<U>, onReject: ((error: Any) -> U)? = null, onProgress: ((note: Any) -> Any)? = null): Promise<U> = noImpl
    public fun then<U>(onFulfill: (value: R) -> U, onReject: (error: Any) -> Promise.Thenable<U>, onProgress: ((note: Any) -> Any)? = null): Promise<U> = noImpl
    public fun then<U>(onFulfill: ((value: R) -> U)? = null, onReject: ((error: Any) -> U)? = null, onProgress: ((note: Any) -> Any)? = null): Promise<U> = noImpl
    public fun catch<U>(onReject: ((error: Any) -> Promise.Thenable<U>)? = null): Promise<U> = noImpl
    public fun caught<U>(onReject: ((error: Any) -> Promise.Thenable<U>)? = null): Promise<U> = noImpl
    public fun catch<U>(onReject: ((error: Any) -> U)? = null): Promise<U> = noImpl
    public fun caught<U>(onReject: ((error: Any) -> U)? = null): Promise<U> = noImpl
    public fun catch<U>(predicate: (error: Any) -> Boolean, onReject: (error: Any) -> Promise.Thenable<U>): Promise<U> = noImpl
    public fun caught<U>(predicate: (error: Any) -> Boolean, onReject: (error: Any) -> Promise.Thenable<U>): Promise<U> = noImpl
    public fun catch<U>(predicate: (error: Any) -> Boolean, onReject: (error: Any) -> U): Promise<U> = noImpl
    public fun caught<U>(predicate: (error: Any) -> Boolean, onReject: (error: Any) -> U): Promise<U> = noImpl
    public fun catch<U>(ErrorClass: Function, onReject: (error: Any) -> Promise.Thenable<U>): Promise<U> = noImpl
    public fun caught<U>(ErrorClass: Function, onReject: (error: Any) -> Promise.Thenable<U>): Promise<U> = noImpl
    public fun catch<U>(ErrorClass: Function, onReject: (error: Any) -> U): Promise<U> = noImpl
    public fun caught<U>(ErrorClass: Function, onReject: (error: Any) -> U): Promise<U> = noImpl
    public fun error<U>(onReject: (reason: Any) -> Promise.Thenable<U>): Promise<U> = noImpl
    public fun error<U>(onReject: (reason: Any) -> U): Promise<U> = noImpl
    public fun finally(handler: (value: R) -> Promise.Thenable<R>): Promise<R> = noImpl
    public fun finally(handler: (value: R) -> R): Promise<R> = noImpl
    public fun finally(handler: (value: R) -> Unit): Promise<R> = noImpl
    public fun lastly(handler: (value: R) -> Promise.Thenable<R>): Promise<R> = noImpl
    public fun lastly(handler: (value: R) -> R): Promise<R> = noImpl
    public fun lastly(handler: (value: R) -> Unit): Promise<R> = noImpl
    public fun bind(thisArg: Any): Promise<R> = noImpl
    public fun done<U>(onFulfilled: (value: R) -> Promise.Thenable<U>, onRejected: (error: Any) -> Promise.Thenable<U>, onProgress: ((note: Any) -> Any)? = null): Promise<U> = noImpl
    public fun done<U>(onFulfilled: (value: R) -> Promise.Thenable<U>, onRejected: ((error: Any) -> U)? = null, onProgress: ((note: Any) -> Any)? = null): Promise<U> = noImpl
    public fun done<U>(onFulfilled: (value: R) -> U, onRejected: (error: Any) -> Promise.Thenable<U>, onProgress: ((note: Any) -> Any)? = null): Promise<U> = noImpl
    public fun done<U>(onFulfilled: ((value: R) -> U)? = null, onRejected: ((error: Any) -> U)? = null, onProgress: ((note: Any) -> Any)? = null): Promise<U> = noImpl
    public fun progressed(handler: (note: Any) -> Any): Promise<R> = noImpl
    public fun delay(ms: Number): Promise<R> = noImpl
    public fun timeout(ms: Number, message: String? = null): Promise<R> = noImpl
    public fun nodeify(callback: (err: Any, value: R? = null) -> Unit): Promise<R> = noImpl
    public fun nodeify(vararg sink: Any): Unit = noImpl
    public fun cancellable(): Promise<R> = noImpl
    public fun cancel<U>(): Promise<U> = noImpl
    public fun fork<U>(onFulfilled: (value: R) -> Promise.Thenable<U>, onRejected: (error: Any) -> Promise.Thenable<U>, onProgress: ((note: Any) -> Any)? = null): Promise<U> = noImpl
    public fun fork<U>(onFulfilled: (value: R) -> Promise.Thenable<U>, onRejected: ((error: Any) -> U)? = null, onProgress: ((note: Any) -> Any)? = null): Promise<U> = noImpl
    public fun fork<U>(onFulfilled: (value: R) -> U, onRejected: (error: Any) -> Promise.Thenable<U>, onProgress: ((note: Any) -> Any)? = null): Promise<U> = noImpl
    public fun fork<U>(onFulfilled: ((value: R) -> U)? = null, onRejected: ((error: Any) -> U)? = null, onProgress: ((note: Any) -> Any)? = null): Promise<U> = noImpl
    public fun uncancellable(): Promise<R> = noImpl
    public fun isCancellable(): Boolean = noImpl
    public fun isFulfilled(): Boolean = noImpl
    public fun isRejected(): Boolean = noImpl
    public fun isPending(): Boolean = noImpl
    public fun isResolved(): Boolean = noImpl
    public fun inspect(): Promise.Inspection<R> = noImpl
    public fun call(propertyName: String, vararg args: Any): Promise<Any> = noImpl
    // WRONG
    public fun return(): Promise<Any> = noImpl
    public fun thenReturn(): Promise<Any> = noImpl
    public fun return<U>(value: U): Promise<U> = noImpl
    public fun thenReturn<U>(value: U): Promise<U> = noImpl
    // WRONG
    public fun throw(reason: Error): Promise<R> = noImpl
    public fun thenThrow(reason: Error): Promise<R> = noImpl
    public fun toString(): String = noImpl
    public fun toJSON(): Object = noImpl
    public fun spread<U>(onFulfill: Function, onReject: ((reason: Any) -> Promise.Thenable<U>)? = null): Promise<U> = noImpl
    public fun spread<U>(onFulfill: Function, onReject: ((reason: Any) -> U)? = null): Promise<U> = noImpl
    public fun all<U>(): Promise<Array<U>> = noImpl
    public fun props(): Promise<Object> = noImpl
    public fun settle<U>(): Promise<Array<Promise.Inspection<U>>> = noImpl
    public fun any<U>(): Promise<U> = noImpl
    public fun some<U>(count: Number): Promise<Array<U>> = noImpl
    public fun race<U>(): Promise<U> = noImpl
    public fun map<Q, U>(mapper: (item: Q, index: Number, arrayLength: Number) -> Promise.Thenable<U>): Promise<U> = noImpl
    public fun map<Q, U>(mapper: (item: Q, index: Number, arrayLength: Number) -> U): Promise<U> = noImpl
    public fun reduce<Q, U>(reducer: (memo: U, item: Q, index: Number, arrayLength: Number) -> Promise.Thenable<U>, initialValue: U? = null): Promise<U> = noImpl
    public fun reduce<Q, U>(reducer: (memo: U, item: Q, index: Number, arrayLength: Number) -> U, initialValue: U? = null): Promise<U> = noImpl
    public fun filter<U>(filterer: (item: U, index: Number, arrayLength: Number) -> Promise.Thenable<Boolean>): Promise<U> = noImpl
    public fun filter<U>(filterer: (item: U, index: Number, arrayLength: Number) -> Boolean): Promise<U> = noImpl
    public class object {
        // WRONG
        public fun try<R>(fn: () -> Promise.Thenable<R>, args: Array<Any>? = null, ctx: Any? = null): Promise<R> = noImpl
        public fun try<R>(fn: () -> R, args: Array<Any>? = null, ctx: Any? = null): Promise<R> = noImpl
        public fun attempt<R>(fn: () -> Promise.Thenable<R>, args: Array<Any>? = null, ctx: Any? = null): Promise<R> = noImpl
        public fun attempt<R>(fn: () -> R, args: Array<Any>? = null, ctx: Any? = null): Promise<R> = noImpl
        public fun method(fn: Function): Function = noImpl
        public fun resolve(): Promise<Unit> = noImpl
        public fun resolve<R>(value: Promise.Thenable<R>): Promise<R> = noImpl
        public fun resolve<R>(value: R): Promise<R> = noImpl
        public fun reject(reason: Any): Promise<Any> = noImpl
        public fun reject<R>(reason: Any): Promise<R> = noImpl
        public fun defer<R>(): Promise.Resolver<R> = noImpl
        public fun cast<R>(value: Promise.Thenable<R>): Promise<R> = noImpl
        public fun cast<R>(value: R): Promise<R> = noImpl
        public fun bind(thisArg: Any): Promise<Unit> = noImpl
        public fun `is`(value: Any): Boolean = noImpl
        public fun longStackTraces(): Unit = noImpl
        public fun delay<R>(value: Promise.Thenable<R>, ms: Number): Promise<R> = noImpl
        public fun delay<R>(value: R, ms: Number): Promise<R> = noImpl
        public fun delay(ms: Number): Promise<Unit> = noImpl
        public fun promisify(nodeFunction: Function, receiver: Any? = null): Function = noImpl
        public fun promisifyAll(target: Object): Object = noImpl
        public fun coroutine<R>(generatorFunction: Function): Function = noImpl
        public fun spawn<R>(generatorFunction: Function): Promise<R> = noImpl
        public fun noConflict(): typeof Promise = noImpl
        public fun onPossiblyUnhandledRejection(handler: (reason: Any) -> Any): Unit = noImpl
        public fun all<R>(values: Promise.Thenable<Array<Promise.Thenable<R>>>): Promise<Array<R>> = noImpl
        public fun all<R>(values: Promise.Thenable<Array<R>>): Promise<Array<R>> = noImpl
        public fun all<R>(values: Array<Promise.Thenable<R>>): Promise<Array<R>> = noImpl
        public fun all<R>(values: Array<R>): Promise<Array<R>> = noImpl
        public fun props(`object`: Promise<Object>): Promise<Object> = noImpl
        public fun props(`object`: Object): Promise<Object> = noImpl
        public fun settle<R>(values: Promise.Thenable<Array<Promise.Thenable<R>>>): Promise<Array<Promise.Inspection<R>>> = noImpl
        public fun settle<R>(values: Promise.Thenable<Array<R>>): Promise<Array<Promise.Inspection<R>>> = noImpl
        public fun settle<R>(values: Array<Promise.Thenable<R>>): Promise<Array<Promise.Inspection<R>>> = noImpl
        public fun settle<R>(values: Array<R>): Promise<Array<Promise.Inspection<R>>> = noImpl
        public fun any<R>(values: Promise.Thenable<Array<Promise.Thenable<R>>>): Promise<R> = noImpl
        public fun any<R>(values: Promise.Thenable<Array<R>>): Promise<R> = noImpl
        public fun any<R>(values: Array<Promise.Thenable<R>>): Promise<R> = noImpl
        public fun any<R>(values: Array<R>): Promise<R> = noImpl
        public fun race<R>(values: Promise.Thenable<Array<Promise.Thenable<R>>>): Promise<R> = noImpl
        public fun race<R>(values: Promise.Thenable<Array<R>>): Promise<R> = noImpl
        public fun race<R>(values: Array<Promise.Thenable<R>>): Promise<R> = noImpl
        public fun race<R>(values: Array<R>): Promise<R> = noImpl
        public fun some<R>(values: Promise.Thenable<Array<Promise.Thenable<R>>>, count: Number): Promise<Array<R>> = noImpl
        public fun some<R>(values: Promise.Thenable<Array<R>>, count: Number): Promise<Array<R>> = noImpl
        public fun some<R>(values: Array<Promise.Thenable<R>>, count: Number): Promise<Array<R>> = noImpl
        public fun some<R>(values: Array<R>, count: Number): Promise<Array<R>> = noImpl
        public fun join<R>(vararg values: Promise.Thenable<R>): Promise<Array<R>> = noImpl
        public fun join<R>(vararg values: R): Promise<Array<R>> = noImpl
        public fun map<R, U>(values: Promise.Thenable<Array<Promise.Thenable<R>>>, mapper: (item: R, index: Number, arrayLength: Number) -> Promise.Thenable<U>): Promise<Array<U>> = noImpl
        public fun map<R, U>(values: Promise.Thenable<Array<Promise.Thenable<R>>>, mapper: (item: R, index: Number, arrayLength: Number) -> U): Promise<Array<U>> = noImpl
        public fun map<R, U>(values: Promise.Thenable<Array<R>>, mapper: (item: R, index: Number, arrayLength: Number) -> Promise.Thenable<U>): Promise<Array<U>> = noImpl
        public fun map<R, U>(values: Promise.Thenable<Array<R>>, mapper: (item: R, index: Number, arrayLength: Number) -> U): Promise<Array<U>> = noImpl
        public fun map<R, U>(values: Array<Promise.Thenable<R>>, mapper: (item: R, index: Number, arrayLength: Number) -> Promise.Thenable<U>): Promise<Array<U>> = noImpl
        public fun map<R, U>(values: Array<Promise.Thenable<R>>, mapper: (item: R, index: Number, arrayLength: Number) -> U): Promise<Array<U>> = noImpl
        public fun map<R, U>(values: Array<R>, mapper: (item: R, index: Number, arrayLength: Number) -> Promise.Thenable<U>): Promise<Array<U>> = noImpl
        public fun map<R, U>(values: Array<R>, mapper: (item: R, index: Number, arrayLength: Number) -> U): Promise<Array<U>> = noImpl
        public fun reduce<R, U>(values: Promise.Thenable<Array<Promise.Thenable<R>>>, reducer: (total: U, current: R, index: Number, arrayLength: Number) -> Promise.Thenable<U>, initialValue: U? = null): Promise<U> = noImpl
        public fun reduce<R, U>(values: Promise.Thenable<Array<Promise.Thenable<R>>>, reducer: (total: U, current: R, index: Number, arrayLength: Number) -> U, initialValue: U? = null): Promise<U> = noImpl
        public fun reduce<R, U>(values: Promise.Thenable<Array<R>>, reducer: (total: U, current: R, index: Number, arrayLength: Number) -> Promise.Thenable<U>, initialValue: U? = null): Promise<U> = noImpl
        public fun reduce<R, U>(values: Promise.Thenable<Array<R>>, reducer: (total: U, current: R, index: Number, arrayLength: Number) -> U, initialValue: U? = null): Promise<U> = noImpl
        public fun reduce<R, U>(values: Array<Promise.Thenable<R>>, reducer: (total: U, current: R, index: Number, arrayLength: Number) -> Promise.Thenable<U>, initialValue: U? = null): Promise<U> = noImpl
        public fun reduce<R, U>(values: Array<Promise.Thenable<R>>, reducer: (total: U, current: R, index: Number, arrayLength: Number) -> U, initialValue: U? = null): Promise<U> = noImpl
        public fun reduce<R, U>(values: Array<R>, reducer: (total: U, current: R, index: Number, arrayLength: Number) -> Promise.Thenable<U>, initialValue: U? = null): Promise<U> = noImpl
        public fun reduce<R, U>(values: Array<R>, reducer: (total: U, current: R, index: Number, arrayLength: Number) -> U, initialValue: U? = null): Promise<U> = noImpl
        public fun filter<R>(values: Promise.Thenable<Array<Promise.Thenable<R>>>, filterer: (item: R, index: Number, arrayLength: Number) -> Promise.Thenable<Boolean>): Promise<Array<R>> = noImpl
        public fun filter<R>(values: Promise.Thenable<Array<Promise.Thenable<R>>>, filterer: (item: R, index: Number, arrayLength: Number) -> Boolean): Promise<Array<R>> = noImpl
        public fun filter<R>(values: Promise.Thenable<Array<R>>, filterer: (item: R, index: Number, arrayLength: Number) -> Promise.Thenable<Boolean>): Promise<Array<R>> = noImpl
        public fun filter<R>(values: Promise.Thenable<Array<R>>, filterer: (item: R, index: Number, arrayLength: Number) -> Boolean): Promise<Array<R>> = noImpl
        public fun filter<R>(values: Array<Promise.Thenable<R>>, filterer: (item: R, index: Number, arrayLength: Number) -> Promise.Thenable<Boolean>): Promise<Array<R>> = noImpl
        public fun filter<R>(values: Array<Promise.Thenable<R>>, filterer: (item: R, index: Number, arrayLength: Number) -> Boolean): Promise<Array<R>> = noImpl
        public fun filter<R>(values: Array<R>, filterer: (item: R, index: Number, arrayLength: Number) -> Promise.Thenable<Boolean>): Promise<Array<R>> = noImpl
        public fun filter<R>(values: Array<R>, filterer: (item: R, index: Number, arrayLength: Number) -> Boolean): Promise<Array<R>> = noImpl
        public trait RangeError : Error
        public trait CancellationError : Error
        public trait TimeoutError : Error
        public trait TypeError : Error
        public trait RejectionError : Error
        public trait Thenable<R> {
            public fun then<U>(onFulfilled: (value: R) -> Thenable<U>, onRejected: (error: Any) -> Thenable<U>): Thenable<U>
            public fun then<U>(onFulfilled: (value: R) -> Thenable<U>, onRejected: ((error: Any) -> U)? = null): Thenable<U>
            public fun then<U>(onFulfilled: (value: R) -> U, onRejected: (error: Any) -> Thenable<U>): Thenable<U>
            public fun then<U>(onFulfilled: ((value: R) -> U)? = null, onRejected: ((error: Any) -> U)? = null): Thenable<U>
        }
        public trait Resolver<R> {
            public var promise: Promise<R>
            public fun resolve(value: R): Unit
            public fun resolve(): Unit
            public fun reject(reason: Any): Unit
            public fun progress(value: Any): Unit
            public var callback: (err: Any, value: R, vararg values: R) -> Unit
        }
        public trait Inspection<R> {
            public fun isFulfilled(): Boolean
            public fun isRejected(): Boolean
            public fun isPending(): Boolean
            public fun value(): R
            public fun error(): Any
        }
    }
}
module
public object bluebird {

}
