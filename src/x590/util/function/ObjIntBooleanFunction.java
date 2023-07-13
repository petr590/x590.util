package x590.util.function;

@FunctionalInterface
public interface ObjIntBooleanFunction<T, R> {
	R apply(T t, int i, boolean b);
}
