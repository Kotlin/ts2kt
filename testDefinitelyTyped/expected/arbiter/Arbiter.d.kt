[file: nativePackageRoot]
package Arbiter

native
public var Arbiter: ArbiterDef.ArbiterStatic = noImpl

/* ============= */
[file: nativePackage]
package Arbiter.ArbiterDef

native
public trait SubscribeHandler {
    nativeInvoke
    public fun invoke(data: Any, message: String, subscriber_context: Any)
}
native
public trait SubscribeOptions {
    public var priority: Number? = noImpl
    public var async: Boolean? = noImpl
    public var persist: Boolean? = noImpl
}
native
public trait PublishOptions {
    public var cancelable: Boolean? = noImpl
    public var persist: Boolean? = noImpl
    public var async: Boolean? = noImpl
}
native
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
