package Arbiter

@module
object ArbiterDef {
    interface SubscribeHandler {
        @nativeInvoke
        fun invoke(data: Any, message: String, subscriber_context: Any)
    }
    interface SubscribeOptions {
        var priority: Number? = noImpl
        var async: Boolean? = noImpl
        var persist: Boolean? = noImpl
    }
    interface PublishOptions {
        var cancelable: Boolean? = noImpl
        var persist: Boolean? = noImpl
        var async: Boolean? = noImpl
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
