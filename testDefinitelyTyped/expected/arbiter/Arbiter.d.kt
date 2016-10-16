package Arbiter

@module
object ArbiterDef {
    interface SubscribeHandler {
        @nativeInvoke
        fun invoke(data: Any, message: String, subscriber_context: Any)
    }
    interface SubscribeOptions {
        var priority: Number? get() = noImpl
        var async: Boolean? get() = noImpl
        var persist: Boolean? get() = noImpl
    }
    interface PublishOptions {
        var cancelable: Boolean? get() = noImpl
        var persist: Boolean? get() = noImpl
        var async: Boolean? get() = noImpl
    }
    interface ArbiterStatic {
        var version: String
        var updated_on: String
        fun create(): ArbiterStatic
        fun publish(msg: String, data: Any? = null, options: PublishOptions? = null): Boolean
        fun subscribe(msg: String, func: SubscribeHandler): Any
        fun subscribe(msg: String, options: SubscribeOptions, func: SubscribeHandler): Any
        fun subscribe(msg: String, options: SubscribeOptions, context: Any, func: SubscribeHandler): Any
        fun subscribe(msg: Array<String>, func: SubscribeHandler): Any
        fun subscribe(msg: Array<String>, options: SubscribeOptions, func: SubscribeHandler): Any
        fun subscribe(msg: Array<String>, options: SubscribeOptions, context: Any, func: SubscribeHandler): Any
        fun unsubscribe(subscription_id: Number): Boolean
        fun resubscribe(subscription_id: Number): Boolean
    }
}
@native
var Arbiter: ArbiterDef.ArbiterStatic = noImpl
