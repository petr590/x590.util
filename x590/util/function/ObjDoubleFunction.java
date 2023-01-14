package x590.util.function;

@FunctionalInterface
public interface ObjDoubleFunction<T, R> {
	R apply(T t, double value);
}