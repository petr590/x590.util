package x590.util;

/**
 * Содержит значение типа int. Используется, например, когда нужно
 * изменять значение локальной переменной из лямбды
 */
public class IntHolder {
	
	private int value;
	
	public IntHolder(int value) {
		this.value = value;
	}
	
	public int get() {
		return value;
	}
	
	public int set(int value) {
		return this.value = value;
	}
	
	public int neg() {
		return value = -value;
	}
	
	public int add(int value) {
		return this.value += value;
	}
	
	public int sub(int value) {
		return this.value -= value;
	}
	
	public int mul(int value) {
		return this.value *= value;
	}
	
	public int div(int value) {
		return this.value /= value;
	}
	
	public int rem(int value) {
		return this.value %= value;
	}
	
	public int preInc() {
		return ++value;
	}
	
	public int preDec() {
		return --value;
	}
	
	public int postInc() {
		return value++;
	}
	
	public int postDec() {
		return value--;
	}
	
	public int postInc(int value) {
		int prevValue = this.value;
		this.value = prevValue + value;
		return prevValue;
	}
	
	public int postDec(int value) {
		int prevValue = this.value;
		this.value = prevValue - value;
		return prevValue;
	}
	
	public int and(int value) {
		return this.value &= value;
	}
	
	public int or(int value) {
		return this.value |= value;
	}
	
	public int xor(int value) {
		return this.value ^= value;
	}
	
	public int not() {
		return value = ~value;
	}
	
	
	public boolean equals(int value) {
		return this.value == value;
	}
	
	public boolean notEquals(int value) {
		return this.value != value;
	}
	
	public boolean greater(int value) {
		return this.value > value;
	}
	
	public boolean greaterOrEquals(int value) {
		return this.value >= value;
	}
	
	public boolean less(int value) {
		return this.value < value;
	}
	
	public boolean lessOrEquals(int value) {
		return this.value <= value;
	}
	
	
	@Override
	public boolean equals(Object other) {
		return this == other || other instanceof IntHolder holder && this.equals(holder);
	}
	
	public boolean equals(IntHolder other) {
		return value == other.value;
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(value);
	}
	
	@Override
	public String toString() {
		return "IntHolder { value = " + value + " }";
	}
}