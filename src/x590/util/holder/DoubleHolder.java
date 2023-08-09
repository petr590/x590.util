package x590.util.holder;

import java.util.function.DoubleSupplier;

/**
 * Содержит значение типа double. Используется, например, когда нужно
 * изменять значение локальной переменной из лямбды
 */
public class DoubleHolder implements DoubleSupplier {
	
	private double value;
	
	public DoubleHolder() {}
	
	public DoubleHolder(double value) {
		this.value = value;
	}
	
	public double get() {
		return value;
	}

	@Override
	public double getAsDouble() {
		return value;
	}
	
	public double set(double value) {
		return this.value = value;
	}
	
	public double neg() {
		return value = -value;
	}
	
	public double add(double value) {
		return this.value += value;
	}
	
	public double sub(double value) {
		return this.value -= value;
	}
	
	public double mul(double value) {
		return this.value *= value;
	}
	
	public double div(double value) {
		return this.value /= value;
	}
	
	public double rem(double value) {
		return this.value %= value;
	}
	
	public double preInc() {
		return ++value;
	}
	
	public double preDec() {
		return --value;
	}
	
	public double postInc() {
		return value++;
	}
	
	public double postDec() {
		return value--;
	}
	
	public double postInc(double value) {
		double prevValue = this.value;
		this.value = prevValue + value;
		return prevValue;
	}
	
	public double postDec(double value) {
		double prevValue = this.value;
		this.value = prevValue - value;
		return prevValue;
	}
	
	
	public boolean equals(double value) {
		return this.value == value;
	}
	
	public boolean notEquals(double value) {
		return this.value != value;
	}
	
	public boolean greater(double value) {
		return this.value > value;
	}
	
	public boolean greaterOrEquals(double value) {
		return this.value >= value;
	}
	
	public boolean less(double value) {
		return this.value < value;
	}
	
	public boolean lessOrEquals(double value) {
		return this.value <= value;
	}
	
	
	public boolean isNaN() {
		return Double.isNaN(value);
	}
	
	public boolean isFinite() {
		return Double.isFinite(value);
	}
	
	public boolean isInfinite() {
		return Double.isInfinite(value);
	}
	
	
	@Override
	public boolean equals(Object other) {
		return this == other || other instanceof DoubleHolder holder && this.equals(holder);
	}
	
	public boolean equals(DoubleHolder other) {
		return Double.compare(value, other.value) == 0;
	}
	
	@Override
	public int hashCode() {
		return Double.hashCode(value);
	}
	
	@Override
	public String toString() {
		return "DoubleHolder { value = " + value + " }";
	}
}