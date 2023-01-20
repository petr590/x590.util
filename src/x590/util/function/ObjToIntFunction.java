package x590.util.function;

@FunctionalInterface
public interface ObjToIntFunction<T> {
	int apply(T t);
}