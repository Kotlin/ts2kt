// OUT:
// WRONG
package big-integer

native
public trait `T$0` {
    public var quotient: BigInteger
    public var remainder: BigInteger
}
native
public trait BigInteger {
    public fun abs(): BigInteger
    public fun add(number: Number): BigInteger
    public fun add(number: BigInteger): BigInteger
    public fun add(number: String): BigInteger
    public fun plus(number: Number): BigInteger
    public fun plus(number: BigInteger): BigInteger
    public fun plus(number: String): BigInteger
    public fun minus(number: Number): BigInteger
    public fun minus(number: BigInteger): BigInteger
    public fun minus(number: String): BigInteger
    public fun subtract(number: Number): BigInteger
    public fun subtract(number: BigInteger): BigInteger
    public fun subtract(number: String): BigInteger
    public fun multiply(number: Number): BigInteger
    public fun multiply(number: BigInteger): BigInteger
    public fun multiply(number: String): BigInteger
    public fun times(number: Number): BigInteger
    public fun times(number: BigInteger): BigInteger
    public fun times(number: String): BigInteger
    public fun divide(number: Number): BigInteger
    public fun divide(number: BigInteger): BigInteger
    public fun divide(number: String): BigInteger
    public fun over(number: Number): BigInteger
    public fun over(number: BigInteger): BigInteger
    public fun over(number: String): BigInteger
    public fun pow(number: Number): BigInteger
    public fun pow(number: BigInteger): BigInteger
    public fun pow(number: String): BigInteger
    public fun next(): BigInteger
    public fun prev(): BigInteger
    public fun mod(number: Number): BigInteger
    public fun mod(number: BigInteger): BigInteger
    public fun mod(number: String): BigInteger
    public fun divmod(number: Number): `T$0`
    public fun divmod(number: BigInteger): `T$0`
    public fun divmod(number: String): `T$0`
    public fun greater(number: Number): Boolean
    public fun greater(number: BigInteger): Boolean
    public fun greater(number: String): Boolean
    public fun greaterOrEquals(number: Number): Boolean
    public fun greaterOrEquals(number: BigInteger): Boolean
    public fun greaterOrEquals(number: String): Boolean
    public fun lesser(number: Number): Boolean
    public fun lesser(number: BigInteger): Boolean
    public fun lesser(number: String): Boolean
    public fun lesserOrEquals(number: Number): Boolean
    public fun lesserOrEquals(number: BigInteger): Boolean
    public fun lesserOrEquals(number: String): Boolean
    public fun isEven(): Boolean
    public fun isOdd(): Boolean
    public fun isPositive(): Boolean
    public fun isNegative(): Boolean
    public fun compare(number: Number): BigInteger
    public fun compare(number: BigInteger): BigInteger
    public fun compare(number: String): BigInteger
    public fun compareAbs(number: Number): BigInteger
    public fun compareAbs(number: BigInteger): BigInteger
    public fun compareAbs(number: String): BigInteger
    public fun equals(number: Number): Boolean
    public fun equals(number: BigInteger): Boolean
    public fun equals(number: String): Boolean
    public fun notEquals(number: Number): Boolean
    public fun notEquals(number: BigInteger): Boolean
    public fun notEquals(number: String): Boolean
    public fun toJSNumber(): Number
    public fun toString(): String
    public fun valueOf(): Number
}
native
public trait BigIntegerStatic {
    public var one: BigInteger
    public var zero: BigInteger
    public var minusOne: BigInteger
    public fun invoke(): BigInteger
    public fun invoke(number: Number): BigInteger
    public fun invoke(string: String): BigInteger
    public fun invoke(bigInt: BigInteger): BigInteger
}
native
module("big-integer")
public var bigInt: BigIntegerStatic = noImpl
module
// WRONG name
public object big-integer {

}
