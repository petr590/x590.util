package x590.util;

/**
 * Содержит значение типа long. Используется, например, когда нужно
 * изменять значение локальной переменной из лямбды
 */
public class LongHolder {
	
	private long value;
	
	public LongHolder() {}
	
	public LongHolder(long value) {
		this.value = value;
	}
	
	public long get() {
		return value;
	}
	
	public long set(long value) {
		return this.value = value;
	}
	
	public long neg() {
		return value = -value;
	}
	
	public long add(long value) {
		return this.value += value;
	}
	
	public long sub(long value) {
		return this.value -= value;
	}
	
	public long mul(long value) {
		return this.value *= value;
	}
	
	public long div(long value) {
		return this.value /= value;
	}
	
	public long rem(long value) {
		return this.value %= value;
	}
	
	public long preInc() {
		return ++value;
	}
	
	public long preDec() {
		return --value;
	}
	
	public long postInc() {
		return value++;
	}
	
	public long postDec() {
		return value--;
	}
	
	public long postInc(long value) {
		long prevValue = this.value;
		this.value = prevValue + value;
		return prevValue;
	}
	
	public long postDec(long value) {
		long prevValue = this.value;
		this.value = prevValue - value;
		return prevValue;
	}
	
	public long and(long value) {
		return this.value &= value;
	}
	
	public long or(long value) {
		return this.value |= value;
	}
	
	public long xor(long value) {
		return this.value ^= value;
	}
	
	public long not() {
		return value = ~value;
	}
	
	
	public boolean equals(long value) {
		return this.value == value;
	}
	
	public boolean notEquals(long value) {
		return this.value != value;
	}
	
	public boolean greater(long value) {
		return this.value > value;
	}
	
	public boolean greaterOrEquals(long value) {
		return this.value >= value;
	}
	
	public boolean less(long value) {
		return this.value < value;
	}
	
	public boolean lessOrEquals(long value) {
		return this.value <= value;
	}
	
	
	@Override
	public boolean equals(Object other) {
		return this == other || other instanceof LongHolder holder && this.equals(holder);
	}
	
	public boolean equals(LongHolder other) {
		return value == other.value;
	}
	
	@Override
	public int hashCode() {
		return Long.hashCode(value);
	}
	
	@Override
	public String toString() {
		return "LongHolder { value = " + value + " }";
	}
}