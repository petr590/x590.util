package x590.util.function;

@FunctionalInterface
public interface ObjLongFunction<T, R> {
	R apply(T value1, long value2);
}