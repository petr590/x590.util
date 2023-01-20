package x590.util.function;

@FunctionalInterface
public interface ObjLongFunction<T, R> {
	R apply(T t, long value);
}