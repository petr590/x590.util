package x590.util.function;

import java.util.function.Function;

public final class Functions {
	
	private Functions() {}
	
	@SuppressWarnings("unchecked")
	public static <R, T> R uncheckedCast(T t) {
		return (R)t;
	}
	
	public static <R, T extends R> R wideCast(T t) {
		return t;
	}
	
	
	public static <R, T> Function<T, R> uncheckedCasting() {
		return Functions::uncheckedCast;
	}
	
	public static <R, T extends R> Function<T, R> wideCasting() {
		return Functions::wideCast;
	}
}
