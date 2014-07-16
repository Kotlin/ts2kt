// OUT:
// WRONG
package angular-translate

module
public object ng.translate  {
    public trait ITranslationTable {
        public fun get(key: String): String
        public fun set(key: String, value: String): Unit
    }
    public trait ILanguageKeyAlias {
        public fun get(key: String): String
        public fun set(key: String, value: String): Unit
    }
    public trait IStorage {
        public fun get(name: String): String
        public fun set(name: String, value: String): Unit
    }
    public trait ISTaticFilesLoaderOptions {
        public var prefix: String
        public var suffix: String
        public var key: String?
    }
    public trait ITranslateService {
        public fun invoke(key: String, vararg params: String): ng.IPromise<String>
        public fun cloakClassName(): String
        public fun fallbackLanguage(langKey: String? = null): String
        public fun fallbackLanguage(langKey: Array<String>? = null): String
        public fun instant(translationId: String, interpolateParams: Any? = null, interpolationId: String? = null): String
        public fun instant(translationId: Array<String>, interpolateParams: Any? = null, interpolationId: String? = null): String
        public fun isPostCompilingEnabled(): Boolean
        public fun preferredLanguage(): String
        public fun proposedLanguage(): String
        public fun refresh(langKey: String? = null): ng.IPromise<Unit>
        public fun storage(): IStorage
        public fun storageKey(): String
        public fun use(): String
        public fun use(key: String): ng.IPromise<String>
        public fun useFallbackLanguage(langKey: String? = null): Unit
    }
    public trait ITranslateProvider : ng.IServiceProvider  {
        public fun translations(): ITranslationTable
        public fun translations(key: String, translationTable: ITranslationTable): ITranslateProvider
        public fun cloakClassName(): String
        public fun cloakClassName(name: String): ITranslateProvider
        public fun addInterpolation(factory: Any): ITranslateProvider
        public fun useMessageFormatInterpolation(): ITranslateProvider
        public fun useInterpolation(factory: String): ITranslateProvider
        public fun useSanitizeValueStrategy(value: String): ITranslateProvider
        public fun preferredLanguage(): String
        public fun preferredLanguage(language: String): ITranslateProvider
        public fun translationNotFoundIndicator(indicator: String): ITranslateProvider
        public fun translationNotFoundIndicatorLeft(): String
        public fun translationNotFoundIndicatorLeft(indicator: String): ITranslateProvider
        public fun translationNotFoundIndicatorRight(): String
        public fun translationNotFoundIndicatorRight(indicator: String): ITranslateProvider
        public fun fallbackLanguage(): String
        public fun fallbackLanguage(language: String): ITranslateProvider
        public fun fallbackLanguage(languages: Array<String>): ITranslateProvider
        public fun use(): String
        public fun use(key: String): ITranslateProvider
        public fun storageKey(): String
        public fun storageKey(key: String): Unit
        public fun useUrlLoader(url: String): ITranslateProvider
        public fun useStaticFilesLoader(options: ISTaticFilesLoaderOptions): ITranslateProvider
        public fun useLoader(loaderFactory: String, options: Any): ITranslateProvider
        public fun useLocalStorage(): ITranslateProvider
        public fun useCookieStorage(): ITranslateProvider
        public fun useStorage(storageFactory: Any): ITranslateProvider
        public fun storagePrefix(): String
        public fun storagePrefix(prefix: String): ITranslateProvider
        public fun useMissingTranslationHandlerLog(): ITranslateProvider
        public fun useMissingTranslationHandler(factory: String): ITranslateProvider
        public fun usePostCompiling(value: Boolean): ITranslateProvider
        public fun determinePreferredLanguage(fn: (() -> Unit)? = null): ITranslateProvider
        public fun registerAvailableLanguageKeys(): Array<String>
        public fun registerAvailableLanguageKeys(languageKeys: Array<String>, aliases: Array<ILanguageKeyAlias>? = null): ITranslateProvider
    }
}
