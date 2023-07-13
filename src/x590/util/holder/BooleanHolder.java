package x590.util.holder;

/**
 * Содержит значение типа boolean. Используется, например, когда нужно
 * изменять значение локальной переменной из лямбды
 */
public class BooleanHolder {
	
	private boolean value;
	
	public BooleanHolder() {}
	
	public BooleanHolder(boolean value) {
		this.value = value;
	}
	
	public boolean get() {
		return value;
	}
	
	public boolean is() {
		return value;
	}
	
	public boolean isTrue() {
		return value;
	}
	
	public boolean isFalse() {
		return !value;
	}
	
	public boolean set(boolean value) {
		return this.value = value;
	}
	
	public boolean and(boolean value) {
		return this.value &= value;
	}
	
	public boolean or(boolean value) {
		return this.value |= value;
	}
	
	public boolean xor(boolean value) {
		return this.value ^= value;
	}
	
	public boolean not() {
		return value = !value;
	}
	
	
	public boolean equals(boolean value) {
		return this.value == value;
	}
	
	public boolean notEquals(boolean value) {
		return this.value != value;
	}
	
	
	@Override
	public boolean equals(Object other) {
		return this == other || other instanceof BooleanHolder holder && this.equals(holder);
	}
	
	public boolean equals(BooleanHolder other) {
		return value == other.value;
	}
	
	@Override
	public int hashCode() {
		return Boolean.hashCode(value);
	}
	
	@Override
	public String toString() {
		return "BooleanHolder { value = " + value + " }";
	}
}
