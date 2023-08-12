package x590.util.function;

@FunctionalInterface
public interface ObjDoubleFunction<T, R> {
	R apply(T value1, double value2);
}