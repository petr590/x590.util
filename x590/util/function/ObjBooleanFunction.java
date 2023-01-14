package x590.util.function;

@FunctionalInterface
public interface ObjBooleanFunction<T, R> {
	R apply(T t, boolean value);
}