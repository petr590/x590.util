package x590.util.function;

@FunctionalInterface
public interface ObjCharFunction<T, R> {
	R apply(T value1, char value2);
}