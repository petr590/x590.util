package x590.util;

/**
 * Содержит значение типа T. Используется, например, когда нужно
 * изменять значение локальной переменной из лямбды
 */
public class ObjectHolder<T> {
	
	private static final ObjectHolder<?> VOID_HOLDER = new ObjectHolder<>();
	
	private T value;
	
	public ObjectHolder() {}
	
	public ObjectHolder(T value) {
		this.value = value;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> ObjectHolder<T> voidHolder() {
		return (ObjectHolder<T>)VOID_HOLDER;
	}
	
	public T get() {
		return value;
	}
	
	public T set(T value) {
		return this.value = value;
	}
	
	
	public boolean valueEquals(T value) {
		return this.value == value;
	}
	
	public boolean valueNotEquals(T value) {
		return this.value != value;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		return this == other || other instanceof ObjectHolder && this.equals((ObjectHolder<T>)other);
	}
	
	public boolean equals(ObjectHolder<T> other) {
		return value.equals(other.value);
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	@Override
	public String toString() {
		return "ObjectHolder { value = " + value + " }";
	}
}