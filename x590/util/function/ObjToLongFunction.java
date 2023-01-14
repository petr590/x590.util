package x590.util.function;

@FunctionalInterface
public interface ObjToLongFunction<T> {
	long apply(T t);
}