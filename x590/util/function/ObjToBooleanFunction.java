package x590.util.function;

@FunctionalInterface
public interface ObjToBooleanFunction<T> {
	boolean apply(T t);
}