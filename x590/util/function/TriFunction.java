package x590.util.function;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
	R apply(T t, U y, V v);
}