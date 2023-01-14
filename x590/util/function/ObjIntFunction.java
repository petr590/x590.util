package x590.util.function;

@FunctionalInterface
public interface ObjIntFunction<T, R> {
	R apply(T t, int value);
}