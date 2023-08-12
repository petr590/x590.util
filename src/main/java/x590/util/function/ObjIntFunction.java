package x590.util.function;

@FunctionalInterface
public interface ObjIntFunction<T, R> {
	R apply(T value1, int value2);
}