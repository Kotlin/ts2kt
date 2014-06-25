package accounting

native
public trait IAccountingCurrencyFormat {
    public var pos: String
    public var neg: String?
    public var zero: String?
}
native
public trait IAccountingCurrencySettings<TFormat> {
    public var symbol: String?
    public var format: TFormat?
    public var decimal: String?
    public var thousand: String?
    public var precision: Number?
}
native
public trait IAccountingNumberSettings {
    public var precision: Number?
    public var thousand: String?
    public var decimal: String?
}
native
public trait IAccountingSettings {
    public var currency: IAccountingCurrencySettings<Any>
    public var number: IAccountingNumberSettings
}
native
public trait IAccountingStatic {
    public fun formatMoney(number: Number, symbol: String? = null, precision: Number? = null, thousand: String? = null, decimal: String? = null, format: String? = null): String
    public fun formatMoney(number: Number, options: IAccountingCurrencySettings<String>): String
    public fun formatMoney(number: Number, options: IAccountingCurrencySettings<IAccountingCurrencyFormat>): String
    public fun formatMoney(numbers: Array<Number>, symbol: String? = null, precision: Number? = null, thousand: String? = null, decimal: String? = null, format: String? = null): Array<String>
    public fun formatMoney(numbers: Array<Number>, options: IAccountingCurrencySettings<String>): Array<String>
    public fun formatMoney(numbers: Array<Number>, options: IAccountingCurrencySettings<IAccountingCurrencyFormat>): Array<String>
    public fun formatMoney(numbers: Array<Any>, symbol: String? = null, precision: Number? = null, thousand: String? = null, decimal: String? = null, format: String? = null): Array<Any>
    public fun formatMoney(numbers: Array<Any>, options: IAccountingCurrencySettings<String>): Array<Any>
    public fun formatMoney(numbers: Array<Any>, options: IAccountingCurrencySettings<IAccountingCurrencyFormat>): Array<Any>
    public fun formatColumn(numbers: Array<Number>, symbol: String? = null, precision: Number? = null, thousand: String? = null, decimal: String? = null, format: String? = null): Array<String>
    public fun formatColumn(numbers: Array<Number>, options: IAccountingCurrencySettings<String>): Array<String>
    public fun formatColumn(numbers: Array<Number>, options: IAccountingCurrencySettings<IAccountingCurrencyFormat>): Array<String>
    public fun formatColumn(numbers: Array<Array<Number>>, symbol: String? = null, precision: Number? = null, thousand: String? = null, decimal: String? = null, format: String? = null): Array<Array<String>>
    public fun formatColumn(numbers: Array<Array<Number>>, options: IAccountingCurrencySettings<String>): Array<Array<String>>
    public fun formatColumn(numbers: Array<Array<Number>>, options: IAccountingCurrencySettings<IAccountingCurrencyFormat>): Array<Array<String>>
    public fun formatNumber(number: Number, precision: Number? = null, thousand: String? = null, decimal: String? = null): String
    public fun formatNumber(number: Number, options: IAccountingNumberSettings): String
    public fun formatNumber(number: Array<Number>, precision: Number? = null, thousand: String? = null, decimal: String? = null): Array<String>
    public fun formatNumber(number: Array<Number>, options: IAccountingNumberSettings): Array<String>
    public fun formatNumber(number: Array<Any>, precision: Number? = null, thousand: String? = null, decimal: String? = null): Array<Any>
    public fun formatNumber(number: Array<Any>, options: IAccountingNumberSettings): Array<Any>
    public fun toFixed(number: Number, precision: Number? = null): String
    public fun unformat(string: String, decimal: String? = null): Number
    public var settings: IAccountingSettings
}
native
module("accounting")
public var accounting: IAccountingStatic = noImpl
