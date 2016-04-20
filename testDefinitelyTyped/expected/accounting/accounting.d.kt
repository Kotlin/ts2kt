package accounting

@native
interface IAccountingCurrencyFormat {
    var pos: String
    var neg: String? = noImpl
    var zero: String? = noImpl
}
@native
interface IAccountingCurrencySettings<TFormat> {
    var symbol: String? = noImpl
    var format: TFormat? = noImpl
    var decimal: String? = noImpl
    var thousand: String? = noImpl
    var precision: Number? = noImpl
}
@native
interface IAccountingNumberSettings {
    var precision: Number? = noImpl
    var thousand: String? = noImpl
    var decimal: String? = noImpl
}
@native
interface IAccountingSettings {
    var currency: IAccountingCurrencySettings<Any>
    var number: IAccountingNumberSettings
}
@native
interface IAccountingStatic {
    fun formatMoney(number: Number, symbol: String? = null, precision: Number? = null, thousand: String? = null, decimal: String? = null, format: String? = null): String
    fun formatMoney(number: Number, options: IAccountingCurrencySettings<String>): String
    fun formatMoney(number: Number, options: IAccountingCurrencySettings<IAccountingCurrencyFormat>): String
    fun formatMoney(numbers: Array<Number>, symbol: String? = null, precision: Number? = null, thousand: String? = null, decimal: String? = null, format: String? = null): Array<String>
    fun formatMoney(numbers: Array<Number>, options: IAccountingCurrencySettings<String>): Array<String>
    fun formatMoney(numbers: Array<Number>, options: IAccountingCurrencySettings<IAccountingCurrencyFormat>): Array<String>
    fun formatMoney(numbers: Array<Any>, symbol: String? = null, precision: Number? = null, thousand: String? = null, decimal: String? = null, format: String? = null): Array<Any>
    fun formatMoney(numbers: Array<Any>, options: IAccountingCurrencySettings<String>): Array<Any>
    fun formatMoney(numbers: Array<Any>, options: IAccountingCurrencySettings<IAccountingCurrencyFormat>): Array<Any>
    fun formatColumn(numbers: Array<Number>, symbol: String? = null, precision: Number? = null, thousand: String? = null, decimal: String? = null, format: String? = null): Array<String>
    fun formatColumn(numbers: Array<Number>, options: IAccountingCurrencySettings<String>): Array<String>
    fun formatColumn(numbers: Array<Number>, options: IAccountingCurrencySettings<IAccountingCurrencyFormat>): Array<String>
    fun formatColumn(numbers: Array<Array<Number>>, symbol: String? = null, precision: Number? = null, thousand: String? = null, decimal: String? = null, format: String? = null): Array<Array<String>>
    fun formatColumn(numbers: Array<Array<Number>>, options: IAccountingCurrencySettings<String>): Array<Array<String>>
    fun formatColumn(numbers: Array<Array<Number>>, options: IAccountingCurrencySettings<IAccountingCurrencyFormat>): Array<Array<String>>
    fun formatNumber(number: Number, precision: Number? = null, thousand: String? = null, decimal: String? = null): String
    fun formatNumber(number: Number, options: IAccountingNumberSettings): String
    fun formatNumber(number: Array<Number>, precision: Number? = null, thousand: String? = null, decimal: String? = null): Array<String>
    fun formatNumber(number: Array<Number>, options: IAccountingNumberSettings): Array<String>
    fun formatNumber(number: Array<Any>, precision: Number? = null, thousand: String? = null, decimal: String? = null): Array<Any>
    fun formatNumber(number: Array<Any>, options: IAccountingNumberSettings): Array<Any>
    fun toFixed(number: Number, precision: Number? = null): String
    fun unformat(string: String, decimal: String? = null): Number
    var settings: IAccountingSettings
}
@native
@module("accounting")
var accounting: IAccountingStatic = noImpl
