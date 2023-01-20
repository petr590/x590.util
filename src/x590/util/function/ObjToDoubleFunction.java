package x590.util.function;

@FunctionalInterface
public interface ObjToDoubleFunction<T> {
	double apply(T t);
}