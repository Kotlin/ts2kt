// WRONG
// TODO fix package
package angular-agility

module
public object aa {
    public trait ILabelStrategies {
        public fun get(strategyName: String): (element: ng.IAugmentedJQueryStatic, labelText: String, isRequired: Boolean) -> Unit
        public fun set(strategyName: String, value: (element: ng.IAugmentedJQueryStatic, labelText: String, isRequired: Boolean) -> Unit): Unit
    }
    public trait IFieldGroupStrategies {
        public fun get(strategyName: String): (element: ng.IAugmentedJQueryStatic) -> Unit
        public fun set(strategyName: String, value: (element: ng.IAugmentedJQueryStatic) -> Unit): Unit
    }
    public trait IValMsgPlacementStrategies {
        public fun get(strategyName: String): (formFieldElement: ng.IAugmentedJQueryStatic, formName: String, formFieldName: String) -> Unit
        public fun set(strategyName: String, value: (formFieldElement: ng.IAugmentedJQueryStatic, formName: String, formFieldName: String) -> Unit): Unit
    }
    public trait IValidIconStrategy {
        public var validIcon: String
        public var invalidIcon: String
        public fun getContainer(element: ng.IAugmentedJQueryStatic): Unit
    }
    public trait ISpinnerClickStrategies {
        public fun get(strategyName: String): (element: ng.IAugmentedJQueryStatic) -> Unit
        public fun set(strategyName: String, value: (element: ng.IAugmentedJQueryStatic) -> Unit): Unit
    }
    public trait IOnNavigateAwayStrategies {
        public fun get(strategyName: String): (rootFormScope: ng.IScope, rootForm: ng.IAugmentedJQueryStatic, `$injector`: ng.auto.IInjectorService) -> Unit
        public fun set(strategyName: String, value: (rootFormScope: ng.IScope, rootForm: ng.IAugmentedJQueryStatic, `$injector`: ng.auto.IInjectorService) -> Unit): Unit
    }
    public trait IValidationMessages {
        public fun get(validationKey: String): String
        public fun set(validationKey: String, value: String): Unit
    }
    public trait IGlobalSettings {
        public fun get(settingName: String): Any
        public fun set(settingName: String, value: Any): Unit
    }
    public trait IFormExtensionsProvider : ng.auto.IProvider {
        public var defaultLabelStrategy: String
        public var defaultFieldGroupStrategy: String
        public var defaultValMsgPlacementStrategy: String
        public var validIconStrategy: IValidIconStrategy
        public var defaultSpinnerClickStrategy: String
        public var defaultNotifyTarget: String
        public var defaultOnNavigateAwayStrategy: String
        public var validationMessages: IValidationMessages
        public var valMsgForTemplate: String
        public var confirmResetStrategy: () -> Boolean
        public var globalSettings: IGlobalSettings
        public var labelStrategies: ILabelStrategies
        public var fieldGroupStrategies: IFieldGroupStrategies
        public var valMsgPlacementStrategies: IValMsgPlacementStrategies
        public var spinnerClickStrategies: ISpinnerClickStrategies
        public var onNavigateAwayStrategies: IOnNavigateAwayStrategies
    }
    public trait INotifyPredicate {
        public fun invoke(message: String, options: Any, notifier: Any): Any
    }
    public trait INotifyDefaults {
        public var success: INotifyPredicate
        public var info: INotifyPredicate
        public var warning: INotifyPredicate
        public var danger: INotifyPredicate
        public var error: INotifyPredicate
    }
    public trait INotifyConfig {
        public var name: String
        public var template: String?
        public var templateName: String?
        public var options: INotifyOptions
        public var namedDefaults: INotifyDefaults
    }
    public trait INotifyOptions {
        public var cssClasses: String?
        public var messageType: String
        public var allowHtml: Boolean
        public var message: String
    }
    public trait INotifyConfigProvider : ng.auto.IProvider {
        public var notifyConfigs: Any
        public var defaultTargetContainerName: String
        public var defaultNotifyConfig: String
        public fun addOrUpdateNotifyConfig(name: String, opts: INotifyConfig): Unit
        public fun optionsTransformer(options: INotifyOptions, `$sce`: ng.ISCEService): Unit
    }
    public trait IExternalFormValidationConfig {
        public var validations: Any
        public var ignore: Any?
        public var globals: Any?
        public var resolve: Any?
        public var resolveFn: ((modelValue: String) -> String)?
    }
}
