package Arbiter

module
public object ArbiterDef {
    public trait SubscribeHandler {
        public fun invoke(data: Any, message: String, subscriber_context: Any): Unit
    }
    public trait SubscribeOptions {
        public var priority: Number?
        public var async: Boolean?
        public var persist: Boolean?
    }
    public trait PublishOptions {
        public var cancelable: Boolean?
        public var persist: Boolean?
        public var async: Boolean?
    }
    public trait ArbiterStatic {
        public var version: String
        public var updated_on: String
        public fun create(): ArbiterStatic
        public fun publish(msg: String, data: Any? = null, options: PublishOptions? = null): Boolean
        public fun subscribe(msg: String, func: SubscribeHandler): Any
        public fun subscribe(msg: String, options: SubscribeOptions, func: SubscribeHandler): Any
        public fun subscribe(msg: String, options: SubscribeOptions, context: Any, func: SubscribeHandler): Any
        public fun subscribe(msg: Array<String>, func: SubscribeHandler): Any
        public fun subscribe(msg: Array<String>, options: SubscribeOptions, func: SubscribeHandler): Any
        public fun subscribe(msg: Array<String>, options: SubscribeOptions, context: Any, func: SubscribeHandler): Any
        public fun unsubscribe(subscription_id: Number): Boolean
        public fun resubscribe(subscription_id: Number): Boolean
    }
}
native
public var Arbiter: ArbiterDef.ArbiterStatic = noImpl
