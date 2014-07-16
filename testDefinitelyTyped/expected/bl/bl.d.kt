package bl

// WRONG import
module("bl")
public class BufferList : stream.Duplex  {
    public fun new(callback: ((err: Error, buffer: Buffer) -> Unit)? = null): Unit = noImpl
    public fun append(buffer: Buffer): Unit = noImpl
    public fun get(index: Number): Number = noImpl
    public fun slice(start: Number? = null, end: Number? = null): Buffer = noImpl
    public fun copy(dest: Buffer, destStart: Number? = null, srcStart: Number? = null, srcEnd: Number? = null): Unit = noImpl
    public fun duplicate(): BufferList = noImpl
    public fun consume(bytes: Number? = null): Unit = noImpl
    public fun toString(encoding: String? = null, start: Number? = null, end: Number? = null): String = noImpl
    public var length: Number = noImpl
    public fun readDoubleBE(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readDoubleLE(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readFloatBE(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readFloatLE(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readInt32BE(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readInt32LE(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readUInt32BE(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readUInt32LE(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readInt16BE(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readInt16LE(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readUInt16BE(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readUInt16LE(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readInt8(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
    public fun readUInt8(offset: Number, noAssert: Boolean? = null): Buffer = noImpl
}
