package x590.util.function;

@FunctionalInterface
public interface ObjBooleanFunction<T, R> {
	R apply(T value1, boolean value2);
}